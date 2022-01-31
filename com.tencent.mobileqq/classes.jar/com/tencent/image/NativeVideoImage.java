package com.tencent.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.widget.Toast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.AVAudioParam;
import com.tencent.video.decode.AVDecodeFactory;
import com.tencent.video.decode.AVDecodeOption;
import com.tencent.video.decode.AVVideoParam;
import com.tencent.video.decode.AVideoException;
import com.tencent.video.decode.AbstractAVDecode;
import com.tencent.video.decode.ShortVideoSoLoad;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NativeVideoImage
  extends AbstractVideoImage
{
  static final int DEFAULT_AUDIO_FORMAT = 65281;
  public static final Bitmap.Config DEFAULT_CONFIG;
  public static String TAG = "URLDrawable_" + NativeVideoImage.class.getSimpleName() + "_";
  static final String TAG_AUDIO = TAG + "_Audio";
  private static int TIME_BASE;
  static Handler sDecodeHander;
  static HandlerThread sDecodeThread;
  static boolean sLibLoaded = false;
  static Handler sReleaseHandler;
  protected static Handler sUIHandler;
  static boolean sVideoEngineAvaliable = true;
  static HandlerThread sWorkThread = new HandlerThread("Video-Release-Task");
  private int ID = -1;
  public boolean debug = true;
  private long drawTime = -1L;
  protected volatile AbstractAVDecode mAVDecode;
  protected DoAccumulativeRunnable mAccumulativeRunnable;
  private int mAudioFrameDuration = -1;
  private Object mAudioLock = new Object();
  private volatile boolean mAudioThreadFinish = true;
  AudioTrack mAudioTrack;
  private Bitmap mCompatibleBitmap = null;
  private AtomicInteger mCount = new AtomicInteger(0);
  protected Bitmap mCurFrameBitmap;
  protected Bitmap mCurFrameBitmapBuffer;
  protected Bitmap.Config mCurrentConfig = DEFAULT_CONFIG;
  private DataReport mDataReport;
  protected volatile boolean mDecodeNextFrameEnd = true;
  public float mDefaultRoundCorner = 0.0F;
  private boolean mEnableAntiAlias = false;
  private boolean mEnableFilter = false;
  protected Bitmap mFirstFrameBitmap;
  private Object mLock = new Object();
  AVDecodeOption mOption;
  volatile boolean mPlayAudioFrame = false;
  volatile boolean mPlayAudioOnceFinished = true;
  PlayAudioThread mPlayAudioThread;
  int mPlayRepeatCount = 0;
  int mReqHeight = 0;
  int mReqWidth = 0;
  public boolean mRequireAudioFocus = true;
  boolean mResetFlag = false;
  private int mRotation;
  protected final String mSrcVideoFile;
  private float mTotalDeviation = 0.0F;
  private volatile boolean mVideoDecodeFinish = false;
  private int mVideoFrameDuration = -1;
  VideoDrawable.VideoDrawableParams mVideoParams;
  int mlastVideoFrameIndex = 0;
  private long refreshTime = -1L;
  int sImageIndex = 0;
  
  static
  {
    sWorkThread.start();
    sReleaseHandler = new Handler(sWorkThread.getLooper());
    sDecodeThread = new HandlerThread("Video-Decode-Thread");
    sDecodeThread.start();
    sDecodeHander = new Handler(sDecodeThread.getLooper());
    DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
    TIME_BASE = 12;
    sUIHandler = new Handler(Looper.getMainLooper());
  }
  
  public NativeVideoImage(File paramFile, boolean paramBoolean)
  {
    this(paramFile, paramBoolean, 0, 0, null);
  }
  
  public NativeVideoImage(File paramFile, boolean paramBoolean, int paramInt1, int paramInt2, Object paramObject)
  {
    this.mSrcVideoFile = paramFile.getAbsolutePath();
    this.ID = this.mSrcVideoFile.hashCode();
    if ((QLog.isColorLevel()) && (paramObject != null)) {
      QLog.d(TAG + this.ID, 2, "NativeVideoImage(): cacheFirstFrame=" + paramBoolean + ", maxWidth= " + paramInt1 + ", maxHeight= " + paramInt2 + ", videoParams= " + paramObject.toString());
    }
    if ((paramObject != null) && (VideoDrawable.VideoDrawableParams.class.isInstance(paramObject))) {
      this.mVideoParams = ((VideoDrawable.VideoDrawableParams)paramObject);
    }
    for (;;)
    {
      boolean bool = this.mVideoParams.mPlayAudioFrame;
      this.mPlayAudioFrame = bool;
      this.debug = bool;
      this.mDefaultRoundCorner = this.mVideoParams.mVideoRoundCorner;
      this.mEnableAntiAlias = this.mVideoParams.mEnableAntiAlias;
      this.mEnableFilter = this.mVideoParams.mEnableFilter;
      this.mOption = new AVDecodeOption();
      bool = loopEnable;
      if (this.mPlayAudioFrame) {
        bool = false;
      }
      this.mOption.cycle = bool;
      paramObject = this.mOption;
      if (!this.mPlayAudioFrame)
      {
        bool = true;
        paramObject.ignore_audio = bool;
        this.mOption.only_keyframe = false;
        this.mOption.filename = this.mSrcVideoFile;
        this.mOption.audioFormat = 65281;
        this.mOption.wantedFps = this.mVideoParams.mRequestedFPS;
        this.mOption.mDecodeType = this.mVideoParams.mDecodeType;
        this.mOption.mVfPath = this.mVideoParams.mVfPath;
        this.mOption.mAfPath = this.mVideoParams.mAfPath;
        this.mOption.mTotalTime = this.mVideoParams.mTotalTime;
        this.mOption.mVideoFrames = this.mVideoParams.mVideoFrames;
      }
      try
      {
        this.mAVDecode = AVDecodeFactory.newDecodeUncatched(this.mOption);
        if ((this.mAVDecode == null) && (QLog.isColorLevel())) {
          QLog.e(TAG + this.ID, 2, "NativeVideoImage()[mAVDecode == null]....");
        }
        this.mRotation = this.mAVDecode.videoParam.rotation;
        int n = this.mAVDecode.videoParam.fps_den;
        int i1 = this.mAVDecode.videoParam.fps_num;
        float f3 = i1 * 1.0F / n;
        if (this.mAVDecode.audioParam.errcode == -106)
        {
          this.mPlayAudioFrame = false;
          if (QLog.isColorLevel()) {
            QLog.e(TAG + this.ID, 2, "NativeVideoImage() => VIDEO_NO_MEDIA_DATA_ERR, 不存在音频数据, mSrcVideoFile=" + this.mSrcVideoFile);
          }
        }
        paramFile = getFrameSize(paramFile);
        int m = paramFile.width();
        int k = paramFile.height();
        int j = k;
        int i = m;
        if (paramInt1 > 0)
        {
          j = k;
          i = m;
          if (paramInt2 > 0)
          {
            f1 = paramInt1 / m;
            f2 = paramInt2 / k;
            if (f1 >= f2) {
              break label1132;
            }
            j = k;
            i = m;
            if (f1 < 1.0F)
            {
              i = (int)(m * f1);
              j = (int)(k * f1);
            }
          }
        }
        this.mReqWidth = i;
        this.mReqHeight = j;
        if (QLog.isColorLevel())
        {
          paramFile = new StringBuilder();
          paramFile.append("videoParams[ frame_count:").append(this.mAVDecode.videoParam.frame_count);
          paramFile.append("\n mSrcVideoFile:").append(this.mSrcVideoFile);
          paramFile.append("\n duration:").append(this.mAVDecode.videoParam.duration);
          paramFile.append("\n fps_den:").append(n);
          paramFile.append("\n fps_num:").append(i1);
          paramFile.append("\n fps:").append(f3);
          paramFile.append("\n mReqWidth:").append(this.mReqWidth);
          paramFile.append("\n mReqHeight:").append(this.mReqHeight);
          paramFile.append("\n mRotation:").append(this.mRotation);
          QLog.d(TAG + this.ID, 2, " NativeVideoImage(): " + paramFile.toString());
        }
        init(paramBoolean);
        this.mDataReport = new DataReport();
        return;
        if (paramObject == null) {
          continue;
        }
        throw new RuntimeException(" NativeVideoImage(): videoParams is illegal, not VideoDrawableParams, " + paramObject.toString());
        bool = false;
      }
      catch (AVideoException paramObject)
      {
        for (;;)
        {
          float f1;
          float f2;
          paramObject.printStackTrace();
          if (QLog.isColorLevel())
          {
            QLog.e(TAG + this.ID, 2, "NativeVideoImage()[newDecodeUncatched]", paramObject);
            continue;
            label1132:
            f1 = f2;
          }
        }
      }
    }
  }
  
  static void loadLibrary(Context paramContext)
  {
    if (!sLibLoaded) {}
    for (;;)
    {
      try
      {
        int i = ShortVideoSoLoad.LoadExtractedShortVideoSo("AVCodec", paramContext);
        if (i != 0) {
          continue;
        }
        sVideoEngineAvaliable = true;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "loadLibrary(): status=" + i);
        }
      }
      catch (Throwable paramContext)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(TAG, 2, "System.loadLibrary(AVCodec) failed");
        paramContext.printStackTrace();
        continue;
      }
      sLibLoaded = true;
      return;
      if (QLog.isColorLevel()) {
        QLog.e(TAG, 2, "loadLibrary() failure....");
      }
    }
  }
  
  /* Error */
  protected void applyNextFrame()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 499	java/lang/System:currentTimeMillis	()J
    //   5: lstore_1
    //   6: new 501	android/graphics/Canvas
    //   9: dup
    //   10: aload_0
    //   11: getfield 503	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   14: invokespecial 506	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   17: astore 5
    //   19: aload_0
    //   20: getfield 503	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   23: iconst_0
    //   24: invokevirtual 511	android/graphics/Bitmap:eraseColor	(I)V
    //   27: new 513	android/graphics/Paint
    //   30: dup
    //   31: invokespecial 514	android/graphics/Paint:<init>	()V
    //   34: astore 6
    //   36: aload_0
    //   37: getfield 199	com/tencent/image/NativeVideoImage:mDefaultRoundCorner	F
    //   40: fconst_0
    //   41: fcmpl
    //   42: ifle +71 -> 113
    //   45: aload 6
    //   47: iconst_1
    //   48: invokevirtual 517	android/graphics/Paint:setAntiAlias	(Z)V
    //   51: aload 6
    //   53: iconst_1
    //   54: invokevirtual 520	android/graphics/Paint:setFilterBitmap	(Z)V
    //   57: aload 5
    //   59: new 522	android/graphics/RectF
    //   62: dup
    //   63: fconst_0
    //   64: fconst_0
    //   65: aload_0
    //   66: getfield 503	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   69: invokevirtual 525	android/graphics/Bitmap:getWidth	()I
    //   72: i2f
    //   73: aload_0
    //   74: getfield 503	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   77: invokevirtual 528	android/graphics/Bitmap:getHeight	()I
    //   80: i2f
    //   81: invokespecial 531	android/graphics/RectF:<init>	(FFFF)V
    //   84: aload_0
    //   85: getfield 199	com/tencent/image/NativeVideoImage:mDefaultRoundCorner	F
    //   88: aload_0
    //   89: getfield 199	com/tencent/image/NativeVideoImage:mDefaultRoundCorner	F
    //   92: aload 6
    //   94: invokevirtual 535	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   97: aload 6
    //   99: new 537	android/graphics/PorterDuffXfermode
    //   102: dup
    //   103: getstatic 543	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   106: invokespecial 546	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   109: invokevirtual 550	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   112: pop
    //   113: aload_0
    //   114: getfield 376	com/tencent/image/NativeVideoImage:mRotation	I
    //   117: ifeq +173 -> 290
    //   120: new 552	android/graphics/Matrix
    //   123: dup
    //   124: invokespecial 553	android/graphics/Matrix:<init>	()V
    //   127: astore 7
    //   129: aload 7
    //   131: aload_0
    //   132: getfield 376	com/tencent/image/NativeVideoImage:mRotation	I
    //   135: i2f
    //   136: aload_0
    //   137: getfield 555	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   140: invokevirtual 525	android/graphics/Bitmap:getWidth	()I
    //   143: iconst_2
    //   144: idiv
    //   145: i2f
    //   146: aload_0
    //   147: getfield 555	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   150: invokevirtual 528	android/graphics/Bitmap:getHeight	()I
    //   153: iconst_2
    //   154: idiv
    //   155: i2f
    //   156: invokevirtual 559	android/graphics/Matrix:postRotate	(FFF)Z
    //   159: pop
    //   160: aload 7
    //   162: aload_0
    //   163: getfield 503	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   166: invokevirtual 525	android/graphics/Bitmap:getWidth	()I
    //   169: aload_0
    //   170: getfield 555	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   173: invokevirtual 525	android/graphics/Bitmap:getWidth	()I
    //   176: isub
    //   177: i2f
    //   178: fconst_2
    //   179: fdiv
    //   180: aload_0
    //   181: getfield 503	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   184: invokevirtual 528	android/graphics/Bitmap:getHeight	()I
    //   187: aload_0
    //   188: getfield 555	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   191: invokevirtual 528	android/graphics/Bitmap:getHeight	()I
    //   194: isub
    //   195: i2f
    //   196: fconst_2
    //   197: fdiv
    //   198: invokevirtual 563	android/graphics/Matrix:postTranslate	(FF)Z
    //   201: pop
    //   202: aload 5
    //   204: aload_0
    //   205: getfield 555	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   208: aload 7
    //   210: aload 6
    //   212: invokevirtual 567	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   215: invokestatic 268	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +69 -> 287
    //   221: aload_0
    //   222: getfield 187	com/tencent/image/NativeVideoImage:debug	Z
    //   225: ifeq +62 -> 287
    //   228: invokestatic 499	java/lang/System:currentTimeMillis	()J
    //   231: lstore_3
    //   232: new 102	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   239: getstatic 124	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   242: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_0
    //   246: getfield 215	com/tencent/image/NativeVideoImage:ID	I
    //   249: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: iconst_2
    //   256: new 102	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   263: ldc_w 569
    //   266: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: lload_3
    //   270: lload_1
    //   271: lsub
    //   272: invokevirtual 572	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   275: ldc_w 574
    //   278: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload_0
    //   288: monitorexit
    //   289: return
    //   290: aload 5
    //   292: aload_0
    //   293: getfield 555	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   296: fconst_0
    //   297: fconst_0
    //   298: aload 6
    //   300: invokevirtual 577	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   303: goto -88 -> 215
    //   306: astore 5
    //   308: aload_0
    //   309: monitorexit
    //   310: aload 5
    //   312: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	NativeVideoImage
    //   5	266	1	l1	long
    //   231	39	3	l2	long
    //   17	274	5	localCanvas	Canvas
    //   306	5	5	localObject	Object
    //   34	265	6	localPaint	Paint
    //   127	82	7	localMatrix	android.graphics.Matrix
    // Exception table:
    //   from	to	target	type
    //   2	113	306	finally
    //   113	215	306	finally
    //   215	287	306	finally
    //   290	303	306	finally
  }
  
  public void disableGlobalPause()
  {
    synchronized (sPauseLock)
    {
      this.mSupportGlobalPause = false;
      sPauseLock.notifyAll();
      return;
    }
  }
  
  protected void doApplyNextFrame(int paramInt)
  {
    this.mDecodeNextFrameEnd = true;
    super.doApplyNextFrame(paramInt);
    if ((QLog.isColorLevel()) && (this.debug)) {
      QLog.d(TAG + this.ID, 2, "doApplyNextFrame: invalidateSelf, index:" + paramInt);
    }
    this.refreshTime = SystemClock.uptimeMillis();
  }
  
  protected void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    if (sUIHandler == null) {
      sUIHandler = new Handler();
    }
    if (this.mAccumulativeRunnable == null) {
      this.mAccumulativeRunnable = new DoAccumulativeRunnable();
    }
    if ((QLog.isColorLevel()) && (this.debug)) {
      QLog.d(TAG + this.ID, 2, "======>draw():start");
    }
    this.drawTime = SystemClock.uptimeMillis();
    if (paramPaint != null)
    {
      paramPaint.setAntiAlias(this.mEnableAntiAlias);
      paramPaint.setFilterBitmap(this.mEnableFilter);
    }
    if (this.mCurFrameBitmap != null) {
      paramCanvas.drawBitmap(this.mCurFrameBitmap, null, paramRect, paramPaint);
    }
    long l1 = SystemClock.uptimeMillis() - this.drawTime;
    if (!paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "draw(): No animation");
      }
      return;
    }
    if (this.mSupportGlobalPause) {
      if (!sPaused)
      {
        executeNewTask(l1);
        if ((this.mPlayAudioFrame) && (this.mOption != null) && (!this.mOption.ignore_audio)) {
          startPlayAudio();
        }
      }
    }
    for (;;)
    {
      l2 = System.currentTimeMillis() - l2;
      if ((!QLog.isColorLevel()) || ((!this.debug) && (l2 <= TIME_BASE))) {
        break;
      }
      QLog.d(TAG + this.ID, 2, "<======draw() end, cost: " + l2 + " ms, drawCost:" + l1);
      return;
      if (!this.mIsInPendingAction)
      {
        sPendingActions.add(new WeakReference(this));
        this.mIsInPendingAction = true;
        continue;
        executeNewTask(l1);
        if ((this.mPlayAudioFrame) && (this.mOption != null) && (!this.mOption.ignore_audio)) {
          startPlayAudio();
        }
      }
    }
  }
  
  protected void executeNewTask(long paramLong)
  {
    if (this.mDecodeNextFrameEnd)
    {
      this.mDecodeNextFrameEnd = false;
      this.mVideoDecodeFinish = false;
      l2 = 0L;
      l1 = l2;
      if (this.drawTime > this.refreshTime)
      {
        l1 = l2;
        if (this.refreshTime != -1L) {
          l1 = this.drawTime - this.refreshTime;
        }
      }
      if (this.mVideoFrameDuration < 0)
      {
        k = this.mAVDecode.videoParam.fps_den;
        m = this.mAVDecode.videoParam.fps_num;
        j = 0;
        if (m > 0)
        {
          this.mTotalDeviation = (k * 1000.0F / m);
          i = (int)this.mTotalDeviation;
          this.mTotalDeviation -= i;
          f = m * 1.0F / k;
          if (QLog.isColorLevel()) {
            QLog.d(TAG + this.ID, 1, "executeNewTask(), fps_den = " + k + ",fps_num = " + m + ",fpsDuration = " + i + ",fps = " + f + " ,mTotalDeviation=" + this.mTotalDeviation + " ,totalFrame=" + this.mAVDecode.videoParam.frame_count);
          }
          if (QLog.isColorLevel()) {
            QLog.d(TAG + this.ID, 1, "executeNewTask()[], mOption.wantedFps = " + this.mOption.wantedFps + " fps=" + f);
          }
          j = i;
          if (this.mOption.wantedFps != 0.0F)
          {
            j = i;
            if (this.mOption.wantedFps >= f / 2.0F)
            {
              j = i;
              if (this.mOption.wantedFps <= f)
              {
                this.mTotalDeviation = (1000.0F / this.mOption.wantedFps);
                i = (int)this.mTotalDeviation;
                this.mTotalDeviation -= i;
                j = i;
                if (QLog.isColorLevel())
                {
                  QLog.d(TAG + this.ID, 1, "executeNewTask(), mOption.wantedFps = " + this.mOption.wantedFps + ",fpsDuration = " + i + ",fps = " + f + ",mVideoParams.mRequestedFPS = " + this.mVideoParams.mRequestedFPS + " ,mTotalDeviation=" + this.mTotalDeviation);
                  j = i;
                }
              }
            }
          }
          if (j <= 0) {
            break label955;
          }
          this.mVideoFrameDuration = j;
          if (QLog.isColorLevel()) {
            QLog.e(TAG + this.ID, 1, "executeNewTask(),1 mVideoFrameDuration = " + this.mVideoFrameDuration);
          }
          if (1 == 0) {
            break label1160;
          }
          l2 = l1;
          if (l1 > 100L) {
            l2 = 100L;
          }
          l3 = paramLong + l2;
          l1 = l3;
          if (l3 >= this.mVideoFrameDuration)
          {
            if ((QLog.isColorLevel()) && (this.debug)) {
              QLog.e(TAG + this.ID, 1, "executeNewTask(), overhead:" + l3 + ", >= frameDuration overhead=" + l3 + " mVideoFrameDuration=" + this.mVideoFrameDuration);
            }
            l1 = this.mVideoFrameDuration;
          }
          l3 = SystemClock.uptimeMillis() + this.mVideoFrameDuration - l1;
          l1 = l2;
          l2 = l3;
          sDecodeHander.post(new DecodeFrameJob(l2));
          if ((QLog.isColorLevel()) && (this.debug)) {
            QLog.d(TAG + this.ID, 2, "executeNewTask(), duration: " + this.mVideoFrameDuration + ", drawCost: " + paramLong + ",refreshCost:" + l1 + ",sync:" + true);
          }
        }
      }
    }
    label955:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        long l2;
        long l1;
        int k;
        int m;
        int j;
        float f;
        long l3;
        return;
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.e(TAG + this.ID, 1, "executeNewTask(), error!!  mAVDecode.videoParam.fps_num = " + this.mAVDecode.videoParam.fps_num + ", srcFilePath = " + this.mSrcVideoFile);
          i = j;
          continue;
          if (this.mAVDecode.videoParam.duration > 0)
          {
            this.mVideoFrameDuration = this.mAVDecode.videoParam.duration;
            if (QLog.isColorLevel()) {
              QLog.e(TAG + this.ID, 1, "executeNewTask(),2 mVideoFrameDuration = " + this.mVideoFrameDuration);
            }
          }
          else
          {
            this.mVideoFrameDuration = 50;
            QLog.e(TAG, 1, "executeNewTask(), error... mVideoFrameDuration: " + this.mVideoFrameDuration + ", mAVDecode.videoParam.duration " + this.mAVDecode.videoParam.duration + ", fpsDuration: " + j);
            continue;
            if ((this.mAVDecode != null) && (this.mAVDecode.videoParam != null) && (this.mAVDecode.videoParam.duration > 0) && (this.mVideoFrameDuration != this.mAVDecode.videoParam.duration))
            {
              continue;
              l2 = SystemClock.uptimeMillis() + this.mVideoFrameDuration;
            }
          }
        }
      }
    }
    label1160:
    QLog.e(TAG + this.ID, 1, "executeNewTask(): mDecodeNextFrameEnd false");
  }
  
  protected void finalize()
    throws Throwable
  {
    if (sReleaseHandler != null) {
      sReleaseHandler.post(new ReleaseTask(this.mAVDecode));
    }
  }
  
  @TargetApi(12)
  public int getByteSize()
  {
    long l2 = 0L + Utils.getBitmapSize(this.mCurFrameBitmap) + Utils.getBitmapSize(this.mCurFrameBitmapBuffer) + Utils.getBitmapSize(this.mFirstFrameBitmap);
    long l1 = l2;
    if (this.mCompatibleBitmap != null) {
      l1 = l2 + Utils.getBitmapSize(this.mCompatibleBitmap);
    }
    return (int)l1;
  }
  
  Rect getFrameSize(File paramFile)
  {
    paramFile = new Rect();
    if (this.mAVDecode != null)
    {
      paramFile.set(0, 0, this.mAVDecode.videoParam.width, this.mAVDecode.videoParam.height);
      return paramFile;
    }
    paramFile.set(0, 0, 200, 200);
    return paramFile;
  }
  
  public int getHeight()
  {
    if (this.mCurFrameBitmap != null) {
      return this.mCurFrameBitmap.getHeight();
    }
    return 0;
  }
  
  /* Error */
  protected boolean getNextFrame()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 499	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: aload_0
    //   7: getfield 358	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   10: astore 8
    //   12: aload 8
    //   14: getfield 369	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   17: getfield 722	com/tencent/video/decode/AVVideoParam:width	I
    //   20: istore_1
    //   21: aload 8
    //   23: getfield 369	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   26: getfield 724	com/tencent/video/decode/AVVideoParam:height	I
    //   29: istore_2
    //   30: invokestatic 499	java/lang/System:currentTimeMillis	()J
    //   33: lstore 5
    //   35: aload_0
    //   36: getfield 234	com/tencent/image/NativeVideoImage:mResetFlag	Z
    //   39: ifeq +396 -> 435
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 234	com/tencent/image/NativeVideoImage:mResetFlag	Z
    //   47: new 184	com/tencent/video/decode/AVideoException
    //   50: dup
    //   51: bipush 146
    //   53: iconst_m1
    //   54: ldc_w 735
    //   57: invokespecial 738	com/tencent/video/decode/AVideoException:<init>	(IILjava/lang/String;)V
    //   60: athrow
    //   61: astore 8
    //   63: invokestatic 268	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +51 -> 117
    //   69: new 102	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   76: getstatic 124	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   79: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: getfield 215	com/tencent/image/NativeVideoImage:ID	I
    //   86: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: iconst_2
    //   93: new 102	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   100: ldc_w 740
    //   103: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload 8
    //   108: invokevirtual 743	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload 8
    //   119: getfield 746	com/tencent/video/decode/AVideoException:mErrCode	I
    //   122: bipush 146
    //   124: if_icmpne +752 -> 876
    //   127: aload_0
    //   128: iconst_1
    //   129: putfield 207	com/tencent/image/NativeVideoImage:mVideoDecodeFinish	Z
    //   132: invokestatic 268	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +33 -> 168
    //   138: new 102	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   145: getstatic 124	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   148: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_0
    //   152: getfield 215	com/tencent/image/NativeVideoImage:ID	I
    //   155: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: iconst_2
    //   162: ldc_w 748
    //   165: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: aload_0
    //   169: getfield 249	com/tencent/image/NativeVideoImage:mPlayAudioOnceFinished	Z
    //   172: ifne +48 -> 220
    //   175: aload_0
    //   176: iconst_1
    //   177: putfield 249	com/tencent/image/NativeVideoImage:mPlayAudioOnceFinished	Z
    //   180: aload_0
    //   181: getfield 295	com/tencent/image/NativeVideoImage:mVideoParams	Lcom/tencent/image/VideoDrawable$VideoDrawableParams;
    //   184: astore 8
    //   186: aload_0
    //   187: iconst_0
    //   188: putfield 243	com/tencent/image/NativeVideoImage:mPlayAudioFrame	Z
    //   191: aload 8
    //   193: iconst_0
    //   194: putfield 296	com/tencent/image/VideoDrawable$VideoDrawableParams:mPlayAudioFrame	Z
    //   197: aload_0
    //   198: getfield 306	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   201: iconst_1
    //   202: putfield 315	com/tencent/video/decode/AVDecodeOption:ignore_audio	Z
    //   205: getstatic 173	com/tencent/image/NativeVideoImage:sUIHandler	Landroid/os/Handler;
    //   208: new 8	com/tencent/image/NativeVideoImage$2
    //   211: dup
    //   212: aload_0
    //   213: invokespecial 751	com/tencent/image/NativeVideoImage$2:<init>	(Lcom/tencent/image/NativeVideoImage;)V
    //   216: invokevirtual 679	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   219: pop
    //   220: aload_0
    //   221: getfield 295	com/tencent/image/NativeVideoImage:mVideoParams	Lcom/tencent/image/VideoDrawable$VideoDrawableParams;
    //   224: getfield 296	com/tencent/image/VideoDrawable$VideoDrawableParams:mPlayAudioFrame	Z
    //   227: ifeq +603 -> 830
    //   230: aload_0
    //   231: getfield 220	com/tencent/image/NativeVideoImage:mLock	Ljava/lang/Object;
    //   234: astore 8
    //   236: aload 8
    //   238: monitorenter
    //   239: getstatic 151	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   242: ifnull +21 -> 263
    //   245: getstatic 151	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   248: new 24	com/tencent/image/NativeVideoImage$ReleaseTask
    //   251: dup
    //   252: aload_0
    //   253: getfield 358	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   256: invokespecial 705	com/tencent/image/NativeVideoImage$ReleaseTask:<init>	(Lcom/tencent/video/decode/AbstractAVDecode;)V
    //   259: invokevirtual 679	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   262: pop
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 306	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   268: invokestatic 754	com/tencent/video/decode/AVDecodeFactory:newDecode	(Lcom/tencent/video/decode/AVDecodeOption;)Lcom/tencent/video/decode/AbstractAVDecode;
    //   271: putfield 358	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   274: aload 8
    //   276: monitorexit
    //   277: aload_0
    //   278: getfield 247	com/tencent/image/NativeVideoImage:mAudioLock	Ljava/lang/Object;
    //   281: astore 8
    //   283: aload 8
    //   285: monitorenter
    //   286: aload_0
    //   287: iconst_1
    //   288: putfield 207	com/tencent/image/NativeVideoImage:mVideoDecodeFinish	Z
    //   291: aload_0
    //   292: getfield 247	com/tencent/image/NativeVideoImage:mAudioLock	Ljava/lang/Object;
    //   295: invokevirtual 587	java/lang/Object:notifyAll	()V
    //   298: aload 8
    //   300: monitorexit
    //   301: aload_0
    //   302: aload_0
    //   303: getfield 228	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   306: iconst_1
    //   307: iadd
    //   308: putfield 228	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   311: iconst_1
    //   312: istore 7
    //   314: aload_0
    //   315: getfield 241	com/tencent/image/NativeVideoImage:mCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   318: iconst_1
    //   319: invokevirtual 758	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   322: pop
    //   323: invokestatic 499	java/lang/System:currentTimeMillis	()J
    //   326: lload_3
    //   327: lsub
    //   328: lstore_3
    //   329: invokestatic 268	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +98 -> 430
    //   335: aload_0
    //   336: getfield 187	com/tencent/image/NativeVideoImage:debug	Z
    //   339: ifne +17 -> 356
    //   342: lload_3
    //   343: getstatic 166	com/tencent/image/NativeVideoImage:TIME_BASE	I
    //   346: i2l
    //   347: lcmp
    //   348: ifgt +8 -> 356
    //   351: iload 7
    //   353: ifne +77 -> 430
    //   356: new 102	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   363: getstatic 124	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   366: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload_0
    //   370: getfield 215	com/tencent/image/NativeVideoImage:ID	I
    //   373: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: iconst_2
    //   380: new 102	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 760
    //   390: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: lload_3
    //   394: invokevirtual 572	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   397: ldc_w 762
    //   400: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_0
    //   404: getfield 241	com/tencent/image/NativeVideoImage:mCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   407: invokevirtual 765	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   410: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   413: ldc_w 767
    //   416: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: iload 7
    //   421: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   424: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: aload_0
    //   431: monitorexit
    //   432: iload 7
    //   434: ireturn
    //   435: iload_1
    //   436: aload_0
    //   437: getfield 193	com/tencent/image/NativeVideoImage:mReqWidth	I
    //   440: if_icmpne +201 -> 641
    //   443: iload_2
    //   444: aload_0
    //   445: getfield 195	com/tencent/image/NativeVideoImage:mReqHeight	I
    //   448: if_icmpne +193 -> 641
    //   451: aload 8
    //   453: aload_0
    //   454: getfield 555	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   457: invokevirtual 770	com/tencent/video/decode/AbstractAVDecode:seekToNextFrame	(Landroid/graphics/Bitmap;)V
    //   460: invokestatic 499	java/lang/System:currentTimeMillis	()J
    //   463: lload 5
    //   465: lsub
    //   466: lstore 5
    //   468: invokestatic 268	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   471: ifeq +73 -> 544
    //   474: aload_0
    //   475: getfield 187	com/tencent/image/NativeVideoImage:debug	Z
    //   478: ifne +12 -> 490
    //   481: lload 5
    //   483: ldc2_w 771
    //   486: lcmp
    //   487: ifle +57 -> 544
    //   490: new 102	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   497: getstatic 124	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   500: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_0
    //   504: getfield 215	com/tencent/image/NativeVideoImage:ID	I
    //   507: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: iconst_2
    //   514: new 102	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 774
    //   524: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: lload 5
    //   529: invokevirtual 572	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   532: ldc_w 776
    //   535: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 287	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: aload 8
    //   546: getfield 369	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   549: getfield 779	com/tencent/video/decode/AVVideoParam:frame_index	I
    //   552: istore_2
    //   553: iload_2
    //   554: iconst_1
    //   555: if_icmpne +170 -> 725
    //   558: aload_0
    //   559: getfield 230	com/tencent/image/NativeVideoImage:mlastVideoFrameIndex	I
    //   562: iload_2
    //   563: if_icmple +162 -> 725
    //   566: aload_0
    //   567: aload_0
    //   568: getfield 232	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   571: iconst_1
    //   572: iadd
    //   573: putfield 232	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   576: aload_0
    //   577: getfield 782	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   580: astore 8
    //   582: aload 8
    //   584: monitorenter
    //   585: aload_0
    //   586: getfield 782	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   589: invokevirtual 785	java/util/ArrayList:size	()I
    //   592: iconst_1
    //   593: isub
    //   594: istore_1
    //   595: iload_1
    //   596: iflt +126 -> 722
    //   599: aload_0
    //   600: getfield 782	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   603: iload_1
    //   604: invokevirtual 788	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   607: checkcast 633	java/lang/ref/WeakReference
    //   610: invokevirtual 791	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   613: checkcast 793	com/tencent/image/VideoDrawable$OnPlayRepeatListener
    //   616: astore 9
    //   618: aload 9
    //   620: ifnull +14 -> 634
    //   623: aload 9
    //   625: aload_0
    //   626: getfield 232	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   629: invokeinterface 796 2 0
    //   634: iload_1
    //   635: iconst_1
    //   636: isub
    //   637: istore_1
    //   638: goto -43 -> 595
    //   641: iload_2
    //   642: ifeq +7 -> 649
    //   645: iload_1
    //   646: ifne +19 -> 665
    //   649: getstatic 124	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   652: iconst_2
    //   653: ldc_w 798
    //   656: invokestatic 363	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   659: iconst_0
    //   660: istore 7
    //   662: goto -232 -> 430
    //   665: aload_0
    //   666: getfield 189	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   669: ifnonnull +16 -> 685
    //   672: aload_0
    //   673: iload_1
    //   674: iload_2
    //   675: aload_0
    //   676: getfield 191	com/tencent/image/NativeVideoImage:mCurrentConfig	Landroid/graphics/Bitmap$Config;
    //   679: invokestatic 802	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   682: putfield 189	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   685: aload 8
    //   687: aload_0
    //   688: getfield 189	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   691: invokevirtual 770	com/tencent/video/decode/AbstractAVDecode:seekToNextFrame	(Landroid/graphics/Bitmap;)V
    //   694: aload_0
    //   695: aload_0
    //   696: getfield 189	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   699: aload_0
    //   700: getfield 193	com/tencent/image/NativeVideoImage:mReqWidth	I
    //   703: aload_0
    //   704: getfield 195	com/tencent/image/NativeVideoImage:mReqHeight	I
    //   707: iconst_1
    //   708: invokestatic 806	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   711: putfield 555	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   714: goto -254 -> 460
    //   717: astore 9
    //   719: goto -259 -> 460
    //   722: aload 8
    //   724: monitorexit
    //   725: aload_0
    //   726: iload_2
    //   727: putfield 230	com/tencent/image/NativeVideoImage:mlastVideoFrameIndex	I
    //   730: aload_0
    //   731: aload_0
    //   732: getfield 228	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   735: iconst_1
    //   736: iadd
    //   737: putfield 228	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   740: iconst_1
    //   741: istore 7
    //   743: goto -429 -> 314
    //   746: astore 9
    //   748: aload 8
    //   750: monitorexit
    //   751: aload 9
    //   753: athrow
    //   754: astore 8
    //   756: invokestatic 268	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   759: ifeq +10 -> 769
    //   762: aload_0
    //   763: ldc_w 807
    //   766: invokevirtual 810	com/tencent/image/NativeVideoImage:showOOM	(Ljava/lang/String;)V
    //   769: new 102	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   776: getstatic 124	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   779: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: aload_0
    //   783: getfield 215	com/tencent/image/NativeVideoImage:ID	I
    //   786: invokevirtual 271	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   789: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: iconst_1
    //   793: ldc_w 812
    //   796: aload 8
    //   798: invokestatic 456	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   801: iconst_0
    //   802: istore 7
    //   804: goto -490 -> 314
    //   807: astore 9
    //   809: aload 8
    //   811: monitorexit
    //   812: aload 9
    //   814: athrow
    //   815: astore 8
    //   817: aload_0
    //   818: monitorexit
    //   819: aload 8
    //   821: athrow
    //   822: astore 9
    //   824: aload 8
    //   826: monitorexit
    //   827: aload 9
    //   829: athrow
    //   830: getstatic 151	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   833: ifnull +21 -> 854
    //   836: getstatic 151	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   839: new 24	com/tencent/image/NativeVideoImage$ReleaseTask
    //   842: dup
    //   843: aload_0
    //   844: getfield 358	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   847: invokespecial 705	com/tencent/image/NativeVideoImage$ReleaseTask:<init>	(Lcom/tencent/video/decode/AbstractAVDecode;)V
    //   850: invokevirtual 679	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   853: pop
    //   854: aload_0
    //   855: getfield 306	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   858: iconst_1
    //   859: putfield 312	com/tencent/video/decode/AVDecodeOption:cycle	Z
    //   862: aload_0
    //   863: aload_0
    //   864: getfield 306	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   867: invokestatic 754	com/tencent/video/decode/AVDecodeFactory:newDecode	(Lcom/tencent/video/decode/AVDecodeOption;)Lcom/tencent/video/decode/AbstractAVDecode;
    //   870: putfield 358	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   873: goto -572 -> 301
    //   876: iconst_0
    //   877: istore 7
    //   879: goto -565 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	882	0	this	NativeVideoImage
    //   20	654	1	i	int
    //   29	698	2	j	int
    //   5	389	3	l1	long
    //   33	495	5	l2	long
    //   312	566	7	bool	boolean
    //   10	12	8	localAbstractAVDecode	AbstractAVDecode
    //   61	57	8	localAVideoException	AVideoException
    //   754	56	8	localOutOfMemoryError	OutOfMemoryError
    //   815	10	8	localObject2	Object
    //   616	8	9	localOnPlayRepeatListener	VideoDrawable.OnPlayRepeatListener
    //   717	1	9	localNullPointerException	java.lang.NullPointerException
    //   746	6	9	localObject3	Object
    //   807	6	9	localObject4	Object
    //   822	6	9	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   30	61	61	com/tencent/video/decode/AVideoException
    //   435	460	61	com/tencent/video/decode/AVideoException
    //   460	481	61	com/tencent/video/decode/AVideoException
    //   490	544	61	com/tencent/video/decode/AVideoException
    //   544	553	61	com/tencent/video/decode/AVideoException
    //   558	585	61	com/tencent/video/decode/AVideoException
    //   649	659	61	com/tencent/video/decode/AVideoException
    //   665	685	61	com/tencent/video/decode/AVideoException
    //   685	694	61	com/tencent/video/decode/AVideoException
    //   694	714	61	com/tencent/video/decode/AVideoException
    //   725	740	61	com/tencent/video/decode/AVideoException
    //   751	754	61	com/tencent/video/decode/AVideoException
    //   694	714	717	java/lang/NullPointerException
    //   585	595	746	finally
    //   599	618	746	finally
    //   623	634	746	finally
    //   722	725	746	finally
    //   748	751	746	finally
    //   6	30	754	java/lang/OutOfMemoryError
    //   30	61	754	java/lang/OutOfMemoryError
    //   63	117	754	java/lang/OutOfMemoryError
    //   117	168	754	java/lang/OutOfMemoryError
    //   168	220	754	java/lang/OutOfMemoryError
    //   220	239	754	java/lang/OutOfMemoryError
    //   277	286	754	java/lang/OutOfMemoryError
    //   301	311	754	java/lang/OutOfMemoryError
    //   435	460	754	java/lang/OutOfMemoryError
    //   460	481	754	java/lang/OutOfMemoryError
    //   490	544	754	java/lang/OutOfMemoryError
    //   544	553	754	java/lang/OutOfMemoryError
    //   558	585	754	java/lang/OutOfMemoryError
    //   649	659	754	java/lang/OutOfMemoryError
    //   665	685	754	java/lang/OutOfMemoryError
    //   685	694	754	java/lang/OutOfMemoryError
    //   694	714	754	java/lang/OutOfMemoryError
    //   725	740	754	java/lang/OutOfMemoryError
    //   751	754	754	java/lang/OutOfMemoryError
    //   812	815	754	java/lang/OutOfMemoryError
    //   827	830	754	java/lang/OutOfMemoryError
    //   830	854	754	java/lang/OutOfMemoryError
    //   854	873	754	java/lang/OutOfMemoryError
    //   239	263	807	finally
    //   263	277	807	finally
    //   809	812	807	finally
    //   2	6	815	finally
    //   6	30	815	finally
    //   30	61	815	finally
    //   63	117	815	finally
    //   117	168	815	finally
    //   168	220	815	finally
    //   220	239	815	finally
    //   277	286	815	finally
    //   301	311	815	finally
    //   314	351	815	finally
    //   356	430	815	finally
    //   435	460	815	finally
    //   460	481	815	finally
    //   490	544	815	finally
    //   544	553	815	finally
    //   558	585	815	finally
    //   649	659	815	finally
    //   665	685	815	finally
    //   685	694	815	finally
    //   694	714	815	finally
    //   725	740	815	finally
    //   751	754	815	finally
    //   756	769	815	finally
    //   769	801	815	finally
    //   812	815	815	finally
    //   827	830	815	finally
    //   830	854	815	finally
    //   854	873	815	finally
    //   286	301	822	finally
    //   824	827	822	finally
  }
  
  public int getWidth()
  {
    if (this.mCurFrameBitmap != null) {
      return this.mCurFrameBitmap.getWidth();
    }
    return 0;
  }
  
  void init(boolean paramBoolean)
  {
    boolean bool = false;
    if (sVideoEngineAvaliable) {}
    try
    {
      this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      try
      {
        if ((this.mRotation != 0) && (this.mRotation != 180))
        {
          this.mCurFrameBitmap = Bitmap.createBitmap(this.mReqHeight, this.mReqWidth, this.mCurrentConfig);
          if (QLog.isColorLevel())
          {
            String str = TAG + this.ID;
            StringBuilder localStringBuilder = new StringBuilder().append("use mCurFrameBitmapBuffer: ");
            if (this.mCurFrameBitmapBuffer != null) {
              bool = true;
            }
            QLog.d(str, 2, bool);
          }
          getNextFrame();
          applyNextFrame();
          if (!paramBoolean) {}
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        try
        {
          do
          {
            for (;;)
            {
              this.mFirstFrameBitmap = this.mCurFrameBitmap.copy(this.mCurFrameBitmap.getConfig(), false);
              return;
              localOutOfMemoryError1 = localOutOfMemoryError1;
              if (QLog.isColorLevel()) {
                showOOM("create mCurFrameBitmapBuffer");
              }
              if (this.mCurrentConfig == Bitmap.Config.ARGB_8888)
              {
                try
                {
                  this.mCurrentConfig = Bitmap.Config.RGB_565;
                  this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
                }
                catch (OutOfMemoryError localOutOfMemoryError2)
                {
                  if (QLog.isColorLevel()) {
                    showOOM("create mCurFrameBitmapBuffer");
                  }
                  URLDrawable.clearMemoryCache();
                  this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
                }
              }
              else
              {
                URLDrawable.clearMemoryCache();
                this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
                continue;
                this.mCurFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
              }
            }
            localOutOfMemoryError3 = localOutOfMemoryError3;
          } while (!QLog.isColorLevel());
          showOOM("create mCurFrameBitmap");
        }
        catch (OutOfMemoryError localOutOfMemoryError4)
        {
          while (!QLog.isColorLevel()) {}
          showOOM("create mFirstFrameBitmap");
        }
      }
    }
  }
  
  void initAudioTrack()
  {
    if (this.mAVDecode.audioParam.channels <= 1) {}
    int m;
    for (int j = 2;; j = 3)
    {
      m = this.mAVDecode.audioParam.sample_rate;
      if (m > 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(TAG + this.ID, 2, "initAudioTrack(), sampleRateInHz=" + m + ", <= 0, return...");
      }
      return;
    }
    int k = AudioTrack.getMinBufferSize(m, j, 2);
    int i = k;
    if (k < 1024)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "initAudioTrack(), minBufSize=" + k + " < 1024, so mutiply 2");
      }
      k *= 2;
      i = k;
      if (k < 1024) {
        i = 1024;
      }
    }
    k = i * 2;
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "initAudioTrack(): cost=channelConfig: " + j + ", sampleRateInHz: " + m + ", minBufSize: " + i + ", primePlaySize: " + k);
    }
    this.mAudioTrack = new AudioTrack(3, m, j, 2, k, 1);
  }
  
  public boolean isAudioPlaying()
  {
    return this.mPlayAudioFrame;
  }
  
  public void resetAndPlayAudioCircle()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "resetAndPlayAudioOnce >>>");
    }
    this.mPlayAudioOnceFinished = false;
    Object localObject = this.mVideoParams;
    this.mPlayAudioFrame = true;
    ((VideoDrawable.VideoDrawableParams)localObject).mPlayAudioFrame = true;
    localObject = this.mOption;
    if (!this.mPlayAudioFrame) {
      bool = true;
    }
    ((AVDecodeOption)localObject).ignore_audio = bool;
    this.mOption.cycle = true;
    try
    {
      this.mAVDecode.resetVideoPlayer(this.mOption);
      reDraw();
      return;
    }
    catch (AVideoException localAVideoException)
    {
      for (;;)
      {
        QLog.e(TAG, 1, "AVideoException happens resetAndPlayAudioOnce...", localAVideoException);
      }
    }
  }
  
  public void resetAndPlayAudioOnce()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "resetAndPlayAudioOnce >>>");
    }
    this.mPlayAudioOnceFinished = false;
    Object localObject = this.mVideoParams;
    this.mPlayAudioFrame = true;
    ((VideoDrawable.VideoDrawableParams)localObject).mPlayAudioFrame = true;
    localObject = this.mOption;
    boolean bool;
    if (!this.mPlayAudioFrame) {
      bool = true;
    }
    for (;;)
    {
      ((AVDecodeOption)localObject).ignore_audio = bool;
      this.mOption.cycle = false;
      try
      {
        this.mAVDecode.resetVideoPlayer(this.mOption);
        reDraw();
        return;
        bool = false;
      }
      catch (AVideoException localAVideoException)
      {
        for (;;)
        {
          QLog.e(TAG, 1, "AVideoException happens resetAndPlayAudioOnce...", localAVideoException);
        }
      }
    }
  }
  
  public void showOOM(final String paramString)
  {
    sUIHandler.post(new Runnable()
    {
      public void run()
      {
        Toast.makeText(BaseApplication.getContext(), "[NativeVideoImage]OOM:" + paramString, 0).show();
      }
    });
  }
  
  void startPlayAudio()
  {
    if ((this.mPlayAudioThread == null) || (this.mAudioThreadFinish))
    {
      this.mPlayAudioThread = new PlayAudioThread("AudioPlayThread");
      this.mPlayAudioThread.start();
      if (this.mRequireAudioFocus) {
        AudioUtils.requesetAudioFoucus();
      }
    }
  }
  
  public void stopPlayAudio()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "stopPlayAudio()");
    }
    this.mPlayAudioFrame = false;
  }
  
  class DecodeFrameJob
    implements Runnable
  {
    final long mNextFrameTime;
    
    public DecodeFrameJob(long paramLong)
    {
      this.mNextFrameTime = paramLong;
    }
    
    public void run()
    {
      if (NativeVideoImage.this.getNextFrame())
      {
        long l = SystemClock.uptimeMillis();
        NativeVideoImage.RefreshJob localRefreshJob = new NativeVideoImage.RefreshJob(NativeVideoImage.this, NativeVideoImage.this.mCount.get());
        if (l < this.mNextFrameTime)
        {
          NativeVideoImage.sUIHandler.postDelayed(localRefreshJob, this.mNextFrameTime - l);
          NativeVideoImage.this.mDataReport.onVideoFrameDroped(false, -1);
          if ((QLog.isColorLevel()) && (NativeVideoImage.this.debug)) {
            QLog.d(NativeVideoImage.TAG + NativeVideoImage.this.ID, 2, "after getFrame, now < mNextFrameTime, delay:" + (this.mNextFrameTime - l) + "ms, index=" + NativeVideoImage.this.mCount.get());
          }
        }
        do
        {
          return;
          NativeVideoImage.sUIHandler.post(localRefreshJob);
          NativeVideoImage.this.mDataReport.onVideoFrameDroped(true, (int)(l - this.mNextFrameTime));
        } while (!QLog.isColorLevel());
        QLog.w(NativeVideoImage.TAG + NativeVideoImage.this.ID, 2, "after getFrame, now > mNextFrameTime, delayedTime=" + (l - this.mNextFrameTime) + "ms, index=" + NativeVideoImage.this.mCount.get());
        return;
      }
      NativeVideoImage.this.mDecodeNextFrameEnd = true;
      QLog.e(NativeVideoImage.TAG + NativeVideoImage.this.ID, 1, "after getFrame, return false ");
    }
  }
  
  public static class DoAccumulativeRunnable
    extends ArgumentsRunnable<WeakReference<NativeVideoImage.WrappedRefreshImg>>
  {
    public int delay = 0;
    long lastRefreshTime = 0L;
    
    protected void run(List<WeakReference<NativeVideoImage.WrappedRefreshImg>> paramList)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (WeakReference)paramList.next();
        if (localObject != null)
        {
          localObject = (NativeVideoImage.WrappedRefreshImg)((WeakReference)localObject).get();
          if (localObject != null) {
            ((NativeVideoImage.WrappedRefreshImg)localObject).img.doApplyNextFrame(((NativeVideoImage.WrappedRefreshImg)localObject).refeshId);
          }
        }
      }
      this.lastRefreshTime = SystemClock.uptimeMillis();
    }
    
    protected void submit()
    {
      long l1 = SystemClock.uptimeMillis();
      if ((this.lastRefreshTime == 0L) || (l1 - this.lastRefreshTime >= this.delay))
      {
        run();
        this.lastRefreshTime = l1;
        return;
      }
      long l2 = this.delay;
      long l3 = this.lastRefreshTime;
      NativeVideoImage.sUIHandler.postDelayed(this, l2 - (l1 - l3));
    }
  }
  
  class PlayAudioThread
    extends Thread
  {
    static final int LIMIT_TIME_USED = 1;
    
    public PlayAudioThread(String paramString)
    {
      setName(paramString + "-" + getId());
    }
    
    public void run()
    {
      label126:
      long l3;
      long l2;
      try
      {
        NativeVideoImage.access$302(NativeVideoImage.this, false);
        if (NativeVideoImage.this.mAudioTrack == null) {
          NativeVideoImage.this.initAudioTrack();
        }
        l1 = System.currentTimeMillis();
        if (NativeVideoImage.this.mAudioTrack == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + "mAudioTrack == null, return.. ");
          }
          if (NativeVideoImage.this.mAudioTrack == null) {}
        }
      }
      catch (Exception localException1) {}finally
      {
        for (;;)
        {
          if (NativeVideoImage.this.mAudioTrack != null) {}
          try
          {
            NativeVideoImage.this.mAudioTrack.stop();
            if (NativeVideoImage.this.mAudioTrack == null) {
              break label1096;
            }
            NativeVideoImage.this.mAudioTrack.release();
            localObject4 = NativeVideoImage.this;
          }
          catch (IllegalStateException localIllegalStateException1)
          {
            for (;;)
            {
              QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException1);
              if (NativeVideoImage.this.mAudioTrack != null)
              {
                NativeVideoImage.this.mAudioTrack.release();
                localNativeVideoImage1 = NativeVideoImage.this;
              }
            }
          }
          finally
          {
            if (NativeVideoImage.this.mAudioTrack == null) {
              break;
            }
            NativeVideoImage.this.mAudioTrack.release();
            NativeVideoImage.this.mAudioTrack = null;
          }
          ((NativeVideoImage)localObject4).mAudioTrack = null;
          if (NativeVideoImage.this.mRequireAudioFocus) {
            AudioUtils.abandonAudioFoucus();
          }
          NativeVideoImage.access$302(NativeVideoImage.this, true);
          if (QLog.isColorLevel()) {
            QLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread run over");
          }
          throw localObject13;
          i = 0;
          break label1634;
          NativeVideoImage.access$602(NativeVideoImage.this, i);
          break label1634;
          l2 = i;
          try
          {
            Thread.sleep(l2);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          continue;
          synchronized (NativeVideoImage.this.mAudioLock)
          {
            while (!NativeVideoImage.this.mVideoDecodeFinish)
            {
              if (QLog.isColorLevel()) {
                QLog.e(NativeVideoImage.TAG_AUDIO, 2, "AudioDecode begin to wait....");
              }
              NativeVideoImage.this.mAudioLock.wait();
              if (QLog.isColorLevel()) {
                QLog.e(NativeVideoImage.TAG_AUDIO, 2, "AudioDecode finish wait....");
              }
            }
          }
          long l1 = l2;
        }
      }
      try
      {
        NativeVideoImage.this.mAudioTrack.stop();
        if (NativeVideoImage.this.mAudioTrack == null) {
          break label132;
        }
        NativeVideoImage.this.mAudioTrack.release();
        ??? = NativeVideoImage.this;
      }
      catch (IllegalStateException localIllegalStateException3)
      {
        QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException3);
        if (NativeVideoImage.this.mAudioTrack == null) {
          break label132;
        }
        NativeVideoImage.this.mAudioTrack.release();
        localNativeVideoImage3 = NativeVideoImage.this;
        break label126;
      }
      finally
      {
        if (NativeVideoImage.this.mAudioTrack == null) {
          break label1481;
        }
        NativeVideoImage.this.mAudioTrack.release();
        NativeVideoImage.this.mAudioTrack = null;
      }
      ((NativeVideoImage)???).mAudioTrack = null;
      label132:
      if (NativeVideoImage.this.mRequireAudioFocus) {
        AudioUtils.abandonAudioFoucus();
      }
      NativeVideoImage.access$302(NativeVideoImage.this, true);
      if (QLog.isColorLevel()) {
        ??? = NativeVideoImage.TAG_AUDIO;
      }
      label412:
      label671:
      label707:
      long l4;
      for (;;)
      {
        QLog.d((String)???, 2, "PlayAudioThread run over");
        do
        {
          for (;;)
          {
            return;
            NativeVideoImage.this.mAudioTrack.play();
            try
            {
              synchronized (AbstractVideoImage.sPauseLock)
              {
                while (AbstractVideoImage.sPaused)
                {
                  boolean bool = NativeVideoImage.this.mSupportGlobalPause;
                  if (!bool) {
                    break;
                  }
                  try
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + "begin wait ===> ");
                    }
                    if (NativeVideoImage.this.mRequireAudioFocus) {
                      AudioUtils.abandonAudioFoucus();
                    }
                    AbstractVideoImage.sPauseLock.wait();
                    if (QLog.isColorLevel()) {
                      QLog.d(NativeVideoImage.TAG_AUDIO, 2, "PlayAudioThread id=" + getId() + " wait end <=== ");
                    }
                    if (NativeVideoImage.this.mRequireAudioFocus) {
                      AudioUtils.requesetAudioFoucus();
                    }
                  }
                  catch (Exception localException2) {}
                }
                if (NativeVideoImage.this.mPlayAudioFrame) {
                  break label707;
                }
                if (QLog.isColorLevel()) {
                  QLog.i(NativeVideoImage.TAG_AUDIO, 2, "mPlayAudioFrame is false, so quit audio decode... ");
                }
                if (NativeVideoImage.this.mAudioTrack != null) {}
                try
                {
                  NativeVideoImage.this.mAudioTrack.stop();
                  if (NativeVideoImage.this.mAudioTrack == null) {
                    break label412;
                  }
                  NativeVideoImage.this.mAudioTrack.release();
                  ??? = NativeVideoImage.this;
                }
                catch (IllegalStateException localIllegalStateException5)
                {
                  for (;;)
                  {
                    int i;
                    QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException5);
                    if (NativeVideoImage.this.mAudioTrack != null)
                    {
                      NativeVideoImage.this.mAudioTrack.release();
                      localNativeVideoImage5 = NativeVideoImage.this;
                    }
                  }
                }
                finally
                {
                  if (NativeVideoImage.this.mAudioTrack == null) {
                    break label1631;
                  }
                  NativeVideoImage.this.mAudioTrack.release();
                  NativeVideoImage.this.mAudioTrack = null;
                }
                ((NativeVideoImage)???).mAudioTrack = null;
                if (NativeVideoImage.this.mRequireAudioFocus) {
                  AudioUtils.abandonAudioFoucus();
                }
                NativeVideoImage.access$302(NativeVideoImage.this, true);
                if (QLog.isColorLevel()) {
                  ??? = NativeVideoImage.TAG_AUDIO;
                }
              }
            }
            catch (AVideoException localAVideoException)
            {
              do
              {
                l3 = System.currentTimeMillis();
                l2 = l1;
                if (l1 - l3 > 300000L)
                {
                  l1 = l3;
                  l2 = l1;
                  if (QLog.isColorLevel())
                  {
                    l2 = l1;
                    if (NativeVideoImage.this.debug)
                    {
                      QLog.i(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame ", localAVideoException);
                      l2 = l1;
                    }
                  }
                }
                i = localAVideoException.mErrCode;
                if (i == -116) {
                  break;
                }
                l1 = l2;
              } while (i != -110);
              if (QLog.isColorLevel()) {
                QLog.d(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame, AudioDecode end...");
              }
              if (NativeVideoImage.this.mPlayAudioOnceFinished) {
                break label1175;
              }
            }
          }
          NativeVideoImage.this.mPlayAudioOnceFinished = true;
          ??? = NativeVideoImage.this.mVideoParams;
          NativeVideoImage.this.mPlayAudioFrame = false;
          ((VideoDrawable.VideoDrawableParams)???).mPlayAudioFrame = false;
          NativeVideoImage.this.mOption.ignore_audio = true;
          NativeVideoImage.sUIHandler.post(new Runnable()
          {
            public void run()
            {
              if (NativeVideoImage.this.mPlayOnceListener != null)
              {
                NativeVideoImage.this.mPlayOnceListener.onFinish();
                NativeVideoImage.this.mPlayOnceListener = null;
                if (QLog.isColorLevel()) {
                  QLog.e(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame, mPlayOnceListener.onFinish()");
                }
              }
            }
          });
          if (NativeVideoImage.this.mAudioTrack != null) {}
          try
          {
            NativeVideoImage.this.mAudioTrack.stop();
            if (NativeVideoImage.this.mAudioTrack == null) {
              break label671;
            }
            NativeVideoImage.this.mAudioTrack.release();
            ??? = NativeVideoImage.this;
          }
          catch (IllegalStateException localIllegalStateException4)
          {
            for (;;)
            {
              QLog.e(NativeVideoImage.TAG_AUDIO, 1, "PlayAudioThread run ", localIllegalStateException4);
              if (NativeVideoImage.this.mAudioTrack != null)
              {
                NativeVideoImage.this.mAudioTrack.release();
                localNativeVideoImage4 = NativeVideoImage.this;
              }
            }
          }
          finally
          {
            if (NativeVideoImage.this.mAudioTrack == null) {
              break label1556;
            }
            NativeVideoImage.this.mAudioTrack.release();
            NativeVideoImage.this.mAudioTrack = null;
          }
          ((NativeVideoImage)???).mAudioTrack = null;
          if (NativeVideoImage.this.mRequireAudioFocus) {
            AudioUtils.abandonAudioFoucus();
          }
          NativeVideoImage.access$302(NativeVideoImage.this, true);
        } while (!QLog.isColorLevel());
        ??? = NativeVideoImage.TAG_AUDIO;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i(NativeVideoImage.TAG_AUDIO, 2, "seekToNextAudioFrame: before <<<=== ");
        }
        l4 = System.currentTimeMillis();
      }
      for (;;)
      {
        AbstractAVDecode localAbstractAVDecode;
        Object localObject1;
        Object localObject4;
        label1096:
        NativeVideoImage localNativeVideoImage1;
        label1175:
        NativeVideoImage localNativeVideoImage2;
        NativeVideoImage localNativeVideoImage3;
        label1481:
        NativeVideoImage localNativeVideoImage4;
        label1556:
        NativeVideoImage localNativeVideoImage5;
        label1631:
        label1634:
        l4 = l2 - l4;
        long l5 = l3 - l2;
        if (l4 < 1L) {
          if (l5 < 1L) {}
        }
      }
    }
  }
  
  class RefreshJob
    implements Runnable
  {
    int refreshId;
    
    public RefreshJob(int paramInt)
    {
      this.refreshId = paramInt;
    }
    
    public void run()
    {
      if ((QLog.isColorLevel()) && (NativeVideoImage.this.debug)) {
        QLog.d(NativeVideoImage.TAG + NativeVideoImage.this.ID, 2, "RefreshJob.run(): refreshId:" + this.refreshId);
      }
      NativeVideoImage.WrappedRefreshImg localWrappedRefreshImg = new NativeVideoImage.WrappedRefreshImg();
      localWrappedRefreshImg.img = NativeVideoImage.this;
      localWrappedRefreshImg.refeshId = this.refreshId;
      NativeVideoImage.this.mAccumulativeRunnable.add(new WeakReference[] { new WeakReference(localWrappedRefreshImg) });
    }
  }
  
  static class ReleaseTask
    implements Runnable
  {
    AbstractAVDecode mDecoder;
    
    public ReleaseTask(AbstractAVDecode paramAbstractAVDecode)
    {
      this.mDecoder = paramAbstractAVDecode;
    }
    
    public void run()
    {
      if (this.mDecoder != null) {}
      try
      {
        this.mDecoder.close();
        this.mDecoder = null;
        if (QLog.isColorLevel()) {
          QLog.d(NativeVideoImage.TAG, 2, "..ReleaseTask close AVDecode..");
        }
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public static class WrappedRefreshImg
  {
    public AbstractVideoImage img;
    public int refeshId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage
 * JD-Core Version:    0.7.0.1
 */
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
  protected NativeVideoImage.DoAccumulativeRunnable mAccumulativeRunnable;
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
  NativeVideoImage.PlayAudioThread mPlayAudioThread;
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
              break label1130;
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
            label1130:
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
    //   2: invokestatic 475	java/lang/System:currentTimeMillis	()J
    //   5: lstore_1
    //   6: new 477	android/graphics/Canvas
    //   9: dup
    //   10: aload_0
    //   11: getfield 479	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   14: invokespecial 482	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   17: astore 5
    //   19: aload_0
    //   20: getfield 479	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   23: iconst_0
    //   24: invokevirtual 487	android/graphics/Bitmap:eraseColor	(I)V
    //   27: new 489	android/graphics/Paint
    //   30: dup
    //   31: invokespecial 490	android/graphics/Paint:<init>	()V
    //   34: astore 6
    //   36: aload_0
    //   37: getfield 175	com/tencent/image/NativeVideoImage:mDefaultRoundCorner	F
    //   40: fconst_0
    //   41: fcmpl
    //   42: ifle +71 -> 113
    //   45: aload 6
    //   47: iconst_1
    //   48: invokevirtual 493	android/graphics/Paint:setAntiAlias	(Z)V
    //   51: aload 6
    //   53: iconst_1
    //   54: invokevirtual 496	android/graphics/Paint:setFilterBitmap	(Z)V
    //   57: aload 5
    //   59: new 498	android/graphics/RectF
    //   62: dup
    //   63: fconst_0
    //   64: fconst_0
    //   65: aload_0
    //   66: getfield 479	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   69: invokevirtual 501	android/graphics/Bitmap:getWidth	()I
    //   72: i2f
    //   73: aload_0
    //   74: getfield 479	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   77: invokevirtual 504	android/graphics/Bitmap:getHeight	()I
    //   80: i2f
    //   81: invokespecial 507	android/graphics/RectF:<init>	(FFFF)V
    //   84: aload_0
    //   85: getfield 175	com/tencent/image/NativeVideoImage:mDefaultRoundCorner	F
    //   88: aload_0
    //   89: getfield 175	com/tencent/image/NativeVideoImage:mDefaultRoundCorner	F
    //   92: aload 6
    //   94: invokevirtual 511	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   97: aload 6
    //   99: new 513	android/graphics/PorterDuffXfermode
    //   102: dup
    //   103: getstatic 519	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   106: invokespecial 522	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   109: invokevirtual 526	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   112: pop
    //   113: aload_0
    //   114: getfield 352	com/tencent/image/NativeVideoImage:mRotation	I
    //   117: ifeq +173 -> 290
    //   120: new 528	android/graphics/Matrix
    //   123: dup
    //   124: invokespecial 529	android/graphics/Matrix:<init>	()V
    //   127: astore 7
    //   129: aload 7
    //   131: aload_0
    //   132: getfield 352	com/tencent/image/NativeVideoImage:mRotation	I
    //   135: i2f
    //   136: aload_0
    //   137: getfield 531	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   140: invokevirtual 501	android/graphics/Bitmap:getWidth	()I
    //   143: iconst_2
    //   144: idiv
    //   145: i2f
    //   146: aload_0
    //   147: getfield 531	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   150: invokevirtual 504	android/graphics/Bitmap:getHeight	()I
    //   153: iconst_2
    //   154: idiv
    //   155: i2f
    //   156: invokevirtual 535	android/graphics/Matrix:postRotate	(FFF)Z
    //   159: pop
    //   160: aload 7
    //   162: aload_0
    //   163: getfield 479	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   166: invokevirtual 501	android/graphics/Bitmap:getWidth	()I
    //   169: aload_0
    //   170: getfield 531	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   173: invokevirtual 501	android/graphics/Bitmap:getWidth	()I
    //   176: isub
    //   177: i2f
    //   178: fconst_2
    //   179: fdiv
    //   180: aload_0
    //   181: getfield 479	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   184: invokevirtual 504	android/graphics/Bitmap:getHeight	()I
    //   187: aload_0
    //   188: getfield 531	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   191: invokevirtual 504	android/graphics/Bitmap:getHeight	()I
    //   194: isub
    //   195: i2f
    //   196: fconst_2
    //   197: fdiv
    //   198: invokevirtual 539	android/graphics/Matrix:postTranslate	(FF)Z
    //   201: pop
    //   202: aload 5
    //   204: aload_0
    //   205: getfield 531	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   208: aload 7
    //   210: aload 6
    //   212: invokevirtual 543	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   215: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +69 -> 287
    //   221: aload_0
    //   222: getfield 163	com/tencent/image/NativeVideoImage:debug	Z
    //   225: ifeq +62 -> 287
    //   228: invokestatic 475	java/lang/System:currentTimeMillis	()J
    //   231: lstore_3
    //   232: new 78	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   239: getstatic 100	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   242: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload_0
    //   246: getfield 191	com/tencent/image/NativeVideoImage:ID	I
    //   249: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   252: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: iconst_2
    //   256: new 78	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   263: ldc_w 545
    //   266: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: lload_3
    //   270: lload_1
    //   271: lsub
    //   272: invokevirtual 548	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   275: ldc_w 550
    //   278: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload_0
    //   288: monitorexit
    //   289: return
    //   290: aload 5
    //   292: aload_0
    //   293: getfield 531	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   296: fconst_0
    //   297: fconst_0
    //   298: aload 6
    //   300: invokevirtual 553	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
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
      this.mAccumulativeRunnable = new NativeVideoImage.DoAccumulativeRunnable();
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
            break label947;
          }
          this.mVideoFrameDuration = j;
          if (QLog.isColorLevel()) {
            QLog.e(TAG + this.ID, 1, "executeNewTask(),1 mVideoFrameDuration = " + this.mVideoFrameDuration);
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
          l3 = SystemClock.uptimeMillis();
          l4 = this.mVideoFrameDuration;
          sDecodeHander.post(new NativeVideoImage.DecodeFrameJob(this, l3 + l4 - l1));
          if ((QLog.isColorLevel()) && (this.debug)) {
            QLog.d(TAG + this.ID, 2, "executeNewTask(), duration: " + this.mVideoFrameDuration + ", drawCost: " + paramLong + ",refreshCost:" + l2 + ",sync:" + true);
          }
        }
      }
    }
    label947:
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
        long l4;
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
            if ((this.mAVDecode == null) || (this.mAVDecode.videoParam == null) || (this.mAVDecode.videoParam.duration <= 0) || (this.mVideoFrameDuration == this.mAVDecode.videoParam.duration)) {}
          }
        }
      }
    }
    QLog.e(TAG + this.ID, 1, "executeNewTask(): mDecodeNextFrameEnd false");
  }
  
  protected void finalize()
  {
    if (sReleaseHandler != null) {
      sReleaseHandler.post(new NativeVideoImage.ReleaseTask(this.mAVDecode));
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
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: invokestatic 475	java/lang/System:currentTimeMillis	()J
    //   10: lstore 5
    //   12: aload_0
    //   13: getfield 334	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   16: astore 9
    //   18: aload 9
    //   20: getfield 345	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   23: getfield 703	com/tencent/video/decode/AVVideoParam:width	I
    //   26: istore_1
    //   27: aload 9
    //   29: getfield 345	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   32: getfield 705	com/tencent/video/decode/AVVideoParam:height	I
    //   35: istore_2
    //   36: invokestatic 475	java/lang/System:currentTimeMillis	()J
    //   39: lstore 7
    //   41: aload_0
    //   42: getfield 210	com/tencent/image/NativeVideoImage:mResetFlag	Z
    //   45: ifeq +406 -> 451
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 210	com/tencent/image/NativeVideoImage:mResetFlag	Z
    //   53: new 160	com/tencent/video/decode/AVideoException
    //   56: dup
    //   57: bipush 146
    //   59: iconst_m1
    //   60: ldc_w 716
    //   63: invokespecial 719	com/tencent/video/decode/AVideoException:<init>	(IILjava/lang/String;)V
    //   66: athrow
    //   67: astore 9
    //   69: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +51 -> 123
    //   75: new 78	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   82: getstatic 100	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   85: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_0
    //   89: getfield 191	com/tencent/image/NativeVideoImage:ID	I
    //   92: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: iconst_2
    //   99: new 78	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   106: ldc_w 721
    //   109: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 9
    //   114: invokevirtual 724	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload 9
    //   125: getfield 727	com/tencent/video/decode/AVideoException:mErrCode	I
    //   128: bipush 146
    //   130: if_icmpne +755 -> 885
    //   133: aload_0
    //   134: iconst_1
    //   135: putfield 183	com/tencent/image/NativeVideoImage:mVideoDecodeFinish	Z
    //   138: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +33 -> 174
    //   144: new 78	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   151: getstatic 100	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   154: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_0
    //   158: getfield 191	com/tencent/image/NativeVideoImage:ID	I
    //   161: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: iconst_2
    //   168: ldc_w 729
    //   171: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload_0
    //   175: getfield 225	com/tencent/image/NativeVideoImage:mPlayAudioOnceFinished	Z
    //   178: ifne +48 -> 226
    //   181: aload_0
    //   182: iconst_1
    //   183: putfield 225	com/tencent/image/NativeVideoImage:mPlayAudioOnceFinished	Z
    //   186: aload_0
    //   187: getfield 271	com/tencent/image/NativeVideoImage:mVideoParams	Lcom/tencent/image/VideoDrawable$VideoDrawableParams;
    //   190: astore 9
    //   192: aload_0
    //   193: iconst_0
    //   194: putfield 219	com/tencent/image/NativeVideoImage:mPlayAudioFrame	Z
    //   197: aload 9
    //   199: iconst_0
    //   200: putfield 272	com/tencent/image/VideoDrawable$VideoDrawableParams:mPlayAudioFrame	Z
    //   203: aload_0
    //   204: getfield 282	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   207: iconst_1
    //   208: putfield 291	com/tencent/video/decode/AVDecodeOption:ignore_audio	Z
    //   211: getstatic 149	com/tencent/image/NativeVideoImage:sUIHandler	Landroid/os/Handler;
    //   214: new 731	com/tencent/image/NativeVideoImage$2
    //   217: dup
    //   218: aload_0
    //   219: invokespecial 734	com/tencent/image/NativeVideoImage$2:<init>	(Lcom/tencent/image/NativeVideoImage;)V
    //   222: invokevirtual 659	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   225: pop
    //   226: aload_0
    //   227: getfield 271	com/tencent/image/NativeVideoImage:mVideoParams	Lcom/tencent/image/VideoDrawable$VideoDrawableParams;
    //   230: getfield 272	com/tencent/image/VideoDrawable$VideoDrawableParams:mPlayAudioFrame	Z
    //   233: ifeq +606 -> 839
    //   236: aload_0
    //   237: getfield 196	com/tencent/image/NativeVideoImage:mLock	Ljava/lang/Object;
    //   240: astore 9
    //   242: aload 9
    //   244: monitorenter
    //   245: getstatic 127	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   248: ifnull +21 -> 269
    //   251: getstatic 127	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   254: new 684	com/tencent/image/NativeVideoImage$ReleaseTask
    //   257: dup
    //   258: aload_0
    //   259: getfield 334	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   262: invokespecial 687	com/tencent/image/NativeVideoImage$ReleaseTask:<init>	(Lcom/tencent/video/decode/AbstractAVDecode;)V
    //   265: invokevirtual 659	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   268: pop
    //   269: aload_0
    //   270: aload_0
    //   271: getfield 282	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   274: invokestatic 737	com/tencent/video/decode/AVDecodeFactory:newDecode	(Lcom/tencent/video/decode/AVDecodeOption;)Lcom/tencent/video/decode/AbstractAVDecode;
    //   277: putfield 334	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   280: aload 9
    //   282: monitorexit
    //   283: aload_0
    //   284: getfield 223	com/tencent/image/NativeVideoImage:mAudioLock	Ljava/lang/Object;
    //   287: astore 9
    //   289: aload 9
    //   291: monitorenter
    //   292: aload_0
    //   293: iconst_1
    //   294: putfield 183	com/tencent/image/NativeVideoImage:mVideoDecodeFinish	Z
    //   297: aload_0
    //   298: getfield 223	com/tencent/image/NativeVideoImage:mAudioLock	Ljava/lang/Object;
    //   301: invokevirtual 563	java/lang/Object:notifyAll	()V
    //   304: aload 9
    //   306: monitorexit
    //   307: aload_0
    //   308: aload_0
    //   309: getfield 204	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   312: iconst_1
    //   313: iadd
    //   314: putfield 204	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   317: iconst_1
    //   318: istore_3
    //   319: aload_0
    //   320: getfield 217	com/tencent/image/NativeVideoImage:mCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   323: iconst_1
    //   324: invokevirtual 741	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   327: pop
    //   328: invokestatic 475	java/lang/System:currentTimeMillis	()J
    //   331: lload 5
    //   333: lsub
    //   334: lstore 5
    //   336: iload_3
    //   337: istore 4
    //   339: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +104 -> 446
    //   345: aload_0
    //   346: getfield 163	com/tencent/image/NativeVideoImage:debug	Z
    //   349: ifne +20 -> 369
    //   352: lload 5
    //   354: getstatic 142	com/tencent/image/NativeVideoImage:TIME_BASE	I
    //   357: i2l
    //   358: lcmp
    //   359: ifgt +10 -> 369
    //   362: iload_3
    //   363: istore 4
    //   365: iload_3
    //   366: ifne +80 -> 446
    //   369: new 78	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   376: getstatic 100	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   379: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_0
    //   383: getfield 191	com/tencent/image/NativeVideoImage:ID	I
    //   386: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   389: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: iconst_2
    //   393: new 78	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 743
    //   403: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: lload 5
    //   408: invokevirtual 548	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   411: ldc_w 745
    //   414: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_0
    //   418: getfield 217	com/tencent/image/NativeVideoImage:mCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   421: invokevirtual 748	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   424: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   427: ldc_w 750
    //   430: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: iload_3
    //   434: invokevirtual 252	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   437: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: iload_3
    //   444: istore 4
    //   446: aload_0
    //   447: monitorexit
    //   448: iload 4
    //   450: ireturn
    //   451: iload_1
    //   452: aload_0
    //   453: getfield 169	com/tencent/image/NativeVideoImage:mReqWidth	I
    //   456: if_icmpne +201 -> 657
    //   459: iload_2
    //   460: aload_0
    //   461: getfield 171	com/tencent/image/NativeVideoImage:mReqHeight	I
    //   464: if_icmpne +193 -> 657
    //   467: aload 9
    //   469: aload_0
    //   470: getfield 531	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   473: invokevirtual 753	com/tencent/video/decode/AbstractAVDecode:seekToNextFrame	(Landroid/graphics/Bitmap;)V
    //   476: invokestatic 475	java/lang/System:currentTimeMillis	()J
    //   479: lload 7
    //   481: lsub
    //   482: lstore 7
    //   484: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   487: ifeq +73 -> 560
    //   490: aload_0
    //   491: getfield 163	com/tencent/image/NativeVideoImage:debug	Z
    //   494: ifne +12 -> 506
    //   497: lload 7
    //   499: ldc2_w 754
    //   502: lcmp
    //   503: ifle +57 -> 560
    //   506: new 78	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   513: getstatic 100	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   516: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload_0
    //   520: getfield 191	com/tencent/image/NativeVideoImage:ID	I
    //   523: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   526: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: iconst_2
    //   530: new 78	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   537: ldc_w 757
    //   540: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: lload 7
    //   545: invokevirtual 548	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   548: ldc_w 759
    //   551: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: aload 9
    //   562: getfield 345	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   565: getfield 762	com/tencent/video/decode/AVVideoParam:frame_index	I
    //   568: istore_2
    //   569: iload_2
    //   570: iconst_1
    //   571: if_icmpne +224 -> 795
    //   574: aload_0
    //   575: getfield 206	com/tencent/image/NativeVideoImage:mlastVideoFrameIndex	I
    //   578: iload_2
    //   579: if_icmple +216 -> 795
    //   582: aload_0
    //   583: aload_0
    //   584: getfield 208	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   587: iconst_1
    //   588: iadd
    //   589: putfield 208	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   592: aload_0
    //   593: getfield 765	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   596: astore 9
    //   598: aload 9
    //   600: monitorenter
    //   601: aload_0
    //   602: getfield 765	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   605: invokevirtual 768	java/util/ArrayList:size	()I
    //   608: iconst_1
    //   609: isub
    //   610: istore_1
    //   611: iload_1
    //   612: iflt +180 -> 792
    //   615: aload_0
    //   616: getfield 765	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   619: iload_1
    //   620: invokevirtual 771	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   623: checkcast 611	java/lang/ref/WeakReference
    //   626: invokevirtual 774	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   629: checkcast 776	com/tencent/image/VideoDrawable$OnPlayRepeatListener
    //   632: astore 10
    //   634: aload 10
    //   636: ifnull +14 -> 650
    //   639: aload 10
    //   641: aload_0
    //   642: getfield 208	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   645: invokeinterface 779 2 0
    //   650: iload_1
    //   651: iconst_1
    //   652: isub
    //   653: istore_1
    //   654: goto -43 -> 611
    //   657: iload_2
    //   658: ifeq +7 -> 665
    //   661: iload_1
    //   662: ifne +73 -> 735
    //   665: getstatic 100	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   668: iconst_2
    //   669: ldc_w 781
    //   672: invokestatic 339	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   675: goto -229 -> 446
    //   678: astore 9
    //   680: invokestatic 244	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   683: ifeq +10 -> 693
    //   686: aload_0
    //   687: ldc_w 782
    //   690: invokevirtual 785	com/tencent/image/NativeVideoImage:showOOM	(Ljava/lang/String;)V
    //   693: new 78	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   700: getstatic 100	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   703: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: aload_0
    //   707: getfield 191	com/tencent/image/NativeVideoImage:ID	I
    //   710: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   713: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: iconst_1
    //   717: ldc_w 787
    //   720: aload 9
    //   722: invokestatic 432	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   725: goto -406 -> 319
    //   728: astore 9
    //   730: aload_0
    //   731: monitorexit
    //   732: aload 9
    //   734: athrow
    //   735: aload_0
    //   736: getfield 165	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   739: ifnonnull +16 -> 755
    //   742: aload_0
    //   743: iload_1
    //   744: iload_2
    //   745: aload_0
    //   746: getfield 167	com/tencent/image/NativeVideoImage:mCurrentConfig	Landroid/graphics/Bitmap$Config;
    //   749: invokestatic 791	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   752: putfield 165	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   755: aload 9
    //   757: aload_0
    //   758: getfield 165	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   761: invokevirtual 753	com/tencent/video/decode/AbstractAVDecode:seekToNextFrame	(Landroid/graphics/Bitmap;)V
    //   764: aload_0
    //   765: aload_0
    //   766: getfield 165	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   769: aload_0
    //   770: getfield 169	com/tencent/image/NativeVideoImage:mReqWidth	I
    //   773: aload_0
    //   774: getfield 171	com/tencent/image/NativeVideoImage:mReqHeight	I
    //   777: iconst_1
    //   778: invokestatic 795	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   781: putfield 531	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   784: goto -308 -> 476
    //   787: astore 10
    //   789: goto -313 -> 476
    //   792: aload 9
    //   794: monitorexit
    //   795: aload_0
    //   796: iload_2
    //   797: putfield 206	com/tencent/image/NativeVideoImage:mlastVideoFrameIndex	I
    //   800: aload_0
    //   801: aload_0
    //   802: getfield 204	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   805: iconst_1
    //   806: iadd
    //   807: putfield 204	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   810: iconst_1
    //   811: istore_3
    //   812: goto -493 -> 319
    //   815: astore 10
    //   817: aload 9
    //   819: monitorexit
    //   820: aload 10
    //   822: athrow
    //   823: astore 10
    //   825: aload 9
    //   827: monitorexit
    //   828: aload 10
    //   830: athrow
    //   831: astore 10
    //   833: aload 9
    //   835: monitorexit
    //   836: aload 10
    //   838: athrow
    //   839: getstatic 127	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   842: ifnull +21 -> 863
    //   845: getstatic 127	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   848: new 684	com/tencent/image/NativeVideoImage$ReleaseTask
    //   851: dup
    //   852: aload_0
    //   853: getfield 334	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   856: invokespecial 687	com/tencent/image/NativeVideoImage$ReleaseTask:<init>	(Lcom/tencent/video/decode/AbstractAVDecode;)V
    //   859: invokevirtual 659	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   862: pop
    //   863: aload_0
    //   864: getfield 282	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   867: iconst_1
    //   868: putfield 288	com/tencent/video/decode/AVDecodeOption:cycle	Z
    //   871: aload_0
    //   872: aload_0
    //   873: getfield 282	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   876: invokestatic 737	com/tencent/video/decode/AVDecodeFactory:newDecode	(Lcom/tencent/video/decode/AVDecodeOption;)Lcom/tencent/video/decode/AbstractAVDecode;
    //   879: putfield 334	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   882: goto -575 -> 307
    //   885: iconst_0
    //   886: istore_3
    //   887: goto -568 -> 319
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	890	0	this	NativeVideoImage
    //   26	718	1	i	int
    //   35	762	2	j	int
    //   4	883	3	bool1	boolean
    //   1	448	4	bool2	boolean
    //   10	397	5	l1	long
    //   39	505	7	l2	long
    //   16	12	9	localAbstractAVDecode	AbstractAVDecode
    //   67	57	9	localAVideoException	AVideoException
    //   678	43	9	localOutOfMemoryError	OutOfMemoryError
    //   728	106	9	localObject2	Object
    //   632	8	10	localOnPlayRepeatListener	VideoDrawable.OnPlayRepeatListener
    //   787	1	10	localNullPointerException	java.lang.NullPointerException
    //   815	6	10	localObject3	Object
    //   823	6	10	localObject4	Object
    //   831	6	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   36	67	67	com/tencent/video/decode/AVideoException
    //   451	476	67	com/tencent/video/decode/AVideoException
    //   476	497	67	com/tencent/video/decode/AVideoException
    //   506	560	67	com/tencent/video/decode/AVideoException
    //   560	569	67	com/tencent/video/decode/AVideoException
    //   574	601	67	com/tencent/video/decode/AVideoException
    //   665	675	67	com/tencent/video/decode/AVideoException
    //   735	755	67	com/tencent/video/decode/AVideoException
    //   755	764	67	com/tencent/video/decode/AVideoException
    //   764	784	67	com/tencent/video/decode/AVideoException
    //   795	810	67	com/tencent/video/decode/AVideoException
    //   820	823	67	com/tencent/video/decode/AVideoException
    //   12	36	678	java/lang/OutOfMemoryError
    //   36	67	678	java/lang/OutOfMemoryError
    //   69	123	678	java/lang/OutOfMemoryError
    //   123	174	678	java/lang/OutOfMemoryError
    //   174	226	678	java/lang/OutOfMemoryError
    //   226	245	678	java/lang/OutOfMemoryError
    //   283	292	678	java/lang/OutOfMemoryError
    //   307	317	678	java/lang/OutOfMemoryError
    //   451	476	678	java/lang/OutOfMemoryError
    //   476	497	678	java/lang/OutOfMemoryError
    //   506	560	678	java/lang/OutOfMemoryError
    //   560	569	678	java/lang/OutOfMemoryError
    //   574	601	678	java/lang/OutOfMemoryError
    //   665	675	678	java/lang/OutOfMemoryError
    //   735	755	678	java/lang/OutOfMemoryError
    //   755	764	678	java/lang/OutOfMemoryError
    //   764	784	678	java/lang/OutOfMemoryError
    //   795	810	678	java/lang/OutOfMemoryError
    //   820	823	678	java/lang/OutOfMemoryError
    //   828	831	678	java/lang/OutOfMemoryError
    //   836	839	678	java/lang/OutOfMemoryError
    //   839	863	678	java/lang/OutOfMemoryError
    //   863	882	678	java/lang/OutOfMemoryError
    //   7	12	728	finally
    //   12	36	728	finally
    //   36	67	728	finally
    //   69	123	728	finally
    //   123	174	728	finally
    //   174	226	728	finally
    //   226	245	728	finally
    //   283	292	728	finally
    //   307	317	728	finally
    //   319	336	728	finally
    //   339	362	728	finally
    //   369	443	728	finally
    //   451	476	728	finally
    //   476	497	728	finally
    //   506	560	728	finally
    //   560	569	728	finally
    //   574	601	728	finally
    //   665	675	728	finally
    //   680	693	728	finally
    //   693	725	728	finally
    //   735	755	728	finally
    //   755	764	728	finally
    //   764	784	728	finally
    //   795	810	728	finally
    //   820	823	728	finally
    //   828	831	728	finally
    //   836	839	728	finally
    //   839	863	728	finally
    //   863	882	728	finally
    //   764	784	787	java/lang/NullPointerException
    //   601	611	815	finally
    //   615	634	815	finally
    //   639	650	815	finally
    //   792	795	815	finally
    //   817	820	815	finally
    //   245	269	823	finally
    //   269	283	823	finally
    //   825	828	823	finally
    //   292	307	831	finally
    //   833	836	831	finally
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
    int k = 1024;
    if (this.mAVDecode.audioParam.channels <= 1) {}
    int n;
    for (int j = 2;; j = 3)
    {
      n = this.mAVDecode.audioParam.sample_rate;
      if (n > 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(TAG + this.ID, 2, "initAudioTrack(), sampleRateInHz=" + n + ", <= 0, return...");
      }
      return;
    }
    int m = AudioTrack.getMinBufferSize(n, j, 2);
    int i = m;
    if (m < 1024)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "initAudioTrack(), minBufSize=" + m + " < 1024, so mutiply 2");
      }
      m *= 2;
      i = m;
      if (m < 1024) {
        i = k;
      }
    }
    for (;;)
    {
      k = i * 2;
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "initAudioTrack(): cost=channelConfig: " + j + ", sampleRateInHz: " + n + ", minBufSize: " + i + ", primePlaySize: " + k);
      }
      this.mAudioTrack = new AudioTrack(3, n, j, 2, k, 1);
      return;
    }
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
  
  public void showOOM(String paramString)
  {
    sUIHandler.post(new NativeVideoImage.1(this, paramString));
  }
  
  void startPlayAudio()
  {
    if ((this.mPlayAudioThread == null) || (this.mAudioThreadFinish))
    {
      this.mPlayAudioThread = new NativeVideoImage.PlayAudioThread(this, "AudioPlayThread");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage
 * JD-Core Version:    0.7.0.1
 */
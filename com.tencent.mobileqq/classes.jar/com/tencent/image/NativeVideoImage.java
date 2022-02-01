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
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
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
  public static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
  public static String TAG = "URLDrawable_" + NativeVideoImage.class.getSimpleName() + "_";
  static final String TAG_AUDIO = TAG + "_Audio";
  private static int TIME_BASE = 12;
  static Handler sDecodeHander;
  static HandlerThread sDecodeThread;
  static boolean sLibLoaded;
  static Handler sReleaseHandler;
  protected static Handler sUIHandler = new Handler(Looper.getMainLooper());
  static boolean sVideoEngineAvaliable;
  static HandlerThread sWorkThread;
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
    sLibLoaded = false;
    sVideoEngineAvaliable = true;
    sWorkThread = new HandlerThread("Video-Release-Task");
    sWorkThread.start();
    sReleaseHandler = new Handler(sWorkThread.getLooper());
    sDecodeThread = new HandlerThread("Video-Decode-Thread");
    sDecodeThread.start();
    sDecodeHander = new Handler(sDecodeThread.getLooper());
  }
  
  public NativeVideoImage(File paramFile, boolean paramBoolean)
  {
    this(paramFile, paramBoolean, 0, 0, null);
  }
  
  public NativeVideoImage(File paramFile, boolean paramBoolean, int paramInt1, int paramInt2, Object paramObject)
  {
    this.mSrcVideoFile = paramFile.getAbsolutePath();
    this.ID = this.mSrcVideoFile.hashCode();
    if ((URLDrawable.depImp.mLog.isColorLevel()) && (paramObject != null)) {
      URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "NativeVideoImage(): cacheFirstFrame=" + paramBoolean + ", maxWidth= " + paramInt1 + ", maxHeight= " + paramInt2 + ", videoParams= " + paramObject.toString());
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
        if ((this.mAVDecode == null) && (URLDrawable.depImp.mLog.isColorLevel())) {
          URLDrawable.depImp.mLog.e(TAG + this.ID, 2, "NativeVideoImage()[mAVDecode == null]....");
        }
        this.mRotation = this.mAVDecode.videoParam.rotation;
        int n = this.mAVDecode.videoParam.fps_den;
        int i1 = this.mAVDecode.videoParam.fps_num;
        float f3 = i1 * 1.0F / n;
        if (this.mAVDecode.audioParam.errcode == -106)
        {
          this.mPlayAudioFrame = false;
          if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.e(TAG + this.ID, 2, "NativeVideoImage() => VIDEO_NO_MEDIA_DATA_ERR, 不存在音频数据, mSrcVideoFile=" + this.mSrcVideoFile);
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
              break label1212;
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
        if (URLDrawable.depImp.mLog.isColorLevel())
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
          URLDrawable.depImp.mLog.d(TAG + this.ID, 2, " NativeVideoImage(): " + paramFile.toString());
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
          if (URLDrawable.depImp.mLog.isColorLevel())
          {
            URLDrawable.depImp.mLog.e(TAG + this.ID, 2, "NativeVideoImage()[newDecodeUncatched]", paramObject);
            continue;
            label1212:
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
        int i = ShortVideoSoLoad.LoadExtractedShortVideo("AVCodec");
        if (i != 0) {
          continue;
        }
        sVideoEngineAvaliable = true;
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.d(TAG, 2, "loadLibrary(): status=" + i);
        }
      }
      catch (Throwable paramContext)
      {
        if (!URLDrawable.depImp.mLog.isColorLevel()) {
          continue;
        }
        URLDrawable.depImp.mLog.e(TAG, 2, "System.loadLibrary(AVCodec) failed");
        paramContext.printStackTrace();
        continue;
      }
      sLibLoaded = true;
      return;
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.e(TAG, 2, "loadLibrary() failure....");
      }
    }
  }
  
  /* Error */
  protected void applyNextFrame()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 487	java/lang/System:currentTimeMillis	()J
    //   5: lstore_1
    //   6: new 489	android/graphics/Canvas
    //   9: dup
    //   10: aload_0
    //   11: getfield 491	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   14: invokespecial 494	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   17: astore 5
    //   19: aload_0
    //   20: getfield 491	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   23: iconst_0
    //   24: invokevirtual 499	android/graphics/Bitmap:eraseColor	(I)V
    //   27: new 501	android/graphics/Paint
    //   30: dup
    //   31: invokespecial 502	android/graphics/Paint:<init>	()V
    //   34: astore 6
    //   36: aload_0
    //   37: getfield 165	com/tencent/image/NativeVideoImage:mDefaultRoundCorner	F
    //   40: fconst_0
    //   41: fcmpl
    //   42: ifle +71 -> 113
    //   45: aload 6
    //   47: iconst_1
    //   48: invokevirtual 505	android/graphics/Paint:setAntiAlias	(Z)V
    //   51: aload 6
    //   53: iconst_1
    //   54: invokevirtual 508	android/graphics/Paint:setFilterBitmap	(Z)V
    //   57: aload 5
    //   59: new 510	android/graphics/RectF
    //   62: dup
    //   63: fconst_0
    //   64: fconst_0
    //   65: aload_0
    //   66: getfield 491	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   69: invokevirtual 513	android/graphics/Bitmap:getWidth	()I
    //   72: i2f
    //   73: aload_0
    //   74: getfield 491	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   77: invokevirtual 516	android/graphics/Bitmap:getHeight	()I
    //   80: i2f
    //   81: invokespecial 519	android/graphics/RectF:<init>	(FFFF)V
    //   84: aload_0
    //   85: getfield 165	com/tencent/image/NativeVideoImage:mDefaultRoundCorner	F
    //   88: aload_0
    //   89: getfield 165	com/tencent/image/NativeVideoImage:mDefaultRoundCorner	F
    //   92: aload 6
    //   94: invokevirtual 523	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   97: aload 6
    //   99: new 525	android/graphics/PorterDuffXfermode
    //   102: dup
    //   103: getstatic 531	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   106: invokespecial 534	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   109: invokevirtual 538	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   112: pop
    //   113: aload_0
    //   114: getfield 364	com/tencent/image/NativeVideoImage:mRotation	I
    //   117: ifeq +189 -> 306
    //   120: new 540	android/graphics/Matrix
    //   123: dup
    //   124: invokespecial 541	android/graphics/Matrix:<init>	()V
    //   127: astore 7
    //   129: aload 7
    //   131: aload_0
    //   132: getfield 364	com/tencent/image/NativeVideoImage:mRotation	I
    //   135: i2f
    //   136: aload_0
    //   137: getfield 543	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   140: invokevirtual 513	android/graphics/Bitmap:getWidth	()I
    //   143: iconst_2
    //   144: idiv
    //   145: i2f
    //   146: aload_0
    //   147: getfield 543	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   150: invokevirtual 516	android/graphics/Bitmap:getHeight	()I
    //   153: iconst_2
    //   154: idiv
    //   155: i2f
    //   156: invokevirtual 547	android/graphics/Matrix:postRotate	(FFF)Z
    //   159: pop
    //   160: aload 7
    //   162: aload_0
    //   163: getfield 491	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   166: invokevirtual 513	android/graphics/Bitmap:getWidth	()I
    //   169: aload_0
    //   170: getfield 543	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   173: invokevirtual 513	android/graphics/Bitmap:getWidth	()I
    //   176: isub
    //   177: i2f
    //   178: fconst_2
    //   179: fdiv
    //   180: aload_0
    //   181: getfield 491	com/tencent/image/NativeVideoImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   184: invokevirtual 516	android/graphics/Bitmap:getHeight	()I
    //   187: aload_0
    //   188: getfield 543	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   191: invokevirtual 516	android/graphics/Bitmap:getHeight	()I
    //   194: isub
    //   195: i2f
    //   196: fconst_2
    //   197: fdiv
    //   198: invokevirtual 551	android/graphics/Matrix:postTranslate	(FF)Z
    //   201: pop
    //   202: aload 5
    //   204: aload_0
    //   205: getfield 543	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   208: aload 7
    //   210: aload 6
    //   212: invokevirtual 555	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   215: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   218: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   221: invokeinterface 256 1 0
    //   226: ifeq +77 -> 303
    //   229: aload_0
    //   230: getfield 163	com/tencent/image/NativeVideoImage:debug	Z
    //   233: ifeq +70 -> 303
    //   236: invokestatic 487	java/lang/System:currentTimeMillis	()J
    //   239: lstore_3
    //   240: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   243: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   246: new 85	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   253: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   256: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: getfield 203	com/tencent/image/NativeVideoImage:ID	I
    //   263: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: iconst_2
    //   270: new 85	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 557
    //   280: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: lload_3
    //   284: lload_1
    //   285: lsub
    //   286: invokevirtual 560	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   289: ldc_w 562
    //   292: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokeinterface 275 4 0
    //   303: aload_0
    //   304: monitorexit
    //   305: return
    //   306: aload 5
    //   308: aload_0
    //   309: getfield 543	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   312: fconst_0
    //   313: fconst_0
    //   314: aload 6
    //   316: invokevirtual 565	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   319: goto -104 -> 215
    //   322: astore 5
    //   324: aload_0
    //   325: monitorexit
    //   326: aload 5
    //   328: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	this	NativeVideoImage
    //   5	280	1	l1	long
    //   239	45	3	l2	long
    //   17	290	5	localCanvas	Canvas
    //   322	5	5	localObject	Object
    //   34	281	6	localPaint	Paint
    //   127	82	7	localMatrix	android.graphics.Matrix
    // Exception table:
    //   from	to	target	type
    //   2	113	322	finally
    //   113	215	322	finally
    //   215	303	322	finally
    //   306	319	322	finally
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
    if ((URLDrawable.depImp.mLog.isColorLevel()) && (this.debug)) {
      URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "doApplyNextFrame: invalidateSelf, index:" + paramInt);
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
    if ((URLDrawable.depImp.mLog.isColorLevel()) && (this.debug)) {
      URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "======>draw():start");
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
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "draw(): No animation");
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
      if ((!URLDrawable.depImp.mLog.isColorLevel()) || ((!this.debug) && (l2 <= TIME_BASE))) {
        break;
      }
      URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "<======draw() end, cost: " + l2 + " ms, drawCost:" + l1);
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
          if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG + this.ID, 1, "executeNewTask(), fps_den = " + k + ",fps_num = " + m + ",fpsDuration = " + i + ",fps = " + f + " ,mTotalDeviation=" + this.mTotalDeviation + " ,totalFrame=" + this.mAVDecode.videoParam.frame_count);
          }
          if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG + this.ID, 1, "executeNewTask()[], mOption.wantedFps = " + this.mOption.wantedFps + " fps=" + f);
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
                if (URLDrawable.depImp.mLog.isColorLevel())
                {
                  URLDrawable.depImp.mLog.d(TAG + this.ID, 1, "executeNewTask(), mOption.wantedFps = " + this.mOption.wantedFps + ",fpsDuration = " + i + ",fps = " + f + ",mVideoParams.mRequestedFPS = " + this.mVideoParams.mRequestedFPS + " ,mTotalDeviation=" + this.mTotalDeviation);
                  j = i;
                }
              }
            }
          }
          if (j <= 0) {
            break label1059;
          }
          this.mVideoFrameDuration = j;
          if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.e(TAG + this.ID, 1, "executeNewTask(),1 mVideoFrameDuration = " + this.mVideoFrameDuration);
          }
          l2 = l1;
          if (l1 > 100L) {
            l2 = 100L;
          }
          l3 = paramLong + l2;
          l1 = l3;
          if (l3 >= this.mVideoFrameDuration)
          {
            if ((URLDrawable.depImp.mLog.isColorLevel()) && (this.debug)) {
              URLDrawable.depImp.mLog.e(TAG + this.ID, 1, "executeNewTask(), overhead:" + l3 + ", >= frameDuration overhead=" + l3 + " mVideoFrameDuration=" + this.mVideoFrameDuration);
            }
            l1 = this.mVideoFrameDuration;
          }
          l3 = SystemClock.uptimeMillis();
          l4 = this.mVideoFrameDuration;
          sDecodeHander.post(new NativeVideoImage.DecodeFrameJob(this, l3 + l4 - l1));
          if ((URLDrawable.depImp.mLog.isColorLevel()) && (this.debug)) {
            URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "executeNewTask(), duration: " + this.mVideoFrameDuration + ", drawCost: " + paramLong + ",refreshCost:" + l2 + ",sync:" + true);
          }
        }
      }
    }
    label1059:
    while (!URLDrawable.depImp.mLog.isColorLevel()) {
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
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          URLDrawable.depImp.mLog.e(TAG + this.ID, 1, "executeNewTask(), error!!  mAVDecode.videoParam.fps_num = " + this.mAVDecode.videoParam.fps_num + ", srcFilePath = " + this.mSrcVideoFile);
          i = j;
          continue;
          if (this.mAVDecode.videoParam.duration > 0)
          {
            this.mVideoFrameDuration = this.mAVDecode.videoParam.duration;
            if (URLDrawable.depImp.mLog.isColorLevel()) {
              URLDrawable.depImp.mLog.e(TAG + this.ID, 1, "executeNewTask(),2 mVideoFrameDuration = " + this.mVideoFrameDuration);
            }
          }
          else
          {
            this.mVideoFrameDuration = 50;
            URLDrawable.depImp.mLog.e(TAG, 1, "executeNewTask(), error... mVideoFrameDuration: " + this.mVideoFrameDuration + ", mAVDecode.videoParam.duration " + this.mAVDecode.videoParam.duration + ", fpsDuration: " + j);
            continue;
            if ((this.mAVDecode == null) || (this.mAVDecode.videoParam == null) || (this.mAVDecode.videoParam.duration <= 0) || (this.mVideoFrameDuration == this.mAVDecode.videoParam.duration)) {}
          }
        }
      }
    }
    URLDrawable.depImp.mLog.e(TAG + this.ID, 1, "executeNewTask(): mDecodeNextFrameEnd false");
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
    //   7: invokestatic 487	java/lang/System:currentTimeMillis	()J
    //   10: lstore 5
    //   12: aload_0
    //   13: getfield 346	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   16: astore 9
    //   18: aload 9
    //   20: getfield 357	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   23: getfield 715	com/tencent/video/decode/AVVideoParam:width	I
    //   26: istore_1
    //   27: aload 9
    //   29: getfield 357	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   32: getfield 717	com/tencent/video/decode/AVVideoParam:height	I
    //   35: istore_2
    //   36: invokestatic 487	java/lang/System:currentTimeMillis	()J
    //   39: lstore 7
    //   41: aload_0
    //   42: getfield 183	com/tencent/image/NativeVideoImage:mResetFlag	Z
    //   45: ifeq +454 -> 499
    //   48: aload_0
    //   49: iconst_0
    //   50: putfield 183	com/tencent/image/NativeVideoImage:mResetFlag	Z
    //   53: new 160	com/tencent/video/decode/AVideoException
    //   56: dup
    //   57: bipush 146
    //   59: iconst_m1
    //   60: ldc_w 728
    //   63: invokespecial 731	com/tencent/video/decode/AVideoException:<init>	(IILjava/lang/String;)V
    //   66: athrow
    //   67: astore 9
    //   69: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   72: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   75: invokeinterface 256 1 0
    //   80: ifeq +59 -> 139
    //   83: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   86: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   89: new 85	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   96: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   99: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload_0
    //   103: getfield 203	com/tencent/image/NativeVideoImage:ID	I
    //   106: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: iconst_2
    //   113: new 85	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 733
    //   123: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 9
    //   128: invokevirtual 736	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokeinterface 275 4 0
    //   139: aload 9
    //   141: getfield 739	com/tencent/video/decode/AVideoException:mErrCode	I
    //   144: bipush 146
    //   146: if_icmpne +827 -> 973
    //   149: aload_0
    //   150: iconst_1
    //   151: putfield 195	com/tencent/image/NativeVideoImage:mVideoDecodeFinish	Z
    //   154: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   157: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   160: invokeinterface 256 1 0
    //   165: ifeq +41 -> 206
    //   168: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   171: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   174: new 85	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   181: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   184: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload_0
    //   188: getfield 203	com/tencent/image/NativeVideoImage:ID	I
    //   191: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: iconst_2
    //   198: ldc_w 741
    //   201: invokeinterface 275 4 0
    //   206: aload_0
    //   207: getfield 187	com/tencent/image/NativeVideoImage:mPlayAudioOnceFinished	Z
    //   210: ifne +48 -> 258
    //   213: aload_0
    //   214: iconst_1
    //   215: putfield 187	com/tencent/image/NativeVideoImage:mPlayAudioOnceFinished	Z
    //   218: aload_0
    //   219: getfield 283	com/tencent/image/NativeVideoImage:mVideoParams	Lcom/tencent/image/VideoDrawable$VideoDrawableParams;
    //   222: astore 9
    //   224: aload_0
    //   225: iconst_0
    //   226: putfield 185	com/tencent/image/NativeVideoImage:mPlayAudioFrame	Z
    //   229: aload 9
    //   231: iconst_0
    //   232: putfield 284	com/tencent/image/VideoDrawable$VideoDrawableParams:mPlayAudioFrame	Z
    //   235: aload_0
    //   236: getfield 294	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   239: iconst_1
    //   240: putfield 303	com/tencent/video/decode/AVDecodeOption:ignore_audio	Z
    //   243: getstatic 124	com/tencent/image/NativeVideoImage:sUIHandler	Landroid/os/Handler;
    //   246: new 743	com/tencent/image/NativeVideoImage$2
    //   249: dup
    //   250: aload_0
    //   251: invokespecial 746	com/tencent/image/NativeVideoImage$2:<init>	(Lcom/tencent/image/NativeVideoImage;)V
    //   254: invokevirtual 671	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   257: pop
    //   258: aload_0
    //   259: getfield 283	com/tencent/image/NativeVideoImage:mVideoParams	Lcom/tencent/image/VideoDrawable$VideoDrawableParams;
    //   262: getfield 284	com/tencent/image/VideoDrawable$VideoDrawableParams:mPlayAudioFrame	Z
    //   265: ifeq +662 -> 927
    //   268: aload_0
    //   269: getfield 208	com/tencent/image/NativeVideoImage:mLock	Ljava/lang/Object;
    //   272: astore 9
    //   274: aload 9
    //   276: monitorenter
    //   277: getstatic 145	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   280: ifnull +21 -> 301
    //   283: getstatic 145	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   286: new 696	com/tencent/image/NativeVideoImage$ReleaseTask
    //   289: dup
    //   290: aload_0
    //   291: getfield 346	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   294: invokespecial 699	com/tencent/image/NativeVideoImage$ReleaseTask:<init>	(Lcom/tencent/video/decode/AbstractAVDecode;)V
    //   297: invokevirtual 671	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   300: pop
    //   301: aload_0
    //   302: aload_0
    //   303: getfield 294	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   306: invokestatic 749	com/tencent/video/decode/AVDecodeFactory:newDecode	(Lcom/tencent/video/decode/AVDecodeOption;)Lcom/tencent/video/decode/AbstractAVDecode;
    //   309: putfield 346	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   312: aload 9
    //   314: monitorexit
    //   315: aload_0
    //   316: getfield 225	com/tencent/image/NativeVideoImage:mAudioLock	Ljava/lang/Object;
    //   319: astore 9
    //   321: aload 9
    //   323: monitorenter
    //   324: aload_0
    //   325: iconst_1
    //   326: putfield 195	com/tencent/image/NativeVideoImage:mVideoDecodeFinish	Z
    //   329: aload_0
    //   330: getfield 225	com/tencent/image/NativeVideoImage:mAudioLock	Ljava/lang/Object;
    //   333: invokevirtual 575	java/lang/Object:notifyAll	()V
    //   336: aload 9
    //   338: monitorexit
    //   339: aload_0
    //   340: aload_0
    //   341: getfield 177	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   344: iconst_1
    //   345: iadd
    //   346: putfield 177	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   349: iconst_1
    //   350: istore_3
    //   351: aload_0
    //   352: getfield 221	com/tencent/image/NativeVideoImage:mCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   355: iconst_1
    //   356: invokevirtual 753	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   359: pop
    //   360: invokestatic 487	java/lang/System:currentTimeMillis	()J
    //   363: lload 5
    //   365: lsub
    //   366: lstore 5
    //   368: iload_3
    //   369: istore 4
    //   371: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   374: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   377: invokeinterface 256 1 0
    //   382: ifeq +112 -> 494
    //   385: aload_0
    //   386: getfield 163	com/tencent/image/NativeVideoImage:debug	Z
    //   389: ifne +20 -> 409
    //   392: lload 5
    //   394: getstatic 153	com/tencent/image/NativeVideoImage:TIME_BASE	I
    //   397: i2l
    //   398: lcmp
    //   399: ifgt +10 -> 409
    //   402: iload_3
    //   403: istore 4
    //   405: iload_3
    //   406: ifne +88 -> 494
    //   409: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   412: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   415: new 85	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   422: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   425: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_0
    //   429: getfield 203	com/tencent/image/NativeVideoImage:ID	I
    //   432: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   435: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: iconst_2
    //   439: new 85	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 755
    //   449: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: lload 5
    //   454: invokevirtual 560	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   457: ldc_w 757
    //   460: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload_0
    //   464: getfield 221	com/tencent/image/NativeVideoImage:mCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   467: invokevirtual 760	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   470: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   473: ldc_w 762
    //   476: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: iload_3
    //   480: invokevirtual 264	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   483: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokeinterface 275 4 0
    //   491: iload_3
    //   492: istore 4
    //   494: aload_0
    //   495: monitorexit
    //   496: iload 4
    //   498: ireturn
    //   499: iload_1
    //   500: aload_0
    //   501: getfield 173	com/tencent/image/NativeVideoImage:mReqWidth	I
    //   504: if_icmpne +217 -> 721
    //   507: iload_2
    //   508: aload_0
    //   509: getfield 175	com/tencent/image/NativeVideoImage:mReqHeight	I
    //   512: if_icmpne +209 -> 721
    //   515: aload 9
    //   517: aload_0
    //   518: getfield 543	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   521: invokevirtual 765	com/tencent/video/decode/AbstractAVDecode:seekToNextFrame	(Landroid/graphics/Bitmap;)V
    //   524: invokestatic 487	java/lang/System:currentTimeMillis	()J
    //   527: lload 7
    //   529: lsub
    //   530: lstore 7
    //   532: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   535: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   538: invokeinterface 256 1 0
    //   543: ifeq +81 -> 624
    //   546: aload_0
    //   547: getfield 163	com/tencent/image/NativeVideoImage:debug	Z
    //   550: ifne +12 -> 562
    //   553: lload 7
    //   555: ldc2_w 766
    //   558: lcmp
    //   559: ifle +65 -> 624
    //   562: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   565: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   568: new 85	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   575: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   578: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload_0
    //   582: getfield 203	com/tencent/image/NativeVideoImage:ID	I
    //   585: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   588: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: iconst_2
    //   592: new 85	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   599: ldc_w 769
    //   602: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: lload 7
    //   607: invokevirtual 560	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   610: ldc_w 771
    //   613: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokeinterface 275 4 0
    //   624: aload 9
    //   626: getfield 357	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   629: getfield 774	com/tencent/video/decode/AVVideoParam:frame_index	I
    //   632: istore_2
    //   633: iload_2
    //   634: iconst_1
    //   635: if_icmpne +248 -> 883
    //   638: aload_0
    //   639: getfield 179	com/tencent/image/NativeVideoImage:mlastVideoFrameIndex	I
    //   642: iload_2
    //   643: if_icmple +240 -> 883
    //   646: aload_0
    //   647: aload_0
    //   648: getfield 181	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   651: iconst_1
    //   652: iadd
    //   653: putfield 181	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   656: aload_0
    //   657: getfield 777	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   660: astore 9
    //   662: aload 9
    //   664: monitorenter
    //   665: aload_0
    //   666: getfield 777	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   669: invokevirtual 780	java/util/ArrayList:size	()I
    //   672: iconst_1
    //   673: isub
    //   674: istore_1
    //   675: iload_1
    //   676: iflt +204 -> 880
    //   679: aload_0
    //   680: getfield 777	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   683: iload_1
    //   684: invokevirtual 783	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   687: checkcast 623	java/lang/ref/WeakReference
    //   690: invokevirtual 786	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   693: checkcast 788	com/tencent/image/VideoDrawable$OnPlayRepeatListener
    //   696: astore 10
    //   698: aload 10
    //   700: ifnull +14 -> 714
    //   703: aload 10
    //   705: aload_0
    //   706: getfield 181	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   709: invokeinterface 791 2 0
    //   714: iload_1
    //   715: iconst_1
    //   716: isub
    //   717: istore_1
    //   718: goto -43 -> 675
    //   721: iload_2
    //   722: ifeq +7 -> 729
    //   725: iload_1
    //   726: ifne +97 -> 823
    //   729: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   732: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   735: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   738: iconst_2
    //   739: ldc_w 793
    //   742: invokeinterface 351 4 0
    //   747: goto -253 -> 494
    //   750: astore 9
    //   752: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   755: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   758: invokeinterface 256 1 0
    //   763: ifeq +10 -> 773
    //   766: aload_0
    //   767: ldc_w 794
    //   770: invokevirtual 797	com/tencent/image/NativeVideoImage:showOOM	(Ljava/lang/String;)V
    //   773: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   776: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   779: new 85	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   786: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   789: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload_0
    //   793: getfield 203	com/tencent/image/NativeVideoImage:ID	I
    //   796: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   799: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: iconst_1
    //   803: ldc_w 799
    //   806: aload 9
    //   808: invokeinterface 444 5 0
    //   813: goto -462 -> 351
    //   816: astore 9
    //   818: aload_0
    //   819: monitorexit
    //   820: aload 9
    //   822: athrow
    //   823: aload_0
    //   824: getfield 189	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   827: ifnonnull +16 -> 843
    //   830: aload_0
    //   831: iload_1
    //   832: iload_2
    //   833: aload_0
    //   834: getfield 169	com/tencent/image/NativeVideoImage:mCurrentConfig	Landroid/graphics/Bitmap$Config;
    //   837: invokestatic 803	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   840: putfield 189	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   843: aload 9
    //   845: aload_0
    //   846: getfield 189	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   849: invokevirtual 765	com/tencent/video/decode/AbstractAVDecode:seekToNextFrame	(Landroid/graphics/Bitmap;)V
    //   852: aload_0
    //   853: aload_0
    //   854: getfield 189	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   857: aload_0
    //   858: getfield 173	com/tencent/image/NativeVideoImage:mReqWidth	I
    //   861: aload_0
    //   862: getfield 175	com/tencent/image/NativeVideoImage:mReqHeight	I
    //   865: iconst_1
    //   866: invokestatic 807	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   869: putfield 543	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   872: goto -348 -> 524
    //   875: astore 10
    //   877: goto -353 -> 524
    //   880: aload 9
    //   882: monitorexit
    //   883: aload_0
    //   884: iload_2
    //   885: putfield 179	com/tencent/image/NativeVideoImage:mlastVideoFrameIndex	I
    //   888: aload_0
    //   889: aload_0
    //   890: getfield 177	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   893: iconst_1
    //   894: iadd
    //   895: putfield 177	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   898: iconst_1
    //   899: istore_3
    //   900: goto -549 -> 351
    //   903: astore 10
    //   905: aload 9
    //   907: monitorexit
    //   908: aload 10
    //   910: athrow
    //   911: astore 10
    //   913: aload 9
    //   915: monitorexit
    //   916: aload 10
    //   918: athrow
    //   919: astore 10
    //   921: aload 9
    //   923: monitorexit
    //   924: aload 10
    //   926: athrow
    //   927: getstatic 145	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   930: ifnull +21 -> 951
    //   933: getstatic 145	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   936: new 696	com/tencent/image/NativeVideoImage$ReleaseTask
    //   939: dup
    //   940: aload_0
    //   941: getfield 346	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   944: invokespecial 699	com/tencent/image/NativeVideoImage$ReleaseTask:<init>	(Lcom/tencent/video/decode/AbstractAVDecode;)V
    //   947: invokevirtual 671	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   950: pop
    //   951: aload_0
    //   952: getfield 294	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   955: iconst_1
    //   956: putfield 300	com/tencent/video/decode/AVDecodeOption:cycle	Z
    //   959: aload_0
    //   960: aload_0
    //   961: getfield 294	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   964: invokestatic 749	com/tencent/video/decode/AVDecodeFactory:newDecode	(Lcom/tencent/video/decode/AVDecodeOption;)Lcom/tencent/video/decode/AbstractAVDecode;
    //   967: putfield 346	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   970: goto -631 -> 339
    //   973: iconst_0
    //   974: istore_3
    //   975: goto -624 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	978	0	this	NativeVideoImage
    //   26	806	1	i	int
    //   35	850	2	j	int
    //   4	971	3	bool1	boolean
    //   1	496	4	bool2	boolean
    //   10	443	5	l1	long
    //   39	567	7	l2	long
    //   16	12	9	localAbstractAVDecode	AbstractAVDecode
    //   67	73	9	localAVideoException	AVideoException
    //   750	57	9	localOutOfMemoryError	OutOfMemoryError
    //   816	106	9	localObject2	Object
    //   696	8	10	localOnPlayRepeatListener	VideoDrawable.OnPlayRepeatListener
    //   875	1	10	localNullPointerException	java.lang.NullPointerException
    //   903	6	10	localObject3	Object
    //   911	6	10	localObject4	Object
    //   919	6	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   36	67	67	com/tencent/video/decode/AVideoException
    //   499	524	67	com/tencent/video/decode/AVideoException
    //   524	553	67	com/tencent/video/decode/AVideoException
    //   562	624	67	com/tencent/video/decode/AVideoException
    //   624	633	67	com/tencent/video/decode/AVideoException
    //   638	665	67	com/tencent/video/decode/AVideoException
    //   729	747	67	com/tencent/video/decode/AVideoException
    //   823	843	67	com/tencent/video/decode/AVideoException
    //   843	852	67	com/tencent/video/decode/AVideoException
    //   852	872	67	com/tencent/video/decode/AVideoException
    //   883	898	67	com/tencent/video/decode/AVideoException
    //   908	911	67	com/tencent/video/decode/AVideoException
    //   12	36	750	java/lang/OutOfMemoryError
    //   36	67	750	java/lang/OutOfMemoryError
    //   69	139	750	java/lang/OutOfMemoryError
    //   139	206	750	java/lang/OutOfMemoryError
    //   206	258	750	java/lang/OutOfMemoryError
    //   258	277	750	java/lang/OutOfMemoryError
    //   315	324	750	java/lang/OutOfMemoryError
    //   339	349	750	java/lang/OutOfMemoryError
    //   499	524	750	java/lang/OutOfMemoryError
    //   524	553	750	java/lang/OutOfMemoryError
    //   562	624	750	java/lang/OutOfMemoryError
    //   624	633	750	java/lang/OutOfMemoryError
    //   638	665	750	java/lang/OutOfMemoryError
    //   729	747	750	java/lang/OutOfMemoryError
    //   823	843	750	java/lang/OutOfMemoryError
    //   843	852	750	java/lang/OutOfMemoryError
    //   852	872	750	java/lang/OutOfMemoryError
    //   883	898	750	java/lang/OutOfMemoryError
    //   908	911	750	java/lang/OutOfMemoryError
    //   916	919	750	java/lang/OutOfMemoryError
    //   924	927	750	java/lang/OutOfMemoryError
    //   927	951	750	java/lang/OutOfMemoryError
    //   951	970	750	java/lang/OutOfMemoryError
    //   7	12	816	finally
    //   12	36	816	finally
    //   36	67	816	finally
    //   69	139	816	finally
    //   139	206	816	finally
    //   206	258	816	finally
    //   258	277	816	finally
    //   315	324	816	finally
    //   339	349	816	finally
    //   351	368	816	finally
    //   371	402	816	finally
    //   409	491	816	finally
    //   499	524	816	finally
    //   524	553	816	finally
    //   562	624	816	finally
    //   624	633	816	finally
    //   638	665	816	finally
    //   729	747	816	finally
    //   752	773	816	finally
    //   773	813	816	finally
    //   823	843	816	finally
    //   843	852	816	finally
    //   852	872	816	finally
    //   883	898	816	finally
    //   908	911	816	finally
    //   916	919	816	finally
    //   924	927	816	finally
    //   927	951	816	finally
    //   951	970	816	finally
    //   852	872	875	java/lang/NullPointerException
    //   665	675	903	finally
    //   679	698	903	finally
    //   703	714	903	finally
    //   880	883	903	finally
    //   905	908	903	finally
    //   277	301	911	finally
    //   301	315	911	finally
    //   913	916	911	finally
    //   324	339	919	finally
    //   921	924	919	finally
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
          if (URLDrawable.depImp.mLog.isColorLevel())
          {
            ILog localILog = URLDrawable.depImp.mLog;
            String str = TAG + this.ID;
            StringBuilder localStringBuilder = new StringBuilder().append("use mCurFrameBitmapBuffer: ");
            if (this.mCurFrameBitmapBuffer != null) {
              bool = true;
            }
            localILog.d(str, 2, bool);
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
              if (URLDrawable.depImp.mLog.isColorLevel()) {
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
                  if (URLDrawable.depImp.mLog.isColorLevel()) {
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
          } while (!URLDrawable.depImp.mLog.isColorLevel());
          showOOM("create mCurFrameBitmap");
        }
        catch (OutOfMemoryError localOutOfMemoryError4)
        {
          while (!URLDrawable.depImp.mLog.isColorLevel()) {}
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
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.e(TAG + this.ID, 2, "initAudioTrack(), sampleRateInHz=" + n + ", <= 0, return...");
      }
      return;
    }
    int m = AudioTrack.getMinBufferSize(n, j, 2);
    int i = m;
    if (m < 1024)
    {
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "initAudioTrack(), minBufSize=" + m + " < 1024, so mutiply 2");
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
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "initAudioTrack(): cost=channelConfig: " + j + ", sampleRateInHz: " + n + ", minBufSize: " + i + ", primePlaySize: " + k);
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
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(TAG, 2, "resetAndPlayAudioOnce >>>");
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
        URLDrawable.depImp.mLog.e(TAG, 1, "AVideoException happens resetAndPlayAudioOnce...", localAVideoException);
      }
    }
  }
  
  public void resetAndPlayAudioOnce()
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(TAG, 2, "resetAndPlayAudioOnce >>>");
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
          URLDrawable.depImp.mLog.e(TAG, 1, "AVideoException happens resetAndPlayAudioOnce...", localAVideoException);
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
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(TAG + this.ID, 2, "stopPlayAudio()");
    }
    this.mPlayAudioFrame = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage
 * JD-Core Version:    0.7.0.1
 */
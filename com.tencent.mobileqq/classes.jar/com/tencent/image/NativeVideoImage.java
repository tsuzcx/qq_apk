package com.tencent.image;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportAudioTrack;
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
  public static String TAG;
  static final String TAG_AUDIO;
  private static int TIME_BASE = 12;
  static Handler sDecodeHander;
  static HandlerThread sDecodeThread;
  static boolean sLibLoaded;
  static Handler sReleaseHandler;
  protected static Handler sUIHandler;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("URLDrawable_");
    localStringBuilder.append(NativeVideoImage.class.getSimpleName());
    localStringBuilder.append("_");
    TAG = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append("_Audio");
    TAG_AUDIO = localStringBuilder.toString();
    sUIHandler = new Handler(Looper.getMainLooper());
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
    Object localObject1;
    Object localObject2;
    if ((URLDrawable.depImp.mLog.isColorLevel()) && (paramObject != null))
    {
      localObject1 = URLDrawable.depImp.mLog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(TAG);
      ((StringBuilder)localObject2).append(this.ID);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NativeVideoImage(): cacheFirstFrame=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", maxWidth= ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", maxHeight= ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", videoParams= ");
      localStringBuilder.append(paramObject.toString());
      ((ILog)localObject1).d((String)localObject2, 2, localStringBuilder.toString());
    }
    if ((paramObject != null) && (VideoDrawable.VideoDrawableParams.class.isInstance(paramObject))) {
      this.mVideoParams = ((VideoDrawable.VideoDrawableParams)paramObject);
    } else {
      if (paramObject != null) {
        break label1336;
      }
    }
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
    paramObject = this.mOption;
    paramObject.cycle = bool;
    paramObject.ignore_audio = (this.mPlayAudioFrame ^ true);
    paramObject = this.mOption;
    paramObject.only_keyframe = false;
    paramObject.filename = this.mSrcVideoFile;
    paramObject.audioFormat = 65281;
    paramObject.wantedFps = this.mVideoParams.mRequestedFPS;
    this.mOption.mDecodeType = this.mVideoParams.mDecodeType;
    this.mOption.mVfPath = this.mVideoParams.mVfPath;
    this.mOption.mAfPath = this.mVideoParams.mAfPath;
    this.mOption.mTotalTime = this.mVideoParams.mTotalTime;
    this.mOption.mVideoFrames = this.mVideoParams.mVideoFrames;
    try
    {
      this.mAVDecode = AVDecodeFactory.newDecodeUncatched(this.mOption);
    }
    catch (AVideoException paramObject)
    {
      paramObject.printStackTrace();
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        localObject1 = URLDrawable.depImp.mLog;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(TAG);
        ((StringBuilder)localObject2).append(this.ID);
        ((ILog)localObject1).e(((StringBuilder)localObject2).toString(), 2, "NativeVideoImage()[newDecodeUncatched]", paramObject);
      }
    }
    if ((this.mAVDecode == null) && (URLDrawable.depImp.mLog.isColorLevel()))
    {
      paramObject = URLDrawable.depImp.mLog;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(TAG);
      ((StringBuilder)localObject1).append(this.ID);
      paramObject.e(((StringBuilder)localObject1).toString(), 2, "NativeVideoImage()[mAVDecode == null]....");
    }
    this.mRotation = this.mAVDecode.videoParam.rotation;
    int n = this.mAVDecode.videoParam.fps_den;
    int i1 = this.mAVDecode.videoParam.fps_num;
    float f3 = i1 * 1.0F / n;
    if (this.mAVDecode.audioParam.errcode == -106)
    {
      this.mPlayAudioFrame = false;
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramObject = URLDrawable.depImp.mLog;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(TAG);
        ((StringBuilder)localObject1).append(this.ID);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("NativeVideoImage() => VIDEO_NO_MEDIA_DATA_ERR, 不存在音频数据, mSrcVideoFile=");
        ((StringBuilder)localObject2).append(this.mSrcVideoFile);
        paramObject.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    paramFile = getFrameSize(paramFile);
    int k = paramFile.width();
    int m = paramFile.height();
    int j = k;
    int i = m;
    if (paramInt1 > 0)
    {
      j = k;
      i = m;
      if (paramInt2 > 0)
      {
        float f1 = paramInt1;
        float f4 = k;
        f1 /= f4;
        float f2 = paramInt2;
        float f5 = m;
        f2 /= f5;
        if (f1 >= f2) {
          f1 = f2;
        }
        j = k;
        i = m;
        if (f1 < 1.0F)
        {
          j = (int)(f4 * f1);
          i = (int)(f5 * f1);
        }
      }
    }
    this.mReqWidth = j;
    this.mReqHeight = i;
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      paramFile = new StringBuilder();
      paramFile.append("videoParams[ frame_count:");
      paramFile.append(this.mAVDecode.videoParam.frame_count);
      paramFile.append("\n mSrcVideoFile:");
      paramFile.append(this.mSrcVideoFile);
      paramFile.append("\n duration:");
      paramFile.append(this.mAVDecode.videoParam.duration);
      paramFile.append("\n fps_den:");
      paramFile.append(n);
      paramFile.append("\n fps_num:");
      paramFile.append(i1);
      paramFile.append("\n fps:");
      paramFile.append(f3);
      paramFile.append("\n mReqWidth:");
      paramFile.append(this.mReqWidth);
      paramFile.append("\n mReqHeight:");
      paramFile.append(this.mReqHeight);
      paramFile.append("\n mRotation:");
      paramFile.append(this.mRotation);
      paramObject = URLDrawable.depImp.mLog;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(TAG);
      ((StringBuilder)localObject1).append(this.ID);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(" NativeVideoImage(): ");
      ((StringBuilder)localObject2).append(paramFile.toString());
      paramObject.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    init(paramBoolean);
    this.mDataReport = new DataReport();
    return;
    label1336:
    paramFile = new StringBuilder();
    paramFile.append(" NativeVideoImage(): videoParams is illegal, not VideoDrawableParams, ");
    paramFile.append(paramObject.toString());
    throw new RuntimeException(paramFile.toString());
  }
  
  static void loadLibrary(Context paramContext)
  {
    if (!sLibLoaded)
    {
      try
      {
        int i = ShortVideoSoLoad.LoadExtractedShortVideo("AVCodec");
        if (i == 0) {
          sVideoEngineAvaliable = true;
        } else if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.e(TAG, 2, "loadLibrary() failure....");
        }
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          paramContext = URLDrawable.depImp.mLog;
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("loadLibrary(): status=");
          localStringBuilder.append(i);
          paramContext.d(str, 2, localStringBuilder.toString());
        }
      }
      catch (Throwable paramContext)
      {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.e(TAG, 2, "System.loadLibrary(AVCodec) failed");
        }
        paramContext.printStackTrace();
      }
      sLibLoaded = true;
    }
  }
  
  protected void applyNextFrame()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      Object localObject1 = new Canvas(this.mCurFrameBitmap);
      this.mCurFrameBitmap.eraseColor(0);
      Object localObject3 = new Paint();
      if (this.mDefaultRoundCorner > 0.0F)
      {
        ((Paint)localObject3).setAntiAlias(true);
        ((Paint)localObject3).setFilterBitmap(true);
        ((Canvas)localObject1).drawRoundRect(new RectF(0.0F, 0.0F, this.mCurFrameBitmap.getWidth(), this.mCurFrameBitmap.getHeight()), this.mDefaultRoundCorner, this.mDefaultRoundCorner, (Paint)localObject3);
        ((Paint)localObject3).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      }
      Object localObject4;
      if (this.mRotation != 0)
      {
        localObject4 = new Matrix();
        ((Matrix)localObject4).postRotate(this.mRotation, this.mCurFrameBitmapBuffer.getWidth() / 2, this.mCurFrameBitmapBuffer.getHeight() / 2);
        ((Matrix)localObject4).postTranslate((this.mCurFrameBitmap.getWidth() - this.mCurFrameBitmapBuffer.getWidth()) / 2.0F, (this.mCurFrameBitmap.getHeight() - this.mCurFrameBitmapBuffer.getHeight()) / 2.0F);
        ((Canvas)localObject1).drawBitmap(this.mCurFrameBitmapBuffer, (Matrix)localObject4, (Paint)localObject3);
      }
      else
      {
        ((Canvas)localObject1).drawBitmap(this.mCurFrameBitmapBuffer, 0.0F, 0.0F, (Paint)localObject3);
      }
      if ((URLDrawable.depImp.mLog.isColorLevel()) && (this.debug))
      {
        long l2 = System.currentTimeMillis();
        localObject1 = URLDrawable.depImp.mLog;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(TAG);
        ((StringBuilder)localObject3).append(this.ID);
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("applyNextFrame, cost=");
        ((StringBuilder)localObject4).append(l2 - l1);
        ((StringBuilder)localObject4).append("ms");
        ((ILog)localObject1).d((String)localObject3, 2, ((StringBuilder)localObject4).toString());
      }
      return;
    }
    finally {}
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
    if ((URLDrawable.depImp.mLog.isColorLevel()) && (this.debug))
    {
      ILog localILog = URLDrawable.depImp.mLog;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(this.ID);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doApplyNextFrame: invalidateSelf, index:");
      localStringBuilder.append(paramInt);
      localILog.d((String)localObject, 2, localStringBuilder.toString());
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
    if ((URLDrawable.depImp.mLog.isColorLevel()) && (this.debug))
    {
      localObject = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(this.ID);
      ((ILog)localObject).d(localStringBuilder.toString(), 2, "======>draw():start");
    }
    this.drawTime = SystemClock.uptimeMillis();
    if (paramPaint != null)
    {
      paramPaint.setAntiAlias(this.mEnableAntiAlias);
      paramPaint.setFilterBitmap(this.mEnableFilter);
    }
    Object localObject = this.mCurFrameBitmap;
    if (localObject != null) {
      paramCanvas.drawBitmap((Bitmap)localObject, null, paramRect, paramPaint);
    }
    long l1 = SystemClock.uptimeMillis() - this.drawTime;
    if (!paramBoolean)
    {
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramCanvas = URLDrawable.depImp.mLog;
        paramRect = new StringBuilder();
        paramRect.append(TAG);
        paramRect.append(this.ID);
        paramCanvas.d(paramRect.toString(), 2, "draw(): No animation");
      }
      return;
    }
    if (this.mSupportGlobalPause)
    {
      if (!sPaused)
      {
        executeNewTask(l1);
        if (this.mPlayAudioFrame)
        {
          paramCanvas = this.mOption;
          if ((paramCanvas != null) && (!paramCanvas.ignore_audio)) {
            startPlayAudio();
          }
        }
      }
      else if (!this.mIsInPendingAction)
      {
        sPendingActions.add(new WeakReference(this));
        this.mIsInPendingAction = true;
      }
    }
    else
    {
      executeNewTask(l1);
      if (this.mPlayAudioFrame)
      {
        paramCanvas = this.mOption;
        if ((paramCanvas != null) && (!paramCanvas.ignore_audio)) {
          startPlayAudio();
        }
      }
    }
    l2 = System.currentTimeMillis() - l2;
    if ((URLDrawable.depImp.mLog.isColorLevel()) && ((this.debug) || (l2 > TIME_BASE)))
    {
      paramCanvas = URLDrawable.depImp.mLog;
      paramRect = new StringBuilder();
      paramRect.append(TAG);
      paramRect.append(this.ID);
      paramRect = paramRect.toString();
      paramPaint = new StringBuilder();
      paramPaint.append("<======draw() end, cost: ");
      paramPaint.append(l2);
      paramPaint.append(" ms, drawCost:");
      paramPaint.append(l1);
      paramCanvas.d(paramRect, 2, paramPaint.toString());
    }
  }
  
  protected void executeNewTask(long paramLong)
  {
    ILog localILog;
    Object localObject;
    if (this.mDecodeNextFrameEnd)
    {
      int j = 0;
      this.mDecodeNextFrameEnd = false;
      this.mVideoDecodeFinish = false;
      long l2 = 0L;
      long l3 = this.drawTime;
      long l4 = this.refreshTime;
      long l1 = l2;
      if (l3 > l4)
      {
        l1 = l2;
        if (l4 != -1L) {
          l1 = l3 - l4;
        }
      }
      int i;
      StringBuilder localStringBuilder;
      if (this.mVideoFrameDuration < 0)
      {
        int k = this.mAVDecode.videoParam.fps_den;
        int m = this.mAVDecode.videoParam.fps_num;
        if (m > 0)
        {
          this.mTotalDeviation = (k * 1000.0F / m);
          f1 = this.mTotalDeviation;
          i = (int)f1;
          this.mTotalDeviation = (f1 - i);
        }
        else
        {
          i = j;
          if (URLDrawable.depImp.mLog.isColorLevel())
          {
            localILog = URLDrawable.depImp.mLog;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(TAG);
            ((StringBuilder)localObject).append(this.ID);
            localObject = ((StringBuilder)localObject).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("executeNewTask(), error!!  mAVDecode.videoParam.fps_num = ");
            localStringBuilder.append(this.mAVDecode.videoParam.fps_num);
            localStringBuilder.append(", srcFilePath = ");
            localStringBuilder.append(this.mSrcVideoFile);
            localILog.e((String)localObject, 1, localStringBuilder.toString());
            i = j;
          }
        }
        float f1 = m * 1.0F / k;
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          localILog = URLDrawable.depImp.mLog;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(TAG);
          ((StringBuilder)localObject).append(this.ID);
          localObject = ((StringBuilder)localObject).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("executeNewTask(), fps_den = ");
          localStringBuilder.append(k);
          localStringBuilder.append(",fps_num = ");
          localStringBuilder.append(m);
          localStringBuilder.append(",fpsDuration = ");
          localStringBuilder.append(i);
          localStringBuilder.append(",fps = ");
          localStringBuilder.append(f1);
          localStringBuilder.append(" ,mTotalDeviation=");
          localStringBuilder.append(this.mTotalDeviation);
          localStringBuilder.append(" ,totalFrame=");
          localStringBuilder.append(this.mAVDecode.videoParam.frame_count);
          localILog.d((String)localObject, 1, localStringBuilder.toString());
        }
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          localILog = URLDrawable.depImp.mLog;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(TAG);
          ((StringBuilder)localObject).append(this.ID);
          localObject = ((StringBuilder)localObject).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("executeNewTask()[], mOption.wantedFps = ");
          localStringBuilder.append(this.mOption.wantedFps);
          localStringBuilder.append(" fps=");
          localStringBuilder.append(f1);
          localILog.d((String)localObject, 1, localStringBuilder.toString());
        }
        j = i;
        if (this.mOption.wantedFps != 0.0F)
        {
          j = i;
          if (this.mOption.wantedFps >= f1 / 2.0F)
          {
            j = i;
            if (this.mOption.wantedFps <= f1)
            {
              this.mTotalDeviation = (1000.0F / this.mOption.wantedFps);
              float f2 = this.mTotalDeviation;
              j = (int)f2;
              this.mTotalDeviation = (f2 - j);
              if (URLDrawable.depImp.mLog.isColorLevel())
              {
                localILog = URLDrawable.depImp.mLog;
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append(TAG);
                ((StringBuilder)localObject).append(this.ID);
                localObject = ((StringBuilder)localObject).toString();
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("executeNewTask(), mOption.wantedFps = ");
                localStringBuilder.append(this.mOption.wantedFps);
                localStringBuilder.append(",fpsDuration = ");
                localStringBuilder.append(j);
                localStringBuilder.append(",fps = ");
                localStringBuilder.append(f1);
                localStringBuilder.append(",mVideoParams.mRequestedFPS = ");
                localStringBuilder.append(this.mVideoParams.mRequestedFPS);
                localStringBuilder.append(" ,mTotalDeviation=");
                localStringBuilder.append(this.mTotalDeviation);
                localILog.d((String)localObject, 1, localStringBuilder.toString());
              }
            }
          }
        }
        if (j > 0)
        {
          this.mVideoFrameDuration = j;
          if (URLDrawable.depImp.mLog.isColorLevel())
          {
            localILog = URLDrawable.depImp.mLog;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(TAG);
            ((StringBuilder)localObject).append(this.ID);
            localObject = ((StringBuilder)localObject).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("executeNewTask(),1 mVideoFrameDuration = ");
            localStringBuilder.append(this.mVideoFrameDuration);
            localILog.e((String)localObject, 1, localStringBuilder.toString());
          }
        }
        else if (this.mAVDecode.videoParam.duration > 0)
        {
          this.mVideoFrameDuration = this.mAVDecode.videoParam.duration;
          if (URLDrawable.depImp.mLog.isColorLevel())
          {
            localILog = URLDrawable.depImp.mLog;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(TAG);
            ((StringBuilder)localObject).append(this.ID);
            localObject = ((StringBuilder)localObject).toString();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("executeNewTask(),2 mVideoFrameDuration = ");
            localStringBuilder.append(this.mVideoFrameDuration);
            localILog.e((String)localObject, 1, localStringBuilder.toString());
          }
        }
        else
        {
          this.mVideoFrameDuration = 50;
          localILog = URLDrawable.depImp.mLog;
          localObject = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("executeNewTask(), error... mVideoFrameDuration: ");
          localStringBuilder.append(this.mVideoFrameDuration);
          localStringBuilder.append(", mAVDecode.videoParam.duration ");
          localStringBuilder.append(this.mAVDecode.videoParam.duration);
          localStringBuilder.append(", fpsDuration: ");
          localStringBuilder.append(j);
          localILog.e((String)localObject, 1, localStringBuilder.toString());
        }
      }
      else if ((this.mAVDecode != null) && (this.mAVDecode.videoParam != null) && (this.mAVDecode.videoParam.duration > 0))
      {
        i = this.mVideoFrameDuration;
        i = this.mAVDecode.videoParam.duration;
      }
      l2 = 100L;
      if (l1 > 100L) {
        l1 = l2;
      }
      l3 = paramLong + l1;
      l2 = l3;
      if (l3 >= this.mVideoFrameDuration)
      {
        if ((URLDrawable.depImp.mLog.isColorLevel()) && (this.debug))
        {
          localILog = URLDrawable.depImp.mLog;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(TAG);
          ((StringBuilder)localObject).append(this.ID);
          localObject = ((StringBuilder)localObject).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("executeNewTask(), overhead:");
          localStringBuilder.append(l3);
          localStringBuilder.append(", >= frameDuration overhead=");
          localStringBuilder.append(l3);
          localStringBuilder.append(" mVideoFrameDuration=");
          localStringBuilder.append(this.mVideoFrameDuration);
          localILog.e((String)localObject, 1, localStringBuilder.toString());
        }
        l2 = this.mVideoFrameDuration;
      }
      l3 = SystemClock.uptimeMillis();
      l4 = this.mVideoFrameDuration;
      sDecodeHander.post(new NativeVideoImage.DecodeFrameJob(this, l3 + l4 - l2));
      if ((URLDrawable.depImp.mLog.isColorLevel()) && (this.debug))
      {
        localILog = URLDrawable.depImp.mLog;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(TAG);
        ((StringBuilder)localObject).append(this.ID);
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("executeNewTask(), duration: ");
        localStringBuilder.append(this.mVideoFrameDuration);
        localStringBuilder.append(", drawCost: ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(",refreshCost:");
        localStringBuilder.append(l1);
        localStringBuilder.append(",sync:");
        localStringBuilder.append(true);
        localILog.d((String)localObject, 2, localStringBuilder.toString());
      }
    }
    else if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localILog = URLDrawable.depImp.mLog;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(this.ID);
      localILog.e(((StringBuilder)localObject).toString(), 1, "executeNewTask(): mDecodeNextFrameEnd false");
    }
  }
  
  protected void finalize()
  {
    Handler localHandler = sReleaseHandler;
    if (localHandler != null) {
      localHandler.post(new NativeVideoImage.ReleaseTask(this.mAVDecode));
    }
  }
  
  @TargetApi(12)
  public int getByteSize()
  {
    long l2 = Utils.getBitmapSize(this.mCurFrameBitmap) + 0L + Utils.getBitmapSize(this.mCurFrameBitmapBuffer) + Utils.getBitmapSize(this.mFirstFrameBitmap);
    Bitmap localBitmap = this.mCompatibleBitmap;
    long l1 = l2;
    if (localBitmap != null) {
      l1 = l2 + Utils.getBitmapSize(localBitmap);
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
    Bitmap localBitmap = this.mCurFrameBitmap;
    if (localBitmap != null) {
      return localBitmap.getHeight();
    }
    return 0;
  }
  
  /* Error */
  protected boolean getNextFrame()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 487	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: iconst_0
    //   7: istore 8
    //   9: aload_0
    //   10: getfield 346	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   13: astore 9
    //   15: aload 9
    //   17: getfield 365	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   20: getfield 715	com/tencent/video/decode/AVVideoParam:width	I
    //   23: istore_1
    //   24: aload 9
    //   26: getfield 365	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   29: getfield 717	com/tencent/video/decode/AVVideoParam:height	I
    //   32: istore_2
    //   33: invokestatic 487	java/lang/System:currentTimeMillis	()J
    //   36: lstore 5
    //   38: aload_0
    //   39: getfield 183	com/tencent/image/NativeVideoImage:mResetFlag	Z
    //   42: ifne +358 -> 400
    //   45: iload_1
    //   46: aload_0
    //   47: getfield 173	com/tencent/image/NativeVideoImage:mReqWidth	I
    //   50: if_icmpne +1038 -> 1088
    //   53: iload_2
    //   54: aload_0
    //   55: getfield 175	com/tencent/image/NativeVideoImage:mReqHeight	I
    //   58: if_icmpne +1030 -> 1088
    //   61: aload 9
    //   63: aload_0
    //   64: getfield 543	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   67: invokevirtual 729	com/tencent/video/decode/AbstractAVDecode:seekToNextFrame	(Landroid/graphics/Bitmap;)V
    //   70: goto +52 -> 122
    //   73: aload_0
    //   74: getfield 189	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   77: ifnonnull +16 -> 93
    //   80: aload_0
    //   81: iload_1
    //   82: iload_2
    //   83: aload_0
    //   84: getfield 169	com/tencent/image/NativeVideoImage:mCurrentConfig	Landroid/graphics/Bitmap$Config;
    //   87: invokestatic 733	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   90: putfield 189	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   93: aload 9
    //   95: aload_0
    //   96: getfield 189	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   99: invokevirtual 729	com/tencent/video/decode/AbstractAVDecode:seekToNextFrame	(Landroid/graphics/Bitmap;)V
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 189	com/tencent/image/NativeVideoImage:mCompatibleBitmap	Landroid/graphics/Bitmap;
    //   107: aload_0
    //   108: getfield 173	com/tencent/image/NativeVideoImage:mReqWidth	I
    //   111: aload_0
    //   112: getfield 175	com/tencent/image/NativeVideoImage:mReqHeight	I
    //   115: iconst_1
    //   116: invokestatic 737	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   119: putfield 543	com/tencent/image/NativeVideoImage:mCurFrameBitmapBuffer	Landroid/graphics/Bitmap;
    //   122: invokestatic 487	java/lang/System:currentTimeMillis	()J
    //   125: lload 5
    //   127: lsub
    //   128: lstore 5
    //   130: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   133: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   136: invokeinterface 256 1 0
    //   141: ifeq +112 -> 253
    //   144: aload_0
    //   145: getfield 163	com/tencent/image/NativeVideoImage:debug	Z
    //   148: ifne +12 -> 160
    //   151: lload 5
    //   153: ldc2_w 738
    //   156: lcmp
    //   157: ifle +96 -> 253
    //   160: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   163: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   166: astore 10
    //   168: new 85	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   175: astore 11
    //   177: aload 11
    //   179: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   182: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 11
    //   188: aload_0
    //   189: getfield 203	com/tencent/image/NativeVideoImage:ID	I
    //   192: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 11
    //   198: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: astore 11
    //   203: new 85	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   210: astore 12
    //   212: aload 12
    //   214: ldc_w 741
    //   217: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 12
    //   223: lload 5
    //   225: invokevirtual 563	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 12
    //   231: ldc_w 743
    //   234: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 10
    //   240: aload 11
    //   242: iconst_2
    //   243: aload 12
    //   245: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokeinterface 275 4 0
    //   253: aload 9
    //   255: getfield 365	com/tencent/video/decode/AbstractAVDecode:videoParam	Lcom/tencent/video/decode/AVVideoParam;
    //   258: getfield 746	com/tencent/video/decode/AVVideoParam:frame_index	I
    //   261: istore_2
    //   262: iload_2
    //   263: iconst_1
    //   264: if_icmpne +96 -> 360
    //   267: aload_0
    //   268: getfield 179	com/tencent/image/NativeVideoImage:mlastVideoFrameIndex	I
    //   271: iload_2
    //   272: if_icmple +88 -> 360
    //   275: aload_0
    //   276: aload_0
    //   277: getfield 181	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   280: iconst_1
    //   281: iadd
    //   282: putfield 181	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   285: aload_0
    //   286: getfield 749	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   289: astore 9
    //   291: aload 9
    //   293: monitorenter
    //   294: aload_0
    //   295: getfield 749	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   298: invokevirtual 752	java/util/ArrayList:size	()I
    //   301: iconst_1
    //   302: isub
    //   303: istore_1
    //   304: iload_1
    //   305: iflt +41 -> 346
    //   308: aload_0
    //   309: getfield 749	com/tencent/image/NativeVideoImage:mListener	Ljava/util/ArrayList;
    //   312: iload_1
    //   313: invokevirtual 756	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   316: checkcast 619	java/lang/ref/WeakReference
    //   319: invokevirtual 759	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   322: checkcast 761	com/tencent/image/VideoDrawable$OnPlayRepeatListener
    //   325: astore 10
    //   327: aload 10
    //   329: ifnull +770 -> 1099
    //   332: aload 10
    //   334: aload_0
    //   335: getfield 181	com/tencent/image/NativeVideoImage:mPlayRepeatCount	I
    //   338: invokeinterface 764 2 0
    //   343: goto +756 -> 1099
    //   346: aload 9
    //   348: monitorexit
    //   349: goto +11 -> 360
    //   352: astore 10
    //   354: aload 9
    //   356: monitorexit
    //   357: aload 10
    //   359: athrow
    //   360: aload_0
    //   361: iload_2
    //   362: putfield 179	com/tencent/image/NativeVideoImage:mlastVideoFrameIndex	I
    //   365: aload_0
    //   366: aload_0
    //   367: getfield 177	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   370: iconst_1
    //   371: iadd
    //   372: putfield 177	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   375: goto +731 -> 1106
    //   378: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   381: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   384: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   387: iconst_2
    //   388: ldc_w 766
    //   391: invokeinterface 359 4 0
    //   396: aload_0
    //   397: monitorexit
    //   398: iconst_0
    //   399: ireturn
    //   400: aload_0
    //   401: iconst_0
    //   402: putfield 183	com/tencent/image/NativeVideoImage:mResetFlag	Z
    //   405: new 160	com/tencent/video/decode/AVideoException
    //   408: dup
    //   409: bipush 146
    //   411: iconst_m1
    //   412: ldc_w 768
    //   415: invokespecial 771	com/tencent/video/decode/AVideoException:<init>	(IILjava/lang/String;)V
    //   418: athrow
    //   419: astore 9
    //   421: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   424: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   427: invokeinterface 256 1 0
    //   432: ifeq +87 -> 519
    //   435: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   438: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   441: astore 10
    //   443: new 85	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   450: astore 11
    //   452: aload 11
    //   454: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   457: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: pop
    //   461: aload 11
    //   463: aload_0
    //   464: getfield 203	com/tencent/image/NativeVideoImage:ID	I
    //   467: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 11
    //   473: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: astore 11
    //   478: new 85	java/lang/StringBuilder
    //   481: dup
    //   482: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   485: astore 12
    //   487: aload 12
    //   489: ldc_w 773
    //   492: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload 12
    //   498: aload 9
    //   500: invokevirtual 776	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 10
    //   506: aload 11
    //   508: iconst_2
    //   509: aload 12
    //   511: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokeinterface 275 4 0
    //   519: iload 8
    //   521: istore 7
    //   523: aload 9
    //   525: getfield 779	com/tencent/video/decode/AVideoException:mErrCode	I
    //   528: bipush 146
    //   530: if_icmpne +363 -> 893
    //   533: aload_0
    //   534: iconst_1
    //   535: putfield 195	com/tencent/image/NativeVideoImage:mVideoDecodeFinish	Z
    //   538: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   541: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   544: invokeinterface 256 1 0
    //   549: ifeq +55 -> 604
    //   552: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   555: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   558: astore 9
    //   560: new 85	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   567: astore 10
    //   569: aload 10
    //   571: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   574: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: aload 10
    //   580: aload_0
    //   581: getfield 203	com/tencent/image/NativeVideoImage:ID	I
    //   584: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload 9
    //   590: aload 10
    //   592: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: iconst_2
    //   596: ldc_w 781
    //   599: invokeinterface 275 4 0
    //   604: aload_0
    //   605: getfield 187	com/tencent/image/NativeVideoImage:mPlayAudioOnceFinished	Z
    //   608: ifne +48 -> 656
    //   611: aload_0
    //   612: iconst_1
    //   613: putfield 187	com/tencent/image/NativeVideoImage:mPlayAudioOnceFinished	Z
    //   616: aload_0
    //   617: getfield 283	com/tencent/image/NativeVideoImage:mVideoParams	Lcom/tencent/image/VideoDrawable$VideoDrawableParams;
    //   620: astore 9
    //   622: aload_0
    //   623: iconst_0
    //   624: putfield 185	com/tencent/image/NativeVideoImage:mPlayAudioFrame	Z
    //   627: aload 9
    //   629: iconst_0
    //   630: putfield 284	com/tencent/image/VideoDrawable$VideoDrawableParams:mPlayAudioFrame	Z
    //   633: aload_0
    //   634: getfield 294	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   637: iconst_1
    //   638: putfield 303	com/tencent/video/decode/AVDecodeOption:ignore_audio	Z
    //   641: getstatic 124	com/tencent/image/NativeVideoImage:sUIHandler	Landroid/os/Handler;
    //   644: new 783	com/tencent/image/NativeVideoImage$2
    //   647: dup
    //   648: aload_0
    //   649: invokespecial 786	com/tencent/image/NativeVideoImage$2:<init>	(Lcom/tencent/image/NativeVideoImage;)V
    //   652: invokevirtual 683	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   655: pop
    //   656: aload_0
    //   657: getfield 283	com/tencent/image/NativeVideoImage:mVideoParams	Lcom/tencent/image/VideoDrawable$VideoDrawableParams;
    //   660: getfield 284	com/tencent/image/VideoDrawable$VideoDrawableParams:mPlayAudioFrame	Z
    //   663: ifeq +93 -> 756
    //   666: aload_0
    //   667: getfield 208	com/tencent/image/NativeVideoImage:mLock	Ljava/lang/Object;
    //   670: astore 9
    //   672: aload 9
    //   674: monitorenter
    //   675: getstatic 145	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   678: ifnull +21 -> 699
    //   681: getstatic 145	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   684: new 696	com/tencent/image/NativeVideoImage$ReleaseTask
    //   687: dup
    //   688: aload_0
    //   689: getfield 346	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   692: invokespecial 699	com/tencent/image/NativeVideoImage$ReleaseTask:<init>	(Lcom/tencent/video/decode/AbstractAVDecode;)V
    //   695: invokevirtual 683	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   698: pop
    //   699: aload_0
    //   700: aload_0
    //   701: getfield 294	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   704: invokestatic 789	com/tencent/video/decode/AVDecodeFactory:newDecode	(Lcom/tencent/video/decode/AVDecodeOption;)Lcom/tencent/video/decode/AbstractAVDecode;
    //   707: putfield 346	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   710: aload 9
    //   712: monitorexit
    //   713: aload_0
    //   714: getfield 225	com/tencent/image/NativeVideoImage:mAudioLock	Ljava/lang/Object;
    //   717: astore 9
    //   719: aload 9
    //   721: monitorenter
    //   722: aload_0
    //   723: iconst_1
    //   724: putfield 195	com/tencent/image/NativeVideoImage:mVideoDecodeFinish	Z
    //   727: aload_0
    //   728: getfield 225	com/tencent/image/NativeVideoImage:mAudioLock	Ljava/lang/Object;
    //   731: invokevirtual 575	java/lang/Object:notifyAll	()V
    //   734: aload 9
    //   736: monitorexit
    //   737: goto +62 -> 799
    //   740: astore 10
    //   742: aload 9
    //   744: monitorexit
    //   745: aload 10
    //   747: athrow
    //   748: astore 10
    //   750: aload 9
    //   752: monitorexit
    //   753: aload 10
    //   755: athrow
    //   756: getstatic 145	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   759: ifnull +21 -> 780
    //   762: getstatic 145	com/tencent/image/NativeVideoImage:sReleaseHandler	Landroid/os/Handler;
    //   765: new 696	com/tencent/image/NativeVideoImage$ReleaseTask
    //   768: dup
    //   769: aload_0
    //   770: getfield 346	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   773: invokespecial 699	com/tencent/image/NativeVideoImage$ReleaseTask:<init>	(Lcom/tencent/video/decode/AbstractAVDecode;)V
    //   776: invokevirtual 683	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   779: pop
    //   780: aload_0
    //   781: getfield 294	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   784: iconst_1
    //   785: putfield 300	com/tencent/video/decode/AVDecodeOption:cycle	Z
    //   788: aload_0
    //   789: aload_0
    //   790: getfield 294	com/tencent/image/NativeVideoImage:mOption	Lcom/tencent/video/decode/AVDecodeOption;
    //   793: invokestatic 789	com/tencent/video/decode/AVDecodeFactory:newDecode	(Lcom/tencent/video/decode/AVDecodeOption;)Lcom/tencent/video/decode/AbstractAVDecode;
    //   796: putfield 346	com/tencent/image/NativeVideoImage:mAVDecode	Lcom/tencent/video/decode/AbstractAVDecode;
    //   799: aload_0
    //   800: aload_0
    //   801: getfield 177	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   804: iconst_1
    //   805: iadd
    //   806: putfield 177	com/tencent/image/NativeVideoImage:sImageIndex	I
    //   809: goto +297 -> 1106
    //   812: astore 9
    //   814: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   817: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   820: invokeinterface 256 1 0
    //   825: ifeq +10 -> 835
    //   828: aload_0
    //   829: ldc_w 790
    //   832: invokevirtual 793	com/tencent/image/NativeVideoImage:showOOM	(Ljava/lang/String;)V
    //   835: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   838: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   841: astore 10
    //   843: new 85	java/lang/StringBuilder
    //   846: dup
    //   847: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   850: astore 11
    //   852: aload 11
    //   854: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   857: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: aload 11
    //   863: aload_0
    //   864: getfield 203	com/tencent/image/NativeVideoImage:ID	I
    //   867: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload 10
    //   873: aload 11
    //   875: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: iconst_1
    //   879: ldc_w 795
    //   882: aload 9
    //   884: invokeinterface 355 5 0
    //   889: iload 8
    //   891: istore 7
    //   893: aload_0
    //   894: getfield 221	com/tencent/image/NativeVideoImage:mCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   897: iconst_1
    //   898: invokevirtual 799	java/util/concurrent/atomic/AtomicInteger:addAndGet	(I)I
    //   901: pop
    //   902: invokestatic 487	java/lang/System:currentTimeMillis	()J
    //   905: lload_3
    //   906: lsub
    //   907: lstore_3
    //   908: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   911: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   914: invokeinterface 256 1 0
    //   919: ifeq +146 -> 1065
    //   922: aload_0
    //   923: getfield 163	com/tencent/image/NativeVideoImage:debug	Z
    //   926: ifne +17 -> 943
    //   929: lload_3
    //   930: getstatic 153	com/tencent/image/NativeVideoImage:TIME_BASE	I
    //   933: i2l
    //   934: lcmp
    //   935: ifgt +8 -> 943
    //   938: iload 7
    //   940: ifne +125 -> 1065
    //   943: getstatic 244	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   946: getfield 250	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   949: astore 9
    //   951: new 85	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   958: astore 10
    //   960: aload 10
    //   962: getstatic 107	com/tencent/image/NativeVideoImage:TAG	Ljava/lang/String;
    //   965: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: aload 10
    //   971: aload_0
    //   972: getfield 203	com/tencent/image/NativeVideoImage:ID	I
    //   975: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: aload 10
    //   981: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   984: astore 10
    //   986: new 85	java/lang/StringBuilder
    //   989: dup
    //   990: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   993: astore 11
    //   995: aload 11
    //   997: ldc_w 801
    //   1000: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: pop
    //   1004: aload 11
    //   1006: lload_3
    //   1007: invokevirtual 563	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1010: pop
    //   1011: aload 11
    //   1013: ldc_w 803
    //   1016: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1019: pop
    //   1020: aload 11
    //   1022: aload_0
    //   1023: getfield 221	com/tencent/image/NativeVideoImage:mCount	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1026: invokevirtual 805	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   1029: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload 11
    //   1035: ldc_w 807
    //   1038: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: pop
    //   1042: aload 11
    //   1044: iload 7
    //   1046: invokevirtual 264	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1049: pop
    //   1050: aload 9
    //   1052: aload 10
    //   1054: iconst_2
    //   1055: aload 11
    //   1057: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1060: invokeinterface 275 4 0
    //   1065: aload_0
    //   1066: monitorexit
    //   1067: iload 7
    //   1069: ireturn
    //   1070: astore 9
    //   1072: aload_0
    //   1073: monitorexit
    //   1074: goto +6 -> 1080
    //   1077: aload 9
    //   1079: athrow
    //   1080: goto -3 -> 1077
    //   1083: astore 10
    //   1085: goto -963 -> 122
    //   1088: iload_2
    //   1089: ifeq -711 -> 378
    //   1092: iload_1
    //   1093: ifne -1020 -> 73
    //   1096: goto -718 -> 378
    //   1099: iload_1
    //   1100: iconst_1
    //   1101: isub
    //   1102: istore_1
    //   1103: goto -799 -> 304
    //   1106: iconst_1
    //   1107: istore 7
    //   1109: goto -216 -> 893
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1112	0	this	NativeVideoImage
    //   23	1080	1	i	int
    //   32	1057	2	j	int
    //   5	1002	3	l1	long
    //   36	188	5	l2	long
    //   521	587	7	bool1	boolean
    //   7	883	8	bool2	boolean
    //   419	105	9	localAVideoException	AVideoException
    //   812	71	9	localOutOfMemoryError	OutOfMemoryError
    //   949	102	9	localILog	ILog
    //   1070	8	9	localObject3	Object
    //   166	167	10	localObject4	Object
    //   352	6	10	localObject5	Object
    //   441	150	10	localObject6	Object
    //   740	6	10	localObject7	Object
    //   748	6	10	localObject8	Object
    //   841	212	10	localObject9	Object
    //   1083	1	10	localNullPointerException	java.lang.NullPointerException
    //   175	881	11	localObject10	Object
    //   210	300	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   294	304	352	finally
    //   308	327	352	finally
    //   332	343	352	finally
    //   346	349	352	finally
    //   354	357	352	finally
    //   33	70	419	com/tencent/video/decode/AVideoException
    //   73	93	419	com/tencent/video/decode/AVideoException
    //   93	102	419	com/tencent/video/decode/AVideoException
    //   102	122	419	com/tencent/video/decode/AVideoException
    //   122	151	419	com/tencent/video/decode/AVideoException
    //   160	253	419	com/tencent/video/decode/AVideoException
    //   253	262	419	com/tencent/video/decode/AVideoException
    //   267	294	419	com/tencent/video/decode/AVideoException
    //   357	360	419	com/tencent/video/decode/AVideoException
    //   360	375	419	com/tencent/video/decode/AVideoException
    //   378	396	419	com/tencent/video/decode/AVideoException
    //   400	419	419	com/tencent/video/decode/AVideoException
    //   722	737	740	finally
    //   742	745	740	finally
    //   675	699	748	finally
    //   699	713	748	finally
    //   750	753	748	finally
    //   9	33	812	java/lang/OutOfMemoryError
    //   33	70	812	java/lang/OutOfMemoryError
    //   73	93	812	java/lang/OutOfMemoryError
    //   93	102	812	java/lang/OutOfMemoryError
    //   102	122	812	java/lang/OutOfMemoryError
    //   122	151	812	java/lang/OutOfMemoryError
    //   160	253	812	java/lang/OutOfMemoryError
    //   253	262	812	java/lang/OutOfMemoryError
    //   267	294	812	java/lang/OutOfMemoryError
    //   357	360	812	java/lang/OutOfMemoryError
    //   360	375	812	java/lang/OutOfMemoryError
    //   378	396	812	java/lang/OutOfMemoryError
    //   400	419	812	java/lang/OutOfMemoryError
    //   421	519	812	java/lang/OutOfMemoryError
    //   523	604	812	java/lang/OutOfMemoryError
    //   604	656	812	java/lang/OutOfMemoryError
    //   656	675	812	java/lang/OutOfMemoryError
    //   713	722	812	java/lang/OutOfMemoryError
    //   745	748	812	java/lang/OutOfMemoryError
    //   753	756	812	java/lang/OutOfMemoryError
    //   756	780	812	java/lang/OutOfMemoryError
    //   780	799	812	java/lang/OutOfMemoryError
    //   799	809	812	java/lang/OutOfMemoryError
    //   2	6	1070	finally
    //   9	33	1070	finally
    //   33	70	1070	finally
    //   73	93	1070	finally
    //   93	102	1070	finally
    //   102	122	1070	finally
    //   122	151	1070	finally
    //   160	253	1070	finally
    //   253	262	1070	finally
    //   267	294	1070	finally
    //   357	360	1070	finally
    //   360	375	1070	finally
    //   378	396	1070	finally
    //   400	419	1070	finally
    //   421	519	1070	finally
    //   523	604	1070	finally
    //   604	656	1070	finally
    //   656	675	1070	finally
    //   713	722	1070	finally
    //   745	748	1070	finally
    //   753	756	1070	finally
    //   756	780	1070	finally
    //   780	799	1070	finally
    //   799	809	1070	finally
    //   814	835	1070	finally
    //   835	889	1070	finally
    //   893	938	1070	finally
    //   943	1065	1070	finally
    //   102	122	1083	java/lang/NullPointerException
  }
  
  public int getWidth()
  {
    Bitmap localBitmap = this.mCurFrameBitmap;
    if (localBitmap != null) {
      return localBitmap.getWidth();
    }
    return 0;
  }
  
  void init(boolean paramBoolean)
  {
    if (sVideoEngineAvaliable) {}
    try
    {
      this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      label28:
      break label28;
    }
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      showOOM("create mCurFrameBitmapBuffer");
    }
    if (this.mCurrentConfig == Bitmap.Config.ARGB_8888) {}
    try
    {
      this.mCurrentConfig = Bitmap.Config.RGB_565;
      this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label88:
      break label88;
    }
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      showOOM("create mCurFrameBitmapBuffer");
    }
    URLDrawable.clearMemoryCache();
    this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
    break label156;
    URLDrawable.clearMemoryCache();
    this.mCurFrameBitmapBuffer = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
    try
    {
      label156:
      if ((this.mRotation != 0) && (this.mRotation != 180)) {
        this.mCurFrameBitmap = Bitmap.createBitmap(this.mReqHeight, this.mReqWidth, this.mCurrentConfig);
      } else {
        this.mCurFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      label217:
      ILog localILog;
      Object localObject;
      StringBuilder localStringBuilder;
      boolean bool;
      break label217;
    }
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      showOOM("create mCurFrameBitmap");
    }
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localILog = URLDrawable.depImp.mLog;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(this.ID);
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("use mCurFrameBitmapBuffer: ");
      if (this.mCurFrameBitmapBuffer != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localILog.d((String)localObject, 2, localStringBuilder.toString());
    }
    getNextFrame();
    applyNextFrame();
    if (paramBoolean) {}
    try
    {
      this.mFirstFrameBitmap = this.mCurFrameBitmap.copy(this.mCurFrameBitmap.getConfig(), false);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError4)
    {
      label380:
      break label380;
    }
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      showOOM("create mFirstFrameBitmap");
    }
  }
  
  void initAudioTrack()
  {
    int j;
    if (this.mAVDecode.audioParam.channels <= 1) {
      j = 2;
    } else {
      j = 3;
    }
    int m = this.mAVDecode.audioParam.sample_rate;
    ILog localILog;
    Object localObject;
    StringBuilder localStringBuilder;
    if (m <= 0)
    {
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        localILog = URLDrawable.depImp.mLog;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(TAG);
        ((StringBuilder)localObject).append(this.ID);
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initAudioTrack(), sampleRateInHz=");
        localStringBuilder.append(m);
        localStringBuilder.append(", <= 0, return...");
        localILog.e((String)localObject, 2, localStringBuilder.toString());
      }
      return;
    }
    int k = AudioTrack.getMinBufferSize(m, j, 2);
    int i = k;
    if (k < 1024)
    {
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        localILog = URLDrawable.depImp.mLog;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(TAG);
        ((StringBuilder)localObject).append(this.ID);
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("initAudioTrack(), minBufSize=");
        localStringBuilder.append(k);
        localStringBuilder.append(" < 1024, so mutiply 2");
        localILog.d((String)localObject, 2, localStringBuilder.toString());
      }
      k *= 2;
      i = k;
      if (k < 1024) {
        i = 1024;
      }
    }
    k = i * 2;
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localILog = URLDrawable.depImp.mLog;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(this.ID);
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("initAudioTrack(): cost=channelConfig: ");
      localStringBuilder.append(j);
      localStringBuilder.append(", sampleRateInHz: ");
      localStringBuilder.append(m);
      localStringBuilder.append(", minBufSize: ");
      localStringBuilder.append(i);
      localStringBuilder.append(", primePlaySize: ");
      localStringBuilder.append(k);
      localILog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.mAudioTrack = new ReportAudioTrack(3, m, j, 2, k, 1);
  }
  
  public boolean isAudioPlaying()
  {
    return this.mPlayAudioFrame;
  }
  
  public void resetAndPlayAudioCircle()
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(TAG, 2, "resetAndPlayAudioOnce >>>");
    }
    this.mPlayAudioOnceFinished = false;
    VideoDrawable.VideoDrawableParams localVideoDrawableParams = this.mVideoParams;
    this.mPlayAudioFrame = true;
    localVideoDrawableParams.mPlayAudioFrame = true;
    this.mOption.ignore_audio = (this.mPlayAudioFrame ^ true);
    this.mOption.cycle = true;
    try
    {
      this.mAVDecode.resetVideoPlayer(this.mOption);
    }
    catch (AVideoException localAVideoException)
    {
      URLDrawable.depImp.mLog.e(TAG, 1, "AVideoException happens resetAndPlayAudioOnce...", localAVideoException);
    }
    reDraw();
  }
  
  public void resetAndPlayAudioOnce()
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(TAG, 2, "resetAndPlayAudioOnce >>>");
    }
    this.mPlayAudioOnceFinished = false;
    VideoDrawable.VideoDrawableParams localVideoDrawableParams = this.mVideoParams;
    this.mPlayAudioFrame = true;
    localVideoDrawableParams.mPlayAudioFrame = true;
    this.mOption.ignore_audio = (this.mPlayAudioFrame ^ true);
    this.mOption.cycle = false;
    try
    {
      this.mAVDecode.resetVideoPlayer(this.mOption);
    }
    catch (AVideoException localAVideoException)
    {
      URLDrawable.depImp.mLog.e(TAG, 1, "AVideoException happens resetAndPlayAudioOnce...", localAVideoException);
    }
    reDraw();
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
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ILog localILog = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(this.ID);
      localILog.d(localStringBuilder.toString(), 2, "stopPlayAudio()");
    }
    this.mPlayAudioFrame = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage
 * JD-Core Version:    0.7.0.1
 */
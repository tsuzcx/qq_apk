package com.tencent.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnPreAdListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoOutputFrameListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IProxyFactory;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class QQLiveImage
  implements TVK_IMediaPlayer.OnVideoOutputFrameListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnPreAdListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnVideoPreparedListener, TVK_IMediaPlayer.OnDownloadCallbackListener
{
  static final int MSG_TYPE_REFRESH = 1;
  public static final long SD_CACHE_LIMIT = 524288000L;
  public static final String TAG = QQLiveImage.class.getSimpleName() + "_";
  public static final String TencentVideoSdkAppKey = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  private static AtomicBoolean mInstallProgress = new AtomicBoolean(false);
  public static boolean mIsDebugEnable;
  private static boolean mSDKInited;
  private static boolean sAllPaused;
  private static volatile boolean sEnableUSRLog = false;
  private static volatile ArrayList<QQLiveImage> sImageList;
  protected int ID = 0;
  protected Canvas mCanvas;
  private URLDrawable mCover;
  protected Bitmap mCoverBitmap;
  protected volatile Bitmap mCurFrameBitmap;
  private int mDensity = 160;
  protected QQLiveDrawable.OnDownloadListener mDownloadListener;
  private Vector<WeakReference<QQLiveDrawable>> mDrawableList = new Vector();
  private QQLiveDrawable.ErrorInfo mErrorInfo = new QQLiveDrawable.ErrorInfo();
  int mFrameIndex = 0;
  protected Handler mHandler = new EventHandler(Looper.getMainLooper());
  private long mLastPlayerReleaseTime;
  Object mLock = new Object();
  protected Matrix mMatrix;
  protected QQLiveDrawable.OnStateListener mOnStateListener;
  protected QQLiveDrawable.QQLiveDrawableParams mParams;
  private volatile boolean mPaused = false;
  private boolean mPlayCompleted = false;
  private int mPlayPostionWhenRecyle = -1;
  private TVK_PlayerVideoInfo mPlayerinfo = null;
  private long mPrepareTime;
  private boolean mPrepared = false;
  private boolean mReclyed = false;
  protected Bitmap mRotatedBitmap;
  protected int mRotation;
  private long mStartPlayTime;
  AtomicInteger mState = new AtomicInteger(0);
  private String mUrlStr;
  private TVK_UserInfo mUserinfo = null;
  private volatile TVK_IMediaPlayer mVideoPlayer = null;
  private TVK_IProxyFactory mfactory = null;
  
  static
  {
    mSDKInited = false;
    mIsDebugEnable = true;
  }
  
  public QQLiveImage(String paramString, Object paramObject)
  {
    this.mUrlStr = paramString;
    this.ID = paramString.hashCode();
    if (!paramString.startsWith("qqlive")) {
      throw new IllegalStateException("Wrong format url! str=" + paramString);
    }
    if ((paramObject != null) && ((paramObject instanceof QQLiveDrawable.QQLiveDrawableParams)))
    {
      this.mParams = ((QQLiveDrawable.QQLiveDrawableParams)paramObject);
      setOnStateListener(this.mParams.mListener);
      setOnDownloadListener(this.mParams.mDownloadListener);
    }
    initCover(this.mParams.mCoverUrl);
    addToList(this);
    QLog.d(TAG + this.ID, 1, "QQLiveVideo(): url = " + paramString + ", mParams=" + this.mParams.toString());
    if ((sAllPaused) && (!this.mPaused))
    {
      pause();
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "QQLiveVideo(): 全局已经暂停，但是实例创建未暂停，这里主动停一下 ");
      }
    }
  }
  
  private static void addToList(QQLiveImage paramQQLiveImage)
  {
    if (paramQQLiveImage == null) {
      return;
    }
    boolean bool = false;
    try
    {
      if (sImageList == null) {
        sImageList = new ArrayList();
      }
      if (!sImageList.contains(paramQQLiveImage))
      {
        sImageList.add(paramQQLiveImage);
        bool = true;
      }
      QLog.i(TAG, 1, "addToList().... addSuccess: " + bool + ", ID: " + paramQQLiveImage.ID);
      return;
    }
    finally {}
  }
  
  private void asyncReleasePlayer(boolean paramBoolean)
  {
    if (this.mVideoPlayer != null) {
      try
      {
        if (this.mVideoPlayer != null)
        {
          this.mVideoPlayer.removeAllListener();
          ThreadManagerV2.executeOnFileThread(new ReleaseTask(this.mVideoPlayer, paramBoolean));
          this.mVideoPlayer = null;
        }
        return;
      }
      finally {}
    }
  }
  
  private void changeStateAndNotify(final int paramInt, final Object paramObject)
  {
    if (paramInt != this.mState.get())
    {
      if ((QLog.isColorLevel()) || (sEnableUSRLog)) {
        QLog.d(TAG + this.ID, 2, "changeStateAndNotify(): " + getStateStr(this.mState.get()) + " ===> " + getStateStr(paramInt) + ", extra = " + paramObject);
      }
      this.mState.set(paramInt);
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          if (QQLiveImage.this.mOnStateListener != null) {
            QQLiveImage.this.mOnStateListener.onStateChange(QQLiveImage.this.mUrlStr, QQLiveImage.this.mParams, paramInt, paramObject);
          }
        }
      });
    }
  }
  
  static Context getApplicationContext()
  {
    return BaseApplication.getContext();
  }
  
  public static String getStateStr(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    default: 
      return "STATE_UNKNOW";
    case 0: 
      return "STATE_IDLE";
    case 1: 
      return "STATE_PREPARED";
    case 2: 
      return "STATE_PLAYING";
    case 3: 
      return "STATE_BUFFERING";
    case 4: 
      return "STATE_PAUSE";
    case 5: 
      return "STATE_ERROR";
    case 6: 
      return "STATE_COMPLETE";
    case 8: 
      return "STATE_INITIALIZED";
    }
    return "STATE_PREPARING";
  }
  
  private void initCover(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      if (this.mCoverBitmap == null) {
        try
        {
          this.mCover = URLDrawable.getDrawable(paramString, this.mParams.mCoverLoadingDrawable, this.mParams.mCoverLoadingDrawable);
          if ((this.mCover.getStatus() == 1) && ((this.mCover.getCurrDrawable() instanceof RegionDrawable)))
          {
            this.mCoverBitmap = ((RegionDrawable)this.mCover.getCurrDrawable()).getBitmap();
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(TAG + this.ID, 2, "initCover(): mCover is loaded: ");
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e(TAG + this.ID, 2, "initCover(): getDrawable Exception: imgUrl=" + paramString, localException);
          }
          this.mCover = null;
          return;
        }
      }
    }
    this.mCover.setURLDrawableListener(new URLDrawable.URLDrawableListener()
    {
      public void onLoadCanceled(URLDrawable paramAnonymousURLDrawable) {}
      
      public void onLoadFialed(URLDrawable paramAnonymousURLDrawable, Throwable paramAnonymousThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initCover(): onLoadFialed(): ");
        }
      }
      
      public void onLoadProgressed(URLDrawable paramAnonymousURLDrawable, int paramAnonymousInt) {}
      
      public void onLoadSuccessed(URLDrawable paramAnonymousURLDrawable)
      {
        if ((paramAnonymousURLDrawable.getStatus() == 1) && ((paramAnonymousURLDrawable.getCurrDrawable() instanceof RegionDrawable)))
        {
          paramAnonymousURLDrawable = (RegionDrawable)paramAnonymousURLDrawable.getCurrDrawable();
          QQLiveImage.this.mCoverBitmap = paramAnonymousURLDrawable.getBitmap();
          QQLiveImage.this.invalidateSelf();
          if (QLog.isColorLevel()) {
            QLog.d(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initCover(): onLoadSuccessed(): ");
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initCover(): onLoadSuccessed(): mCoverBitmap=" + QQLiveImage.this.mCoverBitmap);
        }
      }
    });
    this.mCover.startDownload();
  }
  
  public static boolean isAllPaused()
  {
    return sAllPaused;
  }
  
  public static void pauseAll()
  {
    QLog.i(TAG, 1, "pauseAll() ");
    if (!sAllPaused)
    {
      sAllPaused = true;
      for (;;)
      {
        int i;
        try
        {
          if (sImageList != null)
          {
            i = 0;
            if (i < sImageList.size())
            {
              QQLiveImage localQQLiveImage = (QQLiveImage)sImageList.get(i);
              if (localQQLiveImage == null) {
                break label113;
              }
              localQQLiveImage.pause();
              QLog.i(TAG, 1, "pauseAll().... i " + i + ", ID: " + localQQLiveImage.ID);
              break label113;
            }
          }
          return;
        }
        finally {}
        label113:
        i += 1;
      }
    }
  }
  
  public static void releaseAll()
  {
    QLog.d(TAG, 1, "releaseAll()......");
    for (;;)
    {
      int i;
      try
      {
        if (sImageList != null)
        {
          i = 0;
          if (i < sImageList.size())
          {
            QQLiveImage localQQLiveImage = (QQLiveImage)sImageList.get(i);
            if (localQQLiveImage != null)
            {
              localQQLiveImage.release();
              QLog.d(TAG, 1, "release liveImage, index = " + i + ", ID = " + localQQLiveImage.ID);
            }
          }
          else
          {
            sImageList.clear();
            sImageList = null;
          }
        }
        else
        {
          sAllPaused = false;
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public static void resumeAll()
  {
    QLog.i(TAG, 1, "resumeAll() ");
    if (sAllPaused)
    {
      sAllPaused = false;
      for (;;)
      {
        int i;
        try
        {
          if (sImageList != null)
          {
            i = 0;
            if (i < sImageList.size())
            {
              QQLiveImage localQQLiveImage = (QQLiveImage)sImageList.get(i);
              if (localQQLiveImage == null) {
                break label113;
              }
              localQQLiveImage.resume();
              QLog.i(TAG, 1, "resumeAll().... i " + i + ", ID: " + localQQLiveImage.ID);
              break label113;
            }
          }
          return;
        }
        finally {}
        label113:
        i += 1;
      }
    }
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    mIsDebugEnable = paramBoolean;
  }
  
  public static void setUSRLogEnable(boolean paramBoolean)
  {
    sEnableUSRLog = paramBoolean;
  }
  
  public void OnDownloadCallback(String paramString)
  {
    if (this.mDownloadListener != null) {
      this.mDownloadListener.OnDownload(this.mUrlStr, this.mParams, paramString);
    }
  }
  
  /* Error */
  public void OnVideoOutputFrame(TVK_IMediaPlayer arg1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield 169	com/tencent/image/QQLiveImage:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   5: if_acmpeq +57 -> 62
    //   8: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +50 -> 61
    //   14: new 116	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   21: getstatic 136	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   24: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 156	com/tencent/image/QQLiveImage:ID	I
    //   31: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: iconst_2
    //   38: new 116	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   45: ldc_w 515
    //   48: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: return
    //   62: aload_0
    //   63: getfield 189	com/tencent/image/QQLiveImage:mPaused	Z
    //   66: ifne +10 -> 76
    //   69: aload_0
    //   70: getfield 197	com/tencent/image/QQLiveImage:mPlayCompleted	Z
    //   73: ifeq +67 -> 140
    //   76: new 116	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   83: getstatic 136	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   86: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: getfield 156	com/tencent/image/QQLiveImage:ID	I
    //   93: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: iconst_1
    //   100: new 116	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 519
    //   110: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 189	com/tencent/image/QQLiveImage:mPaused	Z
    //   117: invokevirtual 337	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   120: ldc_w 521
    //   123: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_0
    //   127: getfield 197	com/tencent/image/QQLiveImage:mPlayCompleted	Z
    //   130: invokevirtual 337	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   133: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   139: return
    //   140: aload_0
    //   141: getfield 231	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   144: ifnull +75 -> 219
    //   147: aload_0
    //   148: getfield 231	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   151: getfield 524	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mMaxPlayTimeMs	I
    //   154: ifle +65 -> 219
    //   157: aload_0
    //   158: getfield 169	com/tencent/image/QQLiveImage:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   161: ifnull +58 -> 219
    //   164: aload_0
    //   165: getfield 169	com/tencent/image/QQLiveImage:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   168: invokeinterface 528 1 0
    //   173: aload_0
    //   174: getfield 231	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   177: getfield 524	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mMaxPlayTimeMs	I
    //   180: aload_0
    //   181: getfield 231	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   184: getfield 531	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mStartPosi	I
    //   187: iadd
    //   188: i2l
    //   189: lcmp
    //   190: iflt +29 -> 219
    //   193: aload_0
    //   194: getfield 231	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   197: getfield 534	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mLoopback	Z
    //   200: ifeq +507 -> 707
    //   203: aload_0
    //   204: getfield 169	com/tencent/image/QQLiveImage:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   207: aload_0
    //   208: getfield 231	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   211: getfield 531	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mStartPosi	I
    //   214: invokeinterface 537 2 0
    //   219: aload_2
    //   220: ifnull +598 -> 818
    //   223: invokestatic 542	java/lang/System:currentTimeMillis	()J
    //   226: lstore 9
    //   228: aload_2
    //   229: invokestatic 548	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   232: astore_2
    //   233: aload_0
    //   234: getfield 201	com/tencent/image/QQLiveImage:mLock	Ljava/lang/Object;
    //   237: astore_1
    //   238: aload_1
    //   239: monitorenter
    //   240: aload_0
    //   241: getfield 550	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   244: ifnonnull +108 -> 352
    //   247: aload_0
    //   248: iload_3
    //   249: iload 4
    //   251: getstatic 556	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   254: invokestatic 562	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   257: putfield 550	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   260: aload_0
    //   261: iload 5
    //   263: putfield 564	com/tencent/image/QQLiveImage:mRotation	I
    //   266: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +83 -> 352
    //   272: new 116	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   279: getstatic 136	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   282: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_0
    //   286: getfield 156	com/tencent/image/QQLiveImage:ID	I
    //   289: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: iconst_2
    //   296: new 116	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   303: ldc_w 566
    //   306: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: iload_3
    //   310: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: ldc_w 568
    //   316: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: iload 4
    //   321: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   324: ldc_w 570
    //   327: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload 5
    //   332: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: ldc_w 572
    //   338: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: iload 6
    //   343: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   346: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 342	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: aload_0
    //   353: getfield 550	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   356: aload_2
    //   357: invokevirtual 576	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   360: aload_0
    //   361: getfield 564	com/tencent/image/QQLiveImage:mRotation	I
    //   364: ifeq +180 -> 544
    //   367: aload_0
    //   368: getfield 578	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   371: ifnonnull +35 -> 406
    //   374: aload_0
    //   375: getfield 564	com/tencent/image/QQLiveImage:mRotation	I
    //   378: bipush 90
    //   380: if_icmpeq +13 -> 393
    //   383: aload_0
    //   384: getfield 564	com/tencent/image/QQLiveImage:mRotation	I
    //   387: sipush 270
    //   390: if_icmpne +326 -> 716
    //   393: aload_0
    //   394: iload 4
    //   396: iload_3
    //   397: getstatic 556	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   400: invokestatic 562	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   403: putfield 578	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   406: aload_0
    //   407: getfield 580	com/tencent/image/QQLiveImage:mCanvas	Landroid/graphics/Canvas;
    //   410: ifnonnull +18 -> 428
    //   413: aload_0
    //   414: new 582	android/graphics/Canvas
    //   417: dup
    //   418: aload_0
    //   419: getfield 578	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   422: invokespecial 585	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   425: putfield 580	com/tencent/image/QQLiveImage:mCanvas	Landroid/graphics/Canvas;
    //   428: aload_0
    //   429: getfield 587	com/tencent/image/QQLiveImage:mMatrix	Landroid/graphics/Matrix;
    //   432: ifnonnull +89 -> 521
    //   435: aload_0
    //   436: new 589	android/graphics/Matrix
    //   439: dup
    //   440: invokespecial 590	android/graphics/Matrix:<init>	()V
    //   443: putfield 587	com/tencent/image/QQLiveImage:mMatrix	Landroid/graphics/Matrix;
    //   446: aload_0
    //   447: getfield 550	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   450: invokevirtual 593	android/graphics/Bitmap:getWidth	()I
    //   453: istore 7
    //   455: aload_0
    //   456: getfield 550	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   459: invokevirtual 596	android/graphics/Bitmap:getHeight	()I
    //   462: istore 8
    //   464: aload_0
    //   465: getfield 587	com/tencent/image/QQLiveImage:mMatrix	Landroid/graphics/Matrix;
    //   468: aload_0
    //   469: getfield 564	com/tencent/image/QQLiveImage:mRotation	I
    //   472: i2f
    //   473: iload 7
    //   475: iconst_2
    //   476: idiv
    //   477: i2f
    //   478: iload 8
    //   480: iconst_2
    //   481: idiv
    //   482: i2f
    //   483: invokevirtual 600	android/graphics/Matrix:postRotate	(FFF)Z
    //   486: pop
    //   487: aload_0
    //   488: getfield 587	com/tencent/image/QQLiveImage:mMatrix	Landroid/graphics/Matrix;
    //   491: aload_0
    //   492: getfield 578	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   495: invokevirtual 593	android/graphics/Bitmap:getWidth	()I
    //   498: iload 7
    //   500: isub
    //   501: i2f
    //   502: fconst_2
    //   503: fdiv
    //   504: aload_0
    //   505: getfield 578	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   508: invokevirtual 596	android/graphics/Bitmap:getHeight	()I
    //   511: iload 8
    //   513: isub
    //   514: i2f
    //   515: fconst_2
    //   516: fdiv
    //   517: invokevirtual 604	android/graphics/Matrix:postTranslate	(FF)Z
    //   520: pop
    //   521: aload_0
    //   522: getfield 550	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   525: ifnull +19 -> 544
    //   528: aload_0
    //   529: getfield 580	com/tencent/image/QQLiveImage:mCanvas	Landroid/graphics/Canvas;
    //   532: aload_0
    //   533: getfield 550	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   536: aload_0
    //   537: getfield 587	com/tencent/image/QQLiveImage:mMatrix	Landroid/graphics/Matrix;
    //   540: aconst_null
    //   541: invokevirtual 608	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   544: aload_1
    //   545: monitorexit
    //   546: aload_0
    //   547: aload_0
    //   548: getfield 199	com/tencent/image/QQLiveImage:mFrameIndex	I
    //   551: iconst_1
    //   552: iadd
    //   553: putfield 199	com/tencent/image/QQLiveImage:mFrameIndex	I
    //   556: invokestatic 542	java/lang/System:currentTimeMillis	()J
    //   559: lload 9
    //   561: lsub
    //   562: lstore 9
    //   564: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   567: ifeq +116 -> 683
    //   570: lload 9
    //   572: ldc2_w 609
    //   575: lcmp
    //   576: ifle +107 -> 683
    //   579: new 116	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   586: getstatic 136	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   589: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload_0
    //   593: getfield 156	com/tencent/image/QQLiveImage:ID	I
    //   596: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   599: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: iconst_2
    //   603: new 116	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   610: ldc_w 612
    //   613: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: iload_3
    //   617: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   620: ldc_w 568
    //   623: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: iload 4
    //   628: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   631: ldc_w 614
    //   634: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: lload 9
    //   639: invokevirtual 617	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   642: ldc_w 619
    //   645: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload_0
    //   649: getfield 199	com/tencent/image/QQLiveImage:mFrameIndex	I
    //   652: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   655: ldc_w 621
    //   658: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: iload 5
    //   663: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   666: ldc_w 623
    //   669: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: iload 6
    //   674: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   677: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   683: aload_0
    //   684: getfield 167	com/tencent/image/QQLiveImage:mHandler	Landroid/os/Handler;
    //   687: iconst_1
    //   688: invokevirtual 626	android/os/Handler:removeMessages	(I)V
    //   691: aload_0
    //   692: getfield 167	com/tencent/image/QQLiveImage:mHandler	Landroid/os/Handler;
    //   695: iconst_1
    //   696: invokevirtual 630	android/os/Handler:sendEmptyMessage	(I)Z
    //   699: pop
    //   700: aload_0
    //   701: iconst_2
    //   702: aconst_null
    //   703: invokespecial 289	com/tencent/image/QQLiveImage:changeStateAndNotify	(ILjava/lang/Object;)V
    //   706: return
    //   707: aload_0
    //   708: aload_0
    //   709: getfield 169	com/tencent/image/QQLiveImage:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   712: invokevirtual 634	com/tencent/image/QQLiveImage:onCompletion	(Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;)V
    //   715: return
    //   716: aload_0
    //   717: iload_3
    //   718: iload 4
    //   720: getstatic 556	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   723: invokestatic 562	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   726: putfield 578	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   729: goto -323 -> 406
    //   732: astore_2
    //   733: aload_1
    //   734: monitorexit
    //   735: aload_2
    //   736: athrow
    //   737: astore_1
    //   738: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   741: ifeq -185 -> 556
    //   744: new 116	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   751: getstatic 136	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   754: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload_0
    //   758: getfield 156	com/tencent/image/QQLiveImage:ID	I
    //   761: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: iconst_2
    //   768: ldc_w 636
    //   771: aload_1
    //   772: invokestatic 455	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   775: goto -219 -> 556
    //   778: astore_1
    //   779: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   782: ifeq -226 -> 556
    //   785: new 116	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   792: getstatic 136	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   795: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload_0
    //   799: getfield 156	com/tencent/image/QQLiveImage:ID	I
    //   802: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   805: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   808: iconst_2
    //   809: ldc_w 638
    //   812: invokestatic 517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: goto -259 -> 556
    //   818: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   821: ifeq -760 -> 61
    //   824: new 116	java/lang/StringBuilder
    //   827: dup
    //   828: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   831: getstatic 136	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   834: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: aload_0
    //   838: getfield 156	com/tencent/image/QQLiveImage:ID	I
    //   841: invokevirtual 257	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   844: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: iconst_2
    //   848: ldc_w 640
    //   851: invokestatic 517	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   854: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	855	0	this	QQLiveImage
    //   0	855	2	paramArrayOfByte	byte[]
    //   0	855	3	paramInt1	int
    //   0	855	4	paramInt2	int
    //   0	855	5	paramInt3	int
    //   0	855	6	paramInt4	int
    //   453	48	7	i	int
    //   462	52	8	j	int
    //   226	412	9	l	long
    // Exception table:
    //   from	to	target	type
    //   240	352	732	finally
    //   352	393	732	finally
    //   393	406	732	finally
    //   406	428	732	finally
    //   428	521	732	finally
    //   521	544	732	finally
    //   544	546	732	finally
    //   716	729	732	finally
    //   733	735	732	finally
    //   233	240	737	java/lang/Exception
    //   546	556	737	java/lang/Exception
    //   735	737	737	java/lang/Exception
    //   233	240	778	java/lang/OutOfMemoryError
    //   546	556	778	java/lang/OutOfMemoryError
    //   735	737	778	java/lang/OutOfMemoryError
  }
  
  public void attachDrawable(QQLiveDrawable paramQQLiveDrawable)
  {
    if (paramQQLiveDrawable != null) {
      synchronized (this.mDrawableList)
      {
        if (!this.mDrawableList.contains(paramQQLiveDrawable)) {
          this.mDrawableList.add(new WeakReference(paramQQLiveDrawable));
        }
        return;
      }
    }
  }
  
  public void detachDrawable(QQLiveDrawable paramQQLiveDrawable)
  {
    if (paramQQLiveDrawable != null)
    {
      localVector = this.mDrawableList;
      int i = 0;
      Object localObject;
      for (;;)
      {
        int j;
        try
        {
          if (i < this.mDrawableList.size())
          {
            localObject = (WeakReference)this.mDrawableList.get(i);
            if ((localObject == null) || (((WeakReference)localObject).get() == paramQQLiveDrawable))
            {
              localObject = this.mDrawableList;
              j = i - 1;
            }
          }
        }
        finally {}
        try
        {
          ((Vector)localObject).remove(i);
          i = j;
        }
        finally
        {
          continue;
          continue;
        }
        i += 1;
      }
      if (((WeakReference)localObject).get() == paramQQLiveDrawable)
      {
        paramQQLiveDrawable = this.mDrawableList;
        paramQQLiveDrawable.remove(i);
      }
    }
    else
    {
      return;
      return;
    }
  }
  
  protected void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    if ((this.mCurFrameBitmap != null) || (this.mRotatedBitmap != null)) {
      if ((this.mRotation != 0) && (this.mRotatedBitmap != null))
      {
        paramCanvas.drawBitmap(this.mRotatedBitmap, null, paramRect, paramPaint);
        if ((this.mVideoPlayer != null) || (this.mParams == null) || (this.mPaused) || (this.mPlayCompleted) || (this.mState.get() == 5)) {
          break label223;
        }
        initAndStartPlayer(this.mParams.mStartPosi);
      }
    }
    label223:
    while ((!QLog.isColorLevel()) || (this.mVideoPlayer != null))
    {
      return;
      paramCanvas.drawBitmap(this.mCurFrameBitmap, null, paramRect, paramPaint);
      break;
      if (this.mCoverBitmap != null)
      {
        paramCanvas.drawBitmap(this.mCoverBitmap, null, paramRect, paramPaint);
        break;
      }
      if ((this.mParams != null) && (this.mParams.mCoverLoadingDrawable != null))
      {
        if (!this.mParams.mCoverLoadingDrawable.getBounds().equals(paramRect)) {
          this.mParams.mCoverLoadingDrawable.setBounds(paramRect);
        }
        this.mParams.mCoverLoadingDrawable.draw(paramCanvas);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w(TAG + this.ID, 2, "draw(): nothing to draw");
      break;
    }
    QLog.w(TAG + this.ID, 2, "draw(): mVideoPlayer == null, mPaused = " + this.mPaused + ", mPlayCompleted = " + this.mPlayCompleted + ",mState=" + getStateStr(this.mState.get()));
  }
  
  protected void finalize()
    throws Throwable
  {
    if (this.mVideoPlayer != null) {
      release();
    }
  }
  
  public int getByteSize()
  {
    return 0 + Utils.getBitmapSize(this.mCoverBitmap) + Utils.getBitmapSize(this.mCurFrameBitmap);
  }
  
  public long getCurrentPosition()
  {
    long l = -1L;
    if (this.mVideoPlayer != null) {
      l = this.mVideoPlayer.getCurrentPostion();
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "getCurrentPosition() curPosi = " + l);
    }
    return l;
  }
  
  public int getHeight()
  {
    if (this.mCurFrameBitmap != null)
    {
      if ((this.mRotation == 0) || (this.mRotation == 180)) {
        return this.mCurFrameBitmap.getHeight();
      }
      return this.mCurFrameBitmap.getWidth();
    }
    if (this.mCoverBitmap != null) {
      return this.mCoverBitmap.getHeight();
    }
    if (this.mParams != null) {
      return this.mParams.mPreviewHeight;
    }
    return 0;
  }
  
  public int getPlayState()
  {
    return this.mState.get();
  }
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramInt);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramInt);
  }
  
  public int getWidth()
  {
    if (this.mCurFrameBitmap != null)
    {
      if ((this.mRotation == 0) || (this.mRotation == 180)) {
        return this.mCurFrameBitmap.getWidth();
      }
      return this.mCurFrameBitmap.getHeight();
    }
    if (this.mCoverBitmap != null) {
      return this.mCoverBitmap.getWidth();
    }
    if (this.mParams != null) {
      return this.mParams.mPreviewWidth;
    }
    return 0;
  }
  
  protected void initAndStartPlayer(final int paramInt)
  {
    if (this.mPaused) {
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "initAndStartPlayer(): paused, just return");
      }
    }
    do
    {
      return;
      if ((this.mState.get() != 9) && (this.mState.get() != 8)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.w(TAG + this.ID, 2, "initAndStartPlayer(): initialed or preparing, just return");
    return;
    changeStateAndNotify(3, null);
    final Context localContext = getApplicationContext();
    URLDrawable.sDefaultDrawableParms.mURLDrawableExecutor.execute(new Runnable()
    {
      public void run()
      {
        if (!QQLiveImage.mSDKInited)
        {
          TVK_SDKMgr.setDebugEnable(QQLiveImage.mIsDebugEnable);
          TVK_SDKMgr.initSdk(localContext, "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==", "");
          TVK_SDKMgr.setPreloadMaxStorageSize(524288000L);
          TVK_SDKMgr.setOnLogListener(new QQLiveImage.OnLogListener(null));
          QQLiveImage.access$302(true);
        }
        if (!TVK_SDKMgr.isInstalled(localContext))
        {
          if (QLog.isColorLevel()) {
            QLog.e(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initAndStartPlayer(): TVK_SDKMgr not install, mInstallProgress = " + QQLiveImage.mInstallProgress);
          }
          if (QQLiveImage.mInstallProgress.get()) {}
        }
        final QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams;
        do
        {
          try
          {
            TVK_SDKMgr.installPlugin(localContext, new QQLiveImage.SDKInstallListener(null));
            return;
          }
          catch (Exception localException1)
          {
            while (!QLog.isColorLevel()) {}
            QLog.e(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initAndStartPlayer(): Exception happens in TVK_SDKMgr.installPlugin", localException1);
            return;
          }
          localQQLiveDrawableParams = QQLiveImage.this.mParams;
        } while (localQQLiveDrawableParams == null);
        int i;
        if (localQQLiveDrawableParams.mDataSourceType == 2)
        {
          if (localQQLiveDrawableParams.mDataSourceAdapter == null) {
            break label942;
          }
          synchronized (QQLiveImage.this)
          {
            if (localQQLiveDrawableParams.mDataSourceAdapter == null) {
              break label340;
            }
            i = localQQLiveDrawableParams.mDataSourceAdapter.getStaus();
            if (QLog.isColorLevel()) {
              QLog.d(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initAndStartPlayer(): DATA_SOURCE_TYPE_THIRD，status = " + i);
            }
            if (i == 0)
            {
              localQQLiveDrawableParams.mDataSourceAdapter.requestPrepare(localQQLiveDrawableParams.mDataSource, new AbsThirdDataSourceAdapter.OnPreparedCallback()
              {
                public void onPrepared()
                {
                  if (QLog.isColorLevel()) {
                    QLog.d(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initAndStartPlayer(): DATA_SOURCE_TYPE_THIRD，onPrepared: ");
                  }
                  if (localQQLiveDrawableParams != null) {
                    QQLiveImage.this.initAndStartPlayer(localQQLiveDrawableParams.mStartPosi);
                  }
                }
              });
              return;
            }
          }
          if (i == 1)
          {
            return;
            label340:
            if (QLog.isColorLevel()) {
              QLog.e(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initAndStartPlayer(): DATA_SOURCE_TYPE_THIRD，mParams.mDataSourceAdapter == null 1 ");
            }
            return;
          }
        }
        if (QQLiveImage.this.mfactory == null) {
          QQLiveImage.access$602(QQLiveImage.this, TVK_SDKMgr.getProxyFactory());
        }
        long l;
        if (QQLiveImage.this.mVideoPlayer == null) {
          synchronized (QQLiveImage.this)
          {
            if (QQLiveImage.this.mVideoPlayer == null)
            {
              QQLiveImage.access$702(QQLiveImage.this, QQLiveImage.this.mfactory.createMediaPlayer(localContext, null));
              if (QLog.isColorLevel()) {
                QLog.d(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initAndStartPlayer(): Runnable start ====> startPosi = " + paramInt);
              }
              QQLiveImage.access$802(QQLiveImage.this, SystemClock.uptimeMillis());
              if (QQLiveImage.this.mLastPlayerReleaseTime <= 0L) {
                break label1073;
              }
              l = SystemClock.uptimeMillis() - QQLiveImage.this.mLastPlayerReleaseTime;
              label556:
              QQLiveImage.this.changeStateAndNotify(8, Long.valueOf(l));
              QQLiveImage.access$1102(QQLiveImage.this, new TVK_UserInfo("", ""));
              if (localObject1.mDataSourceType != 0) {
                break label1080;
              }
              QQLiveImage.access$1202(QQLiveImage.this, new TVK_PlayerVideoInfo(8, localObject1.mDataSource, ""));
              label620:
              if (localObject1.mPlayType != 1) {
                break label1098;
              }
              QQLiveImage.this.mPlayerinfo.setPlayType(1);
              label640:
              QQLiveImage.this.mPlayerinfo.setPlayMode("extern_video_output");
              ??? = new HashMap();
              if (TextUtils.isEmpty(localObject1.mReportTag)) {
                break label1236;
              }
              ((Map)???).put("shouq_bus_type", localObject1.mReportTag);
              label688:
              if (QLog.isColorLevel()) {
                QLog.d(QQLiveImage.TAG, 2, "initAndStartPlayer(): report tag=" + localObject1.mReportTag);
              }
              QQLiveImage.this.mPlayerinfo.setReportInfoMap((Map)???);
              if (!TextUtils.isEmpty(localObject1.mServerType)) {
                QQLiveImage.this.mPlayerinfo.setConfigMap("cache_servers_type", localObject1.mServerType);
              }
              if (!TextUtils.isEmpty(localObject1.mSavePath)) {
                QQLiveImage.this.mPlayerinfo.setConfigMap("file_dir", localObject1.mSavePath);
              }
              if (localObject1.mDuraion > 0) {
                QQLiveImage.this.mPlayerinfo.setConfigMap("duration", String.valueOf(localObject1.mDuraion));
              }
              if (!TextUtils.isEmpty(localObject1.mVid)) {
                QQLiveImage.this.mPlayerinfo.setVid(localObject1.mVid);
              }
              QQLiveImage.this.mPlayerinfo.addExtraParamsMap("shouq_bus_type", "bus_type_kandian_feeds");
            }
          }
        }
        for (;;)
        {
          try
          {
            ??? = QQLiveImage.this;
            if (??? != null)
            {
              TVK_IMediaPlayer localTVK_IMediaPlayer = QQLiveImage.this.mVideoPlayer;
              if (localTVK_IMediaPlayer != null) {}
            }
            else
            {
              try
              {
                return;
              }
              finally {}
              label942:
              return;
              if (QLog.isColorLevel()) {
                QLog.w(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initAndStartPlayer(): mVideoPlayer has been initialed, 1 just return");
              }
              return;
              localObject3 = finally;
              throw localObject3;
              return;
              label1073:
              l = -1L;
              break label556;
              label1080:
              QQLiveImage.access$1202(QQLiveImage.this, new TVK_PlayerVideoInfo());
              break label620;
              label1098:
              if (localObject3.mPlayType == 2)
              {
                QQLiveImage.this.mPlayerinfo.setPlayType(4);
                break label640;
              }
              if ((localObject3.mPlayType == 3) && (localObject3.mDataSourceAdapter != null))
              {
                i = QQLiveImage.this.mParams.mDataSourceAdapter.getPlayType();
                if (i == 2)
                {
                  QQLiveImage.this.mPlayerinfo.setPlayType(4);
                  break label640;
                }
                if (i == 1)
                {
                  QQLiveImage.this.mPlayerinfo.setPlayType(1);
                  break label640;
                }
                if (i == 0)
                {
                  QQLiveImage.this.mPlayerinfo.setPlayType(2);
                  break label640;
                }
                QQLiveImage.this.mPlayerinfo.setPlayType(2);
                break label640;
              }
              QQLiveImage.this.mPlayerinfo.setPlayType(2);
              break label640;
              label1236:
              ((Map)???).put("shouq_bus_type", "bus_type_aio");
              break label688;
            }
            QQLiveImage.this.mVideoPlayer.setOnVideoOutputFrameListener((TVK_IMediaPlayer.OnVideoOutputFrameListener)???);
            QQLiveImage.this.mVideoPlayer.setOnInfoListener((TVK_IMediaPlayer.OnInfoListener)???);
            QQLiveImage.this.mVideoPlayer.setOnPreAdListener((TVK_IMediaPlayer.OnPreAdListener)???);
            QQLiveImage.this.mVideoPlayer.setOnCompletionListener((TVK_IMediaPlayer.OnCompletionListener)???);
            QQLiveImage.this.mVideoPlayer.setOnVideoPreparedListener((TVK_IMediaPlayer.OnVideoPreparedListener)???);
            QQLiveImage.this.mVideoPlayer.setOnErrorListener((TVK_IMediaPlayer.OnErrorListener)???);
            QQLiveImage.this.mVideoPlayer.setOnSeekCompleteListener((TVK_IMediaPlayer.OnSeekCompleteListener)???);
            QQLiveImage.this.mVideoPlayer.setOnDownloadCallback((TVK_IMediaPlayer.OnDownloadCallbackListener)???);
            QQLiveImage.this.mVideoPlayer.setLoopback(localObject3.mLoopback);
            QQLiveImage.this.mVideoPlayer.setOutputMute(localObject3.mMute);
            if (localObject3.mDataSourceType != 0) {
              continue;
            }
            QQLiveImage.this.mVideoPlayer.openMediaPlayer(QQLiveImage.getApplicationContext(), QQLiveImage.this.mUserinfo, QQLiveImage.this.mPlayerinfo, "sd", paramInt, 0L);
          }
          catch (Exception localException2)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initAndStartPlayer(): error happens in openMediaPlayer ", localException2);
            QQLiveImage.this.onError(QQLiveImage.this.mVideoPlayer, 0, 0, 0, "inner error when openMediaPlayer", null);
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initAndStartPlayer(): <==== runnable end ");
            continue;
            if (localException2.mDataSourceType != 2) {
              break label1762;
            }
            if ((localException2.mDataSourceAdapter == null) || (localException2.mDataSourceAdapter.getStaus() != 2)) {
              continue;
            }
            QQLiveImage.this.mVideoPlayer.openMediaPlayerByUrl(QQLiveImage.getApplicationContext(), localException2.mDataSourceAdapter.getURL(), paramInt, 0L, QQLiveImage.this.mPlayerinfo);
            continue;
          }
          finally
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initAndStartPlayer(): <==== runnable end ");
          }
          QQLiveImage.this.changeStateAndNotify(9, null);
          if (QLog.isColorLevel()) {
            QLog.d(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "initAndStartPlayer(): <==== runnable end ");
          }
          return;
          if (localObject3.mDataSourceType == 1) {
            QQLiveImage.this.mVideoPlayer.openMediaPlayerByUrl(QQLiveImage.getApplicationContext(), localObject3.mDataSource, paramInt, 0L, QQLiveImage.this.mPlayerinfo);
          } else {
            label1762:
            if (localObject4.mDataSourceType == 3) {
              QQLiveImage.this.mVideoPlayer.openMediaPlayerByUrl(QQLiveImage.getApplicationContext(), localObject4.mDataSource, paramInt, 0L, QQLiveImage.this.mPlayerinfo);
            } else if (localObject4.mDataSourceType == 4) {
              QQLiveImage.this.mVideoPlayer.openMediaPlayerByUrl(QQLiveImage.getApplicationContext(), localObject4.mUrls, paramInt, 0L, QQLiveImage.this.mPlayerinfo, null);
            }
          }
        }
      }
    });
  }
  
  protected void invalidateSelf()
  {
    Vector localVector = this.mDrawableList;
    int i = 0;
    for (;;)
    {
      Object localObject1;
      int j;
      try
      {
        if (i < this.mDrawableList.size())
        {
          localObject1 = (WeakReference)this.mDrawableList.get(i);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
          {
            localObject1 = this.mDrawableList;
            j = i - 1;
          }
        }
      }
      finally {}
      try
      {
        ((Vector)localObject1).remove(i);
        i = j;
        i += 1;
      }
      finally
      {
        break;
      }
      ((QQLiveDrawable)((WeakReference)localObject1).get()).invalidateSelf();
      continue;
      return;
    }
    throw localObject2;
  }
  
  public boolean isPaused()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "isPaused(): mPaused = " + this.mPaused);
    }
    return this.mPaused;
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onCompletion(): ");
    }
    asyncReleasePlayer(false);
    this.mPrepared = false;
    this.mPlayCompleted = true;
    changeStateAndNotify(6, null);
  }
  
  public void onDetachedFromWindow()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "onDetachedFromWindow() ");
    }
    if (this.mParams != null)
    {
      this.mParams.mListener = null;
      this.mParams.mDownloadListener = null;
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    this.mErrorInfo.model = paramInt1;
    this.mErrorInfo.what = paramInt2;
    this.mErrorInfo.extra = paramInt3;
    this.mErrorInfo.detailInfo = paramString;
    this.mErrorInfo.info = paramObject;
    if (QLog.isColorLevel())
    {
      paramString = TAG + this.ID;
      paramObject = new StringBuilder().append("[TVK_IMediaPlayer] onError(): \n").append(this.mErrorInfo.toString()).append("\n");
      if (this.mParams != null) {
        break label152;
      }
    }
    label152:
    for (paramTVK_IMediaPlayer = "mParams=null";; paramTVK_IMediaPlayer = this.mParams.toString())
    {
      QLog.e(paramString, 2, paramTVK_IMediaPlayer);
      asyncReleasePlayer(false);
      this.mPrepared = false;
      changeStateAndNotify(5, this.mErrorInfo);
      return false;
    }
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onInfo(): 视频开始缓冲==>");
      }
      changeStateAndNotify(3, null);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onInfo(): 视频缓冲结束<==");
      }
      changeStateAndNotify(2, null);
    }
  }
  
  public void onPreAdPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onPreAdPrepared(): adDuration = " + paramLong);
    }
    this.mVideoPlayer.start();
  }
  
  public void onPreAdPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onPreAdPreparing(): ");
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (!this.mPaused)
    {
      if (this.mVideoPlayer != null) {
        this.mVideoPlayer.start();
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "[TVK_IMediaPlayer] onSeekComplete, start ");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e(TAG + this.ID, 2, "[TVK_IMediaPlayer] onSeekComplete, paused, just return.");
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (!this.mPaused)
    {
      if (this.mVideoPlayer != null) {
        this.mVideoPlayer.start();
      }
      int i = paramTVK_IMediaPlayer.getVideoWidth();
      int j = paramTVK_IMediaPlayer.getVideoHeight();
      if (this.mStartPlayTime > 0L) {
        this.mPrepareTime = (SystemClock.uptimeMillis() - this.mStartPlayTime);
      }
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("prepareTime:").append(this.mPrepareTime).append("\n");
      localStringBuilder.append("width:").append(i).append("\n");
      localStringBuilder.append("height:").append(j).append("\n");
      paramTVK_IMediaPlayer = paramTVK_IMediaPlayer.getPlayDetailsTime();
      if (paramTVK_IMediaPlayer != null)
      {
        Iterator localIterator = paramTVK_IMediaPlayer.keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          localStringBuilder.append(localObject).append(" ：").append(paramTVK_IMediaPlayer.get(localObject)).append("\n");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(TAG + this.ID, 2, "[TVK_IMediaPlayer] onVideoPrepared():  " + localStringBuilder.toString());
      }
    }
    for (;;)
    {
      this.mPrepared = true;
      changeStateAndNotify(1, null);
      return;
      QLog.e(TAG + this.ID, 1, "[TVK_IMediaPlayer] onVideoPrepared(): But paused, return. ");
    }
  }
  
  public void pause()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((!this.mPaused) && (!this.mPlayCompleted) && (this.mState.get() != 6) && (this.mState.get() != 5)) {
      if (this.mVideoPlayer == null) {
        break label227;
      }
    }
    for (;;)
    {
      try
      {
        if (this.mVideoPlayer == null) {
          break label216;
        }
        if (this.mVideoPlayer.isPlaying())
        {
          localStringBuilder.append("step: mVideoPlayer.isPlaying, pause;");
          this.mVideoPlayer.pause();
          this.mPaused = true;
          changeStateAndNotify(4, null);
          QLog.d(TAG + this.ID, 1, "pause():  " + localStringBuilder.toString());
          return;
        }
        if (this.mVideoPlayer.isPauseing())
        {
          localStringBuilder.append("step: mVideoPlayer.isPauseing, do nothing;");
          continue;
        }
        localObject.append("step: player unknow status，prepared=" + this.mPrepared);
      }
      finally {}
      continue;
      label216:
      localObject.append("step: player = null.");
      continue;
      label227:
      localObject.append("step: player = null.");
    }
  }
  
  public void recyleAndKeepPostion()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.mVideoPlayer;
    if (this.mVideoPlayer != null)
    {
      this.mReclyed = true;
      this.mPlayPostionWhenRecyle = ((int)this.mVideoPlayer.getCurrentPostion());
      asyncReleasePlayer(true);
      this.mLastPlayerReleaseTime = SystemClock.uptimeMillis();
    }
    this.mOnStateListener = null;
    this.mDownloadListener = null;
    this.mPaused = false;
    this.mPrepared = false;
    this.mPrepareTime = 0L;
    this.mStartPlayTime = 0L;
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "recyleAndKeepPostion()：mPlayPostionWhenRecyle = " + this.mPlayPostionWhenRecyle + ", mReclyed = " + this.mReclyed + ", mVideoPlayer=" + localTVK_IMediaPlayer);
    }
  }
  
  public void release()
  {
    asyncReleasePlayer(false);
    synchronized (this.mLock)
    {
      this.mCurFrameBitmap = null;
      this.mRotatedBitmap = null;
      this.mCover = null;
      this.mCoverBitmap = null;
      this.mOnStateListener = null;
      this.mDownloadListener = null;
      if (this.mParams == null) {}
    }
  }
  
  public void replay()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((this.mState.get() == 6) && (this.mPlayCompleted) && (this.mVideoPlayer == null))
    {
      this.mPlayCompleted = false;
      localStringBuilder.append(" mPlayCompleted, replay!");
      invalidateSelf();
      changeStateAndNotify(3, null);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "replay(): " + localStringBuilder.toString());
    }
  }
  
  public void resume()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((this.mState.get() != 5) && (this.mState.get() != 6) && (!this.mPlayCompleted)) {
      if (this.mVideoPlayer != null) {
        if (this.mVideoPlayer.isPlaying())
        {
          localStringBuilder.append("step: mVideoPlayer.isPlaying, do nothing;");
          this.mPaused = false;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG + this.ID, 2, "resume(): " + localStringBuilder.toString());
      }
      return;
      if (this.mVideoPlayer.isPauseing())
      {
        this.mVideoPlayer.start();
        localStringBuilder.append("step: mVideoPlayer.isPauseing, start;");
        break;
      }
      localStringBuilder.append("step: #player unknow status#").append(", playState=" + getStateStr(this.mState.get()));
      if (this.mPrepared)
      {
        this.mVideoPlayer.start();
        localStringBuilder.append(" prepared. start;");
        break;
      }
      localStringBuilder.append(" not prepared. wait buffering;");
      changeStateAndNotify(3, null);
      break;
      localStringBuilder.append("step: player = null.");
      invalidateSelf();
      changeStateAndNotify(3, null);
      if ((!this.mReclyed) || (this.mPlayPostionWhenRecyle <= -1) || (this.mParams == null)) {
        break;
      }
      localStringBuilder.append("step: mReclyed, mPlayPostionWhenRecyle:").append(this.mPlayPostionWhenRecyle);
      this.mParams.mStartPosi = this.mPlayPostionWhenRecyle;
      this.mReclyed = false;
      this.mPlayPostionWhenRecyle = -1;
      break;
      if (this.mState.get() == 5)
      {
        changeStateAndNotify(5, null);
        localStringBuilder.append("step: STATE_ERROR, just notify");
      }
    }
  }
  
  public void resumeFromPosi(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    if ((this.mState.get() != 5) && (this.mState.get() != 6) && (!this.mPlayCompleted))
    {
      if (this.mVideoPlayer == null) {
        break label287;
      }
      if (!this.mVideoPlayer.isPlaying()) {
        break label155;
      }
      localStringBuilder.append("step: mVideoPlayer.isPlaying, seekto");
      this.mVideoPlayer.seekTo(paramInt);
    }
    for (;;)
    {
      this.mPaused = false;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(TAG + this.ID, 2, "resumeFromPosi(): " + localStringBuilder.toString() + ", position = " + paramInt);
      return;
      label155:
      if (this.mVideoPlayer.isPauseing())
      {
        localStringBuilder.append("step: mVideoPlayer.isPauseing, seekto;");
        this.mVideoPlayer.seekTo(paramInt);
      }
      else
      {
        localStringBuilder.append("step: #player unknow status#").append(", playState=" + getStateStr(this.mState.get()));
        if (this.mPrepared)
        {
          this.mVideoPlayer.seekTo(paramInt);
          localStringBuilder.append(" prepared. seekTo;");
        }
        else
        {
          localStringBuilder.append(" not prepared. reset, wait buffering;");
          invalidateSelf();
          asyncReleasePlayer(false);
          this.mPrepared = false;
          changeStateAndNotify(3, null);
          continue;
          label287:
          localStringBuilder.append("step: player = null.");
          this.mPrepared = false;
          invalidateSelf();
          changeStateAndNotify(3, null);
        }
      }
    }
  }
  
  protected void setOnDownloadListener(QQLiveDrawable.OnDownloadListener paramOnDownloadListener)
  {
    this.mDownloadListener = paramOnDownloadListener;
  }
  
  protected void setOnStateListener(QQLiveDrawable.OnStateListener paramOnStateListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG + this.ID, 2, "setOnStateListener(): mState = " + getStateStr(this.mState.get()) + ", AndNotify");
    }
    this.mOnStateListener = paramOnStateListener;
    final int i = this.mState.get();
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if (QQLiveImage.this.mOnStateListener != null) {
          QQLiveImage.this.mOnStateListener.onStateChange(QQLiveImage.this.mUrlStr, QQLiveImage.this.mParams, i, null);
        }
      }
    });
  }
  
  class EventHandler
    extends Handler
  {
    public EventHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      QQLiveImage.this.invalidateSelf();
    }
  }
  
  private static class OnLogListener
    implements TVK_SDKMgr.OnLogListener
  {
    public int d(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(paramString1, 2, paramString2);
      }
      return 0;
    }
    
    public int e(String paramString1, String paramString2)
    {
      QLog.e(paramString1, 1, paramString2);
      return 0;
    }
    
    public int i(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.i(paramString1, 2, paramString2);
      }
      return 0;
    }
    
    public int v(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(paramString1, 2, paramString2);
      }
      return 0;
    }
    
    public int w(String paramString1, String paramString2)
    {
      if (QLog.isColorLevel()) {
        QLog.w(paramString1, 2, paramString2);
      }
      return 0;
    }
  }
  
  class ReleaseTask
    implements Runnable
  {
    boolean keepPosition;
    TVK_IMediaPlayer videoPlayer;
    
    public ReleaseTask(TVK_IMediaPlayer paramTVK_IMediaPlayer, boolean paramBoolean)
    {
      this.videoPlayer = paramTVK_IMediaPlayer;
      this.keepPosition = paramBoolean;
    }
    
    public void run()
    {
      if (this.videoPlayer != null)
      {
        long l1 = SystemClock.uptimeMillis();
        TVK_IMediaPlayer localTVK_IMediaPlayer = this.videoPlayer;
        if (this.keepPosition) {
          QQLiveImage.access$1302(QQLiveImage.this, (int)this.videoPlayer.getCurrentPostion());
        }
        this.videoPlayer.stop();
        this.videoPlayer.release();
        this.videoPlayer = null;
        long l2 = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
          QLog.w(QQLiveImage.TAG + QQLiveImage.this.ID, 2, "ReleaseTask release TVK_IMediaPlayer =" + localTVK_IMediaPlayer + "，cost = " + (l2 - l1) + "ms");
        }
      }
    }
  }
  
  private static class SDKInstallListener
    implements TVK_SDKMgr.InstallListener
  {
    public void onInstallProgress(float paramFloat)
    {
      QQLiveImage.mInstallProgress.set(false);
      if (QLog.isDevelopLevel()) {
        QLog.d(QQLiveImage.TAG, 4, "[SDKInstallListener] onInstallProgress(): v= " + paramFloat);
      }
    }
    
    public void onInstalledFailed(int paramInt)
    {
      QQLiveImage.mInstallProgress.set(false);
      if (QLog.isColorLevel()) {
        QLog.e(QQLiveImage.TAG, 2, "[SDKInstallListener] onInstalledFailed():");
      }
    }
    
    public void onInstalledSuccessed()
    {
      if (QLog.isColorLevel()) {
        QLog.d(QQLiveImage.TAG, 2, "[SDKInstallListener] onInstalledSuccessed():");
      }
      QQLiveImage.mInstallProgress.set(false);
      for (;;)
      {
        int i;
        try
        {
          if (QQLiveImage.sImageList != null)
          {
            i = 0;
            if (i < QQLiveImage.sImageList.size())
            {
              QQLiveImage localQQLiveImage = (QQLiveImage)QQLiveImage.sImageList.get(i);
              if ((localQQLiveImage == null) || (localQQLiveImage.mParams == null)) {
                break label89;
              }
              localQQLiveImage.initAndStartPlayer(localQQLiveImage.mParams.mStartPosi);
              break label89;
            }
          }
          return;
        }
        finally {}
        label89:
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveImage
 * JD-Core Version:    0.7.0.1
 */
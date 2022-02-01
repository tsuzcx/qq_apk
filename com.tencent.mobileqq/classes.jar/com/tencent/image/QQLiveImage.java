package com.tencent.image;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.image.api.ILog;
import com.tencent.image.api.IThreadManager;
import com.tencent.image.api.ITool;
import com.tencent.image.api.URLDrawableDepWrap;
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
import com.tencent.qqlive.mediaplayer.api.TVK_UserInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class QQLiveImage
  implements TVK_IMediaPlayer.OnCompletionListener, TVK_IMediaPlayer.OnDownloadCallbackListener, TVK_IMediaPlayer.OnErrorListener, TVK_IMediaPlayer.OnInfoListener, TVK_IMediaPlayer.OnPreAdListener, TVK_IMediaPlayer.OnSeekCompleteListener, TVK_IMediaPlayer.OnVideoOutputFrameListener, TVK_IMediaPlayer.OnVideoPreparedListener
{
  static final int MSG_TYPE_REFRESH = 1;
  public static final long SD_CACHE_LIMIT = 524288000L;
  public static final String TAG;
  public static final String TencentVideoSdkAppKey = "qlZy1cUgJFUcdIxwLCxe2Bwl2Iy1G1W1Scj0JYW0q2gNAn3XAYvu6kgSaMFDI+caBVR6jDCu/2+MMP/ 5+bNIv+d+bn4ihMBUKcpWIDySGIAv7rlarJXCev4i7a0qQD2f3s6vtdD9YdQ81ZyeA+nD0MenBGrPPd GeDBvIFQSGz4jB4m6G4fa2abCqy1JQc+r+OGk6hVJQXMGpROgPiIGlF3o/sHuBblmfwvIDtYviSIKD4 UGd0IeJn/IqVI3vUZ3ETgea6FkqDoA00SrTlTYfJUJk/h2lk1rkibIkQMPZhVjI2HYDxV4y501Xj2vD fjFPoNJImVtMjdE2BIIEawxYKA==";
  private static AtomicBoolean mInstallProgress = new AtomicBoolean(false);
  public static boolean mIsDebugEnable;
  static ReentrantLock mLockForImageList;
  private static boolean mSDKInited;
  private static boolean sAllPaused;
  private static volatile int sCurFgActivityHash;
  private static volatile boolean sEnableUSRLog;
  private static volatile ArrayList<QQLiveImage> sImageList;
  private static volatile boolean sIsForeground;
  protected int ID = 0;
  long lastPosi = 0L;
  protected Canvas mCanvas;
  private URLDrawable mCover;
  protected WeakReference<Bitmap> mCoverBitmapRef;
  protected volatile Bitmap mCurFrameBitmap;
  private long mCurPosi;
  private int mDensity = 160;
  protected QQLiveDrawable.OnDownloadListener mDownloadListener;
  private Vector<WeakReference<QQLiveDrawable>> mDrawableList = new Vector();
  private QQLiveDrawable.ErrorInfo mErrorInfo = new QQLiveDrawable.ErrorInfo();
  int mFrameIndex = 0;
  protected Handler mHandler = new QQLiveImage.EventHandler(this, Looper.getMainLooper());
  private long mLastPlayerReleaseTime;
  ReentrantLock mLock = new ReentrantLock();
  protected QQLiveDrawable.OnLoopBackListener mLoopBackListener;
  protected Matrix mMatrix;
  protected WeakReference<QQLiveDrawable.OnStateListener> mOnStateListener;
  protected QQLiveDrawable.QQLiveDrawableParams mParams;
  private volatile boolean mPaused = false;
  private boolean mPlayCompleted = false;
  private int mPlayPostionWhenRecyle = -1;
  private TVK_PlayerVideoInfo mPlayerinfo = null;
  private long mPrepareTime;
  private boolean mPrepared = false;
  private volatile boolean mReclyed = false;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQLiveImage.class.getSimpleName());
    localStringBuilder.append("_");
    TAG = localStringBuilder.toString();
    mIsDebugEnable = true;
    mLockForImageList = new ReentrantLock();
    sEnableUSRLog = false;
    mSDKInited = false;
  }
  
  public QQLiveImage(String paramString, Object paramObject)
  {
    this.mUrlStr = paramString;
    this.ID = paramString.hashCode();
    if (paramString.startsWith("qqlive"))
    {
      if ((paramObject != null) && ((paramObject instanceof QQLiveDrawable.QQLiveDrawableParams)))
      {
        this.mParams = ((QQLiveDrawable.QQLiveDrawableParams)paramObject);
        setOnStateListener(this.mParams.mListener);
        setOnDownloadListener(this.mParams.mDownloadListener);
        setOnLoopBackListener(this.mParams.mLoopBackListener);
      }
      initCover(this.mParams.mCoverUrl);
      addToList(this);
      paramObject = URLDrawable.depImp.mLog;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(this.ID);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QQLiveVideo(): url = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mParams=");
      localStringBuilder.append(this.mParams.toString());
      paramObject.d((String)localObject, 1, localStringBuilder.toString());
      if ((sAllPaused) && (!this.mPaused))
      {
        pause();
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          paramString = URLDrawable.depImp.mLog;
          paramObject = new StringBuilder();
          paramObject.append(TAG);
          paramObject.append(this.ID);
          paramString.d(paramObject.toString(), 2, "QQLiveVideo(): 全局已经暂停，但是实例创建未暂停，这里主动停一下 ");
        }
      }
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("Wrong format url! str=");
    paramObject.append(paramString);
    throw new IllegalStateException(paramObject.toString());
  }
  
  /* Error */
  private static void addToList(QQLiveImage paramQQLiveImage)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: iconst_0
    //   6: istore_2
    //   7: getstatic 130	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   10: invokevirtual 342	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   13: getstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   16: ifnonnull +13 -> 29
    //   19: new 344	java/util/ArrayList
    //   22: dup
    //   23: invokespecial 345	java/util/ArrayList:<init>	()V
    //   26: putstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   29: iload_2
    //   30: istore_1
    //   31: getstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   34: aload_0
    //   35: invokevirtual 349	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   38: ifne +58 -> 96
    //   41: getstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   44: aload_0
    //   45: invokevirtual 352	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: iconst_1
    //   50: istore_1
    //   51: goto +45 -> 96
    //   54: astore_0
    //   55: goto +118 -> 173
    //   58: astore_3
    //   59: iload_2
    //   60: istore_1
    //   61: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   64: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   67: invokeinterface 286 1 0
    //   72: ifeq +24 -> 96
    //   75: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   78: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   81: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   84: iconst_2
    //   85: ldc_w 354
    //   88: aload_3
    //   89: invokeinterface 358 5 0
    //   94: iload_2
    //   95: istore_1
    //   96: getstatic 130	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   99: invokevirtual 361	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   102: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   105: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   108: astore_3
    //   109: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   112: astore 4
    //   114: new 103	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   121: astore 5
    //   123: aload 5
    //   125: ldc_w 363
    //   128: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 5
    //   134: iload_1
    //   135: invokevirtual 366	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 5
    //   141: ldc_w 368
    //   144: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 5
    //   150: aload_0
    //   151: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   154: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_3
    //   159: aload 4
    //   161: iconst_1
    //   162: aload 5
    //   164: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokeinterface 371 4 0
    //   172: return
    //   173: getstatic 130	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   176: invokevirtual 361	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   179: aload_0
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramQQLiveImage	QQLiveImage
    //   30	105	1	bool1	boolean
    //   6	89	2	bool2	boolean
    //   58	31	3	localException	Exception
    //   108	51	3	localILog	ILog
    //   112	48	4	str	String
    //   121	42	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   7	29	54	finally
    //   31	49	54	finally
    //   61	94	54	finally
    //   7	29	58	java/lang/Exception
    //   31	49	58	java/lang/Exception
  }
  
  private void asyncReleasePlayer(boolean paramBoolean)
  {
    this.mState.set(10);
    if (this.mVideoPlayer != null) {
      try
      {
        if (this.mVideoPlayer != null)
        {
          this.mVideoPlayer.removeAllListener();
          URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(new QQLiveImage.ReleaseTask(this, this.mVideoPlayer, paramBoolean), null, false);
          this.mVideoPlayer = null;
        }
        return;
      }
      finally {}
    }
  }
  
  private void changeStateAndNotify(int paramInt, Object paramObject)
  {
    if (paramInt != this.mState.get())
    {
      if ((URLDrawable.depImp.mLog.isColorLevel()) || (sEnableUSRLog))
      {
        ILog localILog = URLDrawable.depImp.mLog;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(TAG);
        ((StringBuilder)localObject).append(this.ID);
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeStateAndNotify(): ");
        localStringBuilder.append(getStateStr(this.mState.get()));
        localStringBuilder.append(" ===> ");
        localStringBuilder.append(getStateStr(paramInt));
        localStringBuilder.append(", extra = ");
        localStringBuilder.append(paramObject);
        localILog.d((String)localObject, 2, localStringBuilder.toString());
      }
      this.mState.set(paramInt);
      this.mHandler.post(new QQLiveImage.6(this, paramInt, paramObject));
    }
  }
  
  static Context getApplicationContext()
  {
    return URLDrawable.depImp.mTool.getContext();
  }
  
  public static ArrayList<QQLiveImage> getImageList()
  {
    return sImageList;
  }
  
  public static String getStateStr(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    default: 
      return "STATE_UNKNOW";
    case 9: 
      return "STATE_PREPARING";
    case 8: 
      return "STATE_INITIALIZED";
    case 6: 
      return "STATE_COMPLETE";
    case 5: 
      return "STATE_ERROR";
    case 4: 
      return "STATE_PAUSE";
    case 3: 
      return "STATE_BUFFERING";
    case 2: 
      return "STATE_PLAYING";
    case 1: 
      return "STATE_PREPARED";
    }
    return "STATE_IDLE";
  }
  
  private void initCover(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject1 = this.mCoverBitmapRef;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
      return;
    }
    try
    {
      this.mCover = URLDrawable.getDrawable(paramString, this.mParams.mCoverWidth, this.mParams.mCoverHeight, this.mParams.mCoverLoadingDrawable, this.mParams.mCoverLoadingDrawable);
      if ((this.mCover.getStatus() == 1) && ((this.mCover.getCurrDrawable() instanceof RegionDrawable)))
      {
        this.mCoverBitmapRef = new WeakReference(((RegionDrawable)this.mCover.getCurrDrawable()).getBitmap());
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          paramString = URLDrawable.depImp.mLog;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(TAG);
          ((StringBuilder)localObject1).append(this.ID);
          paramString.d(((StringBuilder)localObject1).toString(), 2, "initCover(): mCover is loaded: ");
        }
      }
      else
      {
        this.mCover.setURLDrawableListener(new QQLiveImage.4(this));
        this.mCover.startDownload();
      }
      return;
    }
    catch (Exception localException)
    {
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        ILog localILog = URLDrawable.depImp.mLog;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(TAG);
        ((StringBuilder)localObject2).append(this.ID);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initCover(): getDrawable Exception: imgUrl=");
        localStringBuilder.append(paramString);
        localILog.e((String)localObject2, 2, localStringBuilder.toString(), localException);
      }
      this.mCover = null;
    }
  }
  
  public static boolean isAllPaused()
  {
    return sAllPaused;
  }
  
  public static void onBackground(Activity paramActivity)
  {
    if ((paramActivity != null) && (sCurFgActivityHash != 0) && (paramActivity.hashCode() != sCurFgActivityHash))
    {
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        ILog localILog = URLDrawable.depImp.mLog;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onBackground() , curActivityHash = ");
        localStringBuilder.append(paramActivity.hashCode());
        localStringBuilder.append(", sCurFgActivityHash = ");
        localStringBuilder.append(sCurFgActivityHash);
        localILog.d(str, 2, localStringBuilder.toString());
      }
      return;
    }
    if (sIsForeground)
    {
      sIsForeground = false;
      URLDrawable.depImp.mLog.d(TAG, 1, "onBackground()......<==");
      URLDrawable.sDefaultDrawableParms.mSubHandler.post(new QQLiveImage.1());
    }
  }
  
  public static void onForeground(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      sCurFgActivityHash = paramActivity.hashCode();
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramActivity = URLDrawable.depImp.mLog;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onForeground() , sCurFgActivityHash = ");
        localStringBuilder.append(sCurFgActivityHash);
        paramActivity.d(str, 2, localStringBuilder.toString());
      }
    }
    if (!sIsForeground)
    {
      sIsForeground = true;
      URLDrawable.depImp.mLog.d(TAG, 1, "onForeground()......==>");
    }
  }
  
  public static void pauseAll(Activity paramActivity)
  {
    if ((paramActivity != null) && (sCurFgActivityHash != 0) && (paramActivity.hashCode() != sCurFgActivityHash))
    {
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        ILog localILog = URLDrawable.depImp.mLog;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pauseAll() , curActivityHash = ");
        localStringBuilder.append(paramActivity.hashCode());
        localStringBuilder.append(", sCurFgActivityHash = ");
        localStringBuilder.append(sCurFgActivityHash);
        localILog.d(str, 2, localStringBuilder.toString());
      }
      return;
    }
    if (!sAllPaused)
    {
      sAllPaused = true;
      URLDrawable.depImp.mLog.i(TAG, 1, "do pauseAll");
      URLDrawable.sDefaultDrawableParms.mSubHandler.post(new QQLiveImage.3());
    }
  }
  
  /* Error */
  public static void releaseAll(Activity paramActivity)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +104 -> 105
    //   4: getstatic 520	com/tencent/image/QQLiveImage:sCurFgActivityHash	I
    //   7: ifeq +98 -> 105
    //   10: aload_0
    //   11: invokevirtual 521	java/lang/Object:hashCode	()I
    //   14: getstatic 520	com/tencent/image/QQLiveImage:sCurFgActivityHash	I
    //   17: if_icmpeq +88 -> 105
    //   20: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   23: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   26: invokeinterface 286 1 0
    //   31: ifeq +73 -> 104
    //   34: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   37: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   40: astore_2
    //   41: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   44: astore_3
    //   45: new 103	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   52: astore 4
    //   54: aload 4
    //   56: ldc_w 557
    //   59: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 4
    //   65: aload_0
    //   66: invokevirtual 521	java/lang/Object:hashCode	()I
    //   69: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 4
    //   75: ldc_w 525
    //   78: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 4
    //   84: getstatic 520	com/tencent/image/QQLiveImage:sCurFgActivityHash	I
    //   87: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_2
    //   92: aload_3
    //   93: iconst_2
    //   94: aload 4
    //   96: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokeinterface 277 4 0
    //   104: return
    //   105: getstatic 130	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   108: invokevirtual 342	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   111: getstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   114: ifnull +115 -> 229
    //   117: iconst_0
    //   118: istore_1
    //   119: iload_1
    //   120: getstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   123: invokevirtual 560	java/util/ArrayList:size	()I
    //   126: if_icmpge +93 -> 219
    //   129: getstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   132: iload_1
    //   133: invokevirtual 563	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   136: checkcast 2	com/tencent/image/QQLiveImage
    //   139: astore_0
    //   140: aload_0
    //   141: ifnull +157 -> 298
    //   144: aload_0
    //   145: invokevirtual 566	com/tencent/image/QQLiveImage:release	()V
    //   148: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   151: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   154: astore_2
    //   155: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   158: astore_3
    //   159: new 103	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   166: astore 4
    //   168: aload 4
    //   170: ldc_w 568
    //   173: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 4
    //   179: iload_1
    //   180: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 4
    //   186: ldc_w 570
    //   189: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 4
    //   195: aload_0
    //   196: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   199: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_2
    //   204: aload_3
    //   205: iconst_1
    //   206: aload 4
    //   208: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokeinterface 277 4 0
    //   216: goto +82 -> 298
    //   219: getstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   222: invokevirtual 573	java/util/ArrayList:clear	()V
    //   225: aconst_null
    //   226: putstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   229: getstatic 130	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   232: invokevirtual 361	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   235: goto +44 -> 279
    //   238: astore_0
    //   239: goto +45 -> 284
    //   242: astore_0
    //   243: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   246: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   249: invokeinterface 286 1 0
    //   254: ifeq -25 -> 229
    //   257: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   260: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   263: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   266: iconst_2
    //   267: ldc_w 575
    //   270: aload_0
    //   271: invokeinterface 358 5 0
    //   276: goto -47 -> 229
    //   279: iconst_0
    //   280: putstatic 279	com/tencent/image/QQLiveImage:sAllPaused	Z
    //   283: return
    //   284: getstatic 130	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   287: invokevirtual 361	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   290: goto +5 -> 295
    //   293: aload_0
    //   294: athrow
    //   295: goto -2 -> 293
    //   298: iload_1
    //   299: iconst_1
    //   300: iadd
    //   301: istore_1
    //   302: goto -183 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	paramActivity	Activity
    //   118	184	1	i	int
    //   40	164	2	localILog	ILog
    //   44	161	3	str	String
    //   52	155	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   105	117	238	finally
    //   119	140	238	finally
    //   144	216	238	finally
    //   219	229	238	finally
    //   243	276	238	finally
    //   105	117	242	java/lang/Exception
    //   119	140	242	java/lang/Exception
    //   144	216	242	java/lang/Exception
    //   219	229	242	java/lang/Exception
  }
  
  public static void resumeAll(Activity paramActivity)
  {
    if (paramActivity != null)
    {
      sCurFgActivityHash = paramActivity.hashCode();
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramActivity = URLDrawable.depImp.mLog;
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resumeAll() , sCurFgActivityHash = ");
        localStringBuilder.append(sCurFgActivityHash);
        paramActivity.d(str, 2, localStringBuilder.toString());
      }
    }
    if (sAllPaused)
    {
      sAllPaused = false;
      URLDrawable.depImp.mLog.i(TAG, 1, "resumeAll() ");
      URLDrawable.sDefaultDrawableParms.mSubHandler.post(new QQLiveImage.2());
    }
  }
  
  public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt2 != 0)
    {
      if (paramInt2 == paramInt3) {
        return paramInt1;
      }
      i = (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
    }
    return i;
  }
  
  public static void setDebugEnable(boolean paramBoolean)
  {
    mIsDebugEnable = paramBoolean;
  }
  
  public static void setUSRLogEnable(boolean paramBoolean)
  {
    sEnableUSRLog = paramBoolean;
  }
  
  /* Error */
  private static void tryReycleFramesUseless(QQLiveImage paramQQLiveImage)
  {
    // Byte code:
    //   0: getstatic 130	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   3: invokevirtual 591	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   6: ifeq +115 -> 121
    //   9: getstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   12: ifnull +53 -> 65
    //   15: iconst_0
    //   16: istore_1
    //   17: iload_1
    //   18: getstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   21: invokevirtual 560	java/util/ArrayList:size	()I
    //   24: if_icmpge +41 -> 65
    //   27: getstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   30: iload_1
    //   31: invokevirtual 563	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   34: checkcast 2	com/tencent/image/QQLiveImage
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +19 -> 58
    //   42: aload_2
    //   43: invokevirtual 594	com/tencent/image/QQLiveImage:isRecycled	()Z
    //   46: ifeq +12 -> 58
    //   49: aload_2
    //   50: aload_0
    //   51: if_acmpeq +7 -> 58
    //   54: aload_2
    //   55: invokevirtual 597	com/tencent/image/QQLiveImage:recycleCurFrame	()V
    //   58: iload_1
    //   59: iconst_1
    //   60: iadd
    //   61: istore_1
    //   62: goto -45 -> 17
    //   65: getstatic 130	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   68: invokevirtual 361	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   71: return
    //   72: astore_0
    //   73: goto +40 -> 113
    //   76: astore_0
    //   77: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   80: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   83: invokeinterface 286 1 0
    //   88: ifeq -23 -> 65
    //   91: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   94: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   97: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   100: iconst_2
    //   101: ldc_w 599
    //   104: aload_0
    //   105: invokeinterface 358 5 0
    //   110: goto -45 -> 65
    //   113: getstatic 130	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   116: invokevirtual 361	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   119: aload_0
    //   120: athrow
    //   121: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramQQLiveImage	QQLiveImage
    //   16	46	1	i	int
    //   37	18	2	localQQLiveImage	QQLiveImage
    // Exception table:
    //   from	to	target	type
    //   9	15	72	finally
    //   17	38	72	finally
    //   42	49	72	finally
    //   54	58	72	finally
    //   77	110	72	finally
    //   9	15	76	java/lang/Exception
    //   17	38	76	java/lang/Exception
    //   42	49	76	java/lang/Exception
    //   54	58	76	java/lang/Exception
  }
  
  public void OnDownloadCallback(String paramString)
  {
    QQLiveDrawable.OnDownloadListener localOnDownloadListener = this.mDownloadListener;
    if (localOnDownloadListener != null) {
      localOnDownloadListener.OnDownload(this.mUrlStr, this.mParams, paramString);
    }
  }
  
  /* Error */
  public void OnVideoOutputFrame(TVK_IMediaPlayer paramTVK_IMediaPlayer, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: getfield 176	com/tencent/image/QQLiveImage:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   5: if_acmpeq +99 -> 104
    //   8: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   11: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   14: invokeinterface 286 1 0
    //   19: ifeq +84 -> 103
    //   22: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   25: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   28: astore_2
    //   29: new 103	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   36: astore 11
    //   38: aload 11
    //   40: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   43: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 11
    //   49: aload_0
    //   50: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   53: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 11
    //   59: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 11
    //   64: new 103	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   71: astore 12
    //   73: aload 12
    //   75: ldc_w 613
    //   78: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 12
    //   84: aload_1
    //   85: invokevirtual 411	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_2
    //   90: aload 11
    //   92: iconst_1
    //   93: aload 12
    //   95: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokeinterface 615 4 0
    //   103: return
    //   104: aload_0
    //   105: getfield 189	com/tencent/image/QQLiveImage:mPaused	Z
    //   108: ifeq +56 -> 164
    //   111: aload_1
    //   112: invokeinterface 616 1 0
    //   117: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   120: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   123: astore_1
    //   124: new 103	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   131: astore_2
    //   132: aload_2
    //   133: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   136: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_2
    //   141: aload_0
    //   142: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   145: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_1
    //   150: aload_2
    //   151: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: iconst_1
    //   155: ldc_w 618
    //   158: invokeinterface 615 4 0
    //   163: return
    //   164: aload_0
    //   165: getfield 197	com/tencent/image/QQLiveImage:mPlayCompleted	Z
    //   168: ifeq +50 -> 218
    //   171: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   174: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   177: astore_1
    //   178: new 103	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   185: astore_2
    //   186: aload_2
    //   187: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   190: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload_2
    //   195: aload_0
    //   196: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   199: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_1
    //   204: aload_2
    //   205: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: iconst_1
    //   209: ldc_w 620
    //   212: invokeinterface 615 4 0
    //   217: return
    //   218: getstatic 527	com/tencent/image/QQLiveImage:sIsForeground	Z
    //   221: ifne +22 -> 243
    //   224: getstatic 533	com/tencent/image/URLDrawable:sDefaultDrawableParms	Lcom/tencent/image/URLDrawableParams;
    //   227: getfield 538	com/tencent/image/URLDrawableParams:mSubHandler	Landroid/os/Handler;
    //   230: new 622	com/tencent/image/QQLiveImage$8
    //   233: dup
    //   234: aload_0
    //   235: invokespecial 623	com/tencent/image/QQLiveImage$8:<init>	(Lcom/tencent/image/QQLiveImage;)V
    //   238: invokevirtual 421	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   241: pop
    //   242: return
    //   243: aload_0
    //   244: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   247: ifnull +424 -> 671
    //   250: aload_0
    //   251: getfield 176	com/tencent/image/QQLiveImage:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   254: ifnull +417 -> 671
    //   257: aload_0
    //   258: getfield 176	com/tencent/image/QQLiveImage:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   261: invokeinterface 627 1 0
    //   266: lstore 7
    //   268: aload_0
    //   269: lload 7
    //   271: putfield 629	com/tencent/image/QQLiveImage:mCurPosi	J
    //   274: aload_0
    //   275: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   278: getfield 632	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mMaxPlayTimeMs	I
    //   281: ifle +235 -> 516
    //   284: lload 7
    //   286: aload_0
    //   287: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   290: getfield 632	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mMaxPlayTimeMs	I
    //   293: aload_0
    //   294: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   297: getfield 635	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mStartPosi	I
    //   300: iadd
    //   301: i2l
    //   302: lcmp
    //   303: iflt +362 -> 665
    //   306: aload_0
    //   307: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   310: getfield 638	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mLoopback	Z
    //   313: ifeq +194 -> 507
    //   316: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   319: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   322: astore_1
    //   323: new 103	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   330: astore 11
    //   332: aload 11
    //   334: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   337: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 11
    //   343: aload_0
    //   344: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   347: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 11
    //   353: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: astore 11
    //   358: new 103	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   365: astore 12
    //   367: aload 12
    //   369: ldc_w 640
    //   372: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 12
    //   378: aload_0
    //   379: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   382: getfield 635	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mStartPosi	I
    //   385: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_1
    //   390: aload 11
    //   392: iconst_2
    //   393: aload 12
    //   395: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokeinterface 277 4 0
    //   403: aload_0
    //   404: getfield 176	com/tencent/image/QQLiveImage:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   407: aload_0
    //   408: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   411: getfield 635	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mStartPosi	I
    //   414: invokeinterface 643 2 0
    //   419: aload_0
    //   420: getfield 644	com/tencent/image/QQLiveImage:mLoopBackListener	Lcom/tencent/image/QQLiveDrawable$OnLoopBackListener;
    //   423: astore_1
    //   424: aload_1
    //   425: ifnull +240 -> 665
    //   428: aload_1
    //   429: aload_0
    //   430: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   433: lload 7
    //   435: invokeinterface 650 4 0
    //   440: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   443: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   446: invokeinterface 286 1 0
    //   451: ifeq +214 -> 665
    //   454: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   457: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   460: astore_1
    //   461: new 103	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   468: astore 11
    //   470: aload 11
    //   472: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   475: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 11
    //   481: aload_0
    //   482: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   485: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: aload_1
    //   490: aload 11
    //   492: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: iconst_2
    //   496: ldc_w 652
    //   499: invokeinterface 277 4 0
    //   504: goto +161 -> 665
    //   507: aload_0
    //   508: aload_0
    //   509: getfield 176	com/tencent/image/QQLiveImage:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   512: invokevirtual 656	com/tencent/image/QQLiveImage:onCompletion	(Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;)V
    //   515: return
    //   516: aload_0
    //   517: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   520: getfield 638	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mLoopback	Z
    //   523: ifeq +142 -> 665
    //   526: aload_0
    //   527: getfield 644	com/tencent/image/QQLiveImage:mLoopBackListener	Lcom/tencent/image/QQLiveDrawable$OnLoopBackListener;
    //   530: ifnull +135 -> 665
    //   533: aload_0
    //   534: getfield 176	com/tencent/image/QQLiveImage:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   537: invokeinterface 659 1 0
    //   542: lconst_0
    //   543: lcmp
    //   544: ifle +121 -> 665
    //   547: aload_0
    //   548: getfield 172	com/tencent/image/QQLiveImage:lastPosi	J
    //   551: lstore 9
    //   553: lload 7
    //   555: lload 9
    //   557: lcmp
    //   558: ifge +107 -> 665
    //   561: lload 9
    //   563: ldc2_w 660
    //   566: ldiv
    //   567: aload_0
    //   568: getfield 176	com/tencent/image/QQLiveImage:mVideoPlayer	Lcom/tencent/qqlive/mediaplayer/api/TVK_IMediaPlayer;
    //   571: invokeinterface 659 1 0
    //   576: ldc2_w 660
    //   579: ldiv
    //   580: lcmp
    //   581: iflt +84 -> 665
    //   584: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   587: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   590: invokeinterface 286 1 0
    //   595: ifeq +53 -> 648
    //   598: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   601: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   604: astore_1
    //   605: new 103	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   612: astore 11
    //   614: aload 11
    //   616: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   619: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload 11
    //   625: aload_0
    //   626: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   629: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: aload_1
    //   634: aload 11
    //   636: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: iconst_2
    //   640: ldc_w 663
    //   643: invokeinterface 277 4 0
    //   648: aload_0
    //   649: getfield 644	com/tencent/image/QQLiveImage:mLoopBackListener	Lcom/tencent/image/QQLiveDrawable$OnLoopBackListener;
    //   652: aload_0
    //   653: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   656: aload_0
    //   657: getfield 172	com/tencent/image/QQLiveImage:lastPosi	J
    //   660: invokeinterface 650 4 0
    //   665: aload_0
    //   666: lload 7
    //   668: putfield 172	com/tencent/image/QQLiveImage:lastPosi	J
    //   671: aload_2
    //   672: ifnull +593 -> 1265
    //   675: invokestatic 668	java/lang/System:currentTimeMillis	()J
    //   678: pop2
    //   679: aload_2
    //   680: invokestatic 674	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   683: astore_1
    //   684: aload_0
    //   685: getfield 170	com/tencent/image/QQLiveImage:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   688: invokevirtual 342	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   691: aload_0
    //   692: getfield 676	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   695: ifnonnull +172 -> 867
    //   698: aload_0
    //   699: iload_3
    //   700: iload 4
    //   702: getstatic 682	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   705: invokestatic 688	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   708: putfield 676	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   711: aload_0
    //   712: iload 5
    //   714: putfield 690	com/tencent/image/QQLiveImage:mRotation	I
    //   717: aload_0
    //   718: invokestatic 692	com/tencent/image/QQLiveImage:tryReycleFramesUseless	(Lcom/tencent/image/QQLiveImage;)V
    //   721: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   724: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   727: invokeinterface 286 1 0
    //   732: ifeq +135 -> 867
    //   735: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   738: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   741: astore_2
    //   742: new 103	java/lang/StringBuilder
    //   745: dup
    //   746: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   749: astore 11
    //   751: aload 11
    //   753: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   756: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload 11
    //   762: aload_0
    //   763: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   766: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: aload 11
    //   772: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   775: astore 11
    //   777: new 103	java/lang/StringBuilder
    //   780: dup
    //   781: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   784: astore 12
    //   786: aload 12
    //   788: ldc_w 694
    //   791: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: pop
    //   795: aload 12
    //   797: iload_3
    //   798: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   801: pop
    //   802: aload 12
    //   804: ldc_w 696
    //   807: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: aload 12
    //   813: iload 4
    //   815: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   818: pop
    //   819: aload 12
    //   821: ldc_w 698
    //   824: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: pop
    //   828: aload 12
    //   830: iload 5
    //   832: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   835: pop
    //   836: aload 12
    //   838: ldc_w 700
    //   841: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload 12
    //   847: iload 6
    //   849: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload_2
    //   854: aload 11
    //   856: iconst_2
    //   857: aload 12
    //   859: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokeinterface 371 4 0
    //   867: aload_0
    //   868: getfield 676	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   871: aload_1
    //   872: invokevirtual 704	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   875: aload_0
    //   876: getfield 690	com/tencent/image/QQLiveImage:mRotation	I
    //   879: ifeq +196 -> 1075
    //   882: aload_0
    //   883: getfield 706	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   886: ifnonnull +54 -> 940
    //   889: aload_0
    //   890: getfield 690	com/tencent/image/QQLiveImage:mRotation	I
    //   893: bipush 90
    //   895: if_icmpeq +32 -> 927
    //   898: aload_0
    //   899: getfield 690	com/tencent/image/QQLiveImage:mRotation	I
    //   902: sipush 270
    //   905: if_icmpne +6 -> 911
    //   908: goto +19 -> 927
    //   911: aload_0
    //   912: iload_3
    //   913: iload 4
    //   915: getstatic 682	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   918: invokestatic 688	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   921: putfield 706	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   924: goto +16 -> 940
    //   927: aload_0
    //   928: iload 4
    //   930: iload_3
    //   931: getstatic 682	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   934: invokestatic 688	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   937: putfield 706	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   940: aload_0
    //   941: getfield 708	com/tencent/image/QQLiveImage:mCanvas	Landroid/graphics/Canvas;
    //   944: ifnonnull +18 -> 962
    //   947: aload_0
    //   948: new 710	android/graphics/Canvas
    //   951: dup
    //   952: aload_0
    //   953: getfield 706	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   956: invokespecial 713	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   959: putfield 708	com/tencent/image/QQLiveImage:mCanvas	Landroid/graphics/Canvas;
    //   962: aload_0
    //   963: getfield 715	com/tencent/image/QQLiveImage:mMatrix	Landroid/graphics/Matrix;
    //   966: ifnonnull +86 -> 1052
    //   969: aload_0
    //   970: new 717	android/graphics/Matrix
    //   973: dup
    //   974: invokespecial 718	android/graphics/Matrix:<init>	()V
    //   977: putfield 715	com/tencent/image/QQLiveImage:mMatrix	Landroid/graphics/Matrix;
    //   980: aload_0
    //   981: getfield 676	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   984: invokevirtual 721	android/graphics/Bitmap:getWidth	()I
    //   987: istore_3
    //   988: aload_0
    //   989: getfield 676	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   992: invokevirtual 724	android/graphics/Bitmap:getHeight	()I
    //   995: istore 4
    //   997: aload_0
    //   998: getfield 715	com/tencent/image/QQLiveImage:mMatrix	Landroid/graphics/Matrix;
    //   1001: aload_0
    //   1002: getfield 690	com/tencent/image/QQLiveImage:mRotation	I
    //   1005: i2f
    //   1006: iload_3
    //   1007: iconst_2
    //   1008: idiv
    //   1009: i2f
    //   1010: iload 4
    //   1012: iconst_2
    //   1013: idiv
    //   1014: i2f
    //   1015: invokevirtual 728	android/graphics/Matrix:postRotate	(FFF)Z
    //   1018: pop
    //   1019: aload_0
    //   1020: getfield 715	com/tencent/image/QQLiveImage:mMatrix	Landroid/graphics/Matrix;
    //   1023: aload_0
    //   1024: getfield 706	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   1027: invokevirtual 721	android/graphics/Bitmap:getWidth	()I
    //   1030: iload_3
    //   1031: isub
    //   1032: i2f
    //   1033: fconst_2
    //   1034: fdiv
    //   1035: aload_0
    //   1036: getfield 706	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   1039: invokevirtual 724	android/graphics/Bitmap:getHeight	()I
    //   1042: iload 4
    //   1044: isub
    //   1045: i2f
    //   1046: fconst_2
    //   1047: fdiv
    //   1048: invokevirtual 732	android/graphics/Matrix:postTranslate	(FF)Z
    //   1051: pop
    //   1052: aload_0
    //   1053: getfield 676	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   1056: ifnull +19 -> 1075
    //   1059: aload_0
    //   1060: getfield 708	com/tencent/image/QQLiveImage:mCanvas	Landroid/graphics/Canvas;
    //   1063: aload_0
    //   1064: getfield 676	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   1067: aload_0
    //   1068: getfield 715	com/tencent/image/QQLiveImage:mMatrix	Landroid/graphics/Matrix;
    //   1071: aconst_null
    //   1072: invokevirtual 736	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V
    //   1075: aload_0
    //   1076: aload_0
    //   1077: getfield 168	com/tencent/image/QQLiveImage:mFrameIndex	I
    //   1080: iconst_1
    //   1081: iadd
    //   1082: putfield 168	com/tencent/image/QQLiveImage:mFrameIndex	I
    //   1085: goto +136 -> 1221
    //   1088: astore_1
    //   1089: goto +167 -> 1256
    //   1092: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1095: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1098: invokeinterface 286 1 0
    //   1103: ifeq +118 -> 1221
    //   1106: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1109: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1112: astore_1
    //   1113: new 103	java/lang/StringBuilder
    //   1116: dup
    //   1117: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1120: astore_2
    //   1121: aload_2
    //   1122: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   1125: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1128: pop
    //   1129: aload_2
    //   1130: aload_0
    //   1131: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   1134: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: aload_1
    //   1139: aload_2
    //   1140: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1143: iconst_2
    //   1144: ldc_w 738
    //   1147: invokeinterface 615 4 0
    //   1152: goto +69 -> 1221
    //   1155: astore_1
    //   1156: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1159: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1162: invokeinterface 286 1 0
    //   1167: ifeq +54 -> 1221
    //   1170: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1173: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1176: astore_2
    //   1177: new 103	java/lang/StringBuilder
    //   1180: dup
    //   1181: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1184: astore 11
    //   1186: aload 11
    //   1188: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   1191: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: pop
    //   1195: aload 11
    //   1197: aload_0
    //   1198: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   1201: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1204: pop
    //   1205: aload_2
    //   1206: aload 11
    //   1208: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1211: iconst_2
    //   1212: ldc_w 740
    //   1215: aload_1
    //   1216: invokeinterface 358 5 0
    //   1221: aload_0
    //   1222: getfield 170	com/tencent/image/QQLiveImage:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1225: invokevirtual 361	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1228: invokestatic 668	java/lang/System:currentTimeMillis	()J
    //   1231: pop2
    //   1232: aload_0
    //   1233: getfield 159	com/tencent/image/QQLiveImage:mHandler	Landroid/os/Handler;
    //   1236: iconst_1
    //   1237: invokevirtual 743	android/os/Handler:removeMessages	(I)V
    //   1240: aload_0
    //   1241: getfield 159	com/tencent/image/QQLiveImage:mHandler	Landroid/os/Handler;
    //   1244: iconst_1
    //   1245: invokevirtual 747	android/os/Handler:sendEmptyMessage	(I)Z
    //   1248: pop
    //   1249: aload_0
    //   1250: iconst_2
    //   1251: aconst_null
    //   1252: invokespecial 306	com/tencent/image/QQLiveImage:changeStateAndNotify	(ILjava/lang/Object;)V
    //   1255: return
    //   1256: aload_0
    //   1257: getfield 170	com/tencent/image/QQLiveImage:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1260: invokevirtual 361	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1263: aload_1
    //   1264: athrow
    //   1265: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1268: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1271: invokeinterface 286 1 0
    //   1276: ifeq +49 -> 1325
    //   1279: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   1282: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   1285: astore_1
    //   1286: new 103	java/lang/StringBuilder
    //   1289: dup
    //   1290: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   1293: astore_2
    //   1294: aload_2
    //   1295: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   1298: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: pop
    //   1302: aload_2
    //   1303: aload_0
    //   1304: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   1307: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1310: pop
    //   1311: aload_1
    //   1312: aload_2
    //   1313: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1316: iconst_2
    //   1317: ldc_w 749
    //   1320: invokeinterface 615 4 0
    //   1325: return
    //   1326: astore_1
    //   1327: goto -235 -> 1092
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1330	0	this	QQLiveImage
    //   0	1330	1	paramTVK_IMediaPlayer	TVK_IMediaPlayer
    //   0	1330	2	paramArrayOfByte	byte[]
    //   0	1330	3	paramInt1	int
    //   0	1330	4	paramInt2	int
    //   0	1330	5	paramInt3	int
    //   0	1330	6	paramInt4	int
    //   266	401	7	l1	long
    //   551	11	9	l2	long
    //   36	1171	11	localObject	Object
    //   71	787	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   691	867	1088	finally
    //   867	908	1088	finally
    //   911	924	1088	finally
    //   927	940	1088	finally
    //   940	962	1088	finally
    //   962	1052	1088	finally
    //   1052	1075	1088	finally
    //   1075	1085	1088	finally
    //   1092	1152	1088	finally
    //   1156	1221	1088	finally
    //   691	867	1155	java/lang/Exception
    //   867	908	1155	java/lang/Exception
    //   911	924	1155	java/lang/Exception
    //   927	940	1155	java/lang/Exception
    //   940	962	1155	java/lang/Exception
    //   962	1052	1155	java/lang/Exception
    //   1052	1075	1155	java/lang/Exception
    //   1075	1085	1155	java/lang/Exception
    //   691	867	1326	java/lang/OutOfMemoryError
    //   867	908	1326	java/lang/OutOfMemoryError
    //   911	924	1326	java/lang/OutOfMemoryError
    //   927	940	1326	java/lang/OutOfMemoryError
    //   940	962	1326	java/lang/OutOfMemoryError
    //   962	1052	1326	java/lang/OutOfMemoryError
    //   1052	1075	1326	java/lang/OutOfMemoryError
    //   1075	1085	1326	java/lang/OutOfMemoryError
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
    Vector localVector;
    if (paramQQLiveDrawable != null) {
      localVector = this.mDrawableList;
    }
    int j;
    for (int i = 0;; i = j + 1)
    {
      try
      {
        if (i < this.mDrawableList.size())
        {
          WeakReference localWeakReference = (WeakReference)this.mDrawableList.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != paramQQLiveDrawable))
          {
            j = i;
            if (localWeakReference.get() != paramQQLiveDrawable) {
              continue;
            }
            this.mDrawableList.remove(i);
            return;
          }
          this.mDrawableList.remove(i);
          j = i - 1;
          continue;
        }
        return;
      }
      finally {}
      return;
    }
  }
  
  protected void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
  {
    Object localObject;
    if ((this.mCurFrameBitmap == null) && (this.mRotatedBitmap == null))
    {
      localObject = this.mCoverBitmapRef;
      if ((localObject != null) && (((WeakReference)localObject).get() != null))
      {
        paramCanvas.drawBitmap((Bitmap)this.mCoverBitmapRef.get(), null, paramRect, paramPaint);
      }
      else
      {
        paramPaint = this.mParams;
        if ((paramPaint != null) && (paramPaint.mCoverLoadingDrawable != null))
        {
          if (!this.mParams.mCoverLoadingDrawable.getBounds().equals(paramRect)) {
            this.mParams.mCoverLoadingDrawable.setBounds(paramRect);
          }
          this.mParams.mCoverLoadingDrawable.draw(paramCanvas);
        }
        else if (URLDrawable.depImp.mLog.isColorLevel())
        {
          paramCanvas = URLDrawable.depImp.mLog;
          paramRect = new StringBuilder();
          paramRect.append(TAG);
          paramRect.append(this.ID);
          paramCanvas.w(paramRect.toString(), 2, "draw(): nothing to draw");
        }
      }
    }
    else
    {
      if (this.mRotation != 0)
      {
        localObject = this.mRotatedBitmap;
        if (localObject != null)
        {
          paramCanvas.drawBitmap((Bitmap)localObject, null, paramRect, paramPaint);
          break label225;
        }
      }
      if (this.mCurFrameBitmap != null) {
        paramCanvas.drawBitmap(this.mCurFrameBitmap, null, paramRect, paramPaint);
      }
    }
    label225:
    if ((this.mVideoPlayer == null) && (this.mParams != null) && (!this.mPaused) && (!this.mPlayCompleted) && (this.mState.get() != 5))
    {
      initAndStartPlayer(this.mParams.mStartPosi);
      return;
    }
    if ((URLDrawable.depImp.mLog.isColorLevel()) && (this.mVideoPlayer == null))
    {
      paramCanvas = URLDrawable.depImp.mLog;
      paramRect = new StringBuilder();
      paramRect.append(TAG);
      paramRect.append(this.ID);
      paramRect = paramRect.toString();
      paramPaint = new StringBuilder();
      paramPaint.append("draw(): mVideoPlayer == null, mPaused = ");
      paramPaint.append(this.mPaused);
      paramPaint.append(", mPlayCompleted = ");
      paramPaint.append(this.mPlayCompleted);
      paramPaint.append(",mState=");
      paramPaint.append(getStateStr(this.mState.get()));
      paramCanvas.w(paramRect, 2, paramPaint.toString());
    }
  }
  
  protected void finalize()
  {
    if (this.mVideoPlayer != null) {
      release();
    }
  }
  
  public int getByteSize()
  {
    WeakReference localWeakReference = this.mCoverBitmapRef;
    int i = 0;
    if (localWeakReference != null) {
      i = 0 + Utils.getBitmapSize((Bitmap)localWeakReference.get());
    }
    return i + Utils.getBitmapSize(this.mCurFrameBitmap);
  }
  
  public long getCurrentPosition()
  {
    try
    {
      if (this.mVideoPlayer != null) {
        l = this.mVideoPlayer.getCurrentPostion();
      } else {
        l = this.mCurPosi;
      }
    }
    catch (Throwable localThrowable)
    {
      long l;
      label28:
      ILog localILog;
      Object localObject;
      StringBuilder localStringBuilder;
      break label28;
    }
    l = -1L;
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localILog = URLDrawable.depImp.mLog;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(this.ID);
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentPosition() curPosi = ");
      localStringBuilder.append(l);
      localILog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return l;
  }
  
  public int getHeight()
  {
    if (this.mCurFrameBitmap != null)
    {
      int i = this.mRotation;
      if ((i != 0) && (i != 180)) {
        return this.mCurFrameBitmap.getWidth();
      }
      return this.mCurFrameBitmap.getHeight();
    }
    Object localObject = this.mCoverBitmapRef;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      return ((Bitmap)this.mCoverBitmapRef.get()).getHeight();
    }
    localObject = this.mParams;
    if (localObject != null) {
      return ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPreviewHeight;
    }
    return 0;
  }
  
  public long getMsgUniseq()
  {
    QQLiveDrawable.QQLiveDrawableParams localQQLiveDrawableParams = this.mParams;
    if (localQQLiveDrawableParams != null) {
      return localQQLiveDrawableParams.msgUniseq;
    }
    return 0L;
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
      int i = this.mRotation;
      if ((i != 0) && (i != 180)) {
        return this.mCurFrameBitmap.getHeight();
      }
      return this.mCurFrameBitmap.getWidth();
    }
    Object localObject = this.mCoverBitmapRef;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      return ((Bitmap)this.mCoverBitmapRef.get()).getWidth();
    }
    localObject = this.mParams;
    if (localObject != null) {
      return ((QQLiveDrawable.QQLiveDrawableParams)localObject).mPreviewWidth;
    }
    return 0;
  }
  
  protected void initAndStartPlayer(int paramInt)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.mPaused)
    {
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        localObject = URLDrawable.depImp.mLog;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(TAG);
        localStringBuilder.append(this.ID);
        ((ILog)localObject).d(localStringBuilder.toString(), 2, "initAndStartPlayer(): paused, just return");
      }
      return;
    }
    if ((this.mState.get() != 9) && (this.mState.get() != 8))
    {
      changeStateAndNotify(3, null);
      localObject = getApplicationContext();
      URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(new QQLiveImage.7(this, (Context)localObject, paramInt), null, false);
      return;
    }
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localObject = URLDrawable.depImp.mLog;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(this.ID);
      ((ILog)localObject).w(localStringBuilder.toString(), 2, "initAndStartPlayer(): initialed or preparing, just return");
    }
  }
  
  protected void invalidateSelf()
  {
    Vector localVector = this.mDrawableList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.mDrawableList.size())
        {
          WeakReference localWeakReference = (WeakReference)this.mDrawableList.get(i);
          if ((localWeakReference != null) && (localWeakReference.get() != null))
          {
            ((QQLiveDrawable)localWeakReference.get()).invalidateSelf();
          }
          else
          {
            this.mDrawableList.remove(i);
            i -= 1;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        continue;
        throw localObject;
        continue;
        i += 1;
      }
    }
  }
  
  public boolean isPaused()
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ILog localILog = URLDrawable.depImp.mLog;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(this.ID);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPaused(): mPaused = ");
      localStringBuilder.append(this.mPaused);
      localILog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return this.mPaused;
  }
  
  public boolean isRecycled()
  {
    return this.mReclyed;
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(this.ID);
      paramTVK_IMediaPlayer.d(localStringBuilder.toString(), 2, "[TVK_IMediaPlayer] onCompletion(): ");
    }
    asyncReleasePlayer(false);
    this.mPrepared = false;
    this.mPlayCompleted = true;
    changeStateAndNotify(6, null);
  }
  
  public void onDetachedFromWindow()
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localObject = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(this.ID);
      ((ILog)localObject).d(localStringBuilder.toString(), 2, "onDetachedFromWindow() ");
    }
    Object localObject = this.mParams;
    if (localObject != null)
    {
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mListener = null;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mDownloadListener = null;
      ((QQLiveDrawable.QQLiveDrawableParams)localObject).mLoopBackListener = null;
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    paramTVK_IMediaPlayer = this.mErrorInfo;
    paramTVK_IMediaPlayer.model = paramInt1;
    paramTVK_IMediaPlayer.what = paramInt2;
    paramTVK_IMediaPlayer.extra = paramInt3;
    paramTVK_IMediaPlayer.detailInfo = paramString;
    paramTVK_IMediaPlayer.info = paramObject;
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[TVK_IMediaPlayer] onError(): \n");
      paramString.append(this.mErrorInfo.toString());
      paramString.append("\n");
      paramTVK_IMediaPlayer = this.mParams;
      if (paramTVK_IMediaPlayer == null) {
        paramTVK_IMediaPlayer = "mParams=null";
      } else {
        paramTVK_IMediaPlayer = paramTVK_IMediaPlayer.toString();
      }
      paramString.append(paramTVK_IMediaPlayer);
      paramTVK_IMediaPlayer = paramString.toString();
      paramString = URLDrawable.depImp.mLog;
      paramObject = new StringBuilder();
      paramObject.append(TAG);
      paramObject.append(this.ID);
      paramString.e(paramObject.toString(), 2, paramTVK_IMediaPlayer);
    }
    asyncReleasePlayer(false);
    this.mPrepared = false;
    changeStateAndNotify(5, this.mErrorInfo);
    return false;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    if (paramInt != 21)
    {
      if (paramInt == 22)
      {
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          paramTVK_IMediaPlayer = URLDrawable.depImp.mLog;
          paramObject = new StringBuilder();
          paramObject.append(TAG);
          paramObject.append(this.ID);
          paramTVK_IMediaPlayer.d(paramObject.toString(), 2, "[TVK_IMediaPlayer] onInfo(): 视频缓冲结束<==");
        }
        if (this.mPaused) {
          changeStateAndNotify(4, null);
        } else {
          changeStateAndNotify(2, null);
        }
      }
    }
    else
    {
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramTVK_IMediaPlayer = URLDrawable.depImp.mLog;
        paramObject = new StringBuilder();
        paramObject.append(TAG);
        paramObject.append(this.ID);
        paramTVK_IMediaPlayer.d(paramObject.toString(), 2, "[TVK_IMediaPlayer] onInfo(): 视频开始缓冲==>");
      }
      changeStateAndNotify(3, null);
    }
    return false;
  }
  
  public void onPreAdPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer, long paramLong)
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = URLDrawable.depImp.mLog;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(this.ID);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[TVK_IMediaPlayer] onPreAdPrepared(): adDuration = ");
      localStringBuilder.append(paramLong);
      paramTVK_IMediaPlayer.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.mVideoPlayer.start();
  }
  
  public void onPreAdPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(this.ID);
      paramTVK_IMediaPlayer.d(localStringBuilder.toString(), 2, "[TVK_IMediaPlayer] onPreAdPreparing(): ");
    }
  }
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    StringBuilder localStringBuilder;
    if (!this.mPaused)
    {
      if (this.mVideoPlayer != null) {
        this.mVideoPlayer.start();
      }
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramTVK_IMediaPlayer = URLDrawable.depImp.mLog;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(TAG);
        localStringBuilder.append(this.ID);
        paramTVK_IMediaPlayer.d(localStringBuilder.toString(), 2, "[TVK_IMediaPlayer] onSeekComplete, start ");
      }
    }
    else if (URLDrawable.depImp.mLog.isColorLevel())
    {
      paramTVK_IMediaPlayer = URLDrawable.depImp.mLog;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(this.ID);
      paramTVK_IMediaPlayer.e(localStringBuilder.toString(), 2, "[TVK_IMediaPlayer] onSeekComplete, paused, just return.");
    }
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.mPrepared = true;
    StringBuilder localStringBuilder;
    if (!this.mPaused)
    {
      changeStateAndNotify(1, null);
      if (this.mState.get() == 10)
      {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
          URLDrawable.depImp.mLog.d(TAG, 2, "mState.get() == OnStateListener.STATE_RELEASED");
        }
        asyncReleasePlayer(false);
      }
      if (this.mVideoPlayer != null) {
        this.mVideoPlayer.start();
      }
      int i = paramTVK_IMediaPlayer.getVideoWidth();
      int j = paramTVK_IMediaPlayer.getVideoHeight();
      if (this.mStartPlayTime > 0L) {
        this.mPrepareTime = (SystemClock.uptimeMillis() - this.mStartPlayTime);
      }
      localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("prepareTime:");
      localStringBuilder.append(this.mPrepareTime);
      localStringBuilder.append("\n");
      localStringBuilder.append("width:");
      localStringBuilder.append(i);
      localStringBuilder.append("\n");
      localStringBuilder.append("height:");
      localStringBuilder.append(j);
      localStringBuilder.append("\n");
      paramTVK_IMediaPlayer = paramTVK_IMediaPlayer.getPlayDetailsTime();
      Object localObject1;
      Object localObject2;
      if (paramTVK_IMediaPlayer != null)
      {
        localObject1 = paramTVK_IMediaPlayer.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          localStringBuilder.append(localObject2);
          localStringBuilder.append(" ：");
          localStringBuilder.append(paramTVK_IMediaPlayer.get(localObject2));
          localStringBuilder.append("\n");
        }
      }
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        paramTVK_IMediaPlayer = URLDrawable.depImp.mLog;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(TAG);
        ((StringBuilder)localObject1).append(this.ID);
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[TVK_IMediaPlayer] onVideoPrepared():  ");
        ((StringBuilder)localObject2).append(localStringBuilder.toString());
        paramTVK_IMediaPlayer.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    else
    {
      paramTVK_IMediaPlayer.pause();
      paramTVK_IMediaPlayer = URLDrawable.depImp.mLog;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(this.ID);
      paramTVK_IMediaPlayer.e(localStringBuilder.toString(), 1, "[TVK_IMediaPlayer] onVideoPrepared(): But paused, try pause! ");
    }
  }
  
  public void pause()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    if ((!this.mPaused) && (!this.mPlayCompleted) && (this.mState.get() != 6) && (this.mState.get() != 5))
    {
      if (this.mVideoPlayer != null) {
        try
        {
          if (this.mVideoPlayer != null)
          {
            if (this.mVideoPlayer.isPlaying())
            {
              localStringBuilder1.append("step: mVideoPlayer.isPlaying, pause;");
              this.mVideoPlayer.pause();
            }
            else if (this.mVideoPlayer.isPauseing())
            {
              localStringBuilder1.append("step: mVideoPlayer.isPauseing, do nothing;");
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("step: player unknow status，prepared=");
              ((StringBuilder)localObject2).append(this.mPrepared);
              localStringBuilder1.append(((StringBuilder)localObject2).toString());
            }
          }
          else {
            localStringBuilder1.append("step: player = null.");
          }
        }
        finally {}
      } else {
        localObject1.append("step: player = null.");
      }
      this.mPaused = true;
      changeStateAndNotify(4, null);
    }
    Object localObject2 = URLDrawable.depImp.mLog;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(TAG);
    ((StringBuilder)localObject3).append(this.ID);
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("pause():  ");
    localStringBuilder2.append(localObject1.toString());
    ((ILog)localObject2).d((String)localObject3, 1, localStringBuilder2.toString());
  }
  
  public void recycleCurFrame()
  {
    ILog localILog;
    StringBuilder localStringBuilder;
    if (this.mLock.tryLock())
    {
      this.mCurFrameBitmap = null;
      this.mLock.unlock();
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        localILog = URLDrawable.depImp.mLog;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(TAG);
        localStringBuilder.append(this.ID);
        localILog.d(localStringBuilder.toString(), 2, "recycleCurFrame()");
      }
    }
    else if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localILog = URLDrawable.depImp.mLog;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(this.ID);
      localILog.w(localStringBuilder.toString(), 2, "recycleCurFrame() failed by can't accqure lock ");
    }
  }
  
  public void recyleAndKeepPostion()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.mVideoPlayer;
    if (this.mVideoPlayer != null)
    {
      this.mPlayPostionWhenRecyle = ((int)this.mVideoPlayer.getCurrentPostion());
      asyncReleasePlayer(true);
      this.mLastPlayerReleaseTime = SystemClock.uptimeMillis();
    }
    this.mReclyed = true;
    this.mOnStateListener = null;
    this.mDownloadListener = null;
    this.mLoopBackListener = null;
    this.mPrepared = false;
    this.mPrepareTime = 0L;
    this.mStartPlayTime = 0L;
    ILog localILog = URLDrawable.depImp.mLog;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TAG);
    ((StringBuilder)localObject).append(this.ID);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recyleAndKeepPostion()：mPlayPostionWhenRecyle = ");
    localStringBuilder.append(this.mPlayPostionWhenRecyle);
    localStringBuilder.append(", mReclyed = ");
    localStringBuilder.append(this.mReclyed);
    localStringBuilder.append(", mVideoPlayer=");
    localStringBuilder.append(localTVK_IMediaPlayer);
    localILog.d((String)localObject, 1, localStringBuilder.toString());
  }
  
  public void recyleAndNotKeepPosition()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.mVideoPlayer;
    if (this.mVideoPlayer != null)
    {
      asyncReleasePlayer(false);
      this.mLastPlayerReleaseTime = SystemClock.uptimeMillis();
    }
    Object localObject1 = this.mParams;
    if (localObject1 != null) {
      ((QQLiveDrawable.QQLiveDrawableParams)localObject1).mStartPosi = 0;
    }
    this.mPlayPostionWhenRecyle = 0;
    this.mReclyed = true;
    this.mPrepared = false;
    this.mPrepareTime = 0L;
    this.mStartPlayTime = 0L;
    this.mPlayCompleted = false;
    localObject1 = URLDrawable.depImp.mLog;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(TAG);
    ((StringBuilder)localObject2).append(this.ID);
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" recyleForOnItemSelect()：mPlayPostionWhenRecyle = ");
    localStringBuilder.append(this.mPlayPostionWhenRecyle);
    localStringBuilder.append(", mReclyed = ");
    localStringBuilder.append(this.mReclyed);
    localStringBuilder.append(", mVideoPlayer=");
    localStringBuilder.append(localTVK_IMediaPlayer);
    localStringBuilder.append(" this=");
    localStringBuilder.append(this);
    ((ILog)localObject1).d((String)localObject2, 1, localStringBuilder.toString());
  }
  
  public void recyleFor2Background()
  {
    TVK_IMediaPlayer localTVK_IMediaPlayer = this.mVideoPlayer;
    if (this.mVideoPlayer != null)
    {
      this.mPlayPostionWhenRecyle = ((int)this.mVideoPlayer.getCurrentPostion());
      asyncReleasePlayer(true);
      this.mLastPlayerReleaseTime = SystemClock.uptimeMillis();
    }
    this.mReclyed = true;
    this.mPrepared = false;
    this.mPrepareTime = 0L;
    this.mStartPlayTime = 0L;
    ILog localILog = URLDrawable.depImp.mLog;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(TAG);
    ((StringBuilder)localObject).append(this.ID);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recyleFor2Background()：mPlayPostionWhenRecyle = ");
    localStringBuilder.append(this.mPlayPostionWhenRecyle);
    localStringBuilder.append(", mReclyed = ");
    localStringBuilder.append(this.mReclyed);
    localStringBuilder.append(", mVideoPlayer=");
    localStringBuilder.append(localTVK_IMediaPlayer);
    localILog.d((String)localObject, 1, localStringBuilder.toString());
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: getstatic 130	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   3: invokevirtual 342	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   6: getstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   9: ifnull +11 -> 20
    //   12: getstatic 298	com/tencent/image/QQLiveImage:sImageList	Ljava/util/ArrayList;
    //   15: aload_0
    //   16: invokevirtual 1002	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   19: pop
    //   20: getstatic 130	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   23: invokevirtual 361	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   26: goto +44 -> 70
    //   29: astore_1
    //   30: goto +279 -> 309
    //   33: astore_1
    //   34: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   37: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   40: invokeinterface 286 1 0
    //   45: ifeq -25 -> 20
    //   48: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   51: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   54: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   57: iconst_2
    //   58: ldc_w 1004
    //   61: aload_1
    //   62: invokeinterface 358 5 0
    //   67: goto -47 -> 20
    //   70: aload_0
    //   71: iconst_0
    //   72: invokespecial 855	com/tencent/image/QQLiveImage:asyncReleasePlayer	(Z)V
    //   75: aload_0
    //   76: getfield 170	com/tencent/image/QQLiveImage:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   79: invokevirtual 591	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   82: ifeq +15 -> 97
    //   85: aload_0
    //   86: aconst_null
    //   87: putfield 676	com/tencent/image/QQLiveImage:mCurFrameBitmap	Landroid/graphics/Bitmap;
    //   90: aload_0
    //   91: getfield 170	com/tencent/image/QQLiveImage:mLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   94: invokevirtual 361	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 706	com/tencent/image/QQLiveImage:mRotatedBitmap	Landroid/graphics/Bitmap;
    //   102: aload_0
    //   103: aconst_null
    //   104: putfield 484	com/tencent/image/QQLiveImage:mCover	Lcom/tencent/image/URLDrawable;
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield 463	com/tencent/image/QQLiveImage:mCoverBitmapRef	Ljava/lang/ref/WeakReference;
    //   112: aload_0
    //   113: aconst_null
    //   114: putfield 986	com/tencent/image/QQLiveImage:mOnStateListener	Ljava/lang/ref/WeakReference;
    //   117: aload_0
    //   118: aconst_null
    //   119: putfield 601	com/tencent/image/QQLiveImage:mDownloadListener	Lcom/tencent/image/QQLiveDrawable$OnDownloadListener;
    //   122: aload_0
    //   123: aconst_null
    //   124: putfield 644	com/tencent/image/QQLiveImage:mLoopBackListener	Lcom/tencent/image/QQLiveDrawable$OnLoopBackListener;
    //   127: aload_0
    //   128: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   131: ifnull +59 -> 190
    //   134: aload_0
    //   135: monitorenter
    //   136: aload_0
    //   137: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   140: ifnull +40 -> 180
    //   143: aload_0
    //   144: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   147: aconst_null
    //   148: putfield 224	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mListener	Lcom/tencent/image/QQLiveDrawable$OnStateListener;
    //   151: aload_0
    //   152: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   155: aconst_null
    //   156: putfield 1008	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDataSourceAdapter	Lcom/tencent/image/AbsThirdDataSourceAdapter;
    //   159: aload_0
    //   160: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   163: aconst_null
    //   164: putfield 230	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mDownloadListener	Lcom/tencent/image/QQLiveDrawable$OnDownloadListener;
    //   167: aload_0
    //   168: getfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   171: aconst_null
    //   172: putfield 236	com/tencent/image/QQLiveDrawable$QQLiveDrawableParams:mLoopBackListener	Lcom/tencent/image/QQLiveDrawable$OnLoopBackListener;
    //   175: aload_0
    //   176: aconst_null
    //   177: putfield 220	com/tencent/image/QQLiveImage:mParams	Lcom/tencent/image/QQLiveDrawable$QQLiveDrawableParams;
    //   180: aload_0
    //   181: monitorexit
    //   182: goto +8 -> 190
    //   185: astore_1
    //   186: aload_0
    //   187: monitorexit
    //   188: aload_1
    //   189: athrow
    //   190: aload_0
    //   191: getfield 166	com/tencent/image/QQLiveImage:mState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   194: iconst_0
    //   195: invokevirtual 375	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   198: aload_0
    //   199: iconst_0
    //   200: putfield 168	com/tencent/image/QQLiveImage:mFrameIndex	I
    //   203: aload_0
    //   204: iconst_0
    //   205: putfield 191	com/tencent/image/QQLiveImage:mPrepared	Z
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield 195	com/tencent/image/QQLiveImage:mReclyed	Z
    //   213: aload_0
    //   214: iconst_m1
    //   215: putfield 193	com/tencent/image/QQLiveImage:mPlayPostionWhenRecyle	I
    //   218: aload_0
    //   219: iconst_0
    //   220: putfield 197	com/tencent/image/QQLiveImage:mPlayCompleted	Z
    //   223: aload_0
    //   224: lconst_0
    //   225: putfield 920	com/tencent/image/QQLiveImage:mPrepareTime	J
    //   228: aload_0
    //   229: lconst_0
    //   230: putfield 333	com/tencent/image/QQLiveImage:mStartPlayTime	J
    //   233: aload_0
    //   234: lconst_0
    //   235: putfield 337	com/tencent/image/QQLiveImage:mLastPlayerReleaseTime	J
    //   238: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   241: getfield 1012	com/tencent/image/api/URLDrawableDepWrap:mCache	Lcom/tencent/image/api/ICache;
    //   244: ifnull +18 -> 262
    //   247: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   250: getfield 1012	com/tencent/image/api/URLDrawableDepWrap:mCache	Lcom/tencent/image/api/ICache;
    //   253: aload_0
    //   254: getfield 204	com/tencent/image/QQLiveImage:mUrlStr	Ljava/lang/String;
    //   257: invokeinterface 1016 2 0
    //   262: getstatic 257	com/tencent/image/URLDrawable:depImp	Lcom/tencent/image/api/URLDrawableDepWrap;
    //   265: getfield 263	com/tencent/image/api/URLDrawableDepWrap:mLog	Lcom/tencent/image/api/ILog;
    //   268: astore_1
    //   269: new 103	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   276: astore_2
    //   277: aload_2
    //   278: getstatic 123	com/tencent/image/QQLiveImage:TAG	Ljava/lang/String;
    //   281: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_2
    //   286: aload_0
    //   287: getfield 146	com/tencent/image/QQLiveImage:ID	I
    //   290: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload_1
    //   295: aload_2
    //   296: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: iconst_1
    //   300: ldc_w 1004
    //   303: invokeinterface 277 4 0
    //   308: return
    //   309: getstatic 130	com/tencent/image/QQLiveImage:mLockForImageList	Ljava/util/concurrent/locks/ReentrantLock;
    //   312: invokevirtual 361	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   315: goto +5 -> 320
    //   318: aload_1
    //   319: athrow
    //   320: goto -2 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	QQLiveImage
    //   29	1	1	localObject1	Object
    //   33	29	1	localException	Exception
    //   185	4	1	localObject2	Object
    //   268	51	1	localILog	ILog
    //   276	20	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	20	29	finally
    //   34	67	29	finally
    //   0	20	33	java/lang/Exception
    //   136	180	185	finally
    //   180	182	185	finally
    //   186	188	185	finally
  }
  
  public void replay()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    if ((this.mState.get() == 6) && (this.mPlayCompleted) && (this.mVideoPlayer == null))
    {
      this.mParams.mStartPosi = 0;
      this.mPlayCompleted = false;
      localStringBuilder1.append(" mPlayCompleted, replay!");
      invalidateSelf();
      changeStateAndNotify(3, null);
    }
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ILog localILog = URLDrawable.depImp.mLog;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(this.ID);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("replay(): ");
      localStringBuilder2.append(localStringBuilder1.toString());
      localILog.d((String)localObject, 2, localStringBuilder2.toString());
    }
  }
  
  public void resume()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("");
    if ((this.mState.get() != 5) && (this.mState.get() != 6) && (!this.mPlayCompleted))
    {
      if (this.mVideoPlayer != null)
      {
        try
        {
          if (this.mVideoPlayer != null) {
            if (this.mVideoPlayer.isPlaying())
            {
              localStringBuilder1.append("step: mVideoPlayer.isPlaying, do nothing;");
            }
            else if (this.mVideoPlayer.isPauseing())
            {
              this.mVideoPlayer.start();
              localStringBuilder1.append("step: mVideoPlayer.isPauseing, start;");
            }
            else
            {
              localStringBuilder1.append("step: #player unknow status#");
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(", playState=");
              ((StringBuilder)localObject2).append(getStateStr(this.mState.get()));
              localStringBuilder1.append(((StringBuilder)localObject2).toString());
              if (this.mPrepared)
              {
                this.mVideoPlayer.start();
                localStringBuilder1.append(" prepared. start;");
              }
              else
              {
                localStringBuilder1.append(" not prepared. wait buffering;");
                changeStateAndNotify(3, null);
              }
            }
          }
        }
        finally {}
      }
      else
      {
        localObject1.append("step: player = null.");
        if (Thread.currentThread() == Looper.getMainLooper().getThread())
        {
          invalidateSelf();
        }
        else
        {
          this.mHandler.removeMessages(1);
          this.mHandler.sendEmptyMessage(1);
        }
        changeStateAndNotify(3, null);
        if ((this.mReclyed) && (this.mPlayPostionWhenRecyle > -1) && (this.mParams != null))
        {
          localObject1.append("step: mReclyed, mPlayPostionWhenRecyle:");
          localObject1.append(this.mPlayPostionWhenRecyle);
          this.mReclyed = false;
          this.mParams.mStartPosi = this.mPlayPostionWhenRecyle;
          this.mPlayPostionWhenRecyle = -1;
        }
      }
      this.mPaused = false;
    }
    else if (this.mState.get() == 5)
    {
      changeStateAndNotify(5, null);
      localObject1.append("step: STATE_ERROR, just notify");
    }
    Object localObject2 = URLDrawable.depImp.mLog;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(TAG);
    ((StringBuilder)localObject3).append(this.ID);
    localObject3 = ((StringBuilder)localObject3).toString();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" resume(): ");
    localStringBuilder2.append(localObject1.toString());
    localStringBuilder2.append("this=");
    localStringBuilder2.append(this);
    ((ILog)localObject2).d((String)localObject3, 1, localStringBuilder2.toString());
  }
  
  public void resumeFromPosi(int paramInt)
  {
    if (paramInt <= 0) {
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder("");
    Object localObject1;
    if ((this.mState.get() != 5) && (this.mState.get() != 6) && (!this.mPlayCompleted))
    {
      if (this.mVideoPlayer != null)
      {
        if (this.mVideoPlayer.isPlaying())
        {
          localStringBuilder1.append("step: mVideoPlayer.isPlaying, seekto");
          this.mVideoPlayer.seekTo(paramInt);
        }
        else if (this.mVideoPlayer.isPauseing())
        {
          localStringBuilder1.append("step: mVideoPlayer.isPauseing, seekto;");
          this.mVideoPlayer.seekTo(paramInt);
        }
        else
        {
          localStringBuilder1.append("step: #player unknow status#");
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(", playState=");
          ((StringBuilder)localObject1).append(getStateStr(this.mState.get()));
          localStringBuilder1.append(((StringBuilder)localObject1).toString());
          if (this.mPrepared)
          {
            this.mVideoPlayer.seekTo(paramInt);
            localStringBuilder1.append(" prepared. seekTo;");
          }
          else
          {
            localStringBuilder1.append(" not prepared. reset, wait buffering;");
            invalidateSelf();
            changeStateAndNotify(3, null);
          }
        }
      }
      else
      {
        localStringBuilder1.append("step: player = null.");
        this.mPrepared = false;
        invalidateSelf();
        changeStateAndNotify(3, null);
        if ((this.mReclyed) && (this.mParams != null))
        {
          localStringBuilder1.append("step: mReclyed, mPlayPostionWhenRecyle:");
          localStringBuilder1.append(this.mPlayPostionWhenRecyle);
          this.mReclyed = false;
        }
      }
      this.mPaused = false;
    }
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localObject1 = URLDrawable.depImp.mLog;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(TAG);
      ((StringBuilder)localObject2).append(this.ID);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("resumeFromPosi(): ");
      localStringBuilder2.append(localStringBuilder1.toString());
      localStringBuilder2.append(", position = ");
      localStringBuilder2.append(paramInt);
      ((ILog)localObject1).d((String)localObject2, 2, localStringBuilder2.toString());
    }
  }
  
  public void seek(int paramInt)
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.seekTo(paramInt);
    }
  }
  
  protected void setOnDownloadListener(QQLiveDrawable.OnDownloadListener paramOnDownloadListener)
  {
    this.mDownloadListener = paramOnDownloadListener;
  }
  
  protected void setOnLoopBackListener(QQLiveDrawable.OnLoopBackListener paramOnLoopBackListener)
  {
    this.mLoopBackListener = paramOnLoopBackListener;
  }
  
  protected void setOnStateListener(QQLiveDrawable.OnStateListener paramOnStateListener)
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ILog localILog = URLDrawable.depImp.mLog;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TAG);
      ((StringBuilder)localObject).append(this.ID);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setOnStateListener(): mState = ");
      localStringBuilder.append(getStateStr(this.mState.get()));
      localStringBuilder.append(", AndNotify");
      localILog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.mOnStateListener = new WeakReference(paramOnStateListener);
    int i = this.mState.get();
    this.mHandler.post(new QQLiveImage.5(this, i));
  }
  
  public void start()
  {
    if (this.mVideoPlayer != null) {
      this.mVideoPlayer.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.QQLiveImage
 * JD-Core Version:    0.7.0.1
 */
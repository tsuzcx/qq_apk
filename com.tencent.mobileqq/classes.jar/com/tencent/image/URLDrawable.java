package com.tencent.image;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.image.api.ICache;
import com.tencent.image.api.ILog;
import com.tencent.image.api.IReport;
import com.tencent.image.api.IThreadManager;
import com.tencent.image.api.ITool;
import com.tencent.image.api.IVersion;
import com.tencent.image.api.URLDrawableDepWrap;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;

public class URLDrawable
  extends Drawable
  implements Drawable.Callback, URLState.Callback, Runnable
{
  static final int ANIMATION_DURATION = 600;
  public static final int CANCLED = 3;
  private static final int CORE_POOL_SIZE;
  private static final int CPU_COUNT;
  public static boolean DEBUG = false;
  public static final int DECODE_FAIL_COMMON = 1;
  public static final int DECODE_FAIL_DEFAULT_IGNORE_DELETE_FILE = 3;
  public static final int DECODE_FAIL_DOWNLOADER_DELETE_FILE = 2;
  public static final int FAILED = 2;
  public static final int FILE_DOWNLOADED = 4;
  private static final int KEEP_ALIVE = 1;
  public static final int LOADING = 0;
  private static final int MAXIMUM_POOL_SIZE;
  private static final int PENDING_ACTION_CAPACITY = 100;
  public static final int SUCCESSED = 1;
  public static final String TAG = "URLDrawable_";
  public static final String THREAD_SUB_TAG = "Thread";
  public static URLDrawableDepWrap depImp;
  static Context mApplicationContext;
  static URLDrawableParams sDefaultDrawableParms;
  static boolean sPause = false;
  static Object sPauseLock = new Object();
  private static final LruCache<URLDrawable, LruCache> sPendingActions = new LruCache(100);
  private static final BlockingQueue<Runnable> sPoolWorkQueue;
  private static final ThreadFactory sThreadFactory;
  public boolean individualPause = false;
  private int individualPauseCount = 0;
  private int mAlpha = 255;
  private boolean mAlreadyChecked = false;
  private boolean mAutoDownload = true;
  private Exception mCallStack;
  private ColorFilter mColorFilter;
  private CookieStore mCookies;
  private Drawable mCurrDrawable;
  private URLDrawable.DownloadListener mDownloadListener;
  protected URLState mDrawableContainerState;
  private Matrix mExifMatrix;
  private Object mExtraInfo;
  private long mFadeInAnimationStartTime = -1L;
  private boolean mFadeInAnimationStarted = false;
  boolean mFadeInImage;
  private Drawable mFailedDrawable;
  private float mGifRoundCorner;
  private Header[] mHeaders;
  private boolean mIsShowWatermark = false;
  private URLDrawable.URLDrawableListener mListener;
  private int mProgress = 0;
  private Drawable mProgressDrawable;
  private Object mTag;
  private int mTargetDensity = 160;
  public boolean mUseApngImage;
  private boolean mUseExifOrientation = true;
  private boolean mUseGifAnimation;
  private boolean mUseSharpPImage;
  private Bitmap mWatermarkDrawable = null;
  private int mWatermarkMarginButtom = 0;
  private int mWatermarkMarginRight = 0;
  
  static
  {
    CPU_COUNT = Runtime.getRuntime().availableProcessors();
    int i = CPU_COUNT;
    CORE_POOL_SIZE = i + 1;
    MAXIMUM_POOL_SIZE = i * 2 + 1;
    sPoolWorkQueue = new LinkedBlockingQueue(128);
    sThreadFactory = new URLDrawable.1();
  }
  
  URLDrawable(URLState paramURLState, Resources paramResources)
  {
    this.mDrawableContainerState = paramURLState;
    if (paramURLState.mStatus == 1)
    {
      this.mCurrDrawable = this.mDrawableContainerState.mSuccessed.newDrawable(paramResources);
      this.mCurrDrawable.setCallback(this);
      return;
    }
    this.mDrawableContainerState.addCallBack(this);
  }
  
  private URLDrawable(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    this.mDrawableContainerState = new URLState(paramURL, paramURLDrawableOptions);
    this.mFailedDrawable = paramURLDrawableOptions.mFailedDrawable;
    this.mCurrDrawable = paramURLDrawableOptions.mLoadingDrawable;
    if ((this.mCurrDrawable == null) && (sDefaultDrawableParms.getDefaultLoadingDrawable() != null)) {
      this.mCurrDrawable = sDefaultDrawableParms.getDefaultLoadingDrawable();
    }
    this.mDrawableContainerState.addCallBack(this);
  }
  
  private static URLDrawable autoScale(Resources paramResources, URLDrawable paramURLDrawable)
  {
    if (sDefaultDrawableParms.mAutoScaleByDensity)
    {
      if (paramResources != null)
      {
        paramURLDrawable.setTargetDensity(paramResources.getDisplayMetrics().densityDpi);
        return paramURLDrawable;
      }
      paramURLDrawable.setTargetDensity(sDefaultDrawableParms.mDeviceDensity);
    }
    return paramURLDrawable;
  }
  
  private void checkBitmapSize()
  {
    if (!depImp.mVersion.isPublicVersion())
    {
      if (!DEBUG) {
        return;
      }
      if ((!this.mAlreadyChecked) && (RegionDrawable.class.isInstance(this.mCurrDrawable)))
      {
        this.mAlreadyChecked = true;
        Object localObject1 = getCallback();
        if (ImageView.class.isInstance(localObject1))
        {
          localObject1 = (ImageView)localObject1;
          int i = ((ImageView)localObject1).getMeasuredWidth();
          int j = ((ImageView)localObject1).getMeasuredHeight();
          Object localObject2 = (RegionDrawable)this.mCurrDrawable;
          int k = ((RegionDrawable)localObject2).getBitmap().getWidth();
          int m = ((RegionDrawable)localObject2).getBitmap().getHeight();
          if (isBitmapOversize(k, m, i, j))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("(");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(",");
            ((StringBuilder)localObject2).append(j);
            ((StringBuilder)localObject2).append(")");
            localObject2 = ((StringBuilder)localObject2).toString();
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("(");
            ((StringBuilder)localObject3).append(k);
            ((StringBuilder)localObject3).append(",");
            ((StringBuilder)localObject3).append(m);
            ((StringBuilder)localObject3).append(")");
            localObject3 = ((StringBuilder)localObject3).toString();
            if ((((ImageView)localObject1).getContext() != null) && ((((ImageView)localObject1).getContext() instanceof Activity))) {
              localObject1 = ((ImageView)localObject1).getContext().getClass().getName();
            } else {
              localObject1 = "";
            }
            i = this.mDrawableContainerState.mParams.reqHeight;
            j = this.mDrawableContainerState.mParams.reqWidth;
            Object localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("(");
            ((StringBuilder)localObject4).append(j);
            ((StringBuilder)localObject4).append(",");
            ((StringBuilder)localObject4).append(i);
            ((StringBuilder)localObject4).append(")");
            localObject4 = ((StringBuilder)localObject4).toString();
            String str = getURL().toString();
            Exception localException = this.mCallStack;
            depImp.mReport.debug(1, new Object[] { localObject2, localObject3, str, localObject1, localException, localObject4 });
          }
        }
      }
    }
  }
  
  private static void checkParams()
  {
    if (sDefaultDrawableParms != null) {
      return;
    }
    throw new IllegalStateException("Default params is not seted, please call setURLDrawableParams first");
  }
  
  public static void clearMemoryCache()
  {
    depImp.mCache.evictAll();
  }
  
  private static URLDrawable doIllegalURL(String paramString)
  {
    Object localObject = depImp.mLog;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doIllegalURL :");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" isPublicVersion:");
    localStringBuilder.append(depImp.mVersion.isPublicVersion());
    ((ILog)localObject).d("URLDrawable_", 1, localStringBuilder.toString());
    if (depImp.mVersion.isPublicVersion()) {
      try
      {
        paramString = getDrawable(new URL("illegalurl", null, ""));
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("illegal url format: ");
    ((StringBuilder)localObject).append(paramString);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  /* Error */
  @Deprecated
  public static URLDrawable getDrawable(File paramFile, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 430	java/io/File:toURI	()Ljava/net/URI;
    //   4: invokevirtual 435	java/net/URI:toURL	()Ljava/net/URL;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnull +12 -> 21
    //   12: aload_0
    //   13: aload_1
    //   14: invokestatic 438	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   17: areturn
    //   18: astore_0
    //   19: aload_0
    //   20: athrow
    //   21: aconst_null
    //   22: areturn
    //   23: astore_0
    //   24: goto -3 -> 21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	paramFile	File
    //   0	27	1	paramURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   0	8	18	finally
    //   0	8	23	java/net/MalformedURLException
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString)
  {
    return getDrawable(paramString, null, null);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2)
  {
    return getDrawable(paramString, paramInt1, paramInt2, null, null);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getDrawable(paramString, paramInt1, paramInt2, paramDrawable1, paramDrawable2, false);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    try
    {
      paramDrawable1 = getDrawable(new URL(paramString), paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
      return paramDrawable1;
    }
    catch (MalformedURLException paramDrawable1)
    {
      label22:
      break label22;
    }
    return doIllegalURL(paramString);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return getDrawable(paramString, paramInt1, paramInt2, null, null, paramBoolean);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getDrawable(paramString, 0, 0, paramDrawable1, paramDrawable2);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return getDrawable(paramString, 0, 0, paramDrawable1, paramDrawable2, paramBoolean);
  }
  
  public static URLDrawable getDrawable(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    try
    {
      paramURLDrawableOptions = getDrawable(new URL(paramString), paramURLDrawableOptions);
      return paramURLDrawableOptions;
    }
    catch (MalformedURLException paramURLDrawableOptions)
    {
      label15:
      break label15;
    }
    return doIllegalURL(paramString);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, boolean paramBoolean)
  {
    return getDrawable(paramString, null, null, paramBoolean);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL)
  {
    return getDrawable(paramURL, null, null);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, null, null);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable2;
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    localURLDrawableOptions.mGifRoundCorner = paramFloat;
    return getDrawable(paramURL, localURLDrawableOptions);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, null, null, paramBoolean, 0.0F);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getDrawable(paramURL, 0, 0, paramDrawable1, paramDrawable2);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return getDrawable(paramURL, 0, 0, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    try
    {
      checkParams();
      URLDrawable.URLDrawableOptions localURLDrawableOptions = paramURLDrawableOptions;
      if (paramURLDrawableOptions == null) {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      }
      URLState localURLState = URLState.getConstants(paramURL.toString(), localURLDrawableOptions);
      if (localURLState != null)
      {
        localObject = (URLDrawable)localURLState.newDrawable(null);
        paramURLDrawableOptions = (URLDrawable.URLDrawableOptions)localObject;
        if (localURLState.mParams.mAutoScaleByDensity) {
          paramURLDrawableOptions = autoScale(null, (URLDrawable)localObject);
        }
        paramURLDrawableOptions.mUseExifOrientation = localURLDrawableOptions.mUseExifOrientation;
        paramURLDrawableOptions.mExtraInfo = localURLDrawableOptions.mExtraInfo;
        int i = paramURLDrawableOptions.getStatus();
        if (i == 1)
        {
          if ((paramURLDrawableOptions.mCurrDrawable instanceof GifDrawable))
          {
            ((GifDrawable)paramURLDrawableOptions.mCurrDrawable).mUseAnimation = localURLDrawableOptions.mPlayGifImage;
          }
          else if ((paramURLDrawableOptions.mCurrDrawable instanceof ApngDrawable))
          {
            ((ApngDrawable)paramURLDrawableOptions.mCurrDrawable).mUseAnimation = localURLDrawableOptions.mUseApngImage;
            ((ApngDrawable)paramURLDrawableOptions.mCurrDrawable).setUseRect(localURLDrawableOptions.mExtraInfo);
            paramURLDrawableOptions.mUseApngImage = localURLDrawableOptions.mUseApngImage;
          }
          else if ((paramURLDrawableOptions.mCurrDrawable instanceof VideoDrawable))
          {
            if ((localURLDrawableOptions.mExtraInfo != null) && ((localURLDrawableOptions.mExtraInfo instanceof VideoDrawable.VideoDrawableParams))) {
              ((VideoDrawable)paramURLDrawableOptions.mCurrDrawable).mPlayVideoFrame = ((VideoDrawable.VideoDrawableParams)localURLDrawableOptions.mExtraInfo).mPlayVideoFrame;
            }
          }
          else if (((paramURLDrawableOptions.mCurrDrawable instanceof QQLiveDrawable)) && (localURLDrawableOptions.mExtraInfo != null) && ((localURLDrawableOptions.mExtraInfo instanceof QQLiveDrawable.QQLiveDrawableParams)))
          {
            paramURL = (QQLiveDrawable)paramURLDrawableOptions.mCurrDrawable;
            localObject = (QQLiveDrawable.QQLiveDrawableParams)localURLDrawableOptions.mExtraInfo;
            paramURL.setParams((QQLiveDrawable.QQLiveDrawableParams)localObject);
            if ((!((QQLiveDrawable.QQLiveDrawableParams)localObject).mPlayPause) && (!QQLiveImage.isAllPaused()))
            {
              if (((QQLiveDrawable.QQLiveDrawableParams)localObject).mStartPosi > 0) {
                paramURL.resumeFromPosi(((QQLiveDrawable.QQLiveDrawableParams)localObject).mStartPosi);
              } else {
                paramURL.resume();
              }
            }
            else {
              paramURL.pause();
            }
            paramURL.setOnStateListener(((QQLiveDrawable.QQLiveDrawableParams)localObject).mListener);
            paramURL.setOnDownloadListener(((QQLiveDrawable.QQLiveDrawableParams)localObject).mDownloadListener);
            paramURL.setOnLoopBackListener(((QQLiveDrawable.QQLiveDrawableParams)localObject).mLoopBackListener);
          }
        }
        else
        {
          paramURLDrawableOptions.mUseGifAnimation = localURLDrawableOptions.mPlayGifImage;
          paramURLDrawableOptions.mUseApngImage = localURLDrawableOptions.mUseApngImage;
          paramURLDrawableOptions.mUseSharpPImage = localURLDrawableOptions.mUseSharpPImage;
          paramURLDrawableOptions.mGifRoundCorner = localURLDrawableOptions.mGifRoundCorner;
          paramURLDrawableOptions.mFadeInImage = sDefaultDrawableParms.mFadeInImage;
          localObject = localURLState.mCustomError;
          if (i == 2)
          {
            if (depImp.mLog.isColorLevel())
            {
              ILog localILog = depImp.mLog;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("getDrawable from cache url= ");
              localStringBuilder.append(paramURL.toString());
              localStringBuilder.append(",isLoadingStarted");
              localStringBuilder.append(localURLState.mIsLoadingStarted);
              localILog.d("URLDrawable_", 2, localStringBuilder.toString());
            }
            if (localObject != null) {
              paramURLDrawableOptions.mFailedDrawable = ((CustomError)localObject).getFailedDrawable();
            } else if (localURLDrawableOptions.mFailedDrawable != null) {
              paramURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mFailedDrawable;
            } else {
              paramURLDrawableOptions.mFailedDrawable = sDefaultDrawableParms.getDefualtFailedDrawable();
            }
            paramURLDrawableOptions.mCurrDrawable = paramURLDrawableOptions.mFailedDrawable;
          }
          else
          {
            paramURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mFailedDrawable;
            if (localURLDrawableOptions.mLoadingDrawable == null) {
              paramURL = sDefaultDrawableParms.getDefaultLoadingDrawable();
            } else {
              paramURL = localURLDrawableOptions.mLoadingDrawable;
            }
            paramURLDrawableOptions.mProgressDrawable = paramURL;
            paramURLDrawableOptions.mCurrDrawable = paramURLDrawableOptions.mProgressDrawable;
            if (i == 4)
            {
              paramURL = localURLState.mParams;
              if (localURLDrawableOptions.mRequestWidth != 0) {
                i = localURLDrawableOptions.mRequestHeight;
              }
            }
          }
        }
        paramURLDrawableOptions.mCallStack = new IllegalStateException("UrlDrawable getStack");
        localURLDrawableOptions.Recycle();
        return paramURLDrawableOptions;
      }
      paramURLDrawableOptions = new URLDrawable(paramURL, localURLDrawableOptions);
      paramURLDrawableOptions.mUseGifAnimation = localURLDrawableOptions.mPlayGifImage;
      paramURLDrawableOptions.mUseApngImage = localURLDrawableOptions.mUseApngImage;
      paramURLDrawableOptions.mUseSharpPImage = localURLDrawableOptions.mUseSharpPImage;
      paramURLDrawableOptions.mGifRoundCorner = localURLDrawableOptions.mGifRoundCorner;
      paramURLDrawableOptions.mFadeInImage = sDefaultDrawableParms.mFadeInImage;
      paramURLDrawableOptions.mUseExifOrientation = localURLDrawableOptions.mUseExifOrientation;
      paramURLDrawableOptions.mExtraInfo = localURLDrawableOptions.mExtraInfo;
      Object localObject = paramURLDrawableOptions.mDrawableContainerState.mParams;
      ((DownloadParams)localObject).url = paramURL;
      ((DownloadParams)localObject).urlStr = paramURL.toString();
      ((DownloadParams)localObject).needCheckNetType = localURLDrawableOptions.mNeedCheckNetType;
      ((DownloadParams)localObject).retryCount = localURLDrawableOptions.mRetryCount;
      ((DownloadParams)localObject).mHttpDownloaderParams = localURLDrawableOptions.mHttpDownloaderParams;
      if (localURLDrawableOptions.mUseAutoScaleParams) {
        ((DownloadParams)localObject).mAutoScaleByDensity = sDefaultDrawableParms.mAutoScaleByDensity;
      }
      if ((localURLDrawableOptions.mRequestWidth != 0) && (localURLDrawableOptions.mRequestHeight != 0))
      {
        ((DownloadParams)localObject).reqWidth = localURLDrawableOptions.mRequestWidth;
        ((DownloadParams)localObject).reqHeight = localURLDrawableOptions.mRequestHeight;
      }
      else
      {
        ((DownloadParams)localObject).reqWidth = sDefaultDrawableParms.mReqWidth;
        ((DownloadParams)localObject).reqHeight = sDefaultDrawableParms.mReqHeight;
      }
      ((DownloadParams)localObject).mImgType = localURLDrawableOptions.mImgType;
      paramURL = paramURLDrawableOptions;
      if (localURLDrawableOptions.mUseAutoScaleParams) {
        paramURL = autoScale(null, paramURLDrawableOptions);
      }
      paramURL.mCallStack = new IllegalStateException("UrlDrawable getStack");
      localURLDrawableOptions.Recycle();
      return paramURL;
    }
    finally {}
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, boolean paramBoolean)
  {
    return getDrawable(paramURL, null, null, paramBoolean);
  }
  
  /* Error */
  public static URLDrawable getFileDrawable(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    // Byte code:
    //   0: new 432	java/net/URI
    //   3: dup
    //   4: ldc_w 659
    //   7: aconst_null
    //   8: aload_0
    //   9: aconst_null
    //   10: invokespecial 662	java/net/URI:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   13: invokevirtual 435	java/net/URI:toURL	()Ljava/net/URL;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +25 -> 43
    //   21: aload_0
    //   22: aload_1
    //   23: invokestatic 438	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   26: areturn
    //   27: astore_0
    //   28: goto +17 -> 45
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 663	java/net/URISyntaxException:printStackTrace	()V
    //   36: aconst_null
    //   37: areturn
    //   38: astore_0
    //   39: aload_0
    //   40: invokevirtual 417	java/net/MalformedURLException:printStackTrace	()V
    //   43: aconst_null
    //   44: areturn
    //   45: aload_0
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	paramString	String
    //   0	47	1	paramURLDrawableOptions	URLDrawable.URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   0	17	27	finally
    //   32	36	27	finally
    //   39	43	27	finally
    //   0	17	31	java/net/URISyntaxException
    //   0	17	38	java/net/MalformedURLException
  }
  
  public static int getPoolSize()
  {
    return URLDrawable.URLDrawableOptions.access$000();
  }
  
  private void httpdownloadError()
  {
    String str = getURL().toString();
    Exception localException = this.mCallStack;
    depImp.mReport.debug(2, new Object[] { str, localException });
  }
  
  public static void init(URLDrawableDepWrap paramURLDrawableDepWrap, URLDrawableParams paramURLDrawableParams)
  {
    paramURLDrawableDepWrap.mTool.initURLStreamHandlerFactory();
    if (sDefaultDrawableParms == null)
    {
      depImp = paramURLDrawableDepWrap;
      if (paramURLDrawableParams.mSubHandler == null) {
        paramURLDrawableParams.mSubHandler = new Handler(depImp.mThreadManager.getSubThread().getLooper());
      }
      sDefaultDrawableParms = paramURLDrawableParams;
      mApplicationContext = paramURLDrawableDepWrap.mTool.getContext();
      paramURLDrawableParams.mSubHandler.post(new URLDrawable.2());
      return;
    }
    throw new IllegalArgumentException("please don't call setURLDrawableParams twice");
  }
  
  private boolean isBitmapOversize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 != 0) && (paramInt4 != 0) && (paramInt3 != -1))
    {
      if (paramInt4 == -1) {
        return false;
      }
      if ((paramInt2 > paramInt4) && (paramInt1 > paramInt3))
      {
        paramInt2 = Math.round(paramInt2 / paramInt4);
        paramInt3 = Math.round(paramInt1 / paramInt3);
        paramInt1 = paramInt3;
        if (paramInt2 > paramInt3) {
          paramInt1 = paramInt2;
        }
        if (paramInt1 >= 2) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void pause()
  {
    if (depImp.mLog.isColorLevel()) {
      depImp.mLog.d("URLDrawable_pause", 2, "pause load image ");
    }
    synchronized (sPauseLock)
    {
      sPause = true;
      return;
    }
  }
  
  @Deprecated
  public static void removeMemoryCacheByUrl(String paramString)
  {
    depImp.mCache.remove(paramString);
  }
  
  public static void removeMemoryCacheByUrl(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    paramString = URLState.getMemoryCacheKey(paramString, paramURLDrawableOptions);
    depImp.mCache.remove(paramString);
  }
  
  public static void resume()
  {
    Object localObject2;
    if (depImp.mLog.isColorLevel())
    {
      ??? = depImp.mLog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("resume load image ");
      ((StringBuilder)localObject2).append(new java.lang.RuntimeException("getStack").getStackTrace()[1].toString());
      ((ILog)???).d("URLDrawable_resume", 2, ((StringBuilder)localObject2).toString());
    }
    synchronized (sPauseLock)
    {
      sPause = false;
      sPauseLock.notifyAll();
      localObject2 = sPendingActions.snapshot();
      Object localObject4;
      if (depImp.mLog.isColorLevel())
      {
        localObject4 = depImp.mLog;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resume sPendingActions size= ");
        localStringBuilder.append(sPendingActions.size());
        ((ILog)localObject4).d("URLDrawable_resume", 2, localStringBuilder.toString());
      }
      localObject2 = ((Map)localObject2).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (URLDrawable)((Iterator)localObject2).next();
        ((URLDrawable)localObject4).scheduleSelf((Runnable)localObject4, SystemClock.uptimeMillis() + 1L);
        sPendingActions.remove(localObject4);
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void addCookies(String paramString1, String paramString2)
  {
    if (this.mCookies == null) {
      this.mCookies = new BasicCookieStore();
    }
    this.mCookies.addCookie(new BasicClientCookie(paramString1, paramString2));
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    Header[] arrayOfHeader1 = this.mHeaders;
    if ((arrayOfHeader1 != null) && (arrayOfHeader1.length != 0))
    {
      Header[] arrayOfHeader2 = new Header[arrayOfHeader1.length + 1];
      System.arraycopy(arrayOfHeader1, 0, arrayOfHeader2, 0, arrayOfHeader1.length);
      arrayOfHeader2[this.mHeaders.length] = new BasicHeader(paramString1, paramString2);
      this.mHeaders = arrayOfHeader2;
      return;
    }
    this.mHeaders = new Header[] { new BasicHeader(paramString1, paramString2) };
  }
  
  public void cancelDownload()
  {
    cancelDownload(false);
  }
  
  public void cancelDownload(boolean paramBoolean)
  {
    ILog localILog;
    StringBuilder localStringBuilder;
    if (depImp.mLog.isColorLevel())
    {
      localILog = depImp.mLog;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[cancelDownload]");
      localStringBuilder.append(getURL());
      localILog.i("URLDrawable_", 2, localStringBuilder.toString());
    }
    if (this.mDrawableContainerState.mTask != null)
    {
      this.mDrawableContainerState.mTask.mDownloadRunnable.cancel();
      return;
    }
    if (depImp.mLog.isColorLevel())
    {
      localILog = depImp.mLog;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[cancelDownload]task is null, cancel failed...");
      localStringBuilder.append(getURL());
      localILog.i("URLDrawable_", 2, localStringBuilder.toString());
    }
  }
  
  public void downloadImediatly()
  {
    this.mDrawableContainerState.downloadImediatly(this.mHeaders, this.mCookies, this.mTag, true, this.mUseGifAnimation, this.mUseApngImage, this.mUseSharpPImage, this.mGifRoundCorner, this.mUseExifOrientation, this.mExtraInfo);
  }
  
  public void downloadImediatly(boolean paramBoolean)
  {
    this.mDrawableContainerState.downloadImediatly(this.mHeaders, this.mCookies, this.mTag, paramBoolean, this.mUseGifAnimation, this.mUseApngImage, this.mUseSharpPImage, this.mGifRoundCorner, this.mUseExifOrientation, this.mExtraInfo);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject;
    if (this.mCurrDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        checkBitmapSize();
      }
      int i = paramCanvas.save();
      int j;
      if ((this.mFadeInImage) && (this.mFadeInAnimationStarted))
      {
        long l = AnimationUtils.currentAnimationTimeMillis();
        if (this.mFadeInAnimationStartTime == -1L) {
          this.mFadeInAnimationStartTime = l;
        }
        float f = (float)(l - this.mFadeInAnimationStartTime) / 600.0F;
        if ((f >= 0.0F) && (f <= 1.0F))
        {
          f = 1.0F - f;
          j = Math.min((int)((1.0F - f * f) * 255.0F), 255);
          localObject = getBounds();
          if (Build.VERSION.SDK_INT >= 21) {
            paramCanvas.saveLayerAlpha(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).width(), ((Rect)localObject).height(), j);
          } else {
            paramCanvas.saveLayerAlpha(((Rect)localObject).left, ((Rect)localObject).top, ((Rect)localObject).width(), ((Rect)localObject).height(), j, 31);
          }
          invalidateSelf();
        }
        else
        {
          this.mFadeInAnimationStarted = false;
        }
      }
      localObject = this.mExifMatrix;
      if (localObject != null) {
        paramCanvas.concat((Matrix)localObject);
      }
      this.mCurrDrawable.draw(paramCanvas);
      if (this.mIsShowWatermark == true)
      {
        localObject = this.mWatermarkDrawable;
        if (localObject != null)
        {
          int i1 = ((Bitmap)localObject).getWidth();
          int m = this.mWatermarkDrawable.getHeight();
          j = this.mCurrDrawable.getIntrinsicWidth();
          int k = this.mCurrDrawable.getIntrinsicHeight();
          int i2 = this.mWatermarkMarginRight;
          int n = this.mWatermarkMarginButtom;
          i1 = j - i1 - i2;
          m = k - m - n;
          if ((j > 0) && (k > 0) && (i1 >= 0) && (m >= 0)) {
            paramCanvas.drawBitmap(this.mWatermarkDrawable, i1, m, null);
          }
        }
      }
      if ((getStatus() == 0) && (this.mProgressDrawable != null) && (this.mDrawableContainerState.mIsLoadingStarted == 1)) {
        this.mProgressDrawable.draw(paramCanvas);
      }
      paramCanvas.restoreToCount(i);
    }
    if (this.mAutoDownload)
    {
      if (this.individualPause) {
        this.individualPauseCount += 1;
      }
      if ((!sPause) || (this.mDrawableContainerState.mIgnorePause))
      {
        boolean bool = this.individualPause;
        if ((!bool) || ((bool) && (this.individualPauseCount == 1))) {}
      }
      else
      {
        if (depImp.mLog.isColorLevel())
        {
          paramCanvas = depImp.mLog;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("addToPending:");
          ((StringBuilder)localObject).append(getURL());
          paramCanvas.d("URLDrawable_pause", 4, ((StringBuilder)localObject).toString());
        }
        paramCanvas = sPendingActions;
        paramCanvas.put(this, paramCanvas);
        return;
      }
      startDownload();
    }
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.mDrawableContainerState;
  }
  
  public Drawable getCurrDrawable()
  {
    return this.mCurrDrawable;
  }
  
  public long getCurrentPostion()
  {
    Drawable localDrawable = this.mCurrDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof QQLiveDrawable))) {
      return ((QQLiveDrawable)localDrawable).getCurrentPosition();
    }
    return 0L;
  }
  
  public int getExifOrientation()
  {
    if ((this.mDrawableContainerState.mStatus == 1) && (this.mCurrDrawable != null)) {
      return this.mDrawableContainerState.mOrientation;
    }
    return 0;
  }
  
  public Object getExtraInfo()
  {
    return this.mExtraInfo;
  }
  
  public File getFileInLocal()
  {
    URLState localURLState = this.mDrawableContainerState;
    if (localURLState == null) {
      return null;
    }
    return localURLState.mCacheFile;
  }
  
  public Header getHeader(String paramString)
  {
    Header[] arrayOfHeader = this.mHeaders;
    if (arrayOfHeader != null)
    {
      int j = arrayOfHeader.length;
      int i = 0;
      while (i < j)
      {
        Header localHeader = arrayOfHeader[i];
        if ((paramString != null) && (paramString.equals(localHeader.getName()))) {
          return localHeader;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public Header[] getHeaders()
  {
    return this.mHeaders;
  }
  
  public int getIntrinsicHeight()
  {
    if ((this.mUseExifOrientation) && (this.mDrawableContainerState.mStatus == 1) && (this.mCurrDrawable != null))
    {
      int i = this.mDrawableContainerState.mOrientation;
      if ((i != 5) && (i != 6) && (i != 7) && (i != 8))
      {
        if (this.mDrawableContainerState.mHeight > 0) {
          return this.mDrawableContainerState.mHeight;
        }
        return this.mCurrDrawable.getIntrinsicHeight();
      }
      if (this.mDrawableContainerState.mWidth > 0) {
        return this.mDrawableContainerState.mWidth;
      }
      return this.mCurrDrawable.getIntrinsicWidth();
    }
    if (this.mDrawableContainerState.mHeight > 0) {
      return this.mDrawableContainerState.mHeight;
    }
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    if ((this.mUseExifOrientation) && (this.mDrawableContainerState.mStatus == 1) && (this.mCurrDrawable != null))
    {
      int i = this.mDrawableContainerState.mOrientation;
      if ((i != 5) && (i != 6) && (i != 7) && (i != 8))
      {
        if (this.mDrawableContainerState.mWidth > 0) {
          return this.mDrawableContainerState.mWidth;
        }
        return this.mCurrDrawable.getIntrinsicWidth();
      }
      if (this.mDrawableContainerState.mHeight > 0) {
        return this.mDrawableContainerState.mHeight;
      }
      return this.mCurrDrawable.getIntrinsicHeight();
    }
    if (this.mDrawableContainerState.mWidth > 0) {
      return this.mDrawableContainerState.mWidth;
    }
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      return localDrawable.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int getPlayState()
  {
    Drawable localDrawable = this.mCurrDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof QQLiveDrawable))) {
      return ((QQLiveDrawable)localDrawable).getPlayState();
    }
    return -1;
  }
  
  public int getProgress()
  {
    return this.mProgress;
  }
  
  public CustomError getStateError()
  {
    URLState localURLState = this.mDrawableContainerState;
    if (localURLState != null) {
      return localURLState.mCustomError;
    }
    return null;
  }
  
  public Object getStateTag()
  {
    URLState localURLState = this.mDrawableContainerState;
    if (localURLState != null) {
      return localURLState.mParams.tag;
    }
    return null;
  }
  
  public int getStatus()
  {
    return this.mDrawableContainerState.mStatus;
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public URL getURL()
  {
    return this.mDrawableContainerState.mUrl;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isAnim()
  {
    Drawable localDrawable = this.mCurrDrawable;
    return ((localDrawable instanceof GifDrawable)) || ((localDrawable instanceof ApngDrawable));
  }
  
  public boolean isDownloadStarted()
  {
    return this.mDrawableContainerState.mIsLoadingStarted == 1;
  }
  
  public boolean isFakeSize()
  {
    return (this.mDrawableContainerState.mWidth != 0) && (this.mDrawableContainerState.mHeight != 0);
  }
  
  public Drawable mutate()
  {
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      localDrawable.mutate();
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    if ((this.mUseExifOrientation) && (this.mDrawableContainerState.mStatus == 1) && (this.mCurrDrawable != null) && (this.mDrawableContainerState.mOrientation != 0) && (this.mDrawableContainerState.mOrientation != 1))
    {
      int j = paramRect.width();
      float f1 = j / 2.0F;
      int k = paramRect.height();
      float f2 = k / 2.0F;
      localObject = new Rect();
      Matrix localMatrix = new Matrix();
      int m = this.mDrawableContainerState.mOrientation;
      int i = 90;
      switch (m)
      {
      default: 
        localMatrix = null;
        localObject = paramRect;
        break;
      case 6: 
      case 8: 
        if (this.mDrawableContainerState.mOrientation != 6) {
          i = 270;
        }
        ((Rect)localObject).set(0, 0, k, j);
        localMatrix.setTranslate(-f2, -f1);
        localMatrix.postRotate(i);
        localMatrix.postTranslate(f1 + paramRect.left, f2 + paramRect.top);
        break;
      case 5: 
      case 7: 
        if (this.mDrawableContainerState.mOrientation != 5) {
          i = 270;
        }
        ((Rect)localObject).set(0, 0, j, k);
        localMatrix.setTranslate(-f1, -f2);
        localMatrix.postScale(1.0F, -1.0F);
        localMatrix.postRotate(i);
        localMatrix.postTranslate(f1 + paramRect.left, f2 + paramRect.top);
        break;
      case 4: 
        ((Rect)localObject).set(0, 0, j, k);
        localMatrix.setTranslate(-f1, -f2);
        localMatrix.postScale(1.0F, -1.0F);
        localMatrix.postTranslate(f1 + paramRect.left, f2 + paramRect.top);
        break;
      case 3: 
        ((Rect)localObject).set(0, 0, j, k);
        localMatrix.setTranslate(-f1, -f2);
        localMatrix.postRotate(180.0F);
        localMatrix.postTranslate(f1 + paramRect.left, f2 + paramRect.top);
        break;
      case 2: 
        ((Rect)localObject).set(0, 0, j, k);
        localMatrix.setTranslate(-f1, -f2);
        localMatrix.postScale(-1.0F, 1.0F);
        localMatrix.postTranslate(f1 + paramRect.left, f2 + paramRect.top);
      }
      this.mExifMatrix = localMatrix;
      this.mCurrDrawable.setBounds((Rect)localObject);
    }
    else
    {
      localObject = this.mCurrDrawable;
      if (localObject != null) {
        ((Drawable)localObject).setBounds(paramRect);
      }
    }
    Object localObject = this.mProgressDrawable;
    if (localObject != null) {
      ((Drawable)localObject).setBounds(paramRect);
    }
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    URLDrawable.DownloadListener localDownloadListener = this.mDownloadListener;
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadFailed(paramInt);
    }
  }
  
  public void onFileDownloadStarted()
  {
    URLDrawable.DownloadListener localDownloadListener = this.mDownloadListener;
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadStarted();
    }
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    URLDrawable.DownloadListener localDownloadListener = this.mDownloadListener;
    if (localDownloadListener != null) {
      localDownloadListener.onFileDownloadSucceed(paramLong);
    }
  }
  
  public void onFileDownloaded(URLState paramURLState)
  {
    if (getStatus() == 4)
    {
      paramURLState = this.mListener;
      if ((paramURLState != null) && ((paramURLState instanceof URLDrawable.URLDrawableListener2))) {
        ((URLDrawable.URLDrawableListener2)paramURLState).onFileDownloaded(this);
      }
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      return localDrawable.setLevel(paramInt);
    }
    return false;
  }
  
  public void onLoadCanceled(URLState paramURLState)
  {
    paramURLState = this.mListener;
    if (paramURLState != null) {
      paramURLState.onLoadCanceled(this);
    }
    if (Looper.myLooper() != Looper.getMainLooper()) {
      return;
    }
    invalidateSelf();
  }
  
  public void onLoadFailed(URLState paramURLState, Throwable paramThrowable)
  {
    Drawable localDrawable = this.mCurrDrawable;
    paramURLState = paramURLState.mCustomError;
    if (paramURLState != null) {
      this.mFailedDrawable = paramURLState.getFailedDrawable();
    } else if (this.mFailedDrawable == null) {
      this.mFailedDrawable = sDefaultDrawableParms.getDefualtFailedDrawable();
    }
    this.mCurrDrawable = this.mFailedDrawable;
    paramURLState = this.mCurrDrawable;
    if (paramURLState != null)
    {
      paramURLState.setAlpha(this.mAlpha);
      this.mCurrDrawable.setVisible(isVisible(), true);
      this.mCurrDrawable.setDither(this.mDrawableContainerState.mDither);
      this.mCurrDrawable.setColorFilter(this.mColorFilter);
      this.mCurrDrawable.setState(getState());
      this.mCurrDrawable.setLevel(getLevel());
      this.mCurrDrawable.setCallback(this);
      this.mCurrDrawable.setBounds(getBounds());
    }
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    paramURLState = this.mListener;
    if (paramURLState != null) {
      paramURLState.onLoadFialed(this, paramThrowable);
    }
    if (this.mFadeInImage) {
      this.mFadeInAnimationStarted = true;
    }
    this.mDrawableContainerState.mCacheFile = null;
    invalidateSelf();
    if (paramThrowable.toString().contains("response_code=404")) {
      httpdownloadError();
    }
  }
  
  public void onLoadStarted(URLState paramURLState)
  {
    invalidateSelf();
  }
  
  public void onLoadSuccessed(URLState paramURLState)
  {
    Drawable localDrawable = this.mCurrDrawable;
    paramURLState = paramURLState.mSuccessed.newDrawable();
    paramURLState.setAlpha(this.mAlpha);
    paramURLState.setVisible(isVisible(), true);
    paramURLState.setColorFilter(this.mColorFilter);
    paramURLState.setState(getState());
    paramURLState.setLevel(getLevel());
    paramURLState.setCallback(this);
    paramURLState.setBounds(getBounds());
    if (Build.VERSION.SDK_INT >= 23) {
      this.mCurrDrawable = paramURLState;
    }
    if ((paramURLState instanceof RegionDrawable))
    {
      ((RegionDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
    }
    else if ((paramURLState instanceof SliceBitmapDrawable))
    {
      ((SliceBitmapDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
    }
    else
    {
      Object localObject1;
      if ((paramURLState instanceof GifDrawable))
      {
        localObject1 = (GifDrawable)paramURLState;
        ((GifDrawable)localObject1).setTargetDensity(this.mTargetDensity);
        ((GifDrawable)localObject1).mUseAnimation = this.mUseGifAnimation;
      }
      else if ((paramURLState instanceof ApngDrawable))
      {
        localObject1 = (ApngDrawable)paramURLState;
        ((ApngDrawable)localObject1).setTargetDensity(this.mTargetDensity);
        ((ApngDrawable)localObject1).setUseRect(this.mExtraInfo);
        ((ApngDrawable)localObject1).mUseAnimation = this.mUseApngImage;
      }
      else if ((paramURLState instanceof RoundRectDrawable))
      {
        ((RoundRectDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
      }
      else if ((paramURLState instanceof VideoDrawable))
      {
        localObject1 = (VideoDrawable)paramURLState;
        ((VideoDrawable)localObject1).setTargetDensity(this.mTargetDensity);
        Object localObject2 = this.mExtraInfo;
        if ((localObject2 != null) && ((localObject2 instanceof VideoDrawable.VideoDrawableParams))) {
          ((VideoDrawable)localObject1).mPlayVideoFrame = ((VideoDrawable.VideoDrawableParams)localObject2).mPlayVideoFrame;
        }
      }
      else if ((paramURLState instanceof QQLiveDrawable))
      {
        ((QQLiveDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
      }
    }
    this.mCurrDrawable = paramURLState;
    if (localDrawable != null) {
      localDrawable.setCallback(null);
    }
    paramURLState = this.mListener;
    if (paramURLState != null) {
      paramURLState.onLoadSuccessed(this);
    }
    if (this.mFadeInImage) {
      this.mFadeInAnimationStarted = true;
    }
    paramURLState = this.mProgressDrawable;
    if (paramURLState != null)
    {
      paramURLState.setCallback(null);
      this.mProgressDrawable = null;
    }
    invalidateSelf();
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      localDrawable.setState(paramArrayOfInt);
    }
    return true;
  }
  
  public void onUpdateProgress(int paramInt)
  {
    Object localObject = this.mProgressDrawable;
    if (localObject != null)
    {
      ((Drawable)localObject).setLevel(paramInt);
      invalidateSelf();
    }
    localObject = this.mListener;
    if (localObject != null) {
      ((URLDrawable.URLDrawableListener)localObject).onLoadProgressed(this, paramInt);
    }
  }
  
  public void pauseVideo()
  {
    Drawable localDrawable = this.mCurrDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)localDrawable).pause();
    }
  }
  
  public void replay()
  {
    Drawable localDrawable = this.mCurrDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)localDrawable).replay();
    }
  }
  
  public void restartDownload()
  {
    if (this.mDrawableContainerState.reStartDownload(this.mHeaders, this.mCookies, this.mTag, true, this.mUseGifAnimation, this.mUseApngImage, this.mUseSharpPImage, this.mGifRoundCorner, this.mUseExifOrientation, this.mExtraInfo)) {
      invalidateSelf();
    }
  }
  
  public void resumeVideo()
  {
    Drawable localDrawable = this.mCurrDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)localDrawable).resume();
    }
  }
  
  public void run()
  {
    if (depImp.mLog.isColorLevel())
    {
      ILog localILog = depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startDownload from run : ");
      localStringBuilder.append(this.mDrawableContainerState.mUrlStr);
      localILog.d("URLDrawable_resume", 2, localStringBuilder.toString());
    }
    startDownload();
  }
  
  public String saveTo(String paramString)
  {
    return this.mDrawableContainerState.saveTo(paramString);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void seek(int paramInt)
  {
    Drawable localDrawable = this.mCurrDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)localDrawable).seek(paramInt);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.mAlpha != paramInt)
    {
      this.mAlpha = paramInt;
      Drawable localDrawable = this.mCurrDrawable;
      if (localDrawable != null) {
        localDrawable.setAlpha(paramInt);
      }
    }
  }
  
  public void setAutoDownload(boolean paramBoolean)
  {
    this.mAutoDownload = paramBoolean;
    if (paramBoolean) {
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mColorFilter != paramColorFilter)
    {
      this.mColorFilter = paramColorFilter;
      Drawable localDrawable = this.mCurrDrawable;
      if (localDrawable != null) {
        localDrawable.setColorFilter(paramColorFilter);
      }
    }
  }
  
  public void setCookies(CookieStore paramCookieStore)
  {
    this.mCookies = paramCookieStore;
  }
  
  public void setDecodeHandler(DownloadParams.DecodeHandler paramDecodeHandler)
  {
    this.mDrawableContainerState.mParams.mDecodeHandler = paramDecodeHandler;
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (this.mDrawableContainerState.mDither != paramBoolean)
    {
      URLState localURLState = this.mDrawableContainerState;
      localURLState.mDither = paramBoolean;
      Drawable localDrawable = this.mCurrDrawable;
      if (localDrawable != null) {
        localDrawable.setDither(localURLState.mDither);
      }
    }
  }
  
  public void setDownloadListener(URLDrawable.DownloadListener paramDownloadListener)
  {
    this.mDownloadListener = paramDownloadListener;
  }
  
  public void setFadeInImage(boolean paramBoolean)
  {
    this.mFadeInImage = paramBoolean;
  }
  
  public void setGIFPlayOnceListener(GifDrawable.OnGIFPlayOnceListener paramOnGIFPlayOnceListener)
  {
    Object localObject = this.mCurrDrawable;
    if ((localObject instanceof GifDrawable))
    {
      localObject = (GifDrawable.GifState)((GifDrawable)localObject).getConstantState();
      if ((localObject != null) && (((GifDrawable.GifState)localObject).mGif != null)) {
        ((GifDrawable.GifState)localObject).mGif.setGIFPlayOnceListener(paramOnGIFPlayOnceListener);
      }
    }
  }
  
  public void setHeaders(Header... paramVarArgs)
  {
    this.mHeaders = paramVarArgs;
  }
  
  public void setIgnorePause(boolean paramBoolean)
  {
    this.mDrawableContainerState.mIgnorePause = paramBoolean;
  }
  
  public void setIndividualPause(boolean paramBoolean)
  {
    Drawable localDrawable = this.mCurrDrawable;
    if ((localDrawable instanceof GifDrawable)) {
      ((GifDrawable.GifState)((GifDrawable)localDrawable).getConstantState()).setStickerPause(paramBoolean);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    Drawable localDrawable = this.mCurrDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)localDrawable).setMute(paramBoolean);
    }
  }
  
  public void setProgressDrawable(Drawable paramDrawable)
  {
    Drawable localDrawable = this.mProgressDrawable;
    if (localDrawable != paramDrawable)
    {
      if (localDrawable != null) {
        localDrawable.setCallback(null);
      }
      this.mProgressDrawable = paramDrawable;
      paramDrawable = this.mProgressDrawable;
      if (paramDrawable != null)
      {
        paramDrawable.setCallback(this);
        this.mProgressDrawable.setBounds(getBounds());
        this.mProgressDrawable.setLevel(this.mProgress);
      }
      onUpdateProgress(this.mDrawableContainerState.mProgress);
    }
  }
  
  public void setTag(Object paramObject)
  {
    this.mTag = paramObject;
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (paramInt != this.mTargetDensity)
    {
      int i;
      if (paramInt == 0) {
        i = 160;
      } else {
        i = paramInt;
      }
      this.mTargetDensity = i;
      if (getStatus() == 1)
      {
        Drawable localDrawable = this.mCurrDrawable;
        if ((localDrawable instanceof RegionDrawable))
        {
          ((RegionDrawable)localDrawable).setTargetDensity(paramInt);
          return;
        }
        if ((localDrawable instanceof SliceBitmapDrawable))
        {
          ((SliceBitmapDrawable)localDrawable).setTargetDensity(this.mTargetDensity);
          return;
        }
        if ((localDrawable instanceof GifDrawable))
        {
          ((GifDrawable)localDrawable).setTargetDensity(paramInt);
          return;
        }
        if ((localDrawable instanceof ApngDrawable))
        {
          ((ApngDrawable)localDrawable).setTargetDensity(paramInt);
          return;
        }
        if ((localDrawable instanceof RoundRectDrawable))
        {
          ((RoundRectDrawable)localDrawable).setTargetDensity(paramInt);
          return;
        }
        if ((localDrawable instanceof VideoDrawable))
        {
          ((VideoDrawable)localDrawable).setTargetDensity(paramInt);
          return;
        }
        if ((localDrawable instanceof QQLiveDrawable)) {
          ((QQLiveDrawable)localDrawable).setTargetDensity(paramInt);
        }
      }
    }
  }
  
  public void setURLDrawableListener(URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    this.mListener = paramURLDrawableListener;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    Drawable localDrawable = this.mCurrDrawable;
    if (localDrawable != null) {
      localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void setWatermarkDrawable(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.mWatermarkDrawable = paramBitmap;
    this.mWatermarkMarginRight = paramInt1;
    this.mWatermarkMarginButtom = paramInt2;
  }
  
  public void setWatermarkVisibility(int paramInt)
  {
    if (paramInt == 0) {
      this.mIsShowWatermark = true;
    } else {
      this.mIsShowWatermark = false;
    }
    invalidateSelf();
  }
  
  public void startDownload()
  {
    startDownload(true);
  }
  
  public void startDownload(boolean paramBoolean)
  {
    this.mDrawableContainerState.startDownload(this.mHeaders, this.mCookies, this.mTag, paramBoolean, this.mUseGifAnimation, this.mUseApngImage, this.mUseSharpPImage, this.mGifRoundCorner, this.mUseExifOrientation, this.mExtraInfo);
  }
  
  public void startVideo()
  {
    Drawable localDrawable = this.mCurrDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)localDrawable).startVideo();
    }
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
  
  public void updateRegionBitmap(RegionDrawableData paramRegionDrawableData)
  {
    if (!RegionDrawable.class.isInstance(this.mCurrDrawable)) {
      return;
    }
    Matrix localMatrix1 = this.mExifMatrix;
    if ((localMatrix1 != null) && (!localMatrix1.isIdentity()))
    {
      RectF localRectF = new RectF(paramRegionDrawableData.mShowArea);
      Matrix localMatrix2 = new Matrix();
      localMatrix1.invert(localMatrix2);
      localMatrix2.mapRect(localRectF);
      localRectF.round(paramRegionDrawableData.mShowArea);
      localRectF.set(paramRegionDrawableData.mImageArea);
      localMatrix2.mapRect(localRectF);
      localRectF.round(paramRegionDrawableData.mImageArea);
    }
    ((RegionDrawable)this.mCurrDrawable).updateRegionRect(paramRegionDrawableData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.URLDrawable
 * JD-Core Version:    0.7.0.1
 */
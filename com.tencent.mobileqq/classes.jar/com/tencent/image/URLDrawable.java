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
import android.support.v4.util.LruCache;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLStreamHandlerFactory;
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
  private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
  private static final int CPU_COUNT;
  public static boolean DEBUG = false;
  public static final int DECODE_FAIL_COMMON = 1;
  public static final int DECODE_FAIL_DEFAULT_IGNORE_DELETE_FILE = 3;
  public static final int DECODE_FAIL_DOWNLOADER_DELETE_FILE = 2;
  public static final int FAILED = 2;
  public static final int FILE_DOWNLOADED = 4;
  private static final int KEEP_ALIVE = 1;
  public static final int LOADING = 0;
  private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
  private static final int PENDING_ACTION_CAPACITY = 100;
  public static final int SUCCESSED = 1;
  public static final String TAG = "URLDrawable_";
  public static final String THREAD_SUB_TAG = "Thread";
  static Context mApplicationContext;
  static URLDrawable.DebuggableCallback sDebugCallback;
  static URLDrawableParams sDefaultDrawableParms;
  static MQLruCache<String, Object> sMemoryCache;
  static boolean sPause = false;
  static Object sPauseLock = new Object();
  private static final LruCache<URLDrawable, LruCache> sPendingActions = new LruCache(100);
  private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue(128);
  private static URLStreamHandlerFactory sStreamHandler = new URLDrawable.1();
  private static final ThreadFactory sThreadFactory = new URLDrawable.2();
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
      if (paramResources != null) {
        paramURLDrawable.setTargetDensity(paramResources.getDisplayMetrics().densityDpi);
      }
    }
    else {
      return paramURLDrawable;
    }
    paramURLDrawable.setTargetDensity(sDefaultDrawableParms.mDeviceDensity);
    return paramURLDrawable;
  }
  
  private void checkBitmapSize()
  {
    if ((sDebugCallback == null) || ((!DEBUG) && (!sDebugCallback.isNeedSample()))) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.mAlreadyChecked) || (!RegionDrawable.class.isInstance(this.mCurrDrawable)));
        this.mAlreadyChecked = true;
        localObject1 = getCallback();
      } while (!ImageView.class.isInstance(localObject1));
      localObject1 = (ImageView)localObject1;
      i = ((ImageView)localObject1).getMeasuredWidth();
      j = ((ImageView)localObject1).getMeasuredHeight();
      localObject2 = (RegionDrawable)this.mCurrDrawable;
      k = ((RegionDrawable)localObject2).getBitmap().getWidth();
      m = ((RegionDrawable)localObject2).getBitmap().getHeight();
    } while (!isBitmapOversize(k, m, i, j));
    Object localObject2 = "(" + i + "," + j + ")";
    String str1 = "(" + k + "," + m + ")";
    if ((((ImageView)localObject1).getContext() != null) && ((((ImageView)localObject1).getContext() instanceof Activity))) {}
    for (Object localObject1 = ((ImageView)localObject1).getContext().getClass().getName();; localObject1 = "")
    {
      i = this.mDrawableContainerState.mParams.reqHeight;
      j = this.mDrawableContainerState.mParams.reqWidth;
      String str2 = "(" + j + "," + i + ")";
      String str3 = getURL().toString();
      Exception localException = this.mCallStack;
      sDebugCallback.onDebug(1, new Object[] { localObject2, str1, str3, localObject1, localException, str2 });
      return;
    }
  }
  
  private static void checkParams()
  {
    if (sDefaultDrawableParms == null) {
      throw new IllegalStateException("Default params is not seted, please call setURLDrawableParams first");
    }
  }
  
  public static void clearMemoryCache()
  {
    sMemoryCache.evictAll();
  }
  
  /* Error */
  @Deprecated
  public static URLDrawable getDrawable(File paramFile, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 391	java/io/File:toURI	()Ljava/net/URI;
    //   6: invokevirtual 396	java/net/URI:toURL	()Ljava/net/URL;
    //   9: astore_3
    //   10: aload_2
    //   11: astore_0
    //   12: aload_3
    //   13: ifnull +9 -> 22
    //   16: aload_3
    //   17: aload_1
    //   18: invokestatic 399	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   21: astore_0
    //   22: aload_0
    //   23: areturn
    //   24: aload_0
    //   25: athrow
    //   26: astore_0
    //   27: aload_2
    //   28: astore_0
    //   29: iconst_0
    //   30: ifeq -8 -> 22
    //   33: aconst_null
    //   34: aload_1
    //   35: invokestatic 399	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   38: areturn
    //   39: astore_0
    //   40: iconst_0
    //   41: ifeq -17 -> 24
    //   44: aconst_null
    //   45: aload_1
    //   46: invokestatic 399	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   49: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	paramFile	File
    //   0	50	1	paramURLDrawableOptions	URLDrawable.URLDrawableOptions
    //   1	27	2	localObject	Object
    //   9	8	3	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   2	10	26	java/net/MalformedURLException
    //   2	10	39	finally
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
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
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
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
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
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    int i;
    do
    {
      for (;;)
      {
        try
        {
          checkParams();
          localURLDrawableOptions = paramURLDrawableOptions;
          if (paramURLDrawableOptions == null) {
            localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          }
          localObject = URLState.getConstants(paramURL.toString(), localURLDrawableOptions);
          if (localObject == null) {
            break label596;
          }
          paramURLDrawableOptions = (URLDrawable)((URLState)localObject).newDrawable(null);
          if (((URLState)localObject).mParams.mAutoScaleByDensity)
          {
            paramURLDrawableOptions = autoScale(null, paramURLDrawableOptions);
            paramURLDrawableOptions.mUseExifOrientation = localURLDrawableOptions.mUseExifOrientation;
            paramURLDrawableOptions.mExtraInfo = localURLDrawableOptions.mExtraInfo;
            i = paramURLDrawableOptions.getStatus();
            if (i != 1) {
              break label366;
            }
            if ((paramURLDrawableOptions.mCurrDrawable instanceof GifDrawable))
            {
              ((GifDrawable)paramURLDrawableOptions.mCurrDrawable).mUseAnimation = localURLDrawableOptions.mPlayGifImage;
              paramURLDrawableOptions.mCallStack = new IllegalStateException("UrlDrawable getStack");
              localURLDrawableOptions.Recycle();
              paramURL = paramURLDrawableOptions;
              return paramURL;
            }
          }
          else
          {
            continue;
          }
          if ((paramURLDrawableOptions.mCurrDrawable instanceof ApngDrawable))
          {
            ((ApngDrawable)paramURLDrawableOptions.mCurrDrawable).mUseAnimation = localURLDrawableOptions.mUseApngImage;
            ((ApngDrawable)paramURLDrawableOptions.mCurrDrawable).setUseRect(localURLDrawableOptions.mExtraInfo);
            paramURLDrawableOptions.mUseApngImage = localURLDrawableOptions.mUseApngImage;
            continue;
          }
          if (!(paramURLDrawableOptions.mCurrDrawable instanceof VideoDrawable)) {
            break;
          }
        }
        finally {}
        if ((localURLDrawableOptions.mExtraInfo != null) && ((localURLDrawableOptions.mExtraInfo instanceof VideoDrawable.VideoDrawableParams))) {
          ((VideoDrawable)paramURLDrawableOptions.mCurrDrawable).mPlayVideoFrame = ((VideoDrawable.VideoDrawableParams)localURLDrawableOptions.mExtraInfo).mPlayVideoFrame;
        }
      }
    } while ((!(paramURLDrawableOptions.mCurrDrawable instanceof QQLiveDrawable)) || (localURLDrawableOptions.mExtraInfo == null) || (!(localURLDrawableOptions.mExtraInfo instanceof QQLiveDrawable.QQLiveDrawableParams)));
    paramURL = (QQLiveDrawable)paramURLDrawableOptions.mCurrDrawable;
    Object localObject = (QQLiveDrawable.QQLiveDrawableParams)localURLDrawableOptions.mExtraInfo;
    paramURL.setParams((QQLiveDrawable.QQLiveDrawableParams)localObject);
    if ((((QQLiveDrawable.QQLiveDrawableParams)localObject).mPlayPause) || (QQLiveImage.isAllPaused())) {
      paramURL.pause();
    }
    for (;;)
    {
      paramURL.setOnStateListener(((QQLiveDrawable.QQLiveDrawableParams)localObject).mListener);
      paramURL.setOnDownloadListener(((QQLiveDrawable.QQLiveDrawableParams)localObject).mDownloadListener);
      paramURL.setOnLoopBackListener(((QQLiveDrawable.QQLiveDrawableParams)localObject).mLoopBackListener);
      break;
      if (((QQLiveDrawable.QQLiveDrawableParams)localObject).mStartPosi > 0) {
        paramURL.resumeFromPosi(((QQLiveDrawable.QQLiveDrawableParams)localObject).mStartPosi);
      } else {
        paramURL.resume();
      }
    }
    label366:
    paramURLDrawableOptions.mUseGifAnimation = localURLDrawableOptions.mPlayGifImage;
    paramURLDrawableOptions.mUseApngImage = localURLDrawableOptions.mUseApngImage;
    paramURLDrawableOptions.mUseSharpPImage = localURLDrawableOptions.mUseSharpPImage;
    paramURLDrawableOptions.mGifRoundCorner = localURLDrawableOptions.mGifRoundCorner;
    paramURLDrawableOptions.mFadeInImage = sDefaultDrawableParms.mFadeInImage;
    CustomError localCustomError = ((URLState)localObject).mCustomError;
    if (i == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("URLDrawable_", 2, "getDrawable from cache url= " + paramURL.toString() + ",isLoadingStarted" + ((URLState)localObject).mIsLoadingStarted);
      }
      if (localCustomError != null) {
        paramURLDrawableOptions.mFailedDrawable = localCustomError.getFailedDrawable();
      }
      for (;;)
      {
        paramURLDrawableOptions.mCurrDrawable = paramURLDrawableOptions.mFailedDrawable;
        break;
        if (localURLDrawableOptions.mFailedDrawable != null) {
          paramURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mFailedDrawable;
        } else {
          paramURLDrawableOptions.mFailedDrawable = sDefaultDrawableParms.getDefualtFailedDrawable();
        }
      }
    }
    paramURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mFailedDrawable;
    if (localURLDrawableOptions.mLoadingDrawable == null) {}
    for (paramURL = sDefaultDrawableParms.getDefaultLoadingDrawable();; paramURL = localURLDrawableOptions.mLoadingDrawable)
    {
      paramURLDrawableOptions.mProgressDrawable = paramURL;
      paramURLDrawableOptions.mCurrDrawable = paramURLDrawableOptions.mProgressDrawable;
      if (i != 4) {
        break;
      }
      paramURL = ((URLState)localObject).mParams;
      if ((localURLDrawableOptions.mRequestWidth == 0) || (localURLDrawableOptions.mRequestHeight == 0)) {
        break;
      }
      break;
    }
    label596:
    paramURLDrawableOptions = new URLDrawable(paramURL, localURLDrawableOptions);
    paramURLDrawableOptions.mUseGifAnimation = localURLDrawableOptions.mPlayGifImage;
    paramURLDrawableOptions.mUseApngImage = localURLDrawableOptions.mUseApngImage;
    paramURLDrawableOptions.mUseSharpPImage = localURLDrawableOptions.mUseSharpPImage;
    paramURLDrawableOptions.mGifRoundCorner = localURLDrawableOptions.mGifRoundCorner;
    paramURLDrawableOptions.mFadeInImage = sDefaultDrawableParms.mFadeInImage;
    paramURLDrawableOptions.mUseExifOrientation = localURLDrawableOptions.mUseExifOrientation;
    paramURLDrawableOptions.mExtraInfo = localURLDrawableOptions.mExtraInfo;
    localObject = paramURLDrawableOptions.mDrawableContainerState.mParams;
    ((DownloadParams)localObject).url = paramURL;
    ((DownloadParams)localObject).urlStr = paramURL.toString();
    ((DownloadParams)localObject).needCheckNetType = localURLDrawableOptions.mNeedCheckNetType;
    ((DownloadParams)localObject).retryCount = localURLDrawableOptions.mRetryCount;
    ((DownloadParams)localObject).mHttpDownloaderParams = localURLDrawableOptions.mHttpDownloaderParams;
    if (localURLDrawableOptions.mUseAutoScaleParams) {
      ((DownloadParams)localObject).mAutoScaleByDensity = sDefaultDrawableParms.mAutoScaleByDensity;
    }
    if ((localURLDrawableOptions.mRequestWidth == 0) || (localURLDrawableOptions.mRequestHeight == 0)) {
      ((DownloadParams)localObject).reqWidth = sDefaultDrawableParms.mReqWidth;
    }
    for (((DownloadParams)localObject).reqHeight = sDefaultDrawableParms.mReqHeight;; ((DownloadParams)localObject).reqHeight = localURLDrawableOptions.mRequestHeight)
    {
      ((DownloadParams)localObject).mImgType = localURLDrawableOptions.mImgType;
      paramURL = paramURLDrawableOptions;
      if (localURLDrawableOptions.mUseAutoScaleParams) {
        paramURL = autoScale(null, paramURLDrawableOptions);
      }
      paramURL.mCallStack = new IllegalStateException("UrlDrawable getStack");
      localURLDrawableOptions.Recycle();
      break;
      ((DownloadParams)localObject).reqWidth = localURLDrawableOptions.mRequestWidth;
    }
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, boolean paramBoolean)
  {
    return getDrawable(paramURL, null, null, paramBoolean);
  }
  
  public static URLDrawable getFileDrawable(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    Object localObject = null;
    try
    {
      URL localURL = new URI("file", null, paramString, null).toURL();
      paramString = localObject;
      if (localURL != null) {
        paramString = getDrawable(localURL, paramURLDrawableOptions);
      }
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
      paramString = localObject;
      return getDrawable(null, paramURLDrawableOptions);
    }
    catch (URISyntaxException paramString)
    {
      paramString.printStackTrace();
      paramString = localObject;
      return getDrawable(null, paramURLDrawableOptions);
      throw paramString;
    }
    finally
    {
      while (0 == 0) {}
    }
    return paramString;
    return getDrawable(null, paramURLDrawableOptions);
  }
  
  public static int getPoolSize()
  {
    return URLDrawable.URLDrawableOptions.access$000();
  }
  
  private void httpdownloadError()
  {
    if (sDebugCallback == null) {
      return;
    }
    String str = getURL().toString();
    Exception localException = this.mCallStack;
    sDebugCallback.onDebug(2, new Object[] { str, localException });
  }
  
  public static void init(Context paramContext, URLDrawableParams paramURLDrawableParams)
  {
    URL.setURLStreamHandlerFactory(sStreamHandler);
    if (sDefaultDrawableParms != null) {
      throw new IllegalArgumentException("please don't call setURLDrawableParams twice");
    }
    if (paramURLDrawableParams.mSubHandler == null) {
      paramURLDrawableParams.mSubHandler = new Handler(((HandlerThread)ThreadManagerV2.getSubThread()).getLooper());
    }
    sDefaultDrawableParms = paramURLDrawableParams;
    if (paramURLDrawableParams.mMemoryCache == null) {}
    for (sMemoryCache = new URLDrawable.3(paramURLDrawableParams.mMemoryCacheSize);; sMemoryCache = paramURLDrawableParams.mMemoryCache)
    {
      mApplicationContext = paramContext;
      paramURLDrawableParams.mSubHandler.post(new URLDrawable.4());
      return;
    }
  }
  
  private boolean isBitmapOversize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt3 == 0) || (paramInt4 == 0) || (paramInt3 == -1) || (paramInt4 == -1)) {}
    for (;;)
    {
      return false;
      if ((paramInt2 > paramInt4) && (paramInt1 > paramInt3))
      {
        paramInt2 = Math.round(paramInt2 / paramInt4);
        paramInt1 = Math.round(paramInt1 / paramInt3);
        if (paramInt2 > paramInt1) {
          paramInt1 = paramInt2;
        }
        while (paramInt1 >= 2) {
          return true;
        }
      }
    }
  }
  
  public static void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("URLDrawable_pause", 2, "pause load image ");
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
    sMemoryCache.remove(paramString);
  }
  
  public static void removeMemoryCacheByUrl(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    paramString = URLState.getMemoryCacheKey(paramString, paramURLDrawableOptions);
    sMemoryCache.remove(paramString);
  }
  
  public static void reportLoadingDrawableError()
  {
    if ((sDebugCallback != null) && (sDebugCallback.isNeedSample())) {
      sDebugCallback.onReportLoadingDrawableError();
    }
  }
  
  public static void resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("URLDrawable_resume", 2, "resume load image " + new java.lang.RuntimeException("getStack").getStackTrace()[1].toString());
    }
    synchronized (sPauseLock)
    {
      sPause = false;
      sPauseLock.notifyAll();
      Object localObject2 = sPendingActions.snapshot();
      if (QLog.isColorLevel()) {
        QLog.d("URLDrawable_resume", 2, "resume sPendingActions size= " + sPendingActions.size());
      }
      localObject2 = ((Map)localObject2).keySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        URLDrawable localURLDrawable = (URLDrawable)((Iterator)localObject2).next();
        localURLDrawable.scheduleSelf(localURLDrawable, SystemClock.uptimeMillis() + 1L);
        sPendingActions.remove(localURLDrawable);
      }
    }
  }
  
  public static void setDebuggableCallback(URLDrawable.DebuggableCallback paramDebuggableCallback)
  {
    if ((DEBUG) && (sDebugCallback != null)) {
      throw new IllegalArgumentException("please don't call setDebuggableCallback twice");
    }
    sDebugCallback = paramDebuggableCallback;
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
    if ((this.mHeaders == null) || (this.mHeaders.length == 0))
    {
      this.mHeaders = new Header[] { new BasicHeader(paramString1, paramString2) };
      return;
    }
    Header[] arrayOfHeader = new Header[this.mHeaders.length + 1];
    System.arraycopy(this.mHeaders, 0, arrayOfHeader, 0, this.mHeaders.length);
    arrayOfHeader[this.mHeaders.length] = new BasicHeader(paramString1, paramString2);
    this.mHeaders = arrayOfHeader;
  }
  
  public void cancelDownload()
  {
    cancelDownload(false);
  }
  
  public void cancelDownload(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("URLDrawable_", 2, "[cancelDownload]" + getURL());
    }
    if (this.mDrawableContainerState.mTask != null) {
      this.mDrawableContainerState.mTask.mDownloadRunnable.cancel();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("URLDrawable_", 2, "[cancelDownload]task is null, cancel failed..." + getURL());
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
    int i;
    int j;
    Rect localRect;
    if (this.mCurrDrawable != null)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        checkBitmapSize();
      }
      i = paramCanvas.save();
      if ((this.mFadeInImage) && (this.mFadeInAnimationStarted))
      {
        long l = AnimationUtils.currentAnimationTimeMillis();
        if (this.mFadeInAnimationStartTime == -1L) {
          this.mFadeInAnimationStartTime = l;
        }
        float f = (float)(l - this.mFadeInAnimationStartTime) / 600.0F;
        if ((f < 0.0F) || (f > 1.0F)) {
          break label438;
        }
        j = Math.min((int)((1.0F - (1.0F - f) * (1.0F - f)) * 255.0F), 255);
        localRect = getBounds();
        if (Build.VERSION.SDK_INT < 21) {
          break label402;
        }
        paramCanvas.saveLayerAlpha(localRect.left, localRect.top, localRect.width(), localRect.height(), j);
        invalidateSelf();
      }
    }
    for (;;)
    {
      if (this.mExifMatrix != null) {
        paramCanvas.concat(this.mExifMatrix);
      }
      this.mCurrDrawable.draw(paramCanvas);
      if ((this.mIsShowWatermark == true) && (this.mWatermarkDrawable != null))
      {
        int i1 = this.mWatermarkDrawable.getWidth();
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
      if ((getStatus() == 0) && (this.mProgressDrawable != null) && (this.mDrawableContainerState.mIsLoadingStarted == 1)) {
        this.mProgressDrawable.draw(paramCanvas);
      }
      paramCanvas.restoreToCount(i);
      if (this.mAutoDownload)
      {
        if (this.individualPause) {
          this.individualPauseCount += 1;
        }
        if (((sPause) && (!this.mDrawableContainerState.mIgnorePause)) || ((this.individualPause) && ((!this.individualPause) || (this.individualPauseCount != 1)))) {
          break label446;
        }
        startDownload();
      }
      return;
      label402:
      paramCanvas.saveLayerAlpha(localRect.left, localRect.top, localRect.width(), localRect.height(), j, 31);
      break;
      label438:
      this.mFadeInAnimationStarted = false;
    }
    label446:
    if (QLog.isDevelopLevel()) {
      QLog.d("URLDrawable_pause", 4, "addToPending:" + getURL());
    }
    sPendingActions.put(this, sPendingActions);
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
    if ((this.mCurrDrawable != null) && ((this.mCurrDrawable instanceof QQLiveDrawable))) {
      return ((QQLiveDrawable)this.mCurrDrawable).getCurrentPosition();
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
  
  public File getFileInLocal()
  {
    if (this.mDrawableContainerState == null) {
      return null;
    }
    return this.mDrawableContainerState.mCacheFile;
  }
  
  public Header getHeader(String paramString)
  {
    if (this.mHeaders != null)
    {
      Header[] arrayOfHeader = this.mHeaders;
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
      switch (this.mDrawableContainerState.mOrientation)
      {
      default: 
        if (this.mDrawableContainerState.mHeight > 0) {
          return this.mDrawableContainerState.mHeight;
        }
        break;
      case 5: 
      case 6: 
      case 7: 
      case 8: 
        if (this.mDrawableContainerState.mWidth > 0) {
          return this.mDrawableContainerState.mWidth;
        }
        return this.mCurrDrawable.getIntrinsicWidth();
      }
      return this.mCurrDrawable.getIntrinsicHeight();
    }
    if (this.mDrawableContainerState.mHeight > 0) {
      return this.mDrawableContainerState.mHeight;
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    if ((this.mUseExifOrientation) && (this.mDrawableContainerState.mStatus == 1) && (this.mCurrDrawable != null))
    {
      switch (this.mDrawableContainerState.mOrientation)
      {
      default: 
        if (this.mDrawableContainerState.mWidth > 0) {
          return this.mDrawableContainerState.mWidth;
        }
        break;
      case 5: 
      case 6: 
      case 7: 
      case 8: 
        if (this.mDrawableContainerState.mHeight > 0) {
          return this.mDrawableContainerState.mHeight;
        }
        return this.mCurrDrawable.getIntrinsicHeight();
      }
      return this.mCurrDrawable.getIntrinsicWidth();
    }
    if (this.mDrawableContainerState.mWidth > 0) {
      return this.mDrawableContainerState.mWidth;
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int getPlayState()
  {
    if ((this.mCurrDrawable != null) && ((this.mCurrDrawable instanceof QQLiveDrawable))) {
      return ((QQLiveDrawable)this.mCurrDrawable).getPlayState();
    }
    return -1;
  }
  
  public int getProgress()
  {
    return this.mProgress;
  }
  
  public CustomError getStateError()
  {
    if (this.mDrawableContainerState != null) {
      return this.mDrawableContainerState.mCustomError;
    }
    return null;
  }
  
  public Object getStateTag()
  {
    if (this.mDrawableContainerState != null) {
      return this.mDrawableContainerState.mParams.tag;
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
    return ((this.mCurrDrawable instanceof GifDrawable)) || ((this.mCurrDrawable instanceof ApngDrawable));
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
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.mutate();
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int j;
    float f1;
    int k;
    float f2;
    Object localObject1;
    Object localObject2;
    if ((this.mUseExifOrientation) && (this.mDrawableContainerState.mStatus == 1) && (this.mCurrDrawable != null) && (this.mDrawableContainerState.mOrientation != 0) && (this.mDrawableContainerState.mOrientation != 1))
    {
      j = paramRect.width();
      f1 = j / 2.0F;
      k = paramRect.height();
      f2 = k / 2.0F;
      localObject1 = new Rect();
      localObject2 = new Matrix();
      switch (this.mDrawableContainerState.mOrientation)
      {
      default: 
        localObject1 = null;
        localObject2 = paramRect;
        this.mExifMatrix = ((Matrix)localObject1);
        this.mCurrDrawable.setBounds((Rect)localObject2);
      }
    }
    for (;;)
    {
      if (this.mProgressDrawable != null) {
        this.mProgressDrawable.setBounds(paramRect);
      }
      return;
      ((Rect)localObject1).set(0, 0, j, k);
      ((Matrix)localObject2).setTranslate(-f1, -f2);
      ((Matrix)localObject2).postScale(-1.0F, 1.0F);
      ((Matrix)localObject2).postTranslate(paramRect.left + f1, paramRect.top + f2);
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      ((Rect)localObject1).set(0, 0, j, k);
      ((Matrix)localObject2).setTranslate(-f1, -f2);
      ((Matrix)localObject2).postScale(1.0F, -1.0F);
      ((Matrix)localObject2).postTranslate(paramRect.left + f1, paramRect.top + f2);
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      if (this.mDrawableContainerState.mOrientation == 5) {}
      for (int i = 90;; i = 270)
      {
        ((Rect)localObject1).set(0, 0, j, k);
        ((Matrix)localObject2).setTranslate(-f1, -f2);
        ((Matrix)localObject2).postScale(1.0F, -1.0F);
        ((Matrix)localObject2).postRotate(i);
        ((Matrix)localObject2).postTranslate(paramRect.left + f1, paramRect.top + f2);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
      }
      if (this.mDrawableContainerState.mOrientation == 6) {}
      for (i = 90;; i = 270)
      {
        ((Rect)localObject1).set(0, 0, k, j);
        ((Matrix)localObject2).setTranslate(-f2, -f1);
        ((Matrix)localObject2).postRotate(i);
        ((Matrix)localObject2).postTranslate(paramRect.left + f1, paramRect.top + f2);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        break;
      }
      ((Rect)localObject1).set(0, 0, j, k);
      ((Matrix)localObject2).setTranslate(-f1, -f2);
      ((Matrix)localObject2).postRotate(180.0F);
      ((Matrix)localObject2).postTranslate(paramRect.left + f1, paramRect.top + f2);
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break;
      if (this.mCurrDrawable != null) {
        this.mCurrDrawable.setBounds(paramRect);
      }
    }
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (this.mDownloadListener != null) {
      this.mDownloadListener.onFileDownloadFailed(paramInt);
    }
  }
  
  public void onFileDownloadStarted()
  {
    if (this.mDownloadListener != null) {
      this.mDownloadListener.onFileDownloadStarted();
    }
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    if (this.mDownloadListener != null) {
      this.mDownloadListener.onFileDownloadSucceed(paramLong);
    }
  }
  
  public void onFileDownloaded(URLState paramURLState)
  {
    if ((getStatus() == 4) && (this.mListener != null) && ((this.mListener instanceof URLDrawable.URLDrawableListener2))) {
      ((URLDrawable.URLDrawableListener2)this.mListener).onFileDownloaded(this);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.setLevel(paramInt);
    }
    return false;
  }
  
  public void onLoadCanceled(URLState paramURLState)
  {
    if (this.mListener != null) {
      this.mListener.onLoadCanceled(this);
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
    }
    for (;;)
    {
      this.mCurrDrawable = this.mFailedDrawable;
      if (this.mCurrDrawable != null)
      {
        this.mCurrDrawable.setAlpha(this.mAlpha);
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
      if (this.mListener != null) {
        this.mListener.onLoadFialed(this, paramThrowable);
      }
      if (this.mFadeInImage) {
        this.mFadeInAnimationStarted = true;
      }
      this.mDrawableContainerState.mCacheFile = null;
      invalidateSelf();
      if (paramThrowable.toString().contains("response_code=404")) {
        httpdownloadError();
      }
      return;
      if (this.mFailedDrawable == null) {
        this.mFailedDrawable = sDefaultDrawableParms.getDefualtFailedDrawable();
      }
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
    if ((paramURLState instanceof RegionDrawable)) {
      ((RegionDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
    }
    for (;;)
    {
      this.mCurrDrawable = paramURLState;
      if (localDrawable != null) {
        localDrawable.setCallback(null);
      }
      if (this.mListener != null) {
        this.mListener.onLoadSuccessed(this);
      }
      if (this.mFadeInImage) {
        this.mFadeInAnimationStarted = true;
      }
      if (this.mProgressDrawable != null)
      {
        this.mProgressDrawable.setCallback(null);
        this.mProgressDrawable = null;
      }
      invalidateSelf();
      return;
      if ((paramURLState instanceof SliceBitmapDrawable))
      {
        ((SliceBitmapDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
      }
      else if ((paramURLState instanceof GifDrawable))
      {
        ((GifDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
        ((GifDrawable)paramURLState).mUseAnimation = this.mUseGifAnimation;
      }
      else if ((paramURLState instanceof ApngDrawable))
      {
        ((ApngDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
        ((ApngDrawable)paramURLState).setUseRect(this.mExtraInfo);
        ((ApngDrawable)paramURLState).mUseAnimation = this.mUseApngImage;
      }
      else if ((paramURLState instanceof RoundRectDrawable))
      {
        ((RoundRectDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
      }
      else if ((paramURLState instanceof VideoDrawable))
      {
        VideoDrawable localVideoDrawable = (VideoDrawable)paramURLState;
        localVideoDrawable.setTargetDensity(this.mTargetDensity);
        if ((this.mExtraInfo != null) && ((this.mExtraInfo instanceof VideoDrawable.VideoDrawableParams))) {
          localVideoDrawable.mPlayVideoFrame = ((VideoDrawable.VideoDrawableParams)this.mExtraInfo).mPlayVideoFrame;
        }
      }
      else if ((paramURLState instanceof QQLiveDrawable))
      {
        ((QQLiveDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
      }
    }
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.setState(paramArrayOfInt);
    }
    return true;
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (this.mProgressDrawable != null)
    {
      this.mProgressDrawable.setLevel(paramInt);
      invalidateSelf();
    }
    if (this.mListener != null) {
      this.mListener.onLoadProgressed(this, paramInt);
    }
  }
  
  public void pauseVideo()
  {
    if ((this.mCurrDrawable != null) && ((this.mCurrDrawable instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.mCurrDrawable).pause();
    }
  }
  
  public void replay()
  {
    if ((this.mCurrDrawable != null) && ((this.mCurrDrawable instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.mCurrDrawable).replay();
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
    if ((this.mCurrDrawable != null) && ((this.mCurrDrawable instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.mCurrDrawable).resume();
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("URLDrawable_resume", 2, "startDownload from run : " + this.mDrawableContainerState.mUrlStr);
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
    if ((this.mCurrDrawable != null) && ((this.mCurrDrawable instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.mCurrDrawable).seek(paramInt);
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.mAlpha != paramInt)
    {
      this.mAlpha = paramInt;
      if (this.mCurrDrawable != null) {
        this.mCurrDrawable.setAlpha(paramInt);
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
      if (this.mCurrDrawable != null) {
        this.mCurrDrawable.setColorFilter(paramColorFilter);
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
      this.mDrawableContainerState.mDither = paramBoolean;
      if (this.mCurrDrawable != null) {
        this.mCurrDrawable.setDither(this.mDrawableContainerState.mDither);
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
    if ((this.mCurrDrawable instanceof GifDrawable))
    {
      GifDrawable.GifState localGifState = (GifDrawable.GifState)((GifDrawable)this.mCurrDrawable).getConstantState();
      if ((localGifState != null) && (localGifState.mGif != null)) {
        localGifState.mGif.setGIFPlayOnceListener(paramOnGIFPlayOnceListener);
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
    if ((this.mCurrDrawable instanceof GifDrawable)) {
      ((GifDrawable.GifState)((GifDrawable)this.mCurrDrawable).getConstantState()).setStickerPause(paramBoolean);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    if ((this.mCurrDrawable != null) && ((this.mCurrDrawable instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.mCurrDrawable).setMute(paramBoolean);
    }
  }
  
  public void setProgressDrawable(Drawable paramDrawable)
  {
    if (this.mProgressDrawable != paramDrawable)
    {
      if (this.mProgressDrawable != null) {
        this.mProgressDrawable.setCallback(null);
      }
      this.mProgressDrawable = paramDrawable;
      if (this.mProgressDrawable != null)
      {
        this.mProgressDrawable.setCallback(this);
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
    int i;
    if (paramInt != this.mTargetDensity)
    {
      if (paramInt != 0) {
        break label51;
      }
      i = 160;
      this.mTargetDensity = i;
      if (getStatus() == 1)
      {
        if (!(this.mCurrDrawable instanceof RegionDrawable)) {
          break label56;
        }
        ((RegionDrawable)this.mCurrDrawable).setTargetDensity(paramInt);
      }
    }
    label51:
    label56:
    do
    {
      return;
      i = paramInt;
      break;
      if ((this.mCurrDrawable instanceof SliceBitmapDrawable))
      {
        ((SliceBitmapDrawable)this.mCurrDrawable).setTargetDensity(this.mTargetDensity);
        return;
      }
      if ((this.mCurrDrawable instanceof GifDrawable))
      {
        ((GifDrawable)this.mCurrDrawable).setTargetDensity(paramInt);
        return;
      }
      if ((this.mCurrDrawable instanceof ApngDrawable))
      {
        ((ApngDrawable)this.mCurrDrawable).setTargetDensity(paramInt);
        return;
      }
      if ((this.mCurrDrawable instanceof RoundRectDrawable))
      {
        ((RoundRectDrawable)this.mCurrDrawable).setTargetDensity(paramInt);
        return;
      }
      if ((this.mCurrDrawable instanceof VideoDrawable))
      {
        ((VideoDrawable)this.mCurrDrawable).setTargetDensity(paramInt);
        return;
      }
    } while (!(this.mCurrDrawable instanceof QQLiveDrawable));
    ((QQLiveDrawable)this.mCurrDrawable).setTargetDensity(paramInt);
  }
  
  public void setURLDrawableListener(URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    this.mListener = paramURLDrawableListener;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.setVisible(paramBoolean1, paramBoolean2);
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
    if (paramInt == 0) {}
    for (this.mIsShowWatermark = true;; this.mIsShowWatermark = false)
    {
      invalidateSelf();
      return;
    }
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
    if ((this.mCurrDrawable != null) && ((this.mCurrDrawable instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)this.mCurrDrawable).startVideo();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLDrawable
 * JD-Core Version:    0.7.0.1
 */
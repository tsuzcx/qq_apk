package com.tencent.image;

import android.app.PendingIntent.CanceledException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;

public final class URLState
  extends Drawable.ConstantState
{
  static final String CACHE_PREFIX = "Cache_";
  static final Object DOWNLOAD_ASYNC = new Object();
  static final Object FILE_DOWNLOADED;
  public static final int FLAG_BATCH_HANDLER = 2;
  public static final int FLAG_FILE_HANDLER = 0;
  public static final int FLAG_THREAD_POOL = 1;
  public static final int INTERVAL_TIME = 300000;
  public static final int LENGTH_URL_EXTRA = 60;
  public static final int REPORT_TIME = 500000;
  public static final String TENCENT_FILE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/";
  public static final int THREAD_COST_TIME = 500000;
  private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());
  private static String[] sSysTracePrefixs = { "android.", "com.android.", "dalvik.", "com.google.", "java." };
  static ConcurrentHashMap<String, URLState.ThreadReportParam> sThreadReportCache;
  static HashMap<String, WeakReference<URLState>> sUnFinishImageCache = new HashMap();
  static long slastCheckTime;
  private Vector<WeakReference<URLState.Callback>> callbacks = new Vector();
  boolean isFlashPicNeedCache = false;
  File mCacheFile;
  CustomError mCustomError;
  boolean mDecodeFile;
  private final Object mDecodeFileLock = new Object();
  int mDecodeFileStrategy = 1;
  boolean mDither = true;
  int mHeight = 0;
  boolean mIgnorePause = false;
  int mIsLoadingStarted = 0;
  String mMemoryCacheKey;
  int mOrientation = 0;
  DownloadParams mParams = new DownloadParams();
  byte mPriority = 1;
  int mProgress = 0;
  ProtocolDownloader mProtocolDownloader;
  int mStatus = 0;
  Drawable.ConstantState mSuccessed;
  URLState.PreDownloadRunnable mTask;
  URL mUrl;
  String mUrlStr;
  boolean mUseMemoryCache = true;
  boolean mUseThreadPool = true;
  boolean mUseUnFinishCache = true;
  int mWidth = 0;
  
  static
  {
    sThreadReportCache = new ConcurrentHashMap();
    slastCheckTime = 0L;
    FILE_DOWNLOADED = new Object();
  }
  
  URLState(URL arg1, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    this.mUrl = ???;
    this.isFlashPicNeedCache = paramURLDrawableOptions.isFlashPic;
    this.mUrlStr = ???.toString();
    this.mMemoryCacheKey = getMemoryCacheKey(this.mUrlStr, paramURLDrawableOptions);
    this.mUseMemoryCache = paramURLDrawableOptions.mUseMemoryCache;
    this.mUseUnFinishCache = paramURLDrawableOptions.mUseUnFinishCache;
    this.mUseThreadPool = paramURLDrawableOptions.mUseThreadPool;
    this.mDecodeFileStrategy = paramURLDrawableOptions.mDecodeFileStrategy;
    this.mPriority = paramURLDrawableOptions.mPriority;
    this.mProtocolDownloader = URLDrawable.sDefaultDrawableParms.getDownloader(???.getProtocol(), paramURLDrawableOptions.mHttpDownloaderParams);
    if ((this.mProtocolDownloader == null) && (QLog.isDevelopLevel())) {
      QLog.e("URLDrawable_", 4, "No comfortable downloader. url:" + ??? + "protocol" + ???.getProtocol());
    }
    synchronized (URLDrawable.sMemoryCache)
    {
      if (this.mUseUnFinishCache) {
        sUnFinishImageCache.put(this.mMemoryCacheKey, new WeakReference(this));
      }
      return;
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = 1;
    int j = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 != -1) {
            break label42;
          }
          m = j;
        }
      }
    }
    label42:
    int k;
    label54:
    do
    {
      do
      {
        return m;
        j = paramOptions.outHeight;
        k = paramOptions.outWidth;
        m = i;
      } while (j <= paramInt2);
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      i <<= 1;
      k >>= 1;
      j >>= 1;
      break label54;
      n = m;
    }
  }
  
  private void checkThreadState()
  {
    if (slastCheckTime == 0L) {
      slastCheckTime = System.currentTimeMillis();
    }
    for (;;)
    {
      return;
      slastCheckTime = System.currentTimeMillis();
      if (sThreadReportCache.size() <= 0) {
        continue;
      }
      try
      {
        Iterator localIterator = sThreadReportCache.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (URLState.ThreadReportParam)((Map.Entry)localObject).getValue();
          long l = System.currentTimeMillis() - ((URLState.ThreadReportParam)localObject).startTime;
          if (l > 500000L)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("URL", str);
            localHashMap.put("duration", String.valueOf(l));
            localHashMap.put("threadState", String.valueOf(((URLState.ThreadReportParam)localObject).mThread.getState()));
            localHashMap.put("threadStack", getAppStack(((URLState.ThreadReportParam)localObject).mThread.getStackTrace()).toString());
            localHashMap.put("postCost", String.valueOf(((URLState.ThreadReportParam)localObject).postTime));
            localHashMap.put("ThreadFlag", String.valueOf(((URLState.ThreadReportParam)localObject).type));
            if (URLDrawable.sDebugCallback != null) {
              URLDrawable.sDebugCallback.onReportThread(localHashMap);
            }
            if (QLog.isColorLevel()) {
              QLog.d("URLDrawable_Thread", 2, "checkThreadState|params= " + localHashMap);
            }
            localIterator.remove();
          }
        }
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private Object decodeFile(File paramFile, URLDrawableHandler paramURLDrawableHandler)
  {
    Object localObject2 = this.mProtocolDownloader;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = ((ProtocolDownloader)localObject2).decodeFile(paramFile, this.mParams, paramURLDrawableHandler);
      paramURLDrawableHandler = (URLDrawableHandler)localObject1;
      if (localObject1 == null) {
        break label74;
      }
      this.mOrientation = this.mParams.outOrientation;
      this.mWidth = this.mParams.outWidth;
      this.mHeight = this.mParams.outHeight;
      paramURLDrawableHandler = (URLDrawableHandler)localObject1;
    }
    label74:
    do
    {
      do
      {
        do
        {
          return paramURLDrawableHandler;
          paramURLDrawableHandler = null;
          if ((paramFile == null) || (!paramFile.exists())) {
            return null;
          }
          if ((localObject2 != null) && (((ProtocolDownloader)localObject2).gifHasDifferentState())) {}
          for (boolean bool = true; VideoDrawable.isVideo(paramFile); bool = false) {
            return new NativeVideoImage(paramFile, true, this.mParams.reqWidth, this.mParams.reqHeight, this.mParams.mExtraInfo);
          }
          if ((GifDrawable.isGifFile(paramFile)) && ((bool) || (this.mParams.useGifAnimation))) {
            return NativeGifFactory.getNativeGifObject(paramFile, bool, false, this.mParams.reqWidth, this.mParams.reqHeight, this.mParams.mGifRoundCorner);
          }
          if (this.mParams.useApngImage)
          {
            if ((this.mParams.mExtraInfo instanceof Bundle)) {
              return new ApngImage(paramFile, bool, (Bundle)this.mParams.mExtraInfo);
            }
            return new ApngImage(paramFile, bool);
          }
          if ((!this.mParams.useSharpPImage) || (!SharpPUtil.isSharpPFile(paramFile))) {
            break;
          }
          localObject1 = new File(NativeGifIndex8.getSoLibPath(URLDrawable.mApplicationContext) + "libTcHevcDec.so");
          if (QLog.isColorLevel()) {
            QLog.d("URLDrawable_", 2, "soLibFile = " + ((File)localObject1).getAbsolutePath() + " exists = " + ((File)localObject1).exists());
          }
        } while (!((File)localObject1).exists());
        return SharpPUtil.decodeSharpPByFilePath(paramFile.getAbsolutePath());
        localObject1 = paramFile.getAbsolutePath();
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        ((BitmapFactory.Options)localObject2).inPreferredConfig = URLDrawable.sDefaultDrawableParms.mConfig;
        ((BitmapFactory.Options)localObject2).inDensity = 160;
        ((BitmapFactory.Options)localObject2).inTargetDensity = 160;
        ((BitmapFactory.Options)localObject2).inScreenDensity = 160;
        SafeBitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject2).inSampleSize = calculateInSampleSize((BitmapFactory.Options)localObject2, this.mParams.reqWidth, this.mParams.reqHeight);
        paramURLDrawableHandler = SafeBitmapFactory.decodeFile((String)localObject1, (BitmapFactory.Options)localObject2);
        if (QLog.isColorLevel()) {
          QLog.d("URLDrawable_", 2, "decodeFile:sampleSize=" + ((BitmapFactory.Options)localObject2).inSampleSize + ", requestSize=" + this.mParams.reqWidth + "," + this.mParams.reqHeight + " " + this.mUrlStr);
        }
        if (paramURLDrawableHandler == null)
        {
          if (this.mDecodeFileStrategy == 3) {
            if (QLog.isColorLevel()) {
              QLog.d("URLDrawable_", 2, "decode cache file failed,ignoreDeleteFile:" + (String)localObject1 + " mUrlStr:" + this.mUrlStr);
            }
          }
          for (;;)
          {
            return null;
            if (QLog.isColorLevel()) {
              QLog.d("URLDrawable_", 2, "decode cache file failed,path:" + (String)localObject1 + " mUrlStr:" + this.mUrlStr + " mDecodeFileStrategy:" + this.mDecodeFileStrategy);
            }
            if (((String)localObject1).startsWith(TENCENT_FILE_PATH)) {
              paramFile.delete();
            }
          }
        }
        this.mOrientation = JpegExifReader.readOrientation((String)localObject1);
        paramFile = paramURLDrawableHandler;
        if (this.mParams.mDecodeHandler != null) {
          paramFile = this.mParams.mDecodeHandler.run(this.mParams, paramURLDrawableHandler);
        }
        paramURLDrawableHandler = paramFile;
      } while (Build.VERSION.SDK_INT < 11);
      paramURLDrawableHandler = paramFile;
    } while (!SliceBitmap.needSlice(paramFile));
    paramURLDrawableHandler = new SliceBitmap(paramFile);
    paramFile.recycle();
    return paramURLDrawableHandler;
  }
  
  private static StringBuilder getAppStack(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramArrayOfStackTraceElement.length)
    {
      String str = paramArrayOfStackTraceElement[i].toString();
      if (isQQStackFrame(str))
      {
        if (localStringBuilder.length() != 0) {
          break label58;
        }
        localStringBuilder.append("[");
      }
      for (;;)
      {
        localStringBuilder.append(str);
        i += 1;
        break;
        label58:
        localStringBuilder.append(",");
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("]");
    }
    return localStringBuilder;
  }
  
  static URLState getConstants(String paramString)
  {
    synchronized (URLDrawable.sMemoryCache)
    {
      WeakReference localWeakReference = (WeakReference)sUnFinishImageCache.get(paramString);
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        paramString = (URLState)localWeakReference.get();
        return paramString;
      }
      paramString = (Pair)URLDrawable.sMemoryCache.get(paramString);
      if ((paramString != null) && ((paramString.first instanceof URLState))) {
        return (URLState)paramString.first;
      }
    }
    return null;
  }
  
  static URLState getConstants(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    synchronized (URLDrawable.sMemoryCache)
    {
      paramString = getMemoryCacheKey(paramString, paramURLDrawableOptions);
      WeakReference localWeakReference = (WeakReference)sUnFinishImageCache.get(paramString);
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        if (paramURLDrawableOptions.isFlashPic != ((URLState)localWeakReference.get()).isFlashPicNeedCache) {
          return null;
        }
        paramString = (URLState)localWeakReference.get();
        return paramString;
      }
    }
    paramString = (Pair)URLDrawable.sMemoryCache.get(paramString);
    if ((paramString != null) && ((paramString.first instanceof URLState)))
    {
      if (paramURLDrawableOptions.isFlashPic != ((URLState)paramString.first).isFlashPicNeedCache) {
        return null;
      }
      return (URLState)paramString.first;
    }
    return null;
  }
  
  private static int getImageByteSize(Object paramObject)
  {
    if ((paramObject instanceof Bitmap)) {
      return Utils.getBitmapSize((Bitmap)paramObject);
    }
    if ((paramObject instanceof SliceBitmap)) {
      return ((SliceBitmap)paramObject).getByteCount();
    }
    if ((paramObject instanceof AbstractGifImage)) {
      return ((AbstractGifImage)paramObject).getByteSize();
    }
    if (NativeVideoImage.class.isInstance(paramObject)) {
      return ((NativeVideoImage)paramObject).getByteSize();
    }
    if (QQLiveImage.class.isInstance(paramObject)) {
      return ((QQLiveImage)paramObject).getByteSize();
    }
    if (RoundRectBitmap.class.isInstance(paramObject)) {
      return ((RoundRectBitmap)paramObject).getByteSize();
    }
    if ((paramObject instanceof ApngImage)) {
      return ((ApngImage)paramObject).getByteSize();
    }
    return 1048576;
  }
  
  public static String getMemoryCacheKey(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(paramString);
    if (paramString.startsWith("qqlive://msgId")) {
      return paramString;
    }
    if ((!paramString.startsWith("chatthumb")) && (paramURLDrawableOptions.mKeyAddWHSuffix) && (paramURLDrawableOptions.mRequestWidth != 0) && (paramURLDrawableOptions.mRequestHeight != 0)) {
      localStringBuilder.append('#').append(paramURLDrawableOptions.mRequestWidth).append("_").append(paramURLDrawableOptions.mRequestHeight);
    }
    if (paramURLDrawableOptions.mMemoryCacheKeySuffix != null) {
      localStringBuilder.append('#').append(paramURLDrawableOptions.mMemoryCacheKeySuffix);
    }
    return localStringBuilder.toString();
  }
  
  private static boolean isQQStackFrame(String paramString)
  {
    String[] arrayOfString = sSysTracePrefixs;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.startsWith(arrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void pauseThread()
  {
    if ((this.mIgnorePause) || (Looper.myLooper() == Looper.getMainLooper())) {
      return;
    }
    synchronized (URLDrawable.sPauseLock)
    {
      long l1 = System.currentTimeMillis();
      while (URLDrawable.sPause)
      {
        long l2 = System.currentTimeMillis();
        if (l2 - l1 > 10000L) {
          break;
        }
        try
        {
          URLDrawable.sPauseLock.wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      return;
    }
  }
  
  private void result(Object paramObject)
  {
    UI_HANDLER.post(new URLState.1(this, paramObject));
  }
  
  void addCallBack(URLState.Callback paramCallback)
  {
    if (paramCallback != null) {
      this.callbacks.add(new WeakReference(paramCallback));
    }
  }
  
  /* Error */
  void downloadImediatly(Header[] paramArrayOfHeader, CookieStore paramCookieStore, Object paramObject1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat, boolean paramBoolean5, Object paramObject2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 156	com/tencent/image/URLState:mStatus	I
    //   4: iconst_1
    //   5: if_icmpeq +10 -> 15
    //   8: aload_0
    //   9: getfield 174	com/tencent/image/URLState:mIsLoadingStarted	I
    //   12: ifle +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 174	com/tencent/image/URLState:mIsLoadingStarted	I
    //   21: iconst_1
    //   22: iadd
    //   23: putfield 174	com/tencent/image/URLState:mIsLoadingStarted	I
    //   26: aload_0
    //   27: iload 4
    //   29: putfield 732	com/tencent/image/URLState:mDecodeFile	Z
    //   32: aload_0
    //   33: getfield 163	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   36: aload_2
    //   37: putfield 736	com/tencent/image/DownloadParams:cookies	Lorg/apache/http/client/CookieStore;
    //   40: aload_0
    //   41: getfield 163	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   44: aload_1
    //   45: putfield 740	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   48: aload_0
    //   49: getfield 163	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   52: aload_3
    //   53: putfield 743	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   56: aload_0
    //   57: getfield 163	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   60: iload 5
    //   62: putfield 463	com/tencent/image/DownloadParams:useGifAnimation	Z
    //   65: aload_0
    //   66: getfield 163	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   69: iload 6
    //   71: putfield 476	com/tencent/image/DownloadParams:useApngImage	Z
    //   74: aload_0
    //   75: getfield 163	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   78: iload 7
    //   80: putfield 489	com/tencent/image/DownloadParams:useSharpPImage	Z
    //   83: aload_0
    //   84: getfield 163	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   87: fload 8
    //   89: putfield 467	com/tencent/image/DownloadParams:mGifRoundCorner	F
    //   92: aload_0
    //   93: getfield 163	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   96: iconst_0
    //   97: putfield 746	com/tencent/image/DownloadParams:needCheckNetType	Z
    //   100: aload_0
    //   101: getfield 163	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   104: iload 9
    //   106: putfield 749	com/tencent/image/DownloadParams:useExifOrientation	Z
    //   109: aload_0
    //   110: getfield 163	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   113: aload 10
    //   115: putfield 452	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   118: aload_0
    //   119: aload_0
    //   120: getfield 196	com/tencent/image/URLState:mUrl	Ljava/net/URL;
    //   123: new 751	com/tencent/image/URLDrawableHandler$Adapter
    //   126: dup
    //   127: invokespecial 752	com/tencent/image/URLDrawableHandler$Adapter:<init>	()V
    //   130: invokevirtual 756	com/tencent/image/URLState:loadImage	(Ljava/net/URL;Lcom/tencent/image/URLDrawableHandler;)Ljava/lang/Object;
    //   133: astore_1
    //   134: aload_1
    //   135: getstatic 124	com/tencent/image/URLState:DOWNLOAD_ASYNC	Ljava/lang/Object;
    //   138: if_acmpeq -123 -> 15
    //   141: invokestatic 702	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   144: invokestatic 132	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   147: if_acmpne +9 -> 156
    //   150: aload_0
    //   151: aload_1
    //   152: invokevirtual 759	com/tencent/image/URLState:onResult	(Ljava/lang/Object;)V
    //   155: return
    //   156: getstatic 137	com/tencent/image/URLState:UI_HANDLER	Landroid/os/Handler;
    //   159: new 761	com/tencent/image/URLState$PostOnResult
    //   162: dup
    //   163: aload_0
    //   164: aload_1
    //   165: invokespecial 762	com/tencent/image/URLState$PostOnResult:<init>	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   168: invokevirtual 721	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   171: pop
    //   172: return
    //   173: astore_1
    //   174: aload_1
    //   175: getstatic 124	com/tencent/image/URLState:DOWNLOAD_ASYNC	Ljava/lang/Object;
    //   178: if_acmpeq -163 -> 15
    //   181: invokestatic 702	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   184: invokestatic 132	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   187: if_acmpne +9 -> 196
    //   190: aload_0
    //   191: aload_1
    //   192: invokevirtual 759	com/tencent/image/URLState:onResult	(Ljava/lang/Object;)V
    //   195: return
    //   196: getstatic 137	com/tencent/image/URLState:UI_HANDLER	Landroid/os/Handler;
    //   199: new 761	com/tencent/image/URLState$PostOnResult
    //   202: dup
    //   203: aload_0
    //   204: aload_1
    //   205: invokespecial 762	com/tencent/image/URLState$PostOnResult:<init>	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   208: invokevirtual 721	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   211: pop
    //   212: return
    //   213: astore_1
    //   214: getstatic 124	com/tencent/image/URLState:DOWNLOAD_ASYNC	Ljava/lang/Object;
    //   217: ifnull +17 -> 234
    //   220: invokestatic 702	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   223: invokestatic 132	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   226: if_acmpne +10 -> 236
    //   229: aload_0
    //   230: aconst_null
    //   231: invokevirtual 759	com/tencent/image/URLState:onResult	(Ljava/lang/Object;)V
    //   234: aload_1
    //   235: athrow
    //   236: getstatic 137	com/tencent/image/URLState:UI_HANDLER	Landroid/os/Handler;
    //   239: new 761	com/tencent/image/URLState$PostOnResult
    //   242: dup
    //   243: aload_0
    //   244: aconst_null
    //   245: invokespecial 762	com/tencent/image/URLState$PostOnResult:<init>	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   248: invokevirtual 721	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   251: pop
    //   252: goto -18 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	URLState
    //   0	255	1	paramArrayOfHeader	Header[]
    //   0	255	2	paramCookieStore	CookieStore
    //   0	255	3	paramObject1	Object
    //   0	255	4	paramBoolean1	boolean
    //   0	255	5	paramBoolean2	boolean
    //   0	255	6	paramBoolean3	boolean
    //   0	255	7	paramBoolean4	boolean
    //   0	255	8	paramFloat	float
    //   0	255	9	paramBoolean5	boolean
    //   0	255	10	paramObject2	Object
    // Exception table:
    //   from	to	target	type
    //   118	134	173	java/lang/Throwable
    //   118	134	213	finally
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  Object loadImage(URL paramURL, URLDrawableHandler paramURLDrawableHandler)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("URLDrawable_Thread_pasueCost", 2, "DownloadAsyncTask pauseThread1 start: " + this.mUrlStr);
    }
    pauseThread();
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("URLDrawable_Thread_pasueCost", 2, "DownloadAsyncTask pauseThread1 end : " + this.mUrlStr + ",cost=" + (l2 - l1));
    }
    if (this.mParams.useApngImage)
    {
      ??? = URLDrawable.sDefaultDrawableParms.getApngSoLoader();
      if (!((ApngSoLoader)???).isLoaded())
      {
        ((ApngSoLoader)???).load(new URLState.2(this, paramURLDrawableHandler));
        paramURL = DOWNLOAD_ASYNC;
        return paramURL;
      }
    }
    if (this.mProtocolDownloader != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("URLDrawable_", 2, "call downloader loadImage." + this.mUrlStr);
      }
      if ((!this.mProtocolDownloader.hasDiskFile(this.mParams)) && (this.mParams.mHttpDownloaderParams != null))
      {
        this.mProtocolDownloader.loadImageFile(this.mParams, new URLState.3(this, paramURL, paramURLDrawableHandler));
        return DOWNLOAD_ASYNC;
      }
      if (QLog.isColorLevel()) {
        QLog.i("URLDrawable_", 2, "sync loadImage.");
      }
      paramURL = this.mProtocolDownloader.loadImageFile(this.mParams, paramURLDrawableHandler);
      this.mCacheFile = paramURL;
    }
    for (;;)
    {
      synchronized (this.mDecodeFileLock)
      {
        if (!this.mDecodeFile)
        {
          this.mStatus = 4;
          this.mIsLoadingStarted -= 1;
          paramURL = FILE_DOWNLOADED;
          return paramURL;
        }
      }
      this.mStatus = 4;
      paramURL = decodeFile(paramURL, paramURLDrawableHandler);
      if (paramURL != null)
      {
        if (!(paramURL instanceof Bitmap)) {
          break label591;
        }
        ??? = this.mUrl.getPath();
        ??? = new RegionDrawable(null, (Bitmap)paramURL, (String)???);
        ((RegionDrawable)???).setDither(this.mDither);
        this.mSuccessed = ((RegionDrawable)???).getConstantState();
      }
      for (;;)
      {
        Pair localPair = new Pair(this, Integer.valueOf(getImageByteSize(paramURL)));
        synchronized (URLDrawable.sMemoryCache)
        {
          if (this.mUseUnFinishCache) {
            sUnFinishImageCache.remove(this.mMemoryCacheKey);
          }
          if (this.mUseMemoryCache) {
            URLDrawable.sMemoryCache.put(this.mMemoryCacheKey, localPair, this.mPriority);
          }
          this.mStatus = 1;
          l1 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("URLDrawable_Thread_pasueCost", 2, "DownloadAsyncTask pauseThread2 start: " + this.mUrlStr);
          }
          pauseThread();
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("URLDrawable_Thread_pasueCost", 2, "DownloadAsyncTask pauseThread2 end: " + this.mUrlStr + ",cost=" + (l2 - l1));
          }
          paramURLDrawableHandler.publishProgress(10000);
          if (paramURL == null)
          {
            throw new NullPointerException("bitmap decode failed");
            label591:
            if ((paramURL instanceof SliceBitmap))
            {
              ??? = new SliceBitmapDrawable.BitmapState((SliceBitmap)paramURL);
              ((SliceBitmapDrawable.BitmapState)???).mPaint.setDither(this.mDither);
              this.mSuccessed = ((Drawable.ConstantState)???);
              continue;
            }
            if ((paramURL instanceof AbstractGifImage))
            {
              ??? = new GifDrawable.GifState((AbstractGifImage)paramURL);
              ((GifDrawable.GifState)???).mPaint.setDither(this.mDither);
              this.mSuccessed = ((Drawable.ConstantState)???);
              continue;
            }
            if ((paramURL instanceof ApngImage))
            {
              ??? = new ApngDrawable.ApngState((ApngImage)paramURL);
              ((ApngDrawable.ApngState)???).mPaint.setDither(this.mDither);
              this.mSuccessed = ((Drawable.ConstantState)???);
              continue;
            }
            if ((paramURL instanceof RoundRectBitmap))
            {
              ??? = new RoundRectDrawable.RoundRectDrawableState((RoundRectBitmap)paramURL);
              ((RoundRectDrawable.RoundRectDrawableState)???).mBorderPaint.setDither(this.mDither);
              ((RoundRectDrawable.RoundRectDrawableState)???).mBitmapPaint.setDither(this.mDither);
              this.mSuccessed = ((Drawable.ConstantState)???);
              continue;
            }
            if ((paramURL instanceof AbstractVideoImage))
            {
              ??? = new VideoDrawable.VideoState((AbstractVideoImage)paramURL);
              ((VideoDrawable.VideoState)???).mPaint.setDither(this.mDither);
              this.mSuccessed = ((Drawable.ConstantState)???);
              continue;
            }
            if ((paramURL instanceof QQLiveImage))
            {
              ??? = new QQLiveDrawable.QQLiveState((QQLiveImage)paramURL);
              ((QQLiveDrawable.QQLiveState)???).mPaint.setDither(this.mDither);
              this.mSuccessed = ((Drawable.ConstantState)???);
              this.mParams.mExtraInfo = null;
              continue;
            }
            throw new RuntimeException("Invalide image type " + paramURL.getClass().getSimpleName());
          }
        }
      }
      if (this.mSuccessed != null) {
        break;
      }
      throw new NullPointerException("mSuccessed is null...");
      paramURL = null;
    }
  }
  
  public Drawable newDrawable()
  {
    return new URLDrawable(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new URLDrawable(this, paramResources);
  }
  
  void onFileDownloaded()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("URLDrawable_", 4, "download successed, URLState: " + this + " , url: " + this.mUrlStr + "\nnotify " + this.callbacks.size() + " callbacks");
    }
    Vector localVector1 = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.callbacks.size()) {
          break label182;
        }
        Object localObject1 = (WeakReference)this.callbacks.get(i);
        if (localObject1 != null)
        {
          localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            ((URLState.Callback)localObject1).onFileDownloaded(this);
          }
          else
          {
            localObject1 = this.callbacks;
            j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
        }
      }
      finally {}
      Vector localVector2 = this.callbacks;
      int j = i - 1;
      localVector2.remove(i);
      i = j;
      break label185;
      label182:
      return;
      label185:
      i += 1;
    }
  }
  
  void onLoadCancelled()
  {
    if (QLog.isColorLevel()) {
      QLog.i("URLDrawable_", 2, "[onLoadCancelled]" + this.mUrlStr);
    }
    this.mStatus = 3;
    this.mIsLoadingStarted -= 1;
    int i = 0;
    if (i < this.callbacks.size()) {}
    label172:
    for (;;)
    {
      synchronized (this.callbacks)
      {
        Object localObject1 = (WeakReference)this.callbacks.get(i);
        if (localObject1 != null)
        {
          localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            ((URLState.Callback)localObject1).onLoadCanceled(this);
            i += 1;
            break;
          }
          localObject1 = this.callbacks;
          j = i - 1;
          ((Vector)localObject1).remove(i);
          i = j;
          break label172;
        }
        localObject1 = this.callbacks;
        int j = i - 1;
        ((Vector)localObject1).remove(i);
        i = j;
      }
      return;
    }
  }
  
  void onLoadFailed(Throwable paramThrowable)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("URLDrawable_", 4, wrapLog("URLState onLoadFailed():"), paramThrowable);
    }
    this.mStatus = 2;
    Vector localVector = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.callbacks.size()) {
          break label142;
        }
        localObject = (WeakReference)this.callbacks.get(i);
        if (localObject != null)
        {
          localObject = (URLState.Callback)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((URLState.Callback)localObject).onLoadFailed(this, paramThrowable);
          }
          else
          {
            localObject = this.callbacks;
            j = i - 1;
            ((Vector)localObject).remove(i);
            i = j;
          }
        }
      }
      finally {}
      Object localObject = this.callbacks;
      int j = i - 1;
      ((Vector)localObject).remove(i);
      i = j;
      break label146;
      label142:
      return;
      label146:
      i += 1;
    }
  }
  
  void onLoadStart()
  {
    Vector localVector1 = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.callbacks.size()) {
          break label115;
        }
        Object localObject1 = (WeakReference)this.callbacks.get(i);
        if (localObject1 != null)
        {
          localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            ((URLState.Callback)localObject1).onLoadStarted(this);
          }
          else
          {
            localObject1 = this.callbacks;
            j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
          }
        }
      }
      finally {}
      Vector localVector2 = this.callbacks;
      int j = i - 1;
      localVector2.remove(i);
      i = j;
      break label118;
      label115:
      return;
      label118:
      i += 1;
    }
  }
  
  void onLoadSuccessed(Object paramObject)
  {
    if (this.mIsLoadingStarted == 0) {
      return;
    }
    paramObject = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.callbacks.size())
        {
          Object localObject1 = (WeakReference)this.callbacks.get(i);
          if (localObject1 != null)
          {
            localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((URLState.Callback)localObject1).onLoadSuccessed(this);
            }
          }
        }
        else
        {
          this.callbacks.clear();
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  void onResult(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("URLDrawable_", 2, "URLState.onResult " + paramObject + " " + this.mUrlStr);
    }
    if (paramObject == FILE_DOWNLOADED)
    {
      onFileDownloaded();
      return;
    }
    if ((paramObject instanceof PendingIntent.CanceledException))
    {
      onLoadCancelled();
      return;
    }
    if ((paramObject instanceof CustomError))
    {
      this.mCustomError = ((CustomError)paramObject);
      onLoadFailed(this.mCustomError);
      return;
    }
    if ((paramObject instanceof Throwable))
    {
      onLoadFailed((Throwable)paramObject);
      return;
    }
    onLoadSuccessed(paramObject);
  }
  
  boolean reStartDownload(Header[] paramArrayOfHeader, CookieStore paramCookieStore, Object paramObject1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat, boolean paramBoolean5, Object paramObject2)
  {
    if ((this.mStatus != 2) && (this.mStatus != 3)) {
      return false;
    }
    this.mIsLoadingStarted = 0;
    this.mStatus = 0;
    startDownload(paramArrayOfHeader, paramCookieStore, paramObject1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramFloat, paramBoolean5, paramObject2);
    return true;
  }
  
  void removeCallBack(URLState.Callback paramCallback)
  {
    Vector localVector = this.callbacks;
    int i = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        if (i < this.callbacks.size())
        {
          localObject = (WeakReference)this.callbacks.get(i);
          if (localObject != null)
          {
            localObject = (URLState.Callback)((WeakReference)localObject).get();
            if ((localObject == null) || (localObject != paramCallback)) {
              break label121;
            }
            localObject = this.callbacks;
            j = i - 1;
            ((Vector)localObject).remove(i);
            i = j;
            break label129;
          }
          localObject = this.callbacks;
          int j = i - 1;
          ((Vector)localObject).remove(i);
          i = j;
        }
      }
      finally {}
      return;
      for (;;)
      {
        break label129;
        label121:
        if (localObject == null) {
          break;
        }
      }
      label129:
      i += 1;
    }
  }
  
  public String saveTo(String paramString)
  {
    if (this.mCacheFile == null) {
      throw new FileNotFoundException("File is not download complete, please check getStatus() == URLDrawable.SUCCESSED first. ");
    }
    File localFile = this.mCacheFile;
    String str = paramString;
    if (paramString.indexOf(".") == -1) {
      if (!(this.mSuccessed instanceof GifDrawable.GifState)) {
        break label87;
      }
    }
    label87:
    for (str = ".gif";; str = ".jpg")
    {
      str = paramString + str;
      Utils.copyFile(localFile, new File(str));
      if (localFile == null) {
        break;
      }
      return str;
    }
    return null;
  }
  
  void startDownload(Header[] paramArrayOfHeader, CookieStore paramCookieStore, Object paramObject1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat, boolean paramBoolean5, Object paramObject2)
  {
    if (this.mProtocolDownloader == null) {
      onLoadFailed(new NullPointerException("mProtocolDownloader is null"));
    }
    do
    {
      do
      {
        return;
        if (this.mIsLoadingStarted == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("URLDrawable_", 2, "URLState.startDownload:" + this.mUrlStr);
          }
          this.mIsLoadingStarted += 1;
          this.mDecodeFile = paramBoolean1;
          this.mParams.cookies = paramCookieStore;
          this.mParams.headers = paramArrayOfHeader;
          this.mParams.tag = paramObject1;
          this.mParams.useGifAnimation = paramBoolean2;
          this.mParams.useApngImage = paramBoolean3;
          this.mParams.useSharpPImage = paramBoolean4;
          this.mParams.mGifRoundCorner = paramFloat;
          this.mParams.useExifOrientation = paramBoolean5;
          this.mParams.mExtraInfo = paramObject2;
          paramArrayOfHeader = new URLState.PreDownloadRunnable(this, this.mUrl);
          URLDrawable.sDefaultDrawableParms.mSubHandler.post(paramArrayOfHeader);
          this.mTask = paramArrayOfHeader;
          return;
        }
        if ((this.mDecodeFile) || (!paramBoolean1)) {
          break;
        }
        synchronized (this.mDecodeFileLock)
        {
          if (this.mStatus == 0)
          {
            this.mDecodeFile = true;
            return;
          }
        }
      } while (this.mIsLoadingStarted != 0);
      startDownload(paramArrayOfHeader, paramCookieStore, paramObject1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramFloat, paramBoolean5, paramObject2);
      return;
    } while ((this.mIsLoadingStarted <= 1) || (!QLog.isColorLevel()));
    QLog.i("URLDrawable_", 2, "startDownload mIsLoadingStarted is " + this.mIsLoadingStarted);
  }
  
  String wrapLog(String paramString)
  {
    paramString = new StringBuilder(paramString);
    paramString.append('\n');
    paramString.append("  |- URLState:");
    paramString.append(this);
    paramString.append('\n');
    paramString.append("  |- url:");
    paramString.append(this.mUrlStr);
    paramString.append('\n');
    paramString.append("  |- callbacks:");
    paramString.append(this.callbacks.size());
    return paramString.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLState
 * JD-Core Version:    0.7.0.1
 */
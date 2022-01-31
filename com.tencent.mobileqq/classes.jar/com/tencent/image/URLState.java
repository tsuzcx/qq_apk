package com.tencent.image;

import android.app.PendingIntent.CanceledException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.client.CookieStore;

final class URLState
  extends Drawable.ConstantState
{
  static final String CACHE_PREFIX = "Cache_";
  static final Object DOWNLOAD_ASYNC;
  static final Object FILE_DOWNLOADED;
  public static final int FLAG_BATCH_HANDLER = 2;
  public static final int FLAG_FILE_HANDLER = 0;
  public static final int FLAG_THREAD_POOL = 1;
  public static final int INTERVAL_TIME = 300000;
  public static final int REPORT_TIME = 500000;
  public static final int THREAD_COST_TIME = 500000;
  private static final Handler UI_HANDLER;
  public static final int limitAlbumThumb = 5;
  private static String[] sSysTracePrefixs = { "android.", "com.android.", "dalvik.", "com.google.", "java." };
  static ConcurrentHashMap<String, ThreadReportParam> sThreadReportCache;
  static HashMap<String, WeakReference<URLState>> sUnFinishImageCache = new HashMap();
  public static AtomicInteger sizeAlbumThumb;
  static long slastCheckTime;
  private Vector<WeakReference<Callback>> callbacks = new Vector();
  boolean isFlashPicNeedCache = false;
  File mCacheFile;
  boolean mDecodeFile;
  private final Object mDecodeFileLock = new Object();
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
  PreDownloadRunnable mTask;
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
    DOWNLOAD_ASYNC = new Object();
    UI_HANDLER = new Handler(Looper.getMainLooper());
    sizeAlbumThumb = new AtomicInteger();
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
  
  private int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      m = 1;
    }
    int j;
    int k;
    int i;
    label39:
    do
    {
      do
      {
        return m;
        j = paramOptions.outHeight;
        k = paramOptions.outWidth;
        i = 1;
        m = i;
      } while (j <= paramInt2);
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    int m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      k >>= 1;
      j >>= 1;
      i <<= 1;
      break label39;
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
          localObject = (ThreadReportParam)((Map.Entry)localObject).getValue();
          long l = System.currentTimeMillis() - ((ThreadReportParam)localObject).startTime;
          if (l > 500000L)
          {
            HashMap localHashMap = new HashMap();
            localHashMap.put("URL", str);
            localHashMap.put("duration", String.valueOf(l));
            localHashMap.put("threadState", String.valueOf(((ThreadReportParam)localObject).mThread.getState()));
            localHashMap.put("threadStack", getAppStack(((ThreadReportParam)localObject).mThread.getStackTrace()).toString());
            localHashMap.put("postCost", String.valueOf(((ThreadReportParam)localObject).postTime));
            localHashMap.put("ThreadFlag", String.valueOf(((ThreadReportParam)localObject).type));
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
    throws Exception
  {
    Object localObject1 = null;
    Object localObject2 = this.mProtocolDownloader;
    if (localObject2 != null)
    {
      paramURLDrawableHandler = ((ProtocolDownloader)localObject2).decodeFile(paramFile, this.mParams, paramURLDrawableHandler);
      localObject1 = paramURLDrawableHandler;
      if (paramURLDrawableHandler != null)
      {
        this.mOrientation = this.mParams.outOrientation;
        this.mWidth = this.mParams.outWidth;
        this.mHeight = this.mParams.outHeight;
      }
    }
    do
    {
      return paramURLDrawableHandler;
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
      if (this.mParams.useApngImage) {
        return new ApngImage(paramFile, bool);
      }
      if ((!this.mParams.useSharpPImage) || (!SharpPUtil.isSharpPFile(paramFile))) {
        break;
      }
      localObject2 = new File(NativeGifIndex8.getSoLibPath(URLDrawable.mApplicationContext) + "libTcHevcDec.so");
      if (QLog.isColorLevel()) {
        QLog.d("URLDrawable_", 2, "soLibFile = " + ((File)localObject2).getAbsolutePath() + " exists = " + ((File)localObject2).exists());
      }
      paramURLDrawableHandler = (URLDrawableHandler)localObject1;
    } while (!((File)localObject2).exists());
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
      paramFile.delete();
      throw new IOException("decode cache file failed: " + (String)localObject1);
    }
    this.mOrientation = JpegExifReader.readOrientation((String)localObject1);
    paramFile = paramURLDrawableHandler;
    if (this.mParams.mDecodeHandler != null) {
      paramFile = this.mParams.mDecodeHandler.run(this.mParams, paramURLDrawableHandler);
    }
    if ((Build.VERSION.SDK_INT >= 11) && (SliceBitmap.needSlice(paramFile)))
    {
      paramURLDrawableHandler = new SliceBitmap(paramFile);
      paramFile.recycle();
      return paramURLDrawableHandler;
    }
    return paramFile;
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
  
  private static String getMemoryCacheKey(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramURLDrawableOptions.mMemoryCacheKeySuffix == null) {
      return paramString;
    }
    return paramString + '#' + paramURLDrawableOptions.mMemoryCacheKeySuffix;
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
  
  void addCallBack(Callback paramCallback)
  {
    if (paramCallback != null) {
      this.callbacks.add(new WeakReference(paramCallback));
    }
  }
  
  /* Error */
  void downloadImediatly(Header[] paramArrayOfHeader, CookieStore paramCookieStore, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 158	com/tencent/image/URLState:mStatus	I
    //   4: iconst_1
    //   5: if_icmpeq +10 -> 15
    //   8: aload_0
    //   9: getfield 176	com/tencent/image/URLState:mIsLoadingStarted	I
    //   12: ifle +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 176	com/tencent/image/URLState:mIsLoadingStarted	I
    //   21: iconst_1
    //   22: iadd
    //   23: putfield 176	com/tencent/image/URLState:mIsLoadingStarted	I
    //   26: aload_0
    //   27: iload 4
    //   29: putfield 707	com/tencent/image/URLState:mDecodeFile	Z
    //   32: aload_0
    //   33: getfield 165	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   36: aload_2
    //   37: putfield 711	com/tencent/image/DownloadParams:cookies	Lorg/apache/http/client/CookieStore;
    //   40: aload_0
    //   41: getfield 165	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   44: aload_1
    //   45: putfield 715	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   48: aload_0
    //   49: getfield 165	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   52: aload_3
    //   53: putfield 718	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   56: aload_0
    //   57: getfield 165	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   60: iload 5
    //   62: putfield 468	com/tencent/image/DownloadParams:useGifAnimation	Z
    //   65: aload_0
    //   66: getfield 165	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   69: iload 6
    //   71: putfield 481	com/tencent/image/DownloadParams:useApngImage	Z
    //   74: aload_0
    //   75: getfield 165	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   78: iload 7
    //   80: putfield 489	com/tencent/image/DownloadParams:useSharpPImage	Z
    //   83: aload_0
    //   84: getfield 165	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   87: fload 8
    //   89: putfield 472	com/tencent/image/DownloadParams:mGifRoundCorner	F
    //   92: aload_0
    //   93: getfield 165	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   96: iconst_0
    //   97: putfield 721	com/tencent/image/DownloadParams:needCheckNetType	Z
    //   100: aload_0
    //   101: aload_0
    //   102: getfield 196	com/tencent/image/URLState:mUrl	Ljava/net/URL;
    //   105: new 723	com/tencent/image/URLDrawableHandler$Adapter
    //   108: dup
    //   109: invokespecial 724	com/tencent/image/URLDrawableHandler$Adapter:<init>	()V
    //   112: invokevirtual 728	com/tencent/image/URLState:loadImage	(Ljava/net/URL;Lcom/tencent/image/URLDrawableHandler;)Ljava/lang/Object;
    //   115: astore_1
    //   116: aload_1
    //   117: getstatic 121	com/tencent/image/URLState:DOWNLOAD_ASYNC	Ljava/lang/Object;
    //   120: if_acmpeq -105 -> 15
    //   123: invokestatic 685	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   126: invokestatic 129	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   129: if_acmpne +95 -> 224
    //   132: aload_1
    //   133: astore_2
    //   134: aload_0
    //   135: aload_2
    //   136: invokevirtual 731	com/tencent/image/URLState:onResult	(Ljava/lang/Object;)V
    //   139: return
    //   140: astore_1
    //   141: aload_1
    //   142: getstatic 121	com/tencent/image/URLState:DOWNLOAD_ASYNC	Ljava/lang/Object;
    //   145: if_acmpeq -130 -> 15
    //   148: aload_1
    //   149: astore_2
    //   150: invokestatic 685	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   153: invokestatic 129	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   156: if_acmpeq -22 -> 134
    //   159: getstatic 134	com/tencent/image/URLState:UI_HANDLER	Landroid/os/Handler;
    //   162: astore_3
    //   163: new 20	com/tencent/image/URLState$PostOnResult
    //   166: dup
    //   167: aload_0
    //   168: aload_1
    //   169: invokespecial 734	com/tencent/image/URLState$PostOnResult:<init>	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   172: astore_2
    //   173: aload_3
    //   174: astore_1
    //   175: aload_1
    //   176: aload_2
    //   177: invokevirtual 738	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   180: pop
    //   181: return
    //   182: astore_1
    //   183: getstatic 121	com/tencent/image/URLState:DOWNLOAD_ASYNC	Ljava/lang/Object;
    //   186: ifnull +17 -> 203
    //   189: invokestatic 685	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   192: invokestatic 129	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   195: if_acmpne +10 -> 205
    //   198: aload_0
    //   199: aconst_null
    //   200: invokevirtual 731	com/tencent/image/URLState:onResult	(Ljava/lang/Object;)V
    //   203: aload_1
    //   204: athrow
    //   205: getstatic 134	com/tencent/image/URLState:UI_HANDLER	Landroid/os/Handler;
    //   208: new 20	com/tencent/image/URLState$PostOnResult
    //   211: dup
    //   212: aload_0
    //   213: aconst_null
    //   214: invokespecial 734	com/tencent/image/URLState$PostOnResult:<init>	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   217: invokevirtual 738	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   220: pop
    //   221: goto -18 -> 203
    //   224: getstatic 134	com/tencent/image/URLState:UI_HANDLER	Landroid/os/Handler;
    //   227: astore_2
    //   228: new 20	com/tencent/image/URLState$PostOnResult
    //   231: dup
    //   232: aload_0
    //   233: aload_1
    //   234: invokespecial 734	com/tencent/image/URLState$PostOnResult:<init>	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   237: astore_3
    //   238: aload_2
    //   239: astore_1
    //   240: aload_3
    //   241: astore_2
    //   242: goto -67 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	URLState
    //   0	245	1	paramArrayOfHeader	Header[]
    //   0	245	2	paramCookieStore	CookieStore
    //   0	245	3	paramObject	Object
    //   0	245	4	paramBoolean1	boolean
    //   0	245	5	paramBoolean2	boolean
    //   0	245	6	paramBoolean3	boolean
    //   0	245	7	paramBoolean4	boolean
    //   0	245	8	paramFloat	float
    // Exception table:
    //   from	to	target	type
    //   100	116	140	java/lang/Throwable
    //   100	116	182	finally
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  Object loadImage(URL arg1, final URLDrawableHandler paramURLDrawableHandler)
    throws Throwable
  {
    ??? = null;
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("URLDrawable_Thread_pasueCost", 2, "DownloadAsyncTask pauseThread1 start: " + this.mUrlStr);
    }
    pauseThread();
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("URLDrawable_Thread_pasueCost", 2, "DownloadAsyncTask pauseThread1 end : " + this.mUrlStr + ",cost=" + (l2 - l1));
    }
    if (this.mProtocolDownloader != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("URLDrawable_", 2, "call downloader loadImage." + this.mUrlStr);
      }
      if ((!this.mProtocolDownloader.hasDiskFile(this.mParams)) && (this.mParams.mHttpDownloaderParams != null))
      {
        this.mProtocolDownloader.loadImageFile(this.mParams, new URLDrawableHandler.Adapter()
        {
          public void onFileDownloadFailed(int paramAnonymousInt)
          {
            super.onFileDownloadFailed(paramAnonymousInt);
            paramURLDrawableHandler.onFileDownloadFailed(paramAnonymousInt);
            if (URLState.this.mTask != null) {
              URLState.DownloadRunnable.access$400(URLState.this.mTask.mDownloadRunnable, new HttpException(" http error code " + paramAnonymousInt));
            }
          }
          
          public void onFileDownloadSucceed(long paramAnonymousLong)
          {
            super.onFileDownloadSucceed(paramAnonymousLong);
            if (QLog.isColorLevel()) {
              QLog.i("URLDrawable_", 2, "async onFileDownloadSucceed.");
            }
            try
            {
              if (URLState.this.mProtocolDownloader.hasDiskFile(URLState.this.mParams))
              {
                if (URLState.this.mTask != null)
                {
                  URLState.this.mTask.run();
                  return;
                }
                final Object localObject = URLState.this.loadImage(paramURL, paramURLDrawableHandler);
                paramURLDrawableHandler.onFileDownloadSucceed(paramAnonymousLong);
                URLState.UI_HANDLER.post(new Runnable()
                {
                  public void run()
                  {
                    URLState.this.onResult(localObject);
                  }
                });
                return;
              }
            }
            catch (Throwable localThrowable)
            {
              localThrowable.printStackTrace();
            }
          }
        });
        ??? = DOWNLOAD_ASYNC;
      }
    }
    label544:
    do
    {
      return ???;
      if (QLog.isColorLevel()) {
        QLog.i("URLDrawable_", 2, "sync loadImage.");
      }
      ??? = this.mProtocolDownloader.loadImageFile(this.mParams, paramURLDrawableHandler);
      this.mCacheFile = ((File)???);
      synchronized (this.mDecodeFileLock)
      {
        if (!this.mDecodeFile)
        {
          this.mStatus = 4;
          this.mIsLoadingStarted -= 1;
          paramURLDrawableHandler = FILE_DOWNLOADED;
          return paramURLDrawableHandler;
        }
      }
      this.mStatus = 4;
      ??? = decodeFile((File)???, paramURLDrawableHandler);
      if (??? != null)
      {
        if (!(??? instanceof Bitmap)) {
          break label544;
        }
        ??? = this.mUrl.getPath();
        ??? = new RegionDrawable(null, (Bitmap)???, (String)???);
        ((RegionDrawable)???).setDither(this.mDither);
        this.mSuccessed = ((RegionDrawable)???).getConstantState();
      }
      for (;;)
      {
        Pair localPair = new Pair(this, Integer.valueOf(getImageByteSize(???)));
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
          if (??? == null)
          {
            throw new NullPointerException("bitmap decode failed");
            if ((??? instanceof SliceBitmap))
            {
              ??? = new SliceBitmapDrawable.BitmapState((SliceBitmap)???);
              ((SliceBitmapDrawable.BitmapState)???).mPaint.setDither(this.mDither);
              this.mSuccessed = ((Drawable.ConstantState)???);
              continue;
            }
            if ((??? instanceof AbstractGifImage))
            {
              ??? = new GifDrawable.GifState((AbstractGifImage)???);
              ((GifDrawable.GifState)???).mPaint.setDither(this.mDither);
              this.mSuccessed = ((Drawable.ConstantState)???);
              continue;
            }
            if ((??? instanceof ApngImage))
            {
              ??? = new ApngDrawable.ApngState((ApngImage)???);
              ((ApngDrawable.ApngState)???).mPaint.setDither(this.mDither);
              this.mSuccessed = ((Drawable.ConstantState)???);
              continue;
            }
            if ((??? instanceof RoundRectBitmap))
            {
              ??? = new RoundRectDrawable.RoundRectDrawableState((RoundRectBitmap)???);
              ((RoundRectDrawable.RoundRectDrawableState)???).mBorderPaint.setDither(this.mDither);
              ((RoundRectDrawable.RoundRectDrawableState)???).mBitmapPaint.setDither(this.mDither);
              this.mSuccessed = ((Drawable.ConstantState)???);
              continue;
            }
            if ((??? instanceof AbstractVideoImage))
            {
              ??? = new VideoDrawable.VideoState((AbstractVideoImage)???);
              ((VideoDrawable.VideoState)???).mPaint.setDither(this.mDither);
              this.mSuccessed = ((Drawable.ConstantState)???);
              continue;
            }
            if ((??? instanceof QQLiveImage))
            {
              ??? = new QQLiveDrawable.QQLiveState((QQLiveImage)???);
              ((QQLiveDrawable.QQLiveState)???).mPaint.setDither(this.mDither);
              this.mSuccessed = ((Drawable.ConstantState)???);
              continue;
            }
            throw new RuntimeException("Invalide image type " + ???.getClass().getSimpleName());
          }
        }
      }
    } while (this.mSuccessed != null);
    throw new NullPointerException("mSuccessed is null...");
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
    Vector localVector = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.callbacks.size())
        {
          localObject1 = (WeakReference)this.callbacks.get(i);
          if (localObject1 != null)
          {
            localObject1 = (Callback)((WeakReference)localObject1).get();
            if (localObject1 != null)
            {
              ((Callback)localObject1).onFileDownloaded(this);
              continue;
            }
            localObject1 = this.callbacks;
            j = i - 1;
          }
        }
      }
      finally
      {
        Object localObject1;
        int j;
        continue;
        i += 1;
      }
      try
      {
        ((Vector)localObject1).remove(i);
        i = j;
      }
      finally
      {
        continue;
      }
      throw ((Throwable)localObject1);
      localObject1 = this.callbacks;
      j = i - 1;
      ((Vector)localObject1).remove(i);
      i = j;
      continue;
      return;
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
    for (;;)
    {
      if (i < this.callbacks.size()) {}
      synchronized (this.callbacks)
      {
        Object localObject1 = (WeakReference)this.callbacks.get(i);
        int k;
        int j;
        if (localObject1 != null)
        {
          localObject1 = (Callback)((WeakReference)localObject1).get();
          if (localObject1 != null)
          {
            ((Callback)localObject1).onLoadCanceled(this);
            i += 1;
            continue;
          }
          localObject1 = this.callbacks;
          k = i - 1;
          j = k;
        }
        for (;;)
        {
          try
          {
            ((Vector)localObject1).remove(i);
            i = k;
            break;
          }
          finally {}
          localObject1 = this.callbacks;
          k = i - 1;
          j = k;
          ((Vector)localObject1).remove(i);
          i = k;
        }
        throw localObject2;
        return;
      }
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
        if (i < this.callbacks.size())
        {
          localObject = (WeakReference)this.callbacks.get(i);
          if (localObject != null)
          {
            localObject = (Callback)((WeakReference)localObject).get();
            if (localObject != null)
            {
              ((Callback)localObject).onLoadFailed(this, paramThrowable);
              continue;
            }
            localObject = this.callbacks;
            j = i - 1;
          }
        }
      }
      finally
      {
        Object localObject;
        int j;
        continue;
        i += 1;
      }
      try
      {
        ((Vector)localObject).remove(i);
        i = j;
      }
      finally
      {
        continue;
      }
      throw paramThrowable;
      localObject = this.callbacks;
      j = i - 1;
      ((Vector)localObject).remove(i);
      i = j;
      continue;
      return;
    }
  }
  
  /* Error */
  void onLoadStart()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 172	com/tencent/image/URLState:callbacks	Ljava/util/Vector;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: iconst_0
    //   10: istore_1
    //   11: iload_1
    //   12: aload_0
    //   13: getfield 172	com/tencent/image/URLState:callbacks	Ljava/util/Vector;
    //   16: invokevirtual 900	java/util/Vector:size	()I
    //   19: if_icmpge +86 -> 105
    //   22: aload_0
    //   23: getfield 172	com/tencent/image/URLState:callbacks	Ljava/util/Vector;
    //   26: iload_1
    //   27: invokevirtual 905	java/util/Vector:get	(I)Ljava/lang/Object;
    //   30: checkcast 272	java/lang/ref/WeakReference
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull +50 -> 85
    //   38: aload_3
    //   39: invokevirtual 630	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   42: checkcast 10	com/tencent/image/URLState$Callback
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +13 -> 60
    //   50: aload_3
    //   51: aload_0
    //   52: invokeinterface 933 2 0
    //   57: goto +56 -> 113
    //   60: aload_0
    //   61: getfield 172	com/tencent/image/URLState:callbacks	Ljava/util/Vector;
    //   64: astore_3
    //   65: iload_1
    //   66: iconst_1
    //   67: isub
    //   68: istore_2
    //   69: aload_3
    //   70: iload_1
    //   71: invokevirtual 909	java/util/Vector:remove	(I)Ljava/lang/Object;
    //   74: pop
    //   75: iload_2
    //   76: istore_1
    //   77: goto +36 -> 113
    //   80: aload 4
    //   82: monitorexit
    //   83: aload_3
    //   84: athrow
    //   85: aload_0
    //   86: getfield 172	com/tencent/image/URLState:callbacks	Ljava/util/Vector;
    //   89: astore_3
    //   90: iload_1
    //   91: iconst_1
    //   92: isub
    //   93: istore_2
    //   94: aload_3
    //   95: iload_1
    //   96: invokevirtual 909	java/util/Vector:remove	(I)Ljava/lang/Object;
    //   99: pop
    //   100: iload_2
    //   101: istore_1
    //   102: goto +11 -> 113
    //   105: aload 4
    //   107: monitorexit
    //   108: return
    //   109: astore_3
    //   110: goto -30 -> 80
    //   113: iload_1
    //   114: iconst_1
    //   115: iadd
    //   116: istore_1
    //   117: goto -106 -> 11
    //   120: astore_3
    //   121: goto -41 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	URLState
    //   10	107	1	i	int
    //   68	33	2	j	int
    //   33	62	3	localObject1	Object
    //   109	1	3	localObject2	Object
    //   120	1	3	localObject3	Object
    //   4	102	4	localVector	Vector
    // Exception table:
    //   from	to	target	type
    //   11	34	109	finally
    //   38	46	109	finally
    //   50	57	109	finally
    //   60	65	109	finally
    //   85	90	109	finally
    //   105	108	109	finally
    //   69	75	120	finally
    //   80	83	120	finally
    //   94	100	120	finally
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
            localObject1 = (Callback)((WeakReference)localObject1).get();
            if (localObject1 != null) {
              ((Callback)localObject1).onLoadSuccessed(this);
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
  
  void removeCallBack(Callback paramCallback)
  {
    Vector localVector = this.callbacks;
    int i = 0;
    try
    {
      if (i >= this.callbacks.size()) {
        break label117;
      }
      localObject = (WeakReference)this.callbacks.get(i);
      if (localObject == null) {
        break label90;
      }
      localObject = (Callback)((WeakReference)localObject).get();
      if (localObject == null) {
        break label128;
      }
      if (localObject == paramCallback) {}
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        int j;
        continue;
        do
        {
          break;
        } while (localObject != null);
      }
    }
    localObject = this.callbacks;
    j = i - 1;
    for (;;)
    {
      try
      {
        ((Vector)localObject).remove(i);
        i = j;
        i += 1;
      }
      finally
      {
        label90:
        continue;
      }
      localObject = this.callbacks;
      j = i - 1;
      ((Vector)localObject).remove(i);
      i = j;
    }
    throw paramCallback;
    label117:
  }
  
  public String saveTo(String paramString)
    throws IOException
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
          paramArrayOfHeader = new PreDownloadRunnable(this.mUrl);
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
  
  public static abstract interface Callback
  {
    public abstract void onFileDownloadFailed(int paramInt);
    
    public abstract void onFileDownloadStarted();
    
    public abstract void onFileDownloadSucceed(long paramLong);
    
    public abstract void onFileDownloaded(URLState paramURLState);
    
    public abstract void onLoadCanceled(URLState paramURLState);
    
    public abstract void onLoadFailed(URLState paramURLState, Throwable paramThrowable);
    
    public abstract void onLoadStarted(URLState paramURLState);
    
    public abstract void onLoadSuccessed(URLState paramURLState);
    
    public abstract void onUpdateProgress(int paramInt);
  }
  
  class DownloadRunnable
    implements Runnable, URLDrawableHandler
  {
    public int flag;
    private final AtomicBoolean mCancelled = new AtomicBoolean();
    URL mUrl;
    public long postTime;
    
    DownloadRunnable(URL paramURL)
    {
      this.mUrl = paramURL;
    }
    
    private void result(final Object paramObject)
    {
      URLState.UI_HANDLER.post(new Runnable()
      {
        public void run()
        {
          URLState.this.onResult(paramObject);
        }
      });
    }
    
    public void cancel()
    {
      this.mCancelled.set(true);
    }
    
    public void doCancel()
    {
      throw new CancellationException();
    }
    
    public boolean isCancelled()
    {
      return this.mCancelled.get();
    }
    
    /* Error */
    public void onFileDownloadFailed(int paramInt)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   4: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   7: astore 5
      //   9: aload 5
      //   11: monitorenter
      //   12: iconst_0
      //   13: istore_2
      //   14: iload_2
      //   15: aload_0
      //   16: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   19: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   22: invokevirtual 84	java/util/Vector:size	()I
      //   25: if_icmpge +106 -> 131
      //   28: aload_0
      //   29: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   32: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   35: iload_2
      //   36: invokevirtual 87	java/util/Vector:get	(I)Ljava/lang/Object;
      //   39: checkcast 89	java/lang/ref/WeakReference
      //   42: astore 4
      //   44: aload 4
      //   46: ifnull +60 -> 106
      //   49: aload 4
      //   51: invokevirtual 92	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   54: checkcast 94	com/tencent/image/URLState$Callback
      //   57: astore 4
      //   59: aload 4
      //   61: ifnull +14 -> 75
      //   64: aload 4
      //   66: iload_1
      //   67: invokeinterface 96 2 0
      //   72: goto +68 -> 140
      //   75: aload_0
      //   76: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   79: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   82: astore 4
      //   84: iload_2
      //   85: iconst_1
      //   86: isub
      //   87: istore_3
      //   88: aload 4
      //   90: iload_2
      //   91: invokevirtual 99	java/util/Vector:remove	(I)Ljava/lang/Object;
      //   94: pop
      //   95: iload_3
      //   96: istore_2
      //   97: goto +43 -> 140
      //   100: aload 5
      //   102: monitorexit
      //   103: aload 4
      //   105: athrow
      //   106: aload_0
      //   107: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   110: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   113: astore 4
      //   115: iload_2
      //   116: iconst_1
      //   117: isub
      //   118: istore_3
      //   119: aload 4
      //   121: iload_2
      //   122: invokevirtual 99	java/util/Vector:remove	(I)Ljava/lang/Object;
      //   125: pop
      //   126: iload_3
      //   127: istore_2
      //   128: goto +12 -> 140
      //   131: aload 5
      //   133: monitorexit
      //   134: return
      //   135: astore 4
      //   137: goto -37 -> 100
      //   140: iload_2
      //   141: iconst_1
      //   142: iadd
      //   143: istore_2
      //   144: goto -130 -> 14
      //   147: astore 4
      //   149: goto -49 -> 100
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	152	0	this	DownloadRunnable
      //   0	152	1	paramInt	int
      //   13	131	2	i	int
      //   87	40	3	j	int
      //   42	78	4	localObject1	Object
      //   135	1	4	localObject2	Object
      //   147	1	4	localObject3	Object
      //   7	125	5	localVector	Vector
      // Exception table:
      //   from	to	target	type
      //   14	44	135	finally
      //   49	59	135	finally
      //   64	72	135	finally
      //   75	84	135	finally
      //   106	115	135	finally
      //   131	134	135	finally
      //   88	95	147	finally
      //   100	103	147	finally
      //   119	126	147	finally
    }
    
    /* Error */
    public void onFileDownloadStarted()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   4: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   7: astore 4
      //   9: aload 4
      //   11: monitorenter
      //   12: iconst_0
      //   13: istore_1
      //   14: iload_1
      //   15: aload_0
      //   16: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   19: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   22: invokevirtual 84	java/util/Vector:size	()I
      //   25: if_icmpge +94 -> 119
      //   28: aload_0
      //   29: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   32: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   35: iload_1
      //   36: invokevirtual 87	java/util/Vector:get	(I)Ljava/lang/Object;
      //   39: checkcast 89	java/lang/ref/WeakReference
      //   42: astore_3
      //   43: aload_3
      //   44: ifnull +52 -> 96
      //   47: aload_3
      //   48: invokevirtual 92	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   51: checkcast 94	com/tencent/image/URLState$Callback
      //   54: astore_3
      //   55: aload_3
      //   56: ifnull +12 -> 68
      //   59: aload_3
      //   60: invokeinterface 102 1 0
      //   65: goto +62 -> 127
      //   68: aload_0
      //   69: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   72: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   75: astore_3
      //   76: iload_1
      //   77: iconst_1
      //   78: isub
      //   79: istore_2
      //   80: aload_3
      //   81: iload_1
      //   82: invokevirtual 99	java/util/Vector:remove	(I)Ljava/lang/Object;
      //   85: pop
      //   86: iload_2
      //   87: istore_1
      //   88: goto +39 -> 127
      //   91: aload 4
      //   93: monitorexit
      //   94: aload_3
      //   95: athrow
      //   96: aload_0
      //   97: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   100: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   103: astore_3
      //   104: iload_1
      //   105: iconst_1
      //   106: isub
      //   107: istore_2
      //   108: aload_3
      //   109: iload_1
      //   110: invokevirtual 99	java/util/Vector:remove	(I)Ljava/lang/Object;
      //   113: pop
      //   114: iload_2
      //   115: istore_1
      //   116: goto +11 -> 127
      //   119: aload 4
      //   121: monitorexit
      //   122: return
      //   123: astore_3
      //   124: goto -33 -> 91
      //   127: iload_1
      //   128: iconst_1
      //   129: iadd
      //   130: istore_1
      //   131: goto -117 -> 14
      //   134: astore_3
      //   135: goto -44 -> 91
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	138	0	this	DownloadRunnable
      //   13	118	1	i	int
      //   79	36	2	j	int
      //   42	67	3	localObject1	Object
      //   123	1	3	localObject2	Object
      //   134	1	3	localObject3	Object
      //   7	113	4	localVector	Vector
      // Exception table:
      //   from	to	target	type
      //   14	43	123	finally
      //   47	55	123	finally
      //   59	65	123	finally
      //   68	76	123	finally
      //   96	104	123	finally
      //   119	122	123	finally
      //   80	86	134	finally
      //   91	94	134	finally
      //   108	114	134	finally
    }
    
    /* Error */
    public void onFileDownloadSucceed(long paramLong)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   4: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   7: astore 6
      //   9: aload 6
      //   11: monitorenter
      //   12: iconst_0
      //   13: istore_3
      //   14: iload_3
      //   15: aload_0
      //   16: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   19: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   22: invokevirtual 84	java/util/Vector:size	()I
      //   25: if_icmpge +110 -> 135
      //   28: aload_0
      //   29: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   32: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   35: iload_3
      //   36: invokevirtual 87	java/util/Vector:get	(I)Ljava/lang/Object;
      //   39: checkcast 89	java/lang/ref/WeakReference
      //   42: astore 5
      //   44: aload 5
      //   46: ifnull +62 -> 108
      //   49: aload 5
      //   51: invokevirtual 92	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   54: checkcast 94	com/tencent/image/URLState$Callback
      //   57: astore 5
      //   59: aload 5
      //   61: ifnull +14 -> 75
      //   64: aload 5
      //   66: lload_1
      //   67: invokeinterface 106 3 0
      //   72: goto +72 -> 144
      //   75: aload_0
      //   76: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   79: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   82: astore 5
      //   84: iload_3
      //   85: iconst_1
      //   86: isub
      //   87: istore 4
      //   89: aload 5
      //   91: iload_3
      //   92: invokevirtual 99	java/util/Vector:remove	(I)Ljava/lang/Object;
      //   95: pop
      //   96: iload 4
      //   98: istore_3
      //   99: goto +45 -> 144
      //   102: aload 6
      //   104: monitorexit
      //   105: aload 5
      //   107: athrow
      //   108: aload_0
      //   109: getfield 29	com/tencent/image/URLState$DownloadRunnable:this$0	Lcom/tencent/image/URLState;
      //   112: invokestatic 78	com/tencent/image/URLState:access$300	(Lcom/tencent/image/URLState;)Ljava/util/Vector;
      //   115: astore 5
      //   117: iload_3
      //   118: iconst_1
      //   119: isub
      //   120: istore 4
      //   122: aload 5
      //   124: iload_3
      //   125: invokevirtual 99	java/util/Vector:remove	(I)Ljava/lang/Object;
      //   128: pop
      //   129: iload 4
      //   131: istore_3
      //   132: goto +12 -> 144
      //   135: aload 6
      //   137: monitorexit
      //   138: return
      //   139: astore 5
      //   141: goto -39 -> 102
      //   144: iload_3
      //   145: iconst_1
      //   146: iadd
      //   147: istore_3
      //   148: goto -134 -> 14
      //   151: astore 5
      //   153: goto -51 -> 102
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	156	0	this	DownloadRunnable
      //   0	156	1	paramLong	long
      //   13	135	3	i	int
      //   87	43	4	j	int
      //   42	81	5	localObject1	Object
      //   139	1	5	localObject2	Object
      //   151	1	5	localObject3	Object
      //   7	129	6	localVector	Vector
      // Exception table:
      //   from	to	target	type
      //   14	44	139	finally
      //   49	59	139	finally
      //   64	72	139	finally
      //   75	84	139	finally
      //   108	117	139	finally
      //   135	138	139	finally
      //   89	96	151	finally
      //   102	105	151	finally
      //   122	129	151	finally
    }
    
    protected void onProgressUpdate(int paramInt)
    {
      URLState.this.mProgress = paramInt;
      Vector localVector;
      int i;
      if ((!URLDrawable.sPause) || (URLState.this.mIgnorePause))
      {
        localVector = URLState.this.callbacks;
        i = 0;
      }
      for (;;)
      {
        try
        {
          if (i < URLState.this.callbacks.size())
          {
            localObject1 = (WeakReference)URLState.this.callbacks.get(i);
            if (localObject1 != null)
            {
              localObject1 = (URLState.Callback)((WeakReference)localObject1).get();
              if (localObject1 != null)
              {
                ((URLState.Callback)localObject1).onUpdateProgress(paramInt);
                continue;
              }
              localObject1 = URLState.this.callbacks;
              j = i - 1;
            }
          }
        }
        finally
        {
          Object localObject1;
          int j;
          continue;
          i += 1;
        }
        try
        {
          ((Vector)localObject1).remove(i);
          i = j;
        }
        finally
        {
          continue;
        }
        throw ((Throwable)localObject1);
        localObject1 = URLState.this.callbacks;
        j = i - 1;
        ((Vector)localObject1).remove(i);
        i = j;
        continue;
        return;
      }
    }
    
    public void publishProgress(final int paramInt)
    {
      if (paramInt == URLState.this.mProgress) {
        return;
      }
      URLState.UI_HANDLER.post(new Runnable()
      {
        public void run()
        {
          URLState.DownloadRunnable.this.onProgressUpdate(paramInt);
        }
      });
    }
    
    public void run()
    {
      l1 = System.currentTimeMillis();
      Object localObject1 = new URLState.ThreadReportParam();
      ((URLState.ThreadReportParam)localObject1).startTime = l1;
      ((URLState.ThreadReportParam)localObject1).postTime = (l1 - this.postTime);
      ((URLState.ThreadReportParam)localObject1).type = this.flag;
      ((URLState.ThreadReportParam)localObject1).mThread = Thread.currentThread();
      URLState.sThreadReportCache.put(URLState.this.mUrlStr, localObject1);
      try
      {
        if (QLog.isColorLevel())
        {
          long l2 = this.postTime;
          QLog.d("URLDrawable_Thread", 2, "DownloadAsyncTask.doInBackground start: postCost=" + (l1 - l2) + " ,url=" + URLState.this.mUrlStr + " ,isCancelled:" + isCancelled() + " ,flag=" + this.flag);
        }
        if (isCancelled()) {
          URLState.this.onLoadCancelled();
        }
        localObject1 = URLState.this.loadImage(this.mUrl, this);
        if (localObject1 != URLState.DOWNLOAD_ASYNC) {
          result(localObject1);
        }
        if (this.mUrl.getProtocol().equals("albumthumb")) {
          URLState.sizeAlbumThumb.decrementAndGet();
        }
        l1 = System.currentTimeMillis() - l1;
        if ((l1 > 500000L) && (QLog.isColorLevel())) {
          QLog.e("URLDrawable_Thread", 2, "DownloadAsyncTask cost :" + l1 + ",url" + URLState.this.mUrlStr + ",flag=" + this.flag);
        }
        URLState.sThreadReportCache.remove(URLState.this.mUrlStr);
        if (!QLog.isColorLevel()) {
          break label353;
        }
        localObject1 = "DownloadAsyncTask.doInBackground end :" + l1 + ",url" + URLState.this.mUrlStr + ",flag=" + this.flag;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          label353:
          result(localThrowable);
          if (this.mUrl.getProtocol().equals("albumthumb")) {
            URLState.sizeAlbumThumb.decrementAndGet();
          }
          l1 = System.currentTimeMillis() - l1;
          if ((l1 > 500000L) && (QLog.isColorLevel())) {
            QLog.e("URLDrawable_Thread", 2, "DownloadAsyncTask cost :" + l1 + ",url" + URLState.this.mUrlStr + ",flag=" + this.flag);
          }
          URLState.sThreadReportCache.remove(URLState.this.mUrlStr);
          if (QLog.isColorLevel()) {
            String str = "DownloadAsyncTask.doInBackground end :" + l1 + ",url" + URLState.this.mUrlStr + ",flag=" + this.flag;
          }
        }
      }
      finally
      {
        if (!this.mUrl.getProtocol().equals("albumthumb")) {
          break label552;
        }
        URLState.sizeAlbumThumb.decrementAndGet();
        l1 = System.currentTimeMillis() - l1;
        if ((l1 <= 500000L) || (!QLog.isColorLevel())) {
          break label624;
        }
        QLog.e("URLDrawable_Thread", 2, "DownloadAsyncTask cost :" + l1 + ",url" + URLState.this.mUrlStr + ",flag=" + this.flag);
        URLState.sThreadReportCache.remove(URLState.this.mUrlStr);
        if (!QLog.isColorLevel()) {
          break label697;
        }
        QLog.d("URLDrawable_Thread", 2, "DownloadAsyncTask.doInBackground end :" + l1 + ",url" + URLState.this.mUrlStr + ",flag=" + this.flag);
      }
      QLog.d("URLDrawable_Thread", 2, (String)localObject1);
    }
  }
  
  public class PostOnResult
    implements Runnable
  {
    Object result;
    
    public PostOnResult(Object paramObject)
    {
      this.result = paramObject;
    }
    
    public void run()
    {
      URLState.this.onResult(this.result);
    }
  }
  
  class PreDownloadRunnable
    implements Runnable
  {
    private static final int DOWNLOAD_THREAD_POOL = 1;
    private static final int LOCAL_THREAD_POOL = 0;
    boolean hasFile = false;
    URLState.DownloadRunnable mDownloadRunnable;
    private URL url;
    
    PreDownloadRunnable(URL paramURL)
    {
      this.url = paramURL;
      this.mDownloadRunnable = new URLState.DownloadRunnable(URLState.this, paramURL);
    }
    
    public void run()
    {
      if ((Build.VERSION.SDK_INT >= 11) && (URLState.this.mProtocolDownloader != null) && (URLState.this.mProtocolDownloader.hasDiskFile(URLState.this.mParams))) {
        this.hasFile = true;
      }
      URLState.UI_HANDLER.post(new Runnable()
      {
        public void run()
        {
          if (QLog.isColorLevel()) {
            QLog.i("URLDrawable_", 2, "PreDwonloadAsyncTask doInBackground." + URLState.PreDownloadRunnable.this.url);
          }
          if (URLState.PreDownloadRunnable.this.mDownloadRunnable.isCancelled()) {
            return;
          }
          long l = System.currentTimeMillis();
          URLState.PreDownloadRunnable.this.mDownloadRunnable.postTime = l;
          if (l - URLState.slastCheckTime > 300000L) {
            URLState.this.checkThreadState();
          }
          if (URLState.PreDownloadRunnable.this.hasFile)
          {
            URLState.PreDownloadRunnable.this.mDownloadRunnable.flag = 0;
            if (URLState.PreDownloadRunnable.this.url.getProtocol().equals("albumthumb")) {
              if (URLState.sizeAlbumThumb.incrementAndGet() > 5) {
                URLDrawable.sDefaultDrawableParms.mFileHandler.postAtFrontOfQueue(URLState.PreDownloadRunnable.this.mDownloadRunnable);
              }
            }
          }
          for (;;)
          {
            URLState.this.onLoadStart();
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("URLDrawable_", 2, "PreDwonloadAsyncTask onLoadStart." + URLState.PreDownloadRunnable.this.url);
            return;
            URLDrawable.sDefaultDrawableParms.mFileHandler.post(URLState.PreDownloadRunnable.this.mDownloadRunnable);
            continue;
            URLDrawable.sDefaultDrawableParms.mFileHandler.post(URLState.PreDownloadRunnable.this.mDownloadRunnable);
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("URLDrawable_", 2, "schedule load image " + URLState.this.mUrlStr + ",useThreadPool=" + URLState.this.mUseThreadPool);
            }
            if (URLState.this.mUseThreadPool)
            {
              URLState.PreDownloadRunnable.this.mDownloadRunnable.flag = 1;
              if (QLog.isColorLevel())
              {
                Executor localExecutor = URLDrawable.sDefaultDrawableParms.mURLDrawableExecutor;
                if ((localExecutor instanceof ThreadPoolExecutor)) {
                  QLog.d("URLDrawable_Thread", 2, "Executor.execute:" + URLState.this.mUrlStr + " ,LargestPoolSize = " + ((ThreadPoolExecutor)localExecutor).getLargestPoolSize() + " ,PoolSate=" + localExecutor.toString());
                }
              }
              URLDrawable.sDefaultDrawableParms.mURLDrawableExecutor.execute(URLState.PreDownloadRunnable.this.mDownloadRunnable);
            }
            else
            {
              URLState.PreDownloadRunnable.this.mDownloadRunnable.flag = 2;
              URLDrawable.sDefaultDrawableParms.mBatchHandler.post(URLState.PreDownloadRunnable.this.mDownloadRunnable);
            }
          }
        }
      });
    }
  }
  
  static class ThreadReportParam
  {
    Thread mThread;
    long postTime;
    long startTime;
    int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.URLState
 * JD-Core Version:    0.7.0.1
 */
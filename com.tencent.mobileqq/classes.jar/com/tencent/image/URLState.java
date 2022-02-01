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
import android.util.Pair;
import com.tencent.image.api.ICache;
import com.tencent.image.api.ILog;
import com.tencent.image.api.IReport;
import com.tencent.image.api.URLDrawableDepWrap;
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
  static final Object DOWNLOAD_ASYNC;
  static final Object FILE_DOWNLOADED;
  public static final int FLAG_BATCH_HANDLER = 2;
  public static final int FLAG_FILE_HANDLER = 0;
  public static final int FLAG_THREAD_POOL = 1;
  public static final int INTERVAL_TIME = 300000;
  public static final int LENGTH_URL_EXTRA = 60;
  public static final int REPORT_TIME = 500000;
  public static final String TENCENT_FILE_PATH;
  public static final int THREAD_COST_TIME = 500000;
  private static final Handler UI_HANDLER;
  private static String[] sSysTracePrefixs = { "android.", "com.android.", "dalvik.", "com.google.", "java." };
  static ConcurrentHashMap<String, URLState.ThreadReportParam> sThreadReportCache;
  static HashMap<String, WeakReference<URLState>> sUnFinishImageCache;
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
  byte mPriority = URLDrawable.depImp.mCache.getNormalPriority();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/Tencent/");
    TENCENT_FILE_PATH = localStringBuilder.toString();
    FILE_DOWNLOADED = new Object();
    DOWNLOAD_ASYNC = new Object();
    UI_HANDLER = new Handler(Looper.getMainLooper());
    sUnFinishImageCache = new HashMap();
    sThreadReportCache = new ConcurrentHashMap();
    slastCheckTime = 0L;
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
    if ((this.mProtocolDownloader == null) && (URLDrawable.depImp.mLog.isColorLevel()))
    {
      paramURLDrawableOptions = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("No comfortable downloader. url:");
      localStringBuilder.append(???);
      localStringBuilder.append("protocol");
      localStringBuilder.append(???.getProtocol());
      paramURLDrawableOptions.e("URLDrawable_", 4, localStringBuilder.toString());
    }
    synchronized (URLDrawable.depImp.mCache)
    {
      if (this.mUseUnFinishCache) {
        sUnFinishImageCache.put(this.mMemoryCacheKey, new WeakReference(this));
      }
      return;
    }
  }
  
  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 == -1) {
            return 1;
          }
          j = paramOptions.outHeight;
          int k = paramOptions.outWidth;
          for (;;)
          {
            m = i;
            if (j <= paramInt2) {
              break;
            }
            m = i;
            if (k <= paramInt1) {
              break;
            }
            int n = Math.round(j / paramInt2);
            m = Math.round(k / paramInt1);
            if (n <= m) {
              n = m;
            }
            m = i;
            if (n < 2) {
              break;
            }
            k >>= 1;
            j >>= 1;
            i <<= 1;
          }
        }
      }
    }
    return m;
  }
  
  private void checkThreadState()
  {
    if (slastCheckTime == 0L)
    {
      slastCheckTime = System.currentTimeMillis();
      return;
    }
    slastCheckTime = System.currentTimeMillis();
    if (sThreadReportCache.size() > 0) {
      try
      {
        Iterator localIterator = sThreadReportCache.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (Map.Entry)localIterator.next();
          Object localObject2 = (String)((Map.Entry)localObject1).getKey();
          Object localObject3 = (URLState.ThreadReportParam)((Map.Entry)localObject1).getValue();
          long l = System.currentTimeMillis() - ((URLState.ThreadReportParam)localObject3).startTime;
          if (l > 500000L)
          {
            localObject1 = new HashMap();
            ((HashMap)localObject1).put("URL", localObject2);
            ((HashMap)localObject1).put("duration", String.valueOf(l));
            ((HashMap)localObject1).put("threadState", String.valueOf(((URLState.ThreadReportParam)localObject3).mThread.getState()));
            ((HashMap)localObject1).put("threadStack", getAppStack(((URLState.ThreadReportParam)localObject3).mThread.getStackTrace()).toString());
            ((HashMap)localObject1).put("postCost", String.valueOf(((URLState.ThreadReportParam)localObject3).postTime));
            ((HashMap)localObject1).put("ThreadFlag", String.valueOf(((URLState.ThreadReportParam)localObject3).type));
            localObject2 = new ReportBean("URLDrawableThreadState");
            ((ReportBean)localObject2).params = ((HashMap)localObject1);
            URLDrawable.depImp.mReport.report((ReportBean)localObject2);
            if (URLDrawable.depImp.mLog.isColorLevel())
            {
              localObject2 = URLDrawable.depImp.mLog;
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("checkThreadState|params= ");
              ((StringBuilder)localObject3).append(localObject1);
              ((ILog)localObject2).d("URLDrawable_Thread", 2, ((StringBuilder)localObject3).toString());
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
    if (localObject2 != null)
    {
      Object localObject1 = ((ProtocolDownloader)localObject2).decodeFile(paramFile, this.mParams, paramURLDrawableHandler);
      paramURLDrawableHandler = localObject1;
      if (localObject1 != null)
      {
        this.mOrientation = this.mParams.outOrientation;
        this.mWidth = this.mParams.outWidth;
        this.mHeight = this.mParams.outHeight;
        return localObject1;
      }
    }
    else
    {
      paramURLDrawableHandler = null;
    }
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return null;
      }
      boolean bool;
      if ((localObject2 != null) && (((ProtocolDownloader)localObject2).gifHasDifferentState())) {
        bool = true;
      } else {
        bool = false;
      }
      if (VideoDrawable.isVideo(paramFile)) {
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
      if ((this.mParams.useSharpPImage) && (SharpPUtil.isSharpPFile(paramFile)))
      {
        try
        {
          paramFile = SharpPUtil.decodeSharpPByFilePath(paramFile.getAbsolutePath());
          return paramFile;
        }
        catch (Throwable localThrowable)
        {
          paramFile = paramURLDrawableHandler;
          if (!URLDrawable.depImp.mLog.isColorLevel()) {
            break label825;
          }
        }
        URLDrawable.depImp.mLog.e("URLDrawable_", 2, "", localThrowable);
        return paramURLDrawableHandler;
      }
      else
      {
        String str = paramFile.getAbsolutePath();
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        ((BitmapFactory.Options)localObject2).inPreferredConfig = URLDrawable.sDefaultDrawableParms.mConfig;
        ((BitmapFactory.Options)localObject2).inDensity = 160;
        ((BitmapFactory.Options)localObject2).inTargetDensity = 160;
        ((BitmapFactory.Options)localObject2).inScreenDensity = 160;
        SafeBitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject2);
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = false;
        ((BitmapFactory.Options)localObject2).inSampleSize = calculateInSampleSize((BitmapFactory.Options)localObject2, this.mParams.reqWidth, this.mParams.reqHeight);
        paramURLDrawableHandler = SafeBitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject2);
        if (URLDrawable.depImp.mLog.isColorLevel())
        {
          ILog localILog = URLDrawable.depImp.mLog;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeFile:sampleSize=");
          localStringBuilder.append(((BitmapFactory.Options)localObject2).inSampleSize);
          localStringBuilder.append(", requestSize=");
          localStringBuilder.append(this.mParams.reqWidth);
          localStringBuilder.append(",");
          localStringBuilder.append(this.mParams.reqHeight);
          localStringBuilder.append(" ");
          localStringBuilder.append(this.mUrlStr);
          localILog.d("URLDrawable_", 2, localStringBuilder.toString());
        }
        if (paramURLDrawableHandler == null)
        {
          if (this.mDecodeFileStrategy == 3)
          {
            if (URLDrawable.depImp.mLog.isColorLevel())
            {
              paramFile = URLDrawable.depImp.mLog;
              paramURLDrawableHandler = new StringBuilder();
              paramURLDrawableHandler.append("decode cache file failed,ignoreDeleteFile:");
              paramURLDrawableHandler.append(str);
              paramURLDrawableHandler.append(" mUrlStr:");
              paramURLDrawableHandler.append(this.mUrlStr);
              paramFile.d("URLDrawable_", 2, paramURLDrawableHandler.toString());
              return null;
            }
          }
          else
          {
            if (URLDrawable.depImp.mLog.isColorLevel())
            {
              paramURLDrawableHandler = URLDrawable.depImp.mLog;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("decode cache file failed,path:");
              ((StringBuilder)localObject2).append(str);
              ((StringBuilder)localObject2).append(" mUrlStr:");
              ((StringBuilder)localObject2).append(this.mUrlStr);
              ((StringBuilder)localObject2).append(" mDecodeFileStrategy:");
              ((StringBuilder)localObject2).append(this.mDecodeFileStrategy);
              paramURLDrawableHandler.d("URLDrawable_", 2, ((StringBuilder)localObject2).toString());
            }
            if (str.startsWith(TENCENT_FILE_PATH)) {
              paramFile.delete();
            }
          }
          return null;
        }
        this.mOrientation = JpegExifReader.readOrientation(str);
        if (this.mParams.mDecodeHandler != null) {
          paramURLDrawableHandler = this.mParams.mDecodeHandler.run(this.mParams, paramURLDrawableHandler);
        }
        paramFile = paramURLDrawableHandler;
        if (Build.VERSION.SDK_INT >= 11)
        {
          paramFile = paramURLDrawableHandler;
          if (SliceBitmap.needSlice(paramURLDrawableHandler))
          {
            paramFile = new SliceBitmap(paramURLDrawableHandler);
            paramURLDrawableHandler.recycle();
          }
        }
      }
      label825:
      return paramFile;
    }
    return null;
  }
  
  private static StringBuilder getAppStack(StackTraceElement[] paramArrayOfStackTraceElement)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfStackTraceElement.length)
    {
      String str = paramArrayOfStackTraceElement[i].toString();
      if (isQQStackFrame(str))
      {
        if (localStringBuilder.length() == 0) {
          localStringBuilder.append("[");
        } else {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(str);
      }
      i += 1;
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("]");
    }
    return localStringBuilder;
  }
  
  static URLState getConstants(String paramString)
  {
    synchronized (URLDrawable.depImp.mCache)
    {
      WeakReference localWeakReference = (WeakReference)sUnFinishImageCache.get(paramString);
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        paramString = (URLState)localWeakReference.get();
        return paramString;
      }
      paramString = (Pair)URLDrawable.depImp.mCache.get(paramString);
      if ((paramString != null) && ((paramString.first instanceof URLState))) {
        return (URLState)paramString.first;
      }
      return null;
    }
  }
  
  static URLState getConstants(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    synchronized (URLDrawable.depImp.mCache)
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
      paramString = (Pair)URLDrawable.depImp.mCache.get(paramString);
      if ((paramString != null) && ((paramString.first instanceof URLState)))
      {
        if (paramURLDrawableOptions.isFlashPic != ((URLState)paramString.first).isFlashPicNeedCache) {
          return null;
        }
        return (URLState)paramString.first;
      }
      return null;
    }
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
    if ((!paramString.startsWith("chatthumb")) && (paramURLDrawableOptions.mKeyAddWHSuffix) && (paramURLDrawableOptions.mRequestWidth != 0) && (paramURLDrawableOptions.mRequestHeight != 0))
    {
      localStringBuilder.append('#');
      localStringBuilder.append(paramURLDrawableOptions.mRequestWidth);
      localStringBuilder.append("_");
      localStringBuilder.append(paramURLDrawableOptions.mRequestHeight);
    }
    if (paramURLDrawableOptions.mMemoryCacheKeySuffix != null)
    {
      localStringBuilder.append('#');
      localStringBuilder.append(paramURLDrawableOptions.mMemoryCacheKeySuffix);
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
    if (!this.mIgnorePause) {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        return;
      }
    }
    for (;;)
    {
      synchronized (URLDrawable.sPauseLock)
      {
        long l1 = System.currentTimeMillis();
        if (URLDrawable.sPause)
        {
          long l2 = System.currentTimeMillis();
          if (l2 - l1 > 10000L) {}
        }
        try
        {
          URLDrawable.sPauseLock.wait();
        }
        catch (InterruptedException localInterruptedException) {}
        return;
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
    //   1: getfield 158	com/tencent/image/URLState:mStatus	I
    //   4: iconst_1
    //   5: if_icmpeq +242 -> 247
    //   8: aload_0
    //   9: getfield 169	com/tencent/image/URLState:mIsLoadingStarted	I
    //   12: istore 11
    //   14: iload 11
    //   16: ifle +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: iload 11
    //   23: iconst_1
    //   24: iadd
    //   25: putfield 169	com/tencent/image/URLState:mIsLoadingStarted	I
    //   28: aload_0
    //   29: iload 4
    //   31: putfield 738	com/tencent/image/URLState:mDecodeFile	Z
    //   34: aload_0
    //   35: getfield 165	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   38: astore 12
    //   40: aload 12
    //   42: aload_2
    //   43: putfield 742	com/tencent/image/DownloadParams:cookies	Lorg/apache/http/client/CookieStore;
    //   46: aload 12
    //   48: aload_1
    //   49: putfield 746	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   52: aload 12
    //   54: aload_3
    //   55: putfield 749	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   58: aload 12
    //   60: iload 5
    //   62: putfield 488	com/tencent/image/DownloadParams:useGifAnimation	Z
    //   65: aload 12
    //   67: iload 6
    //   69: putfield 501	com/tencent/image/DownloadParams:useApngImage	Z
    //   72: aload 12
    //   74: iload 7
    //   76: putfield 514	com/tencent/image/DownloadParams:useSharpPImage	Z
    //   79: aload 12
    //   81: fload 8
    //   83: putfield 492	com/tencent/image/DownloadParams:mGifRoundCorner	F
    //   86: aload 12
    //   88: iconst_0
    //   89: putfield 752	com/tencent/image/DownloadParams:needCheckNetType	Z
    //   92: aload 12
    //   94: iload 9
    //   96: putfield 755	com/tencent/image/DownloadParams:useExifOrientation	Z
    //   99: aload 12
    //   101: aload 10
    //   103: putfield 477	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 214	com/tencent/image/URLState:mUrl	Ljava/net/URL;
    //   111: new 757	com/tencent/image/URLDrawableHandler$Adapter
    //   114: dup
    //   115: invokespecial 758	com/tencent/image/URLDrawableHandler$Adapter:<init>	()V
    //   118: invokevirtual 762	com/tencent/image/URLState:loadImage	(Ljava/net/URL;Lcom/tencent/image/URLDrawableHandler;)Ljava/lang/Object;
    //   121: astore_2
    //   122: aload_2
    //   123: getstatic 112	com/tencent/image/URLState:DOWNLOAD_ASYNC	Ljava/lang/Object;
    //   126: if_acmpeq +121 -> 247
    //   129: invokestatic 710	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   132: invokestatic 120	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   135: if_acmpne +8 -> 143
    //   138: aload_2
    //   139: astore_1
    //   140: goto +81 -> 221
    //   143: getstatic 125	com/tencent/image/URLState:UI_HANDLER	Landroid/os/Handler;
    //   146: astore_1
    //   147: new 764	com/tencent/image/URLState$PostOnResult
    //   150: dup
    //   151: aload_0
    //   152: aload_2
    //   153: invokespecial 765	com/tencent/image/URLState$PostOnResult:<init>	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   156: astore_2
    //   157: goto +84 -> 241
    //   160: astore_1
    //   161: getstatic 112	com/tencent/image/URLState:DOWNLOAD_ASYNC	Ljava/lang/Object;
    //   164: ifnull +36 -> 200
    //   167: invokestatic 710	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   170: invokestatic 120	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   173: if_acmpne +11 -> 184
    //   176: aload_0
    //   177: aconst_null
    //   178: invokevirtual 768	com/tencent/image/URLState:onResult	(Ljava/lang/Object;)V
    //   181: goto +19 -> 200
    //   184: getstatic 125	com/tencent/image/URLState:UI_HANDLER	Landroid/os/Handler;
    //   187: new 764	com/tencent/image/URLState$PostOnResult
    //   190: dup
    //   191: aload_0
    //   192: aconst_null
    //   193: invokespecial 765	com/tencent/image/URLState$PostOnResult:<init>	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   196: invokevirtual 729	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   199: pop
    //   200: aload_1
    //   201: athrow
    //   202: astore_2
    //   203: aload_2
    //   204: getstatic 112	com/tencent/image/URLState:DOWNLOAD_ASYNC	Ljava/lang/Object;
    //   207: if_acmpeq +40 -> 247
    //   210: invokestatic 710	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   213: invokestatic 120	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   216: if_acmpne +11 -> 227
    //   219: aload_2
    //   220: astore_1
    //   221: aload_0
    //   222: aload_1
    //   223: invokevirtual 768	com/tencent/image/URLState:onResult	(Ljava/lang/Object;)V
    //   226: return
    //   227: getstatic 125	com/tencent/image/URLState:UI_HANDLER	Landroid/os/Handler;
    //   230: astore_1
    //   231: new 764	com/tencent/image/URLState$PostOnResult
    //   234: dup
    //   235: aload_0
    //   236: aload_2
    //   237: invokespecial 765	com/tencent/image/URLState$PostOnResult:<init>	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   240: astore_2
    //   241: aload_1
    //   242: aload_2
    //   243: invokevirtual 729	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   246: pop
    //   247: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	URLState
    //   0	248	1	paramArrayOfHeader	Header[]
    //   0	248	2	paramCookieStore	CookieStore
    //   0	248	3	paramObject1	Object
    //   0	248	4	paramBoolean1	boolean
    //   0	248	5	paramBoolean2	boolean
    //   0	248	6	paramBoolean3	boolean
    //   0	248	7	paramBoolean4	boolean
    //   0	248	8	paramFloat	float
    //   0	248	9	paramBoolean5	boolean
    //   0	248	10	paramObject2	Object
    //   12	13	11	i	int
    //   38	62	12	localDownloadParams	DownloadParams
    // Exception table:
    //   from	to	target	type
    //   106	122	160	finally
    //   106	122	202	java/lang/Throwable
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  Object loadImage(URL paramURL, URLDrawableHandler paramURLDrawableHandler)
  {
    long l1 = System.currentTimeMillis();
    Object localObject2;
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ??? = URLDrawable.depImp.mLog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DownloadAsyncTask pauseThread1 start: ");
      ((StringBuilder)localObject2).append(this.mUrlStr);
      ((ILog)???).d("URLDrawable_Thread_pasueCost", 2, ((StringBuilder)localObject2).toString());
    }
    pauseThread();
    long l2 = System.currentTimeMillis();
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ??? = URLDrawable.depImp.mLog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DownloadAsyncTask pauseThread1 end : ");
      ((StringBuilder)localObject2).append(this.mUrlStr);
      ((StringBuilder)localObject2).append(",cost=");
      ((StringBuilder)localObject2).append(l2 - l1);
      ((ILog)???).d("URLDrawable_Thread_pasueCost", 2, ((StringBuilder)localObject2).toString());
    }
    if (this.mParams.useApngImage)
    {
      ??? = URLDrawable.sDefaultDrawableParms.getApngSoLoader();
      if (!((ApngSoLoader)???).isLoaded())
      {
        ((ApngSoLoader)???).load(new URLState.2(this, paramURLDrawableHandler));
        return DOWNLOAD_ASYNC;
      }
    }
    if (this.mProtocolDownloader != null)
    {
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        ??? = URLDrawable.depImp.mLog;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("call downloader loadImage.");
        ((StringBuilder)localObject2).append(this.mUrlStr);
        ((ILog)???).i("URLDrawable_", 2, ((StringBuilder)localObject2).toString());
      }
      if ((!this.mProtocolDownloader.hasDiskFile(this.mParams)) && (this.mParams.mHttpDownloaderParams != null))
      {
        this.mProtocolDownloader.loadImageFile(this.mParams, new URLState.3(this, paramURL, paramURLDrawableHandler));
        return DOWNLOAD_ASYNC;
      }
      if (URLDrawable.depImp.mLog.isColorLevel()) {
        URLDrawable.depImp.mLog.i("URLDrawable_", 2, "sync loadImage.");
      }
      paramURL = this.mProtocolDownloader.loadImageFile(this.mParams, paramURLDrawableHandler);
      this.mCacheFile = paramURL;
    }
    else
    {
      paramURL = null;
    }
    synchronized (this.mDecodeFileLock)
    {
      if (!this.mDecodeFile)
      {
        this.mStatus = 4;
        this.mIsLoadingStarted -= 1;
        paramURL = FILE_DOWNLOADED;
        return paramURL;
      }
      this.mStatus = 4;
      paramURL = decodeFile(paramURL, paramURLDrawableHandler);
      if (paramURL != null)
      {
        if ((paramURL instanceof Bitmap))
        {
          ??? = this.mUrl.getPath();
          ??? = new RegionDrawable(null, (Bitmap)paramURL, (String)???);
          ((RegionDrawable)???).setDither(this.mDither);
          this.mSuccessed = ((RegionDrawable)???).getConstantState();
        }
        else if ((paramURL instanceof SliceBitmap))
        {
          ??? = new SliceBitmapDrawable.BitmapState((SliceBitmap)paramURL);
          ((SliceBitmapDrawable.BitmapState)???).mPaint.setDither(this.mDither);
          this.mSuccessed = ((Drawable.ConstantState)???);
        }
        else if ((paramURL instanceof AbstractGifImage))
        {
          ??? = new GifDrawable.GifState((AbstractGifImage)paramURL);
          ((GifDrawable.GifState)???).mPaint.setDither(this.mDither);
          this.mSuccessed = ((Drawable.ConstantState)???);
        }
        else if ((paramURL instanceof ApngImage))
        {
          ??? = new ApngDrawable.ApngState((ApngImage)paramURL);
          ((ApngDrawable.ApngState)???).mPaint.setDither(this.mDither);
          this.mSuccessed = ((Drawable.ConstantState)???);
        }
        else if ((paramURL instanceof RoundRectBitmap))
        {
          ??? = new RoundRectDrawable.RoundRectDrawableState((RoundRectBitmap)paramURL);
          ((RoundRectDrawable.RoundRectDrawableState)???).mBorderPaint.setDither(this.mDither);
          ((RoundRectDrawable.RoundRectDrawableState)???).mBitmapPaint.setDither(this.mDither);
          this.mSuccessed = ((Drawable.ConstantState)???);
        }
        else if ((paramURL instanceof AbstractVideoImage))
        {
          ??? = new VideoDrawable.VideoState((AbstractVideoImage)paramURL);
          ((VideoDrawable.VideoState)???).mPaint.setDither(this.mDither);
          this.mSuccessed = ((Drawable.ConstantState)???);
        }
        else if ((paramURL instanceof QQLiveImage))
        {
          ??? = new QQLiveDrawable.QQLiveState((QQLiveImage)paramURL);
          ((QQLiveDrawable.QQLiveState)???).mPaint.setDither(this.mDither);
          this.mSuccessed = ((Drawable.ConstantState)???);
          this.mParams.mExtraInfo = null;
        }
        else
        {
          if (!(paramURL instanceof Drawable)) {
            break label884;
          }
          this.mSuccessed = ((Drawable)paramURL).getConstantState();
        }
        localObject2 = new Pair(this, Integer.valueOf(getImageByteSize(paramURL)));
        synchronized (URLDrawable.depImp.mCache)
        {
          if (this.mUseUnFinishCache) {
            sUnFinishImageCache.remove(this.mMemoryCacheKey);
          }
          if (this.mUseMemoryCache) {
            URLDrawable.depImp.mCache.put(this.mMemoryCacheKey, localObject2, this.mPriority);
          }
          this.mStatus = 1;
        }
        label884:
        paramURLDrawableHandler = new StringBuilder();
        paramURLDrawableHandler.append("Invalide image type ");
        paramURLDrawableHandler.append(paramURL.getClass().getSimpleName());
        throw new RuntimeException(paramURLDrawableHandler.toString());
      }
      l1 = System.currentTimeMillis();
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        ??? = URLDrawable.depImp.mLog;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("DownloadAsyncTask pauseThread2 start: ");
        ((StringBuilder)localObject2).append(this.mUrlStr);
        ((ILog)???).d("URLDrawable_Thread_pasueCost", 2, ((StringBuilder)localObject2).toString());
      }
      pauseThread();
      l2 = System.currentTimeMillis();
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        ??? = URLDrawable.depImp.mLog;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("DownloadAsyncTask pauseThread2 end: ");
        ((StringBuilder)localObject2).append(this.mUrlStr);
        ((StringBuilder)localObject2).append(",cost=");
        ((StringBuilder)localObject2).append(l2 - l1);
        ((ILog)???).d("URLDrawable_Thread_pasueCost", 2, ((StringBuilder)localObject2).toString());
      }
      paramURLDrawableHandler.publishProgress(10000);
      if (paramURL != null)
      {
        if (this.mSuccessed != null) {
          return paramURL;
        }
        throw new NullPointerException("mSuccessed is null...");
      }
      throw new NullPointerException("bitmap decode failed");
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
    Object localObject2;
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      localObject1 = URLDrawable.depImp.mLog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("download successed, URLState: ");
      ((StringBuilder)localObject2).append(this);
      ((StringBuilder)localObject2).append(" , url: ");
      ((StringBuilder)localObject2).append(this.mUrlStr);
      ((StringBuilder)localObject2).append("\nnotify ");
      ((StringBuilder)localObject2).append(this.callbacks.size());
      ((StringBuilder)localObject2).append(" callbacks");
      ((ILog)localObject1).d("URLDrawable_", 4, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.callbacks.size())
        {
          localObject2 = (WeakReference)this.callbacks.get(i);
          int j;
          if (localObject2 != null)
          {
            localObject2 = (URLState.Callback)((WeakReference)localObject2).get();
            if (localObject2 != null)
            {
              ((URLState.Callback)localObject2).onFileDownloaded(this);
            }
            else
            {
              localObject2 = this.callbacks;
              j = i - 1;
              ((Vector)localObject2).remove(i);
              i = j;
            }
          }
          else
          {
            localObject2 = this.callbacks;
            j = i - 1;
            ((Vector)localObject2).remove(i);
            i = j;
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
        throw localObject3;
        continue;
        i += 1;
      }
    }
  }
  
  void onLoadCancelled()
  {
    Object localObject2;
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ??? = URLDrawable.depImp.mLog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[onLoadCancelled]");
      ((StringBuilder)localObject2).append(this.mUrlStr);
      ((ILog)???).i("URLDrawable_", 2, ((StringBuilder)localObject2).toString());
    }
    this.mStatus = 3;
    this.mIsLoadingStarted -= 1;
    int i = 0;
    if (i < this.callbacks.size()) {}
    label204:
    for (;;)
    {
      synchronized (this.callbacks)
      {
        localObject2 = (WeakReference)this.callbacks.get(i);
        int j;
        if (localObject2 != null)
        {
          localObject2 = (URLState.Callback)((WeakReference)localObject2).get();
          if (localObject2 != null)
          {
            ((URLState.Callback)localObject2).onLoadCanceled(this);
          }
          else
          {
            localObject2 = this.callbacks;
            j = i - 1;
            ((Vector)localObject2).remove(i);
            i = j;
            break label204;
          }
        }
        else
        {
          localObject2 = this.callbacks;
          j = i - 1;
          ((Vector)localObject2).remove(i);
          i = j;
          break label204;
        }
        i += 1;
      }
      return;
    }
  }
  
  void onLoadFailed(Throwable paramThrowable)
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.e("URLDrawable_", 4, wrapLog("URLState onLoadFailed():"), paramThrowable);
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
          Object localObject = (WeakReference)this.callbacks.get(i);
          int j;
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
          else
          {
            localObject = this.callbacks;
            j = i - 1;
            ((Vector)localObject).remove(i);
            i = j;
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
        throw paramThrowable;
        continue;
        i += 1;
      }
    }
  }
  
  void onLoadStart()
  {
    Vector localVector = this.callbacks;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.callbacks.size())
        {
          Object localObject1 = (WeakReference)this.callbacks.get(i);
          int j;
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
          else
          {
            localObject1 = this.callbacks;
            j = i - 1;
            ((Vector)localObject1).remove(i);
            i = j;
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
        throw localObject2;
        continue;
        i += 1;
      }
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
      finally
      {
        continue;
        throw localObject2;
        continue;
        i += 1;
      }
    }
  }
  
  void onResult(Object paramObject)
  {
    if (URLDrawable.depImp.mLog.isColorLevel())
    {
      ILog localILog = URLDrawable.depImp.mLog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("URLState.onResult ");
      localStringBuilder.append(paramObject);
      localStringBuilder.append(" ");
      localStringBuilder.append(this.mUrlStr);
      localILog.d("URLDrawable_", 2, localStringBuilder.toString());
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
    int i = this.mStatus;
    if ((i != 2) && (i != 3)) {
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
      try
      {
        if (i >= this.callbacks.size()) {
          continue;
        }
        localObject = (WeakReference)this.callbacks.get(i);
        if (localObject == null) {
          continue;
        }
        localObject = (URLState.Callback)((WeakReference)localObject).get();
        if (localObject == null) {
          continue;
        }
        if (localObject == paramCallback) {}
      }
      finally
      {
        Object localObject;
        continue;
        throw paramCallback;
        continue;
        int j = i;
        if (localObject != null) {
          continue;
        }
        continue;
        j = i;
        i = j + 1;
      }
      localObject = this.callbacks;
      j = i - 1;
      ((Vector)localObject).remove(i);
      i = j;
      continue;
      localObject = this.callbacks;
      j = i - 1;
      ((Vector)localObject).remove(i);
      i = j;
      continue;
      return;
    }
  }
  
  public String saveTo(String paramString)
  {
    File localFile = this.mCacheFile;
    if (localFile != null)
    {
      String str = paramString;
      if (paramString.indexOf(".") == -1)
      {
        if ((this.mSuccessed instanceof GifDrawable.GifState)) {
          str = ".gif";
        } else {
          str = ".jpg";
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(str);
        str = localStringBuilder.toString();
      }
      Utils.copyFile(localFile, new File(str));
      if (localFile != null) {
        return str;
      }
      return null;
    }
    throw new FileNotFoundException("File is not download complete, please check getStatus() == URLDrawable.SUCCESSED first. ");
  }
  
  void startDownload(Header[] paramArrayOfHeader, CookieStore paramCookieStore, Object paramObject1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, float paramFloat, boolean paramBoolean5, Object paramObject2)
  {
    if (this.mProtocolDownloader == null)
    {
      onLoadFailed(new NullPointerException("mProtocolDownloader is null"));
      return;
    }
    if (this.mIsLoadingStarted == 0)
    {
      if (URLDrawable.depImp.mLog.isColorLevel())
      {
        ??? = URLDrawable.depImp.mLog;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("URLState.startDownload:");
        localStringBuilder.append(this.mUrlStr);
        ((ILog)???).d("URLDrawable_", 2, localStringBuilder.toString());
      }
      this.mIsLoadingStarted += 1;
      this.mDecodeFile = paramBoolean1;
      ??? = this.mParams;
      ((DownloadParams)???).cookies = paramCookieStore;
      ((DownloadParams)???).headers = paramArrayOfHeader;
      ((DownloadParams)???).tag = paramObject1;
      ((DownloadParams)???).useGifAnimation = paramBoolean2;
      ((DownloadParams)???).useApngImage = paramBoolean3;
      ((DownloadParams)???).useSharpPImage = paramBoolean4;
      ((DownloadParams)???).mGifRoundCorner = paramFloat;
      ((DownloadParams)???).useExifOrientation = paramBoolean5;
      ((DownloadParams)???).mExtraInfo = paramObject2;
      paramArrayOfHeader = new URLState.PreDownloadRunnable(this, this.mUrl);
      URLDrawable.sDefaultDrawableParms.mSubHandler.post(paramArrayOfHeader);
      this.mTask = paramArrayOfHeader;
      return;
    }
    if ((!this.mDecodeFile) && (paramBoolean1)) {
      synchronized (this.mDecodeFileLock)
      {
        if (this.mStatus == 0)
        {
          this.mDecodeFile = true;
          return;
        }
        if (this.mIsLoadingStarted != 0) {
          return;
        }
        startDownload(paramArrayOfHeader, paramCookieStore, paramObject1, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramFloat, paramBoolean5, paramObject2);
        return;
      }
    }
    if ((this.mIsLoadingStarted > 1) && (URLDrawable.depImp.mLog.isColorLevel()))
    {
      paramArrayOfHeader = URLDrawable.depImp.mLog;
      paramCookieStore = new StringBuilder();
      paramCookieStore.append("startDownload mIsLoadingStarted is ");
      paramCookieStore.append(this.mIsLoadingStarted);
      paramArrayOfHeader.i("URLDrawable_", 2, paramCookieStore.toString());
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.URLState
 * JD-Core Version:    0.7.0.1
 */
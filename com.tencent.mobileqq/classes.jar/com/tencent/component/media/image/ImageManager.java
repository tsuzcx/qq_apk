package com.tencent.component.media.image;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.component.media.IDownloader;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.DrawableContainer;
import com.tencent.component.media.image.drawable.NinePatchRefDrawable;
import com.tencent.component.media.image.drawable.SliceBitmapDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.image.BitmapImage;
import com.tencent.component.media.image.image.FeedsBitmapImage;
import com.tencent.component.media.image.image.Image;
import com.tencent.component.media.image.image.NewGifImage;
import com.tencent.component.media.image.region.RegionDrawable;
import com.tencent.component.media.photogif.NewAnimationDrawable;
import com.tencent.component.media.photogif.PhotoGifDrawable;
import com.tencent.component.media.utils.BaseHandler;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.component.media.utils.LruCache;
import com.tencent.sharpP.SharpPUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageManager
{
  private static final int DRAWABLE_CACHE_LOG_SIZE = 1048576;
  public static final byte FLAG_DOWNLOAD_ONLY = 3;
  public static final byte FLAG_GET_FROM_MEMORY = 0;
  public static final byte FLAG_GET_FROM_MEMORY_LOCAL = 1;
  public static final byte FLAG_GET_FROM_MEMORY_LOCAL_NETWORK = 2;
  public static final String IMAGE_DIR_NAME_NOCACHE = "nocache";
  public static final String IMAGE_DIR_NAME_SR = "image_sr";
  public static final String IMAGE_DIR_NAME_V1 = "image";
  public static final String IMAGE_DIR_NAME_V2 = "imageV2";
  private static final int IMAGE_HIT = 16;
  private static final ConcurrentHashMap<String, Object> INVALIDATE_URLS = new ConcurrentHashMap();
  private static final boolean IS_ICE_CREAM_SANDWICH;
  private static final Object LOCK_CacheMap;
  private static final Object LOCK_mImageDecodeThreadPool;
  private static final Object LOCK_mImageGetNullOrCancelHandler;
  private static final Object LOCK_mImageTaskThreadPool;
  private static final Object LOCK_mInstance = new Object();
  private static final int LOW_SIZE = 5242880;
  private static final String LRU_FILE_NAME = "imagelru.usetime";
  private static long MAX_INNER_SIZE_LIMIT = 0L;
  private static long MAX_SDCARD_SIZE_LIMIT = 0L;
  private static final int MIN_CACHE_SIZE = 8388608;
  private static final int MSG_CANCEL = 1;
  private static final int MSG_DUMP_MEMORY_CACHE = 1000;
  private static final int MSG_GET_NULL = 0;
  private static final int MSG_IMAGE_TASK_TRACER = 2;
  public static final String TAG = "ImageManager";
  private static final int VERSION_CODES_LOLLIPOP = 21;
  private static Comparator<File> fileTimeComparator;
  private static Runnable getAllSDCardInfoRunnable;
  public static volatile boolean hasScrolled = false;
  private static FilenameFilter imageFilenameFilter;
  public static volatile boolean isInFriendFeed = false;
  private static boolean isMainProcess = false;
  private static HashMap<String, Boolean> isStorageReallyCanwriteMap;
  private static boolean isUseExternalStorage = false;
  private static final int localPhotoProcessCacheSize = 524288;
  private static String mCachePath;
  private static HashMap<String, Integer> mDecodeExceptionMap;
  private static ConcurrentHashMap<Integer, Integer> mFilename2FileLengthMap;
  private static volatile boolean mHasLoadSDCardName = false;
  private static Executor mImageDecodeThreadPool;
  private static volatile HandlerThread mImageSuperResolutionHandlerThread;
  private static volatile Executor mImageTaskThreadPool;
  private static volatile ImageManager mInstance;
  private static boolean mIsRegisterSdcardReceiver = false;
  private static volatile boolean mLoadAllImageFileFlag = false;
  private static ConcurrentHashMap<String, Integer> mLruFilename2TimeMap;
  private static HashMap<String, String> mSDCardName2PathMap;
  private static long mSaveLruFileTime = 0L;
  private static volatile Handler mSuperResolutionHandler;
  private static final int mainProcessCacheSize = 262144;
  private static long maxAvailableSize = 0L;
  private static String maxAvailableSizePath;
  private static long maxCacheSize = 0L;
  private static int maxDecodeFailCount = 0;
  private static final float remainSizeFactor = 0.8F;
  private static String sCachePath4SuperResolution;
  public static boolean sCloseNativeAndCache = false;
  private static String storeRootPath;
  private static final AtomicInteger threadCount;
  public static final long timeInterval = 60000L;
  private final BroadcastReceiver MsdCardMountReceiver;
  private Runnable checkOldImageFileAndCleanRunnable;
  private long checkStorageLowTime;
  private Looper dispatcherLoop = null;
  private IImageFileTracer imageFileTracer = null;
  private int imageMemCacheSize;
  private boolean isStorageLow;
  IBitmapFactory mBitmapFactory;
  ByteArrayPool mByteArrayPool;
  private Context mContext;
  private IDecoder mDecoder = null;
  private ConcurrentHashMap<String, File> mFilename2FileMap;
  private volatile boolean mHasEntryNoCacheUrlKeyAndCacheTimeMap;
  private IDownloader mImageDownloader = null;
  private BaseHandler mImageGetNullOrCancelHandler = null;
  private ConcurrentHashMap<Integer, Integer> mImageKey2SampleSizeMap;
  private ConcurrentHashMap<Integer, HashSet<ImageKey>> mImageKeyHash2DecodeOrDownloadMap = new ConcurrentHashMap();
  private LruCache<Integer, Drawable> mImageKeyHash2DrawableMap = null;
  private LruCache<Integer, Image> mImageKeyHash2ImageMap = null;
  private ConcurrentHashMap<Integer, String> mImageKeyHash2UrlMap = new ConcurrentHashMap();
  private HashMap<Integer, HashSet<ImageKey>> mImageKeyHash2WaitDecodeMap;
  private ConcurrentHashMap<String, ImageManager.ImageAttri> mImagePath2AttriMap;
  private ThreadLocal<HashSet<Integer>> mIntegerHashSet;
  private final BaseHandler mMainHandler;
  private ConcurrentHashMap<String, Long> mNoCacheUrlKeyAndCacheTimeMap = new ConcurrentHashMap();
  private volatile long mTotalFileSize;
  private ConcurrentHashMap<String, HashSet<Integer>> mUrlKey2AllImageKeyMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, HashSet<Integer>> mUrlKey2DownloadImageKeyMap;
  
  static
  {
    LOCK_mImageGetNullOrCancelHandler = new Object();
    LOCK_CacheMap = new Object();
    boolean bool;
    if (Build.VERSION.SDK_INT >= 14) {
      bool = true;
    } else {
      bool = false;
    }
    IS_ICE_CREAM_SANDWICH = bool;
    isMainProcess = true;
    isInFriendFeed = false;
    hasScrolled = false;
    threadCount = new AtomicInteger(1);
    mDecodeExceptionMap = new HashMap();
    maxDecodeFailCount = -1;
    mCachePath = null;
    storeRootPath = "";
    mSDCardName2PathMap = new HashMap();
    mHasLoadSDCardName = false;
    maxAvailableSizePath = "";
    maxAvailableSize = 0L;
    getAllSDCardInfoRunnable = new ImageManager.10();
    isStorageReallyCanwriteMap = new HashMap();
    mIsRegisterSdcardReceiver = false;
    MAX_SDCARD_SIZE_LIMIT = 104857600L;
    MAX_INNER_SIZE_LIMIT = 41943040L;
    maxCacheSize = MAX_SDCARD_SIZE_LIMIT;
    isUseExternalStorage = true;
    imageFilenameFilter = new ImageManager.12();
    fileTimeComparator = new ImageManager.13();
    mImageDecodeThreadPool = null;
    LOCK_mImageDecodeThreadPool = new Object();
    mImageTaskThreadPool = null;
    LOCK_mImageTaskThreadPool = new Object();
    mLoadAllImageFileFlag = false;
    mFilename2FileLengthMap = new ConcurrentHashMap();
    mLruFilename2TimeMap = new ConcurrentHashMap(50, 0.75F, 8);
    mSaveLruFileTime = 0L;
  }
  
  private ImageManager()
  {
    int k = 0;
    this.mHasEntryNoCacheUrlKeyAndCacheTimeMap = false;
    this.mImageKeyHash2WaitDecodeMap = new HashMap();
    this.mUrlKey2DownloadImageKeyMap = new ConcurrentHashMap();
    this.mIntegerHashSet = new ImageManager.1(this);
    this.mMainHandler = new BaseHandler(Looper.getMainLooper());
    this.mContext = null;
    this.imageMemCacheSize = 1;
    this.checkStorageLowTime = 0L;
    this.isStorageLow = false;
    this.mImageKey2SampleSizeMap = new ConcurrentHashMap();
    this.mImagePath2AttriMap = new ConcurrentHashMap();
    this.MsdCardMountReceiver = new ImageManager.11(this);
    this.mFilename2FileMap = new ConcurrentHashMap();
    this.mTotalFileSize = 0L;
    this.checkOldImageFileAndCleanRunnable = new ImageManager.16(this);
    this.mContext = ImageManagerEnv.getAppContext();
    sCloseNativeAndCache = ImageManagerEnv.g().closeNativeAndinBitmap();
    if (sCloseNativeAndCache) {
      ImageManagerLog.d(TAG, "wns closeNativeAndCache");
    }
    if ((Build.VERSION.SDK_INT >= 21) && ("meizu".equalsIgnoreCase(Build.MANUFACTURER))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      sCloseNativeAndCache = true;
      ImageManagerLog.d(TAG, "isMeizu closeNativeAndCache");
    }
    this.dispatcherLoop = ImageManagerEnv.g().getDispatcher();
    if (this.dispatcherLoop == null)
    {
      localObject = new HandlerThread("Qzone_ImageManager_getnull_or_cancel");
      ((HandlerThread)localObject).start();
      this.dispatcherLoop = ((HandlerThread)localObject).getLooper();
    }
    int m = ((ActivityManager)this.mContext.getSystemService("activity")).getMemoryClass();
    Object localObject = ImageManagerEnv.g().getProcessName(this.mContext);
    isMainProcess = ImageManagerEnv.g().isMainProcess(this.mContext);
    int i = 262144 * m;
    boolean bool;
    if ((localObject != null) && (((String)localObject).contains(":localphoto")))
    {
      i = m * 524288;
      bool = true;
    }
    else
    {
      bool = false;
    }
    int j;
    if (!IS_ICE_CREAM_SANDWICH)
    {
      j = i / 2;
    }
    else if (Build.VERSION.SDK_INT >= 21)
    {
      int n = ImageManagerEnv.g().getMinMemoryClassInArt();
      j = i;
      if (m < n)
      {
        sCloseNativeAndCache = true;
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("minMemory closeNativeAndCache:");
        localStringBuilder.append(m);
        localStringBuilder.append(", minMem: ");
        localStringBuilder.append(n);
        ImageManagerLog.d((String)localObject, localStringBuilder.toString());
        j = i;
      }
    }
    else
    {
      j = i;
      if (bool)
      {
        sCloseNativeAndCache = true;
        j = i;
      }
    }
    i = j - 307200;
    this.imageMemCacheSize = i;
    float f2 = ImageManagerEnv.g().getCacheMemRatio();
    float f1 = f2;
    if (f2 > 1.0F) {
      f1 = 1.0F;
    }
    this.imageMemCacheSize = ((int)(this.imageMemCacheSize * f1));
    localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("imageMemCacheSize: ");
    localStringBuilder.append(this.imageMemCacheSize);
    localStringBuilder.append(" , drawableCacheRatio: ");
    localStringBuilder.append(f1);
    localStringBuilder.append(",memoryclass:");
    localStringBuilder.append(m);
    ImageManagerLog.d((String)localObject, localStringBuilder.toString());
    getDecodeThreadPool();
    ImageOptionSampleSize.setSize(m, i);
    if (Build.VERSION.SDK_INT < 14) {
      sCloseNativeAndCache = true;
    }
    if (!sCloseNativeAndCache) {
      if (Build.VERSION.SDK_INT < 21)
      {
        this.mByteArrayPool = new ByteArrayPool(new ImageManager.2(this, bool));
        this.mDecoder = new DalvikDecoder(this.mByteArrayPool);
        if (!DalvikDecoder.loadSoSucess)
        {
          ImageManagerLog.w(TAG, "load so failed");
          this.mDecoder = null;
          this.mByteArrayPool = null;
          sCloseNativeAndCache = true;
        }
        else
        {
          this.mBitmapFactory = new IBitmapFactory.DalvikBitmapFactory(this.mByteArrayPool, this.mDecoder);
        }
      }
      else
      {
        double d;
        if (ImageDefaultConfig.isQzone(this.mContext))
        {
          j = this.imageMemCacheSize;
          d = j;
          Double.isNaN(d);
          i = (int)(d * 0.4D);
          d = j;
          Double.isNaN(d);
          this.imageMemCacheSize = ((int)(d * 0.6D));
        }
        else if (ImageDefaultConfig.isPicture(this.mContext))
        {
          j = this.imageMemCacheSize;
          d = j;
          Double.isNaN(d);
          i = (int)(d * 0.6D);
          d = j;
          Double.isNaN(d);
          this.imageMemCacheSize = ((int)(d * 0.4D));
        }
        else
        {
          i = k;
          if (ImageDefaultConfig.isMobileQQ(this.mContext))
          {
            j = this.imageMemCacheSize;
            d = j;
            Double.isNaN(d);
            i = (int)(d * 0.3D);
            d = j;
            Double.isNaN(d);
            this.imageMemCacheSize = ((int)(d * 0.5D));
          }
        }
        localObject = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ImageLoader----imageMemCacheSize = ");
        localStringBuilder.append(this.imageMemCacheSize);
        ImageManagerLog.d((String)localObject, localStringBuilder.toString());
        this.mByteArrayPool = new ByteArrayPool(new ImageManager.3(this));
        localObject = new ReuseBitmapCacheProxy(new ImageManager.4(this), i);
        this.mDecoder = new ArtDecoder(this.mByteArrayPool, (BitmapPool)localObject);
        this.mBitmapFactory = new IBitmapFactory.ArtBitmapFactory(this.mByteArrayPool, this.mDecoder);
        BitmapReference.setGlobalReleaser((Releaser)localObject);
      }
    }
    if (this.mDecoder == null)
    {
      this.mDecoder = new DefaultDecoder();
      this.mBitmapFactory = new IBitmapFactory.DefaultBitmapFactory(this.mDecoder);
    }
    localObject = TAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageManager() mDecoder:");
    localStringBuilder.append(this.mDecoder);
    ImageManagerLog.d((String)localObject, localStringBuilder.toString());
    registerSdCardMountReceiver();
    getAllSDCardInfo();
    registerDumpMemoryCacheReceiver();
  }
  
  private void checkOldImageFileAndClean()
  {
    if (!isMainProcess) {
      return;
    }
    if ((mLoadAllImageFileFlag) && (this.mTotalFileSize < maxCacheSize)) {
      return;
    }
    Object localObject1 = getCachePath(this.mContext);
    int n = 0;
    int j;
    int i;
    try
    {
      File localFile = new File(((String)localObject1).replace("imageV2", "image"));
      if ((localFile.exists()) && (localFile.isDirectory()))
      {
        localObject3 = localFile.listFiles();
        if ((localObject3 != null) && (localObject3.length > 0))
        {
          j = localObject3.length;
          i = 0;
          while (i < j)
          {
            localObject3[i].delete();
            i += 1;
          }
        }
        localFile.delete();
      }
    }
    catch (Throwable localThrowable4)
    {
      localThrowable4.printStackTrace();
    }
    Object localObject4 = new ConcurrentHashMap();
    Object localObject3 = new ArrayList();
    Object localObject5;
    int k;
    Integer localInteger;
    try
    {
      localObject1 = new File((String)localObject1);
      if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
      {
        localObject5 = ((File)localObject1).listFiles(imageFilenameFilter);
        if (localObject5 != null)
        {
          i = localObject5.length;
          if (i > 0)
          {
            int m = 0;
            i = 0;
            for (;;)
            {
              j = i;
              k = i;
              try
              {
                if (m >= localObject5.length) {
                  break label361;
                }
                j = i;
                ((ArrayList)localObject3).add(localObject5[m]);
                j = i;
                String str = localObject5[m].getName();
                j = i;
                k = parseInt(str);
                j = i;
                localInteger = (Integer)mFilename2FileLengthMap.get(Integer.valueOf(k));
                localObject1 = localInteger;
                if (localInteger == null)
                {
                  j = i;
                  localObject1 = Integer.valueOf((int)localObject5[m].length());
                  j = i;
                  mFilename2FileLengthMap.put(Integer.valueOf(k), localObject1);
                }
                j = i;
                i += ((Integer)localObject1).intValue();
                j = i;
                ((ConcurrentHashMap)localObject4).put(str, localObject5[m]);
                m += 1;
              }
              catch (Throwable localThrowable1)
              {
                break label354;
              }
            }
          }
        }
      }
      k = 0;
    }
    catch (Throwable localThrowable2)
    {
      j = 0;
      label354:
      localThrowable2.printStackTrace();
      k = j;
    }
    label361:
    this.mTotalFileSize = k;
    this.mFilename2FileMap = ((ConcurrentHashMap)localObject4);
    mLoadAllImageFileFlag = true;
    if (this.mTotalFileSize < maxCacheSize) {
      return;
    }
    boolean bool = Build.MODEL.toLowerCase().contains("vivo");
    for (;;)
    {
      try
      {
        l = ((float)maxCacheSize * 0.8F);
        loadLruFileTime(mLruFilename2TimeMap);
        Collections.sort((List)localObject3, fileTimeComparator);
        i = ((ArrayList)localObject3).size() - 1;
        k = n;
        if (i > 0)
        {
          localObject4 = (File)((ArrayList)localObject3).get(i);
          localObject5 = ((File)localObject4).getName();
          localInteger = (Integer)mFilename2FileLengthMap.remove(Integer.valueOf(parseInt((String)localObject5)));
          Object localObject2 = localInteger;
          if (localInteger == null) {
            localObject2 = Integer.valueOf((int)((File)localObject4).length());
          }
          this.mFilename2FileMap.remove(localObject5);
          this.mTotalFileSize -= ((Integer)localObject2).intValue();
          ((File)localObject4).delete();
          localObject2 = (Integer)mLruFilename2TimeMap.remove(localObject5);
          j = k;
          if (bool)
          {
            k += 1;
            j = k;
            if (k % 20 != 0) {}
          }
        }
      }
      catch (Throwable localThrowable3)
      {
        long l;
        localThrowable3.printStackTrace();
        return;
      }
      try
      {
        Thread.sleep(100L);
        j = k;
      }
      catch (Exception localException)
      {
        j = k;
        continue;
        i -= 1;
        k = j;
      }
      if (this.mTotalFileSize < l)
      {
        forceSaveLruFileTime(mLruFilename2TimeMap, true);
        return;
      }
    }
  }
  
  private void checkSaveLruFileTime(ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    if (isMainProcess)
    {
      long l1 = System.currentTimeMillis();
      long l2 = mSaveLruFileTime;
      if (l2 == 0L)
      {
        mSaveLruFileTime = l1;
        forceSaveLruFileTime(paramConcurrentHashMap, false);
        return;
      }
      if (l1 - l2 > 60000L)
      {
        mSaveLruFileTime = l1;
        forceSaveLruFileTime(paramConcurrentHashMap, false);
      }
    }
  }
  
  private void clearAllImageFile()
  {
    this.mTotalFileSize = 0L;
    this.mFilename2FileMap.clear();
    mFilename2FileLengthMap.clear();
    mLruFilename2TimeMap.clear();
    DecodeImageTask.clearImageKey2SampleSizeMap();
    DecodeImageTask.clearImagePath2AttriMap();
    DecodeImageTask.clearImagePath2RotationMap();
    Object localObject = new File(getCachePath(this.mContext));
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length > 0))
      {
        int i = 0;
        while (i < localObject.length)
        {
          localObject[i].delete();
          i += 1;
        }
      }
    }
  }
  
  private static boolean drawableComputable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      return false;
      if ((paramDrawable instanceof DrawableContainer)) {
        return drawableComputable(((DrawableContainer)paramDrawable).getDrawable());
      }
      if ((paramDrawable instanceof PhotoGifDrawable)) {
        return true;
      }
      if ((paramDrawable instanceof NewGifDrawable)) {
        return true;
      }
      if ((paramDrawable instanceof BitmapDrawable)) {
        return true;
      }
      if ((paramDrawable instanceof BitmapImageDrawable)) {
        return true;
      }
      if ((paramDrawable instanceof SliceBitmapDrawable)) {
        return true;
      }
      if ((paramDrawable instanceof NewAnimationDrawable)) {
        return true;
      }
      if ((paramDrawable instanceof NinePatchRefDrawable)) {
        return true;
      }
    } while (!(paramDrawable instanceof RegionDrawable));
    return true;
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = 1;
    if (i <= 0) {
      i = 1;
    }
    int k = paramDrawable.getIntrinsicHeight();
    if (k > 0) {
      j = k;
    }
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void evictAll()
  {
    if (!ImageManagerEnv.g().isMainProcess(this.mContext)) {
      getDrawableCache().evictAll();
    }
  }
  
  /* Error */
  private void forceSaveLruFileTime(ConcurrentHashMap<String, Integer> paramConcurrentHashMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 883	java/util/concurrent/ConcurrentHashMap:size	()I
    //   4: ifle +244 -> 248
    //   7: new 201	java/util/HashMap
    //   10: dup
    //   11: invokespecial 202	java/util/HashMap:<init>	()V
    //   14: astore 4
    //   16: aload 4
    //   18: aload_1
    //   19: invokevirtual 887	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   22: aload_1
    //   23: invokevirtual 789	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   26: new 440	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 441	java/lang/StringBuilder:<init>	()V
    //   33: astore_1
    //   34: aload_1
    //   35: aload_0
    //   36: getfield 327	com/tencent/component/media/image/ImageManager:mContext	Landroid/content/Context;
    //   39: invokestatic 680	com/tencent/component/media/image/ImageManager:getCachePath	(Landroid/content/Context;)Ljava/lang/String;
    //   42: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: ldc 47
    //   49: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_1
    //   54: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: astore_3
    //   58: aconst_null
    //   59: astore 5
    //   61: aconst_null
    //   62: astore_1
    //   63: iload_2
    //   64: ifne +8 -> 72
    //   67: iconst_1
    //   68: istore_2
    //   69: goto +5 -> 74
    //   72: iconst_0
    //   73: istore_2
    //   74: new 889	java/io/FileOutputStream
    //   77: dup
    //   78: aload_3
    //   79: iload_2
    //   80: invokespecial 892	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   83: astore_3
    //   84: new 440	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 441	java/lang/StringBuilder:<init>	()V
    //   91: astore_1
    //   92: aload 4
    //   94: invokevirtual 896	java/util/HashMap:keySet	()Ljava/util/Set;
    //   97: invokeinterface 902 1 0
    //   102: astore 5
    //   104: aload 5
    //   106: invokeinterface 907 1 0
    //   111: ifeq +53 -> 164
    //   114: aload 5
    //   116: invokeinterface 911 1 0
    //   121: checkcast 386	java/lang/String
    //   124: astore 6
    //   126: aload_1
    //   127: aload 6
    //   129: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: ldc_w 913
    //   137: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: aload 4
    //   144: aload 6
    //   146: invokevirtual 914	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   149: invokevirtual 577	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_1
    //   154: ldc_w 916
    //   157: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: goto -57 -> 104
    //   164: aload_3
    //   165: aload_1
    //   166: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokevirtual 920	java/lang/String:getBytes	()[B
    //   172: invokevirtual 924	java/io/FileOutputStream:write	([B)V
    //   175: aload_3
    //   176: invokevirtual 927	java/io/FileOutputStream:flush	()V
    //   179: aload_3
    //   180: invokevirtual 930	java/io/FileOutputStream:close	()V
    //   183: return
    //   184: astore_1
    //   185: goto +45 -> 230
    //   188: astore 4
    //   190: goto +18 -> 208
    //   193: astore 4
    //   195: aload_1
    //   196: astore_3
    //   197: aload 4
    //   199: astore_1
    //   200: goto +30 -> 230
    //   203: astore 4
    //   205: aload 5
    //   207: astore_3
    //   208: aload_3
    //   209: astore_1
    //   210: aload 4
    //   212: invokevirtual 931	java/lang/Exception:printStackTrace	()V
    //   215: aload_3
    //   216: ifnull +32 -> 248
    //   219: aload_3
    //   220: invokevirtual 930	java/io/FileOutputStream:close	()V
    //   223: return
    //   224: astore_1
    //   225: aload_1
    //   226: invokevirtual 932	java/io/IOException:printStackTrace	()V
    //   229: return
    //   230: aload_3
    //   231: ifnull +15 -> 246
    //   234: aload_3
    //   235: invokevirtual 930	java/io/FileOutputStream:close	()V
    //   238: goto +8 -> 246
    //   241: astore_3
    //   242: aload_3
    //   243: invokevirtual 932	java/io/IOException:printStackTrace	()V
    //   246: aload_1
    //   247: athrow
    //   248: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	ImageManager
    //   0	249	1	paramConcurrentHashMap	ConcurrentHashMap<String, Integer>
    //   0	249	2	paramBoolean	boolean
    //   57	178	3	localObject1	Object
    //   241	2	3	localIOException	java.io.IOException
    //   14	129	4	localHashMap	HashMap
    //   188	1	4	localException1	Exception
    //   193	5	4	localObject2	Object
    //   203	8	4	localException2	Exception
    //   59	147	5	localIterator	Iterator
    //   124	21	6	str	String
    // Exception table:
    //   from	to	target	type
    //   84	104	184	finally
    //   104	161	184	finally
    //   164	179	184	finally
    //   84	104	188	java/lang/Exception
    //   104	161	188	java/lang/Exception
    //   164	179	188	java/lang/Exception
    //   74	84	193	finally
    //   210	215	193	finally
    //   74	84	203	java/lang/Exception
    //   179	183	224	java/io/IOException
    //   219	223	224	java/io/IOException
    //   234	238	241	java/io/IOException
  }
  
  private Drawable get(int paramInt)
  {
    if (!ImageManagerEnv.g().isQQProcess(this.mContext)) {
      return (Drawable)getDrawableCache().get(Integer.valueOf(paramInt));
    }
    Object localObject = ImageManagerEnv.g().getQQImagecache();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localObject = ((MQLruCache)localObject).get(localStringBuilder.toString());
    if ((localObject != null) && ((localObject instanceof Drawable))) {
      return (Drawable)localObject;
    }
    return null;
  }
  
  private void getAllSDCardInfo()
  {
    if (mHasLoadSDCardName) {
      return;
    }
    mHasLoadSDCardName = true;
    imageGetNullOrCancelHandler().postDelayed(new ImageManager.9(this), 10000L);
  }
  
  @Public
  public static String getCachePath(Context paramContext)
  {
    if (mCachePath == null) {
      try
      {
        if (mCachePath == null) {
          mCachePath = getStorePath(paramContext, "imageV2", false, false);
        }
      }
      finally {}
    }
    return mCachePath;
  }
  
  @Public
  public static String getCachePath(Context paramContext, String paramString)
  {
    return getStorePath(paramContext, paramString, false, false);
  }
  
  private static String getCachePathNocache(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getCachePath(paramContext));
    localStringBuilder.append("nocache");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  private static String getCachePathNocacheOrCreateIfInexistence(Context paramContext)
  {
    paramContext = getCachePathNocache(paramContext);
    File localFile = new File(paramContext);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    return paramContext;
  }
  
  @Public
  public static String getCachePathSR(Context paramContext)
  {
    if (sCachePath4SuperResolution == null) {
      try
      {
        if (sCachePath4SuperResolution == null) {
          sCachePath4SuperResolution = getStorePath(paramContext, "image_sr", false, false);
        }
      }
      finally {}
    }
    return sCachePath4SuperResolution;
  }
  
  private static Executor getDecodeThreadPool()
  {
    if (mImageDecodeThreadPool == null)
    {
      int i = ImageManagerEnv.g().getDecodeThreadNum(isMainProcess);
      mImageDecodeThreadPool = ImageManagerEnv.g().getExecutor();
      if (mImageDecodeThreadPool == null) {
        mImageDecodeThreadPool = Executors.newFixedThreadPool(i, new ImageManager.14());
      }
    }
    return mImageDecodeThreadPool;
  }
  
  private static int getDrawableAllocSize(Drawable paramDrawable)
  {
    int j = 0;
    if (paramDrawable == null) {
      return 0;
    }
    if ((paramDrawable instanceof DrawableContainer)) {
      return getDrawableAllocSize(((DrawableContainer)paramDrawable).getDrawable());
    }
    if ((paramDrawable instanceof PhotoGifDrawable)) {
      return 0;
    }
    if ((paramDrawable instanceof NewGifDrawable)) {
      return (int)((NewGifDrawable)paramDrawable).getAllocationByteCount();
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return BitmapUtils.getBitmapAllocSize(((BitmapDrawable)paramDrawable).getBitmap());
    }
    if ((paramDrawable instanceof BitmapImageDrawable)) {
      return ((BitmapImageDrawable)paramDrawable).size();
    }
    if ((paramDrawable instanceof SliceBitmapDrawable)) {
      return ((SliceBitmapDrawable)paramDrawable).getByteCount();
    }
    if ((paramDrawable instanceof NewAnimationDrawable)) {
      return ((NewAnimationDrawable)paramDrawable).getByteCount();
    }
    int i;
    if ((paramDrawable instanceof NinePatchRefDrawable))
    {
      paramDrawable = ((NinePatchRefDrawable)paramDrawable).getBitmapRef();
      i = j;
      if (paramDrawable != null)
      {
        paramDrawable = paramDrawable.getBitmap();
        i = j;
        if (paramDrawable != null) {
          return BitmapUtils.getBitmapAllocSize(paramDrawable);
        }
      }
    }
    else if ((paramDrawable instanceof RegionDrawable))
    {
      paramDrawable = ((RegionDrawable)paramDrawable).getBitmapRef();
      i = j;
      if (paramDrawable != null)
      {
        paramDrawable = paramDrawable.getBitmap();
        i = j;
        if (paramDrawable != null) {
          return BitmapUtils.getBitmapAllocSize(paramDrawable);
        }
      }
    }
    else
    {
      j = paramDrawable.getIntrinsicHeight();
      int k = paramDrawable.getIntrinsicWidth();
      i = j;
      if (j < 1) {
        i = 1;
      }
      j = k;
      if (k < 1) {
        j = 1;
      }
      i = j * i * 4;
    }
    return i;
  }
  
  private LruCache<Integer, Drawable> getDrawableCache()
  {
    if (this.mImageKeyHash2DrawableMap == null) {
      synchronized (LOCK_CacheMap)
      {
        if (this.mImageKeyHash2DrawableMap == null) {
          this.mImageKeyHash2DrawableMap = new ImageManager.6(this, this.imageMemCacheSize);
        }
      }
    }
    return this.mImageKeyHash2DrawableMap;
  }
  
  public static String getErrorString(ImageKey paramImageKey, int paramInt)
  {
    if (paramImageKey != null)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("问题描述", ImageTaskConst.getImageTaskErrorDescription(paramInt));
        localJSONObject.put("failCode", String.valueOf(paramInt));
        localJSONObject.put("filePath", paramImageKey.filePath);
        localJSONObject.put("url", paramImageKey.url);
        paramImageKey = localJSONObject.toString();
        return paramImageKey;
      }
      catch (JSONException paramImageKey)
      {
        paramImageKey.printStackTrace();
      }
    }
    return null;
  }
  
  private LruCache<Integer, Image> getImageCache()
  {
    if (this.mImageKeyHash2ImageMap == null) {
      synchronized (LOCK_CacheMap)
      {
        if (this.mImageKeyHash2ImageMap == null) {
          this.mImageKeyHash2ImageMap = new ImageManager.7(this, this.imageMemCacheSize);
        }
      }
    }
    return this.mImageKeyHash2ImageMap;
  }
  
  public static ImageManager getInstance()
  {
    if (mInstance == null) {
      synchronized (LOCK_mInstance)
      {
        if (mInstance == null) {
          mInstance = new ImageManager();
        }
      }
    }
    return mInstance;
  }
  
  public static ImageManager getInstance(Context paramContext)
  {
    return getInstance();
  }
  
  public static File getLocalFileByUrl(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (TextUtils.isEmpty(paramString2)) {
      paramContext = getCachePath(paramContext);
    } else {
      paramContext = getCachePath(paramContext, paramString2);
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramContext);
    paramString2.append(File.separator);
    paramString2.append(String.valueOf(ImageKey.getUrlKey(paramString1, false).hashCode()));
    paramContext = new File(paramString2.toString());
    SharpPUtils.deleteSharppCacheFileIfNessary(paramContext, paramString1);
    return paramContext;
  }
  
  private String getNocacheFilePath(ImageKey paramImageKey, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getCachePathNocacheOrCreateIfInexistence(this.mContext));
      localStringBuilder.append(urlKey2FileName(paramImageKey.urlKey, true));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getCachePathNocache(this.mContext));
    localStringBuilder.append(urlKey2FileName(paramImageKey.urlKey, true));
    return localStringBuilder.toString();
  }
  
  public static String getStorePath(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = "";
    Object localObject1 = str1;
    Object localObject3;
    try
    {
      String str2 = Environment.getExternalStorageState();
      localObject1 = str1;
      maxCacheSize = MAX_INNER_SIZE_LIMIT;
      localObject1 = str1;
      isUseExternalStorage = false;
      Object localObject2 = str1;
      if (!paramBoolean1)
      {
        localObject1 = str1;
        localObject2 = str1;
        if ("mounted".equals(str2))
        {
          localObject1 = str1;
          localObject2 = str1;
          if (paramContext.getExternalCacheDir().canWrite())
          {
            localObject1 = str1;
            storeRootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
            localObject1 = str1;
            str1 = ImageManagerEnv.g().getImageCacheDir(true);
            localObject2 = str1;
            localObject1 = str1;
            if (TextUtils.isEmpty(str1))
            {
              localObject1 = str1;
              localObject2 = new StringBuilder();
              localObject1 = str1;
              ((StringBuilder)localObject2).append(paramContext.getExternalCacheDir());
              localObject1 = str1;
              ((StringBuilder)localObject2).append(File.separator);
              localObject1 = str1;
              ((StringBuilder)localObject2).append("qzone");
              localObject1 = str1;
              localObject2 = ((StringBuilder)localObject2).toString();
            }
            localObject1 = localObject2;
            maxCacheSize = MAX_SDCARD_SIZE_LIMIT;
            localObject1 = localObject2;
            isUseExternalStorage = true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject3 = localObject1;
    }
    if (!isUseExternalStorage)
    {
      storeRootPath = Environment.getDataDirectory().getAbsolutePath();
      localObject1 = ImageManagerEnv.g().getImageCacheDir(false);
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramContext.getCacheDir().getAbsolutePath());
        ((StringBuilder)localObject1).append(File.separator);
        ((StringBuilder)localObject1).append("qzone");
        localObject3 = ((StringBuilder)localObject1).toString();
      }
    }
    paramContext = paramString;
    if (!paramString.startsWith(File.separator))
    {
      paramContext = new StringBuilder();
      paramContext.append(File.separator);
      paramContext.append(paramString);
      paramContext = paramContext.toString();
    }
    paramString = paramContext;
    if (!paramContext.endsWith(File.separator))
    {
      paramString = new StringBuilder();
      paramString.append(paramContext);
      paramString.append(File.separator);
      paramString = paramString.toString();
    }
    paramContext = new StringBuilder();
    paramContext.append((String)localObject3);
    paramContext.append(paramString);
    paramContext = new File(paramContext.toString());
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    paramString = paramContext.getAbsolutePath();
    paramContext = paramString;
    if (!paramString.endsWith(File.separator))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append(File.separator);
      paramContext = paramContext.toString();
    }
    return paramContext;
  }
  
  public static Handler getSuperResolutionHandler()
  {
    if (mSuperResolutionHandler == null) {
      try
      {
        if (mSuperResolutionHandler == null)
        {
          mImageSuperResolutionHandlerThread = new HandlerThread("super_resolution_handler_thread");
          mImageSuperResolutionHandlerThread.start();
          mSuperResolutionHandler = new ImageManager.15(mImageSuperResolutionHandlerThread.getLooper());
        }
      }
      finally {}
    }
    return mSuperResolutionHandler;
  }
  
  private void handleDumpMemoryCacheBroadcast(Message paramMessage)
  {
    try
    {
      int i = paramMessage.arg1;
      int j = paramMessage.arg2;
      if (this.mImageKeyHash2DrawableMap != null)
      {
        paramMessage = this.mImageKeyHash2DrawableMap.snapshot();
        if (paramMessage != null)
        {
          Object localObject1 = TAG;
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("memory cache, cache size = ");
          ((StringBuilder)localObject2).append(this.imageMemCacheSize);
          ((StringBuilder)localObject2).append(", length = ");
          ((StringBuilder)localObject2).append(paramMessage.size());
          ((StringBuilder)localObject2).append(", cache info = ");
          ((StringBuilder)localObject2).append(this.mImageKeyHash2DrawableMap.toString());
          ImageManagerLog.w((String)localObject1, ((StringBuilder)localObject2).toString());
          localObject1 = paramMessage.entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Map.Entry)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              int k = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
              int m = getDrawableAllocSize((Drawable)((Map.Entry)localObject2).getValue());
              localObject2 = (String)this.mImageKeyHash2UrlMap.get(Integer.valueOf(k));
              String str = TAG;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("memory cache, key = ");
              localStringBuilder.append(k);
              localStringBuilder.append(", drawable size = ");
              localStringBuilder.append(m);
              localStringBuilder.append(", url = ");
              localStringBuilder.append((String)localObject2);
              ImageManagerLog.w(str, localStringBuilder.toString());
            }
          }
        }
        saveBitmapToSdcard(i, paramMessage, j);
        return;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
  }
  
  private void handleIamgeTracer(Message paramMessage)
  {
    if ((paramMessage.obj instanceof ImageKey))
    {
      if (paramMessage.arg1 == 16)
      {
        ImageTaskTracer.traceImageGet((ImageKey)paramMessage.obj, true);
        return;
      }
      ImageTaskTracer.traceImageGet((ImageKey)paramMessage.obj, false);
    }
  }
  
  private void handleImageGetNull(Message paramMessage)
  {
    if ((paramMessage.obj instanceof ImageKey))
    {
      paramMessage = (ImageKey)paramMessage.obj;
      paramMessage.options = ImageLoader.Options.copy(paramMessage.options);
      if (paramMessage.flag == 0)
      {
        paramMessage.recycle();
        return;
      }
      if ((paramMessage.isSuperResolutionUrl) && (!paramMessage.isHighScaleUrl) && (!TextUtils.isEmpty(paramMessage.bigUrl)))
      {
        localObject1 = ImageKey.getUrlKey(paramMessage.bigUrl, true);
        Object localObject2 = getCachePath(this.mContext);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(urlKey2FileName((String)localObject1, true));
        localObject1 = new File(localStringBuilder.toString());
        if ((ImageManagerEnv.g().enableSuperResolution()) && (!((File)localObject1).exists()))
        {
          if (!ImageManagerEnv.g().hasSuperResolutionInit())
          {
            localObject1 = getCachePathSR(this.mContext);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(urlKey2FileName(paramMessage.urlKey, true));
            if (!new File(((StringBuilder)localObject2).toString()).exists())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("library not init. use big url. url=");
              ((StringBuilder)localObject1).append(paramMessage.url);
              ImageManagerLog.w("superresolution", ((StringBuilder)localObject1).toString());
              paramMessage.srUrl = paramMessage.url;
              paramMessage.setUrl(paramMessage.bigUrl);
              getSuperResolutionHandler().post(new ImageManager.8(this));
            }
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("big cache file exists. url=");
          ((StringBuilder)localObject1).append(paramMessage.url);
          ImageManagerLog.w("superresolution", ((StringBuilder)localObject1).toString());
          paramMessage.srUrl = paramMessage.url;
          paramMessage.setUrl(paramMessage.bigUrl);
        }
      }
      Object localObject1 = ImageTaskBuilder.buildImageTask(paramMessage);
      ImageTaskTracer.removeImageMsgGetNullRecord(paramMessage.hashCodeEx());
      if (localObject1 != null) {
        ((ImageTask)localObject1).excuteTask();
      }
    }
  }
  
  private void handlerImageCancelMessage(Message paramMessage)
  {
    if ((paramMessage.obj instanceof ImageKey))
    {
      paramMessage = (ImageKey)paramMessage.obj;
      paramMessage.options = ImageLoader.Options.copy(paramMessage.options);
      ImageTracer.cancel(paramMessage.url);
      ImageTaskManager.cancelImageTask(paramMessage);
      ImageTaskManager.getInstance().cancelDownload(paramMessage.url);
    }
  }
  
  private void handlerImageDecodeMessage(ImageKey paramImageKey) {}
  
  private BaseHandler imageGetNullOrCancelHandler()
  {
    if (this.mImageGetNullOrCancelHandler == null) {
      synchronized (LOCK_mImageGetNullOrCancelHandler)
      {
        if (this.mImageGetNullOrCancelHandler == null) {
          this.mImageGetNullOrCancelHandler = new ImageManager.5(this, this.dispatcherLoop);
        }
      }
    }
    return this.mImageGetNullOrCancelHandler;
  }
  
  public static void invalidateMemCache(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      INVALIDATE_URLS.put(paramString, Boolean.TRUE);
    }
  }
  
  private boolean isAvailableStorageSizeLow()
  {
    boolean bool = false;
    try
    {
      StatFs localStatFs = new StatFs(storeRootPath);
      long l = localStatFs.getAvailableBlocks();
      int i = localStatFs.getBlockSize();
      if (l * i < 5242880L) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  public static boolean isNetworkUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
    {
      if (URLUtil.isFileUrl(paramString)) {
        return false;
      }
      if (paramString.startsWith("avatar://")) {
        return false;
      }
      return URLUtil.isNetworkUrl(paramString);
    }
    return true;
  }
  
  /* Error */
  private static boolean isStorageReallyCanwrite(String paramString)
  {
    // Byte code:
    //   0: getstatic 227	com/tencent/component/media/image/ImageManager:isStorageReallyCanwriteMap	Ljava/util/HashMap;
    //   3: aload_0
    //   4: invokevirtual 914	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: checkcast 1299	java/lang/Boolean
    //   10: astore 5
    //   12: aload 5
    //   14: ifnull +9 -> 23
    //   17: aload 5
    //   19: invokevirtual 1332	java/lang/Boolean:booleanValue	()Z
    //   22: ireturn
    //   23: iconst_0
    //   24: istore_2
    //   25: invokestatic 1336	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   28: invokevirtual 1339	java/lang/Thread:getId	()J
    //   31: lstore_3
    //   32: new 440	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 441	java/lang/StringBuilder:<init>	()V
    //   39: astore 5
    //   41: aload 5
    //   43: aload_0
    //   44: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 5
    //   50: ldc_w 1341
    //   53: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 5
    //   59: lload_3
    //   60: invokevirtual 1344	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: new 682	java/io/File
    //   67: dup
    //   68: aload 5
    //   70: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokespecial 687	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore 5
    //   78: aload 5
    //   80: invokevirtual 690	java/io/File:exists	()Z
    //   83: ifeq +22 -> 105
    //   86: iload_2
    //   87: istore_1
    //   88: aload 5
    //   90: invokevirtual 700	java/io/File:delete	()Z
    //   93: ifeq +34 -> 127
    //   96: aload 5
    //   98: invokevirtual 1347	java/io/File:createNewFile	()Z
    //   101: istore_1
    //   102: goto +25 -> 127
    //   105: aload 5
    //   107: invokevirtual 1347	java/io/File:createNewFile	()Z
    //   110: istore_1
    //   111: goto +16 -> 127
    //   114: astore_0
    //   115: goto +32 -> 147
    //   118: astore 6
    //   120: aload 6
    //   122: invokevirtual 703	java/lang/Throwable:printStackTrace	()V
    //   125: iload_2
    //   126: istore_1
    //   127: aload 5
    //   129: invokevirtual 700	java/io/File:delete	()Z
    //   132: pop
    //   133: getstatic 227	com/tencent/component/media/image/ImageManager:isStorageReallyCanwriteMap	Ljava/util/HashMap;
    //   136: aload_0
    //   137: iload_1
    //   138: invokestatic 1350	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   141: invokevirtual 1351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   144: pop
    //   145: iload_1
    //   146: ireturn
    //   147: aload 5
    //   149: invokevirtual 700	java/io/File:delete	()Z
    //   152: pop
    //   153: aload_0
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramString	String
    //   87	59	1	bool1	boolean
    //   24	102	2	bool2	boolean
    //   31	29	3	l	long
    //   10	138	5	localObject	Object
    //   118	3	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   78	86	114	finally
    //   88	102	114	finally
    //   105	111	114	finally
    //   120	125	114	finally
    //   78	86	118	java/lang/Throwable
    //   88	102	118	java/lang/Throwable
    //   105	111	118	java/lang/Throwable
  }
  
  private void loadLruFileTime(ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(getCachePath(this.mContext));
    ((StringBuilder)localObject1).append("imagelru.usetime");
    localObject1 = ((StringBuilder)localObject1).toString();
    try
    {
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).exists())
      {
        localObject1 = new BufferedReader(new FileReader((File)localObject1));
        for (;;)
        {
          String str = ((BufferedReader)localObject1).readLine();
          if (str == null) {
            break;
          }
          Object localObject2 = str.split("|");
          if ((localObject2 != null) && (localObject2.length == 2))
          {
            str = localObject2[0];
            int i = Integer.parseInt(localObject2[1]);
            localObject2 = (Integer)paramConcurrentHashMap.get(str);
            if (localObject2 == null) {
              paramConcurrentHashMap.put(str, Integer.valueOf(i));
            } else if (i > ((Integer)localObject2).intValue()) {
              paramConcurrentHashMap.put(str, Integer.valueOf(i));
            }
          }
        }
      }
      return;
    }
    catch (Throwable paramConcurrentHashMap)
    {
      paramConcurrentHashMap.printStackTrace();
    }
  }
  
  private static int parseInt(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      label7:
      break label7;
    }
    return 0;
  }
  
  public static void post(Runnable paramRunnable, boolean paramBoolean)
  {
    getDecodeThreadPool().execute(new ImageManager.Job(paramRunnable, paramBoolean));
  }
  
  private static String processIpformat(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "-";
    }
    Object localObject = Arrays.asList(paramString.split("\\."));
    paramString = new StringBuilder();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (str != null)
      {
        paramString.append(str);
        if ((((Iterator)localObject).hasNext()) && (str.length() < 3)) {
          paramString.append("-");
        }
      }
    }
    return paramString.toString();
  }
  
  private void put(int paramInt, Drawable paramDrawable)
  {
    if (!ImageManagerEnv.g().isQQProcess(this.mContext))
    {
      getDrawableCache().put(Integer.valueOf(paramInt), paramDrawable);
      return;
    }
    MQLruCache localMQLruCache = ImageManagerEnv.g().getQQImagecache();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localMQLruCache.put(localStringBuilder.toString(), paramDrawable);
  }
  
  private void putImageKey(Map<Integer, HashSet<ImageKey>> paramMap, int paramInt, ImageKey paramImageKey)
  {
    if (paramMap != null)
    {
      if (paramImageKey == null) {
        return;
      }
      HashSet localHashSet2 = (HashSet)paramMap.get(Integer.valueOf(paramInt));
      HashSet localHashSet1 = localHashSet2;
      if (localHashSet2 == null)
      {
        localHashSet1 = new HashSet();
        paramMap.put(Integer.valueOf(paramInt), localHashSet1);
      }
      localHashSet1.add(paramImageKey);
    }
  }
  
  private void putImageKeyList(Map<Integer, HashSet<ImageKey>> paramMap, int paramInt, HashSet<ImageKey> paramHashSet)
  {
    if (paramMap != null)
    {
      if (paramHashSet == null) {
        return;
      }
      HashSet localHashSet2 = (HashSet)paramMap.get(Integer.valueOf(paramInt));
      HashSet localHashSet1 = localHashSet2;
      if (localHashSet2 == null)
      {
        localHashSet1 = new HashSet();
        paramMap.put(Integer.valueOf(paramInt), localHashSet1);
      }
      localHashSet1.addAll(paramHashSet);
    }
  }
  
  private void registerDumpMemoryCacheReceiver()
  {
    try
    {
      if (this.mContext == null) {
        return;
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.qzone.dumpmemorycache");
      this.mContext.registerReceiver(new ImageManager.18(this), localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void registerSdCardMountReceiver()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
      localIntentFilter.addAction("android.intent.action.MEDIA_EJECT");
      localIntentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
      localIntentFilter.addAction("android.intent.action.MEDIA_REMOVED");
      localIntentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
      localIntentFilter.addDataScheme("file");
      this.mContext.registerReceiver(this.MsdCardMountReceiver, localIntentFilter);
      mIsRegisterSdcardReceiver = true;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void remove(int paramInt)
  {
    if (!ImageManagerEnv.g().isQQProcess(this.mContext))
    {
      getDrawableCache().remove(Integer.valueOf(paramInt));
      return;
    }
    MQLruCache localMQLruCache = ImageManagerEnv.g().getQQImagecache();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localMQLruCache.remove(localStringBuilder.toString());
  }
  
  static boolean removeInvalidatedUrl(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (INVALIDATE_URLS.remove(paramString) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  private void saveBitmapToSdcard(int paramInt1, Map<Integer, Drawable> paramMap, int paramInt2)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifeq +292 -> 293
    //   4: aload_2
    //   5: ifnull +288 -> 293
    //   8: aload_2
    //   9: iload_1
    //   10: invokestatic 726	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: invokeinterface 1404 2 0
    //   18: checkcast 834	android/graphics/drawable/Drawable
    //   21: invokestatic 1452	com/tencent/component/media/image/ImageManager:drawableToBitmap	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   24: astore 5
    //   26: invokestatic 1115	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   29: invokevirtual 1118	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   32: astore_2
    //   33: new 440	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 441	java/lang/StringBuilder:<init>	()V
    //   40: astore 4
    //   42: aload 4
    //   44: aload_2
    //   45: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 4
    //   51: getstatic 965	java/io/File:separator	Ljava/lang/String;
    //   54: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 4
    //   60: ldc_w 1124
    //   63: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: new 682	java/io/File
    //   70: dup
    //   71: aload 4
    //   73: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokespecial 687	java/io/File:<init>	(Ljava/lang/String;)V
    //   79: astore 4
    //   81: aload 4
    //   83: invokevirtual 690	java/io/File:exists	()Z
    //   86: ifne +9 -> 95
    //   89: aload 4
    //   91: invokevirtual 1139	java/io/File:mkdirs	()Z
    //   94: pop
    //   95: iload_3
    //   96: ifne +33 -> 129
    //   99: new 440	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 441	java/lang/StringBuilder:<init>	()V
    //   106: astore_2
    //   107: aload_2
    //   108: iload_1
    //   109: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: ldc_w 1454
    //   117: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_2
    //   122: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_2
    //   126: goto +30 -> 156
    //   129: new 440	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 441	java/lang/StringBuilder:<init>	()V
    //   136: astore_2
    //   137: aload_2
    //   138: iload_1
    //   139: invokevirtual 450	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_2
    //   144: ldc_w 1456
    //   147: invokevirtual 447	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_2
    //   152: invokevirtual 456	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: astore_2
    //   156: new 682	java/io/File
    //   159: dup
    //   160: aload 4
    //   162: aload_2
    //   163: invokespecial 1458	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   166: astore_2
    //   167: new 889	java/io/FileOutputStream
    //   170: dup
    //   171: aload_2
    //   172: invokespecial 1459	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   175: astore 4
    //   177: iload_3
    //   178: ifne +22 -> 200
    //   181: aload 4
    //   183: astore_2
    //   184: aload 5
    //   186: getstatic 1465	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   189: bipush 100
    //   191: aload 4
    //   193: invokevirtual 1469	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   196: pop
    //   197: goto +19 -> 216
    //   200: aload 4
    //   202: astore_2
    //   203: aload 5
    //   205: getstatic 1472	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   208: bipush 100
    //   210: aload 4
    //   212: invokevirtual 1469	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   215: pop
    //   216: aload 4
    //   218: astore_2
    //   219: aload 4
    //   221: invokevirtual 927	java/io/FileOutputStream:flush	()V
    //   224: aload 4
    //   226: invokevirtual 930	java/io/FileOutputStream:close	()V
    //   229: return
    //   230: astore 5
    //   232: goto +15 -> 247
    //   235: astore 4
    //   237: aconst_null
    //   238: astore_2
    //   239: goto +35 -> 274
    //   242: astore 5
    //   244: aconst_null
    //   245: astore 4
    //   247: aload 4
    //   249: astore_2
    //   250: aload 5
    //   252: invokevirtual 932	java/io/IOException:printStackTrace	()V
    //   255: aload 4
    //   257: ifnull +36 -> 293
    //   260: aload 4
    //   262: invokevirtual 930	java/io/FileOutputStream:close	()V
    //   265: return
    //   266: astore_2
    //   267: aload_2
    //   268: invokevirtual 931	java/lang/Exception:printStackTrace	()V
    //   271: return
    //   272: astore 4
    //   274: aload_2
    //   275: ifnull +15 -> 290
    //   278: aload_2
    //   279: invokevirtual 930	java/io/FileOutputStream:close	()V
    //   282: goto +8 -> 290
    //   285: astore_2
    //   286: aload_2
    //   287: invokevirtual 931	java/lang/Exception:printStackTrace	()V
    //   290: aload 4
    //   292: athrow
    //   293: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	ImageManager
    //   0	294	1	paramInt1	int
    //   0	294	2	paramMap	Map<Integer, Drawable>
    //   0	294	3	paramInt2	int
    //   40	185	4	localObject1	Object
    //   235	1	4	localObject2	Object
    //   245	16	4	localObject3	Object
    //   272	19	4	localObject4	Object
    //   24	180	5	localBitmap	Bitmap
    //   230	1	5	localIOException1	java.io.IOException
    //   242	9	5	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   184	197	230	java/io/IOException
    //   203	216	230	java/io/IOException
    //   219	224	230	java/io/IOException
    //   167	177	235	finally
    //   167	177	242	java/io/IOException
    //   224	229	266	java/lang/Exception
    //   260	265	266	java/lang/Exception
    //   184	197	272	finally
    //   203	216	272	finally
    //   219	224	272	finally
    //   250	255	272	finally
    //   278	282	285	java/lang/Exception
  }
  
  public static void stopAllSuperResolutionTasks()
  {
    if (mSuperResolutionHandler != null) {
      mSuperResolutionHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private void unregisterSdCardMountReceiver()
  {
    try
    {
      if (mIsRegisterSdcardReceiver)
      {
        this.mContext.unregisterReceiver(this.MsdCardMountReceiver);
        mIsRegisterSdcardReceiver = false;
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  private static void updateStorage(String paramString)
  {
    // Byte code:
    //   0: new 682	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 687	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 690	java/io/File:exists	()Z
    //   13: ifeq +162 -> 175
    //   16: new 1353	java/io/BufferedReader
    //   19: dup
    //   20: new 1355	java/io/FileReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 1358	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: invokespecial 1361	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 1364	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +71 -> 111
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc_w 1485
    //   49: invokevirtual 1133	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   52: ifeq -20 -> 32
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 1487
    //   61: invokevirtual 1368	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   64: astore_3
    //   65: aload_1
    //   66: astore_0
    //   67: aload_3
    //   68: arraylength
    //   69: iconst_3
    //   70: if_icmplt -38 -> 32
    //   73: aload_3
    //   74: iconst_2
    //   75: aaload
    //   76: astore_2
    //   77: aload_3
    //   78: iconst_1
    //   79: aaload
    //   80: astore_3
    //   81: aload_1
    //   82: astore_0
    //   83: new 682	java/io/File
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 687	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: invokevirtual 690	java/io/File:exists	()Z
    //   94: ifeq -62 -> 32
    //   97: aload_1
    //   98: astore_0
    //   99: getstatic 214	com/tencent/component/media/image/ImageManager:mSDCardName2PathMap	Ljava/util/HashMap;
    //   102: aload_3
    //   103: aload_2
    //   104: invokevirtual 1351	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: goto -76 -> 32
    //   111: aload_1
    //   112: astore_0
    //   113: aload_1
    //   114: invokevirtual 1488	java/io/BufferedReader:close	()V
    //   117: aload_1
    //   118: invokevirtual 1488	java/io/BufferedReader:close	()V
    //   121: return
    //   122: astore_2
    //   123: goto +12 -> 135
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_0
    //   129: goto +28 -> 157
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: astore_0
    //   137: aload_2
    //   138: invokevirtual 931	java/lang/Exception:printStackTrace	()V
    //   141: aload_1
    //   142: ifnull +33 -> 175
    //   145: aload_1
    //   146: invokevirtual 1488	java/io/BufferedReader:close	()V
    //   149: return
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 932	java/io/IOException:printStackTrace	()V
    //   155: return
    //   156: astore_1
    //   157: aload_0
    //   158: ifnull +15 -> 173
    //   161: aload_0
    //   162: invokevirtual 1488	java/io/BufferedReader:close	()V
    //   165: goto +8 -> 173
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 932	java/io/IOException:printStackTrace	()V
    //   173: aload_1
    //   174: athrow
    //   175: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramString	String
    //   31	87	1	localBufferedReader	BufferedReader
    //   126	1	1	localObject1	Object
    //   134	12	1	localObject2	Object
    //   156	18	1	localObject3	Object
    //   38	66	2	str	String
    //   122	1	2	localException1	Exception
    //   132	6	2	localException2	Exception
    //   64	39	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   34	39	122	java/lang/Exception
    //   45	55	122	java/lang/Exception
    //   57	65	122	java/lang/Exception
    //   67	73	122	java/lang/Exception
    //   83	97	122	java/lang/Exception
    //   99	108	122	java/lang/Exception
    //   113	117	122	java/lang/Exception
    //   16	32	126	finally
    //   16	32	132	java/lang/Exception
    //   117	121	150	java/io/IOException
    //   145	149	150	java/io/IOException
    //   34	39	156	finally
    //   45	55	156	finally
    //   57	65	156	finally
    //   67	73	156	finally
    //   83	97	156	finally
    //   99	108	156	finally
    //   113	117	156	finally
    //   137	141	156	finally
    //   161	165	168	java/io/IOException
  }
  
  public static String urlKey2FileName(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return String.valueOf(paramString.hashCode());
    }
    String str = paramString;
    if (paramString.startsWith("file://")) {
      str = paramString.substring(7, paramString.length());
    }
    return str;
  }
  
  boolean canDownloadImage(ImageKey paramImageKey)
  {
    long l = System.currentTimeMillis();
    if (l - this.checkStorageLowTime > 5000L)
    {
      this.checkStorageLowTime = l;
      this.isStorageLow = isAvailableStorageSizeLow();
      if (this.isStorageLow)
      {
        clearAllImageFile();
        this.isStorageLow = isAvailableStorageSizeLow();
        if ((this.isStorageLow) && (isUseExternalStorage))
        {
          StringBuilder localStringBuilder;
          if (!TextUtils.isEmpty(maxAvailableSizePath))
          {
            mCachePath = getStorePath(this.mContext, "imageV2", false, true);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getCachePath(this.mContext));
            localStringBuilder.append(urlKey2FileName(paramImageKey.urlKey, true));
            paramImageKey.filePath = localStringBuilder.toString();
            clearAllImageFile();
            this.isStorageLow = isAvailableStorageSizeLow();
            if (this.isStorageLow)
            {
              mCachePath = getStorePath(this.mContext, "imageV2", true, false);
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(getCachePath(this.mContext));
              localStringBuilder.append(urlKey2FileName(paramImageKey.urlKey, true));
              paramImageKey.filePath = localStringBuilder.toString();
              clearAllImageFile();
              this.isStorageLow = isAvailableStorageSizeLow();
            }
          }
          else
          {
            mCachePath = getStorePath(this.mContext, "imageV2", true, false);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(getCachePath(this.mContext));
            localStringBuilder.append(urlKey2FileName(paramImageKey.urlKey, true));
            paramImageKey.filePath = localStringBuilder.toString();
            clearAllImageFile();
            this.isStorageLow = isAvailableStorageSizeLow();
          }
        }
      }
      if ((this.isStorageLow) && (isMainProcess)) {
        ImageManagerEnv.g().showToast(0, this.mContext, "手机存储空间不足，图片无法下载展示，请及时清理！", 17);
      }
    }
    return !this.isStorageLow;
  }
  
  public void cancel(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      ImageKey localImageKey = ImageKey.obtain();
      localImageKey.setUrl(paramString);
      localImageKey.listener = paramImageLoadListener;
      localImageKey.options = ImageLoader.Options.copy(paramOptions);
      paramString = imageGetNullOrCancelHandler().obtainMessage();
      paramString.what = 1;
      paramString.obj = localImageKey;
      imageGetNullOrCancelHandler().sendMessage(paramString);
    }
  }
  
  public int capacity()
  {
    return this.imageMemCacheSize;
  }
  
  void checkBitmapDecodeFailCount(ImageKey paramImageKey)
  {
    if (paramImageKey.isNetworkUrl)
    {
      Integer localInteger = (Integer)mDecodeExceptionMap.get(paramImageKey.filePath);
      if (localInteger != null)
      {
        if (maxDecodeFailCount == -1)
        {
          maxDecodeFailCount = ImageManagerEnv.g().getMaxNumOfDecodingFailures();
          if (maxDecodeFailCount <= -1)
          {
            maxDecodeFailCount = 3;
            ImageManagerLog.w(TAG, "--maxDecodeFailCount<=-1,so set default value: 3.");
          }
        }
        if (localInteger.intValue() >= maxDecodeFailCount)
        {
          removeImageFile(paramImageKey.url, null);
          mDecodeExceptionMap.remove(paramImageKey.filePath);
          return;
        }
        mDecodeExceptionMap.put(paramImageKey.filePath, Integer.valueOf(localInteger.intValue() + 1));
        return;
      }
      mDecodeExceptionMap.put(paramImageKey.filePath, Integer.valueOf(1));
    }
  }
  
  public void checkCleanImageLocalFile()
  {
    if (isMainProcess) {
      post(new ImageManager.17(this), false);
    }
    if ((isMainProcess) && ((!mLoadAllImageFileFlag) || ((mLoadAllImageFileFlag) && (this.mTotalFileSize > maxCacheSize))))
    {
      imageGetNullOrCancelHandler().removeCallbacks(this.checkOldImageFileAndCleanRunnable);
      imageGetNullOrCancelHandler().postDelayed(this.checkOldImageFileAndCleanRunnable, 1000L);
    }
  }
  
  public void clear(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      paramString = ImageKey.getUrlKey(paramString, false);
      paramString = (HashSet)this.mUrlKey2AllImageKeyMap.remove(paramString);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          int i = ((Integer)paramString.next()).intValue();
          if (IS_ICE_CREAM_SANDWICH) {
            remove(i);
          } else {
            getImageCache().remove(Integer.valueOf(i));
          }
          this.mImageKeyHash2UrlMap.remove(Integer.valueOf(i));
        }
      }
    }
  }
  
  public void clear(String paramString, ImageLoader.Options paramOptions)
  {
    ImageKey localImageKey = ImageKey.obtain();
    localImageKey.setUrl(paramString);
    localImageKey.options = paramOptions;
    int i = localImageKey.hashCodeEx();
    paramString = localImageKey.urlKey;
    if (IS_ICE_CREAM_SANDWICH) {
      remove(i);
    } else {
      getImageCache().remove(Integer.valueOf(i));
    }
    this.mImageKeyHash2UrlMap.remove(Integer.valueOf(i));
    localImageKey.recycle();
  }
  
  public void clear(boolean paramBoolean)
  {
    if (IS_ICE_CREAM_SANDWICH) {
      evictAll();
    } else {
      getImageCache().evictAll();
    }
    ImageKey.clearAndInitSize();
    if (paramBoolean) {
      clearAllImageFile();
    }
    this.mUrlKey2AllImageKeyMap.clear();
    this.mImageKeyHash2UrlMap.clear();
  }
  
  public void clearMemoryCache()
  {
    clear(false);
  }
  
  public BitmapReference getBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    IBitmapFactory localIBitmapFactory = this.mBitmapFactory;
    if (localIBitmapFactory != null) {
      return localIBitmapFactory.createBitmap(paramInt1, paramInt2, paramConfig);
    }
    return BitmapReference.getBitmapReference(Bitmap.createBitmap(paramInt1, paramInt2, paramConfig));
  }
  
  public IDecoder getDecoder()
  {
    return this.mDecoder;
  }
  
  Drawable getDrawbleFromCache(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {
      return null;
    }
    if (removeInvalidatedUrl(paramImageKey.url))
    {
      clear(paramImageKey.url);
      if ((paramImageKey.isSuperResolutionUrl) && (!paramImageKey.isHighScaleUrl))
      {
        if (removeInvalidatedUrl(paramImageKey.bigUrl)) {
          clear(paramImageKey.bigUrl);
        }
      }
      else {
        return null;
      }
    }
    Object localObject3;
    StringBuilder localStringBuilder;
    long l;
    if (IS_ICE_CREAM_SANDWICH)
    {
      if ((paramImageKey.isSuperResolutionUrl) && (!paramImageKey.isHighScaleUrl) && (!TextUtils.isEmpty(paramImageKey.bigUrl)))
      {
        localObject2 = ImageKey.copy(paramImageKey);
        ((ImageKey)localObject2).setUrl(paramImageKey.bigUrl);
        localObject1 = get(((ImageKey)localObject2).hashCodeEx());
        if (localObject1 != null) {
          paramImageKey.setUrl(paramImageKey.bigUrl);
        }
        ((ImageKey)localObject2).recycle();
      }
      else
      {
        localObject1 = null;
      }
      if (localObject1 == null) {
        localObject1 = get(paramImageKey.hashCodeEx());
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (this.mHasEntryNoCacheUrlKeyAndCacheTimeMap)
        {
          localObject3 = (Long)this.mNoCacheUrlKeyAndCacheTimeMap.get(paramImageKey.urlKey);
          localObject2 = localObject1;
          if (localObject3 != null)
          {
            localObject2 = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getDrawbleFromCache, use no-cache, url = ");
            localStringBuilder.append(paramImageKey.url);
            localStringBuilder.append(", cache_time = ");
            localStringBuilder.append(localObject3);
            ImageManagerLog.w((String)localObject2, localStringBuilder.toString());
            l = ImageManagerEnv.g().getNoCacheImageExpiredTime();
            if (System.currentTimeMillis() - ((Long)localObject3).longValue() >= l * 1000L)
            {
              this.mNoCacheUrlKeyAndCacheTimeMap.remove(paramImageKey.urlKey);
              if (this.mNoCacheUrlKeyAndCacheTimeMap.size() == 0) {
                this.mHasEntryNoCacheUrlKeyAndCacheTimeMap = false;
              }
              clear(paramImageKey.url);
              localObject1 = TAG;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("getDrawbleFromCache, clear no-cache memory, url = ");
              ((StringBuilder)localObject2).append(paramImageKey.url);
              ImageManagerLog.w((String)localObject1, ((StringBuilder)localObject2).toString());
              localObject2 = null;
            }
            else
            {
              localObject2 = localObject1;
              if (!TextUtils.isEmpty(paramImageKey.filePath))
              {
                localObject2 = new File(paramImageKey.filePath);
                localObject3 = TAG;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("getDrawbleFromCache, use no-cache drawable, url=");
                localStringBuilder.append(paramImageKey.url);
                localStringBuilder.append(", file length=");
                localStringBuilder.append(((File)localObject2).length());
                ImageManagerLog.d((String)localObject3, localStringBuilder.toString());
                localObject2 = localObject1;
              }
            }
          }
        }
      }
      if (localObject2 != null) {
        return localObject2;
      }
      return null;
    }
    Object localObject2 = (Image)getImageCache().get(Integer.valueOf(paramImageKey.hashCodeEx()));
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (this.mHasEntryNoCacheUrlKeyAndCacheTimeMap)
      {
        localObject3 = (Long)this.mNoCacheUrlKeyAndCacheTimeMap.get(paramImageKey.urlKey);
        localObject1 = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDrawbleFromCache, use no-cache, url = ");
        localStringBuilder.append(paramImageKey.url);
        localStringBuilder.append(", cache_time = ");
        localStringBuilder.append(localObject3);
        ImageManagerLog.w((String)localObject1, localStringBuilder.toString());
        if (localObject3 != null)
        {
          l = ImageManagerEnv.g().getNoCacheImageExpiredTime();
          localObject1 = localObject2;
          if (System.currentTimeMillis() - ((Long)localObject3).longValue() >= l * 1000L)
          {
            this.mNoCacheUrlKeyAndCacheTimeMap.remove(paramImageKey.urlKey);
            if (this.mNoCacheUrlKeyAndCacheTimeMap.size() == 0) {
              this.mHasEntryNoCacheUrlKeyAndCacheTimeMap = false;
            }
            clear(paramImageKey.url);
            localObject1 = TAG;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getDrawbleFromCache, clear no-cache memory, url = ");
            ((StringBuilder)localObject2).append(paramImageKey.url);
            ImageManagerLog.w((String)localObject1, ((StringBuilder)localObject2).toString());
            localObject1 = null;
          }
        }
        else
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramImageKey.filePath))
          {
            localObject1 = new File(paramImageKey.filePath);
            localObject3 = TAG;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("getDrawbleFromCache, use no-cache drawable, url=");
            localStringBuilder.append(paramImageKey.url);
            localStringBuilder.append(", file length=");
            localStringBuilder.append(((File)localObject1).length());
            ImageManagerLog.d((String)localObject3, localStringBuilder.toString());
            localObject1 = localObject2;
          }
        }
      }
    }
    if (localObject1 != null) {}
    try
    {
      if ((localObject1 instanceof FeedsBitmapImage)) {
        paramImageKey = new SpecifiedBitmapDrawable(((FeedsBitmapImage)localObject1).getBitmap());
      } else if ((localObject1 instanceof BitmapImage))
      {
        if ((paramImageKey.options != null) && (paramImageKey.options.extraProcessor != null))
        {
          localObject1 = new BitmapImageDrawable((BitmapImage)localObject1, paramImageKey.options.clipWidth, paramImageKey.options.clipHeight);
          paramImageKey = paramImageKey.options.extraProcessor.doProcess((Drawable)localObject1);
        }
        else
        {
          paramImageKey = new SpecifiedBitmapDrawable(((BitmapImage)localObject1).getBitmap());
        }
      }
      else if ((localObject1 instanceof NewGifImage)) {
        paramImageKey = ((NewGifImage)localObject1).getDrawable();
      } else {
        return null;
      }
    }
    catch (Throwable paramImageKey)
    {
      return null;
    }
    return paramImageKey;
  }
  
  public Drawable getImage(ImageUrl paramImageUrl, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions, byte paramByte, ImageLoader.ImageDownloadListener paramImageDownloadListener)
  {
    if (paramImageUrl == null) {
      return null;
    }
    ImageKey localImageKey = ImageKey.obtain();
    localImageKey.setUrl(paramImageUrl);
    localImageKey.options = paramOptions;
    localImageKey.flag = paramByte;
    localImageKey.listener = paramImageLoadListener;
    boolean bool;
    if (localImageKey.options == null) {
      bool = false;
    } else {
      bool = localImageKey.options.needCallBackProcessPercent;
    }
    localImageKey.needCallBackProcessPercent = bool;
    localImageKey.imglistener = paramImageDownloadListener;
    if ((localImageKey.isSuperResolutionUrl) && (!localImageKey.isHighScaleUrl))
    {
      paramImageLoadListener = paramImageUrl.url;
      if (!TextUtils.isEmpty(paramImageUrl.bigUrl)) {
        paramImageUrl = paramImageUrl.bigUrl;
      } else {
        paramImageUrl = ImageManagerEnv.g().convertSrUrlToBigUrl(paramImageLoadListener);
      }
      if (paramImageUrl != null) {
        localImageKey.bigUrl = paramImageUrl;
      }
    }
    paramImageUrl = getDrawbleFromCache(localImageKey);
    if (paramImageUrl != null)
    {
      if ((isInFriendFeed) && (paramOptions != null) && (!paramOptions.isPreDecode) && (hasScrolled) && (!paramOptions.disableHitRateReport))
      {
        paramImageLoadListener = imageGetNullOrCancelHandler().obtainMessage();
        paramImageLoadListener.what = 2;
        paramImageLoadListener.obj = localImageKey;
        paramImageLoadListener.arg1 = 16;
        imageGetNullOrCancelHandler().sendMessage(paramImageLoadListener);
      }
      if ((paramOptions == null) || (paramOptions.isGifPlayWhileDownloading != true)) {
        localImageKey.recycle();
      }
      return paramImageUrl;
    }
    if ((isInFriendFeed) && (paramOptions != null) && (!paramOptions.isPreDecode) && (hasScrolled) && (!paramOptions.disableHitRateReport))
    {
      paramImageUrl = imageGetNullOrCancelHandler().obtainMessage();
      paramImageUrl.what = 2;
      paramImageUrl.obj = localImageKey;
      paramImageUrl.arg1 = 0;
      imageGetNullOrCancelHandler().sendMessage(paramImageUrl);
    }
    ImageTaskTracer.addImageMsgGetNullRecord(localImageKey.hashCodeEx());
    paramImageUrl = imageGetNullOrCancelHandler().obtainMessage();
    paramImageUrl.what = 0;
    paramImageUrl.obj = localImageKey;
    imageGetNullOrCancelHandler().sendMessage(paramImageUrl);
    return null;
  }
  
  public Drawable getImage(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions, byte paramByte, ImageLoader.ImageDownloadListener paramImageDownloadListener)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      ImageKey localImageKey = ImageKey.obtain();
      localImageKey.setUrl(paramString);
      localImageKey.options = paramOptions;
      localImageKey.flag = paramByte;
      localImageKey.listener = paramImageLoadListener;
      boolean bool;
      if (localImageKey.options == null) {
        bool = false;
      } else {
        bool = localImageKey.options.needCallBackProcessPercent;
      }
      localImageKey.needCallBackProcessPercent = bool;
      localImageKey.imglistener = paramImageDownloadListener;
      if ((localImageKey.isSuperResolutionUrl) && (!localImageKey.isHighScaleUrl))
      {
        paramString = ImageManagerEnv.g().convertSrUrlToBigUrl(paramString);
        if (paramString != null) {
          localImageKey.bigUrl = paramString;
        }
      }
      paramString = getDrawbleFromCache(localImageKey);
      if (paramString != null)
      {
        if ((isInFriendFeed) && (paramOptions != null) && (!paramOptions.isPreDecode) && (hasScrolled) && (!paramOptions.disableHitRateReport))
        {
          paramImageLoadListener = imageGetNullOrCancelHandler().obtainMessage();
          paramImageLoadListener.what = 2;
          paramImageLoadListener.obj = localImageKey;
          paramImageLoadListener.arg1 = 16;
          imageGetNullOrCancelHandler().sendMessage(paramImageLoadListener);
        }
        if ((paramOptions == null) || (paramOptions.isGifPlayWhileDownloading != true)) {
          localImageKey.recycle();
        }
        return paramString;
      }
      if ((isInFriendFeed) && (paramOptions != null) && (!paramOptions.isPreDecode) && (hasScrolled) && (!paramOptions.disableHitRateReport))
      {
        paramString = imageGetNullOrCancelHandler().obtainMessage();
        paramString.what = 2;
        paramString.obj = localImageKey;
        paramString.arg1 = 0;
        imageGetNullOrCancelHandler().sendMessage(paramString);
      }
      ImageTaskTracer.addImageMsgGetNullRecord(localImageKey.hashCodeEx());
      paramString = imageGetNullOrCancelHandler().obtainMessage();
      paramString.what = 0;
      paramString.obj = localImageKey;
      imageGetNullOrCancelHandler().sendMessage(paramString);
    }
    return null;
  }
  
  public Drawable getImageByUrlInMemory(String paramString)
  {
    Object localObject;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      paramString = ImageKey.getUrlKey(paramString, false);
      paramString = (HashSet)this.mUrlKey2AllImageKeyMap.get(paramString);
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = paramString.iterator();
        do
        {
          int i;
          do
          {
            if (!paramString.hasNext()) {
              break label173;
            }
            i = ((Integer)paramString.next()).intValue();
            if (!IS_ICE_CREAM_SANDWICH) {
              break;
            }
            localObject = get(i);
          } while (localObject == null);
          if ((localObject instanceof NewGifDrawable)) {
            ((NewGifDrawable)localObject).setVisible(true, true);
          }
          return localObject;
          localObject = (Image)getImageCache().get(Integer.valueOf(i));
        } while (localObject == null);
      }
    }
    try
    {
      if ((localObject instanceof FeedsBitmapImage)) {
        paramString = new SpecifiedBitmapDrawable(((FeedsBitmapImage)localObject).getBitmap());
      } else if ((localObject instanceof BitmapImage)) {
        paramString = new SpecifiedBitmapDrawable(((BitmapImage)localObject).getBitmap());
      } else {
        label173:
        return null;
      }
    }
    catch (Throwable paramString)
    {
      return null;
    }
    return paramString;
  }
  
  public File getImageFile(String paramString, ImageLoader.Options paramOptions)
  {
    boolean bool = isNetworkUrl(paramString);
    Object localObject = null;
    if (bool)
    {
      String str = urlKey2FileName(ImageKey.getUrlKey(paramString, true), true);
      localObject = (File)this.mFilename2FileMap.get(str);
      if (localObject == null)
      {
        if ((paramOptions != null) && (paramOptions.fileRootPath != null) && (paramOptions.fileRootPath.length() > 0))
        {
          paramOptions = paramOptions.fileRootPath;
        }
        else
        {
          if (mLoadAllImageFileFlag == true) {
            return null;
          }
          paramOptions = getCachePath(this.mContext);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramOptions);
        ((StringBuilder)localObject).append(str);
        localObject = new File(((StringBuilder)localObject).toString());
        if (((File)localObject).exists())
        {
          this.mFilename2FileMap.put(str, localObject);
          this.mTotalFileSize += ((File)localObject).length();
        }
        else
        {
          localObject = getImageFileForSuperResolution(paramString);
        }
      }
    }
    SharpPUtils.deleteSharppCacheFileIfNessary((File)localObject, paramString);
    SharpPUtils.checkNotSharppCacheFileIfNessary((File)localObject, paramString);
    return localObject;
  }
  
  public File getImageFileForSuperResolution(String paramString)
  {
    if (ImageManagerEnv.g().isSuperResolutionUrl(paramString))
    {
      Object localObject2;
      StringBuilder localStringBuilder;
      if (ImageManagerEnv.g().isHighScaleUrl(paramString))
      {
        localObject1 = getCachePathSR(this.mContext);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(urlKey2FileName(ImageKey.getUrlKey(paramString, true), true));
        localObject1 = new File(((StringBuilder)localObject2).toString());
        if (((File)localObject1).exists()) {
          return localObject1;
        }
        localObject1 = ImageKey.getUrlKey4NoneHighScale(paramString, true);
        localObject2 = getCachePath(this.mContext);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(urlKey2FileName((String)localObject1, true));
        localObject1 = new File(localStringBuilder.toString());
        if (((File)localObject1).exists()) {
          return localObject1;
        }
      }
      Object localObject1 = ImageManagerEnv.g().convertSrUrlToBigUrl(paramString);
      if (localObject1 != null)
      {
        localObject1 = ImageKey.getUrlKey((String)localObject1, true);
        localObject2 = getCachePath(this.mContext);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(urlKey2FileName((String)localObject1, true));
        localObject1 = new File(localStringBuilder.toString());
        if (((File)localObject1).exists()) {
          return localObject1;
        }
        localObject1 = getCachePathSR(this.mContext);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(urlKey2FileName(ImageKey.getUrlKey(paramString, true), true));
        paramString = new File(((StringBuilder)localObject2).toString());
        if (paramString.exists()) {
          return paramString;
        }
      }
    }
    return null;
  }
  
  void imageKeyFilePathCheck(ImageKey paramImageKey)
  {
    Object localObject1;
    if ((paramImageKey.filePath == null) || (paramImageKey.filePath.length() == 0)) {
      if (paramImageKey.isNetworkUrl)
      {
        Object localObject3 = paramImageKey.urlKey;
        Object localObject2;
        if ((paramImageKey.options != null) && (paramImageKey.options.fileRootPath != null) && (paramImageKey.options.fileRootPath.length() > 0))
        {
          localObject1 = paramImageKey.options.fileRootPath;
          localObject2 = localObject3;
        }
        else if (ImageManagerEnv.g().isSuperResolutionUrl(paramImageKey.url))
        {
          localObject1 = getCachePathSR(this.mContext);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(urlKey2FileName(paramImageKey.urlKey, true));
          localObject2 = new File(((StringBuilder)localObject2).toString());
          Object localObject4;
          if (((File)localObject2).exists())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("using cache. url=");
            ((StringBuilder)localObject4).append(paramImageKey.url);
            ((StringBuilder)localObject4).append(" filePath=");
            ((StringBuilder)localObject4).append(((File)localObject2).getAbsolutePath());
            ImageManagerLog.w("superresolution", ((StringBuilder)localObject4).toString());
            paramImageKey.needSuperResolution = false;
            localObject2 = localObject3;
          }
          else
          {
            localObject4 = getCachePath(this.mContext);
            localObject2 = localObject3;
            localObject1 = localObject4;
            if (ImageManagerEnv.g().isHighScaleUrl(paramImageKey.url))
            {
              String str = ImageKey.getUrlKey4NoneHighScale(paramImageKey.url, true);
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append((String)localObject4);
              ((StringBuilder)localObject1).append(urlKey2FileName(str, true));
              File localFile = new File(((StringBuilder)localObject1).toString());
              localObject2 = localObject3;
              localObject1 = localObject4;
              if (localFile.exists())
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("high scale. using normal big cache. url=");
                ((StringBuilder)localObject1).append(paramImageKey.url);
                ((StringBuilder)localObject1).append(" filePath=");
                ((StringBuilder)localObject1).append(localFile.getAbsolutePath());
                ImageManagerLog.w("superresolution", ((StringBuilder)localObject1).toString());
                localObject2 = str;
                localObject1 = localObject4;
              }
            }
          }
        }
        else
        {
          localObject1 = getCachePath(this.mContext);
          localObject2 = localObject3;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(urlKey2FileName((String)localObject2, true));
        paramImageKey.filePath = ((StringBuilder)localObject3).toString();
      }
      else if ((ImageManagerEnv.g().needCheckAvatar()) && (paramImageKey.isAvatarUrl()))
      {
        paramImageKey.filePath = ImageManagerEnv.g().getAvatarPath(paramImageKey.url);
      }
      else
      {
        paramImageKey.filePath = urlKey2FileName(paramImageKey.urlKey, false);
      }
    }
    if ((!TextUtils.isEmpty(paramImageKey.filePath)) && (VideoThumbnail.isVideo(paramImageKey.filePath)))
    {
      localObject1 = VideoThumbnail.queryVideoThumbnailFilePath(ImageManagerEnv.getAppContext(), paramImageKey.filePath);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (new File((String)localObject1).exists())) {
        paramImageKey.filePath = ((String)localObject1);
      }
    }
  }
  
  protected void nocachedDeleteLocalFile(ImageKey paramImageKey)
  {
    if ((this.mHasEntryNoCacheUrlKeyAndCacheTimeMap) && (this.mNoCacheUrlKeyAndCacheTimeMap.containsKey(paramImageKey.urlKey)))
    {
      localObject = new File(paramImageKey.filePath);
      if (((File)localObject).exists())
      {
        boolean bool = ((File)localObject).delete();
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("nocachedDeleteLocalFile, delete local file is: ");
        localStringBuilder.append(bool);
        localStringBuilder.append(", url = ");
        localStringBuilder.append(paramImageKey.url);
        localStringBuilder.append(", filePath=");
        localStringBuilder.append(paramImageKey.filePath);
        ImageManagerLog.w((String)localObject, localStringBuilder.toString());
        if (bool)
        {
          paramImageKey = new File(getNocacheFilePath(paramImageKey, false));
          if (paramImageKey.exists()) {
            paramImageKey.delete();
          }
          return;
        }
      }
    }
    Object localObject = new File(getNocacheFilePath(paramImageKey, false));
    if (((File)localObject).exists())
    {
      paramImageKey = new File(paramImageKey.filePath);
      if (paramImageKey.exists()) {
        paramImageKey.delete();
      }
      ((File)localObject).delete();
    }
  }
  
  public void notifyDownSuccess(ImageKey paramImageKey, String paramString1, String paramString2)
  {
    onDownloadSucceed(paramImageKey, paramString1, paramString2, false);
  }
  
  boolean onDownloadSucceed(ImageKey paramImageKey, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject2 = ImageKey.getUrlKey(paramString1, false);
    ImageTracer.endDownlaod(paramString1);
    if ((paramImageKey != null) && (paramImageKey.flag == 3)) {
      ProgressTracer.print(5, paramString1);
    } else {
      ProgressTracer.print(2, paramString1);
    }
    Object localObject1 = localObject2;
    if (ImageManagerEnv.g().enableSocketMonitor()) {
      localObject1 = ImageManagerEnv.g().removeSocketMonitorParam((String)localObject2);
    }
    long l1;
    if (paramBoolean)
    {
      l1 = System.currentTimeMillis();
      this.mNoCacheUrlKeyAndCacheTimeMap.put(localObject1, Long.valueOf(l1));
      this.mHasEntryNoCacheUrlKeyAndCacheTimeMap = true;
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onDownloadSucceed,save no-cache info, url = ");
      ((StringBuilder)localObject2).append(paramString1);
      ImageManagerLog.w((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    if (paramImageKey != null)
    {
      imageKeyFilePathCheck(paramImageKey);
      localObject1 = new File(paramImageKey.filePath);
      int i;
      long l2;
      if (((File)localObject1).exists())
      {
        if ((paramImageKey.isNetworkUrl) && (!paramBoolean))
        {
          updateLruFile(paramImageKey);
          paramString2 = ((File)localObject1).getName();
          i = (int)((File)localObject1).length();
          this.mFilename2FileMap.put(paramString2, localObject1);
          l1 = this.mTotalFileSize;
          l2 = i;
          this.mTotalFileSize = (l1 + l2);
          mFilename2FileLengthMap.put(Integer.valueOf(parseInt(paramString2)), Integer.valueOf(i));
          ImageTracer.setImageLength(paramString1, l2);
        }
        if (paramBoolean)
        {
          paramImageKey = new File(getNocacheFilePath(paramImageKey, true));
          if (!paramImageKey.exists()) {
            try
            {
              paramImageKey.createNewFile();
              return true;
            }
            catch (Exception paramImageKey)
            {
              paramImageKey.printStackTrace();
            }
          }
        }
        return true;
      }
      if (paramImageKey.isAvatarUrl())
      {
        paramImageKey.filePath = paramString2;
        return true;
      }
      if (!paramImageKey.filePath.startsWith("/data"))
      {
        mCachePath = getStorePath(this.mContext, "imageV2", true, false);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(getCachePath(this.mContext));
        ((StringBuilder)localObject1).append(urlKey2FileName(paramImageKey.urlKey, true));
        paramImageKey.filePath = ((StringBuilder)localObject1).toString();
        paramImageKey = new File(paramImageKey.filePath);
        if (ImageManagerEnv.g().copyFiles(new File(paramString2), paramImageKey))
        {
          if (!paramBoolean)
          {
            paramString2 = paramImageKey.getName();
            i = (int)paramImageKey.length();
            this.mFilename2FileMap.put(paramString2, paramImageKey);
            l1 = this.mTotalFileSize;
            l2 = i;
            this.mTotalFileSize = (l1 + l2);
            mFilename2FileLengthMap.put(Integer.valueOf(parseInt(paramString2)), Integer.valueOf(i));
            ImageTracer.setImageLength(paramString1, l2);
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public void onListViewIdle()
  {
    ImageTaskManager.getInstance().resumeDecodeImageTask();
  }
  
  void putDrawableInMemoryCache(ImageKey paramImageKey, int paramInt, Image paramImage, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    if (paramImageKey == null) {
      return;
    }
    putDrawableInMemoryCache(paramImageKey.urlKey, paramInt, paramImage, paramDrawable, paramOptions);
    this.mImageKeyHash2UrlMap.put(Integer.valueOf(paramInt), paramImageKey.url);
  }
  
  void putDrawableInMemoryCache(String paramString, int paramInt, Image paramImage, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    if ((paramOptions != null) && (!paramOptions.needCache))
    {
      ImageManagerLog.d(TAG, "options.needCache=false,needn't put into cache");
      return;
    }
    if (IS_ICE_CREAM_SANDWICH)
    {
      if (drawableComputable(paramDrawable))
      {
        put(paramInt, paramDrawable);
      }
      else
      {
        paramImage = new StringBuilder();
        paramImage.append("drawable 不能精确计算大小，不能放入缓存中：");
        paramImage.append(paramDrawable);
        ImageManagerLog.d("feilongzou", paramImage.toString());
      }
    }
    else {
      getImageCache().put(Integer.valueOf(paramInt), paramImage);
    }
    paramDrawable = (HashSet)this.mUrlKey2AllImageKeyMap.get(paramString);
    paramImage = paramDrawable;
    if (paramDrawable == null)
    {
      paramImage = new HashSet();
      this.mUrlKey2AllImageKeyMap.put(paramString, paramImage);
    }
    paramImage.add(Integer.valueOf(paramInt));
  }
  
  public void removeImageFile(String paramString, ImageLoader.Options paramOptions)
  {
    if (isNetworkUrl(paramString))
    {
      String str = urlKey2FileName(ImageKey.getUrlKey(paramString, true), true);
      File localFile = (File)this.mFilename2FileMap.remove(str);
      mFilename2FileLengthMap.remove(Integer.valueOf(parseInt(str)));
      paramString = localFile;
      if (localFile == null)
      {
        if ((paramOptions != null) && (paramOptions.fileRootPath != null) && (paramOptions.fileRootPath.length() > 0)) {
          paramString = paramOptions.fileRootPath;
        } else {
          paramString = getCachePath(this.mContext);
        }
        paramOptions = new StringBuilder();
        paramOptions.append(paramString);
        paramOptions.append(str);
        paramString = new File(paramOptions.toString());
      }
      if ((paramString != null) && (paramString.exists()))
      {
        this.mTotalFileSize -= paramString.length();
        paramString.delete();
      }
    }
  }
  
  public void resizeCache(float paramFloat)
  {
    ImageManagerLog.i(TAG, "resize mImageKeyHash2DrawableMap");
    BitmapUtils.resize(this.mImageKeyHash2DrawableMap, paramFloat, 8388608);
    ImageManagerLog.i(TAG, "resize mImageKeyHash2ImageMap");
    BitmapUtils.resize(this.mImageKeyHash2ImageMap, paramFloat);
    ImageManagerLog.i(TAG, "clear ArtDecoder");
    IDecoder localIDecoder = getDecoder();
    if ((localIDecoder instanceof ArtDecoder)) {
      ((ArtDecoder)localIDecoder).trimToSize(paramFloat);
    }
  }
  
  public void saveSuperResImage(Bitmap paramBitmap, ImageKey paramImageKey)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getCachePathSR(this.mContext));
    ((StringBuilder)localObject).append(urlKey2FileName(paramImageKey.urlKey, true));
    localObject = ((StringBuilder)localObject).toString();
    BitmapUtils.saveBitmapToFile(paramBitmap, (String)localObject);
    paramBitmap = paramImageKey.filePath;
    paramImageKey.filePath = ((String)localObject);
    BitmapUtils.copyExif(paramBitmap, (String)localObject);
    paramImageKey.needSuperResolution = false;
    paramBitmap = new File((String)localObject);
    updateLruFile(paramImageKey);
    paramImageKey = paramBitmap.getName();
    int i = (int)paramBitmap.length();
    this.mFilename2FileMap.put(paramImageKey, paramBitmap);
    this.mTotalFileSize += i;
    mFilename2FileLengthMap.put(Integer.valueOf(parseInt(paramImageKey)), Integer.valueOf(i));
  }
  
  public void setImageFileTracer(IImageFileTracer paramIImageFileTracer)
  {
    this.imageFileTracer = paramIImageFileTracer;
  }
  
  protected void traceImageFile(boolean paramBoolean)
  {
    IImageFileTracer localIImageFileTracer = this.imageFileTracer;
    if (localIImageFileTracer != null) {
      localIImageFileTracer.onImageFileDecode(paramBoolean);
    }
  }
  
  public void trimCacheToSize(float paramFloat)
  {
    ImageManagerLog.i(TAG, "clear mImageKeyHash2DrawableMap");
    BitmapUtils.trimToSize(this.mImageKeyHash2DrawableMap, paramFloat, 8388608);
    ImageManagerLog.i(TAG, "clear mImageKeyHash2ImageMap");
    BitmapUtils.trimToSize(this.mImageKeyHash2ImageMap, paramFloat);
    ImageManagerLog.i(TAG, "clear ArtDecoder");
    IDecoder localIDecoder = getDecoder();
    if ((localIDecoder instanceof ArtDecoder)) {
      ((ArtDecoder)localIDecoder).trimToSize(paramFloat);
    }
  }
  
  void updateLruFile(ImageKey paramImageKey)
  {
    if ((paramImageKey != null) && (paramImageKey.isNetworkUrl))
    {
      imageKeyFilePathCheck(paramImageKey);
      paramImageKey = urlKey2FileName(paramImageKey.urlKey, true);
      int i = (int)(System.currentTimeMillis() / 1000L);
      mLruFilename2TimeMap.put(paramImageKey, Integer.valueOf(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager
 * JD-Core Version:    0.7.0.1
 */
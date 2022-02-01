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
import java.util.Arrays;
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
  private static final ConcurrentHashMap<String, Object> INVALIDATE_URLS;
  private static final boolean IS_ICE_CREAM_SANDWICH;
  private static final Object LOCK_CacheMap;
  private static final Object LOCK_mImageDecodeThreadPool;
  private static final Object LOCK_mImageGetNullOrCancelHandler;
  private static final Object LOCK_mImageTaskThreadPool;
  private static final Object LOCK_mInstance;
  private static final int LOW_SIZE = 5242880;
  private static final String LRU_FILE_NAME = "imagelru.usetime";
  private static long MAX_INNER_SIZE_LIMIT = 0L;
  private static long MAX_SDCARD_SIZE_LIMIT = 0L;
  private static final int MIN_CACHE_SIZE = 8388608;
  private static final int MSG_CANCEL = 1;
  private static final int MSG_DUMP_MEMORY_CACHE = 1000;
  private static final int MSG_GET_NULL = 0;
  private static final int MSG_IMAGE_TASK_TRACER = 2;
  public static final String TAG = ImageManager.class.getSimpleName();
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
  private final BroadcastReceiver MsdCardMountReceiver = new ImageManager.11(this);
  private Runnable checkOldImageFileAndCleanRunnable = new ImageManager.16(this);
  private long checkStorageLowTime = 0L;
  private Looper dispatcherLoop = null;
  private IImageFileTracer imageFileTracer = null;
  private int imageMemCacheSize = 1;
  private boolean isStorageLow = false;
  IBitmapFactory mBitmapFactory;
  ByteArrayPool mByteArrayPool;
  private Context mContext = null;
  private IDecoder mDecoder = null;
  private ConcurrentHashMap<String, File> mFilename2FileMap = new ConcurrentHashMap();
  private volatile boolean mHasEntryNoCacheUrlKeyAndCacheTimeMap = false;
  private IDownloader mImageDownloader = null;
  private BaseHandler mImageGetNullOrCancelHandler = null;
  private ConcurrentHashMap<Integer, Integer> mImageKey2SampleSizeMap = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, HashSet<ImageKey>> mImageKeyHash2DecodeOrDownloadMap = new ConcurrentHashMap();
  private LruCache<Integer, Drawable> mImageKeyHash2DrawableMap = null;
  private LruCache<Integer, Image> mImageKeyHash2ImageMap = null;
  private ConcurrentHashMap<Integer, String> mImageKeyHash2UrlMap = new ConcurrentHashMap();
  private HashMap<Integer, HashSet<ImageKey>> mImageKeyHash2WaitDecodeMap = new HashMap();
  private ConcurrentHashMap<String, ImageManager.ImageAttri> mImagePath2AttriMap = new ConcurrentHashMap();
  private ThreadLocal<HashSet<Integer>> mIntegerHashSet = new ImageManager.1(this);
  private final BaseHandler mMainHandler = new BaseHandler(Looper.getMainLooper());
  private ConcurrentHashMap<String, Long> mNoCacheUrlKeyAndCacheTimeMap = new ConcurrentHashMap();
  private volatile long mTotalFileSize = 0L;
  private ConcurrentHashMap<String, HashSet<Integer>> mUrlKey2AllImageKeyMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, HashSet<Integer>> mUrlKey2DownloadImageKeyMap = new ConcurrentHashMap();
  
  static
  {
    mInstance = null;
    LOCK_mInstance = new Object();
    LOCK_mImageGetNullOrCancelHandler = new Object();
    LOCK_CacheMap = new Object();
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
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
      INVALIDATE_URLS = new ConcurrentHashMap();
      return;
    }
  }
  
  private ImageManager()
  {
    sCloseNativeAndCache = ImageManagerEnv.g().closeNativeAndinBitmap();
    if (sCloseNativeAndCache) {
      ImageManagerLog.d(TAG, "wns closeNativeAndCache");
    }
    int i;
    Object localObject;
    int m;
    boolean bool;
    label402:
    int j;
    if ((Build.VERSION.SDK_INT >= 21) && ("meizu".equalsIgnoreCase(Build.MANUFACTURER)))
    {
      i = 1;
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
      m = ((ActivityManager)this.mContext.getSystemService("activity")).getMemoryClass();
      localObject = ImageManagerEnv.g().getProcessName(this.mContext);
      isMainProcess = ImageManagerEnv.g().isMainProcess(this.mContext);
      if ((localObject == null) || (!((String)localObject).contains(":localphoto"))) {
        break label612;
      }
      i = 524288 * m;
      bool = true;
      if (IS_ICE_CREAM_SANDWICH) {
        break label624;
      }
      j = i / 2;
      label413:
      i = j - 307200;
      this.imageMemCacheSize = i;
      float f2 = ImageManagerEnv.g().getCacheMemRatio();
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      this.imageMemCacheSize = ((int)(this.imageMemCacheSize * f1));
      ImageManagerLog.d(TAG, "imageMemCacheSize: " + this.imageMemCacheSize + " , drawableCacheRatio: " + f1 + ",memoryclass:" + m);
      getDecodeThreadPool();
      ImageOptionSampleSize.setSize(m, i);
      if (Build.VERSION.SDK_INT < 14) {
        sCloseNativeAndCache = true;
      }
      if (!sCloseNativeAndCache) {
        break label716;
      }
    }
    for (;;)
    {
      if (this.mDecoder == null)
      {
        this.mDecoder = new DefaultDecoder();
        this.mBitmapFactory = new IBitmapFactory.DefaultBitmapFactory(this.mDecoder);
      }
      ImageManagerLog.d(TAG, "ImageManager() mDecoder:" + this.mDecoder);
      registerSdCardMountReceiver();
      getAllSDCardInfo();
      registerDumpMemoryCacheReceiver();
      return;
      i = 0;
      break;
      label612:
      i = 262144 * m;
      bool = false;
      break label402;
      label624:
      if (Build.VERSION.SDK_INT >= 21)
      {
        int n = ImageManagerEnv.g().getMinMemoryClassInArt();
        j = i;
        if (m >= n) {
          break label413;
        }
        sCloseNativeAndCache = true;
        ImageManagerLog.d(TAG, "minMemory closeNativeAndCache:" + m + ", minMem: " + n);
        j = i;
        break label413;
      }
      j = i;
      if (!bool) {
        break label413;
      }
      sCloseNativeAndCache = true;
      j = i;
      break label413;
      label716:
      if (Build.VERSION.SDK_INT >= 21) {
        break label814;
      }
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
    label814:
    if (ImageDefaultConfig.isQzone(this.mContext))
    {
      i = (int)(this.imageMemCacheSize * 0.4D);
      this.imageMemCacheSize = ((int)(this.imageMemCacheSize * 0.6D));
    }
    for (;;)
    {
      ImageManagerLog.d(TAG, "ImageLoader----imageMemCacheSize = " + this.imageMemCacheSize);
      this.mByteArrayPool = new ByteArrayPool(new ImageManager.3(this));
      localObject = new ReuseBitmapCacheProxy(new ImageManager.4(this), i);
      this.mDecoder = new ArtDecoder(this.mByteArrayPool, (BitmapPool)localObject);
      this.mBitmapFactory = new IBitmapFactory.ArtBitmapFactory(this.mByteArrayPool, this.mDecoder);
      BitmapReference.setGlobalReleaser((Releaser)localObject);
      break;
      if (ImageDefaultConfig.isPicture(this.mContext))
      {
        i = (int)(this.imageMemCacheSize * 0.6D);
        this.imageMemCacheSize = ((int)(this.imageMemCacheSize * 0.4D));
      }
      else
      {
        i = k;
        if (ImageDefaultConfig.isMobileQQ(this.mContext))
        {
          i = (int)(this.imageMemCacheSize * 0.3D);
          this.imageMemCacheSize = ((int)(this.imageMemCacheSize * 0.5D));
        }
      }
    }
  }
  
  /* Error */
  private void checkOldImageFileAndClean()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: getstatic 198	com/tencent/component/media/image/ImageManager:isMainProcess	Z
    //   6: ifne +4 -> 10
    //   9: return
    //   10: getstatic 271	com/tencent/component/media/image/ImageManager:mLoadAllImageFileFlag	Z
    //   13: ifeq +14 -> 27
    //   16: aload_0
    //   17: getfield 356	com/tencent/component/media/image/ImageManager:mTotalFileSize	J
    //   20: getstatic 249	com/tencent/component/media/image/ImageManager:maxCacheSize	J
    //   23: lcmp
    //   24: iflt -15 -> 9
    //   27: aload_0
    //   28: getfield 337	com/tencent/component/media/image/ImageManager:mContext	Landroid/content/Context;
    //   31: invokestatic 679	com/tencent/component/media/image/ImageManager:getCachePath	(Landroid/content/Context;)Ljava/lang/String;
    //   34: astore 9
    //   36: new 681	java/io/File
    //   39: dup
    //   40: aload 9
    //   42: ldc 29
    //   44: ldc 26
    //   46: invokevirtual 685	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   49: invokespecial 686	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore 10
    //   54: aload 10
    //   56: invokevirtual 689	java/io/File:exists	()Z
    //   59: ifeq +61 -> 120
    //   62: aload 10
    //   64: invokevirtual 692	java/io/File:isDirectory	()Z
    //   67: ifeq +53 -> 120
    //   70: aload 10
    //   72: invokevirtual 696	java/io/File:listFiles	()[Ljava/io/File;
    //   75: astore 11
    //   77: aload 11
    //   79: ifnull +35 -> 114
    //   82: aload 11
    //   84: arraylength
    //   85: ifle +29 -> 114
    //   88: aload 11
    //   90: arraylength
    //   91: istore_2
    //   92: iconst_0
    //   93: istore_1
    //   94: iload_1
    //   95: iload_2
    //   96: if_icmpge +18 -> 114
    //   99: aload 11
    //   101: iload_1
    //   102: aaload
    //   103: invokevirtual 699	java/io/File:delete	()Z
    //   106: pop
    //   107: iload_1
    //   108: iconst_1
    //   109: iadd
    //   110: istore_1
    //   111: goto -17 -> 94
    //   114: aload 10
    //   116: invokevirtual 699	java/io/File:delete	()Z
    //   119: pop
    //   120: new 273	java/util/concurrent/ConcurrentHashMap
    //   123: dup
    //   124: invokespecial 274	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   127: astore 12
    //   129: new 701	java/util/ArrayList
    //   132: dup
    //   133: invokespecial 702	java/util/ArrayList:<init>	()V
    //   136: astore 11
    //   138: new 681	java/io/File
    //   141: dup
    //   142: aload 9
    //   144: invokespecial 686	java/io/File:<init>	(Ljava/lang/String;)V
    //   147: astore 9
    //   149: aload 9
    //   151: invokevirtual 689	java/io/File:exists	()Z
    //   154: ifeq +449 -> 603
    //   157: aload 9
    //   159: invokevirtual 692	java/io/File:isDirectory	()Z
    //   162: ifeq +441 -> 603
    //   165: aload 9
    //   167: getstatic 256	com/tencent/component/media/image/ImageManager:imageFilenameFilter	Ljava/io/FilenameFilter;
    //   170: invokevirtual 705	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   173: astore 13
    //   175: aload 13
    //   177: ifnull +426 -> 603
    //   180: aload 13
    //   182: arraylength
    //   183: istore_1
    //   184: iload_1
    //   185: ifle +418 -> 603
    //   188: iconst_0
    //   189: istore_3
    //   190: iconst_0
    //   191: istore_1
    //   192: iload_1
    //   193: istore_2
    //   194: iload_3
    //   195: aload 13
    //   197: arraylength
    //   198: if_icmpge +402 -> 600
    //   201: iload_1
    //   202: istore_2
    //   203: aload 11
    //   205: aload 13
    //   207: iload_3
    //   208: aaload
    //   209: invokevirtual 709	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   212: pop
    //   213: iload_1
    //   214: istore_2
    //   215: aload 13
    //   217: iload_3
    //   218: aaload
    //   219: invokevirtual 712	java/io/File:getName	()Ljava/lang/String;
    //   222: astore 14
    //   224: iload_1
    //   225: istore_2
    //   226: aload 14
    //   228: invokestatic 716	com/tencent/component/media/image/ImageManager:parseInt	(Ljava/lang/String;)I
    //   231: istore 5
    //   233: iload_1
    //   234: istore_2
    //   235: getstatic 276	com/tencent/component/media/image/ImageManager:mFilename2FileLengthMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   238: iload 5
    //   240: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: invokevirtual 726	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   246: checkcast 718	java/lang/Integer
    //   249: astore 10
    //   251: aload 10
    //   253: astore 9
    //   255: aload 10
    //   257: ifnonnull +34 -> 291
    //   260: iload_1
    //   261: istore_2
    //   262: aload 13
    //   264: iload_3
    //   265: aaload
    //   266: invokevirtual 729	java/io/File:length	()J
    //   269: l2i
    //   270: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   273: astore 9
    //   275: iload_1
    //   276: istore_2
    //   277: getstatic 276	com/tencent/component/media/image/ImageManager:mFilename2FileLengthMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   280: iload 5
    //   282: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aload 9
    //   287: invokevirtual 733	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   290: pop
    //   291: iload_1
    //   292: istore_2
    //   293: iload_1
    //   294: aload 9
    //   296: invokevirtual 736	java/lang/Integer:intValue	()I
    //   299: iadd
    //   300: istore_1
    //   301: iload_1
    //   302: istore_2
    //   303: aload 12
    //   305: aload 14
    //   307: aload 13
    //   309: iload_3
    //   310: aaload
    //   311: invokevirtual 733	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   314: pop
    //   315: iload_3
    //   316: iconst_1
    //   317: iadd
    //   318: istore_3
    //   319: goto -127 -> 192
    //   322: astore 10
    //   324: aload 10
    //   326: invokevirtual 739	java/lang/Throwable:printStackTrace	()V
    //   329: goto -209 -> 120
    //   332: astore 9
    //   334: iconst_0
    //   335: istore_1
    //   336: aload 9
    //   338: invokevirtual 739	java/lang/Throwable:printStackTrace	()V
    //   341: aload_0
    //   342: iload_1
    //   343: i2l
    //   344: putfield 356	com/tencent/component/media/image/ImageManager:mTotalFileSize	J
    //   347: aload_0
    //   348: aload 12
    //   350: putfield 354	com/tencent/component/media/image/ImageManager:mFilename2FileMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   353: iconst_1
    //   354: putstatic 271	com/tencent/component/media/image/ImageManager:mLoadAllImageFileFlag	Z
    //   357: aload_0
    //   358: getfield 356	com/tencent/component/media/image/ImageManager:mTotalFileSize	J
    //   361: getstatic 249	com/tencent/component/media/image/ImageManager:maxCacheSize	J
    //   364: lcmp
    //   365: iflt -356 -> 9
    //   368: getstatic 742	android/os/Build:MODEL	Ljava/lang/String;
    //   371: invokevirtual 745	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   374: ldc_w 747
    //   377: invokevirtual 441	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   380: istore 6
    //   382: getstatic 249	com/tencent/component/media/image/ImageManager:maxCacheSize	J
    //   385: l2f
    //   386: ldc 109
    //   388: fmul
    //   389: f2l
    //   390: lstore 7
    //   392: aload_0
    //   393: getstatic 282	com/tencent/component/media/image/ImageManager:mLruFilename2TimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   396: invokespecial 750	com/tencent/component/media/image/ImageManager:loadLruFileTime	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   399: aload 11
    //   401: getstatic 261	com/tencent/component/media/image/ImageManager:fileTimeComparator	Ljava/util/Comparator;
    //   404: invokestatic 756	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   407: aload 11
    //   409: invokevirtual 759	java/util/ArrayList:size	()I
    //   412: iconst_1
    //   413: isub
    //   414: istore_2
    //   415: iload 4
    //   417: istore_1
    //   418: iload_2
    //   419: ifle +140 -> 559
    //   422: aload 11
    //   424: iload_2
    //   425: invokevirtual 762	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   428: checkcast 681	java/io/File
    //   431: astore 12
    //   433: aload 12
    //   435: invokevirtual 712	java/io/File:getName	()Ljava/lang/String;
    //   438: astore 13
    //   440: getstatic 276	com/tencent/component/media/image/ImageManager:mFilename2FileLengthMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   443: aload 13
    //   445: invokestatic 716	com/tencent/component/media/image/ImageManager:parseInt	(Ljava/lang/String;)I
    //   448: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   451: invokevirtual 765	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   454: checkcast 718	java/lang/Integer
    //   457: astore 10
    //   459: aload 10
    //   461: astore 9
    //   463: aload 10
    //   465: ifnonnull +14 -> 479
    //   468: aload 12
    //   470: invokevirtual 729	java/io/File:length	()J
    //   473: l2i
    //   474: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   477: astore 9
    //   479: aload_0
    //   480: getfield 354	com/tencent/component/media/image/ImageManager:mFilename2FileMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   483: aload 13
    //   485: invokevirtual 765	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   488: pop
    //   489: aload_0
    //   490: aload_0
    //   491: getfield 356	com/tencent/component/media/image/ImageManager:mTotalFileSize	J
    //   494: aload 9
    //   496: invokevirtual 736	java/lang/Integer:intValue	()I
    //   499: i2l
    //   500: lsub
    //   501: putfield 356	com/tencent/component/media/image/ImageManager:mTotalFileSize	J
    //   504: aload 12
    //   506: invokevirtual 699	java/io/File:delete	()Z
    //   509: pop
    //   510: getstatic 282	com/tencent/component/media/image/ImageManager:mLruFilename2TimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   513: aload 13
    //   515: invokevirtual 765	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   518: checkcast 718	java/lang/Integer
    //   521: astore 9
    //   523: iload 6
    //   525: ifeq +72 -> 597
    //   528: iload_1
    //   529: iconst_1
    //   530: iadd
    //   531: istore_3
    //   532: iload_3
    //   533: istore_1
    //   534: iload_3
    //   535: bipush 20
    //   537: irem
    //   538: ifne +11 -> 549
    //   541: ldc2_w 766
    //   544: invokestatic 773	java/lang/Thread:sleep	(J)V
    //   547: iload_3
    //   548: istore_1
    //   549: aload_0
    //   550: getfield 356	com/tencent/component/media/image/ImageManager:mTotalFileSize	J
    //   553: lload 7
    //   555: lcmp
    //   556: ifge +20 -> 576
    //   559: aload_0
    //   560: getstatic 282	com/tencent/component/media/image/ImageManager:mLruFilename2TimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   563: iconst_1
    //   564: invokespecial 777	com/tencent/component/media/image/ImageManager:forceSaveLruFileTime	(Ljava/util/concurrent/ConcurrentHashMap;Z)V
    //   567: return
    //   568: astore 9
    //   570: aload 9
    //   572: invokevirtual 739	java/lang/Throwable:printStackTrace	()V
    //   575: return
    //   576: iload_2
    //   577: iconst_1
    //   578: isub
    //   579: istore_2
    //   580: goto -162 -> 418
    //   583: astore 9
    //   585: iload_3
    //   586: istore_1
    //   587: goto -38 -> 549
    //   590: astore 9
    //   592: iload_2
    //   593: istore_1
    //   594: goto -258 -> 336
    //   597: goto -48 -> 549
    //   600: goto -259 -> 341
    //   603: iconst_0
    //   604: istore_1
    //   605: goto -264 -> 341
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	this	ImageManager
    //   93	512	1	i	int
    //   91	502	2	j	int
    //   189	397	3	k	int
    //   1	415	4	m	int
    //   231	50	5	n	int
    //   380	144	6	bool	boolean
    //   390	164	7	l	long
    //   34	261	9	localObject1	Object
    //   332	5	9	localThrowable1	Throwable
    //   461	61	9	localObject2	Object
    //   568	3	9	localThrowable2	Throwable
    //   583	1	9	localException	Exception
    //   590	1	9	localThrowable3	Throwable
    //   52	204	10	localObject3	Object
    //   322	3	10	localThrowable4	Throwable
    //   457	7	10	localInteger	Integer
    //   75	348	11	localObject4	Object
    //   127	378	12	localObject5	Object
    //   173	341	13	localObject6	Object
    //   222	84	14	str	String
    // Exception table:
    //   from	to	target	type
    //   36	77	322	java/lang/Throwable
    //   82	92	322	java/lang/Throwable
    //   99	107	322	java/lang/Throwable
    //   114	120	322	java/lang/Throwable
    //   138	175	332	java/lang/Throwable
    //   180	184	332	java/lang/Throwable
    //   382	415	568	java/lang/Throwable
    //   422	459	568	java/lang/Throwable
    //   468	479	568	java/lang/Throwable
    //   479	523	568	java/lang/Throwable
    //   541	547	568	java/lang/Throwable
    //   549	559	568	java/lang/Throwable
    //   559	567	568	java/lang/Throwable
    //   541	547	583	java/lang/Exception
    //   194	201	590	java/lang/Throwable
    //   203	213	590	java/lang/Throwable
    //   215	224	590	java/lang/Throwable
    //   226	233	590	java/lang/Throwable
    //   235	251	590	java/lang/Throwable
    //   262	275	590	java/lang/Throwable
    //   277	291	590	java/lang/Throwable
    //   293	301	590	java/lang/Throwable
    //   303	315	590	java/lang/Throwable
  }
  
  private void checkSaveLruFileTime(ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    long l;
    if (isMainProcess)
    {
      l = System.currentTimeMillis();
      if (mSaveLruFileTime != 0L) {
        break label29;
      }
      mSaveLruFileTime = l;
      forceSaveLruFileTime(paramConcurrentHashMap, false);
    }
    label29:
    while (l - mSaveLruFileTime <= 60000L) {
      return;
    }
    mSaveLruFileTime = l;
    forceSaveLruFileTime(paramConcurrentHashMap, false);
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
    int j = 1;
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    if (i > 0) {}
    for (;;)
    {
      int k = paramDrawable.getIntrinsicHeight();
      if (k > 0) {
        j = k;
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
      i = 1;
    }
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
    //   1: invokevirtual 882	java/util/concurrent/ConcurrentHashMap:size	()I
    //   4: ifle +182 -> 186
    //   7: new 211	java/util/HashMap
    //   10: dup
    //   11: invokespecial 212	java/util/HashMap:<init>	()V
    //   14: astore 4
    //   16: aload 4
    //   18: aload_1
    //   19: invokevirtual 886	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   22: aload_1
    //   23: invokevirtual 788	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   26: new 448	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 449	java/lang/StringBuilder:<init>	()V
    //   33: aload_0
    //   34: getfield 337	com/tencent/component/media/image/ImageManager:mContext	Landroid/content/Context;
    //   37: invokestatic 679	com/tencent/component/media/image/ImageManager:getCachePath	(Landroid/content/Context;)Ljava/lang/String;
    //   40: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc 47
    //   45: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_1
    //   52: iload_2
    //   53: ifne +134 -> 187
    //   56: iconst_1
    //   57: istore_2
    //   58: new 888	java/io/FileOutputStream
    //   61: dup
    //   62: aload_1
    //   63: iload_2
    //   64: invokespecial 891	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   67: astore_3
    //   68: aload_3
    //   69: astore_1
    //   70: new 448	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 449	java/lang/StringBuilder:<init>	()V
    //   77: astore 5
    //   79: aload_3
    //   80: astore_1
    //   81: aload 4
    //   83: invokevirtual 895	java/util/HashMap:keySet	()Ljava/util/Set;
    //   86: invokeinterface 901 1 0
    //   91: astore 6
    //   93: aload_3
    //   94: astore_1
    //   95: aload 6
    //   97: invokeinterface 906 1 0
    //   102: ifeq +90 -> 192
    //   105: aload_3
    //   106: astore_1
    //   107: aload 6
    //   109: invokeinterface 910 1 0
    //   114: checkcast 392	java/lang/String
    //   117: astore 7
    //   119: aload_3
    //   120: astore_1
    //   121: aload 5
    //   123: aload 7
    //   125: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_3
    //   130: astore_1
    //   131: aload 5
    //   133: ldc_w 912
    //   136: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_3
    //   141: astore_1
    //   142: aload 5
    //   144: aload 4
    //   146: aload 7
    //   148: invokevirtual 913	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   151: invokevirtual 493	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_3
    //   156: astore_1
    //   157: aload 5
    //   159: ldc_w 915
    //   162: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: goto -73 -> 93
    //   169: astore 4
    //   171: aload_3
    //   172: astore_1
    //   173: aload 4
    //   175: invokevirtual 916	java/lang/Exception:printStackTrace	()V
    //   178: aload_3
    //   179: ifnull +7 -> 186
    //   182: aload_3
    //   183: invokevirtual 919	java/io/FileOutputStream:close	()V
    //   186: return
    //   187: iconst_0
    //   188: istore_2
    //   189: goto -131 -> 58
    //   192: aload_3
    //   193: astore_1
    //   194: aload_3
    //   195: aload 5
    //   197: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokevirtual 923	java/lang/String:getBytes	()[B
    //   203: invokevirtual 927	java/io/FileOutputStream:write	([B)V
    //   206: aload_3
    //   207: astore_1
    //   208: aload_3
    //   209: invokevirtual 930	java/io/FileOutputStream:flush	()V
    //   212: aload_3
    //   213: ifnull -27 -> 186
    //   216: aload_3
    //   217: invokevirtual 919	java/io/FileOutputStream:close	()V
    //   220: return
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 931	java/io/IOException:printStackTrace	()V
    //   226: return
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 931	java/io/IOException:printStackTrace	()V
    //   232: return
    //   233: astore_3
    //   234: aconst_null
    //   235: astore_1
    //   236: aload_1
    //   237: ifnull +7 -> 244
    //   240: aload_1
    //   241: invokevirtual 919	java/io/FileOutputStream:close	()V
    //   244: aload_3
    //   245: athrow
    //   246: astore_1
    //   247: aload_1
    //   248: invokevirtual 931	java/io/IOException:printStackTrace	()V
    //   251: goto -7 -> 244
    //   254: astore_3
    //   255: goto -19 -> 236
    //   258: astore 4
    //   260: aconst_null
    //   261: astore_3
    //   262: goto -91 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	ImageManager
    //   0	265	1	paramConcurrentHashMap	ConcurrentHashMap<String, Integer>
    //   0	265	2	paramBoolean	boolean
    //   67	150	3	localFileOutputStream	java.io.FileOutputStream
    //   233	12	3	localObject1	Object
    //   254	1	3	localObject2	Object
    //   261	1	3	localObject3	Object
    //   14	131	4	localHashMap	HashMap
    //   169	5	4	localException1	Exception
    //   258	1	4	localException2	Exception
    //   77	119	5	localStringBuilder	StringBuilder
    //   91	17	6	localIterator	Iterator
    //   117	30	7	str	String
    // Exception table:
    //   from	to	target	type
    //   70	79	169	java/lang/Exception
    //   81	93	169	java/lang/Exception
    //   95	105	169	java/lang/Exception
    //   107	119	169	java/lang/Exception
    //   121	129	169	java/lang/Exception
    //   131	140	169	java/lang/Exception
    //   142	155	169	java/lang/Exception
    //   157	166	169	java/lang/Exception
    //   194	206	169	java/lang/Exception
    //   208	212	169	java/lang/Exception
    //   216	220	221	java/io/IOException
    //   182	186	227	java/io/IOException
    //   58	68	233	finally
    //   240	244	246	java/io/IOException
    //   70	79	254	finally
    //   81	93	254	finally
    //   95	105	254	finally
    //   107	119	254	finally
    //   121	129	254	finally
    //   131	140	254	finally
    //   142	155	254	finally
    //   157	166	254	finally
    //   173	178	254	finally
    //   194	206	254	finally
    //   208	212	254	finally
    //   58	68	258	java/lang/Exception
  }
  
  private Drawable get(int paramInt)
  {
    if (!ImageManagerEnv.g().isQQProcess(this.mContext)) {
      return (Drawable)getDrawableCache().get(Integer.valueOf(paramInt));
    }
    Object localObject = ImageManagerEnv.g().getQQImagecache().get(paramInt + "");
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
    if (mCachePath == null) {}
    try
    {
      if (mCachePath == null) {
        mCachePath = getStorePath(paramContext, "imageV2", false, false);
      }
      return mCachePath;
    }
    finally {}
  }
  
  @Public
  public static String getCachePath(Context paramContext, String paramString)
  {
    return getStorePath(paramContext, paramString, false, false);
  }
  
  private static String getCachePathNocache(Context paramContext)
  {
    return getCachePath(paramContext) + "nocache" + File.separator;
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
    if (sCachePath4SuperResolution == null) {}
    try
    {
      if (sCachePath4SuperResolution == null) {
        sCachePath4SuperResolution = getStorePath(paramContext, "image_sr", false, false);
      }
      return sCachePath4SuperResolution;
    }
    finally {}
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
    if (paramDrawable == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return 0;
              if ((paramDrawable instanceof DrawableContainer)) {
                return getDrawableAllocSize(((DrawableContainer)paramDrawable).getDrawable());
              }
            } while ((paramDrawable instanceof PhotoGifDrawable));
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
            if (!(paramDrawable instanceof NinePatchRefDrawable)) {
              break;
            }
            paramDrawable = ((NinePatchRefDrawable)paramDrawable).getBitmapRef();
          } while (paramDrawable == null);
          paramDrawable = paramDrawable.getBitmap();
        } while (paramDrawable == null);
        return BitmapUtils.getBitmapAllocSize(paramDrawable);
        if (!(paramDrawable instanceof RegionDrawable)) {
          break;
        }
        paramDrawable = ((RegionDrawable)paramDrawable).getBitmapRef();
      } while (paramDrawable == null);
      paramDrawable = paramDrawable.getBitmap();
    } while (paramDrawable == null);
    return BitmapUtils.getBitmapAllocSize(paramDrawable);
    int j = paramDrawable.getIntrinsicHeight();
    int k = paramDrawable.getIntrinsicWidth();
    int i = j;
    if (j < 1) {
      i = 1;
    }
    j = k;
    if (k < 1) {
      j = 1;
    }
    return j * i * 4;
  }
  
  private LruCache<Integer, Drawable> getDrawableCache()
  {
    if (this.mImageKeyHash2DrawableMap == null) {}
    synchronized (LOCK_CacheMap)
    {
      if (this.mImageKeyHash2DrawableMap == null) {
        this.mImageKeyHash2DrawableMap = new ImageManager.6(this, this.imageMemCacheSize);
      }
      return this.mImageKeyHash2DrawableMap;
    }
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
    if (this.mImageKeyHash2ImageMap == null) {}
    synchronized (LOCK_CacheMap)
    {
      if (this.mImageKeyHash2ImageMap == null) {
        this.mImageKeyHash2ImageMap = new ImageManager.7(this, this.imageMemCacheSize);
      }
      return this.mImageKeyHash2ImageMap;
    }
  }
  
  public static ImageManager getInstance()
  {
    if (mInstance == null) {}
    synchronized (LOCK_mInstance)
    {
      if (mInstance == null) {
        mInstance = new ImageManager();
      }
      return mInstance;
    }
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
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramContext = getCachePath(paramContext);; paramContext = getCachePath(paramContext, paramString2))
    {
      paramContext = new File(paramContext + File.separator + String.valueOf(ImageKey.getUrlKey(paramString1, false).hashCode()));
      SharpPUtils.deleteSharppCacheFileIfNessary(paramContext, paramString1);
      return paramContext;
    }
  }
  
  private String getNocacheFilePath(ImageKey paramImageKey, boolean paramBoolean)
  {
    if (paramBoolean) {
      return getCachePathNocacheOrCreateIfInexistence(this.mContext) + urlKey2FileName(paramImageKey.urlKey, true);
    }
    return getCachePathNocache(this.mContext) + urlKey2FileName(paramImageKey.urlKey, true);
  }
  
  public static String getStorePath(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = "";
    localObject2 = str1;
    try
    {
      String str2 = Environment.getExternalStorageState();
      localObject2 = str1;
      maxCacheSize = MAX_INNER_SIZE_LIMIT;
      localObject2 = str1;
      isUseExternalStorage = false;
      localObject1 = str1;
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
            localObject2 = str1;
            storeRootPath = Environment.getExternalStorageDirectory().getAbsolutePath();
            localObject2 = str1;
            localObject1 = ImageManagerEnv.g().getImageCacheDir(true);
          }
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label145:
        Object localObject1 = localObject2;
        localException1.printStackTrace();
      }
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label397;
      }
      localObject2 = paramContext.getExternalCacheDir() + File.separator + "qzone";
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      break label384;
      break label145;
    }
    localObject2 = localObject1;
    maxCacheSize = MAX_SDCARD_SIZE_LIMIT;
    localObject2 = localObject1;
    isUseExternalStorage = true;
    if (!isUseExternalStorage)
    {
      storeRootPath = Environment.getDataDirectory().getAbsolutePath();
      localObject2 = ImageManagerEnv.g().getImageCacheDir(false);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = paramContext.getCacheDir().getAbsolutePath() + File.separator + "qzone";
      }
    }
    paramContext = paramString;
    if (!paramString.startsWith(File.separator)) {
      paramContext = File.separator + paramString;
    }
    paramString = paramContext;
    if (!paramContext.endsWith(File.separator)) {
      paramString = paramContext + File.separator;
    }
    paramContext = new File((String)localObject1 + paramString);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    paramString = paramContext.getAbsolutePath();
    paramContext = paramString;
    if (!paramString.endsWith(File.separator)) {
      paramContext = paramString + File.separator;
    }
    return paramContext;
  }
  
  public static Handler getSuperResolutionHandler()
  {
    if (mSuperResolutionHandler == null) {}
    try
    {
      if (mSuperResolutionHandler == null)
      {
        mImageSuperResolutionHandlerThread = new HandlerThread("super_resolution_handler_thread");
        mImageSuperResolutionHandlerThread.start();
        mSuperResolutionHandler = new ImageManager.15(mImageSuperResolutionHandlerThread.getLooper());
      }
      return mSuperResolutionHandler;
    }
    finally {}
  }
  
  private void handleDumpMemoryCacheBroadcast(Message paramMessage)
  {
    int i;
    int j;
    try
    {
      i = paramMessage.arg1;
      j = paramMessage.arg2;
      if (this.mImageKeyHash2DrawableMap != null)
      {
        paramMessage = this.mImageKeyHash2DrawableMap.snapshot();
        if (paramMessage != null)
        {
          ImageManagerLog.w(TAG, "memory cache, cache size = " + this.imageMemCacheSize + ", length = " + paramMessage.size() + ", cache info = " + this.mImageKeyHash2DrawableMap.toString());
          Iterator localIterator = paramMessage.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            if (localObject != null)
            {
              int k = ((Integer)((Map.Entry)localObject).getKey()).intValue();
              int m = getDrawableAllocSize((Drawable)((Map.Entry)localObject).getValue());
              localObject = (String)this.mImageKeyHash2UrlMap.get(Integer.valueOf(k));
              ImageManagerLog.w(TAG, "memory cache, key = " + k + ", drawable size = " + m + ", url = " + (String)localObject);
            }
          }
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception paramMessage)
    {
      paramMessage.printStackTrace();
    }
    saveBitmapToSdcard(i, paramMessage, j);
  }
  
  private void handleIamgeTracer(Message paramMessage)
  {
    if ((paramMessage.obj instanceof ImageKey))
    {
      if (paramMessage.arg1 == 16) {
        ImageTaskTracer.traceImageGet((ImageKey)paramMessage.obj, true);
      }
    }
    else {
      return;
    }
    ImageTaskTracer.traceImageGet((ImageKey)paramMessage.obj, false);
  }
  
  private void handleImageGetNull(Message paramMessage)
  {
    if ((paramMessage.obj instanceof ImageKey))
    {
      paramMessage = (ImageKey)paramMessage.obj;
      paramMessage.options = ImageLoader.Options.copy(paramMessage.options);
      if (paramMessage.flag == 0) {
        paramMessage.recycle();
      }
    }
    else
    {
      return;
    }
    Object localObject;
    if ((paramMessage.isSuperResolutionUrl) && (!paramMessage.isHighScaleUrl) && (!TextUtils.isEmpty(paramMessage.bigUrl)))
    {
      localObject = ImageKey.getUrlKey(paramMessage.bigUrl, true);
      String str = getCachePath(this.mContext);
      localObject = new File(str + urlKey2FileName((String)localObject, true));
      if ((ImageManagerEnv.g().enableSuperResolution()) && (!((File)localObject).exists())) {
        break label194;
      }
      ImageManagerLog.w("superresolution", "big cache file exists. url=" + paramMessage.url);
      paramMessage.srUrl = paramMessage.url;
      paramMessage.setUrl(paramMessage.bigUrl);
    }
    for (;;)
    {
      localObject = ImageTaskBuilder.buildImageTask(paramMessage);
      ImageTaskTracer.removeImageMsgGetNullRecord(paramMessage.hashCodeEx());
      if (localObject == null) {
        break;
      }
      ((ImageTask)localObject).excuteTask();
      return;
      label194:
      if (!ImageManagerEnv.g().hasSuperResolutionInit())
      {
        localObject = getCachePathSR(this.mContext);
        if (!new File((String)localObject + urlKey2FileName(paramMessage.urlKey, true)).exists())
        {
          ImageManagerLog.w("superresolution", "library not init. use big url. url=" + paramMessage.url);
          paramMessage.srUrl = paramMessage.url;
          paramMessage.setUrl(paramMessage.bigUrl);
          getSuperResolutionHandler().post(new ImageManager.8(this));
        }
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
    if (this.mImageGetNullOrCancelHandler == null) {}
    synchronized (LOCK_mImageGetNullOrCancelHandler)
    {
      if (this.mImageGetNullOrCancelHandler == null) {
        this.mImageGetNullOrCancelHandler = new ImageManager.5(this, this.dispatcherLoop);
      }
      return this.mImageGetNullOrCancelHandler;
    }
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
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))) {
        return true;
      }
    } while ((URLUtil.isFileUrl(paramString)) || (paramString.startsWith("avatar://")));
    return URLUtil.isNetworkUrl(paramString);
  }
  
  private static boolean isStorageReallyCanwrite(String paramString)
  {
    localObject = (Boolean)isStorageReallyCanwriteMap.get(paramString);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    bool2 = false;
    bool1 = false;
    long l = Thread.currentThread().getId();
    localObject = new File(paramString + "/qz" + l);
    for (;;)
    {
      try
      {
        if (!((File)localObject).exists()) {
          continue;
        }
        if (((File)localObject).delete()) {
          bool1 = ((File)localObject).createNewFile();
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        ((File)localObject).delete();
        bool1 = bool2;
        continue;
      }
      finally
      {
        ((File)localObject).delete();
      }
      isStorageReallyCanwriteMap.put(paramString, Boolean.valueOf(bool1));
      return bool1;
      bool1 = ((File)localObject).createNewFile();
    }
  }
  
  private void loadLruFileTime(ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
  {
    Object localObject1 = getCachePath(this.mContext) + "imagelru.usetime";
    for (;;)
    {
      String str;
      Object localObject2;
      int i;
      try
      {
        localObject1 = new File((String)localObject1);
        if (((File)localObject1).exists())
        {
          localObject1 = new BufferedReader(new FileReader((File)localObject1));
          str = ((BufferedReader)localObject1).readLine();
          if (str != null)
          {
            localObject2 = str.split("|");
            if ((localObject2 == null) || (localObject2.length != 2)) {
              continue;
            }
            str = localObject2[0];
            i = Integer.parseInt(localObject2[1]);
            localObject2 = (Integer)paramConcurrentHashMap.get(str);
            if (localObject2 != null) {
              break label141;
            }
            paramConcurrentHashMap.put(str, Integer.valueOf(i));
            continue;
          }
        }
        return;
      }
      catch (Throwable paramConcurrentHashMap)
      {
        paramConcurrentHashMap.printStackTrace();
      }
      label141:
      if (i > ((Integer)localObject2).intValue()) {
        paramConcurrentHashMap.put(str, Integer.valueOf(i));
      }
    }
  }
  
  private static int parseInt(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
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
    ImageManagerEnv.g().getQQImagecache().put(paramInt + "", paramDrawable);
  }
  
  private void putImageKey(Map<Integer, HashSet<ImageKey>> paramMap, int paramInt, ImageKey paramImageKey)
  {
    if ((paramMap == null) || (paramImageKey == null)) {
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
  
  private void putImageKeyList(Map<Integer, HashSet<ImageKey>> paramMap, int paramInt, HashSet<ImageKey> paramHashSet)
  {
    if ((paramMap == null) || (paramHashSet == null)) {
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
    ImageManagerEnv.g().getQQImagecache().remove(paramInt + "");
  }
  
  static boolean removeInvalidatedUrl(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
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
    //   1: ifeq +165 -> 166
    //   4: aload_2
    //   5: ifnull +161 -> 166
    //   8: aload_2
    //   9: iload_1
    //   10: invokestatic 722	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   13: invokeinterface 1401 2 0
    //   18: checkcast 833	android/graphics/drawable/Drawable
    //   21: invokestatic 1449	com/tencent/component/media/image/ImageManager:drawableToBitmap	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   24: astore 5
    //   26: invokestatic 1112	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   29: invokevirtual 1115	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   32: astore_2
    //   33: new 681	java/io/File
    //   36: dup
    //   37: new 448	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 449	java/lang/StringBuilder:<init>	()V
    //   44: aload_2
    //   45: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: getstatic 964	java/io/File:separator	Ljava/lang/String;
    //   51: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc_w 1121
    //   57: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokespecial 686	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore 4
    //   68: aload 4
    //   70: invokevirtual 689	java/io/File:exists	()Z
    //   73: ifne +9 -> 82
    //   76: aload 4
    //   78: invokevirtual 1136	java/io/File:mkdirs	()Z
    //   81: pop
    //   82: iload_3
    //   83: ifne +84 -> 167
    //   86: new 448	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 449	java/lang/StringBuilder:<init>	()V
    //   93: iload_1
    //   94: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: ldc_w 1451
    //   100: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: astore_2
    //   107: new 681	java/io/File
    //   110: dup
    //   111: aload 4
    //   113: aload_2
    //   114: invokespecial 1453	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   117: astore_2
    //   118: new 888	java/io/FileOutputStream
    //   121: dup
    //   122: aload_2
    //   123: invokespecial 1454	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   126: astore 4
    //   128: iload_3
    //   129: ifne +62 -> 191
    //   132: aload 4
    //   134: astore_2
    //   135: aload 5
    //   137: getstatic 1460	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   140: bipush 100
    //   142: aload 4
    //   144: invokevirtual 1464	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   147: pop
    //   148: aload 4
    //   150: astore_2
    //   151: aload 4
    //   153: invokevirtual 930	java/io/FileOutputStream:flush	()V
    //   156: aload 4
    //   158: ifnull +8 -> 166
    //   161: aload 4
    //   163: invokevirtual 919	java/io/FileOutputStream:close	()V
    //   166: return
    //   167: new 448	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 449	java/lang/StringBuilder:<init>	()V
    //   174: iload_1
    //   175: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: ldc_w 1466
    //   181: invokevirtual 455	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: astore_2
    //   188: goto -81 -> 107
    //   191: aload 4
    //   193: astore_2
    //   194: aload 5
    //   196: getstatic 1469	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   199: bipush 100
    //   201: aload 4
    //   203: invokevirtual 1464	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   206: pop
    //   207: goto -59 -> 148
    //   210: astore 5
    //   212: aload 4
    //   214: astore_2
    //   215: aload 5
    //   217: invokevirtual 931	java/io/IOException:printStackTrace	()V
    //   220: aload 4
    //   222: ifnull -56 -> 166
    //   225: aload 4
    //   227: invokevirtual 919	java/io/FileOutputStream:close	()V
    //   230: return
    //   231: astore_2
    //   232: aload_2
    //   233: invokevirtual 916	java/lang/Exception:printStackTrace	()V
    //   236: return
    //   237: astore_2
    //   238: aload_2
    //   239: invokevirtual 916	java/lang/Exception:printStackTrace	()V
    //   242: return
    //   243: astore 4
    //   245: aconst_null
    //   246: astore_2
    //   247: aload_2
    //   248: ifnull +7 -> 255
    //   251: aload_2
    //   252: invokevirtual 919	java/io/FileOutputStream:close	()V
    //   255: aload 4
    //   257: athrow
    //   258: astore_2
    //   259: aload_2
    //   260: invokevirtual 916	java/lang/Exception:printStackTrace	()V
    //   263: goto -8 -> 255
    //   266: astore 4
    //   268: goto -21 -> 247
    //   271: astore 5
    //   273: aconst_null
    //   274: astore 4
    //   276: goto -64 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	ImageManager
    //   0	279	1	paramInt1	int
    //   0	279	2	paramMap	Map<Integer, Drawable>
    //   0	279	3	paramInt2	int
    //   66	160	4	localObject1	Object
    //   243	13	4	localObject2	Object
    //   266	1	4	localObject3	Object
    //   274	1	4	localObject4	Object
    //   24	171	5	localBitmap	Bitmap
    //   210	6	5	localIOException1	java.io.IOException
    //   271	1	5	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   135	148	210	java/io/IOException
    //   151	156	210	java/io/IOException
    //   194	207	210	java/io/IOException
    //   225	230	231	java/lang/Exception
    //   161	166	237	java/lang/Exception
    //   118	128	243	finally
    //   251	255	258	java/lang/Exception
    //   135	148	266	finally
    //   151	156	266	finally
    //   194	207	266	finally
    //   215	220	266	finally
    //   118	128	271	java/io/IOException
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
      }
      return;
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
    //   0: new 681	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 686	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 689	java/io/File:exists	()Z
    //   13: ifeq +113 -> 126
    //   16: new 1350	java/io/BufferedReader
    //   19: dup
    //   20: new 1352	java/io/FileReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 1355	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: invokespecial 1358	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 1361	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +87 -> 127
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc_w 1482
    //   49: invokevirtual 1130	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   52: ifeq -20 -> 32
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 1484
    //   61: invokevirtual 1365	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   83: new 681	java/io/File
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 686	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: invokevirtual 689	java/io/File:exists	()Z
    //   94: ifeq -62 -> 32
    //   97: aload_1
    //   98: astore_0
    //   99: getstatic 224	com/tencent/component/media/image/ImageManager:mSDCardName2PathMap	Ljava/util/HashMap;
    //   102: aload_3
    //   103: aload_2
    //   104: invokevirtual 1348	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: goto -76 -> 32
    //   111: astore_2
    //   112: aload_1
    //   113: astore_0
    //   114: aload_2
    //   115: invokevirtual 916	java/lang/Exception:printStackTrace	()V
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 1485	java/io/BufferedReader:close	()V
    //   126: return
    //   127: aload_1
    //   128: astore_0
    //   129: aload_1
    //   130: invokevirtual 1485	java/io/BufferedReader:close	()V
    //   133: aload_1
    //   134: ifnull -8 -> 126
    //   137: aload_1
    //   138: invokevirtual 1485	java/io/BufferedReader:close	()V
    //   141: return
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 931	java/io/IOException:printStackTrace	()V
    //   147: return
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 931	java/io/IOException:printStackTrace	()V
    //   153: return
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_0
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 1485	java/io/BufferedReader:close	()V
    //   165: aload_1
    //   166: athrow
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 931	java/io/IOException:printStackTrace	()V
    //   172: goto -7 -> 165
    //   175: astore_1
    //   176: goto -19 -> 157
    //   179: astore_2
    //   180: aconst_null
    //   181: astore_1
    //   182: goto -70 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString	String
    //   31	107	1	localBufferedReader	BufferedReader
    //   154	12	1	localObject1	Object
    //   175	1	1	localObject2	Object
    //   181	1	1	localObject3	Object
    //   38	66	2	str	String
    //   111	4	2	localException1	Exception
    //   179	1	2	localException2	Exception
    //   64	39	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   34	39	111	java/lang/Exception
    //   45	55	111	java/lang/Exception
    //   57	65	111	java/lang/Exception
    //   67	73	111	java/lang/Exception
    //   83	97	111	java/lang/Exception
    //   99	108	111	java/lang/Exception
    //   129	133	111	java/lang/Exception
    //   137	141	142	java/io/IOException
    //   122	126	148	java/io/IOException
    //   16	32	154	finally
    //   161	165	167	java/io/IOException
    //   34	39	175	finally
    //   45	55	175	finally
    //   57	65	175	finally
    //   67	73	175	finally
    //   83	97	175	finally
    //   99	108	175	finally
    //   114	118	175	finally
    //   129	133	175	finally
    //   16	32	179	java/lang/Exception
  }
  
  public static String urlKey2FileName(String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = String.valueOf(paramString.hashCode());
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.startsWith("file://"));
    return paramString.substring("file://".length(), paramString.length());
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
          if (TextUtils.isEmpty(maxAvailableSizePath)) {
            break label238;
          }
          mCachePath = getStorePath(this.mContext, "imageV2", false, true);
          paramImageKey.filePath = (getCachePath(this.mContext) + urlKey2FileName(paramImageKey.urlKey, true));
          clearAllImageFile();
          this.isStorageLow = isAvailableStorageSizeLow();
          if (this.isStorageLow)
          {
            mCachePath = getStorePath(this.mContext, "imageV2", true, false);
            paramImageKey.filePath = (getCachePath(this.mContext) + urlKey2FileName(paramImageKey.urlKey, true));
            clearAllImageFile();
          }
        }
      }
    }
    for (this.isStorageLow = isAvailableStorageSizeLow();; this.isStorageLow = isAvailableStorageSizeLow())
    {
      if ((this.isStorageLow) && (isMainProcess)) {
        ImageManagerEnv.g().showToast(0, this.mContext, "手机存储空间不足，图片无法下载展示，请及时清理！", 17);
      }
      if (!this.isStorageLow) {
        break;
      }
      return false;
      label238:
      mCachePath = getStorePath(this.mContext, "imageV2", true, false);
      paramImageKey.filePath = (getCachePath(this.mContext) + urlKey2FileName(paramImageKey.urlKey, true));
      clearAllImageFile();
    }
    return true;
  }
  
  public void cancel(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
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
  
  public int capacity()
  {
    return this.imageMemCacheSize;
  }
  
  void checkBitmapDecodeFailCount(ImageKey paramImageKey)
  {
    Integer localInteger;
    if (paramImageKey.isNetworkUrl)
    {
      localInteger = (Integer)mDecodeExceptionMap.get(paramImageKey.filePath);
      if (localInteger == null) {
        break label113;
      }
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
      }
    }
    else
    {
      return;
    }
    mDecodeExceptionMap.put(paramImageKey.filePath, Integer.valueOf(localInteger.intValue() + 1));
    return;
    label113:
    mDecodeExceptionMap.put(paramImageKey.filePath, Integer.valueOf(1));
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
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return;
      paramString = ImageKey.getUrlKey(paramString, false);
      paramString = (HashSet)this.mUrlKey2AllImageKeyMap.remove(paramString);
    } while (paramString == null);
    paramString = paramString.iterator();
    label39:
    int i;
    if (paramString.hasNext())
    {
      i = ((Integer)paramString.next()).intValue();
      if (!IS_ICE_CREAM_SANDWICH) {
        break label87;
      }
      remove(i);
    }
    for (;;)
    {
      this.mImageKeyHash2UrlMap.remove(Integer.valueOf(i));
      break label39;
      break;
      label87:
      getImageCache().remove(Integer.valueOf(i));
    }
  }
  
  public void clear(String paramString, ImageLoader.Options paramOptions)
  {
    ImageKey localImageKey = ImageKey.obtain();
    localImageKey.setUrl(paramString);
    localImageKey.options = paramOptions;
    int i = localImageKey.hashCodeEx();
    if ((localImageKey.urlKey == null) || (IS_ICE_CREAM_SANDWICH)) {
      remove(i);
    }
    for (;;)
    {
      this.mImageKeyHash2UrlMap.remove(Integer.valueOf(i));
      localImageKey.recycle();
      return;
      getImageCache().remove(Integer.valueOf(i));
    }
  }
  
  public void clear(boolean paramBoolean)
  {
    if (IS_ICE_CREAM_SANDWICH) {
      evictAll();
    }
    for (;;)
    {
      ImageKey.clearAndInitSize();
      if (paramBoolean) {
        clearAllImageFile();
      }
      this.mUrlKey2AllImageKeyMap.clear();
      this.mImageKeyHash2UrlMap.clear();
      return;
      getImageCache().evictAll();
    }
  }
  
  public void clearMemoryCache()
  {
    clear(false);
  }
  
  public BitmapReference getBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if (this.mBitmapFactory != null) {
      return this.mBitmapFactory.createBitmap(paramInt1, paramInt2, paramConfig);
    }
    return BitmapReference.getBitmapReference(Bitmap.createBitmap(paramInt1, paramInt2, paramConfig));
  }
  
  public IDecoder getDecoder()
  {
    return this.mDecoder;
  }
  
  Drawable getDrawbleFromCache(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {}
    do
    {
      return null;
      if (!removeInvalidatedUrl(paramImageKey.url)) {
        break;
      }
      clear(paramImageKey.url);
    } while ((!paramImageKey.isSuperResolutionUrl) || (paramImageKey.isHighScaleUrl));
    if (removeInvalidatedUrl(paramImageKey.bigUrl))
    {
      clear(paramImageKey.bigUrl);
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (IS_ICE_CREAM_SANDWICH)
    {
      if ((!paramImageKey.isSuperResolutionUrl) || (paramImageKey.isHighScaleUrl) || (TextUtils.isEmpty(paramImageKey.bigUrl))) {
        break label801;
      }
      localObject1 = ImageKey.copy(paramImageKey);
      ((ImageKey)localObject1).setUrl(paramImageKey.bigUrl);
      localObject2 = get(((ImageKey)localObject1).hashCodeEx());
      if (localObject2 != null) {
        paramImageKey.setUrl(paramImageKey.bigUrl);
      }
      ((ImageKey)localObject1).recycle();
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = get(paramImageKey.hashCodeEx());
        }
        long l;
        if ((localObject1 != null) && (this.mHasEntryNoCacheUrlKeyAndCacheTimeMap))
        {
          localObject2 = (Long)this.mNoCacheUrlKeyAndCacheTimeMap.get(paramImageKey.urlKey);
          if (localObject2 != null)
          {
            ImageManagerLog.w(TAG, "getDrawbleFromCache, use no-cache, url = " + paramImageKey.url + ", cache_time = " + localObject2);
            l = ImageManagerEnv.g().getNoCacheImageExpiredTime();
            if (System.currentTimeMillis() - ((Long)localObject2).longValue() >= l * 1000L)
            {
              this.mNoCacheUrlKeyAndCacheTimeMap.remove(paramImageKey.urlKey);
              if (this.mNoCacheUrlKeyAndCacheTimeMap.size() == 0) {
                this.mHasEntryNoCacheUrlKeyAndCacheTimeMap = false;
              }
              clear(paramImageKey.url);
              ImageManagerLog.w(TAG, "getDrawbleFromCache, clear no-cache memory, url = " + paramImageKey.url);
            }
          }
        }
        for (paramImageKey = null; paramImageKey != null; paramImageKey = (ImageKey)localObject1)
        {
          return paramImageKey;
          if (!TextUtils.isEmpty(paramImageKey.filePath))
          {
            localObject2 = new File(paramImageKey.filePath);
            ImageManagerLog.d(TAG, "getDrawbleFromCache, use no-cache drawable, url=" + paramImageKey.url + ", file length=" + ((File)localObject2).length());
          }
        }
        break;
        localObject2 = (Image)getImageCache().get(Integer.valueOf(paramImageKey.hashCodeEx()));
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.mHasEntryNoCacheUrlKeyAndCacheTimeMap)
          {
            Long localLong = (Long)this.mNoCacheUrlKeyAndCacheTimeMap.get(paramImageKey.urlKey);
            ImageManagerLog.w(TAG, "getDrawbleFromCache, use no-cache, url = " + paramImageKey.url + ", cache_time = " + localLong);
            if (localLong == null) {
              break label620;
            }
            l = ImageManagerEnv.g().getNoCacheImageExpiredTime();
            localObject1 = localObject2;
            if (System.currentTimeMillis() - localLong.longValue() >= l * 1000L)
            {
              this.mNoCacheUrlKeyAndCacheTimeMap.remove(paramImageKey.urlKey);
              if (this.mNoCacheUrlKeyAndCacheTimeMap.size() == 0) {
                this.mHasEntryNoCacheUrlKeyAndCacheTimeMap = false;
              }
              clear(paramImageKey.url);
              ImageManagerLog.w(TAG, "getDrawbleFromCache, clear no-cache memory, url = " + paramImageKey.url);
              localObject1 = null;
            }
          }
        }
        label589:
        if (localObject1 == null) {
          break;
        }
        try
        {
          if ((localObject1 instanceof FeedsBitmapImage))
          {
            paramImageKey = new SpecifiedBitmapDrawable(((FeedsBitmapImage)localObject1).getBitmap());
            return paramImageKey;
            label620:
            localObject1 = localObject2;
            if (TextUtils.isEmpty(paramImageKey.filePath)) {
              break label589;
            }
            localObject1 = new File(paramImageKey.filePath);
            ImageManagerLog.d(TAG, "getDrawbleFromCache, use no-cache drawable, url=" + paramImageKey.url + ", file length=" + ((File)localObject1).length());
            localObject1 = localObject2;
            break label589;
          }
          if ((localObject1 instanceof BitmapImage))
          {
            if ((paramImageKey.options != null) && (paramImageKey.options.extraProcessor != null))
            {
              localObject1 = new BitmapImageDrawable((BitmapImage)localObject1, paramImageKey.options.clipWidth, paramImageKey.options.clipHeight);
              return paramImageKey.options.extraProcessor.doProcess((Drawable)localObject1);
            }
            return new SpecifiedBitmapDrawable(((BitmapImage)localObject1).getBitmap());
          }
          if (!(localObject1 instanceof NewGifImage)) {
            break;
          }
          paramImageKey = ((NewGifImage)localObject1).getDrawable();
          return paramImageKey;
        }
        catch (Throwable paramImageKey)
        {
          return null;
        }
      }
      label801:
      localObject2 = null;
    }
  }
  
  public Drawable getImage(ImageUrl paramImageUrl, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions, byte paramByte, ImageLoader.ImageDownloadListener paramImageDownloadListener)
  {
    if (paramImageUrl == null)
    {
      paramImageUrl = null;
      return paramImageUrl;
    }
    ImageKey localImageKey = ImageKey.obtain();
    localImageKey.setUrl(paramImageUrl);
    localImageKey.options = paramOptions;
    localImageKey.flag = paramByte;
    localImageKey.listener = paramImageLoadListener;
    boolean bool;
    if (localImageKey.options == null)
    {
      bool = false;
      label49:
      localImageKey.needCallBackProcessPercent = bool;
      localImageKey.imglistener = paramImageDownloadListener;
      if ((localImageKey.isSuperResolutionUrl) && (!localImageKey.isHighScaleUrl))
      {
        paramImageLoadListener = paramImageUrl.url;
        if (TextUtils.isEmpty(paramImageUrl.bigUrl)) {
          break label218;
        }
      }
    }
    label218:
    for (paramImageUrl = paramImageUrl.bigUrl;; paramImageUrl = ImageManagerEnv.g().convertSrUrlToBigUrl(paramImageLoadListener))
    {
      if (paramImageUrl != null) {
        localImageKey.bigUrl = paramImageUrl;
      }
      paramImageLoadListener = getDrawbleFromCache(localImageKey);
      if (paramImageLoadListener == null) {
        break label229;
      }
      if ((isInFriendFeed) && (paramOptions != null) && (!paramOptions.isPreDecode) && (hasScrolled) && (!paramOptions.disableHitRateReport))
      {
        paramImageUrl = imageGetNullOrCancelHandler().obtainMessage();
        paramImageUrl.what = 2;
        paramImageUrl.obj = localImageKey;
        paramImageUrl.arg1 = 16;
        imageGetNullOrCancelHandler().sendMessage(paramImageUrl);
      }
      if (paramOptions != null)
      {
        paramImageUrl = paramImageLoadListener;
        if (paramOptions.isGifPlayWhileDownloading == true) {
          break;
        }
      }
      localImageKey.recycle();
      return paramImageLoadListener;
      bool = localImageKey.options.needCallBackProcessPercent;
      break label49;
    }
    label229:
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
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramString = null;
      return paramString;
    }
    ImageKey localImageKey = ImageKey.obtain();
    localImageKey.setUrl(paramString);
    localImageKey.options = paramOptions;
    localImageKey.flag = paramByte;
    localImageKey.listener = paramImageLoadListener;
    if (localImageKey.options == null) {}
    for (boolean bool = false;; bool = localImageKey.options.needCallBackProcessPercent)
    {
      localImageKey.needCallBackProcessPercent = bool;
      localImageKey.imglistener = paramImageDownloadListener;
      if ((localImageKey.isSuperResolutionUrl) && (!localImageKey.isHighScaleUrl))
      {
        paramString = ImageManagerEnv.g().convertSrUrlToBigUrl(paramString);
        if (paramString != null) {
          localImageKey.bigUrl = paramString;
        }
      }
      paramImageLoadListener = getDrawbleFromCache(localImageKey);
      if (paramImageLoadListener == null) {
        break label213;
      }
      if ((isInFriendFeed) && (paramOptions != null) && (!paramOptions.isPreDecode) && (hasScrolled) && (!paramOptions.disableHitRateReport))
      {
        paramString = imageGetNullOrCancelHandler().obtainMessage();
        paramString.what = 2;
        paramString.obj = localImageKey;
        paramString.arg1 = 16;
        imageGetNullOrCancelHandler().sendMessage(paramString);
      }
      if (paramOptions != null)
      {
        paramString = paramImageLoadListener;
        if (paramOptions.isGifPlayWhileDownloading == true) {
          break;
        }
      }
      localImageKey.recycle();
      return paramImageLoadListener;
    }
    label213:
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
    return null;
  }
  
  public Drawable getImageByUrlInMemory(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    Object localObject;
    do
    {
      int i;
      do
      {
        while (!paramString.hasNext())
        {
          do
          {
            return null;
            paramString = ImageKey.getUrlKey(paramString, false);
            paramString = (HashSet)this.mUrlKey2AllImageKeyMap.get(paramString);
          } while ((paramString == null) || (paramString.size() <= 0));
          paramString = paramString.iterator();
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
    try
    {
      if ((localObject instanceof FeedsBitmapImage)) {
        paramString = new SpecifiedBitmapDrawable(((FeedsBitmapImage)localObject).getBitmap());
      } else if ((localObject instanceof BitmapImage)) {
        paramString = new SpecifiedBitmapDrawable(((BitmapImage)localObject).getBitmap());
      }
    }
    catch (Throwable paramString)
    {
      paramString = null;
    }
    paramString = null;
    return paramString;
  }
  
  public File getImageFile(String paramString, ImageLoader.Options paramOptions)
  {
    Object localObject = null;
    File localFile1;
    if (isNetworkUrl(paramString))
    {
      String str = urlKey2FileName(ImageKey.getUrlKey(paramString, true), true);
      File localFile2 = (File)this.mFilename2FileMap.get(str);
      localFile1 = localFile2;
      if (localFile2 == null)
      {
        if ((paramOptions == null) || (paramOptions.fileRootPath == null) || (paramOptions.fileRootPath.length() <= 0)) {
          break label141;
        }
        paramOptions = paramOptions.fileRootPath;
        localFile1 = new File(paramOptions + str);
        if (!localFile1.exists()) {
          break label162;
        }
        this.mFilename2FileMap.put(str, localFile1);
        this.mTotalFileSize += localFile1.length();
      }
    }
    for (;;)
    {
      SharpPUtils.deleteSharppCacheFileIfNessary(localFile1, paramString);
      SharpPUtils.checkNotSharppCacheFileIfNessary(localFile1, paramString);
      paramOptions = localFile1;
      label141:
      do
      {
        return paramOptions;
        paramOptions = localObject;
      } while (mLoadAllImageFileFlag == true);
      paramOptions = getCachePath(this.mContext);
      break;
      label162:
      localFile1 = getImageFileForSuperResolution(paramString);
      continue;
      localFile1 = null;
    }
  }
  
  public File getImageFileForSuperResolution(String paramString)
  {
    if (ImageManagerEnv.g().isSuperResolutionUrl(paramString))
    {
      Object localObject1;
      if (ImageManagerEnv.g().isHighScaleUrl(paramString))
      {
        localObject1 = getCachePathSR(this.mContext);
        localObject1 = new File((String)localObject1 + urlKey2FileName(ImageKey.getUrlKey(paramString, true), true));
        if (!((File)localObject1).exists()) {}
      }
      do
      {
        Object localObject2;
        do
        {
          do
          {
            return localObject1;
            localObject1 = ImageKey.getUrlKey4NoneHighScale(paramString, true);
            localObject2 = getCachePath(this.mContext);
            localObject2 = new File((String)localObject2 + urlKey2FileName((String)localObject1, true));
            localObject1 = localObject2;
          } while (((File)localObject2).exists());
          localObject1 = ImageManagerEnv.g().convertSrUrlToBigUrl(paramString);
          if (localObject1 == null) {
            break;
          }
          localObject1 = ImageKey.getUrlKey((String)localObject1, true);
          localObject2 = getCachePath(this.mContext);
          localObject2 = new File((String)localObject2 + urlKey2FileName((String)localObject1, true));
          localObject1 = localObject2;
        } while (((File)localObject2).exists());
        localObject1 = getCachePathSR(this.mContext);
        paramString = new File((String)localObject1 + urlKey2FileName(ImageKey.getUrlKey(paramString, true), true));
        localObject1 = paramString;
      } while (paramString.exists());
    }
    return null;
  }
  
  void imageKeyFilePathCheck(ImageKey paramImageKey)
  {
    Object localObject1;
    String str;
    if ((paramImageKey.filePath == null) || (paramImageKey.filePath.length() == 0))
    {
      if (!paramImageKey.isNetworkUrl) {
        break label396;
      }
      localObject1 = paramImageKey.urlKey;
      if ((paramImageKey.options == null) || (paramImageKey.options.fileRootPath == null) || (paramImageKey.options.fileRootPath.length() <= 0)) {
        break label151;
      }
      str = paramImageKey.options.fileRootPath;
    }
    label151:
    label444:
    for (;;)
    {
      paramImageKey.filePath = (str + urlKey2FileName((String)localObject1, true));
      for (;;)
      {
        if ((!TextUtils.isEmpty(paramImageKey.filePath)) && (VideoThumbnail.isVideo(paramImageKey.filePath)))
        {
          str = VideoThumbnail.queryVideoThumbnailFilePath(ImageManagerEnv.getAppContext(), paramImageKey.filePath);
          if ((!TextUtils.isEmpty(str)) && (new File(str).exists())) {
            paramImageKey.filePath = str;
          }
        }
        return;
        if (ImageManagerEnv.g().isSuperResolutionUrl(paramImageKey.url))
        {
          str = getCachePathSR(this.mContext);
          Object localObject2 = new File(str + urlKey2FileName(paramImageKey.urlKey, true));
          if (((File)localObject2).exists())
          {
            ImageManagerLog.w("superresolution", "using cache. url=" + paramImageKey.url + " filePath=" + ((File)localObject2).getAbsolutePath());
            paramImageKey.needSuperResolution = false;
            break;
          }
          str = getCachePath(this.mContext);
          if (!ImageManagerEnv.g().isHighScaleUrl(paramImageKey.url)) {
            break label444;
          }
          localObject2 = ImageKey.getUrlKey4NoneHighScale(paramImageKey.url, true);
          File localFile = new File(str + urlKey2FileName((String)localObject2, true));
          if (!localFile.exists()) {
            break label444;
          }
          ImageManagerLog.w("superresolution", "high scale. using normal big cache. url=" + paramImageKey.url + " filePath=" + localFile.getAbsolutePath());
          localObject1 = localObject2;
          break;
        }
        str = getCachePath(this.mContext);
        break;
        if ((ImageManagerEnv.g().needCheckAvatar()) && (paramImageKey.isAvatarUrl())) {
          paramImageKey.filePath = ImageManagerEnv.g().getAvatarPath(paramImageKey.url);
        } else {
          paramImageKey.filePath = urlKey2FileName(paramImageKey.urlKey, false);
        }
      }
    }
  }
  
  protected void nocachedDeleteLocalFile(ImageKey paramImageKey)
  {
    File localFile;
    if ((this.mHasEntryNoCacheUrlKeyAndCacheTimeMap) && (this.mNoCacheUrlKeyAndCacheTimeMap.containsKey(paramImageKey.urlKey)))
    {
      localFile = new File(paramImageKey.filePath);
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        ImageManagerLog.w(TAG, "nocachedDeleteLocalFile, delete local file is: " + bool + ", url = " + paramImageKey.url + ", filePath=" + paramImageKey.filePath);
        if (bool)
        {
          paramImageKey = new File(getNocacheFilePath(paramImageKey, false));
          if (paramImageKey.exists()) {
            paramImageKey.delete();
          }
        }
      }
    }
    do
    {
      return;
      localFile = new File(getNocacheFilePath(paramImageKey, false));
    } while (!localFile.exists());
    paramImageKey = new File(paramImageKey.filePath);
    if (paramImageKey.exists()) {
      paramImageKey.delete();
    }
    localFile.delete();
  }
  
  public void notifyDownSuccess(ImageKey paramImageKey, String paramString1, String paramString2)
  {
    onDownloadSucceed(paramImageKey, paramString1, paramString2, false);
  }
  
  boolean onDownloadSucceed(ImageKey paramImageKey, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = ImageKey.getUrlKey(paramString1, false);
    ImageTracer.endDownlaod(paramString1);
    if ((paramImageKey != null) && (paramImageKey.flag == 3))
    {
      ProgressTracer.print(5, paramString1);
      Object localObject = str;
      if (ImageManagerEnv.g().enableSocketMonitor()) {
        localObject = ImageManagerEnv.g().removeSocketMonitorParam(str);
      }
      if (paramBoolean)
      {
        long l = System.currentTimeMillis();
        this.mNoCacheUrlKeyAndCacheTimeMap.put(localObject, Long.valueOf(l));
        this.mHasEntryNoCacheUrlKeyAndCacheTimeMap = true;
        ImageManagerLog.w(TAG, "onDownloadSucceed,save no-cache info, url = " + paramString1);
      }
      if (paramImageKey == null) {
        break label438;
      }
      imageKeyFilePathCheck(paramImageKey);
      localObject = new File(paramImageKey.filePath);
      if (!((File)localObject).exists()) {
        break label265;
      }
      if ((paramImageKey.isNetworkUrl) && (!paramBoolean))
      {
        updateLruFile(paramImageKey);
        paramString2 = ((File)localObject).getName();
        i = (int)((File)localObject).length();
        this.mFilename2FileMap.put(paramString2, localObject);
        this.mTotalFileSize += i;
        mFilename2FileLengthMap.put(Integer.valueOf(parseInt(paramString2)), Integer.valueOf(i));
        ImageTracer.setImageLength(paramString1, i);
      }
      if (paramBoolean)
      {
        paramImageKey = new File(getNocacheFilePath(paramImageKey, true));
        if (paramImageKey.exists()) {}
      }
    }
    label265:
    do
    {
      try
      {
        paramImageKey.createNewFile();
        return true;
      }
      catch (Exception paramImageKey)
      {
        paramImageKey.printStackTrace();
        return true;
      }
      ProgressTracer.print(2, paramString1);
      break;
      if (paramImageKey.isAvatarUrl())
      {
        paramImageKey.filePath = paramString2;
        return true;
      }
      if (paramImageKey.filePath.startsWith("/data")) {
        break label438;
      }
      mCachePath = getStorePath(this.mContext, "imageV2", true, false);
      paramImageKey.filePath = (getCachePath(this.mContext) + urlKey2FileName(paramImageKey.urlKey, true));
      paramImageKey = new File(paramImageKey.filePath);
      if (!ImageManagerEnv.g().copyFiles(new File(paramString2), paramImageKey)) {
        break label438;
      }
    } while (paramBoolean);
    paramString2 = paramImageKey.getName();
    int i = (int)paramImageKey.length();
    this.mFilename2FileMap.put(paramString2, paramImageKey);
    this.mTotalFileSize += i;
    mFilename2FileLengthMap.put(Integer.valueOf(parseInt(paramString2)), Integer.valueOf(i));
    ImageTracer.setImageLength(paramString1, i);
    return true;
    label438:
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
    if (IS_ICE_CREAM_SANDWICH) {
      if (drawableComputable(paramDrawable)) {
        put(paramInt, paramDrawable);
      }
    }
    for (;;)
    {
      paramDrawable = (HashSet)this.mUrlKey2AllImageKeyMap.get(paramString);
      paramImage = paramDrawable;
      if (paramDrawable == null)
      {
        paramImage = new HashSet();
        this.mUrlKey2AllImageKeyMap.put(paramString, paramImage);
      }
      paramImage.add(Integer.valueOf(paramInt));
      return;
      ImageManagerLog.d("feilongzou", "drawable 不能精确计算大小，不能放入缓存中：" + paramDrawable);
      continue;
      getImageCache().put(Integer.valueOf(paramInt), paramImage);
    }
  }
  
  public void removeImageFile(String paramString, ImageLoader.Options paramOptions)
  {
    String str;
    if (isNetworkUrl(paramString))
    {
      str = urlKey2FileName(ImageKey.getUrlKey(paramString, true), true);
      File localFile = (File)this.mFilename2FileMap.remove(str);
      mFilename2FileLengthMap.remove(Integer.valueOf(parseInt(str)));
      paramString = localFile;
      if (localFile == null) {
        if ((paramOptions == null) || (paramOptions.fileRootPath == null) || (paramOptions.fileRootPath.length() <= 0)) {
          break label135;
        }
      }
    }
    label135:
    for (paramString = paramOptions.fileRootPath;; paramString = getCachePath(this.mContext))
    {
      paramString = new File(paramString + str);
      if ((paramString != null) && (paramString.exists()))
      {
        this.mTotalFileSize -= paramString.length();
        paramString.delete();
      }
      return;
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
    String str = getCachePathSR(this.mContext) + urlKey2FileName(paramImageKey.urlKey, true);
    BitmapUtils.saveBitmapToFile(paramBitmap, str);
    paramBitmap = paramImageKey.filePath;
    paramImageKey.filePath = str;
    BitmapUtils.copyExif(paramBitmap, str);
    paramImageKey.needSuperResolution = false;
    paramBitmap = new File(str);
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
    if (this.imageFileTracer != null) {
      this.imageFileTracer.onImageFileDecode(paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager
 * JD-Core Version:    0.7.0.1
 */
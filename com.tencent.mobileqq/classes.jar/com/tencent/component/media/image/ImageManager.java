package com.tencent.component.media.image;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
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
import com.tencent.component.media.photogif.NewAnimationDrawable;
import com.tencent.component.media.photogif.PhotoGifDrawable;
import com.tencent.component.media.utils.BaseHandler;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.component.media.utils.LruCache;
import com.tencent.component.media.utils.RapidNetUtils;
import com.tencent.sharpP.SharpPUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import pgn;
import pgo;
import pgp;
import pgr;
import pgs;
import pgt;
import pgu;
import pgv;
import pgx;
import pgy;
import pgz;
import pha;
import phb;
import phc;
import phd;
import phe;
import phf;
import phg;
import phh;
import phi;

public class ImageManager
{
  public static final byte FLAG_DOWNLOAD_ONLY = 3;
  public static final byte FLAG_GET_FROM_MEMORY = 0;
  public static final byte FLAG_GET_FROM_MEMORY_LOCAL = 1;
  public static final byte FLAG_GET_FROM_MEMORY_LOCAL_NETWORK = 2;
  public static final String TAG = ImageManager.class.getSimpleName();
  private static volatile Handler jdField_a_of_type_AndroidOsHandler;
  private static volatile HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static ImageManager jdField_a_of_type_ComTencentComponentMediaImageImageManager;
  private static FilenameFilter jdField_a_of_type_JavaIoFilenameFilter;
  private static final Object jdField_a_of_type_JavaLangObject;
  private static Runnable jdField_a_of_type_JavaLangRunnable;
  private static String jdField_a_of_type_JavaLangString;
  private static Comparator jdField_a_of_type_JavaUtilComparator;
  private static Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static final boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int = 0;
  private static long jdField_b_of_type_Long = 0L;
  private static final Object jdField_b_of_type_JavaLangObject;
  private static String jdField_b_of_type_JavaLangString;
  private static HashMap jdField_b_of_type_JavaUtilHashMap;
  private static volatile Executor jdField_b_of_type_JavaUtilConcurrentExecutor;
  private static long jdField_c_of_type_Long = 0L;
  private static final Object jdField_c_of_type_JavaLangObject;
  private static String jdField_c_of_type_JavaLangString;
  private static HashMap jdField_c_of_type_JavaUtilHashMap;
  private static boolean jdField_c_of_type_Boolean = false;
  private static long jdField_d_of_type_Long = 0L;
  private static final Object jdField_d_of_type_JavaLangObject;
  private static String jdField_d_of_type_JavaLangString;
  private static HashMap jdField_d_of_type_JavaUtilHashMap;
  private static long jdField_e_of_type_Long = 0L;
  private static final Object jdField_e_of_type_JavaLangObject;
  private static volatile boolean jdField_e_of_type_Boolean = false;
  private static boolean jdField_f_of_type_Boolean = false;
  private static long jdField_g_of_type_Long = 0L;
  private static boolean jdField_g_of_type_Boolean = false;
  private static ConcurrentHashMap jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap;
  private static volatile boolean jdField_h_of_type_Boolean = false;
  public static volatile boolean hasScrolled = false;
  private static ConcurrentHashMap i;
  public static volatile boolean isInFriendFeed = false;
  public static boolean sCloseNativeAndCache = false;
  public static final long timeInterval = 60000L;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 0L;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new pgp(this);
  private Context jdField_a_of_type_AndroidContentContext = null;
  private Looper jdField_a_of_type_AndroidOsLooper = null;
  private IDownloader jdField_a_of_type_ComTencentComponentMediaIDownloader = null;
  ByteArrayPool jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool;
  IBitmapFactory jdField_a_of_type_ComTencentComponentMediaImageIBitmapFactory;
  private IDecoder jdField_a_of_type_ComTencentComponentMediaImageIDecoder = null;
  private IImageFileTracer jdField_a_of_type_ComTencentComponentMediaImageIImageFileTracer = null;
  private BaseHandler jdField_a_of_type_ComTencentComponentMediaUtilsBaseHandler = null;
  private LruCache jdField_a_of_type_ComTencentComponentMediaUtilsLruCache = null;
  private ThreadLocal jdField_a_of_type_JavaLangThreadLocal = new pgn(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final BaseHandler jdField_b_of_type_ComTencentComponentMediaUtilsBaseHandler = new BaseHandler(Looper.getMainLooper());
  private LruCache jdField_b_of_type_ComTencentComponentMediaUtilsLruCache = null;
  private Runnable jdField_b_of_type_JavaLangRunnable = new pgv(this);
  private ConcurrentHashMap jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_b_of_type_Boolean = false;
  private ConcurrentHashMap jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_d_of_type_Boolean = false;
  private ConcurrentHashMap jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile long jdField_f_of_type_Long = 0L;
  private ConcurrentHashMap jdField_f_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ConcurrentHashMap jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentComponentMediaImageImageManager = null;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_c_of_type_JavaLangObject = new Object();
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      jdField_c_of_type_Boolean = true;
      isInFriendFeed = false;
      hasScrolled = false;
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
      jdField_b_of_type_JavaUtilHashMap = new HashMap();
      jdField_b_of_type_Int = -1;
      jdField_a_of_type_JavaLangString = null;
      jdField_c_of_type_JavaLangString = "";
      jdField_c_of_type_JavaUtilHashMap = new HashMap();
      jdField_e_of_type_Boolean = false;
      jdField_d_of_type_JavaLangString = "";
      jdField_b_of_type_Long = 0L;
      jdField_a_of_type_JavaLangRunnable = new pgo();
      jdField_d_of_type_JavaUtilHashMap = new HashMap();
      jdField_f_of_type_Boolean = false;
      jdField_c_of_type_Long = 104857600L;
      jdField_d_of_type_Long = 41943040L;
      jdField_e_of_type_Long = jdField_c_of_type_Long;
      jdField_g_of_type_Boolean = true;
      jdField_a_of_type_JavaIoFilenameFilter = new pgr();
      jdField_a_of_type_JavaUtilComparator = new pgs();
      jdField_a_of_type_JavaUtilConcurrentExecutor = null;
      jdField_d_of_type_JavaLangObject = new Object();
      jdField_b_of_type_JavaUtilConcurrentExecutor = null;
      jdField_e_of_type_JavaLangObject = new Object();
      jdField_h_of_type_Boolean = false;
      jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      i = new ConcurrentHashMap(50, 0.75F, 8);
      jdField_g_of_type_Long = 0L;
      return;
    }
  }
  
  private ImageManager()
  {
    sCloseNativeAndCache = ImageManagerEnv.g().closeNativeAndinBitmap();
    if (sCloseNativeAndCache) {
      ImageManagerLog.d(TAG, "wns closeNativeAndCache");
    }
    int j;
    Object localObject;
    int n;
    boolean bool;
    label392:
    int k;
    if ((Build.VERSION.SDK_INT >= 21) && ("meizu".equalsIgnoreCase(Build.MANUFACTURER)))
    {
      j = 1;
      if (j != 0)
      {
        sCloseNativeAndCache = true;
        ImageManagerLog.d(TAG, "isMeizu closeNativeAndCache");
      }
      this.jdField_a_of_type_AndroidOsLooper = ImageManagerEnv.g().getDispatcher();
      if (this.jdField_a_of_type_AndroidOsLooper == null)
      {
        localObject = new HandlerThread("Qzone_ImageManager_getnull_or_cancel");
        ((HandlerThread)localObject).start();
        this.jdField_a_of_type_AndroidOsLooper = ((HandlerThread)localObject).getLooper();
      }
      n = ((ActivityManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("activity")).getMemoryClass();
      localObject = ImageManagerEnv.g().getProcessName(this.jdField_a_of_type_AndroidContentContext);
      jdField_c_of_type_Boolean = ImageManagerEnv.g().isMainProcess(this.jdField_a_of_type_AndroidContentContext);
      if ((localObject == null) || (!((String)localObject).contains(":localphoto"))) {
        break label598;
      }
      j = 524288 * n;
      bool = true;
      if (jdField_a_of_type_Boolean) {
        break label611;
      }
      k = j / 2;
      label403:
      j = k - 307200;
      this.jdField_a_of_type_Int = j;
      float f2 = ImageManagerEnv.g().getCacheMemRatio();
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int * f1));
      ImageManagerLog.d(TAG, "imageMemCacheSize: " + this.jdField_a_of_type_Int + " , drawableCacheRatio: " + f1 + ",memoryclass:" + n);
      a();
      ImageOptionSampleSize.setSize(n, j);
      if (Build.VERSION.SDK_INT < 14) {
        sCloseNativeAndCache = true;
      }
      if (!sCloseNativeAndCache) {
        break label703;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder == null)
      {
        this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder = new DefaultDecoder();
        this.jdField_a_of_type_ComTencentComponentMediaImageIBitmapFactory = new IBitmapFactory.DefaultBitmapFactory(this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder);
      }
      ImageManagerLog.d(TAG, "ImageManager() mDecoder:" + this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder);
      b();
      a();
      return;
      j = 0;
      break;
      label598:
      j = 262144 * n;
      bool = false;
      break label392;
      label611:
      if (Build.VERSION.SDK_INT >= 21)
      {
        int i1 = ImageManagerEnv.g().getMinMemoryClassInArt();
        k = j;
        if (n >= i1) {
          break label403;
        }
        sCloseNativeAndCache = true;
        ImageManagerLog.d(TAG, "minMemory closeNativeAndCache:" + n + ", minMem: " + i1);
        k = j;
        break label403;
      }
      k = j;
      if (!bool) {
        break label403;
      }
      sCloseNativeAndCache = true;
      k = j;
      break label403;
      label703:
      if (Build.VERSION.SDK_INT >= 21) {
        break label801;
      }
      this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool = new ByteArrayPool(new pgy(this, bool));
      this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder = new DalvikDecoder(this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool);
      if (!DalvikDecoder.loadSoSucess)
      {
        ImageManagerLog.w(TAG, "load so failed");
        this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder = null;
        this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool = null;
        sCloseNativeAndCache = true;
      }
      else
      {
        this.jdField_a_of_type_ComTencentComponentMediaImageIBitmapFactory = new IBitmapFactory.DalvikBitmapFactory(this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool, this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder);
      }
    }
    label801:
    if (ImageDefaultConfig.isQzone(this.jdField_a_of_type_AndroidContentContext))
    {
      j = (int)(this.jdField_a_of_type_Int * 0.4D);
      this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.6D));
    }
    for (;;)
    {
      ImageManagerLog.d(TAG, "ImageLoader----imageMemCacheSize = " + this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool = new ByteArrayPool(new pgz(this));
      localObject = new ReuseBitmapCacheProxy(new pha(this), j);
      this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder = new ArtDecoder(this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool, (BitmapPool)localObject);
      this.jdField_a_of_type_ComTencentComponentMediaImageIBitmapFactory = new IBitmapFactory.ArtBitmapFactory(this.jdField_a_of_type_ComTencentComponentMediaImageByteArrayPool, this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder);
      BitmapReference.setGlobalReleaser((Releaser)localObject);
      break;
      j = m;
      if (ImageDefaultConfig.isPicture(this.jdField_a_of_type_AndroidContentContext))
      {
        j = (int)(this.jdField_a_of_type_Int * 0.6D);
        this.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int * 0.4D));
      }
    }
  }
  
  private static int a(String paramString)
  {
    try
    {
      int j = Integer.parseInt(paramString);
      return j;
    }
    catch (NumberFormatException paramString) {}
    return 0;
  }
  
  private BaseHandler a()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaUtilsBaseHandler == null) {}
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentComponentMediaUtilsBaseHandler == null) {
        this.jdField_a_of_type_ComTencentComponentMediaUtilsBaseHandler = new phb(this, this.jdField_a_of_type_AndroidOsLooper);
      }
      return this.jdField_a_of_type_ComTencentComponentMediaUtilsBaseHandler;
    }
  }
  
  private LruCache a()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache == null) {}
    synchronized (jdField_c_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache == null) {
        this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache = new phc(this, this.jdField_a_of_type_Int);
      }
      return this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache;
    }
  }
  
  private static String a(Context paramContext)
  {
    paramContext = b(paramContext);
    File localFile = new File(paramContext);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    return paramContext;
  }
  
  private String a(ImageKey paramImageKey, boolean paramBoolean)
  {
    if (paramBoolean) {
      return a(this.jdField_a_of_type_AndroidContentContext) + urlKey2FileName(paramImageKey.urlKey, true);
    }
    return b(this.jdField_a_of_type_AndroidContentContext) + urlKey2FileName(paramImageKey.urlKey, true);
  }
  
  private static Executor a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentExecutor == null)
    {
      int j = ImageManagerEnv.g().getDecodeThreadNum(jdField_c_of_type_Boolean);
      jdField_a_of_type_JavaUtilConcurrentExecutor = ImageManagerEnv.g().getExecutor();
      if (jdField_a_of_type_JavaUtilConcurrentExecutor == null) {
        jdField_a_of_type_JavaUtilConcurrentExecutor = Executors.newFixedThreadPool(j, new pgt());
      }
    }
    return jdField_a_of_type_JavaUtilConcurrentExecutor;
  }
  
  private void a()
  {
    if (jdField_e_of_type_Boolean) {
      return;
    }
    jdField_e_of_type_Boolean = true;
    a().postDelayed(new phf(this), 10000L);
  }
  
  private void a(Message paramMessage)
  {
    if ((paramMessage.obj instanceof ImageKey))
    {
      paramMessage = (ImageKey)paramMessage.obj;
      paramMessage.options = ImageLoader.Options.copy(paramMessage.options);
      if (paramMessage.flag != 0) {
        break label41;
      }
      paramMessage.recycle();
    }
    label41:
    phh localphh;
    do
    {
      return;
      localphh = ImageTaskBuilder.buildImageTask(paramMessage);
      ImageTaskTracer.removeImageMsgGetNullRecord(paramMessage.hashCodeEx());
    } while (localphh == null);
    localphh.excuteTask();
  }
  
  private void a(ConcurrentHashMap paramConcurrentHashMap)
  {
    long l;
    if (jdField_c_of_type_Boolean)
    {
      l = System.currentTimeMillis();
      if (jdField_g_of_type_Long != 0L) {
        break label29;
      }
      jdField_g_of_type_Long = l;
      a(paramConcurrentHashMap, false);
    }
    label29:
    while (l - jdField_g_of_type_Long <= 60000L) {
      return;
    }
    jdField_g_of_type_Long = l;
    a(paramConcurrentHashMap, false);
  }
  
  /* Error */
  private void a(ConcurrentHashMap paramConcurrentHashMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 609	java/util/concurrent/ConcurrentHashMap:size	()I
    //   4: ifle +183 -> 187
    //   7: new 102	java/util/HashMap
    //   10: dup
    //   11: invokespecial 103	java/util/HashMap:<init>	()V
    //   14: astore 4
    //   16: aload 4
    //   18: aload_1
    //   19: invokevirtual 613	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   22: aload_1
    //   23: invokevirtual 616	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   26: new 335	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   33: aload_0
    //   34: getfield 224	com/tencent/component/media/image/ImageManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   37: invokestatic 619	com/tencent/component/media/image/ImageManager:getCachePath	(Landroid/content/Context;)Ljava/lang/String;
    //   40: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: ldc_w 621
    //   46: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: astore_1
    //   53: iload_2
    //   54: ifne +134 -> 188
    //   57: iconst_1
    //   58: istore_2
    //   59: new 623	java/io/FileOutputStream
    //   62: dup
    //   63: aload_1
    //   64: iload_2
    //   65: invokespecial 626	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   68: astore_3
    //   69: aload_3
    //   70: astore_1
    //   71: new 335	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   78: astore 5
    //   80: aload_3
    //   81: astore_1
    //   82: aload 4
    //   84: invokevirtual 630	java/util/HashMap:keySet	()Ljava/util/Set;
    //   87: invokeinterface 636 1 0
    //   92: astore 6
    //   94: aload_3
    //   95: astore_1
    //   96: aload 6
    //   98: invokeinterface 641 1 0
    //   103: ifeq +90 -> 193
    //   106: aload_3
    //   107: astore_1
    //   108: aload 6
    //   110: invokeinterface 645 1 0
    //   115: checkcast 277	java/lang/String
    //   118: astore 7
    //   120: aload_3
    //   121: astore_1
    //   122: aload 5
    //   124: aload 7
    //   126: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_3
    //   131: astore_1
    //   132: aload 5
    //   134: ldc_w 647
    //   137: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_3
    //   142: astore_1
    //   143: aload 5
    //   145: aload 4
    //   147: aload 7
    //   149: invokevirtual 651	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   152: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_3
    //   157: astore_1
    //   158: aload 5
    //   160: ldc_w 653
    //   163: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: goto -73 -> 94
    //   170: astore 4
    //   172: aload_3
    //   173: astore_1
    //   174: aload 4
    //   176: invokevirtual 656	java/lang/Exception:printStackTrace	()V
    //   179: aload_3
    //   180: ifnull +7 -> 187
    //   183: aload_3
    //   184: invokevirtual 659	java/io/FileOutputStream:close	()V
    //   187: return
    //   188: iconst_0
    //   189: istore_2
    //   190: goto -131 -> 59
    //   193: aload_3
    //   194: astore_1
    //   195: aload_3
    //   196: aload 5
    //   198: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokevirtual 663	java/lang/String:getBytes	()[B
    //   204: invokevirtual 667	java/io/FileOutputStream:write	([B)V
    //   207: aload_3
    //   208: astore_1
    //   209: aload_3
    //   210: invokevirtual 670	java/io/FileOutputStream:flush	()V
    //   213: aload_3
    //   214: ifnull -27 -> 187
    //   217: aload_3
    //   218: invokevirtual 659	java/io/FileOutputStream:close	()V
    //   221: return
    //   222: astore_1
    //   223: aload_1
    //   224: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   227: return
    //   228: astore_1
    //   229: aload_1
    //   230: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   233: return
    //   234: astore_3
    //   235: aconst_null
    //   236: astore_1
    //   237: aload_1
    //   238: ifnull +7 -> 245
    //   241: aload_1
    //   242: invokevirtual 659	java/io/FileOutputStream:close	()V
    //   245: aload_3
    //   246: athrow
    //   247: astore_1
    //   248: aload_1
    //   249: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   252: goto -7 -> 245
    //   255: astore_3
    //   256: goto -19 -> 237
    //   259: astore 4
    //   261: aconst_null
    //   262: astore_3
    //   263: goto -91 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	ImageManager
    //   0	266	1	paramConcurrentHashMap	ConcurrentHashMap
    //   0	266	2	paramBoolean	boolean
    //   68	150	3	localFileOutputStream	java.io.FileOutputStream
    //   234	12	3	localObject1	Object
    //   255	1	3	localObject2	Object
    //   262	1	3	localObject3	Object
    //   14	132	4	localHashMap	HashMap
    //   170	5	4	localException1	Exception
    //   259	1	4	localException2	Exception
    //   78	119	5	localStringBuilder	java.lang.StringBuilder
    //   92	17	6	localIterator	Iterator
    //   118	30	7	str	String
    // Exception table:
    //   from	to	target	type
    //   71	80	170	java/lang/Exception
    //   82	94	170	java/lang/Exception
    //   96	106	170	java/lang/Exception
    //   108	120	170	java/lang/Exception
    //   122	130	170	java/lang/Exception
    //   132	141	170	java/lang/Exception
    //   143	156	170	java/lang/Exception
    //   158	167	170	java/lang/Exception
    //   195	207	170	java/lang/Exception
    //   209	213	170	java/lang/Exception
    //   217	221	222	java/io/IOException
    //   183	187	228	java/io/IOException
    //   59	69	234	finally
    //   241	245	247	java/io/IOException
    //   71	80	255	finally
    //   82	94	255	finally
    //   96	106	255	finally
    //   108	120	255	finally
    //   122	130	255	finally
    //   132	141	255	finally
    //   143	156	255	finally
    //   158	167	255	finally
    //   174	179	255	finally
    //   195	207	255	finally
    //   209	213	255	finally
    //   59	69	259	java/lang/Exception
  }
  
  private static boolean a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      return false;
      if ((paramDrawable instanceof DrawableContainer)) {
        return a(((DrawableContainer)paramDrawable).getDrawable());
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
    } while (!(paramDrawable instanceof NinePatchRefDrawable));
    return true;
  }
  
  private static int b(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      do
      {
        do
        {
          return 0;
          if ((paramDrawable instanceof DrawableContainer)) {
            return b(((DrawableContainer)paramDrawable).getDrawable());
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
    int k = paramDrawable.getIntrinsicHeight();
    int m = paramDrawable.getIntrinsicWidth();
    int j = k;
    if (k < 1) {
      j = 1;
    }
    k = m;
    if (m < 1) {
      k = 1;
    }
    return k * j * 4;
  }
  
  private LruCache b()
  {
    if (this.jdField_b_of_type_ComTencentComponentMediaUtilsLruCache == null) {}
    synchronized (jdField_c_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_ComTencentComponentMediaUtilsLruCache == null) {
        this.jdField_b_of_type_ComTencentComponentMediaUtilsLruCache = new phd(this, this.jdField_a_of_type_Int);
      }
      return this.jdField_b_of_type_ComTencentComponentMediaUtilsLruCache;
    }
  }
  
  private static String b(Context paramContext)
  {
    return getCachePath(paramContext) + "nocache" + File.separator;
  }
  
  private void b()
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
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      jdField_f_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b(Message paramMessage)
  {
    if ((paramMessage.obj instanceof ImageKey))
    {
      paramMessage = (ImageKey)paramMessage.obj;
      paramMessage.options = ImageLoader.Options.copy(paramMessage.options);
      ImageTracer.cancel(paramMessage.url);
      phi.b(paramMessage);
      phi.a().a(paramMessage.url);
    }
  }
  
  /* Error */
  private static void b(String paramString)
  {
    // Byte code:
    //   0: new 495	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 496	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 499	java/io/File:exists	()Z
    //   13: ifeq +113 -> 126
    //   16: new 785	java/io/BufferedReader
    //   19: dup
    //   20: new 787	java/io/FileReader
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 790	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   28: invokespecial 793	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 796	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore_2
    //   39: aload_2
    //   40: ifnull +87 -> 127
    //   43: aload_1
    //   44: astore_0
    //   45: aload_2
    //   46: ldc_w 798
    //   49: invokevirtual 801	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   52: ifeq -20 -> 32
    //   55: aload_1
    //   56: astore_0
    //   57: aload_2
    //   58: ldc_w 803
    //   61: invokevirtual 807	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   83: new 495	java/io/File
    //   86: dup
    //   87: aload_2
    //   88: invokespecial 496	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: invokevirtual 499	java/io/File:exists	()Z
    //   94: ifeq -62 -> 32
    //   97: aload_1
    //   98: astore_0
    //   99: getstatic 115	com/tencent/component/media/image/ImageManager:jdField_c_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   102: aload_3
    //   103: aload_2
    //   104: invokevirtual 811	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: goto -76 -> 32
    //   111: astore_2
    //   112: aload_1
    //   113: astore_0
    //   114: aload_2
    //   115: invokevirtual 656	java/lang/Exception:printStackTrace	()V
    //   118: aload_1
    //   119: ifnull +7 -> 126
    //   122: aload_1
    //   123: invokevirtual 812	java/io/BufferedReader:close	()V
    //   126: return
    //   127: aload_1
    //   128: astore_0
    //   129: aload_1
    //   130: invokevirtual 812	java/io/BufferedReader:close	()V
    //   133: aload_1
    //   134: ifnull -8 -> 126
    //   137: aload_1
    //   138: invokevirtual 812	java/io/BufferedReader:close	()V
    //   141: return
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   147: return
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 671	java/io/IOException:printStackTrace	()V
    //   153: return
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_0
    //   157: aload_0
    //   158: ifnull +7 -> 165
    //   161: aload_0
    //   162: invokevirtual 812	java/io/BufferedReader:close	()V
    //   165: aload_1
    //   166: athrow
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 671	java/io/IOException:printStackTrace	()V
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
  
  private void b(ConcurrentHashMap paramConcurrentHashMap)
  {
    Object localObject1 = getCachePath(this.jdField_a_of_type_AndroidContentContext) + "imagelru.usetime";
    for (;;)
    {
      String str;
      Object localObject2;
      int j;
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
            j = Integer.parseInt(localObject2[1]);
            localObject2 = (Integer)paramConcurrentHashMap.get(str);
            if (localObject2 != null) {
              break label142;
            }
            paramConcurrentHashMap.put(str, Integer.valueOf(j));
            continue;
          }
        }
        return;
      }
      catch (Throwable paramConcurrentHashMap)
      {
        paramConcurrentHashMap.printStackTrace();
      }
      label142:
      if (j > ((Integer)localObject2).intValue()) {
        paramConcurrentHashMap.put(str, Integer.valueOf(j));
      }
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    try
    {
      StatFs localStatFs = new StatFs(jdField_c_of_type_JavaLangString);
      long l = localStatFs.getAvailableBlocks();
      int j = localStatFs.getBlockSize();
      if (l * j < 5242880L) {
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
  
  private static boolean b(String paramString)
  {
    localObject = (Boolean)jdField_d_of_type_JavaUtilHashMap.get(paramString);
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
      jdField_d_of_type_JavaUtilHashMap.put(paramString, Boolean.valueOf(bool1));
      return bool1;
      bool1 = ((File)localObject).createNewFile();
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: getstatic 89	com/tencent/component/media/image/ImageManager:jdField_c_of_type_Boolean	Z
    //   6: ifne +4 -> 10
    //   9: return
    //   10: getstatic 162	com/tencent/component/media/image/ImageManager:jdField_h_of_type_Boolean	Z
    //   13: ifeq +14 -> 27
    //   16: aload_0
    //   17: getfield 243	com/tencent/component/media/image/ImageManager:jdField_f_of_type_Long	J
    //   20: getstatic 140	com/tencent/component/media/image/ImageManager:jdField_e_of_type_Long	J
    //   23: lcmp
    //   24: iflt -15 -> 9
    //   27: aload_0
    //   28: getfield 224	com/tencent/component/media/image/ImageManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   31: invokestatic 619	com/tencent/component/media/image/ImageManager:getCachePath	(Landroid/content/Context;)Ljava/lang/String;
    //   34: astore 9
    //   36: new 495	java/io/File
    //   39: dup
    //   40: aload 9
    //   42: ldc_w 865
    //   45: ldc_w 867
    //   48: invokevirtual 871	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   51: invokespecial 496	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore 10
    //   56: aload 10
    //   58: invokevirtual 499	java/io/File:exists	()Z
    //   61: ifeq +61 -> 122
    //   64: aload 10
    //   66: invokevirtual 874	java/io/File:isDirectory	()Z
    //   69: ifeq +53 -> 122
    //   72: aload 10
    //   74: invokevirtual 878	java/io/File:listFiles	()[Ljava/io/File;
    //   77: astore 11
    //   79: aload 11
    //   81: ifnull +35 -> 116
    //   84: aload 11
    //   86: arraylength
    //   87: ifle +29 -> 116
    //   90: aload 11
    //   92: arraylength
    //   93: istore_2
    //   94: iconst_0
    //   95: istore_1
    //   96: iload_1
    //   97: iload_2
    //   98: if_icmpge +18 -> 116
    //   101: aload 11
    //   103: iload_1
    //   104: aaload
    //   105: invokevirtual 857	java/io/File:delete	()Z
    //   108: pop
    //   109: iload_1
    //   110: iconst_1
    //   111: iadd
    //   112: istore_1
    //   113: goto -17 -> 96
    //   116: aload 10
    //   118: invokevirtual 857	java/io/File:delete	()Z
    //   121: pop
    //   122: new 164	java/util/concurrent/ConcurrentHashMap
    //   125: dup
    //   126: invokespecial 165	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   129: astore 12
    //   131: new 880	java/util/ArrayList
    //   134: dup
    //   135: invokespecial 881	java/util/ArrayList:<init>	()V
    //   138: astore 11
    //   140: new 495	java/io/File
    //   143: dup
    //   144: aload 9
    //   146: invokespecial 496	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore 9
    //   151: aload 9
    //   153: invokevirtual 499	java/io/File:exists	()Z
    //   156: ifeq +450 -> 606
    //   159: aload 9
    //   161: invokevirtual 874	java/io/File:isDirectory	()Z
    //   164: ifeq +442 -> 606
    //   167: aload 9
    //   169: getstatic 147	com/tencent/component/media/image/ImageManager:jdField_a_of_type_JavaIoFilenameFilter	Ljava/io/FilenameFilter;
    //   172: invokevirtual 884	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   175: astore 13
    //   177: aload 13
    //   179: ifnull +427 -> 606
    //   182: aload 13
    //   184: arraylength
    //   185: istore_1
    //   186: iload_1
    //   187: ifle +419 -> 606
    //   190: iconst_0
    //   191: istore_3
    //   192: iconst_0
    //   193: istore_1
    //   194: iload_1
    //   195: istore_2
    //   196: iload_3
    //   197: aload 13
    //   199: arraylength
    //   200: if_icmpge +403 -> 603
    //   203: iload_1
    //   204: istore_2
    //   205: aload 11
    //   207: aload 13
    //   209: iload_3
    //   210: aaload
    //   211: invokevirtual 888	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   214: pop
    //   215: iload_1
    //   216: istore_2
    //   217: aload 13
    //   219: iload_3
    //   220: aaload
    //   221: invokevirtual 891	java/io/File:getName	()Ljava/lang/String;
    //   224: astore 14
    //   226: iload_1
    //   227: istore_2
    //   228: aload 14
    //   230: invokestatic 893	com/tencent/component/media/image/ImageManager:a	(Ljava/lang/String;)I
    //   233: istore 5
    //   235: iload_1
    //   236: istore_2
    //   237: getstatic 167	com/tencent/component/media/image/ImageManager:jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   240: iload 5
    //   242: invokestatic 819	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   245: invokevirtual 815	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   248: checkcast 468	java/lang/Integer
    //   251: astore 10
    //   253: aload 10
    //   255: astore 9
    //   257: aload 10
    //   259: ifnonnull +34 -> 293
    //   262: iload_1
    //   263: istore_2
    //   264: aload 13
    //   266: iload_3
    //   267: aaload
    //   268: invokevirtual 896	java/io/File:length	()J
    //   271: l2i
    //   272: invokestatic 819	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   275: astore 9
    //   277: iload_1
    //   278: istore_2
    //   279: getstatic 167	com/tencent/component/media/image/ImageManager:jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   282: iload 5
    //   284: invokestatic 819	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   287: aload 9
    //   289: invokevirtual 820	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   292: pop
    //   293: iload_1
    //   294: istore_2
    //   295: iload_1
    //   296: aload 9
    //   298: invokevirtual 824	java/lang/Integer:intValue	()I
    //   301: iadd
    //   302: istore_1
    //   303: iload_1
    //   304: istore_2
    //   305: aload 12
    //   307: aload 14
    //   309: aload 13
    //   311: iload_3
    //   312: aaload
    //   313: invokevirtual 820	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   316: pop
    //   317: iload_3
    //   318: iconst_1
    //   319: iadd
    //   320: istore_3
    //   321: goto -127 -> 194
    //   324: astore 10
    //   326: aload 10
    //   328: invokevirtual 821	java/lang/Throwable:printStackTrace	()V
    //   331: goto -209 -> 122
    //   334: astore 9
    //   336: iconst_0
    //   337: istore_1
    //   338: aload 9
    //   340: invokevirtual 821	java/lang/Throwable:printStackTrace	()V
    //   343: aload_0
    //   344: iload_1
    //   345: i2l
    //   346: putfield 243	com/tencent/component/media/image/ImageManager:jdField_f_of_type_Long	J
    //   349: aload_0
    //   350: aload 12
    //   352: putfield 241	com/tencent/component/media/image/ImageManager:jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   355: iconst_1
    //   356: putstatic 162	com/tencent/component/media/image/ImageManager:jdField_h_of_type_Boolean	Z
    //   359: aload_0
    //   360: getfield 243	com/tencent/component/media/image/ImageManager:jdField_f_of_type_Long	J
    //   363: getstatic 140	com/tencent/component/media/image/ImageManager:jdField_e_of_type_Long	J
    //   366: lcmp
    //   367: iflt -358 -> 9
    //   370: getstatic 899	android/os/Build:MODEL	Ljava/lang/String;
    //   373: invokevirtual 902	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   376: ldc_w 904
    //   379: invokevirtual 327	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   382: istore 6
    //   384: getstatic 140	com/tencent/component/media/image/ImageManager:jdField_e_of_type_Long	J
    //   387: l2f
    //   388: ldc_w 905
    //   391: fmul
    //   392: f2l
    //   393: lstore 7
    //   395: aload_0
    //   396: getstatic 173	com/tencent/component/media/image/ImageManager:i	Ljava/util/concurrent/ConcurrentHashMap;
    //   399: invokespecial 907	com/tencent/component/media/image/ImageManager:b	(Ljava/util/concurrent/ConcurrentHashMap;)V
    //   402: aload 11
    //   404: getstatic 152	com/tencent/component/media/image/ImageManager:jdField_a_of_type_JavaUtilComparator	Ljava/util/Comparator;
    //   407: invokestatic 913	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   410: aload 11
    //   412: invokevirtual 914	java/util/ArrayList:size	()I
    //   415: iconst_1
    //   416: isub
    //   417: istore_2
    //   418: iload 4
    //   420: istore_1
    //   421: iload_2
    //   422: ifle +140 -> 562
    //   425: aload 11
    //   427: iload_2
    //   428: invokevirtual 917	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   431: checkcast 495	java/io/File
    //   434: astore 12
    //   436: aload 12
    //   438: invokevirtual 891	java/io/File:getName	()Ljava/lang/String;
    //   441: astore 13
    //   443: getstatic 167	com/tencent/component/media/image/ImageManager:jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   446: aload 13
    //   448: invokestatic 893	com/tencent/component/media/image/ImageManager:a	(Ljava/lang/String;)I
    //   451: invokestatic 819	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: invokevirtual 920	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   457: checkcast 468	java/lang/Integer
    //   460: astore 10
    //   462: aload 10
    //   464: astore 9
    //   466: aload 10
    //   468: ifnonnull +14 -> 482
    //   471: aload 12
    //   473: invokevirtual 896	java/io/File:length	()J
    //   476: l2i
    //   477: invokestatic 819	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   480: astore 9
    //   482: aload_0
    //   483: getfield 241	com/tencent/component/media/image/ImageManager:jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   486: aload 13
    //   488: invokevirtual 920	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   491: pop
    //   492: aload_0
    //   493: aload_0
    //   494: getfield 243	com/tencent/component/media/image/ImageManager:jdField_f_of_type_Long	J
    //   497: aload 9
    //   499: invokevirtual 824	java/lang/Integer:intValue	()I
    //   502: i2l
    //   503: lsub
    //   504: putfield 243	com/tencent/component/media/image/ImageManager:jdField_f_of_type_Long	J
    //   507: aload 12
    //   509: invokevirtual 857	java/io/File:delete	()Z
    //   512: pop
    //   513: getstatic 173	com/tencent/component/media/image/ImageManager:i	Ljava/util/concurrent/ConcurrentHashMap;
    //   516: aload 13
    //   518: invokevirtual 920	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   521: checkcast 468	java/lang/Integer
    //   524: astore 9
    //   526: iload 6
    //   528: ifeq +72 -> 600
    //   531: iload_1
    //   532: iconst_1
    //   533: iadd
    //   534: istore_3
    //   535: iload_3
    //   536: istore_1
    //   537: iload_3
    //   538: bipush 20
    //   540: irem
    //   541: ifne +11 -> 552
    //   544: ldc2_w 921
    //   547: invokestatic 926	java/lang/Thread:sleep	(J)V
    //   550: iload_3
    //   551: istore_1
    //   552: aload_0
    //   553: getfield 243	com/tencent/component/media/image/ImageManager:jdField_f_of_type_Long	J
    //   556: lload 7
    //   558: lcmp
    //   559: ifge +20 -> 579
    //   562: aload_0
    //   563: getstatic 173	com/tencent/component/media/image/ImageManager:i	Ljava/util/concurrent/ConcurrentHashMap;
    //   566: iconst_1
    //   567: invokespecial 602	com/tencent/component/media/image/ImageManager:a	(Ljava/util/concurrent/ConcurrentHashMap;Z)V
    //   570: return
    //   571: astore 9
    //   573: aload 9
    //   575: invokevirtual 821	java/lang/Throwable:printStackTrace	()V
    //   578: return
    //   579: iload_2
    //   580: iconst_1
    //   581: isub
    //   582: istore_2
    //   583: goto -162 -> 421
    //   586: astore 9
    //   588: iload_3
    //   589: istore_1
    //   590: goto -38 -> 552
    //   593: astore 9
    //   595: iload_2
    //   596: istore_1
    //   597: goto -259 -> 338
    //   600: goto -48 -> 552
    //   603: goto -260 -> 343
    //   606: iconst_0
    //   607: istore_1
    //   608: goto -265 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	611	0	this	ImageManager
    //   95	513	1	j	int
    //   93	503	2	k	int
    //   191	398	3	m	int
    //   1	418	4	n	int
    //   233	50	5	i1	int
    //   382	145	6	bool	boolean
    //   393	164	7	l	long
    //   34	263	9	localObject1	Object
    //   334	5	9	localThrowable1	Throwable
    //   464	61	9	localObject2	Object
    //   571	3	9	localThrowable2	Throwable
    //   586	1	9	localException	Exception
    //   593	1	9	localThrowable3	Throwable
    //   54	204	10	localObject3	Object
    //   324	3	10	localThrowable4	Throwable
    //   460	7	10	localInteger	Integer
    //   77	349	11	localObject4	Object
    //   129	379	12	localObject5	Object
    //   175	342	13	localObject6	Object
    //   224	84	14	str	String
    // Exception table:
    //   from	to	target	type
    //   36	79	324	java/lang/Throwable
    //   84	94	324	java/lang/Throwable
    //   101	109	324	java/lang/Throwable
    //   116	122	324	java/lang/Throwable
    //   140	177	334	java/lang/Throwable
    //   182	186	334	java/lang/Throwable
    //   384	418	571	java/lang/Throwable
    //   425	462	571	java/lang/Throwable
    //   471	482	571	java/lang/Throwable
    //   482	526	571	java/lang/Throwable
    //   544	550	571	java/lang/Throwable
    //   552	562	571	java/lang/Throwable
    //   562	570	571	java/lang/Throwable
    //   544	550	586	java/lang/Exception
    //   196	203	593	java/lang/Throwable
    //   205	215	593	java/lang/Throwable
    //   217	226	593	java/lang/Throwable
    //   228	235	593	java/lang/Throwable
    //   237	253	593	java/lang/Throwable
    //   264	277	593	java/lang/Throwable
    //   279	293	593	java/lang/Throwable
    //   295	303	593	java/lang/Throwable
    //   305	317	593	java/lang/Throwable
  }
  
  private void c(Message paramMessage)
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
  
  private void d()
  {
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    i.clear();
    DecodeImageTask.clearImageKey2SampleSizeMap();
    DecodeImageTask.clearImagePath2AttriMap();
    DecodeImageTask.clearImagePath2RotationMap();
    Object localObject = new File(getCachePath(this.jdField_a_of_type_AndroidContentContext));
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length > 0))
      {
        int j = 0;
        while (j < localObject.length)
        {
          localObject[j].delete();
          j += 1;
        }
      }
    }
  }
  
  @Public
  public static String getCachePath(Context paramContext)
  {
    if (jdField_a_of_type_JavaLangString == null) {}
    try
    {
      if (jdField_a_of_type_JavaLangString == null) {
        jdField_a_of_type_JavaLangString = getStorePath(paramContext, "imageV2", false, false);
      }
      return jdField_a_of_type_JavaLangString;
    }
    finally {}
  }
  
  @Public
  public static String getCachePath(Context paramContext, String paramString)
  {
    return getStorePath(paramContext, paramString, false, false);
  }
  
  @Public
  public static String getCachePathSR(Context paramContext)
  {
    if (jdField_b_of_type_JavaLangString == null) {}
    try
    {
      if (jdField_b_of_type_JavaLangString == null) {
        jdField_b_of_type_JavaLangString = getStorePath(paramContext, "image_sr", false, false);
      }
      return jdField_b_of_type_JavaLangString;
    }
    finally {}
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
  
  public static ImageManager getInstance()
  {
    if (jdField_a_of_type_ComTencentComponentMediaImageImageManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentComponentMediaImageImageManager == null) {
        jdField_a_of_type_ComTencentComponentMediaImageImageManager = new ImageManager();
      }
      return jdField_a_of_type_ComTencentComponentMediaImageImageManager;
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
      SharpPUtils.a(paramContext, paramString1);
      return paramContext;
    }
  }
  
  public static String getStorePath(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String str1 = "";
    localObject = str1;
    for (;;)
    {
      try
      {
        String str2 = Environment.getExternalStorageState();
        localObject = str1;
        jdField_e_of_type_Long = jdField_d_of_type_Long;
        localObject = str1;
        jdField_g_of_type_Boolean = false;
        paramContext = str1;
        if (!paramBoolean1)
        {
          paramContext = str1;
          localObject = str1;
          if ("mounted".equals(str2))
          {
            if (paramBoolean2 != true) {
              continue;
            }
            localObject = str1;
            if (TextUtils.isEmpty(jdField_d_of_type_JavaLangString)) {
              continue;
            }
            localObject = str1;
            jdField_c_of_type_JavaLangString = jdField_d_of_type_JavaLangString;
            localObject = str1;
            paramContext = jdField_c_of_type_JavaLangString + File.separator + ImageManagerEnv.g().getImageCacheDir(true);
            localObject = paramContext;
            jdField_e_of_type_Long = jdField_c_of_type_Long;
            localObject = paramContext;
            jdField_g_of_type_Boolean = true;
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        paramContext = (Context)localObject;
        continue;
      }
      localObject = paramContext;
      if (!jdField_g_of_type_Boolean)
      {
        jdField_c_of_type_JavaLangString = Environment.getDataDirectory().getAbsolutePath();
        localObject = ImageManagerEnv.g().getImageCacheDir(false);
      }
      paramContext = paramString;
      if (!paramString.startsWith(File.separator)) {
        paramContext = File.separator + paramString;
      }
      paramString = paramContext;
      if (!paramContext.endsWith(File.separator)) {
        paramString = paramContext + File.separator;
      }
      paramContext = new File((String)localObject + paramString);
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      paramString = paramContext.getAbsolutePath();
      paramContext = paramString;
      if (!paramString.endsWith(File.separator)) {
        paramContext = paramString + File.separator;
      }
      return paramContext;
      paramContext = str1;
      localObject = str1;
      if (Environment.getExternalStorageDirectory().canWrite())
      {
        localObject = str1;
        jdField_c_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath();
        localObject = str1;
        paramContext = jdField_c_of_type_JavaLangString + File.separator + ImageManagerEnv.g().getImageCacheDir(true);
        localObject = paramContext;
        jdField_e_of_type_Long = jdField_c_of_type_Long;
        localObject = paramContext;
        jdField_g_of_type_Boolean = true;
      }
    }
  }
  
  public static Handler getSuperResolutionHandler()
  {
    if (jdField_a_of_type_AndroidOsHandler == null) {}
    try
    {
      if (jdField_a_of_type_AndroidOsHandler == null)
      {
        jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("super_resolution_handler_thread");
        jdField_a_of_type_AndroidOsHandlerThread.start();
        jdField_a_of_type_AndroidOsHandler = new pgu(jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      }
      return jdField_a_of_type_AndroidOsHandler;
    }
    finally {}
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
  
  public static void post(Runnable paramRunnable, boolean paramBoolean)
  {
    a().execute(new phg(paramRunnable, paramBoolean));
  }
  
  public static void stopAllSuperResolutionTasks()
  {
    if (jdField_a_of_type_AndroidOsHandler != null) {
      jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
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
  
  public Drawable a(ImageKey paramImageKey)
  {
    if (paramImageKey == null) {}
    for (;;)
    {
      return null;
      Object localObject2;
      Object localObject1;
      Long localLong;
      long l;
      label522:
      if (jdField_a_of_type_Boolean)
      {
        int j = paramImageKey.hashCodeEx();
        localObject2 = (Drawable)a().get(Integer.valueOf(j));
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.jdField_b_of_type_Boolean)
          {
            localLong = (Long)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramImageKey.urlKey);
            localObject1 = localObject2;
            if (localLong != null)
            {
              ImageManagerLog.w(TAG, "getDrawbleFromCache, use no-cache, url = " + paramImageKey.url + ", cache_time = " + localLong);
              l = ImageManagerEnv.g().getNoCacheImageExpiredTime();
              if (System.currentTimeMillis() - localLong.longValue() < l * 1000L) {
                break label218;
              }
              this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramImageKey.urlKey);
              if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
                this.jdField_b_of_type_Boolean = false;
              }
              clear(paramImageKey.url);
              ImageManagerLog.w(TAG, "getDrawbleFromCache, clear no-cache memory, url = " + paramImageKey.url);
              localObject1 = null;
            }
          }
        }
        while (localObject1 != null)
        {
          return localObject1;
          label218:
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramImageKey.filePath))
          {
            localObject1 = new File(paramImageKey.filePath);
            ImageManagerLog.d(TAG, "getDrawbleFromCache, use no-cache drawable, url=" + paramImageKey.url + ", file length=" + ((File)localObject1).length());
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        localObject2 = (Image)b().get(Integer.valueOf(paramImageKey.hashCodeEx()));
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (this.jdField_b_of_type_Boolean)
          {
            localLong = (Long)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramImageKey.urlKey);
            ImageManagerLog.w(TAG, "getDrawbleFromCache, use no-cache, url = " + paramImageKey.url + ", cache_time = " + localLong);
            if (localLong == null) {
              break label522;
            }
            l = ImageManagerEnv.g().getNoCacheImageExpiredTime();
            localObject1 = localObject2;
            if (System.currentTimeMillis() - localLong.longValue() >= l * 1000L)
            {
              this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramImageKey.urlKey);
              if (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.size() == 0) {
                this.jdField_b_of_type_Boolean = false;
              }
              clear(paramImageKey.url);
              ImageManagerLog.w(TAG, "getDrawbleFromCache, clear no-cache memory, url = " + paramImageKey.url);
              localObject1 = null;
            }
          }
        }
        label491:
        if (localObject1 != null) {
          try
          {
            if ((localObject1 instanceof FeedsBitmapImage))
            {
              paramImageKey = new SpecifiedBitmapDrawable(((FeedsBitmapImage)localObject1).getBitmap());
              return paramImageKey;
              localObject1 = localObject2;
              if (TextUtils.isEmpty(paramImageKey.filePath)) {
                break label491;
              }
              localObject1 = new File(paramImageKey.filePath);
              ImageManagerLog.d(TAG, "getDrawbleFromCache, use no-cache drawable, url=" + paramImageKey.url + ", file length=" + ((File)localObject1).length());
              localObject1 = localObject2;
              break label491;
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
            if ((localObject1 instanceof NewGifImage))
            {
              paramImageKey = ((NewGifImage)localObject1).getDrawable();
              return paramImageKey;
            }
          }
          catch (Throwable paramImageKey) {}
        }
      }
    }
    return null;
  }
  
  void a(ImageKey paramImageKey)
  {
    Integer localInteger;
    if (paramImageKey.isNetworkUrl)
    {
      localInteger = (Integer)jdField_b_of_type_JavaUtilHashMap.get(paramImageKey.filePath);
      if (localInteger == null) {
        break label113;
      }
      if (jdField_b_of_type_Int == -1)
      {
        jdField_b_of_type_Int = ImageManagerEnv.g().getMaxNumOfDecodingFailures();
        if (jdField_b_of_type_Int <= -1)
        {
          jdField_b_of_type_Int = 3;
          ImageManagerLog.w(TAG, "--maxDecodeFailCount<=-1,so set default value: 3.");
        }
      }
      if (localInteger.intValue() >= jdField_b_of_type_Int)
      {
        removeImageFile(paramImageKey.url, null);
        jdField_b_of_type_JavaUtilHashMap.remove(paramImageKey.filePath);
      }
    }
    else
    {
      return;
    }
    jdField_b_of_type_JavaUtilHashMap.put(paramImageKey.filePath, Integer.valueOf(localInteger.intValue() + 1));
    return;
    label113:
    jdField_b_of_type_JavaUtilHashMap.put(paramImageKey.filePath, Integer.valueOf(1));
  }
  
  public void a(String paramString, int paramInt, Image paramImage, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    if ((paramOptions != null) && (!paramOptions.needCache))
    {
      ImageManagerLog.d(TAG, "options.needCache=false,needn't put into cache");
      return;
    }
    if (jdField_a_of_type_Boolean) {
      if (a(paramDrawable)) {
        a().put(Integer.valueOf(paramInt), paramDrawable);
      }
    }
    for (;;)
    {
      paramDrawable = (HashSet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      paramImage = paramDrawable;
      if (paramDrawable == null)
      {
        paramImage = new HashSet();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramImage);
      }
      paramImage.add(Integer.valueOf(paramInt));
      return;
      ImageManagerLog.d("feilongzou", "drawable 不能精确计算大小，不能放入缓存中：" + paramDrawable);
      continue;
      b().put(Integer.valueOf(paramInt), paramImage);
    }
  }
  
  boolean a(ImageKey paramImageKey)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 5000L)
    {
      this.jdField_a_of_type_Long = l;
      this.jdField_d_of_type_Boolean = b();
      if (this.jdField_d_of_type_Boolean)
      {
        d();
        this.jdField_d_of_type_Boolean = b();
        if ((this.jdField_d_of_type_Boolean) && (jdField_g_of_type_Boolean))
        {
          if (TextUtils.isEmpty(jdField_d_of_type_JavaLangString)) {
            break label240;
          }
          jdField_a_of_type_JavaLangString = getStorePath(this.jdField_a_of_type_AndroidContentContext, "image", false, true);
          paramImageKey.filePath = (getCachePath(this.jdField_a_of_type_AndroidContentContext) + urlKey2FileName(paramImageKey.urlKey, true));
          d();
          this.jdField_d_of_type_Boolean = b();
          if (this.jdField_d_of_type_Boolean)
          {
            jdField_a_of_type_JavaLangString = getStorePath(this.jdField_a_of_type_AndroidContentContext, "image", true, false);
            paramImageKey.filePath = (getCachePath(this.jdField_a_of_type_AndroidContentContext) + urlKey2FileName(paramImageKey.urlKey, true));
            d();
          }
        }
      }
    }
    for (this.jdField_d_of_type_Boolean = b();; this.jdField_d_of_type_Boolean = b())
    {
      if ((this.jdField_d_of_type_Boolean) && (jdField_c_of_type_Boolean)) {
        ImageManagerEnv.g().showToast(0, this.jdField_a_of_type_AndroidContentContext, "手机存储空间不足，图片无法下载展示，请及时清理！", 17);
      }
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      return false;
      label240:
      jdField_a_of_type_JavaLangString = getStorePath(this.jdField_a_of_type_AndroidContentContext, "image", true, false);
      paramImageKey.filePath = (getCachePath(this.jdField_a_of_type_AndroidContentContext) + urlKey2FileName(paramImageKey.urlKey, true));
      d();
    }
    return true;
  }
  
  public boolean a(ImageKey paramImageKey, String paramString1, String paramString2, boolean paramBoolean)
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
        this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, Long.valueOf(l));
        this.jdField_b_of_type_Boolean = true;
        ImageManagerLog.w(TAG, "onDownloadSucceed,save no-cache info, url = " + paramString1);
      }
      if (paramImageKey == null) {
        break label439;
      }
      c(paramImageKey);
      localObject = new File(paramImageKey.filePath);
      if (!((File)localObject).exists()) {
        break label265;
      }
      if ((paramImageKey.isNetworkUrl) && (!paramBoolean))
      {
        b(paramImageKey);
        paramString2 = ((File)localObject).getName();
        j = (int)((File)localObject).length();
        this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, localObject);
        this.jdField_f_of_type_Long += j;
        jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(a(paramString2)), Integer.valueOf(j));
        ImageTracer.setImageLength(paramString1, j);
      }
      if (paramBoolean)
      {
        paramImageKey = new File(a(paramImageKey, true));
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
        break label439;
      }
      jdField_a_of_type_JavaLangString = getStorePath(this.jdField_a_of_type_AndroidContentContext, "image", true, false);
      paramImageKey.filePath = (getCachePath(this.jdField_a_of_type_AndroidContentContext) + urlKey2FileName(paramImageKey.urlKey, true));
      paramImageKey = new File(paramImageKey.filePath);
      if (!ImageManagerEnv.g().copyFiles(new File(paramString2), paramImageKey)) {
        break label439;
      }
    } while (paramBoolean);
    paramString2 = paramImageKey.getName();
    int j = (int)paramImageKey.length();
    this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString2, paramImageKey);
    this.jdField_f_of_type_Long += j;
    jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(a(paramString2)), Integer.valueOf(j));
    ImageTracer.setImageLength(paramString1, j);
    return true;
    label439:
    return false;
  }
  
  void b(ImageKey paramImageKey)
  {
    if ((paramImageKey != null) && (paramImageKey.isNetworkUrl))
    {
      c(paramImageKey);
      paramImageKey = urlKey2FileName(paramImageKey.urlKey, true);
      int j = (int)(System.currentTimeMillis() / 1000L);
      i.put(paramImageKey, Integer.valueOf(j));
    }
  }
  
  public void c(ImageKey paramImageKey)
  {
    Object localObject1;
    String str;
    if ((paramImageKey.filePath == null) || (paramImageKey.filePath.length() == 0))
    {
      if (!paramImageKey.isNetworkUrl) {
        break label390;
      }
      localObject1 = paramImageKey.urlKey;
      if ((paramImageKey.options == null) || (paramImageKey.options.fileRootPath == null) || (paramImageKey.options.fileRootPath.length() <= 0)) {
        break label151;
      }
      str = paramImageKey.options.fileRootPath;
    }
    label151:
    label438:
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
        if (RapidNetUtils.isSuperResolutionUrl(paramImageKey.url))
        {
          str = getCachePathSR(this.jdField_a_of_type_AndroidContentContext);
          Object localObject2 = new File(str + urlKey2FileName(paramImageKey.urlKey, true));
          if (((File)localObject2).exists())
          {
            ImageManagerLog.w("superresolution", "using cache. url=" + paramImageKey.url + " filePath=" + ((File)localObject2).getAbsolutePath());
            paramImageKey.needSuperResolution = false;
            break;
          }
          str = getCachePath(this.jdField_a_of_type_AndroidContentContext);
          if (!RapidNetUtils.isHighScaleUrl(paramImageKey.url)) {
            break label438;
          }
          localObject2 = ImageKey.getUrlKey4NoneHighScale(paramImageKey.url, true);
          File localFile = new File(str + urlKey2FileName((String)localObject2, true));
          if (!localFile.exists()) {
            break label438;
          }
          ImageManagerLog.w("superresolution", "high scale. using normal big cache. url=" + paramImageKey.url + " filePath=" + localFile.getAbsolutePath());
          localObject1 = localObject2;
          break;
        }
        str = getCachePath(this.jdField_a_of_type_AndroidContentContext);
        break;
        if ((ImageManagerEnv.g().needCheckAvatar()) && (paramImageKey.isAvatarUrl())) {
          paramImageKey.filePath = ImageManagerEnv.g().getAvatarPath(paramImageKey.url);
        } else {
          paramImageKey.filePath = urlKey2FileName(paramImageKey.urlKey, false);
        }
      }
    }
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
    paramString = a().obtainMessage();
    paramString.what = 1;
    paramString.obj = localImageKey;
    a().sendMessage(paramString);
  }
  
  public int capacity()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void checkCleanImageLocalFile()
  {
    if (jdField_c_of_type_Boolean) {
      post(new pgx(this), false);
    }
    if ((jdField_c_of_type_Boolean) && ((!jdField_h_of_type_Boolean) || ((jdField_h_of_type_Boolean) && (this.jdField_f_of_type_Long > jdField_e_of_type_Long))))
    {
      a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  public void clear(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      paramString = ImageKey.getUrlKey(paramString, false);
      paramString = (HashSet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          int j = ((Integer)paramString.next()).intValue();
          if (jdField_a_of_type_Boolean) {
            a().remove(Integer.valueOf(j));
          } else {
            b().remove(Integer.valueOf(j));
          }
        }
      }
    }
  }
  
  public void clear(String paramString, ImageLoader.Options paramOptions)
  {
    ImageKey localImageKey = ImageKey.obtain();
    localImageKey.setUrl(paramString);
    localImageKey.options = paramOptions;
    int j = localImageKey.hashCodeEx();
    if ((localImageKey.urlKey == null) || (jdField_a_of_type_Boolean)) {
      a().remove(Integer.valueOf(j));
    }
    for (;;)
    {
      localImageKey.recycle();
      return;
      b().remove(Integer.valueOf(j));
    }
  }
  
  public void clear(boolean paramBoolean)
  {
    if (jdField_a_of_type_Boolean) {
      a().evictAll();
    }
    for (;;)
    {
      ImageKey.clearAndInitSize();
      if (paramBoolean) {
        d();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
      b().evictAll();
    }
  }
  
  public BitmapReference getBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageIBitmapFactory != null) {
      return this.jdField_a_of_type_ComTencentComponentMediaImageIBitmapFactory.createBitmap(paramInt1, paramInt2, paramConfig);
    }
    return BitmapReference.getBitmapReference(Bitmap.createBitmap(paramInt1, paramInt2, paramConfig));
  }
  
  public IDecoder getDecoder()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaImageIDecoder;
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
    boolean bool;
    if (localImageKey.options == null)
    {
      bool = false;
      label56:
      localImageKey.needCallBackProcessPercent = bool;
      localImageKey.imglistener = paramImageDownloadListener;
      if ((RapidNetUtils.isSuperResolutionUrl(paramString)) && (!RapidNetUtils.isHighScaleUrl(paramString)))
      {
        paramImageLoadListener = RapidNetUtils.convertSrUrlToBigUrl(paramString);
        if (paramImageLoadListener != null)
        {
          paramImageDownloadListener = ImageKey.getUrlKey(paramImageLoadListener, true);
          String str = getCachePath(this.jdField_a_of_type_AndroidContentContext);
          if ((!new File(str + urlKey2FileName(paramImageDownloadListener, true)).exists()) && (ImageManagerEnv.g().enableSuperResolution())) {
            break label302;
          }
          ImageManagerLog.w("superresolution", "big cache file exists. url=" + paramString);
          localImageKey.srUrl = paramString;
          localImageKey.setUrl(paramImageLoadListener);
        }
      }
    }
    for (;;)
    {
      paramImageLoadListener = a(localImageKey);
      if (paramImageLoadListener == null) {
        break label413;
      }
      if ((isInFriendFeed) && (paramOptions != null) && (!paramOptions.isPreDecode) && (hasScrolled) && (!paramOptions.disableHitRateReport))
      {
        paramString = a().obtainMessage();
        paramString.what = 2;
        paramString.obj = localImageKey;
        paramString.arg1 = 16;
        a().sendMessage(paramString);
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
      bool = localImageKey.options.needCallBackProcessPercent;
      break label56;
      label302:
      if (!RapidNetUtils.hasInit())
      {
        paramImageDownloadListener = getCachePathSR(this.jdField_a_of_type_AndroidContentContext);
        if (!new File(paramImageDownloadListener + urlKey2FileName(localImageKey.urlKey, true)).exists())
        {
          ImageManagerLog.w("superresolution", "library not init. use big url. url=" + paramString);
          localImageKey.srUrl = paramString;
          localImageKey.setUrl(paramImageLoadListener);
          getSuperResolutionHandler().post(new phe(this));
        }
      }
    }
    label413:
    if ((isInFriendFeed) && (paramOptions != null) && (!paramOptions.isPreDecode) && (hasScrolled) && (!paramOptions.disableHitRateReport))
    {
      paramString = a().obtainMessage();
      paramString.what = 2;
      paramString.obj = localImageKey;
      paramString.arg1 = 0;
      a().sendMessage(paramString);
    }
    ImageTaskTracer.addImageMsgGetNullRecord(localImageKey.hashCodeEx());
    paramString = a().obtainMessage();
    paramString.what = 0;
    paramString.obj = localImageKey;
    a().sendMessage(paramString);
    return null;
  }
  
  public Drawable getImageByUrlInMemory(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      paramString = null;
      return paramString;
    }
    paramString = ImageKey.getUrlKey(paramString, false);
    paramString = (HashSet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramString = paramString.iterator();
      for (;;)
      {
        if (paramString.hasNext())
        {
          int j = ((Integer)paramString.next()).intValue();
          if (jdField_a_of_type_Boolean)
          {
            localObject = (Drawable)a().get(Integer.valueOf(j));
            if (localObject == null) {
              continue;
            }
            paramString = (String)localObject;
            if (!(localObject instanceof NewGifDrawable)) {
              break;
            }
            ((NewGifDrawable)localObject).setVisible(true, true);
            return localObject;
          }
          Object localObject = (Image)b().get(Integer.valueOf(j));
          if (localObject != null) {
            try
            {
              if ((localObject instanceof FeedsBitmapImage)) {
                return new SpecifiedBitmapDrawable(((FeedsBitmapImage)localObject).getBitmap());
              }
              if (!(localObject instanceof BitmapImage)) {
                break label187;
              }
              paramString = new SpecifiedBitmapDrawable(((BitmapImage)localObject).getBitmap());
              return paramString;
            }
            catch (Throwable paramString)
            {
              return null;
            }
          }
        }
      }
    }
    return null;
    label187:
    return null;
  }
  
  public File getImageFile(String paramString, ImageLoader.Options paramOptions)
  {
    Object localObject = null;
    File localFile1;
    if (isNetworkUrl(paramString))
    {
      String str = urlKey2FileName(ImageKey.getUrlKey(paramString, true), true);
      File localFile2 = (File)this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      localFile1 = localFile2;
      if (localFile2 == null)
      {
        if ((paramOptions == null) || (paramOptions.fileRootPath == null) || (paramOptions.fileRootPath.length() <= 0)) {
          break label136;
        }
        paramOptions = paramOptions.fileRootPath;
        localFile1 = new File(paramOptions + str);
        if (!localFile1.exists()) {
          break label157;
        }
        this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localFile1);
        this.jdField_f_of_type_Long += localFile1.length();
      }
    }
    for (;;)
    {
      SharpPUtils.a(localFile1, paramString);
      paramOptions = localFile1;
      label136:
      do
      {
        return paramOptions;
        paramOptions = localObject;
      } while (jdField_h_of_type_Boolean == true);
      paramOptions = getCachePath(this.jdField_a_of_type_AndroidContentContext);
      break;
      label157:
      localFile1 = getImageFileForSuperResolution(paramString);
      continue;
      localFile1 = null;
    }
  }
  
  public File getImageFileForSuperResolution(String paramString)
  {
    if (RapidNetUtils.isSuperResolutionUrl(paramString))
    {
      Object localObject1;
      if (RapidNetUtils.isHighScaleUrl(paramString))
      {
        localObject1 = getCachePathSR(this.jdField_a_of_type_AndroidContentContext);
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
            localObject2 = getCachePath(this.jdField_a_of_type_AndroidContentContext);
            localObject2 = new File((String)localObject2 + urlKey2FileName((String)localObject1, true));
            localObject1 = localObject2;
          } while (((File)localObject2).exists());
          localObject1 = RapidNetUtils.convertSrUrlToBigUrl(paramString);
          if (localObject1 == null) {
            break;
          }
          localObject1 = ImageKey.getUrlKey((String)localObject1, true);
          localObject2 = getCachePath(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new File((String)localObject2 + urlKey2FileName((String)localObject1, true));
          localObject1 = localObject2;
        } while (((File)localObject2).exists());
        localObject1 = getCachePathSR(this.jdField_a_of_type_AndroidContentContext);
        paramString = new File((String)localObject1 + urlKey2FileName(ImageKey.getUrlKey(paramString, true), true));
        localObject1 = paramString;
      } while (paramString.exists());
    }
    return null;
  }
  
  public void nocachedDeleteLocalFile(ImageKey paramImageKey)
  {
    File localFile;
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramImageKey.urlKey)))
    {
      localFile = new File(paramImageKey.filePath);
      if (localFile.exists())
      {
        boolean bool = localFile.delete();
        ImageManagerLog.w(TAG, "nocachedDeleteLocalFile, delete local file is: " + bool + ", url = " + paramImageKey.url + ", filePath=" + paramImageKey.filePath);
        if (bool)
        {
          paramImageKey = new File(a(paramImageKey, false));
          if (paramImageKey.exists()) {
            paramImageKey.delete();
          }
        }
      }
    }
    do
    {
      return;
      localFile = new File(a(paramImageKey, false));
    } while (!localFile.exists());
    paramImageKey = new File(paramImageKey.filePath);
    if (paramImageKey.exists()) {
      paramImageKey.delete();
    }
    localFile.delete();
  }
  
  public void notifyDownSuccess(ImageKey paramImageKey, String paramString1, String paramString2)
  {
    a(paramImageKey, paramString1, paramString2, false);
  }
  
  public void onListViewIdle()
  {
    phi.a().a();
  }
  
  public void removeImageFile(String paramString, ImageLoader.Options paramOptions)
  {
    String str;
    if (isNetworkUrl(paramString))
    {
      str = urlKey2FileName(ImageKey.getUrlKey(paramString, true), true);
      File localFile = (File)this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
      jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(a(str)));
      paramString = localFile;
      if (localFile == null) {
        if ((paramOptions == null) || (paramOptions.fileRootPath == null) || (paramOptions.fileRootPath.length() <= 0)) {
          break label135;
        }
      }
    }
    label135:
    for (paramString = paramOptions.fileRootPath;; paramString = getCachePath(this.jdField_a_of_type_AndroidContentContext))
    {
      paramString = new File(paramString + str);
      if ((paramString != null) && (paramString.exists()))
      {
        this.jdField_f_of_type_Long -= paramString.length();
        paramString.delete();
      }
      return;
    }
  }
  
  public void saveSuperResImage(Bitmap paramBitmap, ImageKey paramImageKey)
  {
    String str = getCachePathSR(this.jdField_a_of_type_AndroidContentContext) + urlKey2FileName(paramImageKey.urlKey, true);
    BitmapUtils.saveBitmapToFile(paramBitmap, str);
    paramBitmap = paramImageKey.filePath;
    paramImageKey.filePath = str;
    BitmapUtils.copyExif(paramBitmap, str);
    paramImageKey.needSuperResolution = false;
    paramBitmap = new File(str);
    b(paramImageKey);
    paramImageKey = paramBitmap.getName();
    int j = (int)paramBitmap.length();
    this.jdField_g_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramImageKey, paramBitmap);
    this.jdField_f_of_type_Long += j;
    jdField_h_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(a(paramImageKey)), Integer.valueOf(j));
  }
  
  public void setImageFileTracer(IImageFileTracer paramIImageFileTracer)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageIImageFileTracer = paramIImageFileTracer;
  }
  
  protected void traceImageFile(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageIImageFileTracer != null) {
      this.jdField_a_of_type_ComTencentComponentMediaImageIImageFileTracer.onImageFileDecode(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager
 * JD-Core Version:    0.7.0.1
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.MultiHashMap;
import cooperation.qzone.util.ResDownloadManger.1;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class bmju
{
  private static bmju jdField_a_of_type_Bmju;
  private static String jdField_a_of_type_JavaLangString;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_yellow_icon_v1.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_themeAlbum.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_weather.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_cover_widget_lunar.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_loading_bg.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_feed_res.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_plus_publish_video_anim_guide_resource.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_album_first_page_loading_bg.zip", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/qq_qzone_android/qzone_skin_feed_dropmenu_default.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_ads_res.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_feed_list_slide_out_video_capture_anim.zip", "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_photo_category_empty_bgs.zip", "https://d3g.qq.com/sngapp/app/update/20181210212921_4631/qzone_recent_photo_calendar.zip", "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/qq_qzone_android/qzone_skin_feed_dropmenu_night_mode.zip" };
  private static String b;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private LruCache<String, Bitmap> jdField_a_of_type_AndroidSupportV4UtilLruCache;
  private blum jdField_a_of_type_Blum;
  private Downloader.DownloadListener jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener = new bmjv(this);
  private final MultiHashMap<String, bmjx> jdField_a_of_type_CooperationQzoneUtilMultiHashMap = new MultiHashMap();
  
  private bmju()
  {
    jdField_a_of_type_JavaLangString = c("qzonereszip");
    b = c("qzoneres");
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache((int)(MemoryManager.a() / 8L));
  }
  
  public static int a()
  {
    if (ThemeUtil.isNowThemeIsNightForQzone()) {
      return 13;
    }
    return 8;
  }
  
  /* Error */
  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 116	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: astore_0
    //   13: new 121	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_2
    //   18: sipush 8192
    //   21: invokespecial 124	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   24: aconst_null
    //   25: aload_1
    //   26: invokestatic 130	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: astore_1
    //   30: aload_1
    //   31: astore_0
    //   32: aload_2
    //   33: ifnull +9 -> 42
    //   36: aload_2
    //   37: invokevirtual 135	java/io/InputStream:close	()V
    //   40: aload_1
    //   41: astore_0
    //   42: aload_0
    //   43: areturn
    //   44: astore_1
    //   45: aconst_null
    //   46: astore_2
    //   47: aload_2
    //   48: astore_0
    //   49: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq +14 -> 66
    //   55: aload_2
    //   56: astore_0
    //   57: ldc 142
    //   59: iconst_2
    //   60: ldc 144
    //   62: aload_1
    //   63: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   66: aload_3
    //   67: astore_0
    //   68: aload_2
    //   69: ifnull -27 -> 42
    //   72: aload_2
    //   73: invokevirtual 135	java/io/InputStream:close	()V
    //   76: aconst_null
    //   77: areturn
    //   78: astore_0
    //   79: aconst_null
    //   80: areturn
    //   81: astore_1
    //   82: aconst_null
    //   83: astore_2
    //   84: aload_2
    //   85: astore_0
    //   86: invokestatic 140	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +14 -> 103
    //   92: aload_2
    //   93: astore_0
    //   94: ldc 142
    //   96: iconst_2
    //   97: ldc 144
    //   99: aload_1
    //   100: invokestatic 148	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_3
    //   104: astore_0
    //   105: aload_2
    //   106: ifnull -64 -> 42
    //   109: aload_2
    //   110: invokevirtual 135	java/io/InputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: aconst_null
    //   117: areturn
    //   118: astore_1
    //   119: aconst_null
    //   120: astore_0
    //   121: aload_0
    //   122: ifnull +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 135	java/io/InputStream:close	()V
    //   129: aload_1
    //   130: athrow
    //   131: astore_0
    //   132: aload_1
    //   133: areturn
    //   134: astore_0
    //   135: goto -6 -> 129
    //   138: astore_1
    //   139: goto -18 -> 121
    //   142: astore_1
    //   143: goto -59 -> 84
    //   146: astore_1
    //   147: goto -100 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramString	String
    //   0	150	1	paramOptions	BitmapFactory.Options
    //   10	100	2	localFileInputStream	java.io.FileInputStream
    //   1	103	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	44	java/lang/OutOfMemoryError
    //   72	76	78	java/io/IOException
    //   2	11	81	java/lang/Exception
    //   109	113	115	java/io/IOException
    //   2	11	118	finally
    //   36	40	131	java/io/IOException
    //   125	129	134	java/io/IOException
    //   13	30	138	finally
    //   49	55	138	finally
    //   57	66	138	finally
    //   86	92	138	finally
    //   94	103	138	finally
    //   13	30	142	java/lang/Exception
    //   13	30	146	java/lang/OutOfMemoryError
  }
  
  /* Error */
  private blum a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 152	bmju:jdField_a_of_type_Blum	Lblum;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 152	bmju:jdField_a_of_type_Blum	Lblum;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: invokestatic 156	blum:a	()Lblum;
    //   22: putfield 152	bmju:jdField_a_of_type_Blum	Lblum;
    //   25: aload_0
    //   26: getfield 152	bmju:jdField_a_of_type_Blum	Lblum;
    //   29: astore_1
    //   30: goto -16 -> 14
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	bmju
    //   13	17	1	localblum	blum
    //   33	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	33	finally
    //   18	30	33	finally
  }
  
  public static bmju a()
  {
    if (jdField_a_of_type_Bmju == null) {}
    try
    {
      jdField_a_of_type_Bmju = new bmju();
      return jdField_a_of_type_Bmju;
    }
    finally {}
  }
  
  private bmjx a(String paramString1, int paramInt, String paramString2, bmjw parambmjw)
  {
    bmjx localbmjx = bmjx.a(paramInt, paramString2);
    localbmjx.b = paramString1;
    localbmjx.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmjw);
    localbmjx.jdField_a_of_type_Int = paramInt;
    localbmjx.d = paramString2;
    return localbmjx;
  }
  
  private Collection<bmjx> a(String paramString, boolean paramBoolean)
  {
    return a(paramString, paramBoolean, null);
  }
  
  private Collection<bmjx> a(String paramString, boolean paramBoolean, Collection<bmjx> paramCollection)
  {
    MultiHashMap localMultiHashMap = this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap;
    if (paramBoolean) {}
    try
    {
      for (paramString = (HashSet)this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.remove(paramString); paramCollection != null; paramString = (HashSet)this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.get(paramString))
      {
        paramCollection.clear();
        if (paramString != null) {
          paramCollection.addAll(paramString);
        }
        return paramCollection;
      }
      return paramString;
    }
    finally {}
  }
  
  public static void a(int paramInt, String paramString)
  {
    jdField_a_of_type_ArrayOfJavaLangString[paramInt] = paramString;
  }
  
  private void a(bmjx parambmjx)
  {
    if (URLUtil.isNetworkUrl(parambmjx.b))
    {
      String str = b(parambmjx.b);
      a().a(parambmjx.b, str, true, this.jdField_a_of_type_ComTencentComponentNetworkDownloaderDownloader$DownloadListener);
    }
  }
  
  private static void a(File paramFile)
  {
    if (!paramFile.exists()) {
      paramFile.mkdir();
    }
    for (;;)
    {
      return;
      if (!paramFile.isDirectory()) {
        break;
      }
      paramFile = paramFile.listFiles();
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramFile[i];
          if (!localObject.isDirectory()) {
            localObject.delete();
          }
          i += 1;
        }
      }
    }
    paramFile.mkdir();
  }
  
  private boolean a(String paramString, bmjx parambmjx)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap)
      {
        int i = this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.sizeOf(paramString);
        this.jdField_a_of_type_CooperationQzoneUtilMultiHashMap.add(paramString, parambmjx);
        if (i == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private static File b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return new File(b + paramString1.substring(paramString1.lastIndexOf("/") + 1, paramString1.length() - 4) + File.separator + paramString2 + ".png");
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length());
    return jdField_a_of_type_JavaLangString + paramString;
  }
  
  private static void b(String paramString)
  {
    String str = b + paramString.substring(paramString.lastIndexOf("/") + 1, paramString.length() - 4);
    a(new File(str));
    nmk.a(paramString, str);
  }
  
  private static boolean b(File paramFile)
  {
    return (paramFile != null) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  private static String c(String paramString)
  {
    String str2 = BaseApplicationImpl.getContext().getCacheDir().getAbsolutePath();
    String str1 = paramString;
    if (!paramString.startsWith(File.separator)) {
      str1 = File.separator + paramString;
    }
    paramString = str1;
    if (!str1.endsWith(File.separator)) {
      paramString = str1 + File.separator;
    }
    paramString = new File(str2 + paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    str1 = paramString.getAbsolutePath();
    paramString = str1;
    if (!str1.endsWith(File.separator)) {
      paramString = str1 + File.separator;
    }
    return paramString;
  }
  
  /* Error */
  public Bitmap a(int paramInt, String paramString, bmjw parambmjw)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_2
    //   4: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +6 -> 13
    //   10: aload 5
    //   12: areturn
    //   13: aload_0
    //   14: getfield 100	bmju:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   17: new 277	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   24: iload_1
    //   25: invokevirtual 339	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   28: ldc_w 341
    //   31: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokevirtual 342	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: checkcast 344	android/graphics/Bitmap
    //   47: astore 4
    //   49: aload 4
    //   51: astore 5
    //   53: aload 4
    //   55: ifnonnull -45 -> 10
    //   58: getstatic 50	bmju:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   61: iload_1
    //   62: aaload
    //   63: astore 7
    //   65: aload 7
    //   67: aload_2
    //   68: invokestatic 187	bmju:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/File;
    //   71: astore 8
    //   73: aload 8
    //   75: invokestatic 260	bmju:b	(Ljava/io/File;)Z
    //   78: ifeq +186 -> 264
    //   81: aload_0
    //   82: monitorenter
    //   83: aload 4
    //   85: astore 5
    //   87: aload_0
    //   88: getfield 100	bmju:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   91: new 277	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   98: iload_1
    //   99: invokevirtual 339	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: ldc_w 341
    //   105: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokevirtual 342	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast 344	android/graphics/Bitmap
    //   121: astore 6
    //   123: aload 6
    //   125: ifnull +13 -> 138
    //   128: aload_0
    //   129: monitorexit
    //   130: aload 6
    //   132: areturn
    //   133: astore_2
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_2
    //   137: athrow
    //   138: aload 6
    //   140: astore 5
    //   142: aload 6
    //   144: astore 4
    //   146: ldc 142
    //   148: iconst_1
    //   149: ldc_w 346
    //   152: invokestatic 350	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: aload 6
    //   157: astore 5
    //   159: aload 6
    //   161: astore 4
    //   163: aload 8
    //   165: invokevirtual 326	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   168: aconst_null
    //   169: invokestatic 352	bmju:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   172: astore 6
    //   174: aload 6
    //   176: astore 4
    //   178: aload_0
    //   179: monitorexit
    //   180: aload 4
    //   182: astore 6
    //   184: aload 4
    //   186: ifnull +91 -> 277
    //   189: aload_0
    //   190: getfield 100	bmju:jdField_a_of_type_AndroidSupportV4UtilLruCache	Landroid/support/v4/util/LruCache;
    //   193: new 277	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 278	java/lang/StringBuilder:<init>	()V
    //   200: iload_1
    //   201: invokevirtual 339	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: ldc_w 341
    //   207: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_2
    //   211: invokevirtual 282	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 304	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: aload 4
    //   219: invokevirtual 356	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   222: pop
    //   223: aload 4
    //   225: areturn
    //   226: astore 4
    //   228: ldc_w 358
    //   231: iconst_1
    //   232: aload 4
    //   234: invokevirtual 359	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   237: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload 5
    //   242: astore 4
    //   244: goto -66 -> 178
    //   247: astore 5
    //   249: ldc_w 358
    //   252: iconst_1
    //   253: aload 5
    //   255: invokevirtual 362	java/lang/Exception:toString	()Ljava/lang/String;
    //   258: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: goto -83 -> 178
    //   264: ldc 142
    //   266: iconst_1
    //   267: ldc_w 364
    //   270: invokestatic 350	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: aload 4
    //   275: astore 6
    //   277: aload_0
    //   278: aload 7
    //   280: iload_1
    //   281: aload_2
    //   282: aload_3
    //   283: invokespecial 164	bmju:a	(Ljava/lang/String;ILjava/lang/String;Lbmjw;)Lbmjx;
    //   286: astore_2
    //   287: aload 6
    //   289: astore 5
    //   291: aload_0
    //   292: aload 7
    //   294: aload_2
    //   295: invokespecial 257	bmju:a	(Ljava/lang/String;Lbmjx;)Z
    //   298: ifeq -288 -> 10
    //   301: aload_0
    //   302: aload_2
    //   303: invokespecial 222	bmju:a	(Lbmjx;)V
    //   306: aload 6
    //   308: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	bmju
    //   0	309	1	paramInt	int
    //   0	309	2	paramString	String
    //   0	309	3	parambmjw	bmjw
    //   47	177	4	localObject1	Object
    //   226	7	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   242	32	4	localObject2	Object
    //   1	240	5	localObject3	Object
    //   247	7	5	localException	java.lang.Exception
    //   289	1	5	localObject4	Object
    //   121	186	6	localObject5	Object
    //   63	230	7	str	String
    //   71	93	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   87	123	133	finally
    //   128	130	133	finally
    //   134	136	133	finally
    //   146	155	133	finally
    //   163	174	133	finally
    //   178	180	133	finally
    //   228	240	133	finally
    //   249	261	133	finally
    //   87	123	226	java/lang/OutOfMemoryError
    //   146	155	226	java/lang/OutOfMemoryError
    //   163	174	226	java/lang/OutOfMemoryError
    //   87	123	247	java/lang/Exception
    //   146	155	247	java/lang/Exception
    //   163	174	247	java/lang/Exception
  }
  
  public Bitmap a(int paramInt, String paramString, bmjw parambmjw, BitmapFactory.Options paramOptions)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    Bitmap localBitmap;
    do
    {
      return localObject;
      localBitmap = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramInt + " " + paramString);
      localObject = localBitmap;
    } while (localBitmap != null);
    QzoneHandlerThreadFactory.getHandlerThread("BackGround_HandlerThread").post(new ResDownloadManger.1(this, paramInt, paramString, parambmjw, paramOptions));
    return localBitmap;
  }
  
  public Drawable a(int paramInt, String paramString, bmjw parambmjw)
  {
    paramString = a(paramInt, paramString, parambmjw);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)bgtn.c());
      return paramString;
    }
    return null;
  }
  
  public Drawable a(int paramInt, String paramString, bmjw parambmjw, BitmapFactory.Options paramOptions)
  {
    paramString = a(paramInt, paramString, parambmjw, paramOptions);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)bgtn.c());
      return paramString;
    }
    return null;
  }
  
  public void a(int paramInt, ArrayList<String> paramArrayList)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4UtilLruCache != null) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        this.jdField_a_of_type_AndroidSupportV4UtilLruCache.remove(paramInt + " " + str);
      }
    }
  }
  
  public Drawable b(int paramInt, String paramString, bmjw parambmjw)
  {
    Object localObject = null;
    paramString = a(paramInt, paramString, parambmjw, null);
    if (paramString != null)
    {
      paramString.setDensity(320);
      paramString = new BitmapDrawable(paramString);
      paramString.setTargetDensity((int)bgtn.c());
    }
    do
    {
      return paramString;
      paramString = localObject;
    } while (!QLog.isColorLevel());
    QLog.d("Q.lebanew", 4, "qzonepouwindow:下载资源失败");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmju
 * JD-Core Version:    0.7.0.1
 */
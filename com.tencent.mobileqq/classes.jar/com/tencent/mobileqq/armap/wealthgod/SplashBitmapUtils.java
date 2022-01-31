package com.tencent.mobileqq.armap.wealthgod;

import abiy;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class SplashBitmapUtils
{
  private static ARMapDPC jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapDPC;
  public static final Object a;
  private static String jdField_a_of_type_JavaLangString;
  public static final Map a;
  public static final Map b;
  public static final Map c;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    b = new HashMap();
    jdField_a_of_type_JavaLangObject = new Object();
    c = new HashMap();
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_ENTRY_CLOUD", "qq_armap_splash_entry_layout_cloud");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_VIEW_COMPANY_ICON", "qq_armap_splash_layout_company_icon");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_CLOUD_LEFT_TOP", "qq_armap_splash_cloud_left_top");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_CLOUD_RIGHT_TOP", "qq_armap_splash_cloud_right_top");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_CLOUD_FG_1", "qq_armap_splash_fg_cloud_1");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_CLOUD_FG_2_SLEEP", "qq_armap_splash_fg_cloud_2_sleep");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_CLOUD_FG_2_WORK", "qq_armap_splash_fg_cloud_2_work");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_BG", "qq_armap_splash_layout_bg");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_WEALTH_GOD_SLEEP", "qq_armap_splash_layout_wealth_god_sleep");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_WEALTH_GOD_WORK", "qq_armap_splash_layout_wealth_god_work");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_WEALTH_GOD_BAOXIANG", "qq_armap_splash_layout_wealth_god_baoxiang");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_TOY_LEFT_SLEEP", "qq_armap_splash_toy_left_sleep");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_TOY_LEFT_WORK", "qq_armap_splash_toy_left_work");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_TOY_RIGHT_SLEEP", "qq_armap_splash_toy_right_sleep");
    jdField_a_of_type_JavaUtilMap.put("KEY_SPLASH_BG_TOY_RIGHT_WORK", "qq_armap_splash_toy_right_work");
    b.put("KEY_SPLASH_ENTRY_CLOUD", Integer.valueOf(2130903046));
    b.put("KEY_SPLASH_VIEW_COMPANY_ICON", Integer.valueOf(2130903050));
    b.put("KEY_SPLASH_BG_CLOUD_LEFT_TOP", Integer.valueOf(2130903044));
    b.put("KEY_SPLASH_BG_CLOUD_RIGHT_TOP", Integer.valueOf(2130903045));
    b.put("KEY_SPLASH_BG_CLOUD_FG_1", Integer.valueOf(2130903047));
    b.put("KEY_SPLASH_BG_CLOUD_FG_2_SLEEP", Integer.valueOf(2130903048));
    b.put("KEY_SPLASH_BG_CLOUD_FG_2_WORK", Integer.valueOf(2130903048));
    b.put("KEY_SPLASH_BG_BG", Integer.valueOf(2130903049));
    b.put("KEY_SPLASH_BG_WEALTH_GOD_SLEEP", Integer.valueOf(2130903053));
    b.put("KEY_SPLASH_BG_WEALTH_GOD_WORK", Integer.valueOf(2130903054));
    b.put("KEY_SPLASH_BG_WEALTH_GOD_BAOXIANG", Integer.valueOf(2130903052));
    b.put("KEY_SPLASH_BG_TOY_LEFT_SLEEP", Integer.valueOf(0));
    b.put("KEY_SPLASH_BG_TOY_LEFT_WORK", Integer.valueOf(0));
    b.put("KEY_SPLASH_BG_TOY_RIGHT_SLEEP", Integer.valueOf(0));
    b.put("KEY_SPLASH_BG_TOY_RIGHT_WORK", Integer.valueOf(0));
  }
  
  public static float a(float paramFloat1, float paramFloat2)
  {
    float f = 0.0F;
    if (paramFloat1 < 1.0F) {
      f = (float)(15.0F * paramFloat2 * Math.cos(paramFloat1 * 3.141592653589793D) - 15.0F * paramFloat2);
    }
    do
    {
      return f;
      if (paramFloat1 < 2.0F) {
        return (float)(30.0F * paramFloat2 * Math.sin((paramFloat1 - 1.5F) * 3.141592653589793D));
      }
      if (paramFloat1 < 3.33F) {
        return (float)(53.25F * paramFloat2 * Math.cos(1.181049937520192D * (paramFloat1 - 2.0F)) - 23.25F * paramFloat2);
      }
      if (paramFloat1 < 4.1F) {
        return (float)(Math.cos(2.039995280135998D * (paramFloat1 - 4.1F)) * 46.5D / 2.0D * paramFloat2 - 23.25F * paramFloat2);
      }
    } while (paramFloat1 >= 5.0F);
    return (float)(Math.cos(6.981316268210427D * (paramFloat1 - 4.55F)) * 52.0D / 2.0D / 2.0D * paramFloat2 + 13.0F * paramFloat2);
  }
  
  public static Drawable a(Context paramContext, String paramString)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("SplashBitmapUtils", 2, String.format("loadDrawableByKey key=%s", new Object[] { paramString }));
    }
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = (String)jdField_a_of_type_JavaUtilMap.get(paramString);
      i = ((Integer)b.get(paramString)).intValue();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label104;
      }
    }
    label104:
    for (paramString = String.format("%s/%s%s", new Object[] { jdField_a_of_type_JavaLangString, localObject, ".png" });; paramString = null)
    {
      localObject = a(paramContext, paramString, i);
      return localObject;
    }
  }
  
  /* Error */
  public static Drawable a(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +29 -> 38
    //   12: ldc 153
    //   14: iconst_2
    //   15: ldc 194
    //   17: iconst_2
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: aload_1
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: iload_2
    //   28: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: aastore
    //   32: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_1
    //   39: invokestatic 171	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifne +731 -> 773
    //   45: new 196	android/graphics/BitmapFactory$Options
    //   48: dup
    //   49: invokespecial 197	android/graphics/BitmapFactory$Options:<init>	()V
    //   52: astore 11
    //   54: getstatic 199	com/tencent/mobileqq/armap/wealthgod/SplashBitmapUtils:jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapDPC	Lcom/tencent/mobileqq/armap/wealthgod/ARMapDPC;
    //   57: ifnull +280 -> 337
    //   60: getstatic 199	com/tencent/mobileqq/armap/wealthgod/SplashBitmapUtils:jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapDPC	Lcom/tencent/mobileqq/armap/wealthgod/ARMapDPC;
    //   63: getfield 204	com/tencent/mobileqq/armap/wealthgod/ARMapDPC:a	Z
    //   66: ifeq +258 -> 324
    //   69: iconst_2
    //   70: istore_3
    //   71: aload 11
    //   73: iload_3
    //   74: putfield 208	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   77: getstatic 199	com/tencent/mobileqq/armap/wealthgod/SplashBitmapUtils:jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapDPC	Lcom/tencent/mobileqq/armap/wealthgod/ARMapDPC;
    //   80: getfield 210	com/tencent/mobileqq/armap/wealthgod/ARMapDPC:b	Z
    //   83: ifeq +246 -> 329
    //   86: getstatic 216	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   89: astore 4
    //   91: aload 11
    //   93: aload 4
    //   95: putfield 219	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   98: aload_0
    //   99: invokevirtual 225	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   102: invokevirtual 231	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   105: getfield 237	android/util/DisplayMetrics:density	F
    //   108: fconst_2
    //   109: fcmpg
    //   110: ifge +9 -> 119
    //   113: aload 11
    //   115: iconst_2
    //   116: putfield 208	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   119: getstatic 243	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   122: ifnull +676 -> 798
    //   125: getstatic 243	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   128: aload_1
    //   129: invokevirtual 246	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   132: checkcast 248	android/graphics/Bitmap
    //   135: astore 4
    //   137: aload 4
    //   139: ifnull +11 -> 150
    //   142: aload 4
    //   144: invokevirtual 251	android/graphics/Bitmap:isRecycled	()Z
    //   147: ifeq +207 -> 354
    //   150: new 253	java/io/BufferedInputStream
    //   153: dup
    //   154: new 255	java/io/FileInputStream
    //   157: dup
    //   158: aload_1
    //   159: invokespecial 258	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   162: invokespecial 261	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   165: astore 4
    //   167: aload 4
    //   169: astore 5
    //   171: aload 4
    //   173: astore 6
    //   175: aload 4
    //   177: astore 7
    //   179: aload 4
    //   181: aconst_null
    //   182: aload 11
    //   184: invokestatic 267	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   187: astore 8
    //   189: aload 8
    //   191: ifnull +604 -> 795
    //   194: aload 4
    //   196: astore 5
    //   198: aload 4
    //   200: astore 6
    //   202: aload 4
    //   204: astore 7
    //   206: getstatic 243	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   209: ifnull +586 -> 795
    //   212: aload 4
    //   214: astore 5
    //   216: aload 4
    //   218: astore 6
    //   220: aload 4
    //   222: astore 7
    //   224: getstatic 243	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   227: aload_1
    //   228: aload 8
    //   230: invokevirtual 268	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   233: pop
    //   234: aload 10
    //   236: astore 5
    //   238: aload 8
    //   240: ifnull +30 -> 270
    //   243: aload 4
    //   245: astore 5
    //   247: aload 4
    //   249: astore 6
    //   251: aload 4
    //   253: astore 7
    //   255: new 270	android/graphics/drawable/BitmapDrawable
    //   258: dup
    //   259: aload 8
    //   261: invokespecial 273	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   264: astore 8
    //   266: aload 8
    //   268: astore 5
    //   270: aload 4
    //   272: ifnull +516 -> 788
    //   275: aload 4
    //   277: invokevirtual 278	java/io/InputStream:close	()V
    //   280: aload 5
    //   282: astore 4
    //   284: aload 4
    //   286: astore 5
    //   288: aload 4
    //   290: ifnonnull +31 -> 321
    //   293: aload 4
    //   295: astore 5
    //   297: aload_0
    //   298: ifnull +23 -> 321
    //   301: aload 4
    //   303: astore 5
    //   305: iload_2
    //   306: ifle +15 -> 321
    //   309: aload_0
    //   310: invokevirtual 225	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   313: astore_0
    //   314: aload_0
    //   315: iload_2
    //   316: invokevirtual 282	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   319: astore 5
    //   321: aload 5
    //   323: areturn
    //   324: iconst_1
    //   325: istore_3
    //   326: goto -255 -> 71
    //   329: getstatic 285	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   332: astore 4
    //   334: goto -243 -> 91
    //   337: aload 11
    //   339: iconst_1
    //   340: putfield 208	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   343: aload 11
    //   345: getstatic 285	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   348: putfield 219	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   351: goto -253 -> 98
    //   354: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +23 -> 380
    //   360: ldc 153
    //   362: iconst_2
    //   363: ldc_w 287
    //   366: iconst_1
    //   367: anewarray 4	java/lang/Object
    //   370: dup
    //   371: iconst_0
    //   372: aload_1
    //   373: aastore
    //   374: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   377: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: aload 4
    //   382: astore 8
    //   384: aconst_null
    //   385: astore 4
    //   387: goto -153 -> 234
    //   390: astore 4
    //   392: aload 5
    //   394: astore 4
    //   396: goto -112 -> 284
    //   399: astore 4
    //   401: aconst_null
    //   402: astore 5
    //   404: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq +30 -> 437
    //   410: ldc 153
    //   412: iconst_2
    //   413: ldc_w 289
    //   416: iconst_2
    //   417: anewarray 4	java/lang/Object
    //   420: dup
    //   421: iconst_0
    //   422: aload_1
    //   423: aastore
    //   424: dup
    //   425: iconst_1
    //   426: iload_2
    //   427: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   430: aastore
    //   431: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   434: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload 11
    //   439: getfield 219	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   442: getstatic 216	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   445: if_acmpeq +18 -> 463
    //   448: aload 11
    //   450: getfield 208	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   453: istore_3
    //   454: aload 9
    //   456: astore 4
    //   458: iload_3
    //   459: iconst_1
    //   460: if_icmpne +59 -> 519
    //   463: aload 11
    //   465: iconst_2
    //   466: putfield 208	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   469: aload 11
    //   471: getstatic 285	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   474: putfield 219	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   477: aload 5
    //   479: aconst_null
    //   480: aload 11
    //   482: invokestatic 267	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   485: astore 4
    //   487: aload 4
    //   489: ifnull +293 -> 782
    //   492: getstatic 243	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   495: ifnull +13 -> 508
    //   498: getstatic 243	com/tencent/common/app/BaseApplicationImpl:sImageCache	Landroid/support/v4/util/MQLruCache;
    //   501: aload_1
    //   502: aload 4
    //   504: invokevirtual 268	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   507: pop
    //   508: new 270	android/graphics/drawable/BitmapDrawable
    //   511: dup
    //   512: aload 4
    //   514: invokespecial 273	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   517: astore 4
    //   519: aload 5
    //   521: ifnull +258 -> 779
    //   524: aload 5
    //   526: invokevirtual 278	java/io/InputStream:close	()V
    //   529: goto -245 -> 284
    //   532: astore 4
    //   534: ldc 153
    //   536: iconst_1
    //   537: ldc_w 294
    //   540: iconst_2
    //   541: anewarray 4	java/lang/Object
    //   544: dup
    //   545: iconst_0
    //   546: aload_1
    //   547: aastore
    //   548: dup
    //   549: iconst_1
    //   550: iload_2
    //   551: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   554: aastore
    //   555: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   558: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: aload 9
    //   563: astore 4
    //   565: goto -46 -> 519
    //   568: astore_0
    //   569: aload 5
    //   571: ifnull +8 -> 579
    //   574: aload 5
    //   576: invokevirtual 278	java/io/InputStream:close	()V
    //   579: aload_0
    //   580: athrow
    //   581: astore 4
    //   583: ldc 153
    //   585: iconst_1
    //   586: ldc_w 296
    //   589: iconst_2
    //   590: anewarray 4	java/lang/Object
    //   593: dup
    //   594: iconst_0
    //   595: aload_1
    //   596: aastore
    //   597: dup
    //   598: iconst_1
    //   599: iload_2
    //   600: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   603: aastore
    //   604: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   607: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: aload 9
    //   612: astore 4
    //   614: goto -95 -> 519
    //   617: astore 5
    //   619: goto -335 -> 284
    //   622: astore 4
    //   624: aconst_null
    //   625: astore 6
    //   627: aload 6
    //   629: astore 5
    //   631: ldc 153
    //   633: iconst_1
    //   634: ldc_w 298
    //   637: iconst_2
    //   638: anewarray 4	java/lang/Object
    //   641: dup
    //   642: iconst_0
    //   643: aload_1
    //   644: aastore
    //   645: dup
    //   646: iconst_1
    //   647: iload_2
    //   648: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   651: aastore
    //   652: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   655: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: aload 6
    //   660: ifnull +113 -> 773
    //   663: aload 6
    //   665: invokevirtual 278	java/io/InputStream:close	()V
    //   668: aconst_null
    //   669: astore 4
    //   671: goto -387 -> 284
    //   674: astore 4
    //   676: aconst_null
    //   677: astore 4
    //   679: goto -395 -> 284
    //   682: astore_0
    //   683: ldc 153
    //   685: iconst_1
    //   686: ldc_w 300
    //   689: iconst_2
    //   690: anewarray 4	java/lang/Object
    //   693: dup
    //   694: iconst_0
    //   695: aload_1
    //   696: aastore
    //   697: dup
    //   698: iconst_1
    //   699: iload_2
    //   700: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   703: aastore
    //   704: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   707: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: aload 4
    //   712: areturn
    //   713: astore_0
    //   714: ldc 153
    //   716: iconst_1
    //   717: ldc_w 302
    //   720: iconst_2
    //   721: anewarray 4	java/lang/Object
    //   724: dup
    //   725: iconst_0
    //   726: aload_1
    //   727: aastore
    //   728: dup
    //   729: iconst_1
    //   730: iload_2
    //   731: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   734: aastore
    //   735: invokestatic 161	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   738: invokestatic 292	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   741: aload 4
    //   743: areturn
    //   744: astore_1
    //   745: goto -166 -> 579
    //   748: astore_0
    //   749: aconst_null
    //   750: astore 5
    //   752: goto -183 -> 569
    //   755: astore_0
    //   756: goto -187 -> 569
    //   759: astore 4
    //   761: goto -134 -> 627
    //   764: astore 4
    //   766: aload 7
    //   768: astore 5
    //   770: goto -366 -> 404
    //   773: aconst_null
    //   774: astore 4
    //   776: goto -492 -> 284
    //   779: goto -495 -> 284
    //   782: aconst_null
    //   783: astore 4
    //   785: goto -266 -> 519
    //   788: aload 5
    //   790: astore 4
    //   792: goto -508 -> 284
    //   795: goto -561 -> 234
    //   798: aconst_null
    //   799: astore 4
    //   801: goto -664 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	804	0	paramContext	Context
    //   0	804	1	paramString	String
    //   0	804	2	paramInt	int
    //   70	391	3	i	int
    //   89	297	4	localObject1	Object
    //   390	1	4	localException1	Exception
    //   394	1	4	localObject2	Object
    //   399	1	4	localOutOfMemoryError1	OutOfMemoryError
    //   456	62	4	localObject3	Object
    //   532	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   563	1	4	localObject4	Object
    //   581	1	4	localException2	Exception
    //   612	1	4	localObject5	Object
    //   622	1	4	localException3	Exception
    //   669	1	4	localObject6	Object
    //   674	1	4	localException4	Exception
    //   677	65	4	localDrawable	Drawable
    //   759	1	4	localException5	Exception
    //   764	1	4	localOutOfMemoryError3	OutOfMemoryError
    //   774	26	4	localObject7	Object
    //   169	406	5	localObject8	Object
    //   617	1	5	localException6	Exception
    //   629	160	5	localObject9	Object
    //   173	491	6	localObject10	Object
    //   177	590	7	localObject11	Object
    //   187	196	8	localObject12	Object
    //   1	610	9	localObject13	Object
    //   4	231	10	localObject14	Object
    //   52	429	11	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   275	280	390	java/lang/Exception
    //   119	137	399	java/lang/OutOfMemoryError
    //   142	150	399	java/lang/OutOfMemoryError
    //   150	167	399	java/lang/OutOfMemoryError
    //   354	380	399	java/lang/OutOfMemoryError
    //   463	487	532	java/lang/OutOfMemoryError
    //   492	508	532	java/lang/OutOfMemoryError
    //   508	519	532	java/lang/OutOfMemoryError
    //   404	437	568	finally
    //   437	454	568	finally
    //   463	487	568	finally
    //   492	508	568	finally
    //   508	519	568	finally
    //   534	561	568	finally
    //   583	610	568	finally
    //   463	487	581	java/lang/Exception
    //   492	508	581	java/lang/Exception
    //   508	519	581	java/lang/Exception
    //   524	529	617	java/lang/Exception
    //   119	137	622	java/lang/Exception
    //   142	150	622	java/lang/Exception
    //   150	167	622	java/lang/Exception
    //   354	380	622	java/lang/Exception
    //   663	668	674	java/lang/Exception
    //   314	321	682	java/lang/OutOfMemoryError
    //   314	321	713	java/lang/Exception
    //   574	579	744	java/lang/Exception
    //   119	137	748	finally
    //   142	150	748	finally
    //   150	167	748	finally
    //   354	380	748	finally
    //   179	189	755	finally
    //   206	212	755	finally
    //   224	234	755	finally
    //   255	266	755	finally
    //   631	658	755	finally
    //   179	189	759	java/lang/Exception
    //   206	212	759	java/lang/Exception
    //   224	234	759	java/lang/Exception
    //   255	266	759	java/lang/Exception
    //   179	189	764	java/lang/OutOfMemoryError
    //   206	212	764	java/lang/OutOfMemoryError
    //   224	234	764	java/lang/OutOfMemoryError
    //   255	266	764	java/lang/OutOfMemoryError
  }
  
  public static ARMapDPC a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapDPC == null) {
      jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapDPC = ARMapDPC.a();
    }
    return jdField_a_of_type_ComTencentMobileqqArmapWealthgodARMapDPC;
  }
  
  public static void a(Context paramContext, String paramString, ImageView paramImageView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashBitmapUtils", 2, String.format("loadDrawableByKeyAsync key=%s view=%s", new Object[] { paramString, paramImageView }));
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (paramImageView == null)) {
      return;
    }
    for (;;)
    {
      Object localObject1;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject1 = (WeakReference)c.get(paramString);
        if (localObject1 == null) {
          break label367;
        }
        Drawable localDrawable = (Drawable)((WeakReference)localObject1).get();
        if (localDrawable != null)
        {
          localObject1 = localDrawable;
          if (QLog.isColorLevel())
          {
            QLog.d("SplashBitmapUtils", 2, String.format("loadDrawableByKeyAsync hit the cache. key=%s", new Object[] { paramString }));
            localObject1 = localDrawable;
          }
          if (localObject1 == null) {
            break label218;
          }
          if ((!"KEY_SPLASH_BG_WEALTH_GOD_SLEEP".equals(paramString)) && (!"KEY_SPLASH_BG_WEALTH_GOD_WORK".equals(paramString)) && (!"KEY_SPLASH_BG_WEALTH_GOD_BAOXIANG".equals(paramString))) {
            break label209;
          }
          paramImageView.setImageDrawable((Drawable)localObject1);
          return;
        }
      }
      c.remove(paramString);
      if (QLog.isColorLevel())
      {
        QLog.d("SplashBitmapUtils", 2, String.format("loadDrawableByKeyAsync cache is release, remove it. key=%s", new Object[] { paramString }));
        break label367;
        label209:
        paramImageView.setBackgroundDrawable((Drawable)localObject1);
        continue;
        label218:
        int i = ((Integer)b.get(paramString)).intValue();
        if (i > 0) {
          localObject1 = paramContext.getResources();
        }
        for (;;)
        {
          try
          {
            localObject1 = ((Resources)localObject1).getDrawable(i);
            if (localObject1 != null)
            {
              if ((!"KEY_SPLASH_BG_WEALTH_GOD_SLEEP".equals(paramString)) && (!"KEY_SPLASH_BG_WEALTH_GOD_WORK".equals(paramString)) && (!"KEY_SPLASH_BG_WEALTH_GOD_BAOXIANG".equals(paramString))) {
                continue;
              }
              paramImageView.setImageDrawable((Drawable)localObject1);
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            QLog.e("SplashBitmapUtils", 1, String.format("loadDrawableByKeyAsync from res OutOfMemoryError! key=%s", new Object[] { paramString }));
            continue;
          }
          catch (Exception localException)
          {
            QLog.e("SplashBitmapUtils", 1, String.format("loadDrawableByKeyAsync from res Exception! key=%s", new Object[] { paramString }));
            continue;
          }
          ThreadManager.postImmediately(new abiy(paramString, paramContext, paramImageView), null, false);
          break;
          paramImageView.setBackgroundDrawable((Drawable)localObject1);
        }
      }
      label367:
      Object localObject2 = null;
    }
  }
  
  public static void a(Context paramContext, String paramString, ImageView paramImageView, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashBitmapUtils", 2, String.format("loadDrawableByKey key=%s view=%s async=%s", new Object[] { paramString, paramImageView, Boolean.valueOf(paramBoolean) }));
    }
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)) || (paramImageView == null)) {
      return;
    }
    if (paramBoolean)
    {
      a(paramContext, paramString, paramImageView);
      return;
    }
    paramContext = a(paramContext, paramString);
    if (("KEY_SPLASH_BG_WEALTH_GOD_SLEEP".equals(paramString)) || ("KEY_SPLASH_BG_WEALTH_GOD_WORK".equals(paramString)) || ("KEY_SPLASH_BG_WEALTH_GOD_BAOXIANG".equals(paramString)))
    {
      paramImageView.setImageDrawable(paramContext);
      return;
    }
    paramImageView.setBackgroundDrawable(paramContext);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashBitmapUtils", 2, "initResDirInMainThread");
    }
    long l = System.currentTimeMillis();
    paramQQAppInterface = (ARMapConfigManager)paramQQAppInterface.getManager(189);
    if (paramQQAppInterface != null) {}
    try
    {
      a(paramQQAppInterface.a());
      a();
      if (QLog.isColorLevel()) {
        QLog.d("SplashBitmapUtils", 2, String.format("initResDirInMainThread time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("SplashBitmapUtils", 1, "initResDirInMainThread fail.", paramQQAppInterface);
      }
    }
  }
  
  public static void a(ArMapInterface paramArMapInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashBitmapUtils", 2, "initResDirInToolThread");
    }
    long l = System.currentTimeMillis();
    try
    {
      a(((ARMapManager)paramArMapInterface.getManager(209)).c());
      a();
      if (QLog.isColorLevel()) {
        QLog.d("SplashBitmapUtils", 2, String.format("initResDirInToolThread time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
      return;
    }
    catch (Exception paramArMapInterface)
    {
      for (;;)
      {
        QLog.e("SplashBitmapUtils", 1, "initResDirInToolThread fail.", paramArMapInterface);
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SplashBitmapUtils", 2, String.format("setResDir resDir=%s", new Object[] { paramString }));
    }
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static float b(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < 2.0F) {}
    do
    {
      return 0.0F;
      if (paramFloat1 < 3.33F) {
        return (float)(51.5F * paramFloat2 * Math.pow(paramFloat1 - 2.0F, 2.0D) / 1.768900036811829D);
      }
      if (paramFloat1 < 3.83F) {
        return (float)(-20.25F * paramFloat2 / 0.25F * Math.pow(paramFloat1 - 3.83F, 2.0D) + 71.75F * paramFloat2);
      }
      if (paramFloat1 < 4.233F) {
        return 71.75F * paramFloat2;
      }
    } while (paramFloat1 >= 5.0F);
    return (float)((Math.cos(4.095947641590846D * (paramFloat1 - 4.233F)) + 1.0D) * (71.75F * paramFloat2 / 2.0F));
  }
  
  public static float c(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 < 2.0F) {}
    do
    {
      return 1.0F;
      if (paramFloat1 <= 4.0F) {
        return 1.0F + (paramFloat1 - 2.0F) * 0.25F / 2.0F;
      }
    } while (paramFloat1 > 5.0F);
    return 1.0F + (5.0F - paramFloat1) * 0.25F;
  }
  
  public static float d(float paramFloat1, float paramFloat2)
  {
    paramFloat2 = 0.0F;
    if (paramFloat1 < 1.0F) {
      paramFloat2 = (float)(Math.sin(paramFloat1 * 3.141592653589793D / 2.0D - 1.570796326794897D) + 1.0D) * 8.0F;
    }
    do
    {
      return paramFloat2;
      if (paramFloat1 < 5.0F) {
        return (float)Math.cos((paramFloat1 - 1.0F) * 3.141592653589793D) * 8.0F;
      }
    } while (paramFloat1 >= 6.0F);
    return (float)Math.cos((paramFloat1 - 5.0F) * 3.141592653589793D / 2.0D) * 8.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.wealthgod.SplashBitmapUtils
 * JD-Core Version:    0.7.0.1
 */
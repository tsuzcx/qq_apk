package com.tencent.mobileqq.activity.springfestival.entry;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.activity.springfestival.entry.model.ZipRes;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.olympic.OlympicDPC;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs;
import com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PreloadResHandler
  implements IPreloadRes
{
  volatile OlympicDPC jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC;
  List<WeakReference<IPreloadRes.OnDownloadCallback>> jdField_a_of_type_JavaUtilList = new ArrayList();
  CopyOnWriteArrayList<ZipRes> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  
  public PreloadResHandler()
  {
    long l = SystemClock.uptimeMillis();
    ThreadManager.getSubThreadHandler().postAtTime(new PreloadResHandler.1(this), this, l + 1000L);
  }
  
  private static int a(String paramString)
  {
    int j = -1;
    int i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!"hb_pendant_icon".equals(paramString)) {
        break label25;
      }
      i = 2130845060;
    }
    label25:
    do
    {
      return i;
      if ("hb_busi_icon".equals(paramString)) {
        return 2130845404;
      }
      if ("qq_hongbao_formal_bg".equals(paramString)) {
        return 2130845416;
      }
      if ("qq_hongbao_cloud_ing_left".equals(paramString)) {
        return 2130845410;
      }
      if ("qq_hongbao_cloud_ing_right".equals(paramString)) {
        return 2130845411;
      }
      if ("qq_hongbao_progress_name".equals(paramString)) {
        return 2130845542;
      }
      if ("qq_hongbao_fudai_business_logo".equals(paramString)) {
        return 2130845531;
      }
      if ("default_miniapp_desktop_bg".equals(paramString)) {
        return 2130840464;
      }
      if ("default_share_bg_fullscreen".equals(paramString)) {
        return 2130845547;
      }
      i = j;
    } while (!"default_share_bg_window".equals(paramString));
    return 2130845545;
  }
  
  private static Bitmap a(String paramString, boolean paramBoolean, OlympicDPC paramOlympicDPC)
  {
    if (QLog.isColorLevel()) {
      QLog.d("shua2021_PreloadResHandler", 2, String.format("getDefaultIconBitmap start [%s]", new Object[] { paramString }));
    }
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        Bitmap localBitmap = CommonImageCacheHelper.a("red_packet_" + paramString);
        localObject = localBitmap;
        if (localBitmap == null)
        {
          int i = a(paramString);
          if (i < 0) {
            return null;
          }
          localObject = a("", i, paramOlympicDPC, 2);
          paramOlympicDPC = localBitmap;
          if (localObject != null) {
            paramOlympicDPC = (Bitmap)((Pair)localObject).second;
          }
          localObject = paramOlympicDPC;
          if (paramOlympicDPC != null)
          {
            localObject = paramOlympicDPC;
            if (paramBoolean)
            {
              CommonImageCacheHelper.a("red_packet_" + paramString, paramOlympicDPC);
              return paramOlympicDPC;
            }
          }
        }
      }
      catch (OutOfMemoryError paramOlympicDPC)
      {
        SpringHbMonitorReporter.a(106, paramOlympicDPC, new String[] { paramString });
        if (QLog.isColorLevel()) {
          QLog.e("shua2021_PreloadResHandler", 2, "", paramOlympicDPC);
        }
        return null;
      }
      catch (Exception paramString)
      {
        SpringHbMonitorReporter.a(107, paramString, new String[0]);
        if (QLog.isColorLevel()) {
          QLog.e("shua2021_PreloadResHandler", 2, "", paramString);
        }
      }
    }
    return null;
  }
  
  /* Error */
  private static Pair<Integer, Bitmap> a(String paramString, int paramInt1, OlympicDPC paramOlympicDPC, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: iconst_1
    //   4: istore 5
    //   6: aload_0
    //   7: invokestatic 59	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +9 -> 19
    //   13: iload_1
    //   14: ifge +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: new 169	android/graphics/BitmapFactory$Options
    //   22: dup
    //   23: invokespecial 170	android/graphics/BitmapFactory$Options:<init>	()V
    //   26: astore 10
    //   28: aload_2
    //   29: ifnull +457 -> 486
    //   32: aload 10
    //   34: iconst_1
    //   35: putfield 174	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   38: aload 10
    //   40: iconst_1
    //   41: putfield 177	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   44: aload_2
    //   45: getfield 181	com/tencent/mobileqq/olympic/OlympicDPC:d	Z
    //   48: ifeq +181 -> 229
    //   51: aload 10
    //   53: getstatic 187	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   56: putfield 190	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   59: aload_2
    //   60: getfield 192	com/tencent/mobileqq/olympic/OlympicDPC:b	Z
    //   63: ifeq +344 -> 407
    //   66: aload 10
    //   68: iconst_2
    //   69: putfield 196	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   72: iload_3
    //   73: iconst_1
    //   74: if_icmpne +447 -> 521
    //   77: aload_0
    //   78: aload 10
    //   80: invokestatic 202	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   83: astore 9
    //   85: aconst_null
    //   86: astore 8
    //   88: iconst_0
    //   89: istore_3
    //   90: iconst_0
    //   91: istore 4
    //   93: aload 9
    //   95: astore_2
    //   96: aload 8
    //   98: ifnull +560 -> 658
    //   101: aload 8
    //   103: getfield 205	android/util/Pair:first	Ljava/lang/Object;
    //   106: checkcast 207	java/lang/Integer
    //   109: invokevirtual 211	java/lang/Integer:intValue	()I
    //   112: ifne +531 -> 643
    //   115: iload 5
    //   117: istore_1
    //   118: aload_2
    //   119: ifnonnull +47 -> 166
    //   122: iload 4
    //   124: ifne +42 -> 166
    //   127: iload_3
    //   128: ifne +38 -> 166
    //   131: new 213	java/io/File
    //   134: dup
    //   135: aload_0
    //   136: invokespecial 216	java/io/File:<init>	(Ljava/lang/String;)V
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 219	java/io/File:exists	()Z
    //   144: ifeq +8 -> 152
    //   147: aload_0
    //   148: invokevirtual 222	java/io/File:delete	()Z
    //   151: pop
    //   152: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +11 -> 166
    //   158: ldc 112
    //   160: iconst_2
    //   161: ldc 224
    //   163: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: new 149	android/util/Pair
    //   169: dup
    //   170: iload_1
    //   171: invokestatic 228	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   174: aload_2
    //   175: invokespecial 231	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   178: astore_0
    //   179: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +45 -> 227
    //   185: aload_2
    //   186: ifnonnull +491 -> 677
    //   189: lconst_0
    //   190: lstore 6
    //   192: ldc 112
    //   194: iconst_2
    //   195: new 124	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   202: ldc 233
    //   204: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: lload 6
    //   209: invokevirtual 236	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   212: ldc 238
    //   214: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: iload_1
    //   218: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   221: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   227: aload_0
    //   228: areturn
    //   229: aload 10
    //   231: getstatic 244	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   234: putfield 190	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   237: aload 10
    //   239: iconst_1
    //   240: putfield 247	android/graphics/BitmapFactory$Options:inDither	Z
    //   243: goto -184 -> 59
    //   246: astore 9
    //   248: aconst_null
    //   249: astore 8
    //   251: bipush 108
    //   253: aload 9
    //   255: iconst_3
    //   256: anewarray 63	java/lang/String
    //   259: dup
    //   260: iconst_0
    //   261: new 124	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   268: iload_3
    //   269: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: ldc 144
    //   274: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: aload_0
    //   284: aastore
    //   285: dup
    //   286: iconst_2
    //   287: new 124	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   294: iload_1
    //   295: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: ldc 144
    //   300: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aastore
    //   307: invokestatic 163	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   310: aload 8
    //   312: astore 9
    //   314: aload 11
    //   316: astore 10
    //   318: aload_2
    //   319: ifnull +42 -> 361
    //   322: aload 8
    //   324: astore 9
    //   326: aload 11
    //   328: astore 10
    //   330: aload_2
    //   331: getfield 192	com/tencent/mobileqq/olympic/OlympicDPC:b	Z
    //   334: ifne +27 -> 361
    //   337: aload_2
    //   338: iconst_1
    //   339: putfield 192	com/tencent/mobileqq/olympic/OlympicDPC:b	Z
    //   342: aload_0
    //   343: iload_1
    //   344: aload_2
    //   345: iload_3
    //   346: invokestatic 147	com/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler:a	(Ljava/lang/String;ILcom/tencent/mobileqq/olympic/OlympicDPC;I)Landroid/util/Pair;
    //   349: astore 10
    //   351: aload 10
    //   353: getfield 153	android/util/Pair:second	Ljava/lang/Object;
    //   356: checkcast 155	android/graphics/Bitmap
    //   359: astore 9
    //   361: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +28 -> 392
    //   367: ldc 112
    //   369: iconst_2
    //   370: new 124	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   377: ldc 249
    //   379: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_0
    //   383: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: aload 10
    //   394: astore 8
    //   396: iconst_0
    //   397: istore_3
    //   398: iconst_1
    //   399: istore 4
    //   401: aload 9
    //   403: astore_2
    //   404: goto -308 -> 96
    //   407: aload 10
    //   409: iconst_1
    //   410: putfield 196	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   413: goto -341 -> 72
    //   416: astore 8
    //   418: aconst_null
    //   419: astore_2
    //   420: bipush 109
    //   422: aload 8
    //   424: iconst_0
    //   425: anewarray 63	java/lang/String
    //   428: invokestatic 163	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   431: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +41 -> 475
    //   437: ldc 112
    //   439: iconst_2
    //   440: new 124	java/lang/StringBuilder
    //   443: dup
    //   444: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   447: ldc 251
    //   449: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload 8
    //   454: invokevirtual 252	java/lang/Exception:toString	()Ljava/lang/String;
    //   457: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: ldc 254
    //   462: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_0
    //   466: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: iconst_1
    //   476: istore_3
    //   477: iconst_0
    //   478: istore 4
    //   480: aconst_null
    //   481: astore 8
    //   483: goto -387 -> 96
    //   486: aload 10
    //   488: iconst_1
    //   489: putfield 174	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   492: aload 10
    //   494: iconst_1
    //   495: putfield 177	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   498: aload 10
    //   500: iconst_1
    //   501: putfield 196	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   504: aload 10
    //   506: getstatic 244	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   509: putfield 190	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   512: aload 10
    //   514: iconst_1
    //   515: putfield 247	android/graphics/BitmapFactory$Options:inDither	Z
    //   518: goto -446 -> 72
    //   521: iload_3
    //   522: iconst_2
    //   523: if_icmpne +194 -> 717
    //   526: invokestatic 260	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   529: invokevirtual 264	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   532: iload_1
    //   533: aload 10
    //   535: invokestatic 268	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   538: astore 8
    //   540: aload 8
    //   542: astore 9
    //   544: aload 8
    //   546: ifnull -461 -> 85
    //   549: aload 8
    //   551: astore 9
    //   553: invokestatic 110	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   556: ifeq -471 -> 85
    //   559: ldc 112
    //   561: iconst_2
    //   562: new 124	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   569: ldc_w 270
    //   572: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload 8
    //   577: invokevirtual 273	android/graphics/Bitmap:getWidth	()I
    //   580: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   583: ldc_w 275
    //   586: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload 8
    //   591: invokevirtual 278	android/graphics/Bitmap:getHeight	()I
    //   594: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   597: ldc_w 280
    //   600: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload 10
    //   605: getfield 283	android/graphics/BitmapFactory$Options:inDensity	I
    //   608: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   611: ldc_w 285
    //   614: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload 10
    //   619: getfield 288	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   622: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   625: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   628: invokestatic 122	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   631: aload 8
    //   633: astore 9
    //   635: goto -550 -> 85
    //   638: astore 9
    //   640: goto -389 -> 251
    //   643: aload 8
    //   645: getfield 205	android/util/Pair:first	Ljava/lang/Object;
    //   648: checkcast 207	java/lang/Integer
    //   651: invokevirtual 211	java/lang/Integer:intValue	()I
    //   654: istore_1
    //   655: goto -537 -> 118
    //   658: iload 4
    //   660: ifeq +8 -> 668
    //   663: iconst_2
    //   664: istore_1
    //   665: goto -547 -> 118
    //   668: iload_3
    //   669: ifeq +43 -> 712
    //   672: iconst_3
    //   673: istore_1
    //   674: goto -556 -> 118
    //   677: aload_2
    //   678: invokevirtual 291	android/graphics/Bitmap:getRowBytes	()I
    //   681: aload_2
    //   682: invokevirtual 278	android/graphics/Bitmap:getHeight	()I
    //   685: imul
    //   686: sipush 1024
    //   689: idiv
    //   690: i2l
    //   691: lstore 6
    //   693: goto -501 -> 192
    //   696: astore_0
    //   697: goto -531 -> 166
    //   700: astore 9
    //   702: aload 8
    //   704: astore_2
    //   705: aload 9
    //   707: astore 8
    //   709: goto -289 -> 420
    //   712: iconst_0
    //   713: istore_1
    //   714: goto -596 -> 118
    //   717: aconst_null
    //   718: astore 9
    //   720: goto -635 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	723	0	paramString	String
    //   0	723	1	paramInt1	int
    //   0	723	2	paramOlympicDPC	OlympicDPC
    //   0	723	3	paramInt2	int
    //   91	568	4	i	int
    //   4	112	5	j	int
    //   190	502	6	l	long
    //   86	309	8	localObject1	Object
    //   416	37	8	localException1	Exception
    //   481	227	8	localObject2	Object
    //   83	11	9	localBitmap	Bitmap
    //   246	8	9	localOutOfMemoryError1	OutOfMemoryError
    //   312	322	9	localObject3	Object
    //   638	1	9	localOutOfMemoryError2	OutOfMemoryError
    //   700	6	9	localException2	Exception
    //   718	1	9	localObject4	Object
    //   26	592	10	localObject5	Object
    //   1	326	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   19	28	246	java/lang/OutOfMemoryError
    //   32	59	246	java/lang/OutOfMemoryError
    //   59	72	246	java/lang/OutOfMemoryError
    //   77	85	246	java/lang/OutOfMemoryError
    //   229	243	246	java/lang/OutOfMemoryError
    //   407	413	246	java/lang/OutOfMemoryError
    //   486	518	246	java/lang/OutOfMemoryError
    //   526	540	246	java/lang/OutOfMemoryError
    //   19	28	416	java/lang/Exception
    //   32	59	416	java/lang/Exception
    //   59	72	416	java/lang/Exception
    //   77	85	416	java/lang/Exception
    //   229	243	416	java/lang/Exception
    //   407	413	416	java/lang/Exception
    //   486	518	416	java/lang/Exception
    //   526	540	416	java/lang/Exception
    //   553	631	638	java/lang/OutOfMemoryError
    //   131	152	696	java/lang/Exception
    //   152	166	696	java/lang/Exception
    //   553	631	700	java/lang/Exception
  }
  
  private PreloadResHandler.ZipResRef a(String paramString)
  {
    label203:
    for (;;)
    {
      try
      {
        Object localObject1 = Uri.parse(paramString);
        Object localObject3 = ((Uri)localObject1).getScheme();
        Object localObject2 = ((Uri)localObject1).getHost();
        localObject1 = ((Uri)localObject1).getPath();
        if ((localObject1 == null) || (!((String)localObject1).startsWith("/"))) {
          break label203;
        }
        localObject1 = ((String)localObject1).substring(1);
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_PreloadResHandler", 2, String.format("getZipResRef scheme=%s host=%s path=%s url=%s", new Object[] { localObject3, localObject2, localObject1, paramString }));
        }
        if ((((String)localObject3).equalsIgnoreCase("ref")) && (!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          localObject3 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            paramString = (ZipRes)((Iterator)localObject3).next();
            if (!((String)localObject2).equalsIgnoreCase(paramString.id)) {
              continue;
            }
            localObject2 = new PreloadResHandler.ZipResRef(this, null);
            ((PreloadResHandler.ZipResRef)localObject2).jdField_a_of_type_JavaLangString = paramString.id;
            ((PreloadResHandler.ZipResRef)localObject2).c = paramString.url;
            ((PreloadResHandler.ZipResRef)localObject2).b = ((String)localObject1);
            return localObject2;
          }
        }
      }
      catch (Throwable paramString)
      {
        SpringHbMonitorReporter.a(103, paramString, new String[0]);
        QLog.d("shua2021_PreloadResHandler", 1, paramString.getMessage(), paramString);
      }
      return null;
    }
  }
  
  private void a()
  {
    int i;
    String str;
    if (this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC == null)
    {
      localOlympicDPC = new OlympicDPC();
      i = (int)(DeviceInfoUtil.a() / 1024L / 1024L);
      j = ViewUtils.a();
      str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.olympic_act_config.name());
      localOlympicDPC.jdField_a_of_type_JavaLangString = str;
    }
    for (;;)
    {
      try
      {
        if (str.length() <= 0) {
          continue;
        }
        arrayOfString = str.split("\\|");
        if (arrayOfString.length < 9) {
          continue;
        }
        if (i > Integer.valueOf(arrayOfString[0]).intValue()) {
          continue;
        }
        localOlympicDPC.b = true;
        if (Integer.valueOf(arrayOfString[3]).intValue() == 1) {
          localOlympicDPC.d = true;
        }
        bool = false;
      }
      catch (Exception localException)
      {
        String[] arrayOfString;
        SpringHbMonitorReporter.a(102, localException, new String[0]);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("shua2021_PreloadResHandler", 2, "loadDPCConfig Exception:" + localException.toString());
        boolean bool = true;
        continue;
        if (j > 480) {
          continue;
        }
        localOlympicDPC.b = true;
        continue;
      }
      localOlympicDPC.jdField_a_of_type_Boolean = bool;
      if (bool)
      {
        if (i > 512) {
          continue;
        }
        localOlympicDPC.b = true;
        localOlympicDPC.d = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("shua2021_PreloadResHandler", 2, "loadDPCConfig|featureValue:" + str + ",systemTotalMem:" + i + ",screenWidth:" + j + ",isUseDefault:" + bool + ",dpc:" + localOlympicDPC.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC = localOlympicDPC;
      return;
      if (j <= Integer.valueOf(arrayOfString[1]).intValue()) {
        localOlympicDPC.b = true;
      }
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() >= "ref".length())
      {
        bool1 = bool2;
        if ("ref".equalsIgnoreCase(paramString.substring(0, "ref".length()))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static Bitmap b(String paramString1, String paramString2, OlympicDPC paramOlympicDPC)
  {
    if (QLog.isColorLevel()) {
      QLog.d("shua2021_PreloadResHandler", 2, String.format("getBitmap start path=%s, defaultResName=%s", new Object[] { paramString1, paramString2 }));
    }
    Bitmap localBitmap;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString1)) {
          return a(paramString2, true, paramOlympicDPC);
        }
        str = "red_packet_" + paramString1;
        localBitmap = CommonImageCacheHelper.a(str);
        if (localBitmap == null) {
          continue;
        }
        localObject = localBitmap;
        try
        {
          if (!QLog.isColorLevel()) {
            break label277;
          }
          localObject = localBitmap;
          QLog.d("shua2021_PreloadResHandler", 2, "getBitmap, hit cache");
          return localBitmap;
        }
        catch (Exception paramString2)
        {
          paramString1 = (String)localObject;
        }
      }
      catch (Exception paramString2)
      {
        String str;
        Object localObject;
        paramString1 = null;
        continue;
        paramString1 = localBitmap;
        continue;
      }
      SpringHbMonitorReporter.a(105, paramString2, new String[0]);
      paramOlympicDPC = paramString1;
      if (QLog.isColorLevel())
      {
        QLog.d("shua2021_PreloadResHandler", 2, "", paramString2);
        paramOlympicDPC = paramString1;
      }
      return paramOlympicDPC;
      localObject = localBitmap;
      try
      {
        paramString1 = a(paramString1, -1, paramOlympicDPC, 1);
        if (paramString1 == null) {
          continue;
        }
        localObject = localBitmap;
        paramString1 = (Bitmap)paramString1.second;
        if (paramString1 != null)
        {
          localObject = paramString1;
          CommonImageCacheHelper.a(str, paramString1);
          return paramString1;
        }
      }
      catch (Throwable paramString1)
      {
        localObject = localBitmap;
        SpringHbMonitorReporter.a(104, paramString1, new String[0]);
        if (QLog.isColorLevel()) {
          QLog.e("shua2021_PreloadResHandler", 2, "getBitmap, exception=" + paramString1.getMessage(), paramString1);
        }
        paramString1 = null;
        continue;
        localObject = paramString1;
        paramString1 = a(paramString2, true, paramOlympicDPC);
        paramOlympicDPC = paramString1;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("shua2021_PreloadResHandler", 2, "getBitmap, using default bitmap");
            paramOlympicDPC = paramString1;
          }
        }
        catch (Exception paramString2) {}
      }
    }
    label277:
    return localBitmap;
  }
  
  @NotNull
  public static String c(String paramString)
  {
    Object localObject1 = PreloadStaticApi.a(paramString, 0);
    String str;
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).getRealMd5(paramString, (String)localObject1, 0);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        str = PreloadStaticApi.a((String)localObject1, paramString, 0);
        if (PreloadStaticApi.b(str))
        {
          localObject2 = localObject1;
          localObject1 = str;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getUnzipFolderPath foldPath=[%s] md5=[%s] zipUrl=[%s]", new Object[] { localObject1, localObject2, paramString }));
      }
      paramString = (String)localObject1;
      if (localObject1 == null) {
        paramString = "";
      }
      return paramString;
      str = "";
      localObject2 = localObject1;
      localObject1 = str;
      continue;
      localObject2 = "";
      localObject1 = "";
    }
  }
  
  @Nullable
  public Bitmap a(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = paramString1.trim())
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadBitmap start defaultResName=[%s] url=%s", new Object[] { paramString2, paramString1 }));
      }
      if (!TextUtils.isEmpty(paramString1)) {
        break;
      }
      return b("", paramString2, this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC);
    }
    Object localObject2;
    if (a(paramString1))
    {
      localObject2 = a(paramString1);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadBitmap find zipResRef=%s", new Object[] { localObject2 }));
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null) {
      return a(((PreloadResHandler.ZipResRef)localObject1).c, ((PreloadResHandler.ZipResRef)localObject1).b, paramString2);
    }
    localObject1 = PreloadStaticApi.a(paramString1);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists()))
    {
      localObject2 = new DownloadParam();
      ((DownloadParam)localObject2).filePos = 0;
      ((DownloadParam)localObject2).url = paramString1;
      WeakReference localWeakReference = new WeakReference(this);
      PreloadStaticApi.a().getResPath((DownloadParam)localObject2, new PreloadResHandler.3(this, paramString2, localWeakReference, paramString1));
    }
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadBitmap end defaultResName=[%s] hasFile=%b path=%s", new Object[] { paramString2, Boolean.valueOf(bool), localObject1 }));
      }
      if (bool) {}
      for (paramString1 = (String)localObject1;; paramString1 = "") {
        return b(paramString1, paramString2, this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC);
      }
    }
  }
  
  @Nullable
  public Bitmap a(String paramString1, String paramString2, String paramString3)
  {
    String str = null;
    if (paramString1 == null)
    {
      paramString1 = null;
      if (paramString2 != null) {
        break label83;
      }
    }
    label83:
    for (paramString2 = str;; paramString2 = paramString2.trim())
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadBitmapOfZip start fileName=[%s] defaultResName=[%s] zipUrl=%s", new Object[] { paramString2, paramString3, paramString1 }));
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
        break label91;
      }
      return b("", paramString3, this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC);
      paramString1 = paramString1.trim();
      break;
    }
    label91:
    Object localObject = c(paramString1);
    str = (String)localObject + File.separator + paramString2;
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!new File(str).exists()))
    {
      localObject = new DownloadParam();
      ((DownloadParam)localObject).filePos = 0;
      ((DownloadParam)localObject).url = paramString1;
      ((DownloadParam)localObject).isForceUnzip = true;
      PreloadStaticApi.a().getResPath((DownloadParam)localObject, new PreloadResHandler.6(this, paramString2, paramString3));
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0) {}
      for (paramString1 = str;; paramString1 = "") {
        return b(paramString1, paramString3, this.jdField_a_of_type_ComTencentMobileqqOlympicOlympicDPC);
      }
    }
  }
  
  @Nullable
  public String a(String paramString)
  {
    Object localObject = null;
    if (paramString == null)
    {
      paramString = null;
      if (!TextUtils.isEmpty(paramString)) {
        break label25;
      }
    }
    label25:
    String str;
    do
    {
      return localObject;
      paramString = paramString.trim();
      break;
      str = c(paramString);
      if (TextUtils.isEmpty(str))
      {
        localObject = new DownloadParam();
        ((DownloadParam)localObject).filePos = 0;
        ((DownloadParam)localObject).url = paramString;
        ((DownloadParam)localObject).isForceUnzip = true;
        PreloadStaticApi.a().getResPath((DownloadParam)localObject, new PreloadResHandler.4(this));
      }
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFolderPathOfZip end url=%s zipFolderPath=%s", new Object[] { paramString, str }));
    return str;
  }
  
  public void a(IPreloadRes.OnDownloadCallback paramOnDownloadCallback)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          i = this.jdField_a_of_type_JavaUtilList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() != paramOnDownloadCallback)) {
              break label116;
            }
            this.jdField_a_of_type_JavaUtilList.remove(i);
            break label116;
          }
        }
        if (paramOnDownloadCallback != null) {
          this.jdField_a_of_type_JavaUtilList.add(new WeakReference(paramOnDownloadCallback));
        }
        return;
      }
      label116:
      i -= 1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, Object paramObject)
  {
    QLog.i("shua2021_PreloadResHandler", 1, "notifyDownloadCallback suc=" + paramBoolean + ", url=" + paramString + ", result=" + paramObject);
    paramString = new PreloadResHandler.2(this, paramBoolean, paramString, paramObject);
    ThreadManager.getUIHandler().postAtTime(paramString, this, SystemClock.uptimeMillis());
  }
  
  public boolean a(List<ZipRes> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.addAll(paramList);
    }
    if (QLog.isColorLevel()) {
      QLog.i("shua2021_PreloadResHandler", 2, String.format("onGetZipResList resSize=%d cfgVer=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size()), Integer.valueOf(paramInt) }));
    }
    return true;
  }
  
  @Nullable
  public String b(String paramString)
  {
    String str2 = null;
    String str1 = null;
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.trim())
    {
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFilePath start url=%s", new Object[] { paramString }));
      }
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      localObject1 = str1;
      return localObject1;
    }
    Object localObject2;
    if (a(paramString))
    {
      localObject2 = a(paramString);
      localObject1 = localObject2;
      if (QLog.isColorLevel()) {
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFilePath find zipResRef=%s", new Object[] { localObject2 }));
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        str1 = a(((PreloadResHandler.ZipResRef)localObject1).c);
        paramString = str2;
        if (!TextUtils.isEmpty(str1))
        {
          localObject1 = str1 + File.separator + ((PreloadResHandler.ZipResRef)localObject1).b;
          paramString = str2;
          if (new File((String)localObject1).exists()) {
            paramString = (String)localObject1;
          }
        }
        localObject1 = paramString;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFilePath end [isZip] path=%s folder=%s", new Object[] { paramString, str1 }));
        return paramString;
      }
      str2 = PreloadStaticApi.a(paramString);
      if ((TextUtils.isEmpty(str2)) || (!new File(str2).exists()))
      {
        localObject1 = new DownloadParam();
        ((DownloadParam)localObject1).filePos = 0;
        ((DownloadParam)localObject1).url = paramString;
        localObject2 = new WeakReference(this);
        PreloadStaticApi.a().getResPath((DownloadParam)localObject1, new PreloadResHandler.5(this, paramString, (WeakReference)localObject2));
      }
      for (boolean bool = false;; bool = true)
      {
        if (QLog.isColorLevel()) {
          QLog.i("shua2021_PreloadResHandler", 2, String.format("getPreloadFilePath end hasFile=%b path=%s", new Object[] { Boolean.valueOf(bool), str2 }));
        }
        localObject1 = str1;
        if (!bool) {
          break;
        }
        return str2;
      }
    }
  }
  
  public void b(IPreloadRes.OnDownloadCallback paramOnDownloadCallback)
  {
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        if (this.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          i = this.jdField_a_of_type_JavaUtilList.size() - 1;
          if (i >= 0)
          {
            WeakReference localWeakReference = (WeakReference)this.jdField_a_of_type_JavaUtilList.get(i);
            if ((localWeakReference != null) && (localWeakReference.get() != null) && (localWeakReference.get() != paramOnDownloadCallback)) {
              break label94;
            }
            this.jdField_a_of_type_JavaUtilList.remove(i);
            break label94;
          }
        }
        return;
      }
      label94:
      i -= 1;
    }
  }
  
  public void onDestroy()
  {
    ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(this);
    ThreadManager.getUIHandler().removeCallbacksAndMessages(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler
 * JD-Core Version:    0.7.0.1
 */
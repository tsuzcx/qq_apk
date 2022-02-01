package com.tencent.av.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.so.ResMgr;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.automator.AutomatorHelper;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.GifSoLoader;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class AVSoUtils
{
  private static String jdField_a_of_type_JavaLangString;
  private static boolean jdField_a_of_type_Boolean = false;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "SDKCommon", "qav_gaudio_engine", "xplatform", "VideoCtrl", "qav_graphics", "TcHevcEnc", "c++_shared", "qav_media_engine", "TcHevcDec", "traeimp-qq" };
  private static String jdField_b_of_type_JavaLangString;
  private static boolean jdField_b_of_type_Boolean = false;
  private static String jdField_c_of_type_JavaLangString;
  private static boolean jdField_c_of_type_Boolean = false;
  private static String jdField_d_of_type_JavaLangString;
  private static boolean jdField_d_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
    jdField_b_of_type_JavaLangString = "";
    jdField_c_of_type_JavaLangString = "";
    jdField_d_of_type_JavaLangString = "";
  }
  
  public static LoadExtResult a(String paramString)
  {
    long l1 = System.currentTimeMillis();
    LoadExtResult localLoadExtResult = SoLoadManager.getInstance().loadSync(paramString);
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadAndDownloadSo. soName = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", result = ");
    localStringBuilder.append(localLoadExtResult);
    localStringBuilder.append(", time len = ");
    localStringBuilder.append(l2 - l1);
    localStringBuilder.append(", so path = ");
    if (localLoadExtResult != null) {
      paramString = localLoadExtResult.getSoLoadPath(paramString);
    } else {
      paramString = "null";
    }
    localStringBuilder.append(paramString);
    QLog.i("AVSoUtils", 1, localStringBuilder.toString());
    return localLoadExtResult;
  }
  
  public static String a()
  {
    return "lib/armeabi/";
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    if (!AutomatorHelper.jdField_b_of_type_Boolean) {
      return;
    }
    int i;
    if (VcSystemInfo.getCpuArchitecture() <= 2) {
      i = 1;
    } else {
      i = 0;
    }
    String str = b();
    if (i != 0)
    {
      localObject1 = new String[3];
      localObject1[0] = "libTcVpxDec-armeabi.so";
      localObject1[1] = "libTcVpxEnc-armeabi.so";
      localObject1[2] = "libtraeimp-armeabi.so";
    }
    else
    {
      localObject1 = new String[5];
      localObject1[0] = "libTcHevcDec.so";
      localObject1[1] = "libTcHevcDec2.so";
      localObject1[2] = "libTcHevcEnc.so";
      localObject1[3] = "libtraeopus-armeabi.so";
      localObject1[4] = "libtraeopus-armeabi-v7a.so";
    }
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).addAll(Arrays.asList((Object[])localObject1));
    ((ArrayList)localObject2).addAll(Arrays.asList(new String[] { "libSDKCommon.so", "libVideoCtrl.so", "libtraeimp-qq.so", "libqav_graphics.so", "libqav_gaudio_engine.so", "libqav_utils.so", "libqav_media_engine.so", "libhwcodec.so", "libTcVpxEnc.so", "libTcVpxDec.so" }));
    Object localObject1 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append((String)localObject2);
      a(localStringBuilder.toString());
    }
  }
  
  public static void a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("extractAVModulesFromAssets, seq:");
    ((StringBuilder)localObject).append(paramLong);
    QLog.i("AVSoUtils", 1, ((StringBuilder)localObject).toString());
    localObject = BaseApplication.getContext();
    b(paramLong, (Context)localObject, "SDKCommon", true);
    b(paramLong, (Context)localObject, "VideoCtrl", true);
    b(paramLong, (Context)localObject, "traeimp-qq", true);
    b(paramLong, (Context)localObject, "qav_graphics", true);
    b(paramLong, (Context)localObject, "qav_gaudio_engine", true);
    b(paramLong, (Context)localObject, "qav_utils", true);
    b(paramLong, (Context)localObject, "qav_media_engine", true);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          Object localObject = paramContext.getSharedPreferences("so_sp", 4);
          String str3 = d(paramString);
          paramContext = c();
          String str1 = d();
          String str2 = ((SharedPreferences)localObject).getString(str3, str1);
          if ((TextUtils.equals(paramContext, str2)) && (!a(paramContext))) {
            ((SharedPreferences)localObject).edit().putString(str3, str1).apply();
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("resetVersionForFailUpgrade, libName[");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("], old[");
          ((StringBuilder)localObject).append(str2);
          ((StringBuilder)localObject).append("], cur[");
          ((StringBuilder)localObject).append(paramContext);
          ((StringBuilder)localObject).append("], def[");
          ((StringBuilder)localObject).append(str1);
          ((StringBuilder)localObject).append("]");
          QLog.i("AVSoUtils", 1, ((StringBuilder)localObject).toString());
          return;
        }
      }
      finally {}
    }
  }
  
  private static void a(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    if (paramSharedPreferences == null) {
      return;
    }
    if (a(paramString1))
    {
      paramSharedPreferences.edit().putString(paramString2, d()).commit();
      return;
    }
    paramSharedPreferences.edit().putString(paramString2, paramString1).commit();
  }
  
  static void a(String paramString)
  {
    try
    {
      Object localObject = new File(paramString);
      boolean bool2 = ((File)localObject).exists();
      boolean bool1 = false;
      if (bool2) {
        bool1 = ((File)localObject).delete();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("delSoFromCache, soPath[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("], exist[");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append("], ret[");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append("]");
      QLog.w("AVSoUtils", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean a()
  {
    LoadExtResult localLoadExtResult = a("TcHevcDec");
    return (localLoadExtResult != null) && (localLoadExtResult.isSucc());
  }
  
  /* Error */
  private static boolean a(long paramLong, Context paramContext, File paramFile, String paramString1, String paramString2, SharedPreferences paramSharedPreferences, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 286	java/io/File:delete	()Z
    //   4: pop
    //   5: aload_3
    //   6: invokevirtual 283	java/io/File:exists	()Z
    //   9: ifne +1347 -> 1356
    //   12: iload 9
    //   14: ifeq +246 -> 260
    //   17: aload_2
    //   18: aload 4
    //   20: ldc_w 310
    //   23: aload 5
    //   25: invokestatic 312	com/tencent/av/utils/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   28: invokestatic 317	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   31: istore 11
    //   33: aload_3
    //   34: invokevirtual 283	java/io/File:exists	()Z
    //   37: ifeq +151 -> 188
    //   40: iload 11
    //   42: ifeq +65 -> 107
    //   45: aload_3
    //   46: invokevirtual 286	java/io/File:delete	()Z
    //   49: pop
    //   50: new 77	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   57: astore_2
    //   58: aload_2
    //   59: ldc_w 319
    //   62: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: iload 11
    //   69: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_2
    //   74: ldc_w 324
    //   77: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_2
    //   82: lload_0
    //   83: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_2
    //   88: ldc_w 270
    //   91: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: ldc 106
    //   97: iconst_1
    //   98: aload_2
    //   99: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 298	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: iconst_0
    //   106: ireturn
    //   107: aload 6
    //   109: aload 7
    //   111: aload 8
    //   113: invokestatic 326	com/tencent/av/utils/AVSoUtils:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V
    //   116: new 77	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   123: astore_2
    //   124: aload_2
    //   125: ldc_w 328
    //   128: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload_2
    //   133: aload 8
    //   135: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_2
    //   140: ldc_w 330
    //   143: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_2
    //   148: aload 7
    //   150: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_2
    //   155: ldc_w 324
    //   158: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_2
    //   163: lload_0
    //   164: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_2
    //   169: ldc_w 270
    //   172: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: ldc 106
    //   178: iconst_1
    //   179: aload_2
    //   180: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 298	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iconst_1
    //   187: ireturn
    //   188: new 77	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   195: astore_2
    //   196: aload_2
    //   197: ldc_w 332
    //   200: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_2
    //   205: iload 11
    //   207: invokevirtual 322	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload_2
    //   212: ldc_w 334
    //   215: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_2
    //   220: iconst_0
    //   221: invokevirtual 293	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload_2
    //   226: ldc_w 324
    //   229: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_2
    //   234: lload_0
    //   235: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_2
    //   240: ldc_w 270
    //   243: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: ldc 106
    //   249: iconst_1
    //   250: aload_2
    //   251: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 298	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: goto +1139 -> 1396
    //   260: aconst_null
    //   261: astore 20
    //   263: aconst_null
    //   264: astore 15
    //   266: aconst_null
    //   267: astore 16
    //   269: aconst_null
    //   270: astore 19
    //   272: aconst_null
    //   273: astore 17
    //   275: aconst_null
    //   276: astore 18
    //   278: new 278	java/io/File
    //   281: dup
    //   282: aload 4
    //   284: invokespecial 280	java/io/File:<init>	(Ljava/lang/String;)V
    //   287: astore 14
    //   289: aload 14
    //   291: invokevirtual 283	java/io/File:exists	()Z
    //   294: ifne +35 -> 329
    //   297: aload 14
    //   299: invokevirtual 337	java/io/File:mkdir	()Z
    //   302: istore 9
    //   304: iload 9
    //   306: ifeq +6 -> 312
    //   309: goto +20 -> 329
    //   312: iload 10
    //   314: istore 9
    //   316: aconst_null
    //   317: astore 5
    //   319: aload 5
    //   321: astore 14
    //   323: aload 15
    //   325: astore_2
    //   326: goto +720 -> 1046
    //   329: aload_2
    //   330: invokevirtual 341	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   333: astore 14
    //   335: new 77	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   342: astore 15
    //   344: aload 15
    //   346: invokestatic 343	com/tencent/av/utils/AVSoUtils:a	()Ljava/lang/String;
    //   349: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 15
    //   355: aload 5
    //   357: invokestatic 312	com/tencent/av/utils/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   360: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 14
    //   366: aload 15
    //   368: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokevirtual 349	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   374: astore 15
    //   376: aconst_null
    //   377: astore 14
    //   379: aload 15
    //   381: astore_2
    //   382: goto +172 -> 554
    //   385: aload_2
    //   386: invokevirtual 341	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   389: astore 14
    //   391: new 77	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   398: astore 15
    //   400: aload 15
    //   402: invokestatic 343	com/tencent/av/utils/AVSoUtils:a	()Ljava/lang/String;
    //   405: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload 15
    //   411: aload 5
    //   413: invokestatic 312	com/tencent/av/utils/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   416: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 15
    //   422: ldc_w 351
    //   425: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 14
    //   431: aload 15
    //   433: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokevirtual 349	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   439: astore 14
    //   441: aload 14
    //   443: astore 15
    //   445: aload 14
    //   447: ifnull -71 -> 376
    //   450: aload_2
    //   451: invokevirtual 341	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   454: astore_2
    //   455: new 77	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   462: astore 15
    //   464: aload 15
    //   466: invokestatic 343	com/tencent/av/utils/AVSoUtils:a	()Ljava/lang/String;
    //   469: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload 15
    //   475: aload 5
    //   477: invokestatic 312	com/tencent/av/utils/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   480: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 15
    //   486: ldc_w 353
    //   489: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload_2
    //   494: aload 15
    //   496: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokevirtual 349	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   502: astore 15
    //   504: aload 14
    //   506: astore_2
    //   507: aload 15
    //   509: astore 14
    //   511: goto +43 -> 554
    //   514: astore_3
    //   515: aconst_null
    //   516: astore 4
    //   518: aload 17
    //   520: astore_2
    //   521: aload 14
    //   523: astore 5
    //   525: aload 4
    //   527: astore 14
    //   529: goto +791 -> 1320
    //   532: astore_3
    //   533: iload 10
    //   535: istore 9
    //   537: aconst_null
    //   538: astore 5
    //   540: aload 16
    //   542: astore 4
    //   544: aload 14
    //   546: astore_2
    //   547: aload 5
    //   549: astore 14
    //   551: goto +615 -> 1166
    //   554: aload 20
    //   556: astore 15
    //   558: aload_2
    //   559: ifnull +109 -> 668
    //   562: aload 19
    //   564: astore 15
    //   566: aload_2
    //   567: astore 16
    //   569: aload 14
    //   571: astore 17
    //   573: new 77	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   580: astore 20
    //   582: aload 19
    //   584: astore 15
    //   586: aload_2
    //   587: astore 16
    //   589: aload 14
    //   591: astore 17
    //   593: aload 20
    //   595: aload 4
    //   597: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload 19
    //   603: astore 15
    //   605: aload_2
    //   606: astore 16
    //   608: aload 14
    //   610: astore 17
    //   612: aload 20
    //   614: aload 5
    //   616: invokestatic 312	com/tencent/av/utils/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   619: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload 19
    //   625: astore 15
    //   627: aload_2
    //   628: astore 16
    //   630: aload 14
    //   632: astore 17
    //   634: new 355	java/io/FileOutputStream
    //   637: dup
    //   638: aload 20
    //   640: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: iconst_1
    //   644: invokespecial 358	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   647: astore 4
    //   649: aload 4
    //   651: astore 15
    //   653: goto +15 -> 668
    //   656: astore_3
    //   657: aload 18
    //   659: astore 4
    //   661: iload 10
    //   663: istore 9
    //   665: goto +501 -> 1166
    //   668: lconst_0
    //   669: lstore 12
    //   671: sipush 8192
    //   674: newarray byte
    //   676: astore 16
    //   678: aload_2
    //   679: astore 5
    //   681: aload 15
    //   683: astore_2
    //   684: aload 5
    //   686: ifnull +85 -> 771
    //   689: aload 5
    //   691: aload 16
    //   693: iconst_0
    //   694: aload 16
    //   696: arraylength
    //   697: invokevirtual 364	java/io/InputStream:read	([BII)I
    //   700: istore 11
    //   702: aload 5
    //   704: astore 4
    //   706: iload 11
    //   708: iconst_m1
    //   709: if_icmpeq +45 -> 754
    //   712: aload_2
    //   713: aload 16
    //   715: iconst_0
    //   716: iload 11
    //   718: invokevirtual 370	java/io/OutputStream:write	([BII)V
    //   721: lload 12
    //   723: iload 11
    //   725: i2l
    //   726: ladd
    //   727: lstore 12
    //   729: aload 4
    //   731: astore 5
    //   733: goto -49 -> 684
    //   736: astore_3
    //   737: goto +376 -> 1113
    //   740: astore_3
    //   741: aload 4
    //   743: astore 5
    //   745: aload_2
    //   746: astore 4
    //   748: aload 5
    //   750: astore_2
    //   751: goto -90 -> 661
    //   754: goto +17 -> 771
    //   757: astore_3
    //   758: goto +562 -> 1320
    //   761: astore_3
    //   762: aload_2
    //   763: astore 4
    //   765: aload 5
    //   767: astore_2
    //   768: goto -107 -> 661
    //   771: aload 5
    //   773: astore 4
    //   775: aload 14
    //   777: ifnull +49 -> 826
    //   780: aload 14
    //   782: aload 16
    //   784: iconst_0
    //   785: aload 16
    //   787: arraylength
    //   788: invokevirtual 364	java/io/InputStream:read	([BII)I
    //   791: istore 11
    //   793: iload 11
    //   795: iconst_m1
    //   796: if_icmpeq +30 -> 826
    //   799: aload_2
    //   800: astore 15
    //   802: aload 15
    //   804: aload 16
    //   806: iconst_0
    //   807: iload 11
    //   809: invokevirtual 370	java/io/OutputStream:write	([BII)V
    //   812: lload 12
    //   814: iload 11
    //   816: i2l
    //   817: ladd
    //   818: lstore 12
    //   820: aload 15
    //   822: astore_2
    //   823: goto -52 -> 771
    //   826: aload_2
    //   827: astore 5
    //   829: aload_3
    //   830: invokevirtual 283	java/io/File:exists	()Z
    //   833: ifeq +166 -> 999
    //   836: lload 12
    //   838: aload_3
    //   839: invokevirtual 373	java/io/File:length	()J
    //   842: lcmp
    //   843: ifeq +68 -> 911
    //   846: aload_3
    //   847: invokevirtual 286	java/io/File:delete	()Z
    //   850: pop
    //   851: new 77	java/lang/StringBuilder
    //   854: dup
    //   855: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   858: astore_3
    //   859: aload_3
    //   860: ldc_w 375
    //   863: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: pop
    //   867: aload_3
    //   868: lload_0
    //   869: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   872: pop
    //   873: aload_3
    //   874: ldc_w 270
    //   877: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: ldc 106
    //   883: iconst_1
    //   884: aload_3
    //   885: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   888: invokestatic 298	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: aload 4
    //   893: astore_2
    //   894: iconst_0
    //   895: istore 9
    //   897: goto +149 -> 1046
    //   900: astore_3
    //   901: iconst_0
    //   902: istore 9
    //   904: aload 5
    //   906: astore 15
    //   908: goto +220 -> 1128
    //   911: aload 6
    //   913: aload 7
    //   915: aload 8
    //   917: invokestatic 326	com/tencent/av/utils/AVSoUtils:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V
    //   920: new 77	java/lang/StringBuilder
    //   923: dup
    //   924: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   927: astore_3
    //   928: aload_3
    //   929: ldc_w 377
    //   932: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: aload_3
    //   937: aload 8
    //   939: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: pop
    //   943: aload_3
    //   944: ldc_w 330
    //   947: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: pop
    //   951: aload_3
    //   952: aload 7
    //   954: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: pop
    //   958: aload_3
    //   959: ldc_w 324
    //   962: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: pop
    //   966: aload_3
    //   967: lload_0
    //   968: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   971: pop
    //   972: aload_3
    //   973: ldc_w 270
    //   976: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: pop
    //   980: ldc 106
    //   982: iconst_1
    //   983: aload_3
    //   984: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokestatic 298	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   990: aload 4
    //   992: astore_2
    //   993: iconst_1
    //   994: istore 9
    //   996: goto +50 -> 1046
    //   999: new 77	java/lang/StringBuilder
    //   1002: dup
    //   1003: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1006: astore_3
    //   1007: aload_3
    //   1008: ldc_w 379
    //   1011: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1014: pop
    //   1015: aload_3
    //   1016: lload_0
    //   1017: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: aload_3
    //   1022: ldc_w 270
    //   1025: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: pop
    //   1029: ldc 106
    //   1031: iconst_1
    //   1032: aload_3
    //   1033: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1036: invokestatic 298	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1039: aload 4
    //   1041: astore_2
    //   1042: iload 10
    //   1044: istore 9
    //   1046: aload 5
    //   1048: ifnull +11 -> 1059
    //   1051: aload 5
    //   1053: invokevirtual 382	java/io/OutputStream:close	()V
    //   1056: goto +3 -> 1059
    //   1059: aload_2
    //   1060: ifnull +10 -> 1070
    //   1063: aload_2
    //   1064: invokevirtual 383	java/io/InputStream:close	()V
    //   1067: goto +3 -> 1070
    //   1070: iload 9
    //   1072: istore 10
    //   1074: aload 14
    //   1076: ifnull +229 -> 1305
    //   1079: aload 14
    //   1081: invokevirtual 383	java/io/InputStream:close	()V
    //   1084: iload 9
    //   1086: istore 10
    //   1088: goto +217 -> 1305
    //   1091: astore_3
    //   1092: goto +21 -> 1113
    //   1095: astore_3
    //   1096: iload 10
    //   1098: istore 9
    //   1100: aload_2
    //   1101: astore 15
    //   1103: goto +25 -> 1128
    //   1106: astore_3
    //   1107: aload_2
    //   1108: astore 4
    //   1110: aload 15
    //   1112: astore_2
    //   1113: aload 4
    //   1115: astore 5
    //   1117: goto +203 -> 1320
    //   1120: astore_3
    //   1121: iload 10
    //   1123: istore 9
    //   1125: aload_2
    //   1126: astore 4
    //   1128: aload 4
    //   1130: astore_2
    //   1131: aload 15
    //   1133: astore 4
    //   1135: goto +31 -> 1166
    //   1138: astore_3
    //   1139: aconst_null
    //   1140: astore 5
    //   1142: aload 5
    //   1144: astore 14
    //   1146: aload 17
    //   1148: astore_2
    //   1149: goto +171 -> 1320
    //   1152: astore_3
    //   1153: iload 10
    //   1155: istore 9
    //   1157: aconst_null
    //   1158: astore_2
    //   1159: aload_2
    //   1160: astore 14
    //   1162: aload 16
    //   1164: astore 4
    //   1166: aload 4
    //   1168: astore 15
    //   1170: aload_2
    //   1171: astore 16
    //   1173: aload 14
    //   1175: astore 17
    //   1177: new 77	java/lang/StringBuilder
    //   1180: dup
    //   1181: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1184: astore 5
    //   1186: aload 4
    //   1188: astore 15
    //   1190: aload_2
    //   1191: astore 16
    //   1193: aload 14
    //   1195: astore 17
    //   1197: aload 5
    //   1199: ldc_w 385
    //   1202: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: pop
    //   1206: aload 4
    //   1208: astore 15
    //   1210: aload_2
    //   1211: astore 16
    //   1213: aload 14
    //   1215: astore 17
    //   1217: aload 5
    //   1219: lload_0
    //   1220: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1223: pop
    //   1224: aload 4
    //   1226: astore 15
    //   1228: aload_2
    //   1229: astore 16
    //   1231: aload 14
    //   1233: astore 17
    //   1235: aload 5
    //   1237: ldc_w 270
    //   1240: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1243: pop
    //   1244: aload 4
    //   1246: astore 15
    //   1248: aload_2
    //   1249: astore 16
    //   1251: aload 14
    //   1253: astore 17
    //   1255: ldc 106
    //   1257: iconst_1
    //   1258: aload 5
    //   1260: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1263: aload_3
    //   1264: invokestatic 388	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1267: aload 4
    //   1269: ifnull +11 -> 1280
    //   1272: aload 4
    //   1274: invokevirtual 382	java/io/OutputStream:close	()V
    //   1277: goto +3 -> 1280
    //   1280: aload_2
    //   1281: ifnull +10 -> 1291
    //   1284: aload_2
    //   1285: invokevirtual 383	java/io/InputStream:close	()V
    //   1288: goto +3 -> 1291
    //   1291: aload 14
    //   1293: ifnull +8 -> 1301
    //   1296: aload 14
    //   1298: invokevirtual 383	java/io/InputStream:close	()V
    //   1301: iload 9
    //   1303: istore 10
    //   1305: iload 10
    //   1307: ireturn
    //   1308: astore_3
    //   1309: aload 17
    //   1311: astore 14
    //   1313: aload 16
    //   1315: astore 5
    //   1317: aload 15
    //   1319: astore_2
    //   1320: aload_2
    //   1321: ifnull +10 -> 1331
    //   1324: aload_2
    //   1325: invokevirtual 382	java/io/OutputStream:close	()V
    //   1328: goto +3 -> 1331
    //   1331: aload 5
    //   1333: ifnull +11 -> 1344
    //   1336: aload 5
    //   1338: invokevirtual 383	java/io/InputStream:close	()V
    //   1341: goto +3 -> 1344
    //   1344: aload 14
    //   1346: ifnull +8 -> 1354
    //   1349: aload 14
    //   1351: invokevirtual 383	java/io/InputStream:close	()V
    //   1354: aload_3
    //   1355: athrow
    //   1356: new 77	java/lang/StringBuilder
    //   1359: dup
    //   1360: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   1363: astore_2
    //   1364: aload_2
    //   1365: ldc_w 390
    //   1368: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1371: pop
    //   1372: aload_2
    //   1373: lload_0
    //   1374: invokevirtual 94	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1377: pop
    //   1378: aload_2
    //   1379: ldc_w 270
    //   1382: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: pop
    //   1386: ldc 106
    //   1388: iconst_1
    //   1389: aload_2
    //   1390: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1393: invokestatic 298	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1396: iload 10
    //   1398: ireturn
    //   1399: astore 14
    //   1401: goto -1016 -> 385
    //   1404: astore_3
    //   1405: goto -346 -> 1059
    //   1408: astore_2
    //   1409: goto -339 -> 1070
    //   1412: astore_2
    //   1413: iload 9
    //   1415: istore 10
    //   1417: goto -112 -> 1305
    //   1420: astore_3
    //   1421: goto -141 -> 1280
    //   1424: astore_2
    //   1425: goto -134 -> 1291
    //   1428: astore_2
    //   1429: goto -128 -> 1301
    //   1432: astore_2
    //   1433: goto -102 -> 1331
    //   1436: astore_2
    //   1437: goto -93 -> 1344
    //   1440: astore_2
    //   1441: goto -87 -> 1354
    //   1444: astore_3
    //   1445: goto -353 -> 1092
    //   1448: astore_3
    //   1449: goto -353 -> 1096
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1452	0	paramLong	long
    //   0	1452	2	paramContext	Context
    //   0	1452	3	paramFile	File
    //   0	1452	4	paramString1	String
    //   0	1452	5	paramString2	String
    //   0	1452	6	paramSharedPreferences	SharedPreferences
    //   0	1452	7	paramString3	String
    //   0	1452	8	paramString4	String
    //   0	1452	9	paramBoolean1	boolean
    //   0	1452	10	paramBoolean2	boolean
    //   31	784	11	i	int
    //   669	168	12	l	long
    //   287	1063	14	localObject1	Object
    //   1399	1	14	localFileNotFoundException	java.io.FileNotFoundException
    //   264	1054	15	localObject2	Object
    //   267	1047	16	localObject3	Object
    //   273	1037	17	localObject4	Object
    //   276	382	18	localObject5	Object
    //   270	354	19	localObject6	Object
    //   261	378	20	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   450	504	514	finally
    //   450	504	532	java/io/IOException
    //   573	582	656	java/io/IOException
    //   593	601	656	java/io/IOException
    //   612	623	656	java/io/IOException
    //   634	649	656	java/io/IOException
    //   712	721	736	finally
    //   712	721	740	java/io/IOException
    //   689	702	757	finally
    //   689	702	761	java/io/IOException
    //   851	891	900	java/io/IOException
    //   802	812	1091	finally
    //   829	851	1091	finally
    //   851	891	1091	finally
    //   911	990	1091	finally
    //   999	1039	1091	finally
    //   802	812	1095	java/io/IOException
    //   829	851	1095	java/io/IOException
    //   911	990	1095	java/io/IOException
    //   999	1039	1095	java/io/IOException
    //   671	678	1106	finally
    //   671	678	1120	java/io/IOException
    //   278	304	1138	finally
    //   329	376	1138	finally
    //   385	441	1138	finally
    //   278	304	1152	java/io/IOException
    //   329	376	1152	java/io/IOException
    //   385	441	1152	java/io/IOException
    //   573	582	1308	finally
    //   593	601	1308	finally
    //   612	623	1308	finally
    //   634	649	1308	finally
    //   1177	1186	1308	finally
    //   1197	1206	1308	finally
    //   1217	1224	1308	finally
    //   1235	1244	1308	finally
    //   1255	1267	1308	finally
    //   329	376	1399	java/io/FileNotFoundException
    //   1051	1056	1404	java/io/IOException
    //   1063	1067	1408	java/io/IOException
    //   1079	1084	1412	java/io/IOException
    //   1272	1277	1420	java/io/IOException
    //   1284	1288	1424	java/io/IOException
    //   1296	1301	1428	java/io/IOException
    //   1324	1328	1432	java/io/IOException
    //   1336	1341	1436	java/io/IOException
    //   1349	1354	1440	java/io/IOException
    //   780	793	1444	finally
    //   780	793	1448	java/io/IOException
  }
  
  public static boolean a(long paramLong, Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject4 = "";
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("LoadExtractedSo begin, libName[");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("], seq[");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append("]");
    QLog.d("AVSoUtils", 1, ((StringBuilder)localObject1).toString());
    localObject1 = null;
    Object localObject2 = localObject1;
    boolean bool1;
    try
    {
      Object localObject5 = new StringBuilder();
      localObject2 = localObject1;
      ((StringBuilder)localObject5).append(paramContext.getFilesDir().getParent());
      localObject2 = localObject1;
      ((StringBuilder)localObject5).append("/txlib/");
      localObject2 = localObject1;
      ((StringBuilder)localObject5).append(a(paramString));
      localObject2 = localObject1;
      localObject1 = ((StringBuilder)localObject5).toString();
      localObject2 = localObject1;
      bool1 = new File((String)localObject1).exists();
      try
      {
        if (AudioHelper.b())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("LoadExtractedSo, strLibPath[");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("], exists[");
          ((StringBuilder)localObject2).append(bool1);
          ((StringBuilder)localObject2).append("], seq[");
          ((StringBuilder)localObject2).append(paramLong);
          ((StringBuilder)localObject2).append("]");
          QLog.w("AVSoUtils", 1, ((StringBuilder)localObject2).toString());
        }
        localObject5 = "";
        localObject2 = localObject1;
      }
      catch (Exception localException1) {}
      str1 = QLog.getStackTraceString(localObject3);
    }
    catch (Exception localException4)
    {
      bool1 = false;
      localObject1 = localException1;
      localObject3 = localException4;
    }
    String str1;
    Object localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("LoadExtractedSo Exception, seq[");
    ((StringBuilder)localObject6).append(paramLong);
    ((StringBuilder)localObject6).append("]");
    QLog.w("AVSoUtils", 1, ((StringBuilder)localObject6).toString(), localObject3);
    Object localObject3 = localObject1;
    try
    {
      System.load(localObject3);
      localObject1 = "";
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      for (;;)
      {
        Object localObject7;
        localObject1 = QLog.getStackTraceString(localUnsatisfiedLinkError2);
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("LoadExtractedSo, Exception, seq[");
        ((StringBuilder)localObject6).append(paramLong);
        ((StringBuilder)localObject6).append("]");
        QLog.w("AVSoUtils", 1, ((StringBuilder)localObject6).toString(), localUnsatisfiedLinkError2);
        localObject6 = new File(localObject3);
        if (!((File)localObject6).exists()) {
          break label502;
        }
        bool2 = ((File)localObject6).delete();
        if (!QLog.isDevelopLevel()) {
          break label547;
        }
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("LoadExtractedSo, del file ret[");
        ((StringBuilder)localObject6).append(bool2);
        ((StringBuilder)localObject6).append("], seq[");
        ((StringBuilder)localObject6).append(paramLong);
        ((StringBuilder)localObject6).append("]");
        QLog.w("AVSoUtils", 1, ((StringBuilder)localObject6).toString());
        break label547;
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("LoadExtractedSo file not exists, seq[");
        ((StringBuilder)localObject6).append(paramLong);
        ((StringBuilder)localObject6).append("]");
        QLog.w("AVSoUtils", 1, ((StringBuilder)localObject6).toString());
        paramBoolean = b(paramLong, paramContext, paramString, paramBoolean);
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("LoadExtractedSo, re extractLibraryFromAssert, bret[");
        ((StringBuilder)localObject6).append(paramBoolean);
        ((StringBuilder)localObject6).append("], seq[");
        ((StringBuilder)localObject6).append(paramLong);
        ((StringBuilder)localObject6).append("]");
        QLog.w("AVSoUtils", 1, ((StringBuilder)localObject6).toString());
        try
        {
          System.load(localObject3);
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
        {
          str2 = QLog.getStackTraceString(localUnsatisfiedLinkError1);
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("LoadExtractedSo Exception, seq[");
          localStringBuilder1.append(paramLong);
          localStringBuilder1.append("]");
          QLog.w("AVSoUtils", 1, localStringBuilder1.toString(), localUnsatisfiedLinkError2);
          paramBoolean = false;
          localObject8 = localObject1;
        }
      }
    }
    localObject6 = "";
    paramBoolean = true;
    localObject7 = localObject1;
    label502:
    String str2;
    label547:
    Object localObject8;
    if (!paramBoolean)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("LoadExtractedSo,  system way. seq[");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append("]");
      QLog.w("AVSoUtils", 1, ((StringBuilder)localObject1).toString());
      try
      {
        System.loadLibrary(paramString);
        localObject1 = "";
        paramBoolean = true;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
      {
        localObject1 = QLog.getStackTraceString(localUnsatisfiedLinkError3);
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("LoadExtractedSo Exception, seq[");
        localStringBuilder2.append(paramLong);
        localStringBuilder2.append("]");
        QLog.w("AVSoUtils", 1, localStringBuilder2.toString(), localUnsatisfiedLinkError3);
      }
    }
    else
    {
      localObject1 = "";
    }
    long l1;
    if (!paramBoolean) {
      l1 = 0L;
    }
    try
    {
      localFile = new File(localObject3);
      bool2 = localFile.exists();
      localObject3 = localObject4;
    }
    catch (Exception localException2)
    {
      File localFile;
      long l2;
      label876:
      label883:
      break label876;
    }
    try
    {
      localObject4 = MD5.a(localFile);
      localObject3 = localObject4;
      l2 = localFile.length();
      localObject3 = localObject4;
      l1 = l2;
    }
    catch (Exception localException3)
    {
      break label883;
    }
    boolean bool2 = false;
    localObject3 = localObject4;
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("LoadExtractedSo,  failed. seq[");
    ((StringBuilder)localObject4).append(paramLong);
    ((StringBuilder)localObject4).append("], msg1[");
    ((StringBuilder)localObject4).append(str1);
    ((StringBuilder)localObject4).append("], msg2[");
    ((StringBuilder)localObject4).append(localObject8);
    ((StringBuilder)localObject4).append("], msg3[");
    ((StringBuilder)localObject4).append(str2);
    ((StringBuilder)localObject4).append("], msg4[");
    ((StringBuilder)localObject4).append((String)localObject1);
    ((StringBuilder)localObject4).append("]");
    QLog.w("AVSoUtils", 1, ((StringBuilder)localObject4).toString());
    localObject4 = new HashMap();
    ((HashMap)localObject4).put("soname", paramString);
    ((HashMap)localObject4).put("existFirst", String.valueOf(bool1));
    ((HashMap)localObject4).put("existLast", String.valueOf(bool2));
    ((HashMap)localObject4).put("md5", localObject3);
    ((HashMap)localObject4).put("fileLength", String.valueOf(l1));
    ((HashMap)localObject4).put("msg1", c(str1));
    ((HashMap)localObject4).put("msg2", c(localObject8));
    ((HashMap)localObject4).put("msg3", c(str2));
    ((HashMap)localObject4).put("msg4", c((String)localObject1));
    ((HashMap)localObject4).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    ((HashMap)localObject4).put("man", c(Build.MANUFACTURER));
    ((HashMap)localObject4).put("mod", c(Build.MODEL));
    ((HashMap)localObject4).put("qq_ver", String.valueOf(UITools.getQQVersion()));
    StatisticCollector.getInstance(paramContext).collectPerformance("", "AV_LOAD_SO_FAILED", false, 0L, 0L, (HashMap)localObject4, "");
    paramContext = new StringBuilder();
    paramContext.append("LoadExtractedSo end , result[");
    paramContext.append(paramBoolean);
    paramContext.append("], libName[");
    paramContext.append(paramString);
    paramContext.append("], seq[");
    paramContext.append(paramLong);
    paramContext.append("]");
    QLog.w("AVSoUtils", 1, paramContext.toString());
    return paramBoolean;
  }
  
  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    return a(0L, paramContext, paramString, paramBoolean);
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(SoLoadUtil.a());
      if (!TextUtils.equals(paramString, localStringBuilder.toString())) {
        return false;
      }
    }
    return true;
  }
  
  public static String b()
  {
    File localFile = BaseApplication.getContext().getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVSoUtils", 2, "getFilesDir is null");
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getParent());
    localStringBuilder.append("/txlib/");
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    Object localObject = new File(paramString);
    try
    {
      str = MD5FileUtil.a((File)localObject);
    }
    catch (Exception localException)
    {
      String str;
      label17:
      StringBuilder localStringBuilder;
      break label17;
    }
    str = "Exception";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], exists[");
    localStringBuilder.append(((File)localObject).exists());
    paramString = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("], md5[");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("]");
    return ((StringBuilder)localObject).toString();
  }
  
  public static void b()
  {
    String str = b();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("DecodeSo");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libTcHevcDec.so");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libTcHevcDec2.so");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libtraeimp-qq.so");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libqav_graphics.so");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libqav_gaudio_engine.so");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libqav_utils.so");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libqav_media_engine.so");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libSDKCommon.so");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libVideoCtrl.so");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libxplatform.so");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libc++_shared.so");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    str = GifSoLoader.a(BaseApplication.getContext());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libc++_shared.so");
    localStringBuilder1.append(b(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
  }
  
  public static boolean b()
  {
    if (jdField_b_of_type_Boolean) {
      return true;
    }
    try
    {
      if (i())
      {
        Object localObject = BaseApplication.getContext();
        if (TextUtils.isEmpty(jdField_d_of_type_JavaLangString))
        {
          a(0L, (Context)localObject, "VideoCtrl", true);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
          ((StringBuilder)localObject).append(a("VideoCtrl"));
          System.load(((StringBuilder)localObject).toString());
        }
        jdField_b_of_type_Boolean = true;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadDAVEngineSo successfully. sDownloadedAVSDKSoDir = ");
        ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
        QLog.i("AVSoUtils", 1, ((StringBuilder)localObject).toString(), new Throwable("打印调用栈"));
      }
      else
      {
        jdField_b_of_type_Boolean = false;
        QLog.e("AVSoUtils", 1, "loadDAVEngineSo failed.", new Throwable("打印调用栈"));
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadDAVEngineSo failed. err = ");
      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
      QLog.e("AVSoUtils", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      jdField_b_of_type_Boolean = false;
    }
    return jdField_b_of_type_Boolean;
  }
  
  public static boolean b(long paramLong, Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("so_sp", 4);
      String str1 = c();
      String str2 = d(paramString);
      String str3 = localSharedPreferences.getString(str2, d());
      String str4 = b();
      boolean bool2 = TextUtils.isEmpty(str4);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str4);
      ((StringBuilder)localObject1).append(a(paramString));
      localObject1 = new File(((StringBuilder)localObject1).toString());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("extractLibraryFromAssert, libname[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], oldVer[");
      ((StringBuilder)localObject2).append(str3);
      ((StringBuilder)localObject2).append("], newVer[");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("], needDecodeWith7z[");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("], istxLibPathEmpty[");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append("], txSoFile[");
      ((StringBuilder)localObject2).append(((File)localObject1).exists());
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("]");
      localObject2 = ((StringBuilder)localObject2).toString();
      boolean bool1 = true;
      QLog.w("AVSoUtils", 1, (String)localObject2);
      if (bool2) {
        return false;
      }
      if ((TextUtils.equals(str3, str1)) && (((File)localObject1).exists()))
      {
        paramBoolean = bool1;
      }
      else
      {
        long l1 = SystemClock.uptimeMillis();
        paramBoolean = a(paramLong, paramContext, (File)localObject1, str4, paramString, localSharedPreferences, str1, str2, paramBoolean, false);
        long l2 = SystemClock.uptimeMillis();
        paramContext = new StringBuilder();
        paramContext.append("extractLibraryFromAssert end, libName[");
        paramContext.append(paramString);
        paramContext.append("], costTime[");
        paramContext.append(l2 - l1);
        paramContext.append("], exists[");
        paramContext.append(((File)localObject1).exists());
        paramContext.append("], seq[");
        paramContext.append(paramLong);
        paramContext.append("]");
        QLog.w("AVSoUtils", 1, paramContext.toString());
      }
      return paramBoolean;
    }
    finally {}
  }
  
  public static boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = b(0L, paramContext, paramString, paramBoolean);
      return paramBoolean;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppSetting.g());
    localStringBuilder.append(SoLoadUtil.a());
    return localStringBuilder.toString();
  }
  
  public static String c(String paramString)
  {
    return paramString.replace("=", "@1").replace("&", "@2").replace("|", "@3").replace("\"", "@6");
  }
  
  public static void c()
  {
    if ((!TextUtils.isEmpty(e())) && (!TextUtils.isEmpty(f())))
    {
      ThreadManager.excute(new AVSoUtils.1(), 16, null, false);
      return;
    }
    g();
    h();
  }
  
  public static boolean c()
  {
    if (jdField_c_of_type_Boolean) {
      return true;
    }
    try
    {
      if ((i()) && (b()))
      {
        Object localObject = BaseApplication.getContext();
        boolean bool = TextUtils.isEmpty(jdField_d_of_type_JavaLangString);
        if (bool)
        {
          a((Context)localObject, "qav_media_engine", true);
          a(0L, (Context)localObject, "qav_gaudio_engine", true);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
          ((StringBuilder)localObject).append(a("qav_media_engine"));
          System.load(((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
          ((StringBuilder)localObject).append(a("qav_gaudio_engine"));
          System.load(((StringBuilder)localObject).toString());
        }
        jdField_c_of_type_Boolean = true;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadMAVEngineSo successfully. sDownloadedAVSDKSoDir = ");
        ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
        QLog.i("AVSoUtils", 1, ((StringBuilder)localObject).toString(), new Throwable("打印调用栈"));
      }
      else
      {
        jdField_c_of_type_Boolean = false;
        QLog.e("AVSoUtils", 1, "loadMAVEngineSo failed.", new Throwable("打印调用栈"));
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMAVEngineSo failed. err = ");
      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
      QLog.e("AVSoUtils", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      jdField_c_of_type_Boolean = false;
    }
    return jdField_c_of_type_Boolean;
  }
  
  public static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-1");
    localStringBuilder.append(SoLoadUtil.a());
    return localStringBuilder.toString();
  }
  
  public static String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_so_version_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static boolean d()
  {
    if (jdField_d_of_type_Boolean) {
      return true;
    }
    try
    {
      if (i())
      {
        Object localObject = BaseApplication.getContext();
        if (TextUtils.isEmpty(jdField_d_of_type_JavaLangString))
        {
          a(0L, (Context)localObject, "qav_graphics", true);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
          ((StringBuilder)localObject).append(a("qav_graphics"));
          System.load(((StringBuilder)localObject).toString());
        }
        jdField_d_of_type_Boolean = true;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadAVRenderSo successfully. sDownloadedAVSDKSoDir = ");
        ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
        QLog.i("AVSoUtils", 1, ((StringBuilder)localObject).toString(), new Throwable("打印调用栈"));
      }
      else
      {
        jdField_d_of_type_Boolean = false;
        QLog.e("AVSoUtils", 1, "loadAVRenderSo failed.", new Throwable("打印调用栈"));
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadAVRenderSo failed. err = ");
      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
      QLog.e("AVSoUtils", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      jdField_d_of_type_Boolean = false;
    }
    return jdField_d_of_type_Boolean;
  }
  
  public static String e()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String f()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  public static String g()
  {
    return jdField_c_of_type_JavaLangString;
  }
  
  private static boolean g()
  {
    Object localObject1 = a("TcHevcEnc");
    boolean bool;
    if ((localObject1 != null) && (((LoadExtResult)localObject1).isSucc())) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      Object localObject2 = ((LoadExtResult)localObject1).getSoLoadPath("TcHevcEnc");
      localObject1 = jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        jdField_a_of_type_JavaLangString = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(File.separator));
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadAndDownloadSo. new HevcEncSoDir = ");
      ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", old HevcEncSoDir = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("AVSoUtils", 1, ((StringBuilder)localObject2).toString());
    }
    return bool;
  }
  
  private static boolean h()
  {
    Object localObject1 = a("TcHevcDec2");
    boolean bool;
    if ((localObject1 != null) && (((LoadExtResult)localObject1).isSucc())) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      Object localObject2 = ((LoadExtResult)localObject1).getSoLoadPath("TcHevcDec2");
      localObject1 = jdField_b_of_type_JavaLangString;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        jdField_b_of_type_JavaLangString = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(File.separator));
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadAndDownloadSo. new HevcDecSoDir = ");
      ((StringBuilder)localObject2).append(jdField_b_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", old HevcDecSoDir = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("AVSoUtils", 1, ((StringBuilder)localObject2).toString());
    }
    return bool;
  }
  
  private static boolean i()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    try
    {
      Object localObject = BaseApplication.getContext();
      SoLoadUtil.a((Context)localObject, "c++_shared", 0, false);
      SoLoadUtil.a((Context)localObject, "xplatform", 0, false);
      ResMgr.a();
      jdField_d_of_type_JavaLangString = ResMgr.d();
      if (TextUtils.isEmpty(jdField_d_of_type_JavaLangString))
      {
        a(0L, (Context)localObject, "SDKCommon", true);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
        ((StringBuilder)localObject).append(a("SDKCommon"));
        System.load(((StringBuilder)localObject).toString());
      }
      jdField_a_of_type_Boolean = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadAVBaseSo successfully. sDownloadedAVSDKSoDir = ");
      ((StringBuilder)localObject).append(jdField_d_of_type_JavaLangString);
      QLog.i("AVSoUtils", 1, ((StringBuilder)localObject).toString(), new Throwable("打印调用栈"));
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      jdField_a_of_type_Boolean = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadAVBaseSo failed. err = ");
      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
      QLog.e("AVSoUtils", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
    }
    return jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AVSoUtils
 * JD-Core Version:    0.7.0.1
 */
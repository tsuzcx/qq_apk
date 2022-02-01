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
  private static final String[] a = { "SDKCommon", "qav_gaudio_engine", "xplatform", "VideoCtrl", "qav_graphics", "TcHevcEnc", "c++_shared", "qav_media_engine", "TcHevcDec", "traeimp-qq" };
  private static String b = "";
  private static String c = "";
  private static String d = "";
  private static String e = "";
  private static boolean f = false;
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  
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
          String str3 = e(paramString);
          paramContext = e();
          String str1 = f();
          String str2 = ((SharedPreferences)localObject).getString(str3, str1);
          if ((TextUtils.equals(paramContext, str2)) && (!f(paramContext))) {
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
    if (f(paramString1))
    {
      paramSharedPreferences.edit().putString(paramString2, f()).commit();
      return;
    }
    paramSharedPreferences.edit().putString(paramString2, paramString1).commit();
  }
  
  /* Error */
  private static boolean a(long paramLong, Context paramContext, File paramFile, String paramString1, String paramString2, SharedPreferences paramSharedPreferences, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 178	java/io/File:delete	()Z
    //   4: pop
    //   5: aload_3
    //   6: invokevirtual 181	java/io/File:exists	()Z
    //   9: ifne +1327 -> 1336
    //   12: iload 9
    //   14: ifeq +234 -> 248
    //   17: aload_2
    //   18: aload 4
    //   20: ldc 183
    //   22: aload 5
    //   24: invokestatic 185	com/tencent/av/utils/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   27: invokestatic 190	com/tencent/mobileqq/utils/SoLoadUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   30: istore 11
    //   32: aload_3
    //   33: invokevirtual 181	java/io/File:exists	()Z
    //   36: ifeq +144 -> 180
    //   39: iload 11
    //   41: ifeq +62 -> 103
    //   44: aload_3
    //   45: invokevirtual 178	java/io/File:delete	()Z
    //   48: pop
    //   49: new 70	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   56: astore_2
    //   57: aload_2
    //   58: ldc 192
    //   60: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: iload 11
    //   67: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_2
    //   72: ldc 197
    //   74: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_2
    //   79: lload_0
    //   80: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_2
    //   85: ldc 163
    //   87: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: ldc 90
    //   93: iconst_1
    //   94: aload_2
    //   95: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 200	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: iconst_0
    //   102: ireturn
    //   103: aload 6
    //   105: aload 7
    //   107: aload 8
    //   109: invokestatic 202	com/tencent/av/utils/AVSoUtils:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V
    //   112: new 70	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   119: astore_2
    //   120: aload_2
    //   121: ldc 204
    //   123: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: aload_2
    //   128: aload 8
    //   130: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_2
    //   135: ldc 206
    //   137: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_2
    //   142: aload 7
    //   144: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_2
    //   149: ldc 197
    //   151: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_2
    //   156: lload_0
    //   157: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_2
    //   162: ldc 163
    //   164: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: ldc 90
    //   170: iconst_1
    //   171: aload_2
    //   172: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 200	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: iconst_1
    //   179: ireturn
    //   180: new 70	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   187: astore_2
    //   188: aload_2
    //   189: ldc 208
    //   191: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_2
    //   196: iload 11
    //   198: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_2
    //   203: ldc 210
    //   205: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload_2
    //   210: iconst_0
    //   211: invokevirtual 213	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload_2
    //   216: ldc 197
    //   218: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_2
    //   223: lload_0
    //   224: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_2
    //   229: ldc 163
    //   231: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: ldc 90
    //   237: iconst_1
    //   238: aload_2
    //   239: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 200	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: goto +1130 -> 1375
    //   248: aconst_null
    //   249: astore 20
    //   251: aconst_null
    //   252: astore 15
    //   254: aconst_null
    //   255: astore 16
    //   257: aconst_null
    //   258: astore 19
    //   260: aconst_null
    //   261: astore 17
    //   263: aconst_null
    //   264: astore 18
    //   266: new 175	java/io/File
    //   269: dup
    //   270: aload 4
    //   272: invokespecial 216	java/io/File:<init>	(Ljava/lang/String;)V
    //   275: astore 14
    //   277: aload 14
    //   279: invokevirtual 181	java/io/File:exists	()Z
    //   282: ifne +35 -> 317
    //   285: aload 14
    //   287: invokevirtual 219	java/io/File:mkdir	()Z
    //   290: istore 9
    //   292: iload 9
    //   294: ifeq +6 -> 300
    //   297: goto +20 -> 317
    //   300: iload 10
    //   302: istore 9
    //   304: aconst_null
    //   305: astore 5
    //   307: aload 5
    //   309: astore 14
    //   311: aload 15
    //   313: astore_2
    //   314: goto +713 -> 1027
    //   317: aload_2
    //   318: invokevirtual 223	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   321: astore 14
    //   323: new 70	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   330: astore 15
    //   332: aload 15
    //   334: invokestatic 225	com/tencent/av/utils/AVSoUtils:a	()Ljava/lang/String;
    //   337: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 15
    //   343: aload 5
    //   345: invokestatic 185	com/tencent/av/utils/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   348: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 14
    //   354: aload 15
    //   356: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokevirtual 231	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   362: astore 15
    //   364: aconst_null
    //   365: astore 14
    //   367: aload 15
    //   369: astore_2
    //   370: goto +170 -> 540
    //   373: aload_2
    //   374: invokevirtual 223	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   377: astore 14
    //   379: new 70	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   386: astore 15
    //   388: aload 15
    //   390: invokestatic 225	com/tencent/av/utils/AVSoUtils:a	()Ljava/lang/String;
    //   393: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 15
    //   399: aload 5
    //   401: invokestatic 185	com/tencent/av/utils/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   404: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 15
    //   410: ldc 233
    //   412: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 14
    //   418: aload 15
    //   420: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokevirtual 231	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   426: astore 14
    //   428: aload 14
    //   430: astore 15
    //   432: aload 14
    //   434: ifnull -70 -> 364
    //   437: aload_2
    //   438: invokevirtual 223	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   441: astore_2
    //   442: new 70	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   449: astore 15
    //   451: aload 15
    //   453: invokestatic 225	com/tencent/av/utils/AVSoUtils:a	()Ljava/lang/String;
    //   456: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: aload 15
    //   462: aload 5
    //   464: invokestatic 185	com/tencent/av/utils/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   467: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 15
    //   473: ldc 235
    //   475: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload_2
    //   480: aload 15
    //   482: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokevirtual 231	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   488: astore 15
    //   490: aload 14
    //   492: astore_2
    //   493: aload 15
    //   495: astore 14
    //   497: goto +43 -> 540
    //   500: astore_3
    //   501: aconst_null
    //   502: astore 4
    //   504: aload 17
    //   506: astore_2
    //   507: aload 14
    //   509: astore 5
    //   511: aload 4
    //   513: astore 14
    //   515: goto +785 -> 1300
    //   518: astore_3
    //   519: iload 10
    //   521: istore 9
    //   523: aconst_null
    //   524: astore 5
    //   526: aload 16
    //   528: astore 4
    //   530: aload 14
    //   532: astore_2
    //   533: aload 5
    //   535: astore 14
    //   537: goto +610 -> 1147
    //   540: aload 20
    //   542: astore 15
    //   544: aload_2
    //   545: ifnull +109 -> 654
    //   548: aload 19
    //   550: astore 15
    //   552: aload_2
    //   553: astore 16
    //   555: aload 14
    //   557: astore 17
    //   559: new 70	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   566: astore 20
    //   568: aload 19
    //   570: astore 15
    //   572: aload_2
    //   573: astore 16
    //   575: aload 14
    //   577: astore 17
    //   579: aload 20
    //   581: aload 4
    //   583: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload 19
    //   589: astore 15
    //   591: aload_2
    //   592: astore 16
    //   594: aload 14
    //   596: astore 17
    //   598: aload 20
    //   600: aload 5
    //   602: invokestatic 185	com/tencent/av/utils/AVSoUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   605: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: pop
    //   609: aload 19
    //   611: astore 15
    //   613: aload_2
    //   614: astore 16
    //   616: aload 14
    //   618: astore 17
    //   620: new 237	java/io/FileOutputStream
    //   623: dup
    //   624: aload 20
    //   626: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: iconst_1
    //   630: invokespecial 240	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   633: astore 4
    //   635: aload 4
    //   637: astore 15
    //   639: goto +15 -> 654
    //   642: astore_3
    //   643: aload 18
    //   645: astore 4
    //   647: iload 10
    //   649: istore 9
    //   651: goto +496 -> 1147
    //   654: lconst_0
    //   655: lstore 12
    //   657: sipush 8192
    //   660: newarray byte
    //   662: astore 16
    //   664: aload_2
    //   665: astore 5
    //   667: aload 15
    //   669: astore_2
    //   670: aload 5
    //   672: ifnull +85 -> 757
    //   675: aload 5
    //   677: aload 16
    //   679: iconst_0
    //   680: aload 16
    //   682: arraylength
    //   683: invokevirtual 246	java/io/InputStream:read	([BII)I
    //   686: istore 11
    //   688: aload 5
    //   690: astore 4
    //   692: iload 11
    //   694: iconst_m1
    //   695: if_icmpeq +45 -> 740
    //   698: aload_2
    //   699: aload 16
    //   701: iconst_0
    //   702: iload 11
    //   704: invokevirtual 252	java/io/OutputStream:write	([BII)V
    //   707: lload 12
    //   709: iload 11
    //   711: i2l
    //   712: ladd
    //   713: lstore 12
    //   715: aload 4
    //   717: astore 5
    //   719: goto -49 -> 670
    //   722: astore_3
    //   723: goto +371 -> 1094
    //   726: astore_3
    //   727: aload 4
    //   729: astore 5
    //   731: aload_2
    //   732: astore 4
    //   734: aload 5
    //   736: astore_2
    //   737: goto -90 -> 647
    //   740: goto +17 -> 757
    //   743: astore_3
    //   744: goto +556 -> 1300
    //   747: astore_3
    //   748: aload_2
    //   749: astore 4
    //   751: aload 5
    //   753: astore_2
    //   754: goto -107 -> 647
    //   757: aload 5
    //   759: astore 4
    //   761: aload 14
    //   763: ifnull +49 -> 812
    //   766: aload 14
    //   768: aload 16
    //   770: iconst_0
    //   771: aload 16
    //   773: arraylength
    //   774: invokevirtual 246	java/io/InputStream:read	([BII)I
    //   777: istore 11
    //   779: iload 11
    //   781: iconst_m1
    //   782: if_icmpeq +30 -> 812
    //   785: aload_2
    //   786: astore 15
    //   788: aload 15
    //   790: aload 16
    //   792: iconst_0
    //   793: iload 11
    //   795: invokevirtual 252	java/io/OutputStream:write	([BII)V
    //   798: lload 12
    //   800: iload 11
    //   802: i2l
    //   803: ladd
    //   804: lstore 12
    //   806: aload 15
    //   808: astore_2
    //   809: goto -52 -> 757
    //   812: aload_2
    //   813: astore 5
    //   815: aload_3
    //   816: invokevirtual 181	java/io/File:exists	()Z
    //   819: ifeq +162 -> 981
    //   822: lload 12
    //   824: aload_3
    //   825: invokevirtual 256	java/io/File:length	()J
    //   828: lcmp
    //   829: ifeq +67 -> 896
    //   832: aload_3
    //   833: invokevirtual 178	java/io/File:delete	()Z
    //   836: pop
    //   837: new 70	java/lang/StringBuilder
    //   840: dup
    //   841: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   844: astore_3
    //   845: aload_3
    //   846: ldc_w 258
    //   849: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: pop
    //   853: aload_3
    //   854: lload_0
    //   855: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   858: pop
    //   859: aload_3
    //   860: ldc 163
    //   862: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: pop
    //   866: ldc 90
    //   868: iconst_1
    //   869: aload_3
    //   870: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokestatic 200	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   876: aload 4
    //   878: astore_2
    //   879: iconst_0
    //   880: istore 9
    //   882: goto +145 -> 1027
    //   885: astore_3
    //   886: iconst_0
    //   887: istore 9
    //   889: aload 5
    //   891: astore 15
    //   893: goto +216 -> 1109
    //   896: aload 6
    //   898: aload 7
    //   900: aload 8
    //   902: invokestatic 202	com/tencent/av/utils/AVSoUtils:a	(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V
    //   905: new 70	java/lang/StringBuilder
    //   908: dup
    //   909: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   912: astore_3
    //   913: aload_3
    //   914: ldc_w 260
    //   917: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: aload_3
    //   922: aload 8
    //   924: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: pop
    //   928: aload_3
    //   929: ldc 206
    //   931: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: aload_3
    //   936: aload 7
    //   938: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   941: pop
    //   942: aload_3
    //   943: ldc 197
    //   945: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: pop
    //   949: aload_3
    //   950: lload_0
    //   951: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   954: pop
    //   955: aload_3
    //   956: ldc 163
    //   958: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: pop
    //   962: ldc 90
    //   964: iconst_1
    //   965: aload_3
    //   966: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   969: invokestatic 200	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   972: aload 4
    //   974: astore_2
    //   975: iconst_1
    //   976: istore 9
    //   978: goto +49 -> 1027
    //   981: new 70	java/lang/StringBuilder
    //   984: dup
    //   985: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   988: astore_3
    //   989: aload_3
    //   990: ldc_w 262
    //   993: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload_3
    //   998: lload_0
    //   999: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload_3
    //   1004: ldc 163
    //   1006: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: pop
    //   1010: ldc 90
    //   1012: iconst_1
    //   1013: aload_3
    //   1014: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1017: invokestatic 200	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1020: aload 4
    //   1022: astore_2
    //   1023: iload 10
    //   1025: istore 9
    //   1027: aload 5
    //   1029: ifnull +11 -> 1040
    //   1032: aload 5
    //   1034: invokevirtual 265	java/io/OutputStream:close	()V
    //   1037: goto +3 -> 1040
    //   1040: aload_2
    //   1041: ifnull +10 -> 1051
    //   1044: aload_2
    //   1045: invokevirtual 266	java/io/InputStream:close	()V
    //   1048: goto +3 -> 1051
    //   1051: iload 9
    //   1053: istore 10
    //   1055: aload 14
    //   1057: ifnull +228 -> 1285
    //   1060: aload 14
    //   1062: invokevirtual 266	java/io/InputStream:close	()V
    //   1065: iload 9
    //   1067: istore 10
    //   1069: goto +216 -> 1285
    //   1072: astore_3
    //   1073: goto +21 -> 1094
    //   1076: astore_3
    //   1077: iload 10
    //   1079: istore 9
    //   1081: aload_2
    //   1082: astore 15
    //   1084: goto +25 -> 1109
    //   1087: astore_3
    //   1088: aload_2
    //   1089: astore 4
    //   1091: aload 15
    //   1093: astore_2
    //   1094: aload 4
    //   1096: astore 5
    //   1098: goto +202 -> 1300
    //   1101: astore_3
    //   1102: iload 10
    //   1104: istore 9
    //   1106: aload_2
    //   1107: astore 4
    //   1109: aload 4
    //   1111: astore_2
    //   1112: aload 15
    //   1114: astore 4
    //   1116: goto +31 -> 1147
    //   1119: astore_3
    //   1120: aconst_null
    //   1121: astore 5
    //   1123: aload 5
    //   1125: astore 14
    //   1127: aload 17
    //   1129: astore_2
    //   1130: goto +170 -> 1300
    //   1133: astore_3
    //   1134: iload 10
    //   1136: istore 9
    //   1138: aconst_null
    //   1139: astore_2
    //   1140: aload_2
    //   1141: astore 14
    //   1143: aload 16
    //   1145: astore 4
    //   1147: aload 4
    //   1149: astore 15
    //   1151: aload_2
    //   1152: astore 16
    //   1154: aload 14
    //   1156: astore 17
    //   1158: new 70	java/lang/StringBuilder
    //   1161: dup
    //   1162: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   1165: astore 5
    //   1167: aload 4
    //   1169: astore 15
    //   1171: aload_2
    //   1172: astore 16
    //   1174: aload 14
    //   1176: astore 17
    //   1178: aload 5
    //   1180: ldc_w 268
    //   1183: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: pop
    //   1187: aload 4
    //   1189: astore 15
    //   1191: aload_2
    //   1192: astore 16
    //   1194: aload 14
    //   1196: astore 17
    //   1198: aload 5
    //   1200: lload_0
    //   1201: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1204: pop
    //   1205: aload 4
    //   1207: astore 15
    //   1209: aload_2
    //   1210: astore 16
    //   1212: aload 14
    //   1214: astore 17
    //   1216: aload 5
    //   1218: ldc 163
    //   1220: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: pop
    //   1224: aload 4
    //   1226: astore 15
    //   1228: aload_2
    //   1229: astore 16
    //   1231: aload 14
    //   1233: astore 17
    //   1235: ldc 90
    //   1237: iconst_1
    //   1238: aload 5
    //   1240: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1243: aload_3
    //   1244: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1247: aload 4
    //   1249: ifnull +11 -> 1260
    //   1252: aload 4
    //   1254: invokevirtual 265	java/io/OutputStream:close	()V
    //   1257: goto +3 -> 1260
    //   1260: aload_2
    //   1261: ifnull +10 -> 1271
    //   1264: aload_2
    //   1265: invokevirtual 266	java/io/InputStream:close	()V
    //   1268: goto +3 -> 1271
    //   1271: aload 14
    //   1273: ifnull +8 -> 1281
    //   1276: aload 14
    //   1278: invokevirtual 266	java/io/InputStream:close	()V
    //   1281: iload 9
    //   1283: istore 10
    //   1285: iload 10
    //   1287: ireturn
    //   1288: astore_3
    //   1289: aload 17
    //   1291: astore 14
    //   1293: aload 16
    //   1295: astore 5
    //   1297: aload 15
    //   1299: astore_2
    //   1300: aload_2
    //   1301: ifnull +10 -> 1311
    //   1304: aload_2
    //   1305: invokevirtual 265	java/io/OutputStream:close	()V
    //   1308: goto +3 -> 1311
    //   1311: aload 5
    //   1313: ifnull +11 -> 1324
    //   1316: aload 5
    //   1318: invokevirtual 266	java/io/InputStream:close	()V
    //   1321: goto +3 -> 1324
    //   1324: aload 14
    //   1326: ifnull +8 -> 1334
    //   1329: aload 14
    //   1331: invokevirtual 266	java/io/InputStream:close	()V
    //   1334: aload_3
    //   1335: athrow
    //   1336: new 70	java/lang/StringBuilder
    //   1339: dup
    //   1340: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   1343: astore_2
    //   1344: aload_2
    //   1345: ldc_w 273
    //   1348: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1351: pop
    //   1352: aload_2
    //   1353: lload_0
    //   1354: invokevirtual 88	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1357: pop
    //   1358: aload_2
    //   1359: ldc 163
    //   1361: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: pop
    //   1365: ldc 90
    //   1367: iconst_1
    //   1368: aload_2
    //   1369: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1372: invokestatic 200	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1375: iload 10
    //   1377: ireturn
    //   1378: astore 14
    //   1380: goto -1007 -> 373
    //   1383: astore_3
    //   1384: goto -344 -> 1040
    //   1387: astore_2
    //   1388: goto -337 -> 1051
    //   1391: astore_2
    //   1392: iload 9
    //   1394: istore 10
    //   1396: goto -111 -> 1285
    //   1399: astore_3
    //   1400: goto -140 -> 1260
    //   1403: astore_2
    //   1404: goto -133 -> 1271
    //   1407: astore_2
    //   1408: goto -127 -> 1281
    //   1411: astore_2
    //   1412: goto -101 -> 1311
    //   1415: astore_2
    //   1416: goto -92 -> 1324
    //   1419: astore_2
    //   1420: goto -86 -> 1334
    //   1423: astore_3
    //   1424: goto -351 -> 1073
    //   1427: astore_3
    //   1428: goto -351 -> 1077
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1431	0	paramLong	long
    //   0	1431	2	paramContext	Context
    //   0	1431	3	paramFile	File
    //   0	1431	4	paramString1	String
    //   0	1431	5	paramString2	String
    //   0	1431	6	paramSharedPreferences	SharedPreferences
    //   0	1431	7	paramString3	String
    //   0	1431	8	paramString4	String
    //   0	1431	9	paramBoolean1	boolean
    //   0	1431	10	paramBoolean2	boolean
    //   30	771	11	j	int
    //   655	168	12	l	long
    //   275	1055	14	localObject1	Object
    //   1378	1	14	localFileNotFoundException	java.io.FileNotFoundException
    //   252	1046	15	localObject2	Object
    //   255	1039	16	localObject3	Object
    //   261	1029	17	localObject4	Object
    //   264	380	18	localObject5	Object
    //   258	352	19	localObject6	Object
    //   249	376	20	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   437	490	500	finally
    //   437	490	518	java/io/IOException
    //   559	568	642	java/io/IOException
    //   579	587	642	java/io/IOException
    //   598	609	642	java/io/IOException
    //   620	635	642	java/io/IOException
    //   698	707	722	finally
    //   698	707	726	java/io/IOException
    //   675	688	743	finally
    //   675	688	747	java/io/IOException
    //   837	876	885	java/io/IOException
    //   788	798	1072	finally
    //   815	837	1072	finally
    //   837	876	1072	finally
    //   896	972	1072	finally
    //   981	1020	1072	finally
    //   788	798	1076	java/io/IOException
    //   815	837	1076	java/io/IOException
    //   896	972	1076	java/io/IOException
    //   981	1020	1076	java/io/IOException
    //   657	664	1087	finally
    //   657	664	1101	java/io/IOException
    //   266	292	1119	finally
    //   317	364	1119	finally
    //   373	428	1119	finally
    //   266	292	1133	java/io/IOException
    //   317	364	1133	java/io/IOException
    //   373	428	1133	java/io/IOException
    //   559	568	1288	finally
    //   579	587	1288	finally
    //   598	609	1288	finally
    //   620	635	1288	finally
    //   1158	1167	1288	finally
    //   1178	1187	1288	finally
    //   1198	1205	1288	finally
    //   1216	1224	1288	finally
    //   1235	1247	1288	finally
    //   317	364	1378	java/io/FileNotFoundException
    //   1032	1037	1383	java/io/IOException
    //   1044	1048	1387	java/io/IOException
    //   1060	1065	1391	java/io/IOException
    //   1252	1257	1399	java/io/IOException
    //   1264	1268	1403	java/io/IOException
    //   1276	1281	1407	java/io/IOException
    //   1304	1308	1411	java/io/IOException
    //   1316	1321	1415	java/io/IOException
    //   1329	1334	1419	java/io/IOException
    //   766	779	1423	finally
    //   766	779	1427	java/io/IOException
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
        if (AudioHelper.e())
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
          break label493;
        }
        bool2 = ((File)localObject6).delete();
        if (!QLog.isDevelopLevel()) {
          break label537;
        }
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("LoadExtractedSo, del file ret[");
        ((StringBuilder)localObject6).append(bool2);
        ((StringBuilder)localObject6).append("], seq[");
        ((StringBuilder)localObject6).append(paramLong);
        ((StringBuilder)localObject6).append("]");
        QLog.w("AVSoUtils", 1, ((StringBuilder)localObject6).toString());
        break label537;
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
    label493:
    String str2;
    label537:
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
      label861:
      label868:
      break label861;
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
      break label868;
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
    ((HashMap)localObject4).put("msg1", d(str1));
    ((HashMap)localObject4).put("msg2", d(localObject8));
    ((HashMap)localObject4).put("msg3", d(str2));
    ((HashMap)localObject4).put("msg4", d((String)localObject1));
    ((HashMap)localObject4).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    ((HashMap)localObject4).put("man", d(Build.MANUFACTURER));
    ((HashMap)localObject4).put("mod", d(Build.MODEL));
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
  
  static void b(String paramString)
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
  
  public static boolean b(long paramLong, Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("so_sp", 4);
      String str1 = e();
      String str2 = e(paramString);
      String str3 = localSharedPreferences.getString(str2, f());
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
  
  public static String c(String paramString)
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
  
  public static void c()
  {
    if (!AutomatorHelper.b) {
      return;
    }
    int j;
    if (VcSystemInfo.getCpuArchitecture() <= 2) {
      j = 1;
    } else {
      j = 0;
    }
    String str = b();
    if (j != 0)
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
      b(localStringBuilder.toString());
    }
  }
  
  public static String d(String paramString)
  {
    return paramString.replace("=", "@1").replace("&", "@2").replace("|", "@3").replace("\"", "@6");
  }
  
  public static void d()
  {
    String str = b();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("DecodeSo");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libTcHevcDec.so");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libTcHevcDec2.so");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libtraeimp-qq.so");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libqav_graphics.so");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libqav_gaudio_engine.so");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libqav_utils.so");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libqav_media_engine.so");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libSDKCommon.so");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libVideoCtrl.so");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libxplatform.so");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libc++_shared.so");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
    str = GifSoLoader.a(BaseApplication.getContext());
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("printSO, ");
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append("libc++_shared.so");
    localStringBuilder1.append(c(localStringBuilder2.toString()));
    QLog.w("AVSoUtils", 1, localStringBuilder1.toString());
  }
  
  public static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppSetting.i());
    localStringBuilder.append(SoLoadUtil.c());
    return localStringBuilder.toString();
  }
  
  public static String e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_so_version_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-1");
    localStringBuilder.append(SoLoadUtil.c());
    return localStringBuilder.toString();
  }
  
  public static boolean f(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append(SoLoadUtil.c());
      if (!TextUtils.equals(paramString, localStringBuilder.toString())) {
        return false;
      }
    }
    return true;
  }
  
  public static LoadExtResult g(String paramString)
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
  
  public static boolean g()
  {
    LoadExtResult localLoadExtResult = g("TcHevcDec");
    return (localLoadExtResult != null) && (localLoadExtResult.isSucc());
  }
  
  public static String h()
  {
    return b;
  }
  
  public static String i()
  {
    return c;
  }
  
  public static String j()
  {
    return d;
  }
  
  public static void k()
  {
    if ((!TextUtils.isEmpty(h())) && (!TextUtils.isEmpty(i())))
    {
      ThreadManager.excute(new AVSoUtils.1(), 16, null, false);
      return;
    }
    q();
    r();
  }
  
  public static boolean l()
  {
    if (g) {
      return true;
    }
    try
    {
      if (s())
      {
        Object localObject = BaseApplication.getContext();
        if (TextUtils.isEmpty(e))
        {
          a(0L, (Context)localObject, "VideoCtrl", true);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(e);
          ((StringBuilder)localObject).append(a("VideoCtrl"));
          System.load(((StringBuilder)localObject).toString());
        }
        g = true;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadDAVEngineSo successfully. sDownloadedAVSDKSoDir = ");
        ((StringBuilder)localObject).append(e);
        QLog.i("AVSoUtils", 1, ((StringBuilder)localObject).toString(), new Throwable("打印调用栈"));
      }
      else
      {
        g = false;
        QLog.e("AVSoUtils", 1, "loadDAVEngineSo failed.", new Throwable("打印调用栈"));
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadDAVEngineSo failed. err = ");
      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
      QLog.e("AVSoUtils", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      g = false;
    }
    return g;
  }
  
  public static boolean m()
  {
    if (h) {
      return true;
    }
    try
    {
      if ((s()) && (l()))
      {
        Object localObject = BaseApplication.getContext();
        boolean bool = TextUtils.isEmpty(e);
        if (bool)
        {
          a((Context)localObject, "qav_media_engine", true);
          a(0L, (Context)localObject, "qav_gaudio_engine", true);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(e);
          ((StringBuilder)localObject).append(a("qav_media_engine"));
          System.load(((StringBuilder)localObject).toString());
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(e);
          ((StringBuilder)localObject).append(a("qav_gaudio_engine"));
          System.load(((StringBuilder)localObject).toString());
        }
        h = true;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadMAVEngineSo successfully. sDownloadedAVSDKSoDir = ");
        ((StringBuilder)localObject).append(e);
        QLog.i("AVSoUtils", 1, ((StringBuilder)localObject).toString(), new Throwable("打印调用栈"));
      }
      else
      {
        h = false;
        QLog.e("AVSoUtils", 1, "loadMAVEngineSo failed.", new Throwable("打印调用栈"));
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMAVEngineSo failed. err = ");
      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
      QLog.e("AVSoUtils", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      h = false;
    }
    return h;
  }
  
  public static boolean n()
  {
    if (i) {
      return true;
    }
    try
    {
      if (s())
      {
        Object localObject = BaseApplication.getContext();
        if (TextUtils.isEmpty(e))
        {
          a(0L, (Context)localObject, "qav_graphics", true);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(e);
          ((StringBuilder)localObject).append(a("qav_graphics"));
          System.load(((StringBuilder)localObject).toString());
        }
        i = true;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadAVRenderSo successfully. sDownloadedAVSDKSoDir = ");
        ((StringBuilder)localObject).append(e);
        QLog.i("AVSoUtils", 1, ((StringBuilder)localObject).toString(), new Throwable("打印调用栈"));
      }
      else
      {
        i = false;
        QLog.e("AVSoUtils", 1, "loadAVRenderSo failed.", new Throwable("打印调用栈"));
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadAVRenderSo failed. err = ");
      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
      QLog.e("AVSoUtils", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
      i = false;
    }
    return i;
  }
  
  private static boolean q()
  {
    Object localObject1 = g("TcHevcEnc");
    boolean bool;
    if ((localObject1 != null) && (((LoadExtResult)localObject1).isSucc())) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      Object localObject2 = ((LoadExtResult)localObject1).getSoLoadPath("TcHevcEnc");
      localObject1 = b;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        b = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(File.separator));
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadAndDownloadSo. new HevcEncSoDir = ");
      ((StringBuilder)localObject2).append(b);
      ((StringBuilder)localObject2).append(", old HevcEncSoDir = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("AVSoUtils", 1, ((StringBuilder)localObject2).toString());
    }
    return bool;
  }
  
  private static boolean r()
  {
    Object localObject1 = g("TcHevcDec2");
    boolean bool;
    if ((localObject1 != null) && (((LoadExtResult)localObject1).isSucc())) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      Object localObject2 = ((LoadExtResult)localObject1).getSoLoadPath("TcHevcDec2");
      localObject1 = c;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        c = ((String)localObject2).substring(0, ((String)localObject2).lastIndexOf(File.separator));
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadAndDownloadSo. new HevcDecSoDir = ");
      ((StringBuilder)localObject2).append(c);
      ((StringBuilder)localObject2).append(", old HevcDecSoDir = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("AVSoUtils", 1, ((StringBuilder)localObject2).toString());
    }
    return bool;
  }
  
  private static boolean s()
  {
    if (f) {
      return true;
    }
    try
    {
      Object localObject = BaseApplication.getContext();
      SoLoadUtil.a((Context)localObject, "c++_shared", 0, false);
      SoLoadUtil.a((Context)localObject, "xplatform", 0, false);
      ResMgr.a();
      e = ResMgr.i();
      if (TextUtils.isEmpty(e))
      {
        a(0L, (Context)localObject, "SDKCommon", true);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(e);
        ((StringBuilder)localObject).append(a("SDKCommon"));
        System.load(((StringBuilder)localObject).toString());
      }
      f = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadAVBaseSo successfully. sDownloadedAVSDKSoDir = ");
      ((StringBuilder)localObject).append(e);
      QLog.i("AVSoUtils", 1, ((StringBuilder)localObject).toString(), new Throwable("打印调用栈"));
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      f = false;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadAVBaseSo failed. err = ");
      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
      QLog.e("AVSoUtils", 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.AVSoUtils
 * JD-Core Version:    0.7.0.1
 */
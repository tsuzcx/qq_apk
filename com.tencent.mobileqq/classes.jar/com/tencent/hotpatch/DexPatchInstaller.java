package com.tencent.hotpatch;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.mobileqq.app.SystemClassLoaderInjector;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
import com.tencent.mobileqq.msf.core.net.patch.PatchReporter;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.utils.SoLoadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.zip.ZipEntry;

public class DexPatchInstaller
{
  public static int a = 0;
  public static String a = "";
  
  private static int a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt != 5) {
                return paramInt + 10000;
              }
              return 807;
            }
            return 802;
          }
          return 801;
        }
        return 805;
      }
      return 803;
    }
    return 800;
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private static int a(Context paramContext, PatchConfig paramPatchConfig)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore 4
    //   10: aload_1
    //   11: invokevirtual 31	com/tencent/hotpatch/config/PatchConfig:b	()Ljava/lang/String;
    //   14: invokestatic 37	com/tencent/mobileqq/msf/core/net/patch/PatchCommonUtil:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   17: astore 7
    //   19: aload 5
    //   21: astore 4
    //   23: new 39	java/io/File
    //   26: dup
    //   27: aload 7
    //   29: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokevirtual 45	java/io/File:getParent	()Ljava/lang/String;
    //   35: astore 8
    //   37: aload 5
    //   39: astore 4
    //   41: new 47	com/tencent/commonsdk/zip/QZipFile
    //   44: dup
    //   45: aload 7
    //   47: invokespecial 48	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   50: astore 5
    //   52: aload 5
    //   54: ldc 50
    //   56: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   59: astore 4
    //   61: new 39	java/io/File
    //   64: dup
    //   65: aload 8
    //   67: ldc 50
    //   69: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: astore 6
    //   74: aload 4
    //   76: ifnull +211 -> 287
    //   79: aload 6
    //   81: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   84: aload 4
    //   86: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   89: lcmp
    //   90: ifne +14 -> 104
    //   93: ldc 71
    //   95: iconst_1
    //   96: ldc 73
    //   98: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: goto +144 -> 245
    //   104: new 39	java/io/File
    //   107: dup
    //   108: aload 8
    //   110: ldc 81
    //   112: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: astore 7
    //   117: aload 7
    //   119: invokevirtual 85	java/io/File:exists	()Z
    //   122: ifeq +38 -> 160
    //   125: aload 7
    //   127: aload 6
    //   129: invokevirtual 89	java/io/File:renameTo	(Ljava/io/File;)Z
    //   132: ifeq +28 -> 160
    //   135: aload 6
    //   137: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   140: aload 4
    //   142: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   145: lcmp
    //   146: ifne +14 -> 160
    //   149: ldc 71
    //   151: iconst_1
    //   152: ldc 91
    //   154: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: goto +88 -> 245
    //   160: iconst_0
    //   161: istore_2
    //   162: iload_2
    //   163: iconst_3
    //   164: if_icmpge +66 -> 230
    //   167: aload 5
    //   169: aload 4
    //   171: invokevirtual 95	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   174: aload 6
    //   176: invokestatic 98	com/tencent/hotpatch/DexPatchInstaller:a	(Ljava/io/InputStream;Ljava/io/File;)V
    //   179: goto +17 -> 196
    //   182: astore 7
    //   184: ldc 71
    //   186: iconst_1
    //   187: aload 7
    //   189: iconst_0
    //   190: anewarray 4	java/lang/Object
    //   193: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   196: aload 6
    //   198: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   201: aload 4
    //   203: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   206: lcmp
    //   207: ifne +16 -> 223
    //   210: ldc 71
    //   212: iconst_1
    //   213: ldc 103
    //   215: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: iconst_1
    //   219: istore_2
    //   220: goto +12 -> 232
    //   223: iload_2
    //   224: iconst_1
    //   225: iadd
    //   226: istore_2
    //   227: goto -65 -> 162
    //   230: iconst_0
    //   231: istore_2
    //   232: iload_2
    //   233: ifne +12 -> 245
    //   236: aload 5
    //   238: invokevirtual 106	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   241: sipush 802
    //   244: ireturn
    //   245: aload 6
    //   247: invokevirtual 109	java/io/File:getPath	()Ljava/lang/String;
    //   250: invokestatic 114	java/lang/System:load	(Ljava/lang/String;)V
    //   253: ldc 71
    //   255: iconst_1
    //   256: ldc 116
    //   258: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: iconst_1
    //   262: istore_3
    //   263: goto +26 -> 289
    //   266: astore_0
    //   267: ldc 71
    //   269: iconst_1
    //   270: aload_0
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   278: aload 5
    //   280: invokevirtual 106	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   283: sipush 806
    //   286: ireturn
    //   287: iconst_0
    //   288: istore_3
    //   289: aload 5
    //   291: ldc 118
    //   293: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   296: astore 9
    //   298: aload 5
    //   300: ldc 120
    //   302: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   305: astore 6
    //   307: aload 5
    //   309: ldc 122
    //   311: invokevirtual 54	com/tencent/commonsdk/zip/QZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   314: astore 4
    //   316: aload 9
    //   318: ifnull +304 -> 622
    //   321: aload 6
    //   323: ifnull +299 -> 622
    //   326: aload 4
    //   328: ifnull +294 -> 622
    //   331: new 39	java/io/File
    //   334: dup
    //   335: aload 8
    //   337: ldc 118
    //   339: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: astore 10
    //   344: new 39	java/io/File
    //   347: dup
    //   348: aload 8
    //   350: ldc 120
    //   352: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   355: astore 7
    //   357: new 39	java/io/File
    //   360: dup
    //   361: aload 8
    //   363: ldc 122
    //   365: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: astore 8
    //   370: aload_1
    //   371: invokevirtual 125	com/tencent/hotpatch/config/PatchConfig:c	()Z
    //   374: ifne +357 -> 731
    //   377: aload 10
    //   379: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   382: aload 9
    //   384: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   387: lcmp
    //   388: ifne +16 -> 404
    //   391: new 127	java/io/FileInputStream
    //   394: dup
    //   395: aload 10
    //   397: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   400: astore_1
    //   401: goto +324 -> 725
    //   404: ldc 71
    //   406: iconst_1
    //   407: ldc 132
    //   409: invokestatic 135	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: aload 5
    //   414: aload 9
    //   416: invokevirtual 95	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   419: astore_1
    //   420: goto +305 -> 725
    //   423: aload 8
    //   425: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   428: aload 4
    //   430: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   433: lcmp
    //   434: ifne +17 -> 451
    //   437: new 127	java/io/FileInputStream
    //   440: dup
    //   441: aload 8
    //   443: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   446: astore 4
    //   448: goto +280 -> 728
    //   451: ldc 71
    //   453: iconst_1
    //   454: ldc 137
    //   456: invokestatic 135	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   459: aload 5
    //   461: aload 4
    //   463: invokevirtual 95	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   466: astore 4
    //   468: goto +260 -> 728
    //   471: aload 7
    //   473: invokestatic 63	com/tencent/mobileqq/pluginsdk/IOUtil:getCRC32Value	(Ljava/io/File;)J
    //   476: aload 6
    //   478: invokevirtual 69	java/util/zip/ZipEntry:getCrc	()J
    //   481: lcmp
    //   482: ifne +17 -> 499
    //   485: new 127	java/io/FileInputStream
    //   488: dup
    //   489: aload 7
    //   491: invokespecial 130	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   494: astore 6
    //   496: goto +243 -> 739
    //   499: ldc 71
    //   501: iconst_1
    //   502: ldc 139
    //   504: invokestatic 135	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: aload 5
    //   509: aload 6
    //   511: invokevirtual 95	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   514: astore 6
    //   516: goto +223 -> 739
    //   519: invokestatic 141	com/tencent/hotpatch/DexPatchInstaller:a	()Z
    //   522: ifne +19 -> 541
    //   525: aload_1
    //   526: aload 4
    //   528: aload 6
    //   530: iload_3
    //   531: aconst_null
    //   532: aconst_null
    //   533: iconst_0
    //   534: invokestatic 147	com/tencent/mobileqq/qfix/Relax:apply	(Ljava/io/InputStream;Ljava/io/InputStream;Ljava/io/InputStream;ZLjava/io/File;Ljava/io/File;Z)I
    //   537: istore_2
    //   538: goto +72 -> 610
    //   541: new 149	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   548: astore 7
    //   550: aload 7
    //   552: ldc 152
    //   554: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 7
    //   560: ldc 158
    //   562: invokestatic 37	com/tencent/mobileqq/msf/core/net/patch/PatchCommonUtil:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   565: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: ldc 71
    //   571: iconst_1
    //   572: aload 7
    //   574: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   577: invokestatic 79	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: aload_1
    //   581: aload 4
    //   583: aload 6
    //   585: iload_3
    //   586: new 39	java/io/File
    //   589: dup
    //   590: ldc 158
    //   592: invokestatic 37	com/tencent/mobileqq/msf/core/net/patch/PatchCommonUtil:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   595: invokespecial 42	java/io/File:<init>	(Ljava/lang/String;)V
    //   598: aload_0
    //   599: ldc 163
    //   601: iconst_0
    //   602: invokevirtual 169	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   605: iconst_1
    //   606: invokestatic 147	com/tencent/mobileqq/qfix/Relax:apply	(Ljava/io/InputStream;Ljava/io/InputStream;Ljava/io/InputStream;ZLjava/io/File;Ljava/io/File;Z)I
    //   609: istore_2
    //   610: iload_2
    //   611: invokestatic 171	com/tencent/hotpatch/DexPatchInstaller:a	(I)I
    //   614: istore_2
    //   615: aload 5
    //   617: invokevirtual 106	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   620: iload_2
    //   621: ireturn
    //   622: aload 5
    //   624: invokevirtual 106	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   627: sipush 804
    //   630: ireturn
    //   631: astore_0
    //   632: aload 5
    //   634: astore 4
    //   636: goto +44 -> 680
    //   639: astore_1
    //   640: aload 5
    //   642: astore_0
    //   643: goto +11 -> 654
    //   646: astore_0
    //   647: goto +33 -> 680
    //   650: astore_1
    //   651: aload 6
    //   653: astore_0
    //   654: aload_0
    //   655: astore 4
    //   657: ldc 71
    //   659: iconst_1
    //   660: aload_1
    //   661: iconst_0
    //   662: anewarray 4	java/lang/Object
    //   665: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   668: aload_0
    //   669: ifnull +7 -> 676
    //   672: aload_0
    //   673: invokevirtual 106	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   676: sipush 802
    //   679: ireturn
    //   680: aload 4
    //   682: ifnull +8 -> 690
    //   685: aload 4
    //   687: invokevirtual 106	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   690: goto +5 -> 695
    //   693: aload_0
    //   694: athrow
    //   695: goto -2 -> 693
    //   698: astore_0
    //   699: sipush 802
    //   702: ireturn
    //   703: astore_0
    //   704: sipush 806
    //   707: ireturn
    //   708: astore_0
    //   709: iload_2
    //   710: ireturn
    //   711: astore_0
    //   712: sipush 804
    //   715: ireturn
    //   716: astore_0
    //   717: sipush 802
    //   720: ireturn
    //   721: astore_1
    //   722: goto -32 -> 690
    //   725: goto -302 -> 423
    //   728: goto -257 -> 471
    //   731: aconst_null
    //   732: astore_1
    //   733: aload_1
    //   734: astore 4
    //   736: goto -265 -> 471
    //   739: goto -220 -> 519
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	742	0	paramContext	Context
    //   0	742	1	paramPatchConfig	PatchConfig
    //   161	549	2	i	int
    //   262	324	3	bool	boolean
    //   8	727	4	localObject1	Object
    //   4	637	5	localQZipFile	QZipFile
    //   1	651	6	localObject2	Object
    //   17	109	7	localObject3	Object
    //   182	6	7	localThrowable	Throwable
    //   355	218	7	localObject4	Object
    //   35	407	8	localObject5	Object
    //   296	119	9	localZipEntry	ZipEntry
    //   342	54	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   167	179	182	java/lang/Throwable
    //   245	261	266	java/lang/Throwable
    //   52	74	631	finally
    //   79	101	631	finally
    //   104	157	631	finally
    //   167	179	631	finally
    //   184	196	631	finally
    //   196	218	631	finally
    //   245	261	631	finally
    //   267	278	631	finally
    //   289	316	631	finally
    //   331	401	631	finally
    //   404	420	631	finally
    //   423	448	631	finally
    //   451	468	631	finally
    //   471	496	631	finally
    //   499	516	631	finally
    //   519	538	631	finally
    //   541	610	631	finally
    //   610	615	631	finally
    //   52	74	639	java/lang/Throwable
    //   79	101	639	java/lang/Throwable
    //   104	157	639	java/lang/Throwable
    //   184	196	639	java/lang/Throwable
    //   196	218	639	java/lang/Throwable
    //   267	278	639	java/lang/Throwable
    //   289	316	639	java/lang/Throwable
    //   331	401	639	java/lang/Throwable
    //   404	420	639	java/lang/Throwable
    //   423	448	639	java/lang/Throwable
    //   451	468	639	java/lang/Throwable
    //   471	496	639	java/lang/Throwable
    //   499	516	639	java/lang/Throwable
    //   519	538	639	java/lang/Throwable
    //   541	610	639	java/lang/Throwable
    //   610	615	639	java/lang/Throwable
    //   10	19	646	finally
    //   23	37	646	finally
    //   41	52	646	finally
    //   657	668	646	finally
    //   10	19	650	java/lang/Throwable
    //   23	37	650	java/lang/Throwable
    //   41	52	650	java/lang/Throwable
    //   236	241	698	java/io/IOException
    //   278	283	703	java/io/IOException
    //   615	620	708	java/io/IOException
    //   622	627	711	java/io/IOException
    //   672	676	716	java/io/IOException
    //   685	690	721	java/io/IOException
  }
  
  private static String a()
  {
    String str = "";
    Object localObject = str;
    try
    {
      if (Build.VERSION.SDK_INT <= 28) {
        if (Build.VERSION.SDK_INT >= 23)
        {
          localObject = str;
          if (BaseApplicationImpl.getApplication().checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {}
        }
        else
        {
          if (Build.VERSION.SDK_INT < 23) {
            return "";
          }
          localObject = (TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone");
          if (Build.VERSION.SDK_INT < 26) {
            return ((TelephonyManager)localObject).getDeviceId();
          }
          localObject = ((TelephonyManager)localObject).getImei();
        }
      }
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static void a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    PatchConfig localPatchConfig = PatchConfigManager.a(paramContext, "dex");
    if ((jdField_a_of_type_Int == 0) && (a(paramContext, localPatchConfig)))
    {
      String str = a();
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("66666")))
      {
        QLog.w("PatchLogTag", 1, "running on a game assist vbox, skip patching");
        return;
      }
      a(localPatchConfig);
      if (jdField_a_of_type_Int == 500)
      {
        if ((localPatchConfig.b()) && (PatchCommonUtil.isArtGeN()) && (!SoLoadUtil.a()))
        {
          i = a(paramContext, localPatchConfig);
          if (i == 807)
          {
            QLog.d("PatchLogTag", 1, "inject failed");
            jdField_a_of_type_Int = 0;
            jdField_a_of_type_JavaLangString = "";
          }
          else if (i != 800)
          {
            str = SystemClassLoaderInjector.a(BaseApplicationImpl.sApplication, 0);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("applyRelaxPatch failed, unloadResult=");
            localStringBuilder.append(str);
            QLog.d("PatchLogTag", 1, localStringBuilder.toString());
            if ("Success".equals(str))
            {
              jdField_a_of_type_Int = 0;
              jdField_a_of_type_JavaLangString = "";
            }
          }
          break label217;
        }
        if (PatchCommonUtil.isDalvik()) {
          PatchResolveForDalvik.a(paramContext, localPatchConfig);
        }
      }
      int i = 0;
      label217:
      a(paramContext, localPatchConfig);
      PatchReporter.reportPatchEvent(paramContext, "", "actPatchInstall", jdField_a_of_type_Int, localPatchConfig.b(), i);
      paramContext = new StringBuilder();
      paramContext.append("DexPatchInstaller installDexPatch total cost time=");
      paramContext.append(System.currentTimeMillis() - l);
      paramContext.append(" ms.");
      QLog.d("PatchLogTag", 1, paramContext.toString());
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("DexPatchInstaller installDexPatch Not inject patch, status=");
    paramContext.append(jdField_a_of_type_Int);
    QLog.d("PatchLogTag", 1, paramContext.toString());
  }
  
  private static void a(Context paramContext, PatchConfig paramPatchConfig)
  {
    paramContext = new DexPatchInstaller.1(paramPatchConfig, paramContext);
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(paramContext, 5, null, true);
      return;
    }
    paramContext.run();
  }
  
  private static void a(PatchConfig paramPatchConfig)
  {
    long l = System.currentTimeMillis();
    paramPatchConfig = paramPatchConfig.b();
    Object localObject = PatchCommonUtil.getPatchPath(paramPatchConfig);
    try
    {
      if (a())
      {
        paramPatchConfig = new QZipFile((String)localObject);
        localObject = new File((String)localObject).getParent();
        ZipEntry localZipEntry = paramPatchConfig.getEntry("classes.dex");
        File localFile = new File((String)localObject, "classes.dex");
        if ((!localFile.exists()) || (IOUtil.getCRC32Value(localFile) != localZipEntry.getCrc()))
        {
          QLog.d("PatchLogTag", 1, "unzip dex");
          PatchDownloadManager.a(paramPatchConfig, (String)localObject);
        }
        jdField_a_of_type_Int = 500;
        QLog.d("PatchLogTag", 1, "inject by qfix");
      }
      else if ("Success".equals(SystemClassLoaderInjector.a(BaseApplicationImpl.sApplication, (String)localObject, null, false)))
      {
        jdField_a_of_type_Int = 500;
        jdField_a_of_type_JavaLangString = paramPatchConfig;
      }
      else
      {
        jdField_a_of_type_Int = 501;
      }
    }
    catch (Throwable paramPatchConfig)
    {
      jdField_a_of_type_Int = 502;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DexPatchInstaller injectDexPatch throwable=");
      ((StringBuilder)localObject).append(paramPatchConfig);
      QLog.d("PatchLogTag", 1, ((StringBuilder)localObject).toString());
    }
    paramPatchConfig = new StringBuilder();
    paramPatchConfig.append("DexPatchInstaller injectDexPatch result=");
    paramPatchConfig.append(jdField_a_of_type_Int);
    paramPatchConfig.append(", inject cost time=");
    paramPatchConfig.append(System.currentTimeMillis() - l);
    paramPatchConfig.append(" ms.");
    QLog.d("PatchLogTag", 1, paramPatchConfig.toString());
  }
  
  /* Error */
  public static void a(java.io.InputStream paramInputStream, File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 358	java/io/File:getParentFile	()Ljava/io/File;
    //   4: invokevirtual 361	java/io/File:mkdirs	()Z
    //   7: pop
    //   8: new 363	java/io/FileOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 364	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   16: astore_3
    //   17: sipush 4096
    //   20: newarray byte
    //   22: astore_1
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 370	java/io/InputStream:read	([B)I
    //   28: istore_2
    //   29: iload_2
    //   30: ifle +13 -> 43
    //   33: aload_3
    //   34: aload_1
    //   35: iconst_0
    //   36: iload_2
    //   37: invokevirtual 376	java/io/OutputStream:write	([BII)V
    //   40: goto -17 -> 23
    //   43: aload_0
    //   44: ifnull +7 -> 51
    //   47: aload_0
    //   48: invokevirtual 377	java/io/InputStream:close	()V
    //   51: aload_3
    //   52: invokevirtual 378	java/io/OutputStream:close	()V
    //   55: return
    //   56: astore_1
    //   57: goto +6 -> 63
    //   60: astore_1
    //   61: aconst_null
    //   62: astore_3
    //   63: aload_0
    //   64: ifnull +10 -> 74
    //   67: aload_0
    //   68: invokevirtual 377	java/io/InputStream:close	()V
    //   71: goto +3 -> 74
    //   74: aload_3
    //   75: ifnull +7 -> 82
    //   78: aload_3
    //   79: invokevirtual 378	java/io/OutputStream:close	()V
    //   82: goto +5 -> 87
    //   85: aload_1
    //   86: athrow
    //   87: goto -2 -> 85
    //   90: astore_0
    //   91: goto -40 -> 51
    //   94: astore_0
    //   95: return
    //   96: astore_0
    //   97: goto -23 -> 74
    //   100: astore_0
    //   101: goto -19 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramInputStream	java.io.InputStream
    //   0	104	1	paramFile	File
    //   28	9	2	i	int
    //   16	63	3	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   17	23	56	finally
    //   23	29	56	finally
    //   33	40	56	finally
    //   8	17	60	finally
    //   47	51	90	java/io/IOException
    //   51	55	94	java/io/IOException
    //   67	71	96	java/io/IOException
    //   78	82	100	java/io/IOException
  }
  
  static boolean a()
  {
    return Build.VERSION.SDK_INT >= 30;
  }
  
  private static boolean a(Context paramContext, PatchConfig paramPatchConfig)
  {
    if (paramPatchConfig == null)
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus patch config is null");
      return false;
    }
    if (!paramPatchConfig.a(paramContext, BaseApplicationImpl.processName)) {
      return false;
    }
    String str = paramPatchConfig.b();
    File localFile = new File(PatchCommonUtil.getPatchPath(str));
    if (!localFile.exists())
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus patch file not exist");
      return false;
    }
    if (localFile.length() != paramPatchConfig.b())
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus patch file length not match");
      return false;
    }
    if (!PatchSharedPreUtil.getPatchVerifyStatus(paramContext, str))
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus verify failed");
      return false;
    }
    if (PatchSharedPreUtil.getCountFailInstallPatch(paramContext, BaseApplicationImpl.processName, str) >= 3)
    {
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus install patch failed max count");
      return false;
    }
    if (PatchSharedPreUtil.getCountFailStartupPatch(paramContext, BaseApplicationImpl.processName, str) > 5)
    {
      jdField_a_of_type_Int = 503;
      PatchReporter.reportPatchEvent(paramContext, "", "actPatchInstall", 503, str);
      QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus start failed max count as install patch");
      return false;
    }
    QLog.d("PatchLogTag", 1, "DexPatchInstaller checkDexPatchConfigAndStatus return true");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hotpatch.DexPatchInstaller
 * JD-Core Version:    0.7.0.1
 */
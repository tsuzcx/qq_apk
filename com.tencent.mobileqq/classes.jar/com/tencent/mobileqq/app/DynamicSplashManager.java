package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.FileUtils;
import java.io.File;
import oicq.wlogin_sdk.tools.MD5;

public class DynamicSplashManager
{
  public static boolean a(int paramInt)
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (i == 2) {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G2");
      }
    }
    do
    {
      i = 0;
      break;
      if (i == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G3");
        }
        i = 10;
        break;
      }
      if (i == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.G4");
        }
        i = 20;
        break;
      }
    } while (i != 1);
    if (QLog.isColorLevel()) {
      QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() userNetworkType == NetType.WIFI");
    }
    i = 100;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseDynamicSplashXMLConfig() userNetworkValue == ");
      localStringBuilder.append(i);
      QLog.d("DynamicSplashManager", 2, localStringBuilder.toString());
    }
    if (i < paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() user network NOT allow download, return");
      }
      return true;
    }
    return false;
  }
  
  /* Error */
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 31
    //   8: iconst_2
    //   9: ldc 66
    //   11: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: new 45	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   21: astore 7
    //   23: aload 7
    //   25: invokestatic 69	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   28: invokevirtual 73	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   31: invokevirtual 78	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   34: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 7
    //   40: ldc 80
    //   42: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 7
    //   48: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 7
    //   53: new 75	java/io/File
    //   56: dup
    //   57: aload 7
    //   59: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore 8
    //   64: aload 8
    //   66: invokevirtual 86	java/io/File:exists	()Z
    //   69: ifne +12 -> 81
    //   72: aload 8
    //   74: invokevirtual 89	java/io/File:mkdirs	()Z
    //   77: pop
    //   78: goto +64 -> 142
    //   81: aload 8
    //   83: invokevirtual 92	java/io/File:isDirectory	()Z
    //   86: ifeq +56 -> 142
    //   89: aload 8
    //   91: invokevirtual 96	java/io/File:listFiles	()[Ljava/io/File;
    //   94: astore 8
    //   96: aload 8
    //   98: ifnull +44 -> 142
    //   101: aload 8
    //   103: arraylength
    //   104: istore 4
    //   106: iconst_0
    //   107: istore_3
    //   108: iload_3
    //   109: iload 4
    //   111: if_icmpge +31 -> 142
    //   114: aload 8
    //   116: iload_3
    //   117: aaload
    //   118: astore 9
    //   120: aload 9
    //   122: ifnull +660 -> 782
    //   125: aload 9
    //   127: invokevirtual 86	java/io/File:exists	()Z
    //   130: ifeq +652 -> 782
    //   133: aload 9
    //   135: invokevirtual 99	java/io/File:delete	()Z
    //   138: pop
    //   139: goto +643 -> 782
    //   142: invokestatic 105	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   145: invokevirtual 109	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   148: new 111	java/io/ByteArrayInputStream
    //   151: dup
    //   152: aload_1
    //   153: ldc 113
    //   155: invokevirtual 119	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   158: invokespecial 122	java/io/ByteArrayInputStream:<init>	([B)V
    //   161: invokevirtual 128	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   164: astore 12
    //   166: aload 12
    //   168: ldc 130
    //   170: invokeinterface 136 2 0
    //   175: invokeinterface 142 1 0
    //   180: iconst_1
    //   181: if_icmpge +5 -> 186
    //   184: iconst_0
    //   185: ireturn
    //   186: new 144	java/text/SimpleDateFormat
    //   189: dup
    //   190: ldc 146
    //   192: invokespecial 147	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   195: astore 9
    //   197: aload 12
    //   199: ldc 149
    //   201: invokeinterface 136 2 0
    //   206: iconst_0
    //   207: invokeinterface 153 2 0
    //   212: invokeinterface 159 1 0
    //   217: invokeinterface 162 1 0
    //   222: astore_1
    //   223: aload 12
    //   225: ldc 164
    //   227: invokeinterface 136 2 0
    //   232: iconst_0
    //   233: invokeinterface 153 2 0
    //   238: invokeinterface 159 1 0
    //   243: invokeinterface 162 1 0
    //   248: astore 11
    //   250: aload 12
    //   252: ldc 166
    //   254: invokeinterface 136 2 0
    //   259: iconst_0
    //   260: invokeinterface 153 2 0
    //   265: invokeinterface 159 1 0
    //   270: invokeinterface 162 1 0
    //   275: astore 10
    //   277: aload 12
    //   279: ldc 168
    //   281: invokeinterface 136 2 0
    //   286: iconst_0
    //   287: invokeinterface 153 2 0
    //   292: invokeinterface 159 1 0
    //   297: invokeinterface 162 1 0
    //   302: astore 8
    //   304: aload 12
    //   306: ldc 170
    //   308: invokeinterface 136 2 0
    //   313: iconst_0
    //   314: invokeinterface 153 2 0
    //   319: invokeinterface 159 1 0
    //   324: invokeinterface 162 1 0
    //   329: invokestatic 176	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   332: invokevirtual 179	java/lang/Integer:intValue	()I
    //   335: istore_3
    //   336: aload 12
    //   338: ldc 181
    //   340: invokeinterface 136 2 0
    //   345: iconst_0
    //   346: invokeinterface 153 2 0
    //   351: invokeinterface 159 1 0
    //   356: invokeinterface 162 1 0
    //   361: invokestatic 176	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   364: invokevirtual 179	java/lang/Integer:intValue	()I
    //   367: istore 4
    //   369: aload 12
    //   371: ldc 183
    //   373: invokeinterface 136 2 0
    //   378: iconst_0
    //   379: invokeinterface 153 2 0
    //   384: invokeinterface 159 1 0
    //   389: invokeinterface 162 1 0
    //   394: invokestatic 176	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   397: invokevirtual 179	java/lang/Integer:intValue	()I
    //   400: istore 5
    //   402: aload 12
    //   404: ldc 185
    //   406: invokeinterface 136 2 0
    //   411: iconst_0
    //   412: invokeinterface 153 2 0
    //   417: invokeinterface 159 1 0
    //   422: invokeinterface 162 1 0
    //   427: invokestatic 176	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   430: invokevirtual 179	java/lang/Integer:intValue	()I
    //   433: istore 6
    //   435: new 45	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   442: astore 12
    //   444: aload 9
    //   446: aload 11
    //   448: invokevirtual 188	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   451: astore 11
    //   453: aload 12
    //   455: aload 11
    //   457: invokevirtual 194	java/util/Date:getTime	()J
    //   460: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload 12
    //   466: ldc 199
    //   468: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 12
    //   474: aload 9
    //   476: aload 10
    //   478: invokevirtual 188	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   481: invokevirtual 194	java/util/Date:getTime	()J
    //   484: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 12
    //   490: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: astore 11
    //   495: iload_3
    //   496: invokestatic 201	com/tencent/mobileqq/app/DynamicSplashManager:a	(I)Z
    //   499: ifeq +5 -> 504
    //   502: iconst_0
    //   503: ireturn
    //   504: invokestatic 69	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   507: iload_2
    //   508: iload 4
    //   510: iload 5
    //   512: iload 6
    //   514: aload 8
    //   516: aload 11
    //   518: aload_1
    //   519: invokestatic 206	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   522: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   525: ifeq +264 -> 789
    //   528: ldc 31
    //   530: iconst_2
    //   531: ldc 208
    //   533: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: goto +3 -> 539
    //   539: aload 9
    //   541: aload 10
    //   543: invokevirtual 188	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   546: invokevirtual 194	java/util/Date:getTime	()J
    //   549: invokestatic 213	java/lang/System:currentTimeMillis	()J
    //   552: lcmp
    //   553: ifge +19 -> 572
    //   556: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   559: ifeq +233 -> 792
    //   562: ldc 31
    //   564: iconst_2
    //   565: ldc 215
    //   567: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: iconst_1
    //   571: ireturn
    //   572: new 45	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   579: astore 9
    //   581: aload 9
    //   583: aload 7
    //   585: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 9
    //   591: ldc 217
    //   593: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload 9
    //   599: aload 8
    //   601: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload 9
    //   607: ldc 219
    //   609: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: new 75	java/io/File
    //   616: dup
    //   617: aload 9
    //   619: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   625: astore 9
    //   627: aload_0
    //   628: aload_1
    //   629: aload 9
    //   631: aload 8
    //   633: invokestatic 222	com/tencent/mobileqq/app/DynamicSplashManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)Z
    //   636: ifne +19 -> 655
    //   639: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   642: ifeq +152 -> 794
    //   645: ldc 31
    //   647: iconst_2
    //   648: ldc 224
    //   650: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   653: iconst_0
    //   654: ireturn
    //   655: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   658: ifeq +11 -> 669
    //   661: ldc 31
    //   663: iconst_2
    //   664: ldc 226
    //   666: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: aload 7
    //   671: aload 8
    //   673: aload 9
    //   675: invokestatic 229	com/tencent/mobileqq/app/DynamicSplashManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Z
    //   678: ifeq +5 -> 683
    //   681: iconst_0
    //   682: ireturn
    //   683: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   686: ifeq +43 -> 729
    //   689: new 45	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   696: astore_0
    //   697: aload_0
    //   698: ldc 231
    //   700: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: pop
    //   704: aload_0
    //   705: aload 7
    //   707: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: ldc 31
    //   713: iconst_2
    //   714: aload_0
    //   715: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: ldc 31
    //   723: iconst_2
    //   724: ldc 233
    //   726: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   729: iconst_1
    //   730: ireturn
    //   731: astore_0
    //   732: goto +8 -> 740
    //   735: astore_0
    //   736: goto +4 -> 740
    //   739: astore_0
    //   740: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   743: ifeq +37 -> 780
    //   746: new 45	java/lang/StringBuilder
    //   749: dup
    //   750: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   753: astore_1
    //   754: aload_1
    //   755: ldc 235
    //   757: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload_1
    //   762: aload_0
    //   763: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   766: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: pop
    //   770: ldc 31
    //   772: iconst_2
    //   773: aload_1
    //   774: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   777: invokestatic 241	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   780: iconst_0
    //   781: ireturn
    //   782: iload_3
    //   783: iconst_1
    //   784: iadd
    //   785: istore_3
    //   786: goto -678 -> 108
    //   789: goto -250 -> 539
    //   792: iconst_1
    //   793: ireturn
    //   794: iconst_0
    //   795: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	796	0	paramQQAppInterface	QQAppInterface
    //   0	796	1	paramString	String
    //   0	796	2	paramInt	int
    //   107	679	3	i	int
    //   104	405	4	j	int
    //   400	111	5	k	int
    //   433	80	6	m	int
    //   21	685	7	localObject1	Object
    //   62	610	8	localObject2	Object
    //   118	556	9	localObject3	Object
    //   275	267	10	str	String
    //   248	269	11	localObject4	Object
    //   164	325	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   528	536	731	java/lang/Exception
    //   539	570	731	java/lang/Exception
    //   572	653	731	java/lang/Exception
    //   655	669	731	java/lang/Exception
    //   669	681	731	java/lang/Exception
    //   683	729	731	java/lang/Exception
    //   453	502	735	java/lang/Exception
    //   504	528	735	java/lang/Exception
    //   14	78	739	java/lang/Exception
    //   81	96	739	java/lang/Exception
    //   101	106	739	java/lang/Exception
    //   125	139	739	java/lang/Exception
    //   142	184	739	java/lang/Exception
    //   186	453	739	java/lang/Exception
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString1, File paramFile, String paramString2)
  {
    if ((paramFile != null) && (paramFile.exists()))
    {
      String str = MD5.getFileMD5(paramFile);
      if ((str != null) && (str.equalsIgnoreCase(paramString2))) {
        return true;
      }
      paramFile.delete();
    }
    boolean bool = HttpDownloadUtil.download(paramQQAppInterface, paramString1, paramFile);
    if ((paramFile != null) && (paramFile.exists())) {
      if (bool == true)
      {
        paramQQAppInterface = MD5.getFileMD5(paramFile);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.equalsIgnoreCase(paramString2))) {
          return true;
        }
      }
      else
      {
        paramFile.delete();
      }
    }
    return false;
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 264	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +837 -> 841
    //   7: aload_1
    //   8: invokestatic 264	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aconst_null
    //   17: astore 11
    //   19: aconst_null
    //   20: astore 12
    //   22: aload 12
    //   24: astore 10
    //   26: new 75	java/io/File
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: invokevirtual 86	java/io/File:exists	()Z
    //   37: ifne +18 -> 55
    //   40: aload 12
    //   42: astore 10
    //   44: ldc 31
    //   46: iconst_1
    //   47: ldc_w 266
    //   50: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: iconst_0
    //   54: ireturn
    //   55: aload 12
    //   57: astore 10
    //   59: new 75	java/io/File
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 13
    //   69: aload 12
    //   71: astore 10
    //   73: aload 13
    //   75: invokevirtual 86	java/io/File:exists	()Z
    //   78: ifeq +659 -> 737
    //   81: aload 12
    //   83: astore 10
    //   85: aload 13
    //   87: invokevirtual 92	java/io/File:isDirectory	()Z
    //   90: ifne +6 -> 96
    //   93: goto +644 -> 737
    //   96: aload 12
    //   98: astore 10
    //   100: aload 13
    //   102: invokevirtual 96	java/io/File:listFiles	()[Ljava/io/File;
    //   105: astore 13
    //   107: aload 12
    //   109: astore 10
    //   111: aload 13
    //   113: arraylength
    //   114: istore_3
    //   115: iconst_0
    //   116: istore_2
    //   117: iload_2
    //   118: iload_3
    //   119: if_icmpge +72 -> 191
    //   122: aload 13
    //   124: iload_2
    //   125: aaload
    //   126: astore 14
    //   128: aload 12
    //   130: astore 10
    //   132: new 45	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   139: astore 15
    //   141: aload 12
    //   143: astore 10
    //   145: aload 15
    //   147: ldc_w 268
    //   150: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 12
    //   156: astore 10
    //   158: aload 15
    //   160: aload 14
    //   162: invokevirtual 271	java/io/File:getName	()Ljava/lang/String;
    //   165: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 12
    //   171: astore 10
    //   173: ldc 31
    //   175: iconst_1
    //   176: aload 15
    //   178: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: iload_2
    //   185: iconst_1
    //   186: iadd
    //   187: istore_2
    //   188: goto -71 -> 117
    //   191: aload 12
    //   193: astore 10
    //   195: new 45	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   202: astore 14
    //   204: aload 12
    //   206: astore 10
    //   208: aload 14
    //   210: ldc_w 273
    //   213: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 12
    //   219: astore 10
    //   221: aload 14
    //   223: aload 13
    //   225: arraylength
    //   226: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 12
    //   232: astore 10
    //   234: ldc 31
    //   236: iconst_1
    //   237: aload 14
    //   239: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   245: aload 12
    //   247: astore 10
    //   249: aload 13
    //   251: arraylength
    //   252: ifgt +18 -> 270
    //   255: aload 12
    //   257: astore 10
    //   259: ldc 31
    //   261: iconst_1
    //   262: ldc_w 275
    //   265: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: iconst_0
    //   269: ireturn
    //   270: aload 12
    //   272: astore 10
    //   274: aload 13
    //   276: arraylength
    //   277: iconst_1
    //   278: isub
    //   279: istore 4
    //   281: aload 12
    //   283: astore 10
    //   285: new 45	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   292: astore 13
    //   294: aload 12
    //   296: astore 10
    //   298: aload 13
    //   300: ldc_w 277
    //   303: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 12
    //   309: astore 10
    //   311: aload 13
    //   313: iload 4
    //   315: invokevirtual 55	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 12
    //   321: astore 10
    //   323: ldc 31
    //   325: iconst_1
    //   326: aload 13
    //   328: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: aload 12
    //   336: astore 10
    //   338: new 279	java/io/BufferedReader
    //   341: dup
    //   342: new 281	java/io/InputStreamReader
    //   345: dup
    //   346: new 283	java/io/FileInputStream
    //   349: dup
    //   350: aload_0
    //   351: invokespecial 284	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   354: invokespecial 287	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   357: invokespecial 290	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   360: astore_0
    //   361: iconst_0
    //   362: istore_2
    //   363: aload_0
    //   364: invokevirtual 293	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   367: astore 10
    //   369: aload 10
    //   371: ifnull +310 -> 681
    //   374: new 45	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   381: astore 11
    //   383: aload 11
    //   385: ldc_w 295
    //   388: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 11
    //   394: aload 10
    //   396: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: ldc 31
    //   402: iconst_1
    //   403: aload 11
    //   405: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload 10
    //   413: invokevirtual 298	java/lang/String:length	()I
    //   416: iconst_5
    //   417: if_icmpge +6 -> 423
    //   420: goto +261 -> 681
    //   423: aload 10
    //   425: ldc_w 300
    //   428: invokevirtual 304	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   431: astore 10
    //   433: aload 10
    //   435: arraylength
    //   436: iconst_2
    //   437: if_icmpeq +6 -> 443
    //   440: goto +411 -> 851
    //   443: new 45	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   450: astore 11
    //   452: aload 11
    //   454: aload_1
    //   455: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 11
    //   461: ldc 217
    //   463: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload 11
    //   469: aload 10
    //   471: iconst_0
    //   472: aaload
    //   473: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload 11
    //   479: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: astore 11
    //   484: new 45	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   491: astore 12
    //   493: aload 12
    //   495: ldc_w 306
    //   498: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload 12
    //   504: aload 11
    //   506: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: ldc 31
    //   512: iconst_1
    //   513: aload 12
    //   515: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: new 75	java/io/File
    //   524: dup
    //   525: aload 11
    //   527: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   530: astore 11
    //   532: aload 11
    //   534: invokevirtual 86	java/io/File:exists	()Z
    //   537: ifne +15 -> 552
    //   540: ldc 31
    //   542: iconst_1
    //   543: ldc_w 308
    //   546: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   549: goto +302 -> 851
    //   552: aload 11
    //   554: invokestatic 247	oicq/wlogin_sdk/tools/MD5:getFileMD5	(Ljava/io/File;)Ljava/lang/String;
    //   557: astore 11
    //   559: aload 11
    //   561: ifnull +89 -> 650
    //   564: aload 11
    //   566: invokevirtual 298	java/lang/String:length	()I
    //   569: aload 10
    //   571: iconst_1
    //   572: aaload
    //   573: invokevirtual 298	java/lang/String:length	()I
    //   576: if_icmpeq +74 -> 650
    //   579: aload 11
    //   581: invokevirtual 298	java/lang/String:length	()I
    //   584: istore 5
    //   586: aload 10
    //   588: iconst_1
    //   589: aaload
    //   590: invokevirtual 298	java/lang/String:length	()I
    //   593: istore 6
    //   595: iconst_0
    //   596: istore_3
    //   597: iload_3
    //   598: iload 5
    //   600: iload 6
    //   602: isub
    //   603: if_icmpge +47 -> 650
    //   606: new 45	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   613: astore 12
    //   615: aload 12
    //   617: ldc_w 310
    //   620: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: pop
    //   624: aload 12
    //   626: aload 10
    //   628: iconst_1
    //   629: aaload
    //   630: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: pop
    //   634: aload 10
    //   636: iconst_1
    //   637: aload 12
    //   639: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: aastore
    //   643: iload_3
    //   644: iconst_1
    //   645: iadd
    //   646: istore_3
    //   647: goto -50 -> 597
    //   650: aload 11
    //   652: ifnull +199 -> 851
    //   655: aload 11
    //   657: aload 10
    //   659: iconst_1
    //   660: aaload
    //   661: invokevirtual 251	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   664: istore 7
    //   666: iload 7
    //   668: ifne +6 -> 674
    //   671: goto +180 -> 851
    //   674: iload_2
    //   675: iconst_1
    //   676: iadd
    //   677: istore_2
    //   678: goto -315 -> 363
    //   681: iconst_1
    //   682: istore 7
    //   684: iload 7
    //   686: istore 8
    //   688: iload_2
    //   689: iload 4
    //   691: if_icmpeq +22 -> 713
    //   694: ldc 31
    //   696: iconst_1
    //   697: ldc_w 312
    //   700: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: iconst_0
    //   704: istore 8
    //   706: goto +7 -> 713
    //   709: astore_1
    //   710: goto +53 -> 763
    //   713: iload 8
    //   715: istore 9
    //   717: aload_0
    //   718: invokevirtual 315	java/io/BufferedReader:close	()V
    //   721: iload 8
    //   723: ireturn
    //   724: astore_1
    //   725: aload_0
    //   726: astore 10
    //   728: aload_1
    //   729: astore_0
    //   730: goto +99 -> 829
    //   733: astore_1
    //   734: goto +26 -> 760
    //   737: aload 12
    //   739: astore 10
    //   741: ldc 31
    //   743: iconst_1
    //   744: ldc_w 317
    //   747: invokestatic 37	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   750: iconst_0
    //   751: ireturn
    //   752: astore_0
    //   753: goto +76 -> 829
    //   756: astore_1
    //   757: aload 11
    //   759: astore_0
    //   760: iconst_1
    //   761: istore 7
    //   763: aload_0
    //   764: astore 10
    //   766: new 45	java/lang/StringBuilder
    //   769: dup
    //   770: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   773: astore 11
    //   775: aload_0
    //   776: astore 10
    //   778: aload 11
    //   780: ldc_w 319
    //   783: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: aload_0
    //   788: astore 10
    //   790: aload 11
    //   792: aload_1
    //   793: invokevirtual 238	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   796: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: pop
    //   800: aload_0
    //   801: astore 10
    //   803: ldc 31
    //   805: iconst_1
    //   806: aload 11
    //   808: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokestatic 241	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   814: aload_0
    //   815: ifnull +11 -> 826
    //   818: iload 7
    //   820: istore 9
    //   822: aload_0
    //   823: invokevirtual 315	java/io/BufferedReader:close	()V
    //   826: iload 7
    //   828: ireturn
    //   829: aload 10
    //   831: ifnull +8 -> 839
    //   834: aload 10
    //   836: invokevirtual 315	java/io/BufferedReader:close	()V
    //   839: aload_0
    //   840: athrow
    //   841: iconst_0
    //   842: ireturn
    //   843: astore_0
    //   844: iload 9
    //   846: ireturn
    //   847: astore_1
    //   848: goto -9 -> 839
    //   851: iconst_0
    //   852: istore 7
    //   854: goto -170 -> 684
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	857	0	paramString1	String
    //   0	857	1	paramString2	String
    //   116	576	2	i	int
    //   114	533	3	j	int
    //   279	413	4	k	int
    //   584	19	5	m	int
    //   593	10	6	n	int
    //   664	189	7	bool1	boolean
    //   686	36	8	bool2	boolean
    //   715	130	9	bool3	boolean
    //   24	811	10	localObject1	Object
    //   17	790	11	localObject2	Object
    //   20	718	12	localStringBuilder1	StringBuilder
    //   67	260	13	localObject3	Object
    //   126	112	14	localStringBuilder2	StringBuilder
    //   139	38	15	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   694	703	709	java/lang/Exception
    //   363	369	724	finally
    //   374	420	724	finally
    //   423	440	724	finally
    //   443	549	724	finally
    //   552	559	724	finally
    //   564	595	724	finally
    //   606	643	724	finally
    //   655	666	724	finally
    //   694	703	724	finally
    //   363	369	733	java/lang/Exception
    //   374	420	733	java/lang/Exception
    //   423	440	733	java/lang/Exception
    //   443	549	733	java/lang/Exception
    //   552	559	733	java/lang/Exception
    //   564	595	733	java/lang/Exception
    //   606	643	733	java/lang/Exception
    //   655	666	733	java/lang/Exception
    //   26	40	752	finally
    //   44	53	752	finally
    //   59	69	752	finally
    //   73	81	752	finally
    //   85	93	752	finally
    //   100	107	752	finally
    //   111	115	752	finally
    //   132	141	752	finally
    //   145	154	752	finally
    //   158	169	752	finally
    //   173	184	752	finally
    //   195	204	752	finally
    //   208	217	752	finally
    //   221	230	752	finally
    //   234	245	752	finally
    //   249	255	752	finally
    //   259	268	752	finally
    //   274	281	752	finally
    //   285	294	752	finally
    //   298	307	752	finally
    //   311	319	752	finally
    //   323	334	752	finally
    //   338	361	752	finally
    //   741	750	752	finally
    //   766	775	752	finally
    //   778	787	752	finally
    //   790	800	752	finally
    //   803	814	752	finally
    //   26	40	756	java/lang/Exception
    //   44	53	756	java/lang/Exception
    //   59	69	756	java/lang/Exception
    //   73	81	756	java/lang/Exception
    //   85	93	756	java/lang/Exception
    //   100	107	756	java/lang/Exception
    //   111	115	756	java/lang/Exception
    //   132	141	756	java/lang/Exception
    //   145	154	756	java/lang/Exception
    //   158	169	756	java/lang/Exception
    //   173	184	756	java/lang/Exception
    //   195	204	756	java/lang/Exception
    //   208	217	756	java/lang/Exception
    //   221	230	756	java/lang/Exception
    //   234	245	756	java/lang/Exception
    //   249	255	756	java/lang/Exception
    //   259	268	756	java/lang/Exception
    //   274	281	756	java/lang/Exception
    //   285	294	756	java/lang/Exception
    //   298	307	756	java/lang/Exception
    //   311	319	756	java/lang/Exception
    //   323	334	756	java/lang/Exception
    //   338	361	756	java/lang/Exception
    //   741	750	756	java/lang/Exception
    //   717	721	843	java/lang/Exception
    //   822	826	843	java/lang/Exception
    //   834	839	847	java/lang/Exception
  }
  
  public static boolean a(String paramString1, String paramString2, File paramFile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    paramString2 = new File(paramString1);
    if (!FileUtils.unzip(paramFile, paramString2))
    {
      if (paramString2.exists()) {
        paramString2.delete();
      }
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is filed, return");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() unzip is SUCCESS");
    }
    paramFile = new StringBuilder();
    paramFile.append(paramString1);
    paramFile.append("/md5.txt");
    if (!a(paramFile.toString(), paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is filed, return");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DynamicSplashManager", 2, "parseDynamicSplashXMLConfig() checkUnzipFileMd5 is SUCCESS");
    }
    if (paramString2.isDirectory())
    {
      long l = paramString2.lastModified();
      paramString1 = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
      paramString1.putLong("dynamic_splash_config_folder_modify_time", l);
      paramString1.commit();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DynamicSplashManager
 * JD-Core Version:    0.7.0.1
 */
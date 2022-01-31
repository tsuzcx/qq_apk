package com.tencent.mobileqq.ar;

import android.util.Xml;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

public class ArSDK2NativeSoLoader
{
  public static int a(String paramString)
  {
    try
    {
      int i = ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", ArNativeSoLoaderBase.b("arsdk2", "v7.3.5.1", "arsdk2"), paramString);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static int a(String paramString1, String paramString2)
  {
    Object localObject;
    int i;
    for (;;)
    {
      try
      {
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. soResFilename = " + paramString1 + ", soResMd5FromConfig = " + paramString2);
        ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", "arsdk2", paramString2);
        try
        {
          ArConfigUtils.a(paramString1, ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", ArNativeSoLoaderBase.b("arsdk2", "v7.3.5.1", "arsdk2")));
          paramString2 = ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", ArNativeSoLoaderBase.b("arsdk2", "v7.3.5.1", "arsdk2")) + File.separator + "md5_config.xml";
          localObject = new File(paramString2);
          if (!((File)localObject).exists()) {
            break label781;
          }
        }
        catch (IOException paramString2)
        {
          File localFile;
          String str;
          i = -6;
          FileUtils.a(ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", ArNativeSoLoaderBase.b("arsdk2", "v7.3.5.1", "arsdk2")), false);
          paramString2 = new File(paramString1);
          if (paramString2.exists()) {
            paramString2.delete();
          }
          QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. unzip failed. result = " + -6 + ", soResFilename = " + paramString1);
          continue;
        }
      }
      finally {}
      try
      {
        paramString2 = FileUtils.b((File)localObject);
        paramString1 = a(paramString2);
        if (paramString1.size() <= 0) {
          break label751;
        }
        paramString2 = paramString1.entrySet().iterator();
        if (!paramString2.hasNext()) {
          break label822;
        }
        localObject = (Map.Entry)paramString2.next();
        paramString1 = "";
        if (!((String)((Map.Entry)localObject).getKey()).equalsIgnoreCase("libAlphaAR")) {
          break label528;
        }
        paramString1 = ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", ArNativeSoLoaderBase.b("arsdk2", "v7.3.5.1", "arsdk2")) + File.separator + (String)((Map.Entry)localObject).getKey() + ".so";
        ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", "libAlphaAR", (String)((Map.Entry)localObject).getValue());
      }
      catch (IOException paramString2)
      {
        i = -5;
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = " + -5 + ", soResFilename = " + paramString1);
        continue;
        if (!((String)((Map.Entry)localObject).getKey()).equalsIgnoreCase("libYTCommon")) {
          break label619;
        }
        paramString1 = ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", ArNativeSoLoaderBase.b("arsdk2", "v7.3.5.1", "arsdk2")) + File.separator + (String)((Map.Entry)localObject).getKey() + ".so";
        ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", "libYTCommon", (String)((Map.Entry)localObject).getValue());
        continue;
        if (!((String)((Map.Entry)localObject).getKey()).equalsIgnoreCase("AlphaAR_mqq_license")) {
          continue;
        }
        paramString1 = ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", ArNativeSoLoaderBase.b("arsdk2", "v7.3.5.1", "arsdk2")) + File.separator + (String)((Map.Entry)localObject).getKey() + ".dat";
        ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", "AlphaAR_mqq_license", (String)((Map.Entry)localObject).getValue());
        continue;
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = " + -2 + ", filename = " + paramString1);
        i = -2;
        continue;
        i = -1;
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. sSoMd5ListFromConfig.size() == 0. result = " + -1);
        continue;
      }
      localFile = new File(paramString1);
      QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. soFilename = " + paramString1);
      if (localFile.exists())
      {
        str = PortalUtils.a(paramString1);
        localObject = (String)((Map.Entry)localObject).getValue();
        if (((String)localObject).equalsIgnoreCase(str)) {
          continue;
        }
        localFile.delete();
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. check md5 failed. result = " + -3 + ", filename = " + paramString1 + ", md5FromCalc = " + str + ", md5FromConfig = " + (String)localObject);
        i = -3;
      }
    }
    for (;;)
    {
      return i;
      label528:
      label619:
      label751:
      QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = " + -2 + ", configFilename = " + paramString2);
      label781:
      i = -2;
      continue;
      label822:
      QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "doOnDownloadSuccess. result = " + 0);
      i = 0;
    }
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 174
    //   2: astore 4
    //   4: new 31	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   11: ldc 13
    //   13: ldc 15
    //   15: ldc 13
    //   17: ldc 15
    //   19: ldc 13
    //   21: invokestatic 21	com/tencent/mobileqq/ar/ArNativeSoLoaderBase:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: invokestatic 55	com/tencent/mobileqq/ar/ArNativeSoLoaderBase:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   27: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: getstatic 66	java/io/File:separator	Ljava/lang/String;
    //   33: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 162
    //   38: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore_1
    //   45: new 31	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   52: astore_3
    //   53: new 62	java/io/File
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: astore_1
    //   62: new 176	java/io/BufferedReader
    //   65: dup
    //   66: new 178	java/io/FileReader
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 181	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   74: invokespecial 184	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   77: astore_2
    //   78: iconst_1
    //   79: istore_0
    //   80: aload_2
    //   81: astore_1
    //   82: aload_2
    //   83: invokevirtual 187	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   86: astore 5
    //   88: aload 5
    //   90: ifnull +19 -> 109
    //   93: aload_2
    //   94: astore_1
    //   95: aload_3
    //   96: aload 5
    //   98: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: iload_0
    //   103: iconst_1
    //   104: iadd
    //   105: istore_0
    //   106: goto -26 -> 80
    //   109: aload_2
    //   110: astore_1
    //   111: aload_2
    //   112: invokevirtual 190	java/io/BufferedReader:close	()V
    //   115: aload_2
    //   116: astore_1
    //   117: aload_3
    //   118: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: astore_3
    //   122: aload_3
    //   123: astore_1
    //   124: aload_2
    //   125: ifnull +9 -> 134
    //   128: aload_2
    //   129: invokevirtual 190	java/io/BufferedReader:close	()V
    //   132: aload_3
    //   133: astore_1
    //   134: ldc 29
    //   136: iconst_2
    //   137: new 31	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   144: ldc 192
    //   146: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 50	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_1
    //   160: areturn
    //   161: astore_3
    //   162: aconst_null
    //   163: astore_2
    //   164: aload_2
    //   165: astore_1
    //   166: aload_3
    //   167: invokevirtual 195	java/io/IOException:printStackTrace	()V
    //   170: aload 4
    //   172: astore_1
    //   173: aload_2
    //   174: ifnull -40 -> 134
    //   177: aload_2
    //   178: invokevirtual 190	java/io/BufferedReader:close	()V
    //   181: aload 4
    //   183: astore_1
    //   184: goto -50 -> 134
    //   187: astore_1
    //   188: aload 4
    //   190: astore_1
    //   191: goto -57 -> 134
    //   194: astore_2
    //   195: aconst_null
    //   196: astore_1
    //   197: aload_1
    //   198: ifnull +7 -> 205
    //   201: aload_1
    //   202: invokevirtual 190	java/io/BufferedReader:close	()V
    //   205: aload_2
    //   206: athrow
    //   207: astore_1
    //   208: aload_3
    //   209: astore_1
    //   210: goto -76 -> 134
    //   213: astore_1
    //   214: goto -9 -> 205
    //   217: astore_2
    //   218: goto -21 -> 197
    //   221: astore_3
    //   222: goto -58 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   79	27	0	i	int
    //   44	140	1	localObject1	Object
    //   187	1	1	localIOException1	IOException
    //   190	12	1	str1	String
    //   207	1	1	localIOException2	IOException
    //   209	1	1	localObject2	Object
    //   213	1	1	localIOException3	IOException
    //   77	101	2	localBufferedReader	java.io.BufferedReader
    //   194	12	2	localObject3	Object
    //   217	1	2	localObject4	Object
    //   52	81	3	localObject5	Object
    //   161	48	3	localIOException4	IOException
    //   221	1	3	localIOException5	IOException
    //   2	187	4	str2	String
    //   86	11	5	str3	String
    // Exception table:
    //   from	to	target	type
    //   62	78	161	java/io/IOException
    //   177	181	187	java/io/IOException
    //   62	78	194	finally
    //   128	132	207	java/io/IOException
    //   201	205	213	java/io/IOException
    //   82	88	217	finally
    //   95	102	217	finally
    //   111	115	217	finally
    //   117	122	217	finally
    //   166	170	217	finally
    //   82	88	221	java/io/IOException
    //   95	102	221	java/io/IOException
    //   111	115	221	java/io/IOException
    //   117	122	221	java/io/IOException
  }
  
  private static HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception localException)
      {
        XmlPullParser localXmlPullParser;
        QLog.e("AREngine_ArSDK2NativeSoLoader", 2, "parseSoMd5FromXmlConfig failed. error = " + localException.getMessage() + ", xmlConfigContent = " + paramString);
        return localHashMap;
      }
      int i = localXmlPullParser.next();
      break label204;
      str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("libAlphaAR"))
      {
        localHashMap.put("libAlphaAR", localXmlPullParser.nextText());
      }
      else if (str.equalsIgnoreCase("libYTCommon"))
      {
        localHashMap.put("libYTCommon", localException.nextText());
      }
      else if (str.equalsIgnoreCase("AlphaAR_mqq_license"))
      {
        localHashMap.put("AlphaAR_mqq_license", localException.nextText());
        label204:
        while (i == 1)
        {
          String str;
          QLog.d("AREngine_ArSDK2NativeSoLoader", 2, "parseSoMd5FromXmlConfig successfully. soMd5List = " + localHashMap);
          return localHashMap;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  public static boolean a()
  {
    File localFile1 = new File(ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", ArNativeSoLoaderBase.b("arsdk2", "v7.3.5.1", "arsdk2")) + File.separator + "libYTCommon" + ".so");
    File localFile2 = new File(ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", ArNativeSoLoaderBase.b("arsdk2", "v7.3.5.1", "arsdk2")) + File.separator + "libAlphaAR" + ".so");
    File localFile3 = new File(ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", ArNativeSoLoaderBase.b("arsdk2", "v7.3.5.1", "arsdk2")) + File.separator + "AlphaAR_mqq_license" + ".dat");
    if (!localFile1.exists()) {}
    while ((!localFile2.exists()) || (!localFile3.exists())) {
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        String str = ArNativeSoLoaderBase.a("arsdk2", "v7.3.5.1", ArNativeSoLoaderBase.b("arsdk2", "v7.3.5.1", "arsdk2")) + File.separator + paramString + ".so";
        Object localObject = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ArSDK2NativeSoLoader", 2, "isSoFileExist soFile=" + str + ", exist=" + ((File)localObject).exists());
        }
        if (((File)localObject).exists())
        {
          paramString = ArNativeSoLoaderBase.b("arsdk2", "v7.3.5.1", paramString);
          localObject = PortalUtils.a(str);
          boolean bool2 = paramString.equalsIgnoreCase((String)localObject);
          if (bool2)
          {
            bool1 = true;
            return bool1;
          }
          QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "isSoFileExist. check md5 failed. soFilename = " + str + ", md5FromConfig = " + paramString + ", md5FromCalc = " + (String)localObject);
          continue;
        }
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, "isSoFileExist. so not exist. soFilename = " + str);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArSDK2NativeSoLoader
 * JD-Core Version:    0.7.0.1
 */
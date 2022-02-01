package com.tencent.mobileqq.ar;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class ArNativeSoLoader
{
  public static boolean a;
  private static final byte[] a;
  public static boolean b = false;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[0];
    jdField_a_of_type_Boolean = false;
  }
  
  public static byte a(String paramString)
  {
    byte b2 = 0;
    if (paramString == null) {
      return -1;
    }
    String str = a() + "/lib" + paramString + ".so";
    if (QLog.isColorLevel()) {
      QLog.i("ArConfig_ArNativeSoLoader", 2, "start arNativeSo: " + str);
    }
    File localFile = new File(str);
    if ((!jdField_a_of_type_Boolean) && (localFile.exists())) {}
    for (;;)
    {
      try
      {
        System.load(str);
        b1 = b2;
        if (QLog.isColorLevel())
        {
          QLog.i("ArConfig_ArNativeSoLoader", 2, "load " + str + " success!");
          b1 = b2;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("ArConfig_ArNativeSoLoader", 2, "load from ar dir failed.", localUnsatisfiedLinkError);
        b1 = -3;
        continue;
      }
      a(paramString, b1);
      return b1;
      b2 = -2;
      byte b1 = b2;
      if (QLog.isColorLevel())
      {
        QLog.i("ArConfig_ArNativeSoLoader", 2, "no ar so in ar dir");
        b1 = b2;
      }
    }
  }
  
  public static String a()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ArConfig_ArNativeSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/ar";
  }
  
  private static void a(String paramString, byte paramByte)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
    byte b1 = localSharedPreferences.getInt("ar_native_so_load_result" + paramString, 0);
    if ((!b) || (b1 != paramByte))
    {
      b = true;
      ThreadManager.post(new ArNativeSoLoader.1(paramString, paramByte, localSharedPreferences), 5, null, true);
    }
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString, true);
  }
  
  public static boolean a(String paramString, HashMap<String, String> paramHashMap)
  {
    boolean bool = true;
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    paramHashMap.clear();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramHashMap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ArConfig_ArNativeSoLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      if (localXmlPullParser.getName().equalsIgnoreCase("ArMapEngine836"))
      {
        paramHashMap.put("ArMapEngine836", localXmlPullParser.nextText());
        break label104;
        ;;
        label104:
        if (QLog.isColorLevel())
        {
          QLog.d("ArConfig_ArNativeSoLoader", 2, "parseConfig success|config=" + paramHashMap);
          return true;
          if (i != 1) {
            switch (i)
            {
            }
          }
        }
      }
    }
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    String str1 = a() + "/lib" + paramString + ".so";
    ??? = new File(str1);
    if (QLog.isColorLevel()) {
      QLog.d("ArConfig_ArNativeSoLoader", 2, "isSoFileExist libPath=" + str1 + ", exist=" + ((File)???).exists() + ", isUncompressZip=" + jdField_a_of_type_Boolean);
    }
    boolean bool1 = bool3;
    if (!jdField_a_of_type_Boolean)
    {
      bool1 = bool3;
      if (((File)???).exists())
      {
        if (paramBoolean) {
          break label132;
        }
        bool1 = true;
      }
    }
    return bool1;
    for (;;)
    {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        label132:
        String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("ar_native_" + paramString, null);
        if (QLog.isColorLevel()) {
          QLog.d("ArConfig_ArNativeSoLoader", 2, "isSoFileExist: md5= " + str2);
        }
        if (str2 == null) {
          break label283;
        }
        if (str2.equalsIgnoreCase(PortalUtils.a(str1)))
        {
          break label283;
          return paramBoolean;
        }
      }
      paramBoolean = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("ArConfig_ArNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " check md5 false!");
        paramBoolean = bool2;
        continue;
        label283:
        paramBoolean = true;
      }
    }
  }
  
  /* Error */
  public static byte b(String arg0)
  {
    // Byte code:
    //   0: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 48
    //   8: iconst_2
    //   9: new 25	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   16: ldc 229
    //   18: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: iconst_1
    //   32: putstatic 14	com/tencent/mobileqq/ar/ArNativeSoLoader:jdField_a_of_type_Boolean	Z
    //   35: aload_0
    //   36: invokestatic 29	com/tencent/mobileqq/ar/ArNativeSoLoader:a	()Ljava/lang/String;
    //   39: invokestatic 234	com/tencent/mobileqq/ar/ArConfigUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: new 142	java/util/HashMap
    //   45: dup
    //   46: invokespecial 235	java/util/HashMap:<init>	()V
    //   49: astore 5
    //   51: getstatic 87	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   54: ldc 104
    //   56: iconst_0
    //   57: invokevirtual 108	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   60: invokeinterface 239 1 0
    //   65: astore 4
    //   67: new 56	java/io/File
    //   70: dup
    //   71: new 25	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   78: invokestatic 29	com/tencent/mobileqq/ar/ArNativeSoLoader:a	()Ljava/lang/String;
    //   81: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 241
    //   86: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   95: astore_3
    //   96: aload_3
    //   97: invokevirtual 62	java/io/File:exists	()Z
    //   100: ifeq +311 -> 411
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_3
    //   106: invokestatic 246	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;)Ljava/lang/String;
    //   109: astore_3
    //   110: aload_3
    //   111: astore_0
    //   112: aload_0
    //   113: ifnull +274 -> 387
    //   116: aload_0
    //   117: aload 5
    //   119: invokestatic 248	com/tencent/mobileqq/ar/ArNativeSoLoader:a	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   122: ifeq +265 -> 387
    //   125: getstatic 12	com/tencent/mobileqq/ar/ArNativeSoLoader:jdField_a_of_type_ArrayOfByte	[B
    //   128: astore_0
    //   129: aload_0
    //   130: monitorenter
    //   131: aload 5
    //   133: invokevirtual 252	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   136: invokeinterface 258 1 0
    //   141: astore_3
    //   142: aload_3
    //   143: invokeinterface 263 1 0
    //   148: ifeq +283 -> 431
    //   151: aload_3
    //   152: invokeinterface 266 1 0
    //   157: checkcast 268	java/util/Map$Entry
    //   160: astore 5
    //   162: new 25	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   169: invokestatic 29	com/tencent/mobileqq/ar/ArNativeSoLoader:a	()Ljava/lang/String;
    //   172: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: ldc 35
    //   177: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: invokeinterface 271 1 0
    //   187: checkcast 149	java/lang/String
    //   190: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 37
    //   195: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: astore 7
    //   203: new 56	java/io/File
    //   206: dup
    //   207: aload 7
    //   209: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: astore 6
    //   214: aload 6
    //   216: invokevirtual 62	java/io/File:exists	()Z
    //   219: ifeq +163 -> 382
    //   222: aload 7
    //   224: invokestatic 221	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   227: astore 7
    //   229: aload 5
    //   231: invokeinterface 274 1 0
    //   236: checkcast 149	java/lang/String
    //   239: aload 7
    //   241: invokevirtual 179	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   244: ifne +84 -> 328
    //   247: aload 6
    //   249: invokevirtual 277	java/io/File:delete	()Z
    //   252: pop
    //   253: iconst_2
    //   254: istore_1
    //   255: aload 4
    //   257: invokeinterface 282 1 0
    //   262: pop
    //   263: aload_0
    //   264: monitorexit
    //   265: iconst_0
    //   266: putstatic 14	com/tencent/mobileqq/ar/ArNativeSoLoader:jdField_a_of_type_Boolean	Z
    //   269: iload_1
    //   270: ireturn
    //   271: astore_0
    //   272: iconst_0
    //   273: putstatic 14	com/tencent/mobileqq/ar/ArNativeSoLoader:jdField_a_of_type_Boolean	Z
    //   276: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   279: ifeq +32 -> 311
    //   282: ldc 48
    //   284: iconst_2
    //   285: new 25	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 284
    //   295: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_0
    //   299: invokevirtual 287	java/io/IOException:getMessage	()Ljava/lang/String;
    //   302: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: invokestatic 29	com/tencent/mobileqq/ar/ArNativeSoLoader:a	()Ljava/lang/String;
    //   314: iconst_0
    //   315: invokestatic 290	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Z)V
    //   318: iconst_m1
    //   319: ireturn
    //   320: astore_3
    //   321: aload_3
    //   322: invokevirtual 293	java/io/IOException:printStackTrace	()V
    //   325: goto -213 -> 112
    //   328: aload 4
    //   330: new 25	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   337: ldc 210
    //   339: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 5
    //   344: invokeinterface 271 1 0
    //   349: checkcast 149	java/lang/String
    //   352: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: aload 5
    //   360: invokeinterface 274 1 0
    //   365: checkcast 149	java/lang/String
    //   368: invokeinterface 297 3 0
    //   373: pop
    //   374: goto -232 -> 142
    //   377: astore_3
    //   378: aload_0
    //   379: monitorexit
    //   380: aload_3
    //   381: athrow
    //   382: iconst_3
    //   383: istore_1
    //   384: goto -129 -> 255
    //   387: iconst_4
    //   388: istore_2
    //   389: iload_2
    //   390: istore_1
    //   391: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq -129 -> 265
    //   397: ldc 48
    //   399: iconst_2
    //   400: ldc_w 299
    //   403: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: iload_2
    //   407: istore_1
    //   408: goto -143 -> 265
    //   411: invokestatic 46	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +12 -> 426
    //   417: ldc 48
    //   419: iconst_2
    //   420: ldc_w 301
    //   423: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: iconst_0
    //   427: istore_1
    //   428: goto -163 -> 265
    //   431: iconst_0
    //   432: istore_1
    //   433: goto -178 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   254	179	1	b1	byte
    //   388	19	2	b2	byte
    //   95	57	3	localObject1	Object
    //   320	2	3	localIOException	java.io.IOException
    //   377	4	3	localObject2	Object
    //   65	264	4	localEditor	android.content.SharedPreferences.Editor
    //   49	310	5	localObject3	Object
    //   212	36	6	localFile	File
    //   201	39	7	str	String
    // Exception table:
    //   from	to	target	type
    //   35	42	271	java/io/IOException
    //   105	110	320	java/io/IOException
    //   131	142	377	finally
    //   142	253	377	finally
    //   255	265	377	finally
    //   328	374	377	finally
    //   378	380	377	finally
  }
  
  public static boolean b(String paramString)
  {
    return new File(a() + "/lib" + paramString + ".so").exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArNativeSoLoader
 * JD-Core Version:    0.7.0.1
 */
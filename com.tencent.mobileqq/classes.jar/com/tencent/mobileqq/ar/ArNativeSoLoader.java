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
import zxy;

public class ArNativeSoLoader
{
  public static boolean a;
  private static final byte[] a;
  public static boolean b;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[0];
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
      ThreadManager.post(new zxy(paramString, paramByte, localSharedPreferences), 5, null, true);
    }
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString, true);
  }
  
  public static boolean a(String paramString, HashMap paramHashMap)
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
      if (localXmlPullParser.getName().equalsIgnoreCase("ArMapEngine738"))
      {
        paramHashMap.put("ArMapEngine738", localXmlPullParser.nextText());
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
    //   0: iconst_1
    //   1: putstatic 57	com/tencent/mobileqq/ar/ArNativeSoLoader:jdField_a_of_type_Boolean	Z
    //   4: aload_0
    //   5: invokestatic 25	com/tencent/mobileqq/ar/ArNativeSoLoader:a	()Ljava/lang/String;
    //   8: invokestatic 230	com/tencent/mobileqq/ar/ArConfigUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: new 142	java/util/HashMap
    //   14: dup
    //   15: invokespecial 231	java/util/HashMap:<init>	()V
    //   18: astore 5
    //   20: getstatic 85	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   23: ldc 102
    //   25: iconst_0
    //   26: invokevirtual 106	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   29: invokeinterface 235 1 0
    //   34: astore 4
    //   36: new 52	java/io/File
    //   39: dup
    //   40: new 21	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   47: invokestatic 25	com/tencent/mobileqq/ar/ArNativeSoLoader:a	()Ljava/lang/String;
    //   50: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 237
    //   55: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore_3
    //   65: aload_3
    //   66: invokevirtual 60	java/io/File:exists	()Z
    //   69: ifeq +311 -> 380
    //   72: aconst_null
    //   73: astore_0
    //   74: aload_3
    //   75: invokestatic 242	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;)Ljava/lang/String;
    //   78: astore_3
    //   79: aload_3
    //   80: astore_0
    //   81: aload_0
    //   82: ifnull +274 -> 356
    //   85: aload_0
    //   86: aload 5
    //   88: invokestatic 244	com/tencent/mobileqq/ar/ArNativeSoLoader:a	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   91: ifeq +265 -> 356
    //   94: getstatic 12	com/tencent/mobileqq/ar/ArNativeSoLoader:jdField_a_of_type_ArrayOfByte	[B
    //   97: astore_0
    //   98: aload_0
    //   99: monitorenter
    //   100: aload 5
    //   102: invokevirtual 248	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   105: invokeinterface 254 1 0
    //   110: astore_3
    //   111: aload_3
    //   112: invokeinterface 259 1 0
    //   117: ifeq +283 -> 400
    //   120: aload_3
    //   121: invokeinterface 262 1 0
    //   126: checkcast 264	java/util/Map$Entry
    //   129: astore 5
    //   131: new 21	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   138: invokestatic 25	com/tencent/mobileqq/ar/ArNativeSoLoader:a	()Ljava/lang/String;
    //   141: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 31
    //   146: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 5
    //   151: invokeinterface 267 1 0
    //   156: checkcast 149	java/lang/String
    //   159: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 33
    //   164: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 7
    //   172: new 52	java/io/File
    //   175: dup
    //   176: aload 7
    //   178: invokespecial 55	java/io/File:<init>	(Ljava/lang/String;)V
    //   181: astore 6
    //   183: aload 6
    //   185: invokevirtual 60	java/io/File:exists	()Z
    //   188: ifeq +163 -> 351
    //   191: aload 7
    //   193: invokestatic 219	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 7
    //   198: aload 5
    //   200: invokeinterface 270 1 0
    //   205: checkcast 149	java/lang/String
    //   208: aload 7
    //   210: invokevirtual 179	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   213: ifne +84 -> 297
    //   216: aload 6
    //   218: invokevirtual 273	java/io/File:delete	()Z
    //   221: pop
    //   222: iconst_2
    //   223: istore_1
    //   224: aload 4
    //   226: invokeinterface 278 1 0
    //   231: pop
    //   232: aload_0
    //   233: monitorexit
    //   234: iconst_0
    //   235: putstatic 57	com/tencent/mobileqq/ar/ArNativeSoLoader:jdField_a_of_type_Boolean	Z
    //   238: iload_1
    //   239: ireturn
    //   240: astore_0
    //   241: iconst_0
    //   242: putstatic 57	com/tencent/mobileqq/ar/ArNativeSoLoader:jdField_a_of_type_Boolean	Z
    //   245: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +32 -> 280
    //   251: ldc 44
    //   253: iconst_2
    //   254: new 21	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 280
    //   264: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: invokevirtual 283	java/io/IOException:getMessage	()Ljava/lang/String;
    //   271: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: invokestatic 25	com/tencent/mobileqq/ar/ArNativeSoLoader:a	()Ljava/lang/String;
    //   283: iconst_0
    //   284: invokestatic 286	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Z)V
    //   287: iconst_m1
    //   288: ireturn
    //   289: astore_3
    //   290: aload_3
    //   291: invokevirtual 289	java/io/IOException:printStackTrace	()V
    //   294: goto -213 -> 81
    //   297: aload 4
    //   299: new 21	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   306: ldc 208
    //   308: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload 5
    //   313: invokeinterface 267 1 0
    //   318: checkcast 149	java/lang/String
    //   321: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: aload 5
    //   329: invokeinterface 270 1 0
    //   334: checkcast 149	java/lang/String
    //   337: invokeinterface 293 3 0
    //   342: pop
    //   343: goto -232 -> 111
    //   346: astore_3
    //   347: aload_0
    //   348: monitorexit
    //   349: aload_3
    //   350: athrow
    //   351: iconst_3
    //   352: istore_1
    //   353: goto -129 -> 224
    //   356: iconst_4
    //   357: istore_2
    //   358: iload_2
    //   359: istore_1
    //   360: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq -129 -> 234
    //   366: ldc 44
    //   368: iconst_2
    //   369: ldc_w 295
    //   372: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: iload_2
    //   376: istore_1
    //   377: goto -143 -> 234
    //   380: invokestatic 42	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq +12 -> 395
    //   386: ldc 44
    //   388: iconst_2
    //   389: ldc_w 297
    //   392: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: iconst_0
    //   396: istore_1
    //   397: goto -163 -> 234
    //   400: iconst_0
    //   401: istore_1
    //   402: goto -178 -> 224
    // Local variable table:
    //   start	length	slot	name	signature
    //   223	179	1	b1	byte
    //   357	19	2	b2	byte
    //   64	57	3	localObject1	Object
    //   289	2	3	localIOException	java.io.IOException
    //   346	4	3	localObject2	Object
    //   34	264	4	localEditor	android.content.SharedPreferences.Editor
    //   18	310	5	localObject3	Object
    //   181	36	6	localFile	File
    //   170	39	7	str	String
    // Exception table:
    //   from	to	target	type
    //   4	11	240	java/io/IOException
    //   74	79	289	java/io/IOException
    //   100	111	346	finally
    //   111	222	346	finally
    //   224	234	346	finally
    //   297	343	346	finally
    //   347	349	346	finally
  }
  
  public static boolean b(String paramString)
  {
    return new File(a() + "/lib" + paramString + ".so").exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArNativeSoLoader
 * JD-Core Version:    0.7.0.1
 */
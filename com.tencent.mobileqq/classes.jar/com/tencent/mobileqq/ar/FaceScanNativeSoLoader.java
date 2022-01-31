package com.tencent.mobileqq.ar;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arengine.ARFaceDataCollector;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class FaceScanNativeSoLoader
{
  private static final Object a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  /* Error */
  public static byte a(String arg0)
  {
    // Byte code:
    //   0: iconst_1
    //   1: putstatic 20	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:jdField_a_of_type_Boolean	Z
    //   4: new 22	java/io/File
    //   7: dup
    //   8: invokestatic 26	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:b	()Ljava/lang/String;
    //   11: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 4
    //   16: aload 4
    //   18: invokevirtual 33	java/io/File:exists	()Z
    //   21: ifeq +40 -> 61
    //   24: aload 4
    //   26: invokestatic 38	com/tencent/mobileqq/filemanager/util/FileUtil:a	(Ljava/io/File;)Z
    //   29: istore_3
    //   30: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +28 -> 61
    //   36: ldc 45
    //   38: iconst_2
    //   39: new 47	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   46: ldc 50
    //   48: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: iload_3
    //   52: invokevirtual 57	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: aload_0
    //   62: invokestatic 66	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:a	()Ljava/lang/String;
    //   65: invokestatic 69	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: new 71	java/util/HashMap
    //   71: dup
    //   72: invokespecial 72	java/util/HashMap:<init>	()V
    //   75: astore 6
    //   77: getstatic 78	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   80: ldc 80
    //   82: iconst_0
    //   83: invokevirtual 84	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   86: invokeinterface 90 1 0
    //   91: astore 5
    //   93: new 22	java/io/File
    //   96: dup
    //   97: new 47	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   104: invokestatic 66	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:a	()Ljava/lang/String;
    //   107: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 92
    //   112: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 33	java/io/File:exists	()Z
    //   128: ifeq +319 -> 447
    //   131: aconst_null
    //   132: astore_0
    //   133: aload 4
    //   135: invokestatic 97	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;)Ljava/lang/String;
    //   138: astore 4
    //   140: aload 4
    //   142: astore_0
    //   143: aload_0
    //   144: ifnull +280 -> 424
    //   147: aload_0
    //   148: aload 6
    //   150: invokestatic 100	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:a	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   153: ifeq +271 -> 424
    //   156: getstatic 14	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   159: astore_0
    //   160: aload_0
    //   161: monitorenter
    //   162: aload 6
    //   164: invokevirtual 104	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   167: invokeinterface 110 1 0
    //   172: astore 4
    //   174: aload 4
    //   176: invokeinterface 115 1 0
    //   181: ifeq +285 -> 466
    //   184: aload 4
    //   186: invokeinterface 119 1 0
    //   191: checkcast 121	java/util/Map$Entry
    //   194: astore 6
    //   196: new 47	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   203: invokestatic 66	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:a	()Ljava/lang/String;
    //   206: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 123
    //   211: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: aload 6
    //   216: invokeinterface 126 1 0
    //   221: checkcast 128	java/lang/String
    //   224: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc 130
    //   229: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore 8
    //   237: new 22	java/io/File
    //   240: dup
    //   241: aload 8
    //   243: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   246: astore 7
    //   248: aload 7
    //   250: invokevirtual 33	java/io/File:exists	()Z
    //   253: ifeq +166 -> 419
    //   256: aload 8
    //   258: invokestatic 135	com/tencent/mobileqq/portal/PortalUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   261: astore 8
    //   263: aload 6
    //   265: invokeinterface 138 1 0
    //   270: checkcast 128	java/lang/String
    //   273: aload 8
    //   275: invokevirtual 142	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   278: ifne +85 -> 363
    //   281: aload 7
    //   283: invokevirtual 145	java/io/File:delete	()Z
    //   286: pop
    //   287: iconst_2
    //   288: istore_1
    //   289: aload 5
    //   291: invokeinterface 150 1 0
    //   296: pop
    //   297: aload_0
    //   298: monitorexit
    //   299: iconst_0
    //   300: putstatic 20	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:jdField_a_of_type_Boolean	Z
    //   303: iload_1
    //   304: ireturn
    //   305: astore_0
    //   306: iconst_0
    //   307: putstatic 20	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:jdField_a_of_type_Boolean	Z
    //   310: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +31 -> 344
    //   316: ldc 45
    //   318: iconst_2
    //   319: new 47	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   326: ldc 152
    //   328: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_0
    //   332: invokevirtual 155	java/io/IOException:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: invokestatic 66	com/tencent/mobileqq/ar/FaceScanNativeSoLoader:a	()Ljava/lang/String;
    //   347: iconst_0
    //   348: invokestatic 158	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Z)V
    //   351: iconst_m1
    //   352: ireturn
    //   353: astore 4
    //   355: aload 4
    //   357: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   360: goto -217 -> 143
    //   363: aload 5
    //   365: new 47	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   372: ldc 163
    //   374: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload 6
    //   379: invokeinterface 126 1 0
    //   384: checkcast 128	java/lang/String
    //   387: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: aload 6
    //   395: invokeinterface 138 1 0
    //   400: checkcast 128	java/lang/String
    //   403: invokeinterface 167 3 0
    //   408: pop
    //   409: goto -235 -> 174
    //   412: astore 4
    //   414: aload_0
    //   415: monitorexit
    //   416: aload 4
    //   418: athrow
    //   419: iconst_3
    //   420: istore_1
    //   421: goto -132 -> 289
    //   424: iconst_4
    //   425: istore_2
    //   426: iload_2
    //   427: istore_1
    //   428: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   431: ifeq -132 -> 299
    //   434: ldc 45
    //   436: iconst_2
    //   437: ldc 169
    //   439: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: iload_2
    //   443: istore_1
    //   444: goto -145 -> 299
    //   447: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +11 -> 461
    //   453: ldc 45
    //   455: iconst_2
    //   456: ldc 171
    //   458: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: iconst_0
    //   462: istore_1
    //   463: goto -164 -> 299
    //   466: iconst_0
    //   467: istore_1
    //   468: goto -179 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   288	180	1	b1	byte
    //   425	18	2	b2	byte
    //   29	23	3	bool	boolean
    //   14	171	4	localObject1	Object
    //   353	3	4	localIOException	java.io.IOException
    //   412	5	4	localObject2	Object
    //   91	273	5	localEditor	android.content.SharedPreferences.Editor
    //   75	319	6	localObject3	Object
    //   246	36	7	localFile	File
    //   235	39	8	str	String
    // Exception table:
    //   from	to	target	type
    //   61	68	305	java/io/IOException
    //   133	140	353	java/io/IOException
    //   162	174	412	finally
    //   174	287	412	finally
    //   289	299	412	finally
    //   363	409	412	finally
    //   414	416	412	finally
  }
  
  public static String a()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FaceScanNativeSoLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/face_scan_so";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("FaceScanNativeSoLoader", 2, "getFaceLibPath ,path = " + str);
    return str;
  }
  
  public static String a(String paramString)
  {
    new StringBuilder().append(a()).append("/lib").append(paramString).append(".so").toString();
    String str = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("face_native_" + paramString, null);
    if (QLog.isColorLevel()) {
      QLog.i("FaceScanNativeSoLoader", 2, "getFaceSoMd5 ,soName = " + paramString + ",md5 = " + str);
    }
    return str;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 45
    //   10: iconst_2
    //   11: new 47	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   18: ldc 201
    //   20: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 64	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 203	java/util/zip/ZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 204	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 208	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   48: astore 6
    //   50: sipush 8192
    //   53: newarray byte
    //   55: astore 7
    //   57: aload 6
    //   59: invokeinterface 213 1 0
    //   64: ifeq +330 -> 394
    //   67: aload 6
    //   69: invokeinterface 216 1 0
    //   74: checkcast 218	java/util/zip/ZipEntry
    //   77: astore 5
    //   79: aload 5
    //   81: invokevirtual 221	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +410 -> 496
    //   89: aload_0
    //   90: ldc 223
    //   92: invokevirtual 227	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +6 -> 101
    //   98: goto -41 -> 57
    //   101: new 47	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   108: aload_1
    //   109: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 231	java/io/File:separator	Ljava/lang/String;
    //   115: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_0
    //   126: aload 5
    //   128: invokevirtual 234	java/util/zip/ZipEntry:isDirectory	()Z
    //   131: ifeq +27 -> 158
    //   134: new 22	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 33	java/io/File:exists	()Z
    //   147: ifne +352 -> 499
    //   150: aload_0
    //   151: invokevirtual 237	java/io/File:mkdir	()Z
    //   154: pop
    //   155: goto +344 -> 499
    //   158: aload_0
    //   159: getstatic 231	java/io/File:separator	Ljava/lang/String;
    //   162: invokevirtual 241	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   165: istore_2
    //   166: aload_0
    //   167: iconst_0
    //   168: iload_2
    //   169: invokevirtual 245	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: astore 8
    //   174: aload_0
    //   175: iload_2
    //   176: iconst_1
    //   177: iadd
    //   178: invokevirtual 248	java/lang/String:substring	(I)Ljava/lang/String;
    //   181: ldc 250
    //   183: invokevirtual 253	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   186: ifeq +6 -> 192
    //   189: goto -132 -> 57
    //   192: new 22	java/io/File
    //   195: dup
    //   196: aload 8
    //   198: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 8
    //   203: aload 8
    //   205: invokevirtual 33	java/io/File:exists	()Z
    //   208: ifne +9 -> 217
    //   211: aload 8
    //   213: invokevirtual 237	java/io/File:mkdir	()Z
    //   216: pop
    //   217: new 22	java/io/File
    //   220: dup
    //   221: new 47	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   228: aload_0
    //   229: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 255
    //   234: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   243: astore 8
    //   245: new 22	java/io/File
    //   248: dup
    //   249: aload_0
    //   250: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   253: astore 9
    //   255: aload 8
    //   257: invokevirtual 33	java/io/File:exists	()Z
    //   260: ifeq +9 -> 269
    //   263: aload 8
    //   265: invokevirtual 145	java/io/File:delete	()Z
    //   268: pop
    //   269: new 257	java/io/FileOutputStream
    //   272: dup
    //   273: aload 8
    //   275: invokespecial 260	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   278: astore_0
    //   279: aload 4
    //   281: aload 5
    //   283: invokevirtual 264	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   286: astore 5
    //   288: aload 5
    //   290: aload 7
    //   292: iconst_0
    //   293: aload 7
    //   295: arraylength
    //   296: invokevirtual 270	java/io/InputStream:read	([BII)I
    //   299: istore_2
    //   300: iload_2
    //   301: iconst_m1
    //   302: if_icmpeq +52 -> 354
    //   305: aload_0
    //   306: aload 7
    //   308: iconst_0
    //   309: iload_2
    //   310: invokevirtual 274	java/io/FileOutputStream:write	([BII)V
    //   313: goto -25 -> 288
    //   316: astore 6
    //   318: aload 5
    //   320: astore_1
    //   321: aload_0
    //   322: astore_3
    //   323: aload 6
    //   325: astore_0
    //   326: aload_3
    //   327: ifnull +7 -> 334
    //   330: aload_3
    //   331: invokevirtual 277	java/io/FileOutputStream:close	()V
    //   334: aload_1
    //   335: ifnull +7 -> 342
    //   338: aload_1
    //   339: invokevirtual 278	java/io/InputStream:close	()V
    //   342: aload 4
    //   344: ifnull +8 -> 352
    //   347: aload 4
    //   349: invokevirtual 279	java/util/zip/ZipFile:close	()V
    //   352: aload_0
    //   353: athrow
    //   354: aload_0
    //   355: invokevirtual 282	java/io/FileOutputStream:flush	()V
    //   358: aload_0
    //   359: invokevirtual 277	java/io/FileOutputStream:close	()V
    //   362: aload 5
    //   364: invokevirtual 278	java/io/InputStream:close	()V
    //   367: aload 8
    //   369: aload 9
    //   371: invokestatic 285	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/io/File;Ljava/io/File;)Z
    //   374: ifne +125 -> 499
    //   377: aload 8
    //   379: aload 9
    //   381: invokestatic 287	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;Ljava/io/File;)Z
    //   384: pop
    //   385: goto +114 -> 499
    //   388: astore_0
    //   389: aconst_null
    //   390: astore_1
    //   391: goto -65 -> 326
    //   394: iconst_0
    //   395: ifeq +11 -> 406
    //   398: new 289	java/lang/NullPointerException
    //   401: dup
    //   402: invokespecial 290	java/lang/NullPointerException:<init>	()V
    //   405: athrow
    //   406: iconst_0
    //   407: ifeq +11 -> 418
    //   410: new 289	java/lang/NullPointerException
    //   413: dup
    //   414: invokespecial 290	java/lang/NullPointerException:<init>	()V
    //   417: athrow
    //   418: aload 4
    //   420: ifnull +8 -> 428
    //   423: aload 4
    //   425: invokevirtual 279	java/util/zip/ZipFile:close	()V
    //   428: return
    //   429: astore_0
    //   430: aload_0
    //   431: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   434: goto -28 -> 406
    //   437: astore_0
    //   438: aload_0
    //   439: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   442: goto -24 -> 418
    //   445: astore_0
    //   446: aload_0
    //   447: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   450: return
    //   451: astore_3
    //   452: aload_3
    //   453: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   456: goto -122 -> 334
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   464: goto -122 -> 342
    //   467: astore_1
    //   468: aload_1
    //   469: invokevirtual 161	java/io/IOException:printStackTrace	()V
    //   472: goto -120 -> 352
    //   475: astore_0
    //   476: aconst_null
    //   477: astore 4
    //   479: aconst_null
    //   480: astore_1
    //   481: goto -155 -> 326
    //   484: astore 5
    //   486: aconst_null
    //   487: astore_1
    //   488: aload_0
    //   489: astore_3
    //   490: aload 5
    //   492: astore_0
    //   493: goto -167 -> 326
    //   496: goto -439 -> 57
    //   499: goto -442 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	502	0	paramString1	String
    //   0	502	1	paramString2	String
    //   165	145	2	i	int
    //   1	330	3	str1	String
    //   451	2	3	localIOException	java.io.IOException
    //   489	1	3	str2	String
    //   41	437	4	localZipFile	java.util.zip.ZipFile
    //   77	286	5	localObject1	Object
    //   484	7	5	localObject2	Object
    //   48	20	6	localEnumeration	java.util.Enumeration
    //   316	8	6	localObject3	Object
    //   55	252	7	arrayOfByte	byte[]
    //   172	206	8	localObject4	Object
    //   253	127	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   288	300	316	finally
    //   305	313	316	finally
    //   354	367	316	finally
    //   43	57	388	finally
    //   57	85	388	finally
    //   89	98	388	finally
    //   101	155	388	finally
    //   158	189	388	finally
    //   192	217	388	finally
    //   217	269	388	finally
    //   269	279	388	finally
    //   367	385	388	finally
    //   398	406	429	java/io/IOException
    //   410	418	437	java/io/IOException
    //   423	428	445	java/io/IOException
    //   330	334	451	java/io/IOException
    //   338	342	459	java/io/IOException
    //   347	352	467	java/io/IOException
    //   33	43	475	finally
    //   279	288	484	finally
  }
  
  public static boolean a()
  {
    if ((!a("nnpack")) || (!a("YTCommon")) || (!a("YTFaceCluster")) || (!a("YTFaceExtFeature")) || (!a("YTFaceTrackPro")) || (!a("YTFaceClusterJNI_V720")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoLoader", 2, "native so is not exist!");
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    String str1 = a() + "/lib" + paramString + ".so";
    ??? = new File(str1);
    if ((!jdField_a_of_type_Boolean) && (((File)???).exists())) {
      for (;;)
      {
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("face_native_" + paramString, null);
          if (str2 != null) {
            if (str2.equalsIgnoreCase(PortalUtils.a(str1)))
            {
              break label177;
              return bool1;
            }
            else
            {
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " check md5 false!");
              bool1 = bool2;
            }
          }
        }
        label177:
        boolean bool1 = true;
      }
    }
    return false;
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
        QLog.e("FaceScanNativeSoLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      break label290;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("YTCommon"))
      {
        paramHashMap.put("YTCommon", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (str.equalsIgnoreCase("YTFaceCluster"))
        {
          paramHashMap.put("YTFaceCluster", localXmlPullParser.nextText());
          continue;
        }
        if (str.equalsIgnoreCase("nnpack"))
        {
          paramHashMap.put("nnpack", localXmlPullParser.nextText());
          continue;
        }
        if (str.equalsIgnoreCase("YTFaceExtFeature"))
        {
          paramHashMap.put("YTFaceExtFeature", localXmlPullParser.nextText());
          continue;
        }
        if (str.equalsIgnoreCase("YTFaceTrackPro"))
        {
          paramHashMap.put("YTFaceTrackPro", localXmlPullParser.nextText());
          continue;
        }
        if (!str.equalsIgnoreCase("YTFaceClusterJNI_V720")) {
          continue;
        }
        paramHashMap.put("YTFaceClusterJNI_V720", localXmlPullParser.nextText());
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("FaceScanNativeSoLoader", 2, "parseConfig success|config=" + paramHashMap);
        return true;
        label290:
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public static byte b(String paramString)
  {
    byte b3 = 0;
    byte b2 = 0;
    if (paramString == null) {
      return -1;
    }
    String str = a() + "/lib" + paramString + ".so";
    if (QLog.isColorLevel()) {
      QLog.i("FaceScanNativeSoLoader", 2, "start faceNativeSo: " + str);
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
          QLog.i("FaceScanNativeSoLoader", 2, "load " + str + " success!");
          b1 = b2;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        QLog.d("FaceScanNativeSoLoader", 1, "load from face dir failed, libName = " + paramString + "," + localUnsatisfiedLinkError.getMessage());
        b1 = -2;
        continue;
      }
      ARFaceDataCollector.a(paramString, b1);
      return b1;
      byte b1 = b3;
      if (jdField_a_of_type_Boolean)
      {
        b1 = b3;
        if (!localFile.exists()) {
          b1 = -3;
        }
      }
      b2 = b1;
      if (jdField_a_of_type_Boolean)
      {
        b2 = b1;
        if (localFile.exists()) {
          b2 = -4;
        }
      }
      b1 = b2;
      if (!jdField_a_of_type_Boolean)
      {
        b1 = b2;
        if (!localFile.exists()) {
          b1 = -5;
        }
      }
      QLog.d("FaceScanNativeSoLoader", 1, "no face so in face dir,libName = " + paramString);
    }
  }
  
  public static String b()
  {
    return BaseApplicationImpl.sApplication.getFilesDir().getParent() + "/face_scan";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FaceScanNativeSoLoader
 * JD-Core Version:    0.7.0.1
 */
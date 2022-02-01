package com.tencent.mobileqq.ar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Xml;
import com.tencent.aelight.camera.download.old.api.AEOldResInfo;
import com.tencent.aelight.camera.download.old.api.IAEOldResUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arengine.ARFaceDataCollector;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.qroute.QRoute;
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

public class FaceScanNativeSoLoader
{
  private static final Object a;
  public static boolean a = false;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static byte a(String arg0)
  {
    jdField_a_of_type_Boolean = true;
    Object localObject1 = new File(b());
    boolean bool = ((File)localObject1).exists();
    byte b = 2;
    if (bool)
    {
      bool = FileUtil.a((File)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("doOnDownloadSuccess delete oldUncompressedFile:");
        ((StringBuilder)localObject1).append(bool);
        QLog.d("FaceScanNativeSoLoader", 2, ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      try
      {
        a(???, a());
        Object localObject3 = new HashMap();
        SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).edit();
        ??? = new StringBuilder();
        ???.append(a());
        ???.append("/face_native_config.xml");
        localObject1 = new File(???.toString());
        if (((File)localObject1).exists())
        {
          ??? = null;
          try
          {
            localObject1 = FileUtils.readFileToString((File)localObject1);
            ??? = (String)localObject1;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
          if ((??? != null) && (a(???, (HashMap)localObject3))) {
            synchronized (jdField_a_of_type_JavaLangObject)
            {
              Iterator localIterator = ((HashMap)localObject3).entrySet().iterator();
              if (!localIterator.hasNext()) {
                break label570;
              }
              localObject3 = (Map.Entry)localIterator.next();
              Object localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(a());
              ((StringBuilder)localObject4).append("/lib");
              ((StringBuilder)localObject4).append((String)((Map.Entry)localObject3).getKey());
              ((StringBuilder)localObject4).append(".so");
              String str = ((StringBuilder)localObject4).toString();
              localObject4 = new File(str);
              if (!((File)localObject4).exists()) {
                break label565;
              }
              str = PortalUtils.a(str);
              if (!((String)((Map.Entry)localObject3).getValue()).equalsIgnoreCase(str))
              {
                ((File)localObject4).delete();
              }
              else
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("face_native_");
                ((StringBuilder)localObject4).append((String)((Map.Entry)localObject3).getKey());
                localEditor.putString(((StringBuilder)localObject4).toString(), (String)((Map.Entry)localObject3).getValue());
                if (!QLog.isColorLevel()) {
                  continue;
                }
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("doOnDownloadSuccess save sp key =  face_native_");
                ((StringBuilder)localObject4).append((String)((Map.Entry)localObject3).getKey());
                ((StringBuilder)localObject4).append(",value = ");
                ((StringBuilder)localObject4).append((String)((Map.Entry)localObject3).getValue());
                QLog.d("FaceScanNativeSoLoader", 2, ((StringBuilder)localObject4).toString());
                continue;
              }
              localEditor.commit();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoLoader", 2, "config data is not correct");
          }
          b = 4;
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoLoader", 2, "config file is not exist");
          }
          b = 0;
        }
        jdField_a_of_type_Boolean = false;
        return b;
      }
      catch (IOException ???)
      {
        jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("uncompressZip false: ");
          localStringBuilder.append(???.getMessage());
          QLog.d("FaceScanNativeSoLoader", 2, localStringBuilder.toString());
        }
        FileUtils.delete(a(), false);
        return -1;
      }
      label565:
      b = 3;
      continue;
      label570:
      b = 0;
    }
  }
  
  public static String a()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FaceScanNativeSoLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject);
    localStringBuilder.append("/pddata/prd/face_scan_so_v795");
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFaceLibPath ,path = ");
      localStringBuilder.append((String)localObject);
      QLog.i("FaceScanNativeSoLoader", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a());
    ((StringBuilder)localObject).append("/lib");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".so");
    ((StringBuilder)localObject).toString();
    localObject = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("face_native_");
    localStringBuilder.append(paramString);
    localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), null);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFaceSoMd5 ,soName = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",md5 = ");
      localStringBuilder.append((String)localObject);
      QLog.i("FaceScanNativeSoLoader", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: new 46	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 207
    //   17: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 58
    //   29: iconst_2
    //   30: aload_3
    //   31: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aconst_null
    //   38: astore 4
    //   40: new 209	com/tencent/commonsdk/zip/QZipFile
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 210	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 214	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   53: astore 6
    //   55: sipush 8192
    //   58: newarray byte
    //   60: astore 7
    //   62: aload 6
    //   64: invokeinterface 219 1 0
    //   69: ifeq +338 -> 407
    //   72: aload 6
    //   74: invokeinterface 222 1 0
    //   79: checkcast 224	java/util/zip/ZipEntry
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 227	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   87: astore 5
    //   89: aload 5
    //   91: ifnull -29 -> 62
    //   94: aload 5
    //   96: ldc 229
    //   98: invokevirtual 233	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +6 -> 107
    //   104: goto -42 -> 62
    //   107: new 46	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   114: astore 8
    //   116: aload 8
    //   118: aload_1
    //   119: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 8
    //   125: getstatic 237	java/io/File:separator	Ljava/lang/String;
    //   128: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 8
    //   134: aload 5
    //   136: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 8
    //   142: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore 5
    //   147: aload_0
    //   148: invokevirtual 240	java/util/zip/ZipEntry:isDirectory	()Z
    //   151: ifeq +28 -> 179
    //   154: new 23	java/io/File
    //   157: dup
    //   158: aload 5
    //   160: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 34	java/io/File:exists	()Z
    //   168: ifne -106 -> 62
    //   171: aload_0
    //   172: invokevirtual 243	java/io/File:mkdir	()Z
    //   175: pop
    //   176: goto -114 -> 62
    //   179: aload 5
    //   181: getstatic 237	java/io/File:separator	Ljava/lang/String;
    //   184: invokevirtual 247	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   187: istore_2
    //   188: aload 5
    //   190: iconst_0
    //   191: iload_2
    //   192: invokevirtual 251	java/lang/String:substring	(II)Ljava/lang/String;
    //   195: astore 8
    //   197: aload 5
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: invokevirtual 254	java/lang/String:substring	(I)Ljava/lang/String;
    //   205: ldc_w 256
    //   208: invokevirtual 259	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   211: ifeq +6 -> 217
    //   214: goto -152 -> 62
    //   217: new 23	java/io/File
    //   220: dup
    //   221: aload 8
    //   223: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   226: astore 8
    //   228: aload 8
    //   230: invokevirtual 34	java/io/File:exists	()Z
    //   233: ifne +9 -> 242
    //   236: aload 8
    //   238: invokevirtual 243	java/io/File:mkdir	()Z
    //   241: pop
    //   242: new 46	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 47	java/lang/StringBuilder:<init>	()V
    //   249: astore 8
    //   251: aload 8
    //   253: aload 5
    //   255: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 8
    //   261: ldc_w 261
    //   264: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: new 23	java/io/File
    //   271: dup
    //   272: aload 8
    //   274: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   280: astore 8
    //   282: new 23	java/io/File
    //   285: dup
    //   286: aload 5
    //   288: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   291: astore 9
    //   293: aload 8
    //   295: invokevirtual 34	java/io/File:exists	()Z
    //   298: ifeq +9 -> 307
    //   301: aload 8
    //   303: invokevirtual 150	java/io/File:delete	()Z
    //   306: pop
    //   307: new 263	java/io/FileOutputStream
    //   310: dup
    //   311: aload 8
    //   313: invokespecial 266	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   316: astore 5
    //   318: aload_3
    //   319: aload_0
    //   320: invokevirtual 270	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   323: astore_0
    //   324: aload_0
    //   325: aload 7
    //   327: iconst_0
    //   328: aload 7
    //   330: arraylength
    //   331: invokevirtual 276	java/io/InputStream:read	([BII)I
    //   334: istore_2
    //   335: iload_2
    //   336: iconst_m1
    //   337: if_icmpeq +15 -> 352
    //   340: aload 5
    //   342: aload 7
    //   344: iconst_0
    //   345: iload_2
    //   346: invokevirtual 280	java/io/FileOutputStream:write	([BII)V
    //   349: goto -25 -> 324
    //   352: aload 5
    //   354: invokevirtual 283	java/io/FileOutputStream:flush	()V
    //   357: aload 5
    //   359: invokevirtual 286	java/io/FileOutputStream:close	()V
    //   362: aload_0
    //   363: invokevirtual 287	java/io/InputStream:close	()V
    //   366: aload 8
    //   368: aload 9
    //   370: invokestatic 291	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   373: ifne -311 -> 62
    //   376: aload 8
    //   378: aload 9
    //   380: invokestatic 294	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   383: pop
    //   384: goto -322 -> 62
    //   387: astore 4
    //   389: aload_0
    //   390: astore_1
    //   391: aload 4
    //   393: astore_0
    //   394: goto +6 -> 400
    //   397: astore_0
    //   398: aconst_null
    //   399: astore_1
    //   400: aload 5
    //   402: astore 4
    //   404: goto +25 -> 429
    //   407: aload_3
    //   408: invokevirtual 295	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   411: return
    //   412: astore_0
    //   413: aload_0
    //   414: invokevirtual 102	java/io/IOException:printStackTrace	()V
    //   417: return
    //   418: astore_0
    //   419: aconst_null
    //   420: astore_1
    //   421: goto +8 -> 429
    //   424: astore_0
    //   425: aconst_null
    //   426: astore_3
    //   427: aload_3
    //   428: astore_1
    //   429: aload 4
    //   431: ifnull +18 -> 449
    //   434: aload 4
    //   436: invokevirtual 286	java/io/FileOutputStream:close	()V
    //   439: goto +10 -> 449
    //   442: astore 4
    //   444: aload 4
    //   446: invokevirtual 102	java/io/IOException:printStackTrace	()V
    //   449: aload_1
    //   450: ifnull +15 -> 465
    //   453: aload_1
    //   454: invokevirtual 287	java/io/InputStream:close	()V
    //   457: goto +8 -> 465
    //   460: astore_1
    //   461: aload_1
    //   462: invokevirtual 102	java/io/IOException:printStackTrace	()V
    //   465: aload_3
    //   466: ifnull +15 -> 481
    //   469: aload_3
    //   470: invokevirtual 295	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   473: goto +8 -> 481
    //   476: astore_1
    //   477: aload_1
    //   478: invokevirtual 102	java/io/IOException:printStackTrace	()V
    //   481: goto +5 -> 486
    //   484: aload_0
    //   485: athrow
    //   486: goto -2 -> 484
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	paramString1	String
    //   0	489	1	paramString2	String
    //   187	159	2	i	int
    //   13	457	3	localObject1	Object
    //   38	1	4	localObject2	Object
    //   387	5	4	localObject3	Object
    //   402	33	4	localObject4	Object
    //   442	3	4	localIOException	IOException
    //   87	314	5	localObject5	Object
    //   53	20	6	localEnumeration	java.util.Enumeration
    //   60	283	7	arrayOfByte	byte[]
    //   114	263	8	localObject6	Object
    //   291	88	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   324	335	387	finally
    //   340	349	387	finally
    //   352	366	387	finally
    //   318	324	397	finally
    //   407	411	412	java/io/IOException
    //   49	62	418	finally
    //   62	89	418	finally
    //   94	104	418	finally
    //   107	176	418	finally
    //   179	214	418	finally
    //   217	242	418	finally
    //   242	307	418	finally
    //   307	318	418	finally
    //   366	384	418	finally
    //   40	49	424	finally
    //   434	439	442	java/io/IOException
    //   453	457	460	java/io/IOException
    //   469	473	476	java/io/IOException
  }
  
  public static boolean a()
  {
    if ((FileUtil.b(d())) && (FileUtil.b(c())) && (a("YTFaceCluster")) && (a("YTFaceExtFeature")) && (FileUtil.b(e())) && (a("YTFaceClusterJNI_V852")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoLoader", 2, "isAllSoFileReady true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoLoader", 2, "isAllSoFileReady native so is not exist!");
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append(a());
    ((StringBuilder)???).append("/lib");
    ((StringBuilder)???).append(paramString);
    ((StringBuilder)???).append(".so");
    Object localObject2 = ((StringBuilder)???).toString();
    ??? = new File((String)localObject2);
    boolean bool4 = jdField_a_of_type_Boolean;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (!bool4)
    {
      bool1 = bool3;
      if (!((File)???).exists()) {}
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        Object localObject3 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("face_native_");
        localStringBuilder.append(paramString);
        localObject3 = ((SharedPreferences)localObject3).getString(localStringBuilder.toString(), null);
        localObject2 = PortalUtils.a((String)localObject2);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSoFileExist: soName= ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" ,spmd5 = ");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(",fileMD5 = ");
          localStringBuilder.append((String)localObject2);
          QLog.d("FaceScanNativeSoLoader", 2, localStringBuilder.toString());
        }
        if ((localObject3 == null) || (((String)localObject3).equalsIgnoreCase((String)localObject2))) {
          break label392;
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("isSoFileExist: soName= ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" check md5 false!");
          QLog.d("FaceScanNativeSoLoader", 2, ((StringBuilder)localObject2).toString());
          bool1 = bool2;
        }
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("isSoFileExist: soName= ");
        ((StringBuilder)???).append(paramString);
        ((StringBuilder)???).append(" ,result = ");
        ((StringBuilder)???).append(bool1);
        ((StringBuilder)???).append(",isUncompressZip = ");
        ((StringBuilder)???).append(jdField_a_of_type_Boolean);
        QLog.d("FaceScanNativeSoLoader", 2, ((StringBuilder)???).toString());
      }
      return bool1;
      label392:
      bool1 = true;
    }
  }
  
  public static boolean a(String paramString, HashMap<String, String> paramHashMap)
  {
    Object localObject = Xml.newPullParser();
    paramHashMap.clear();
    int i;
    try
    {
      ((XmlPullParser)localObject).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      i = ((XmlPullParser)localObject).getEventType();
    }
    catch (Exception paramHashMap)
    {
      String str;
      if (!QLog.isColorLevel()) {
        break label192;
      }
      QLog.e("FaceScanNativeSoLoader", 2, paramString, paramHashMap);
      label192:
      return false;
    }
    str = ((XmlPullParser)localObject).getName();
    if (str.equalsIgnoreCase("YTFaceCluster")) {
      paramHashMap.put("YTFaceCluster", ((XmlPullParser)localObject).nextText());
    } else if (str.equalsIgnoreCase("YTFaceExtFeature")) {
      paramHashMap.put("YTFaceExtFeature", ((XmlPullParser)localObject).nextText());
    } else if (str.equalsIgnoreCase("YTFaceClusterJNI_V852")) {
      paramHashMap.put("YTFaceClusterJNI_V852", ((XmlPullParser)localObject).nextText());
    }
    for (;;)
    {
      i = ((XmlPullParser)localObject).next();
      while (i == 1)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseConfig success|config=");
          ((StringBuilder)localObject).append(paramHashMap);
          QLog.d("FaceScanNativeSoLoader", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      if (i == 2) {
        break;
      }
    }
  }
  
  public static byte b(String paramString)
  {
    byte b;
    try
    {
      System.load(paramString);
      b = 0;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FaceScanNativeSoLoader", 2, "loadSoByPath error", localUnsatisfiedLinkError);
      }
      b = -2;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadSoByPath ret = ");
      localStringBuilder.append(b);
      localStringBuilder.append(",soPath = ");
      localStringBuilder.append(paramString);
      QLog.d("FaceScanNativeSoLoader", 2, localStringBuilder.toString());
    }
    return b;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.sApplication.getFilesDir().getParent());
    localStringBuilder.append("/face_scan");
    return localStringBuilder.toString();
  }
  
  public static byte c(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(a());
    ((StringBuilder)localObject1).append("/lib");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(".so");
    localObject1 = ((StringBuilder)localObject1).toString();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadFaceNativeSo start faceNativeSo: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("FaceScanNativeSoLoader", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new File((String)localObject1);
    boolean bool = jdField_a_of_type_Boolean;
    byte b3 = 0;
    byte b2 = 0;
    byte b1;
    if ((!bool) && (((File)localObject2).exists()))
    {
      try
      {
        System.load((String)localObject1);
        b1 = b3;
        if (!QLog.isColorLevel()) {
          break label357;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("load ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" success!");
        QLog.i("FaceScanNativeSoLoader", 2, ((StringBuilder)localObject2).toString());
        b1 = b3;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadFaceNativeSo load from face dir failed, libName = ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(localUnsatisfiedLinkError.getMessage());
        QLog.d("FaceScanNativeSoLoader", 1, ((StringBuilder)localObject2).toString());
        b1 = -2;
      }
    }
    else
    {
      b1 = b2;
      if (jdField_a_of_type_Boolean)
      {
        b1 = b2;
        if (!((File)localObject2).exists()) {
          b1 = -3;
        }
      }
      b2 = b1;
      if (jdField_a_of_type_Boolean)
      {
        b2 = b1;
        if (((File)localObject2).exists()) {
          b2 = -4;
        }
      }
      b1 = b2;
      if (!jdField_a_of_type_Boolean)
      {
        b1 = b2;
        if (!((File)localObject2).exists()) {
          b1 = -5;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadFaceNativeSo no face so in face dir,libName = ");
      localStringBuilder.append(paramString);
      QLog.d("FaceScanNativeSoLoader", 1, localStringBuilder.toString());
    }
    label357:
    ARFaceDataCollector.a(paramString, b1);
    return b1;
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IAEOldResUtil)QRoute.api(IAEOldResUtil.class)).getFinalUnzippedPackageDir(AEOldResInfo.b));
    localStringBuilder.append("libc++_shared.so");
    return localStringBuilder.toString();
  }
  
  public static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IAEOldResUtil)QRoute.api(IAEOldResUtil.class)).getFinalUnzippedPackageDir(AEOldResInfo.b));
    localStringBuilder.append("libopencv_tinyworld.so");
    return localStringBuilder.toString();
  }
  
  public static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IAEOldResUtil)QRoute.api(IAEOldResUtil.class)).getFinalUnzippedPackageDir(AEOldResInfo.b));
    localStringBuilder.append("libYTFaceTracker.so");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FaceScanNativeSoLoader
 * JD-Core Version:    0.7.0.1
 */
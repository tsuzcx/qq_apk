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
  public static boolean a = false;
  private static final Object b = new Object();
  
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
    //   0: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: new 48	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 93
    //   17: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 38
    //   29: iconst_2
    //   30: aload_3
    //   31: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aconst_null
    //   38: astore 4
    //   40: new 98	com/tencent/commonsdk/zip/QZipFile
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 101	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 105	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   53: astore 6
    //   55: sipush 8192
    //   58: newarray byte
    //   60: astore 7
    //   62: aload 6
    //   64: invokeinterface 110 1 0
    //   69: ifeq +336 -> 405
    //   72: aload 6
    //   74: invokeinterface 114 1 0
    //   79: checkcast 116	java/util/zip/ZipEntry
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 119	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   87: astore 5
    //   89: aload 5
    //   91: ifnull -29 -> 62
    //   94: aload 5
    //   96: ldc 121
    //   98: invokevirtual 127	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +6 -> 107
    //   104: goto -42 -> 62
    //   107: new 48	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   114: astore 8
    //   116: aload 8
    //   118: aload_1
    //   119: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 8
    //   125: getstatic 133	java/io/File:separator	Ljava/lang/String;
    //   128: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 8
    //   134: aload 5
    //   136: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 8
    //   142: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore 5
    //   147: aload_0
    //   148: invokevirtual 136	java/util/zip/ZipEntry:isDirectory	()Z
    //   151: ifeq +28 -> 179
    //   154: new 129	java/io/File
    //   157: dup
    //   158: aload 5
    //   160: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 140	java/io/File:exists	()Z
    //   168: ifne -106 -> 62
    //   171: aload_0
    //   172: invokevirtual 143	java/io/File:mkdir	()Z
    //   175: pop
    //   176: goto -114 -> 62
    //   179: aload 5
    //   181: getstatic 133	java/io/File:separator	Ljava/lang/String;
    //   184: invokevirtual 147	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   187: istore_2
    //   188: aload 5
    //   190: iconst_0
    //   191: iload_2
    //   192: invokevirtual 151	java/lang/String:substring	(II)Ljava/lang/String;
    //   195: astore 8
    //   197: aload 5
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: invokevirtual 154	java/lang/String:substring	(I)Ljava/lang/String;
    //   205: ldc 156
    //   207: invokevirtual 160	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   210: ifeq +6 -> 216
    //   213: goto -151 -> 62
    //   216: new 129	java/io/File
    //   219: dup
    //   220: aload 8
    //   222: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   225: astore 8
    //   227: aload 8
    //   229: invokevirtual 140	java/io/File:exists	()Z
    //   232: ifne +9 -> 241
    //   235: aload 8
    //   237: invokevirtual 143	java/io/File:mkdir	()Z
    //   240: pop
    //   241: new 48	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   248: astore 8
    //   250: aload 8
    //   252: aload 5
    //   254: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 8
    //   260: ldc 162
    //   262: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: new 129	java/io/File
    //   269: dup
    //   270: aload 8
    //   272: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   278: astore 8
    //   280: new 129	java/io/File
    //   283: dup
    //   284: aload 5
    //   286: invokespecial 137	java/io/File:<init>	(Ljava/lang/String;)V
    //   289: astore 9
    //   291: aload 8
    //   293: invokevirtual 140	java/io/File:exists	()Z
    //   296: ifeq +9 -> 305
    //   299: aload 8
    //   301: invokevirtual 165	java/io/File:delete	()Z
    //   304: pop
    //   305: new 167	java/io/FileOutputStream
    //   308: dup
    //   309: aload 8
    //   311: invokespecial 170	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   314: astore 5
    //   316: aload_3
    //   317: aload_0
    //   318: invokevirtual 174	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   321: astore_0
    //   322: aload_0
    //   323: aload 7
    //   325: iconst_0
    //   326: aload 7
    //   328: arraylength
    //   329: invokevirtual 180	java/io/InputStream:read	([BII)I
    //   332: istore_2
    //   333: iload_2
    //   334: iconst_m1
    //   335: if_icmpeq +15 -> 350
    //   338: aload 5
    //   340: aload 7
    //   342: iconst_0
    //   343: iload_2
    //   344: invokevirtual 184	java/io/FileOutputStream:write	([BII)V
    //   347: goto -25 -> 322
    //   350: aload 5
    //   352: invokevirtual 187	java/io/FileOutputStream:flush	()V
    //   355: aload 5
    //   357: invokevirtual 190	java/io/FileOutputStream:close	()V
    //   360: aload_0
    //   361: invokevirtual 191	java/io/InputStream:close	()V
    //   364: aload 8
    //   366: aload 9
    //   368: invokestatic 197	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   371: ifne -309 -> 62
    //   374: aload 8
    //   376: aload 9
    //   378: invokestatic 200	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   381: pop
    //   382: goto -320 -> 62
    //   385: astore 4
    //   387: aload_0
    //   388: astore_1
    //   389: aload 4
    //   391: astore_0
    //   392: goto +6 -> 398
    //   395: astore_0
    //   396: aconst_null
    //   397: astore_1
    //   398: aload 5
    //   400: astore 4
    //   402: goto +25 -> 427
    //   405: aload_3
    //   406: invokevirtual 201	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   409: return
    //   410: astore_0
    //   411: aload_0
    //   412: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   415: return
    //   416: astore_0
    //   417: aconst_null
    //   418: astore_1
    //   419: goto +8 -> 427
    //   422: astore_0
    //   423: aconst_null
    //   424: astore_3
    //   425: aload_3
    //   426: astore_1
    //   427: aload 4
    //   429: ifnull +18 -> 447
    //   432: aload 4
    //   434: invokevirtual 190	java/io/FileOutputStream:close	()V
    //   437: goto +10 -> 447
    //   440: astore 4
    //   442: aload 4
    //   444: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   447: aload_1
    //   448: ifnull +15 -> 463
    //   451: aload_1
    //   452: invokevirtual 191	java/io/InputStream:close	()V
    //   455: goto +8 -> 463
    //   458: astore_1
    //   459: aload_1
    //   460: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   463: aload_3
    //   464: ifnull +15 -> 479
    //   467: aload_3
    //   468: invokevirtual 201	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   471: goto +8 -> 479
    //   474: astore_1
    //   475: aload_1
    //   476: invokevirtual 204	java/io/IOException:printStackTrace	()V
    //   479: goto +5 -> 484
    //   482: aload_0
    //   483: athrow
    //   484: goto -2 -> 482
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	paramString1	String
    //   0	487	1	paramString2	String
    //   187	157	2	i	int
    //   13	455	3	localObject1	Object
    //   38	1	4	localObject2	Object
    //   385	5	4	localObject3	Object
    //   400	33	4	localObject4	Object
    //   440	3	4	localIOException	IOException
    //   87	312	5	localObject5	Object
    //   53	20	6	localEnumeration	java.util.Enumeration
    //   60	281	7	arrayOfByte	byte[]
    //   114	261	8	localObject6	Object
    //   289	88	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   322	333	385	finally
    //   338	347	385	finally
    //   350	364	385	finally
    //   316	322	395	finally
    //   405	409	410	java/io/IOException
    //   49	62	416	finally
    //   62	89	416	finally
    //   94	104	416	finally
    //   107	176	416	finally
    //   179	213	416	finally
    //   216	241	416	finally
    //   241	305	416	finally
    //   305	316	416	finally
    //   364	382	416	finally
    //   40	49	422	finally
    //   432	437	440	java/io/IOException
    //   451	455	458	java/io/IOException
    //   467	471	474	java/io/IOException
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
        break label187;
      }
      QLog.e("FaceScanNativeSoLoader", 2, paramString, paramHashMap);
      label187:
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
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.sApplication.getFilesDir().getParent());
    localStringBuilder.append("/face_scan");
    return localStringBuilder.toString();
  }
  
  public static boolean b(String paramString)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append(a());
    ((StringBuilder)???).append("/lib");
    ((StringBuilder)???).append(paramString);
    ((StringBuilder)???).append(".so");
    Object localObject2 = ((StringBuilder)???).toString();
    ??? = new File((String)localObject2);
    boolean bool4 = a;
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
      synchronized (b)
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
        ((StringBuilder)???).append(a);
        QLog.d("FaceScanNativeSoLoader", 2, ((StringBuilder)???).toString());
      }
      return bool1;
      label392:
      bool1 = true;
    }
  }
  
  public static byte c(String arg0)
  {
    a = true;
    Object localObject1 = new File(b());
    boolean bool = ((File)localObject1).exists();
    byte b1 = 2;
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
            synchronized (b)
            {
              Iterator localIterator = ((HashMap)localObject3).entrySet().iterator();
              if (!localIterator.hasNext()) {
                break label577;
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
                break label572;
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
          b1 = 4;
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("FaceScanNativeSoLoader", 2, "config file is not exist");
          }
          b1 = 0;
        }
        a = false;
        return b1;
      }
      catch (IOException ???)
      {
        a = false;
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
      label572:
      b1 = 3;
      continue;
      label577:
      b1 = 0;
    }
  }
  
  public static boolean c()
  {
    if ((FileUtil.d(e())) && (FileUtil.d(d())) && (b("YTFaceCluster")) && (b("YTFaceExtFeature")) && (FileUtil.d(f())) && (b("YTFaceClusterJNI_V852")))
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
  
  public static byte d(String paramString)
  {
    byte b1;
    try
    {
      System.load(paramString);
      b1 = 0;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FaceScanNativeSoLoader", 2, "loadSoByPath error", localUnsatisfiedLinkError);
      }
      b1 = -2;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadSoByPath ret = ");
      localStringBuilder.append(b1);
      localStringBuilder.append(",soPath = ");
      localStringBuilder.append(paramString);
      QLog.d("FaceScanNativeSoLoader", 2, localStringBuilder.toString());
    }
    return b1;
  }
  
  public static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IAEOldResUtil)QRoute.api(IAEOldResUtil.class)).getFinalUnzippedPackageDir(AEOldResInfo.b));
    localStringBuilder.append("libc++_shared.so");
    return localStringBuilder.toString();
  }
  
  public static byte e(String paramString)
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
    boolean bool = a;
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
      if (a)
      {
        b1 = b2;
        if (!((File)localObject2).exists()) {
          b1 = -3;
        }
      }
      b2 = b1;
      if (a)
      {
        b2 = b1;
        if (((File)localObject2).exists()) {
          b2 = -4;
        }
      }
      b1 = b2;
      if (!a)
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
  
  public static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IAEOldResUtil)QRoute.api(IAEOldResUtil.class)).getFinalUnzippedPackageDir(AEOldResInfo.b));
    localStringBuilder.append("libopencv_tinyworld.so");
    return localStringBuilder.toString();
  }
  
  public static String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((IAEOldResUtil)QRoute.api(IAEOldResUtil.class)).getFinalUnzippedPackageDir(AEOldResInfo.b));
    localStringBuilder.append("libYTFaceTracker.so");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FaceScanNativeSoLoader
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Xml;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

public class FaceScanModelsLoader
{
  public static boolean a = false;
  public static volatile boolean b = false;
  public static volatile boolean c = false;
  private static final Object d = new Object();
  
  public static void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uninitModels start hasFaceModelInit = ");
      localStringBuilder.append(b);
      QLog.d("FaceScanModelsLoader", 2, localStringBuilder.toString());
    }
    c = true;
    if (b)
    {
      FaceCluster.getInstance().release();
      b = false;
    }
    c = false;
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanModelsLoader", 2, "uninitModels finish");
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 29	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +34 -> 37
    //   6: new 31	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 66
    //   17: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 43
    //   29: iconst_2
    //   30: aload_3
    //   31: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aconst_null
    //   38: astore 4
    //   40: new 68	com/tencent/commonsdk/zip/QZipFile
    //   43: dup
    //   44: aload_0
    //   45: invokespecial 71	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 75	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   53: astore 6
    //   55: sipush 8192
    //   58: newarray byte
    //   60: astore 7
    //   62: aload 6
    //   64: invokeinterface 80 1 0
    //   69: ifeq +336 -> 405
    //   72: aload 6
    //   74: invokeinterface 84 1 0
    //   79: checkcast 86	java/util/zip/ZipEntry
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 89	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   87: astore 5
    //   89: aload 5
    //   91: ifnull -29 -> 62
    //   94: aload 5
    //   96: ldc 91
    //   98: invokevirtual 97	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifeq +6 -> 107
    //   104: goto -42 -> 62
    //   107: new 31	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   114: astore 8
    //   116: aload 8
    //   118: aload_1
    //   119: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 8
    //   125: getstatic 103	java/io/File:separator	Ljava/lang/String;
    //   128: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 8
    //   134: aload 5
    //   136: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload 8
    //   142: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore 5
    //   147: aload_0
    //   148: invokevirtual 106	java/util/zip/ZipEntry:isDirectory	()Z
    //   151: ifeq +28 -> 179
    //   154: new 99	java/io/File
    //   157: dup
    //   158: aload 5
    //   160: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 110	java/io/File:exists	()Z
    //   168: ifne -106 -> 62
    //   171: aload_0
    //   172: invokevirtual 113	java/io/File:mkdir	()Z
    //   175: pop
    //   176: goto -114 -> 62
    //   179: aload 5
    //   181: getstatic 103	java/io/File:separator	Ljava/lang/String;
    //   184: invokevirtual 117	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   187: istore_2
    //   188: aload 5
    //   190: iconst_0
    //   191: iload_2
    //   192: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   195: astore 8
    //   197: aload 5
    //   199: iload_2
    //   200: iconst_1
    //   201: iadd
    //   202: invokevirtual 124	java/lang/String:substring	(I)Ljava/lang/String;
    //   205: ldc 126
    //   207: invokevirtual 130	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   210: ifeq +6 -> 216
    //   213: goto -151 -> 62
    //   216: new 99	java/io/File
    //   219: dup
    //   220: aload 8
    //   222: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   225: astore 8
    //   227: aload 8
    //   229: invokevirtual 110	java/io/File:exists	()Z
    //   232: ifne +9 -> 241
    //   235: aload 8
    //   237: invokevirtual 113	java/io/File:mkdir	()Z
    //   240: pop
    //   241: new 31	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   248: astore 8
    //   250: aload 8
    //   252: aload 5
    //   254: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 8
    //   260: ldc 132
    //   262: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: new 99	java/io/File
    //   269: dup
    //   270: aload 8
    //   272: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   278: astore 8
    //   280: new 99	java/io/File
    //   283: dup
    //   284: aload 5
    //   286: invokespecial 107	java/io/File:<init>	(Ljava/lang/String;)V
    //   289: astore 9
    //   291: aload 8
    //   293: invokevirtual 110	java/io/File:exists	()Z
    //   296: ifeq +9 -> 305
    //   299: aload 8
    //   301: invokevirtual 135	java/io/File:delete	()Z
    //   304: pop
    //   305: new 137	java/io/FileOutputStream
    //   308: dup
    //   309: aload 8
    //   311: invokespecial 140	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   314: astore 5
    //   316: aload_3
    //   317: aload_0
    //   318: invokevirtual 144	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   321: astore_0
    //   322: aload_0
    //   323: aload 7
    //   325: iconst_0
    //   326: aload 7
    //   328: arraylength
    //   329: invokevirtual 150	java/io/InputStream:read	([BII)I
    //   332: istore_2
    //   333: iload_2
    //   334: iconst_m1
    //   335: if_icmpeq +15 -> 350
    //   338: aload 5
    //   340: aload 7
    //   342: iconst_0
    //   343: iload_2
    //   344: invokevirtual 154	java/io/FileOutputStream:write	([BII)V
    //   347: goto -25 -> 322
    //   350: aload 5
    //   352: invokevirtual 157	java/io/FileOutputStream:flush	()V
    //   355: aload 5
    //   357: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   360: aload_0
    //   361: invokevirtual 161	java/io/InputStream:close	()V
    //   364: aload 8
    //   366: aload 9
    //   368: invokestatic 167	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   371: ifne -309 -> 62
    //   374: aload 8
    //   376: aload 9
    //   378: invokestatic 170	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
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
    //   406: invokevirtual 171	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   409: return
    //   410: astore_0
    //   411: aload_0
    //   412: invokevirtual 174	java/io/IOException:printStackTrace	()V
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
    //   434: invokevirtual 160	java/io/FileOutputStream:close	()V
    //   437: goto +10 -> 447
    //   440: astore 4
    //   442: aload 4
    //   444: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   447: aload_1
    //   448: ifnull +15 -> 463
    //   451: aload_1
    //   452: invokevirtual 161	java/io/InputStream:close	()V
    //   455: goto +8 -> 463
    //   458: astore_1
    //   459: aload_1
    //   460: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   463: aload_3
    //   464: ifnull +15 -> 479
    //   467: aload_3
    //   468: invokevirtual 171	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   471: goto +8 -> 479
    //   474: astore_1
    //   475: aload_1
    //   476: invokevirtual 174	java/io/IOException:printStackTrace	()V
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
  
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    if (b) {
      return b;
    }
    FaceCluster.getInstance();
    YTCommonInterface.initAuthForQQ(paramContext);
    if (FaceCluster.getInstance().isLoadSoSuccess()) {
      bool = b(paramContext);
    } else {
      QLog.d("FaceScanModelsLoader", 1, "initModels loadSo failed");
    }
    b = bool;
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("initModels result = ");
      paramContext.append(bool);
      QLog.d("FaceScanModelsLoader", 2, paramContext.toString());
    }
    return bool;
  }
  
  public static boolean a(String paramString)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append(b());
    ((StringBuilder)???).append(File.separator);
    ((StringBuilder)???).append(paramString);
    Object localObject2 = ((StringBuilder)???).toString();
    ??? = new File((String)localObject2);
    boolean bool1 = a;
    boolean bool2 = false;
    if ((!bool1) && (((File)???).exists())) {}
    for (;;)
    {
      synchronized (d)
      {
        Object localObject3 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("face_models_");
        localStringBuilder.append(paramString);
        localObject3 = ((SharedPreferences)localObject3).getString(localStringBuilder.toString(), null);
        if ((localObject3 == null) || (((String)localObject3).equalsIgnoreCase(PortalUtils.a((String)localObject2)))) {
          break label207;
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("isModelFileExist: modelName= ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" check md5 false!");
          QLog.d("FaceScanModelsLoader", 2, ((StringBuilder)localObject2).toString());
          bool1 = bool2;
        }
        return bool1;
      }
      return false;
      label207:
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
        break label163;
      }
      QLog.e("FaceScanModelsLoader", 2, paramString, paramHashMap);
      label163:
      return false;
    }
    str = ((XmlPullParser)localObject).getName();
    if (str.equalsIgnoreCase("fc_eval.rpdm")) {
      paramHashMap.put("fc_eval.rpdm", ((XmlPullParser)localObject).nextText());
    } else if (str.equalsIgnoreCase("rpn_fr_cluster_256_norelu.model")) {
      paramHashMap.put("rpn_fr_cluster_256_norelu.model", ((XmlPullParser)localObject).nextText());
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
          QLog.d("FaceScanModelsLoader", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      if (i == 2) {
        break;
      }
    }
  }
  
  public static byte b(String arg0)
  {
    a = true;
    Object localObject1 = new File(c());
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
        QLog.d("FaceScanModelsLoader", 2, ((StringBuilder)localObject1).toString());
      }
    }
    for (;;)
    {
      try
      {
        a(???, b());
        Object localObject3 = new HashMap();
        SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
        ??? = new StringBuilder();
        ???.append(b());
        ???.append("/face_models_config.xml");
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
            synchronized (d)
            {
              Iterator localIterator = ((HashMap)localObject3).entrySet().iterator();
              if (!localIterator.hasNext()) {
                break label521;
              }
              localObject3 = (Map.Entry)localIterator.next();
              Object localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(b());
              ((StringBuilder)localObject4).append(File.separator);
              ((StringBuilder)localObject4).append((String)((Map.Entry)localObject3).getKey());
              String str = ((StringBuilder)localObject4).toString();
              localObject4 = new File(str);
              if (!((File)localObject4).exists()) {
                break label516;
              }
              str = PortalUtils.a(str);
              if (!((String)((Map.Entry)localObject3).getValue()).equalsIgnoreCase(str))
              {
                ((File)localObject4).delete();
              }
              else
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("face_models_");
                ((StringBuilder)localObject4).append((String)((Map.Entry)localObject3).getKey());
                localEditor.putString(((StringBuilder)localObject4).toString(), (String)((Map.Entry)localObject3).getValue());
                continue;
              }
              localEditor.commit();
            }
          }
          byte b2 = 4;
          b1 = b2;
          if (QLog.isColorLevel())
          {
            QLog.d("FaceScanModelsLoader", 2, "config data is not correct");
            b1 = b2;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("FaceScanModelsLoader", 2, "config file is not exist");
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
          QLog.d("FaceScanModelsLoader", 2, localStringBuilder.toString());
        }
        FileUtils.delete(b(), false);
        return -1;
      }
      label516:
      b1 = 3;
      continue;
      label521:
      b1 = 0;
    }
  }
  
  public static String b()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FaceScanModelsLoader", 2, "getFilesDir is null");
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObject);
    localStringBuilder.append("/pddata/prd/face_scan_models");
    localObject = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFaceModelsPath ,path = ");
      localStringBuilder.append((String)localObject);
      QLog.i("FaceScanModelsLoader", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = b();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("ufdmtcc.bin");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramContext);
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append("ufat.bin");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(File.separator);
    paramContext = localStringBuilder.toString();
    return FaceCluster.getInstance().init((String)localObject1, (String)localObject2, paramContext) == 0;
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.sApplication.getFilesDir().getParent());
    localStringBuilder.append("/face_models");
    return localStringBuilder.toString();
  }
  
  public static boolean d()
  {
    if ((a("fc_eval.rpdm")) && (a("rpn_fr_cluster_256_norelu.model"))) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanModelsLoader", 2, "modules is not exist!");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FaceScanModelsLoader
 * JD-Core Version:    0.7.0.1
 */
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

public class ArCloudNativeSoLoader
{
  public static int a(String paramString)
  {
    try
    {
      int i = ArNativeSoLoaderBase.a("arcloud", "v8.4.1.1", ArNativeSoLoaderBase.b("arcloud", "v8.4.1.1", "arcloud"), paramString);
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
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doOnDownloadSuccess. soResFilename = ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", soResMd5FromConfig = ");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.i("AREngine_ArCloudNativeSoLoader", 2, ((StringBuilder)localObject1).toString());
      ArNativeSoLoaderBase.a("arcloud", "v8.4.1.1", "arcloud", paramString2);
      paramString2 = ArNativeSoLoaderBase.a("arcloud", "v8.4.1.1", paramString2);
    }
    finally
    {
      Object localObject1;
      Object localObject2;
      label528:
      label681:
      for (;;)
      {
        label579:
        throw paramString1;
      }
    }
    try
    {
      ArConfigUtils.a(paramString1, paramString2);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("md5_config.xml");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new File((String)localObject1);
      if (((File)localObject2).exists()) {
        new HashMap();
      }
    }
    catch (IOException localIOException)
    {
      break label681;
    }
    try
    {
      localObject1 = a(FileUtils.readFileToString((File)localObject2));
      if (((HashMap)localObject1).size() > 0)
      {
        localObject1 = ((HashMap)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          Object localObject3 = (String)((Map.Entry)localObject2).getKey();
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append(File.separator);
          paramString1.append((String)localObject3);
          paramString1.append(".so");
          paramString1 = paramString1.toString();
          ArNativeSoLoaderBase.a("arcloud", "v8.4.1.1", (String)localObject3, (String)((Map.Entry)localObject2).getValue());
          localObject3 = new File(paramString1);
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("doOnDownloadSuccess. soFilename = ");
          ((StringBuilder)localObject4).append(paramString1);
          QLog.i("AREngine_ArCloudNativeSoLoader", 2, ((StringBuilder)localObject4).toString());
          if (((File)localObject3).exists())
          {
            localObject4 = PortalUtils.a(paramString1);
            localObject2 = (String)((Map.Entry)localObject2).getValue();
            if (!((String)localObject2).equalsIgnoreCase((String)localObject4))
            {
              ((File)localObject3).delete();
              paramString2 = new StringBuilder();
              paramString2.append("doOnDownloadSuccess. check md5 failed. result = ");
              paramString2.append(-3);
              paramString2.append(", filename = ");
              paramString2.append(paramString1);
              paramString2.append(", md5FromCalc = ");
              paramString2.append((String)localObject4);
              paramString2.append(", md5FromConfig = ");
              paramString2.append((String)localObject2);
              QLog.i("AREngine_ArCloudNativeSoLoader", 2, paramString2.toString());
              return -3;
            }
          }
          else
          {
            paramString2 = new StringBuilder();
            paramString2.append("doOnDownloadSuccess. so file not exist. result = ");
            paramString2.append(-2);
            paramString2.append(", filename = ");
            paramString2.append(paramString1);
            QLog.i("AREngine_ArCloudNativeSoLoader", 2, paramString2.toString());
            return -2;
          }
        }
        paramString1 = new StringBuilder();
        paramString1.append("doOnDownloadSuccess. result = ");
        paramString1.append(0);
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, paramString1.toString());
        return 0;
      }
      paramString1 = new StringBuilder();
      paramString1.append("doOnDownloadSuccess. sSoMd5ListFromConfig.size() == 0. result = ");
      paramString1.append(-1);
      QLog.i("AREngine_ArCloudNativeSoLoader", 2, paramString1.toString());
      return -1;
    }
    catch (IOException paramString2)
    {
      break label579;
    }
    catch (OutOfMemoryError paramString2)
    {
      break label528;
    }
    paramString2 = new StringBuilder();
    paramString2.append("doOnDownloadSuccess. parse xml failed. result = ");
    paramString2.append(-5);
    paramString2.append(", soResFilename = ");
    paramString2.append(paramString1);
    QLog.i("AREngine_ArCloudNativeSoLoader", 2, paramString2.toString());
    return -5;
    paramString2 = new StringBuilder();
    paramString2.append("doOnDownloadSuccess. parse xml failed. result = ");
    paramString2.append(-5);
    paramString2.append(", soResFilename = ");
    paramString2.append(paramString1);
    QLog.i("AREngine_ArCloudNativeSoLoader", 2, paramString2.toString());
    return -5;
    paramString1 = new StringBuilder();
    paramString1.append("doOnDownloadSuccess. so file not exist. result = ");
    paramString1.append(-2);
    paramString1.append(", configFilename = ");
    paramString1.append((String)localObject1);
    QLog.i("AREngine_ArCloudNativeSoLoader", 2, paramString1.toString());
    return -2;
    FileUtils.delete(paramString2, false);
    paramString2 = new File(paramString1);
    if (paramString2.exists()) {
      paramString2.delete();
    }
    paramString2 = new StringBuilder();
    paramString2.append("doOnDownloadSuccess. unzip failed. result = ");
    paramString2.append(-6);
    paramString2.append(", soResFilename = ");
    paramString2.append(paramString1);
    QLog.i("AREngine_ArCloudNativeSoLoader", 2, paramString2.toString());
    return -6;
  }
  
  public static String a()
  {
    return "libARCloud";
  }
  
  private static HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    int i;
    try
    {
      localObject1 = Xml.newPullParser();
      ((XmlPullParser)localObject1).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      i = ((XmlPullParser)localObject1).getEventType();
    }
    catch (Exception localException)
    {
      Object localObject1;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parseSoMd5FromXmlConfig failed. error = ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      ((StringBuilder)localObject2).append(", xmlConfigContent = ");
      ((StringBuilder)localObject2).append(paramString);
      QLog.e("AREngine_ArCloudNativeSoLoader", 2, ((StringBuilder)localObject2).toString());
      return localHashMap;
    }
    localObject2 = ((XmlPullParser)localObject1).getName();
    if (((String)localObject2).equalsIgnoreCase("libARCloud")) {
      localHashMap.put("libARCloud", ((XmlPullParser)localObject1).nextText());
    } else if (((String)localObject2).equalsIgnoreCase("libARCloud_64")) {
      localHashMap.put("libARCloud_64", ((XmlPullParser)localObject1).nextText());
    }
    for (;;)
    {
      i = ((XmlPullParser)localObject1).next();
      while (i == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseSoMd5FromXmlConfig successfully. soMd5List = ");
        ((StringBuilder)localObject1).append(localHashMap);
        QLog.d("AREngine_ArCloudNativeSoLoader", 2, ((StringBuilder)localObject1).toString());
        return localHashMap;
      }
      if (i == 2) {
        break;
      }
    }
  }
  
  public static boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ArNativeSoLoaderBase.a("arcloud", "v8.4.1.1", ArNativeSoLoaderBase.b("arcloud", "v8.4.1.1", "arcloud")));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(a());
    localStringBuilder.append(".so");
    return new File(localStringBuilder.toString()).exists();
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ArNativeSoLoaderBase.a("arcloud", "v8.4.1.1", ArNativeSoLoaderBase.b("arcloud", "v8.4.1.1", "arcloud")));
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(".so");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new File((String)localObject1);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isSoFileExist soFile=");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(", exist=");
        localStringBuilder.append(((File)localObject2).exists());
        QLog.d("AREngine_ArCloudNativeSoLoader", 2, localStringBuilder.toString());
      }
      if (((File)localObject2).exists())
      {
        paramString = ArNativeSoLoaderBase.b("arcloud", "v8.4.1.1", paramString);
        localObject2 = PortalUtils.a((String)localObject1);
        if (paramString.equalsIgnoreCase((String)localObject2))
        {
          bool = true;
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSoFileExist. check md5 failed. soFilename = ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(", md5FromConfig = ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", md5FromCalc = ");
          localStringBuilder.append((String)localObject2);
          QLog.i("AREngine_ArCloudNativeSoLoader", 2, localStringBuilder.toString());
        }
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("isSoFileExist. so not exist. soFilename = ");
        paramString.append((String)localObject1);
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, paramString.toString());
      }
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArCloudNativeSoLoader
 * JD-Core Version:    0.7.0.1
 */
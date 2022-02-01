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
      int i = ArNativeSoLoaderBase.a("arsdk2", a(), ArNativeSoLoaderBase.b("arsdk2", a(), "arsdk2"), paramString);
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
      QLog.i("AREngine_ArSDK2NativeSoLoader", 2, ((StringBuilder)localObject1).toString());
      ArNativeSoLoaderBase.a("arsdk2", a(), "arsdk2", paramString2);
    }
    finally
    {
      Object localObject1;
      label585:
      label738:
      for (;;)
      {
        label636:
        throw paramString1;
      }
    }
    try
    {
      ArConfigUtils.a(paramString1, ArNativeSoLoaderBase.a("arsdk2", a(), ArNativeSoLoaderBase.b("arsdk2", a(), "arsdk2")));
      paramString2 = new StringBuilder();
      paramString2.append(ArNativeSoLoaderBase.a("arsdk2", a(), ArNativeSoLoaderBase.b("arsdk2", a(), "arsdk2")));
      paramString2.append(File.separator);
      paramString2.append("md5_config.xml");
      paramString2 = paramString2.toString();
      localObject1 = new File(paramString2);
      if (((File)localObject1).exists()) {
        new HashMap();
      }
    }
    catch (IOException paramString2)
    {
      break label738;
    }
    try
    {
      paramString2 = a(FileUtils.readFileToString((File)localObject1));
      if (paramString2.size() > 0)
      {
        paramString2 = paramString2.entrySet().iterator();
        while (paramString2.hasNext())
        {
          localObject1 = (Map.Entry)paramString2.next();
          paramString1 = "";
          if (((String)((Map.Entry)localObject1).getKey()).equalsIgnoreCase("libAlphaAR"))
          {
            paramString1 = new StringBuilder();
            paramString1.append(ArNativeSoLoaderBase.a("arsdk2", a(), ArNativeSoLoaderBase.b("arsdk2", a(), "arsdk2")));
            paramString1.append(File.separator);
            paramString1.append((String)((Map.Entry)localObject1).getKey());
            paramString1.append(".so");
            paramString1 = paramString1.toString();
            ArNativeSoLoaderBase.a("arsdk2", a(), "libAlphaAR", (String)((Map.Entry)localObject1).getValue());
          }
          File localFile = new File(paramString1);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("doOnDownloadSuccess. soFilename = ");
          ((StringBuilder)localObject2).append(paramString1);
          QLog.i("AREngine_ArSDK2NativeSoLoader", 2, ((StringBuilder)localObject2).toString());
          if (localFile.exists())
          {
            localObject2 = PortalUtils.a(paramString1);
            localObject1 = (String)((Map.Entry)localObject1).getValue();
            if (!((String)localObject1).equalsIgnoreCase((String)localObject2))
            {
              localFile.delete();
              paramString2 = new StringBuilder();
              paramString2.append("doOnDownloadSuccess. check md5 failed. result = ");
              paramString2.append(-3);
              paramString2.append(", filename = ");
              paramString2.append(paramString1);
              paramString2.append(", md5FromCalc = ");
              paramString2.append((String)localObject2);
              paramString2.append(", md5FromConfig = ");
              paramString2.append((String)localObject1);
              QLog.i("AREngine_ArSDK2NativeSoLoader", 2, paramString2.toString());
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
            QLog.i("AREngine_ArSDK2NativeSoLoader", 2, paramString2.toString());
            return -2;
          }
        }
        paramString1 = new StringBuilder();
        paramString1.append("doOnDownloadSuccess. result = ");
        paramString1.append(0);
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, paramString1.toString());
        return 0;
      }
      paramString1 = new StringBuilder();
      paramString1.append("doOnDownloadSuccess. sSoMd5ListFromConfig.size() == 0. result = ");
      paramString1.append(-1);
      QLog.i("AREngine_ArSDK2NativeSoLoader", 2, paramString1.toString());
      return -1;
    }
    catch (IOException paramString2)
    {
      break label636;
    }
    catch (OutOfMemoryError paramString2)
    {
      break label585;
    }
    paramString2 = new StringBuilder();
    paramString2.append("doOnDownloadSuccess. parse xml failed. result = ");
    paramString2.append(-5);
    paramString2.append(", soResFilename = ");
    paramString2.append(paramString1);
    QLog.i("AREngine_ArSDK2NativeSoLoader", 2, paramString2.toString());
    return -5;
    paramString2 = new StringBuilder();
    paramString2.append("doOnDownloadSuccess. parse xml failed. result = ");
    paramString2.append(-5);
    paramString2.append(", soResFilename = ");
    paramString2.append(paramString1);
    QLog.i("AREngine_ArSDK2NativeSoLoader", 2, paramString2.toString());
    return -5;
    paramString1 = new StringBuilder();
    paramString1.append("doOnDownloadSuccess. so file not exist. result = ");
    paramString1.append(-2);
    paramString1.append(", configFilename = ");
    paramString1.append(paramString2);
    QLog.i("AREngine_ArSDK2NativeSoLoader", 2, paramString1.toString());
    return -2;
    FileUtils.delete(ArNativeSoLoaderBase.a("arsdk2", a(), ArNativeSoLoaderBase.b("arsdk2", a(), "arsdk2")), false);
    paramString2 = new File(paramString1);
    if (paramString2.exists()) {
      paramString2.delete();
    }
    paramString2 = new StringBuilder();
    paramString2.append("doOnDownloadSuccess. unzip failed. result = ");
    paramString2.append(-6);
    paramString2.append(", soResFilename = ");
    paramString2.append(paramString1);
    QLog.i("AREngine_ArSDK2NativeSoLoader", 2, paramString2.toString());
    return -6;
  }
  
  public static String a()
  {
    return "v8.4.5.1";
  }
  
  private static HashMap<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    int i;
    try
    {
      localObject = Xml.newPullParser();
      ((XmlPullParser)localObject).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      i = ((XmlPullParser)localObject).getEventType();
    }
    catch (Exception localException)
    {
      Object localObject;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseSoMd5FromXmlConfig failed. error = ");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append(", xmlConfigContent = ");
      localStringBuilder.append(paramString);
      QLog.e("AREngine_ArSDK2NativeSoLoader", 2, localStringBuilder.toString());
      return localHashMap;
    }
    if (((XmlPullParser)localObject).getName().equalsIgnoreCase("libAlphaAR")) {
      localHashMap.put("libAlphaAR", ((XmlPullParser)localObject).nextText());
    }
    for (;;)
    {
      i = ((XmlPullParser)localObject).next();
      StringBuilder localStringBuilder;
      while (i == 1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseSoMd5FromXmlConfig successfully. soMd5List = ");
        ((StringBuilder)localObject).append(localHashMap);
        QLog.d("AREngine_ArSDK2NativeSoLoader", 2, ((StringBuilder)localObject).toString());
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
    localStringBuilder.append(ArNativeSoLoaderBase.a("arsdk2", a(), ArNativeSoLoaderBase.b("arsdk2", a(), "arsdk2")));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("libAlphaAR");
    localStringBuilder.append(".so");
    return new File(localStringBuilder.toString()).exists();
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(ArNativeSoLoaderBase.a("arsdk2", a(), ArNativeSoLoaderBase.b("arsdk2", a(), "arsdk2")));
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
        QLog.d("AREngine_ArSDK2NativeSoLoader", 2, localStringBuilder.toString());
      }
      if (((File)localObject2).exists())
      {
        paramString = ArNativeSoLoaderBase.b("arsdk2", a(), paramString);
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
          QLog.i("AREngine_ArSDK2NativeSoLoader", 2, localStringBuilder.toString());
        }
      }
      else
      {
        paramString = new StringBuilder();
        paramString.append("isSoFileExist. so not exist. soFilename = ");
        paramString.append((String)localObject1);
        QLog.i("AREngine_ArSDK2NativeSoLoader", 2, paramString.toString());
      }
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArSDK2NativeSoLoader
 * JD-Core Version:    0.7.0.1
 */
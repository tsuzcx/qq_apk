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

public class ArFeatureSwepNativeSoLoader
{
  public static int a(String paramString)
  {
    try
    {
      int i = ArNativeSoLoaderBase.b("arfeature", "v8.0.0", ArNativeSoLoaderBase.b("arfeature", "v8.0.0", "arfeature"), paramString);
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
      QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, ((StringBuilder)localObject1).toString());
      ArNativeSoLoaderBase.a("arfeature", "v8.0.0", "arfeature", paramString2);
    }
    finally
    {
      Object localObject1;
      label577:
      label730:
      for (;;)
      {
        label628:
        throw paramString1;
      }
    }
    try
    {
      ArConfigUtils.a(paramString1, ArNativeSoLoaderBase.a("arfeature", "v8.0.0", ArNativeSoLoaderBase.b("arfeature", "v8.0.0", "arfeature")));
      paramString2 = new StringBuilder();
      paramString2.append(ArNativeSoLoaderBase.a("arfeature", "v8.0.0", ArNativeSoLoaderBase.b("arfeature", "v8.0.0", "arfeature")));
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
      break label730;
    }
    try
    {
      paramString2 = b(FileUtils.readFileToString((File)localObject1));
      if (paramString2.size() > 0)
      {
        paramString2 = paramString2.entrySet().iterator();
        while (paramString2.hasNext())
        {
          localObject1 = (Map.Entry)paramString2.next();
          paramString1 = "";
          if (((String)((Map.Entry)localObject1).getKey()).equalsIgnoreCase("libARFeature"))
          {
            paramString1 = new StringBuilder();
            paramString1.append(ArNativeSoLoaderBase.a("arfeature", "v8.0.0", ArNativeSoLoaderBase.b("arfeature", "v8.0.0", "arfeature")));
            paramString1.append(File.separator);
            paramString1.append((String)((Map.Entry)localObject1).getKey());
            paramString1.append(".so");
            paramString1 = paramString1.toString();
            ArNativeSoLoaderBase.a("arfeature", "v8.0.0", "libARFeature", (String)((Map.Entry)localObject1).getValue());
          }
          File localFile = new File(paramString1);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("doOnDownloadSuccess. soFilename = ");
          ((StringBuilder)localObject2).append(paramString1);
          QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, ((StringBuilder)localObject2).toString());
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
              QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, paramString2.toString());
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
            QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, paramString2.toString());
            return -2;
          }
        }
        paramString1 = new StringBuilder();
        paramString1.append("doOnDownloadSuccess. result = ");
        paramString1.append(0);
        QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, paramString1.toString());
        return 0;
      }
      paramString1 = new StringBuilder();
      paramString1.append("doOnDownloadSuccess. sSoMd5ListFromConfig.size() == 0. result = ");
      paramString1.append(-1);
      QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, paramString1.toString());
      return -1;
    }
    catch (IOException paramString2)
    {
      break label628;
    }
    catch (OutOfMemoryError paramString2)
    {
      break label577;
    }
    paramString2 = new StringBuilder();
    paramString2.append("doOnDownloadSuccess. parse xml failed. result = ");
    paramString2.append(-5);
    paramString2.append(", soResFilename = ");
    paramString2.append(paramString1);
    QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, paramString2.toString());
    return -5;
    paramString2 = new StringBuilder();
    paramString2.append("doOnDownloadSuccess. parse xml failed. result = ");
    paramString2.append(-5);
    paramString2.append(", soResFilename = ");
    paramString2.append(paramString1);
    QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, paramString2.toString());
    return -5;
    paramString1 = new StringBuilder();
    paramString1.append("doOnDownloadSuccess. so file not exist. result = ");
    paramString1.append(-2);
    paramString1.append(", configFilename = ");
    paramString1.append(paramString2);
    QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, paramString1.toString());
    return -2;
    FileUtils.delete(ArNativeSoLoaderBase.a("arfeature", "v8.0.0", ArNativeSoLoaderBase.b("arfeature", "v8.0.0", "arfeature")), false);
    paramString2 = new File(paramString1);
    if (paramString2.exists()) {
      paramString2.delete();
    }
    paramString2 = new StringBuilder();
    paramString2.append("doOnDownloadSuccess. unzip failed. result = ");
    paramString2.append(-6);
    paramString2.append(", soResFilename = ");
    paramString2.append(paramString1);
    QLog.i("AREngine_ArFeatureSwepNativeSoLoader", 2, paramString2.toString());
    return -6;
  }
  
  public static boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ArNativeSoLoaderBase.a("arfeature", "v8.0.0", ArNativeSoLoaderBase.b("arfeature", "v8.0.0", "arfeature")));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("libARFeature");
    localStringBuilder.append(".so");
    return new File(localStringBuilder.toString()).exists();
  }
  
  private static HashMap<String, String> b(String paramString)
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
      QLog.e("AREngine_ArFeatureSwepNativeSoLoader", 2, localStringBuilder.toString());
      return localHashMap;
    }
    if (((XmlPullParser)localObject).getName().equalsIgnoreCase("libARFeature")) {
      localHashMap.put("libARFeature", ((XmlPullParser)localObject).nextText());
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
        QLog.d("AREngine_ArFeatureSwepNativeSoLoader", 2, ((StringBuilder)localObject).toString());
        return localHashMap;
      }
      if (i == 2) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArFeatureSwepNativeSoLoader
 * JD-Core Version:    0.7.0.1
 */
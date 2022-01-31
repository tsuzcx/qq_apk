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
      int i = ArNativeSoLoaderBase.a("arcloud", "v7.3.0.2", ArNativeSoLoaderBase.b("arcloud", "v7.3.0.2", "arcloud"), paramString);
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
    for (;;)
    {
      try
      {
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. soResFilename = " + paramString1 + ", soResMd5FromConfig = " + paramString2);
        ArNativeSoLoaderBase.a("arcloud", "v7.3.0.2", "arcloud", paramString2);
        try
        {
          ArConfigUtils.a(paramString1, ArNativeSoLoaderBase.a("arcloud", "v7.3.0.2", ArNativeSoLoaderBase.b("arcloud", "v7.3.0.2", "arcloud")));
          paramString2 = ArNativeSoLoaderBase.a("arcloud", "v7.3.0.2", ArNativeSoLoaderBase.b("arcloud", "v7.3.0.2", "arcloud")) + File.separator + "md5_config.xml";
          localObject = new File(paramString2);
          if (!((File)localObject).exists()) {
            break label599;
          }
        }
        catch (IOException paramString2)
        {
          Object localObject;
          File localFile;
          String str;
          i = -6;
          FileUtils.a(ArNativeSoLoaderBase.a("arcloud", "v7.3.0.2", ArNativeSoLoaderBase.b("arcloud", "v7.3.0.2", "arcloud")), false);
          paramString2 = new File(paramString1);
          if (paramString2.exists()) {
            paramString2.delete();
          }
          QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. unzip failed. result = " + -6 + ", soResFilename = " + paramString1);
          continue;
        }
      }
      finally {}
      try
      {
        paramString2 = FileUtils.b((File)localObject);
        paramString1 = a(paramString2);
        if (paramString1.size() <= 0) {
          break label569;
        }
        paramString2 = paramString1.entrySet().iterator();
        if (!paramString2.hasNext()) {
          break label640;
        }
        localObject = (Map.Entry)paramString2.next();
        paramString1 = "";
        if (((String)((Map.Entry)localObject).getKey()).equalsIgnoreCase("libARCloud"))
        {
          paramString1 = ArNativeSoLoaderBase.a("arcloud", "v7.3.0.2", ArNativeSoLoaderBase.b("arcloud", "v7.3.0.2", "arcloud")) + File.separator + (String)((Map.Entry)localObject).getKey() + ".so";
          ArNativeSoLoaderBase.a("arcloud", "v7.3.0.2", "libARCloud", (String)((Map.Entry)localObject).getValue());
        }
        localFile = new File(paramString1);
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. soFilename = " + paramString1);
        if (!localFile.exists()) {
          break label528;
        }
        str = PortalUtils.a(paramString1);
        localObject = (String)((Map.Entry)localObject).getValue();
        if (((String)localObject).equalsIgnoreCase(str)) {
          continue;
        }
        localFile.delete();
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. check md5 failed. result = " + -3 + ", filename = " + paramString1 + ", md5FromCalc = " + str + ", md5FromConfig = " + (String)localObject);
        i = -3;
      }
      catch (IOException paramString2)
      {
        i = -5;
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. parse xml failed. result = " + -5 + ", soResFilename = " + paramString1);
        continue;
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = " + -2 + ", filename = " + paramString1);
        i = -2;
        continue;
        i = -1;
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. sSoMd5ListFromConfig.size() == 0. result = " + -1);
        continue;
      }
      return i;
      label528:
      label569:
      label599:
      QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. so file not exist. result = " + -2 + ", configFilename = " + paramString2);
      int i = -2;
      continue;
      label640:
      QLog.i("AREngine_ArCloudNativeSoLoader", 2, "doOnDownloadSuccess. result = " + 0);
      i = 0;
    }
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
        QLog.e("AREngine_ArCloudNativeSoLoader", 2, "parseSoMd5FromXmlConfig failed. error = " + localException.getMessage() + ", xmlConfigContent = " + paramString);
        return localHashMap;
      }
      int i = localXmlPullParser.next();
      if (localXmlPullParser.getName().equalsIgnoreCase("libARCloud"))
      {
        localHashMap.put("libARCloud", localXmlPullParser.nextText());
        while (i == 1)
        {
          QLog.d("AREngine_ArCloudNativeSoLoader", 2, "parseSoMd5FromXmlConfig successfully. soMd5List = " + localHashMap);
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
    return new File(ArNativeSoLoaderBase.a("arcloud", "v7.3.0.2", ArNativeSoLoaderBase.b("arcloud", "v7.3.0.2", "arcloud")) + File.separator + "libARCloud" + ".so").exists();
  }
  
  public static boolean a(String paramString)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        String str = ArNativeSoLoaderBase.a("arcloud", "v7.3.0.2", ArNativeSoLoaderBase.b("arcloud", "v7.3.0.2", "arcloud")) + File.separator + paramString + ".so";
        Object localObject = new File(str);
        if (QLog.isColorLevel()) {
          QLog.d("AREngine_ArCloudNativeSoLoader", 2, "isSoFileExist soFile=" + str + ", exist=" + ((File)localObject).exists());
        }
        if (((File)localObject).exists())
        {
          paramString = ArNativeSoLoaderBase.b("arcloud", "v7.3.0.2", paramString);
          localObject = PortalUtils.a(str);
          boolean bool2 = paramString.equalsIgnoreCase((String)localObject);
          if (bool2)
          {
            bool1 = true;
            return bool1;
          }
          QLog.i("AREngine_ArCloudNativeSoLoader", 2, "isSoFileExist. check md5 failed. soFilename = " + str + ", md5FromConfig = " + paramString + ", md5FromCalc = " + (String)localObject);
          continue;
        }
        QLog.i("AREngine_ArCloudNativeSoLoader", 2, "isSoFileExist. so not exist. soFilename = " + str);
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArCloudNativeSoLoader
 * JD-Core Version:    0.7.0.1
 */
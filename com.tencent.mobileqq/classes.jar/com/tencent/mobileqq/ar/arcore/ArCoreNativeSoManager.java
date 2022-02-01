package com.tencent.mobileqq.ar.arcore;

import android.os.Build.VERSION;
import android.util.Xml;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionDevice;
import com.tencent.mobileqq.ar.ArConfigUtils;
import com.tencent.mobileqq.ar.ArNativeSoLoaderBase;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;

public class ArCoreNativeSoManager
{
  private static IArCoreNativeSoLoader a;
  
  static
  {
    if ((ARCoreManager.a("HUAWEI")) && (Build.VERSION.SDK_INT >= 23) && (PromotionDevice.a())) {
      a = null;
    }
  }
  
  public static int a(IArCoreNativeSoLoader paramIArCoreNativeSoLoader, String paramString)
  {
    if (paramIArCoreNativeSoLoader != null) {
      try
      {
        if (!StringUtil.a(paramString))
        {
          String str = paramIArCoreNativeSoLoader.a();
          paramIArCoreNativeSoLoader = paramIArCoreNativeSoLoader.b();
          int i = ArNativeSoLoaderBase.a(str, paramIArCoreNativeSoLoader, ArNativeSoLoaderBase.b(str, paramIArCoreNativeSoLoader, str), paramString);
          if (QLog.isColorLevel())
          {
            paramIArCoreNativeSoLoader = new StringBuilder();
            paramIArCoreNativeSoLoader.append("loadArNativeSo soName=");
            paramIArCoreNativeSoLoader.append(paramString);
            paramIArCoreNativeSoLoader.append(" result=");
            paramIArCoreNativeSoLoader.append(i);
            QLog.d("ArCoreNativeSoManager", 2, paramIArCoreNativeSoLoader.toString());
          }
          return i;
        }
      }
      finally {}
    }
    return -4;
  }
  
  public static int a(IArCoreNativeSoLoader paramIArCoreNativeSoLoader, String paramString1, String paramString2)
  {
    label690:
    if (paramIArCoreNativeSoLoader != null)
    {
      String str1;
      String str2;
      Object localObject1;
      List localList;
      label639:
      try
      {
        if ((!StringUtil.a(paramString1)) && (!StringUtil.a(paramString2)))
        {
          str1 = paramIArCoreNativeSoLoader.a();
          str2 = paramIArCoreNativeSoLoader.b();
          localObject1 = paramIArCoreNativeSoLoader.c();
          localList = paramIArCoreNativeSoLoader.a();
          if ((localList != null) && (localList.size() != 0))
          {
            paramIArCoreNativeSoLoader = new StringBuilder();
            paramIArCoreNativeSoLoader.append("doOnDownloadSuccess. soResFilename = ");
            paramIArCoreNativeSoLoader.append(paramString1);
            paramIArCoreNativeSoLoader.append(", soResMd5FromConfig = ");
            paramIArCoreNativeSoLoader.append(paramString2);
            QLog.i("ArCoreNativeSoManager", 2, paramIArCoreNativeSoLoader.toString());
            ArNativeSoLoaderBase.a(str1, str2, str1, paramString2);
          }
        }
      }
      finally {}
    }
    try
    {
      ArConfigUtils.a(paramString1, ArNativeSoLoaderBase.a(str1, str2, ArNativeSoLoaderBase.b(str1, str2, str1)));
      paramIArCoreNativeSoLoader = new StringBuilder();
      paramIArCoreNativeSoLoader.append(ArNativeSoLoaderBase.a(str1, str2, ArNativeSoLoaderBase.b(str1, str2, str1)));
      paramIArCoreNativeSoLoader.append(File.separator);
      paramIArCoreNativeSoLoader.append((String)localObject1);
      paramIArCoreNativeSoLoader = paramIArCoreNativeSoLoader.toString();
      paramString2 = new File(paramIArCoreNativeSoLoader);
      if (paramString2.exists()) {
        new HashMap();
      }
    }
    catch (IOException paramIArCoreNativeSoLoader)
    {
      break label792;
    }
    try
    {
      paramIArCoreNativeSoLoader = a(FileUtils.readFileToString(paramString2), localList);
      if (paramIArCoreNativeSoLoader.size() > 0)
      {
        paramString1 = paramIArCoreNativeSoLoader.entrySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (Map.Entry)paramString1.next();
          paramIArCoreNativeSoLoader = "";
          localObject1 = (String)paramString2.getKey();
          if (localList.contains(localObject1))
          {
            paramIArCoreNativeSoLoader = new StringBuilder();
            paramIArCoreNativeSoLoader.append(ArNativeSoLoaderBase.a(str1, str2, ArNativeSoLoaderBase.b(str1, str2, str1)));
            paramIArCoreNativeSoLoader.append(File.separator);
            paramIArCoreNativeSoLoader.append((String)localObject1);
            paramIArCoreNativeSoLoader.append(".so");
            paramIArCoreNativeSoLoader = paramIArCoreNativeSoLoader.toString();
            ArNativeSoLoaderBase.a(str1, str2, (String)localObject1, (String)paramString2.getValue());
          }
          localObject1 = new File(paramIArCoreNativeSoLoader);
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("doOnDownloadSuccess. soFilename = ");
          ((StringBuilder)localObject2).append(paramIArCoreNativeSoLoader);
          QLog.i("ArCoreNativeSoManager", 2, ((StringBuilder)localObject2).toString());
          if (((File)localObject1).exists())
          {
            localObject2 = PortalUtils.a(paramIArCoreNativeSoLoader);
            paramString2 = (String)paramString2.getValue();
            if (!paramString2.equalsIgnoreCase((String)localObject2))
            {
              ((File)localObject1).delete();
              paramString1 = new StringBuilder();
              paramString1.append("doOnDownloadSuccess. check md5 failed. result = ");
              paramString1.append(-3);
              paramString1.append(", filename = ");
              paramString1.append(paramIArCoreNativeSoLoader);
              paramString1.append(", md5FromCalc = ");
              paramString1.append((String)localObject2);
              paramString1.append(", md5FromConfig = ");
              paramString1.append(paramString2);
              QLog.i("ArCoreNativeSoManager", 2, paramString1.toString());
              return -3;
            }
          }
          else
          {
            paramString1 = new StringBuilder();
            paramString1.append("doOnDownloadSuccess. so file not exist. result = ");
            paramString1.append(-2);
            paramString1.append(", filename = ");
            paramString1.append(paramIArCoreNativeSoLoader);
            QLog.i("ArCoreNativeSoManager", 2, paramString1.toString());
            return -2;
          }
        }
        paramIArCoreNativeSoLoader = new StringBuilder();
        paramIArCoreNativeSoLoader.append("doOnDownloadSuccess. result = ");
        paramIArCoreNativeSoLoader.append(0);
        QLog.i("ArCoreNativeSoManager", 2, paramIArCoreNativeSoLoader.toString());
        return 0;
      }
      paramIArCoreNativeSoLoader = new StringBuilder();
      paramIArCoreNativeSoLoader.append("doOnDownloadSuccess. sSoMd5ListFromConfig.size() == 0. result = ");
      paramIArCoreNativeSoLoader.append(-1);
      QLog.i("ArCoreNativeSoManager", 2, paramIArCoreNativeSoLoader.toString());
      return -1;
    }
    catch (IOException paramIArCoreNativeSoLoader)
    {
      break label690;
    }
    catch (OutOfMemoryError paramIArCoreNativeSoLoader)
    {
      break label639;
    }
    paramIArCoreNativeSoLoader = new StringBuilder();
    paramIArCoreNativeSoLoader.append("doOnDownloadSuccess. parse xml failed. result = ");
    paramIArCoreNativeSoLoader.append(-5);
    paramIArCoreNativeSoLoader.append(", soResFilename = ");
    paramIArCoreNativeSoLoader.append(paramString1);
    QLog.i("ArCoreNativeSoManager", 2, paramIArCoreNativeSoLoader.toString());
    return -5;
    paramIArCoreNativeSoLoader = new StringBuilder();
    paramIArCoreNativeSoLoader.append("doOnDownloadSuccess. parse xml failed. result = ");
    paramIArCoreNativeSoLoader.append(-5);
    paramIArCoreNativeSoLoader.append(", soResFilename = ");
    paramIArCoreNativeSoLoader.append(paramString1);
    QLog.i("ArCoreNativeSoManager", 2, paramIArCoreNativeSoLoader.toString());
    return -5;
    paramString1 = new StringBuilder();
    paramString1.append("doOnDownloadSuccess. so file not exist. result = ");
    paramString1.append(-2);
    paramString1.append(", configFilename = ");
    paramString1.append(paramIArCoreNativeSoLoader);
    QLog.i("ArCoreNativeSoManager", 2, paramString1.toString());
    return -2;
    label792:
    FileUtils.delete(ArNativeSoLoaderBase.a(str1, str2, ArNativeSoLoaderBase.b(str1, str2, str1)), false);
    paramIArCoreNativeSoLoader = new File(paramString1);
    if (paramIArCoreNativeSoLoader.exists()) {
      paramIArCoreNativeSoLoader.delete();
    }
    paramIArCoreNativeSoLoader = new StringBuilder();
    paramIArCoreNativeSoLoader.append("doOnDownloadSuccess. unzip failed. result = ");
    paramIArCoreNativeSoLoader.append(-6);
    paramIArCoreNativeSoLoader.append(", soResFilename = ");
    paramIArCoreNativeSoLoader.append(paramString1);
    QLog.i("ArCoreNativeSoManager", 2, paramIArCoreNativeSoLoader.toString());
    return -6;
    return -1;
    return -1;
  }
  
  public static IArCoreNativeSoLoader a()
  {
    return a;
  }
  
  private static HashMap<String, String> a(String paramString, List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    int i;
    try
    {
      localObject = Xml.newPullParser();
      ((XmlPullParser)localObject).setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
      i = ((XmlPullParser)localObject).getEventType();
    }
    catch (Exception paramList)
    {
      String str;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseSoMd5FromXmlConfig failed. error = ");
      ((StringBuilder)localObject).append(paramList.getMessage());
      ((StringBuilder)localObject).append(", xmlConfigContent = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("ArCoreNativeSoManager", 2, ((StringBuilder)localObject).toString());
      return localHashMap;
    }
    str = ((XmlPullParser)localObject).getName();
    if (paramList.contains(str)) {
      localHashMap.put(str, ((XmlPullParser)localObject).nextText());
    }
    for (;;)
    {
      i = ((XmlPullParser)localObject).next();
      while (i == 1)
      {
        paramList = new StringBuilder();
        paramList.append("parseSoMd5FromXmlConfig successfully. soMd5List = ");
        paramList.append(localHashMap);
        QLog.d("ArCoreNativeSoManager", 2, paramList.toString());
        return localHashMap;
      }
      if (i == 2) {
        break;
      }
    }
  }
  
  public static boolean a(IArCoreNativeSoLoader paramIArCoreNativeSoLoader)
  {
    if (paramIArCoreNativeSoLoader == null) {
      return false;
    }
    Object localObject = paramIArCoreNativeSoLoader.a();
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return false;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!a(paramIArCoreNativeSoLoader, (String)((Iterator)localObject).next())) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(IArCoreNativeSoLoader paramIArCoreNativeSoLoader, String paramString)
  {
    boolean bool = false;
    if (paramIArCoreNativeSoLoader != null) {
      try
      {
        if (!StringUtil.a(paramString))
        {
          String str = paramIArCoreNativeSoLoader.a();
          Object localObject = paramIArCoreNativeSoLoader.b();
          paramIArCoreNativeSoLoader = new StringBuilder();
          paramIArCoreNativeSoLoader.append(ArNativeSoLoaderBase.a(str, (String)localObject, ArNativeSoLoaderBase.b(str, (String)localObject, str)));
          paramIArCoreNativeSoLoader.append(File.separator);
          paramIArCoreNativeSoLoader.append(paramString);
          paramIArCoreNativeSoLoader.append(".so");
          paramIArCoreNativeSoLoader = paramIArCoreNativeSoLoader.toString();
          File localFile = new File(paramIArCoreNativeSoLoader);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isSoFileExist soFile=");
            localStringBuilder.append(paramIArCoreNativeSoLoader);
            localStringBuilder.append(", exist=");
            localStringBuilder.append(localFile.exists());
            QLog.d("ArCoreNativeSoManager", 2, localStringBuilder.toString());
          }
          if (localFile.exists())
          {
            paramString = ArNativeSoLoaderBase.b(str, (String)localObject, paramString);
            str = PortalUtils.a(paramIArCoreNativeSoLoader);
            if (paramString.equalsIgnoreCase(str))
            {
              bool = true;
            }
            else
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("isSoFileExist. check md5 failed. soFilename = ");
              ((StringBuilder)localObject).append(paramIArCoreNativeSoLoader);
              ((StringBuilder)localObject).append(", md5FromConfig = ");
              ((StringBuilder)localObject).append(paramString);
              ((StringBuilder)localObject).append(", md5FromCalc = ");
              ((StringBuilder)localObject).append(str);
              QLog.i("ArCoreNativeSoManager", 2, ((StringBuilder)localObject).toString());
            }
          }
          else
          {
            paramString = new StringBuilder();
            paramString.append("isSoFileExist. so not exist. soFilename = ");
            paramString.append(paramIArCoreNativeSoLoader);
            QLog.i("ArCoreNativeSoManager", 2, paramString.toString());
          }
          return bool;
        }
      }
      finally {}
    }
    return false;
  }
  
  public static boolean b(IArCoreNativeSoLoader paramIArCoreNativeSoLoader)
  {
    if (paramIArCoreNativeSoLoader == null) {
      return false;
    }
    String str1 = paramIArCoreNativeSoLoader.a();
    String str2 = paramIArCoreNativeSoLoader.b();
    paramIArCoreNativeSoLoader = paramIArCoreNativeSoLoader.a();
    if (paramIArCoreNativeSoLoader != null)
    {
      if (paramIArCoreNativeSoLoader.size() == 0) {
        return false;
      }
      paramIArCoreNativeSoLoader = paramIArCoreNativeSoLoader.iterator();
      while (paramIArCoreNativeSoLoader.hasNext())
      {
        String str3 = (String)paramIArCoreNativeSoLoader.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(ArNativeSoLoaderBase.a(str1, str2, ArNativeSoLoaderBase.b(str1, str2, str1)));
        localStringBuilder.append(File.separator);
        localStringBuilder.append(str3);
        localStringBuilder.append(".so");
        if (!new File(localStringBuilder.toString()).exists())
        {
          QLog.i("ArCoreNativeSoManager", 2, "isAllFileExists. name not exist.");
          return false;
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcore.ArCoreNativeSoManager
 * JD-Core Version:    0.7.0.1
 */
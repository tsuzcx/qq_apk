package com.tencent.mobileqq.ar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
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

public class ArNativeSoLoader
{
  public static boolean a;
  private static final byte[] a;
  public static boolean b = false;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = new byte[0];
    jdField_a_of_type_Boolean = false;
  }
  
  public static byte a(String paramString)
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
      ((StringBuilder)localObject2).append("start arNativeSo: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("ArConfig_ArNativeSoLoader", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new File((String)localObject1);
    byte b1;
    if ((!jdField_a_of_type_Boolean) && (((File)localObject2).exists()))
    {
      try
      {
        System.load((String)localObject1);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("load ");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(" success!");
          QLog.i("ArConfig_ArNativeSoLoader", 2, ((StringBuilder)localObject2).toString());
        }
        b1 = 0;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        if (QLog.isColorLevel()) {
          QLog.i("ArConfig_ArNativeSoLoader", 2, "load from ar dir failed.", localUnsatisfiedLinkError);
        }
        b1 = -3;
      }
    }
    else
    {
      byte b2 = -2;
      b1 = b2;
      if (QLog.isColorLevel())
      {
        QLog.i("ArConfig_ArNativeSoLoader", 2, "no ar so in ar dir");
        b1 = b2;
      }
    }
    a(paramString, b1);
    return b1;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getParent());
    localStringBuilder.append("/ar");
    return localStringBuilder.toString();
  }
  
  private static void a(String paramString, byte paramByte)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ar_native_so_load_result");
    localStringBuilder.append(paramString);
    byte b1 = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    if ((!b) || (b1 != paramByte))
    {
      b = true;
      ThreadManager.post(new ArNativeSoLoader.1(paramString, paramByte, localSharedPreferences), 5, null, true);
    }
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString, true);
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
      if (!QLog.isColorLevel()) {
        break label128;
      }
      QLog.e("ArConfig_ArNativeSoLoader", 2, paramString, paramHashMap);
      return false;
    }
    if (((XmlPullParser)localObject).getName().equalsIgnoreCase("ArMapEngine836")) {
      paramHashMap.put("ArMapEngine836", ((XmlPullParser)localObject).nextText());
    }
    for (;;)
    {
      i = ((XmlPullParser)localObject).next();
      label128:
      while (i == 1)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseConfig success|config=");
          ((StringBuilder)localObject).append(paramHashMap);
          QLog.d("ArConfig_ArNativeSoLoader", 2, ((StringBuilder)localObject).toString());
        }
        return true;
      }
      if (i == 2) {
        break;
      }
    }
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(a());
    ((StringBuilder)localObject1).append("/lib");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(".so");
    localObject1 = ((StringBuilder)localObject1).toString();
    ??? = new File((String)localObject1);
    Object localObject3;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("isSoFileExist libPath=");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(", exist=");
      ((StringBuilder)localObject3).append(((File)???).exists());
      ((StringBuilder)localObject3).append(", isUncompressZip=");
      ((StringBuilder)localObject3).append(jdField_a_of_type_Boolean);
      QLog.d("ArConfig_ArNativeSoLoader", 2, ((StringBuilder)localObject3).toString());
    }
    boolean bool2 = jdField_a_of_type_Boolean;
    boolean bool1 = false;
    if ((!bool2) && (((File)???).exists())) {
      if (!paramBoolean) {
        return true;
      }
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        localObject3 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ar_native_");
        localStringBuilder.append(paramString);
        localObject3 = ((SharedPreferences)localObject3).getString(localStringBuilder.toString(), null);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("isSoFileExist: md5= ");
          localStringBuilder.append((String)localObject3);
          QLog.d("ArConfig_ArNativeSoLoader", 2, localStringBuilder.toString());
        }
        if ((localObject3 == null) || (((String)localObject3).equalsIgnoreCase(PortalUtils.a((String)localObject1)))) {
          break label351;
        }
        paramBoolean = bool1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("isSoFileExist: soName= ");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(" check md5 false!");
          QLog.d("ArConfig_ArNativeSoLoader", 2, ((StringBuilder)localObject1).toString());
          paramBoolean = bool1;
        }
        return paramBoolean;
      }
      return false;
      label351:
      paramBoolean = true;
    }
  }
  
  public static byte b(String arg0)
  {
    boolean bool = QLog.isColorLevel();
    byte b1 = 2;
    Object localObject1;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doOnDownloadSuccess : ");
      ((StringBuilder)localObject1).append(???);
      QLog.d("ArConfig_ArNativeSoLoader", 2, ((StringBuilder)localObject1).toString());
    }
    jdField_a_of_type_Boolean = true;
    for (;;)
    {
      try
      {
        ArConfigUtils.a(???, a());
        Object localObject3 = new HashMap();
        SharedPreferences.Editor localEditor = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).edit();
        ??? = new StringBuilder();
        ???.append(a());
        ???.append("/ar_native_config.xml");
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
            synchronized (jdField_a_of_type_ArrayOfByte)
            {
              Iterator localIterator = ((HashMap)localObject3).entrySet().iterator();
              if (!localIterator.hasNext()) {
                break label500;
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
                break label495;
              }
              str = PortalUtils.a(str);
              if (!((String)((Map.Entry)localObject3).getValue()).equalsIgnoreCase(str))
              {
                ((File)localObject4).delete();
              }
              else
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("ar_native_");
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
            QLog.d("ArConfig_ArNativeSoLoader", 2, "config data is not correct");
            b1 = b2;
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArConfig_ArNativeSoLoader", 2, "config file is not exist");
          }
          b1 = 0;
        }
        jdField_a_of_type_Boolean = false;
        return b1;
      }
      catch (IOException ???)
      {
        jdField_a_of_type_Boolean = false;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("uncompressZip false: ");
          localStringBuilder.append(???.getMessage());
          QLog.d("ArConfig_ArNativeSoLoader", 2, localStringBuilder.toString());
        }
        FileUtils.delete(a(), false);
        return -1;
      }
      label495:
      b1 = 3;
      continue;
      label500:
      b1 = 0;
    }
  }
  
  public static boolean b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("/lib");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".so");
    return new File(localStringBuilder.toString()).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArNativeSoLoader
 * JD-Core Version:    0.7.0.1
 */
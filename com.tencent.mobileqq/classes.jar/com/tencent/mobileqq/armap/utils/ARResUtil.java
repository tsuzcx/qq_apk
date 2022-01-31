package com.tencent.mobileqq.armap.utils;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

public class ARResUtil
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  
  static
  {
    int i = 0;
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Throwable localThrowable)
    {
      label28:
      File localFile;
      break label28;
    }
    if (i != 0) {}
    for (localFile = new File(AppConstants.aJ);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      b = new File(localFile, "AR_MAP").getAbsolutePath();
      a = new File(localFile, "res_precover").getAbsolutePath();
      c = new File(b, "preload_map").getAbsolutePath();
      return;
    }
  }
  
  public static File a(String paramString)
  {
    paramString = a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return new File(paramString);
  }
  
  public static String a()
  {
    return b;
  }
  
  public static String a(int paramInt)
  {
    Object localObject = new StringBuilder("");
    ((StringBuilder)localObject).append("map_").append(paramInt).append(".bin");
    String str = ((StringBuilder)localObject).toString();
    localObject = "";
    if (!TextUtils.isEmpty(str)) {
      localObject = new File(c, str).getAbsolutePath();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARResUtil", 2, "getPreloadMapPath:" + (String)localObject);
    }
    return localObject;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str = b;
    if (paramString.startsWith(File.separator)) {
      return str + paramString;
    }
    return str + File.separator + paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString1))
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString2)) {
        str1 = new File(new File(a, paramString1).getAbsolutePath(), paramString2).getAbsolutePath();
      }
    }
    return str1;
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        paramString = FileUtils.b(paramString);
        if (paramString != null)
        {
          paramString = new JSONObject(paramString);
          return paramString;
        }
      }
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static String[] a()
  {
    int k = 0;
    Object localObject1 = new File(c);
    Object localObject2;
    int i;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      String[] arrayOfString = ((File)localObject1).list();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        localObject2 = new File[arrayOfString.length];
        i = 0;
        for (;;)
        {
          localObject1 = localObject2;
          if (i >= arrayOfString.length) {
            break;
          }
          localObject2[i] = new File(c, arrayOfString[i]);
          i += 1;
        }
      }
    }
    localObject1 = null;
    if (localObject1 != null)
    {
      i = localObject1.length;
      if (localObject1.length > 3)
      {
        int m = localObject1.length;
        i = 0;
        while (i < m)
        {
          j = m - 1;
          while (j > i)
          {
            if (localObject1[j].lastModified() > localObject1[(j - 1)].lastModified())
            {
              localObject2 = localObject1[(j - 1)];
              localObject1[(j - 1)] = localObject1[j];
              localObject1[j] = localObject2;
            }
            j -= 1;
          }
          i += 1;
        }
        i = 3;
      }
      localObject2 = new String[i];
      int j = k;
      while (j < i)
      {
        localObject2[j] = localObject1[j].getAbsolutePath();
        if (QLog.isColorLevel()) {
          QLog.d("ARResUtil", 2, "getPreloadMapFileList filePath:" + localObject2[j]);
        }
        j += 1;
      }
      return localObject2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ARResUtil", 2, "getPreloadMapFileList filePath null");
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = new File(a(), paramString).getAbsolutePath();
    }
    return str;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString1))
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString2)) {
        str1 = new File(new File(a, paramString1).getAbsolutePath(), paramString2).getAbsolutePath();
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.utils.ARResUtil
 * JD-Core Version:    0.7.0.1
 */
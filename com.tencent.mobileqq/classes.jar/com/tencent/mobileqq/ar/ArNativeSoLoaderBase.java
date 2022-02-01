package com.tencent.mobileqq.ar;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ArNativeSoLoaderBase
{
  public static int a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramString1, paramString2, paramString3));
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString4);
      localStringBuilder.append(".so");
      paramString1 = localStringBuilder.toString();
      paramString2 = new StringBuilder();
      paramString2.append("loadArNativeSo. soFilename = ");
      paramString2.append(paramString1);
      QLog.i("AREngine_ArNativeSoLoaderBase", 2, paramString2.toString());
      boolean bool = new File(paramString1).exists();
      int i;
      if (bool)
      {
        try
        {
          if ((paramString1.endsWith("libARCloud.so")) || (paramString1.endsWith("libARCloud_64.so")) || (paramString1.endsWith("libARFeature.so"))) {
            SoLoadUtilNew.loadSoByName(BaseApplicationImpl.getContext(), "c++_shared");
          }
          System.load(paramString1);
          i = 0;
          paramString2 = new StringBuilder();
          paramString2.append("loadArNativeSo successfully. result = ");
          paramString2.append(0);
          paramString2.append(", soFilename = ");
          paramString2.append(paramString1);
          QLog.i("AREngine_ArNativeSoLoaderBase", 2, paramString2.toString());
        }
        catch (UnsatisfiedLinkError paramString2)
        {
          paramString3 = new StringBuilder();
          paramString3.append("loadArNativeSo failed. result = ");
          paramString3.append(-4);
          paramString3.append(", soFilename = ");
          paramString3.append(paramString1);
          paramString3.append(", errMsg = ");
          paramString3.append(paramString2.getMessage());
          paramString3.append(", StackTrace = ");
          paramString3.append(paramString2.getStackTrace().toString());
          QLog.e("AREngine_ArNativeSoLoaderBase", 2, paramString3.toString());
          i = -4;
        }
      }
      else
      {
        i = -2;
        paramString2 = new StringBuilder();
        paramString2.append("loadArNativeSo failed. result = ");
        paramString2.append(-2);
        paramString2.append(", soFilename = ");
        paramString2.append(paramString1);
        QLog.i("AREngine_ArNativeSoLoaderBase", 2, paramString2.toString());
      }
      return i;
    }
    finally {}
  }
  
  public static String a()
  {
    if (BaseApplicationImpl.sApplication.getFilesDir() == null)
    {
      QLog.i("AREngine_ArNativeSoLoaderBase", 2, "getARNativeSoRootDir. ARNativeSoRootDir is null.");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getContext().getFilesDir());
    localStringBuilder.append("/pddata/prd");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramString1));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    paramString1 = localStringBuilder.toString();
    paramString2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).edit();
    paramString2.putString(paramString1, paramString4);
    paramString2.commit();
    paramString2 = new StringBuilder();
    paramString2.append("saveMd5. key = ");
    paramString2.append(paramString1);
    paramString2.append(", md5 = ");
    paramString2.append(paramString4);
    QLog.i("AREngine_ArNativeSoLoaderBase", 2, paramString2.toString());
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    paramString1 = localStringBuilder.toString();
    paramString2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString(paramString1, "");
    paramString3 = new StringBuilder();
    paramString3.append("readMd5. key = ");
    paramString3.append(paramString1);
    paramString3.append(", md5 = ");
    paramString3.append(paramString2);
    QLog.i("AREngine_ArNativeSoLoaderBase", 2, paramString3.toString());
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArNativeSoLoaderBase
 * JD-Core Version:    0.7.0.1
 */
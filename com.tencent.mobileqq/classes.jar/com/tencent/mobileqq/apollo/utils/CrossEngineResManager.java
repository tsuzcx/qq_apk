package com.tencent.mobileqq.apollo.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.app.MobileQQ;

public class CrossEngineResManager
{
  public static int a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return -1;
    }
    paramString1 = paramString1.listFiles();
    if (paramString1 == null) {
      return -1;
    }
    Object localObject1 = new File(paramString2);
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    int i = 0;
    while (i < paramString1.length)
    {
      Object localObject2;
      if (paramString1[i].isDirectory())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString1[i].getPath());
        ((StringBuilder)localObject1).append("/");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(paramString1[i].getName());
        ((StringBuilder)localObject2).append("/");
        a((String)localObject1, ((StringBuilder)localObject2).toString(), paramBoolean1, paramBoolean2, paramBoolean3);
      }
      else
      {
        localObject1 = new File(paramString1[i].getPath());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(paramString1[i].getName());
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (((File)localObject1).exists())
        {
          if ((paramBoolean2) && (((File)localObject2).exists()) && (!((File)localObject2).delete()) && (paramBoolean3)) {
            QLog.d("[cmshow]CrossEngineResManager", 1, new Object[] { "copyDirectory fail, delete file name:", ((File)localObject1).getPath() });
          }
          if (!((File)localObject2).exists()) {
            try
            {
              ((File)localObject2).createNewFile();
              if ((!FileUtils.copyFile((File)localObject1, (File)localObject2, paramBoolean3)) && (paramBoolean3)) {
                QLog.d("[cmshow]CrossEngineResManager", 1, new Object[] { "copyDirectory fail, file name:", ((File)localObject1).getPath() });
              }
            }
            catch (IOException localIOException)
            {
              if (paramBoolean3) {
                QLog.e("[cmshow]CrossEngineResManager", 1, "copyDirectory error, ", localIOException);
              }
            }
          }
          if (paramBoolean1) {
            ((File)localObject1).delete();
          }
        }
      }
      i += 1;
    }
    return 0;
  }
  
  public static void a(CrossEngineResManager.LoadListener paramLoadListener)
  {
    if (a())
    {
      QLog.i("[cmshow]CrossEngineResManager", 1, "[CrossEngine] use local so");
      if (paramLoadListener != null) {
        paramLoadListener.a(0);
      }
      return;
    }
    if (!c("v8jni"))
    {
      if (paramLoadListener != null) {
        paramLoadListener.a(-1);
      }
      return;
    }
    SoLoadManager.getInstance().load("Standalone", new CrossEngineResManager.1(paramLoadListener));
  }
  
  public static boolean a()
  {
    return false;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    String str = SharedPreUtils.A(MobileQQ.sMobileQQ.getApplicationContext());
    if (TextUtils.isEmpty(str)) {
      return true;
    }
    if (VersionUtil.a(paramString, str) > 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static void b(CrossEngineResManager.LoadListener paramLoadListener)
  {
    SoLoadManager.getInstance().download("Standalone", new CrossEngineResManager.2(paramLoadListener));
  }
  
  public static void b(String paramString)
  {
    SharedPreUtils.J(MobileQQ.sMobileQQ.getApplicationContext(), paramString);
  }
  
  public static boolean b()
  {
    File localFile1 = new File(ApolloConstant.k);
    File localFile2 = new File(ApolloConstant.k, "EngineResource");
    return (localFile1.exists()) && (localFile2.exists());
  }
  
  public static void c(CrossEngineResManager.LoadListener paramLoadListener)
  {
    boolean bool = c("v8jni");
    int i = -1;
    if (!bool)
    {
      if (paramLoadListener != null) {
        paramLoadListener.a(-1);
      }
      return;
    }
    if (SoLoadManager.getInstance().loadSync("Standalone", null).isSucc()) {
      i = 0;
    }
    if (paramLoadListener != null) {
      paramLoadListener.a(i);
    }
  }
  
  private static boolean c(String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load so failed: so=");
      localStringBuilder.append(paramString);
      QLog.e("[cmshow]CrossEngineResManager", 1, localStringBuilder.toString(), localThrowable);
    }
    return false;
  }
  
  private static void d()
  {
    FileUtils.deleteDirectory(ApolloConstant.k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.CrossEngineResManager
 * JD-Core Version:    0.7.0.1
 */
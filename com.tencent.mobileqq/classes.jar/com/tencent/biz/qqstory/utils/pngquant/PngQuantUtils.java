package com.tencent.biz.qqstory.utils.pngquant;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public final class PngQuantUtils
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  
  public static void a(AppRuntime paramAppRuntime)
  {
    HtmlOffline.b("1017", paramAppRuntime, true, new PngQuantUtils.1());
  }
  
  public static boolean a()
  {
    if ((!a.get()) && (HtmlOffline.h("1017")) && (HtmlOffline.c("1017", "https://libpngquantandroid.so")))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(OfflineEnvHelper.b("1017"));
      ((StringBuilder)localObject).append("1017");
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("libpngquantandroid.so");
      localObject = ((StringBuilder)localObject).toString();
      if (FileUtils.fileExists((String)localObject))
      {
        System.load((String)localObject);
        a.set(true);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("System.load file =");
          localStringBuilder.append((String)localObject);
          QLog.d("PngQuantUtils", 2, localStringBuilder.toString());
        }
      }
    }
    return a.get();
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    if (paramFile1 != null)
    {
      if (!paramFile1.exists()) {
        return false;
      }
      if (paramFile2 != null)
      {
        if (paramFile2.length() == 0L) {
          return nativePngQuantFile(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath());
        }
        throw new IllegalArgumentException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  private static native boolean nativePngQuantFile(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils
 * JD-Core Version:    0.7.0.1
 */
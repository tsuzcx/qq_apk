package com.tencent.biz.qqstory.utils.pngquant;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import onr;

public final class PngQuantUtils
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  
  public static void a(AppRuntime paramAppRuntime)
  {
    HtmlOffline.b("1017", paramAppRuntime, true, new onr());
  }
  
  public static boolean a()
  {
    if ((!a.get()) && (HtmlOffline.c("1017")) && (HtmlOffline.a("1017", "http://libpngquantandroid.so")))
    {
      String str = OfflineEnvHelper.a("1017") + "1017" + File.separator + "libpngquantandroid.so";
      if (FileUtils.a(str))
      {
        System.load(str);
        a.set(true);
        if (QLog.isColorLevel()) {
          QLog.d("PngQuantUtils", 2, "System.load file =" + str);
        }
      }
    }
    return a.get();
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    if (paramFile1 == null) {
      throw new NullPointerException();
    }
    if (!paramFile1.exists()) {
      return false;
    }
    if (paramFile2 == null) {
      throw new NullPointerException();
    }
    if (paramFile2.length() != 0L) {
      throw new IllegalArgumentException();
    }
    return nativePngQuantFile(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath());
  }
  
  private static native boolean nativePngQuantFile(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils
 * JD-Core Version:    0.7.0.1
 */
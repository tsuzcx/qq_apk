package com.tencent.biz.qqstory.utils.pngquant;

import bace;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import mof;
import mol;
import mqq.app.AppRuntime;
import voo;

public final class PngQuantUtils
{
  public static AtomicBoolean a = new AtomicBoolean(false);
  
  public static void a(AppRuntime paramAppRuntime)
  {
    mof.b("1017", paramAppRuntime, true, new voo());
  }
  
  public static boolean a()
  {
    if ((!a.get()) && (mof.c("1017")) && (mof.a("1017", "http://libpngquantandroid.so")))
    {
      String str = mol.a("1017") + "1017" + File.separator + "libpngquantandroid.so";
      if (bace.a(str))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.pngquant.PngQuantUtils
 * JD-Core Version:    0.7.0.1
 */
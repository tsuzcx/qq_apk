package com.tencent.mobileqq.app.compact;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import java.io.File;

public class ReflectLoadLibrary
{
  @TargetApi(23)
  private static int a()
  {
    return Build.VERSION.PREVIEW_SDK_INT;
  }
  
  public static void a(ClassLoader paramClassLoader, File paramFile)
  {
    if (paramFile != null)
    {
      int i;
      label50:
      label58:
      label76:
      label97:
      try
      {
        if (paramFile.exists()) {
          if ((Build.VERSION.SDK_INT != 25) || (a() == 0))
          {
            i = Build.VERSION.SDK_INT;
            if (i <= 25) {
              break label58;
            }
          }
        }
      }
      finally {}
    }
    try
    {
      ReflectLoadLibrary.V25.a(paramClassLoader, paramFile);
      return;
    }
    catch (Throwable localThrowable1)
    {
      break label50;
    }
    ReflectLoadLibrary.V23.a(paramClassLoader, paramFile);
    break label97;
    i = Build.VERSION.SDK_INT;
    if (i >= 23) {}
    try
    {
      ReflectLoadLibrary.V23.a(paramClassLoader, paramFile);
    }
    catch (Throwable localThrowable2)
    {
      break label76;
    }
    ReflectLoadLibrary.V14.a(paramClassLoader, paramFile);
    break label97;
    if (Build.VERSION.SDK_INT >= 14) {
      ReflectLoadLibrary.V14.a(paramClassLoader, paramFile);
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.compact.ReflectLoadLibrary
 * JD-Core Version:    0.7.0.1
 */
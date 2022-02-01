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
    if (paramFile != null) {}
    for (;;)
    {
      int i;
      try
      {
        boolean bool = paramFile.exists();
        if (!bool) {
          return;
        }
        if ((Build.VERSION.SDK_INT != 25) || (a() == 0))
        {
          i = Build.VERSION.SDK_INT;
          if (i <= 25) {}
        }
        else
        {
          try
          {
            ReflectLoadLibrary.V25.a(paramClassLoader, paramFile);
          }
          catch (Throwable localThrowable1)
          {
            ReflectLoadLibrary.V23.a(paramClassLoader, paramFile);
          }
          continue;
        }
        i = Build.VERSION.SDK_INT;
      }
      finally {}
      if (i >= 23) {
        try
        {
          ReflectLoadLibrary.V23.a(paramClassLoader, paramFile);
        }
        catch (Throwable localThrowable2)
        {
          ReflectLoadLibrary.V14.a(paramClassLoader, paramFile);
        }
      } else if (Build.VERSION.SDK_INT >= 14) {
        ReflectLoadLibrary.V14.a(paramClassLoader, paramFile);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.compact.ReflectLoadLibrary
 * JD-Core Version:    0.7.0.1
 */
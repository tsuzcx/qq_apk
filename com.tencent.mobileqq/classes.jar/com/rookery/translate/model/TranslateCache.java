package com.rookery.translate.model;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class TranslateCache
{
  private static TransMemCache a;
  private static TransDiskCache b;
  
  public static TransMemCache a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new TransMemCache(65536);
      }
      return a;
    }
    finally {}
  }
  
  public static TransDiskCache b(Context paramContext)
  {
    if (b == null)
    {
      int i = ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass() * 1048576 / 8;
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[TranslateCache]disk cache:");
        ((StringBuilder)localObject).append(i);
        QLog.d("Translator", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        localObject = b;
        if (localObject == null) {
          try
          {
            b = new TransDiskCache(paramContext, 1, i);
          }
          catch (IOException paramContext)
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("[TranslateCache] initcache error: ");
              ((StringBuilder)localObject).append(paramContext);
              QLog.e("Translator", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
      finally {}
    }
    return b;
  }
  
  public static TransDiskCache c(Context paramContext)
  {
    if (b == null) {
      ThreadManager.post(new TranslateCache.1(paramContext), 5, null, true);
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.model.TranslateCache
 * JD-Core Version:    0.7.0.1
 */
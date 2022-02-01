package com.tencent.mobileqq.ark.util;

import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.appmanage.LocalAppManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

public class ArkLocalCacheUtil
{
  public static void a()
  {
    QLog.i("ArkApp.ArkLocalCacheUtil", 1, "cleanArkAppCache");
    b();
    d();
    LocalAppManager.deleteAllLocalApps();
  }
  
  public static void b()
  {
    File localFile = new File(ArkEnvironmentManager.getInstance().getCacheDirectory());
    File[] arrayOfFile = localFile.listFiles(new ArkLocalCacheUtil.1());
    if (arrayOfFile != null)
    {
      Locale localLocale = Locale.CHINA;
      int j = arrayOfFile.length;
      int i = 0;
      QLog.i("ArkApp.ArkLocalCacheUtil", 1, String.format(localLocale, "cleanWebCache, count=%d, path=%s", new Object[] { Integer.valueOf(j), localFile.getAbsolutePath() }));
      j = arrayOfFile.length;
      while (i < j)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
  }
  
  public static void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ArkEnvironmentManager.getInstance().getStorageDirectory());
    localStringBuilder.append("/storage.db");
    new File(localStringBuilder.toString()).delete();
  }
  
  public static void d()
  {
    String str = ArkEnvironmentManager.getInstance().getResDirectory();
    String[] arrayOfString = new File(str).list();
    if ((arrayOfString != null) && (arrayOfString.length > 0))
    {
      int i = 0;
      while (i < arrayOfString.length)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(arrayOfString[i]);
        localObject = new File(((StringBuilder)localObject).toString());
        if (((File)localObject).isDirectory())
        {
          File[] arrayOfFile = ((File)localObject).listFiles();
          if (arrayOfFile != null)
          {
            QLog.i("ArkApp.ArkLocalCacheUtil", 1, String.format(Locale.CHINA, "cleanAppRes, count=%d, path=%s", new Object[] { Integer.valueOf(arrayOfFile.length), ((File)localObject).getAbsolutePath() }));
            int j = 0;
            while (j < arrayOfFile.length)
            {
              arrayOfFile[j].delete();
              j += 1;
            }
          }
        }
        else
        {
          ((File)localObject).delete();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.util.ArkLocalCacheUtil
 * JD-Core Version:    0.7.0.1
 */
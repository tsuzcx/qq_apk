package com.tencent.apkupdate.logic.protocol;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Environment;
import android.util.Log;
import com.tencent.apkupdate.a.e;
import com.tencent.apkupdate.b.c;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class a
{
  private static a b;
  private Context a;
  private ExecutorService c;
  
  public static a a()
  {
    try
    {
      if (b == null) {
        b = new a();
      }
      a locala = b;
      return locala;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    Object localObject = a().a.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(paramString, 0);
      if (localObject != null)
      {
        String str2 = ((PackageInfo)localObject).applicationInfo.sourceDir;
        localObject = new StringBuilder("packageName: ");
        ((StringBuilder)localObject).append(paramString);
        Log.i("ProtocolHelper", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder("localPath: ");
        ((StringBuilder)localObject).append(str2);
        Log.i("ProtocolHelper", ((StringBuilder)localObject).toString());
        long l1 = System.currentTimeMillis();
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = a().a;
        boolean bool = "mounted".equals(Environment.getExternalStorageState());
        String str1;
        if ((bool) && (Environment.getExternalStorageDirectory().canWrite()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getPath());
          ((StringBuilder)localObject).append("/mfcache");
          localObject = new File(((StringBuilder)localObject).toString());
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          str1 = ((File)localObject).getAbsolutePath();
          localObject = str1;
          if (!str1.endsWith("/"))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str1);
            ((StringBuilder)localObject).append("/");
          }
        }
        else
        {
          for (;;)
          {
            localObject = ((StringBuilder)localObject).toString();
            break;
            str1 = ((Context)localObject).getFilesDir().getAbsolutePath();
            localObject = str1;
            if (str1.endsWith("/")) {
              break;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(str1);
            ((StringBuilder)localObject).append("/");
          }
        }
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(paramString);
        localStringBuilder.append(".cache");
        paramString = localStringBuilder.toString();
        new e(str2, paramString).a();
        paramString = c.b(paramString);
        long l2 = System.currentTimeMillis();
        localObject = new StringBuilder("old_md5: cost=");
        ((StringBuilder)localObject).append(l2 - l1);
        ((StringBuilder)localObject).append("; md5=");
        ((StringBuilder)localObject).append(paramString);
        Log.i("ProtocolHelper", ((StringBuilder)localObject).toString());
        if (paramString != null) {
          return paramString;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public final void a(Context paramContext)
  {
    this.c = Executors.newFixedThreadPool(5);
    this.a = paramContext;
  }
  
  public final void a(Runnable paramRunnable)
  {
    Log.i("ProtocolHelper", "startNewTask");
    ExecutorService localExecutorService = this.c;
    if ((localExecutorService != null) && (!localExecutorService.isShutdown()))
    {
      Log.i("ProtocolHelper", "threadPool.execute");
      this.c.execute(paramRunnable);
    }
  }
  
  public final Context b()
  {
    return this.a;
  }
  
  public final String b(String paramString)
  {
    try
    {
      paramString = this.a.getPackageManager().getPackageInfo(paramString, 64);
      if (paramString != null)
      {
        paramString = paramString.signatures;
        if ((paramString != null) && (paramString.length > 0))
        {
          paramString = c.a(paramString[(paramString.length - 1)].toCharsString());
          return paramString;
        }
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public final void c()
  {
    Log.i("ProtocolHelper", "threadPool.shutdown()");
    ExecutorService localExecutorService = this.c;
    if (localExecutorService != null)
    {
      localExecutorService.shutdown();
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.a
 * JD-Core Version:    0.7.0.1
 */
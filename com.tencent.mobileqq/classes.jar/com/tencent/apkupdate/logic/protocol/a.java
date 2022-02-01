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
  private static a b = null;
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
        Log.i("ProtocolHelper", "packageName: " + paramString);
        Log.i("ProtocolHelper", "localPath: " + str2);
        long l1 = System.currentTimeMillis();
        StringBuilder localStringBuilder = new StringBuilder();
        localObject = a().a;
        String str1;
        if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite()))
        {
          localObject = new File(Environment.getExternalStorageDirectory().getPath() + "/mfcache");
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdirs();
          }
          str1 = ((File)localObject).getAbsolutePath();
          localObject = str1;
          if (!str1.endsWith("/")) {
            localObject = str1 + "/";
          }
        }
        for (;;)
        {
          paramString = (String)localObject + paramString + ".cache";
          new e(str2, paramString).a();
          paramString = c.b(paramString);
          long l2 = System.currentTimeMillis();
          Log.i("ProtocolHelper", "old_md5: cost=" + (l2 - l1) + "; md5=" + paramString);
          if (paramString == null) {
            break;
          }
          return paramString;
          str1 = ((Context)localObject).getFilesDir().getAbsolutePath();
          localObject = str1;
          if (!str1.endsWith("/")) {
            localObject = str1 + "/";
          }
        }
      }
      return "";
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public final void a(Context paramContext)
  {
    this.c = Executors.newFixedThreadPool(5);
    this.a = paramContext;
  }
  
  public final void a(Runnable paramRunnable)
  {
    Log.i("ProtocolHelper", "startNewTask");
    if ((this.c != null) && (!this.c.isShutdown()))
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
    if (this.c != null)
    {
      this.c.shutdown();
      this.c = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.a
 * JD-Core Version:    0.7.0.1
 */
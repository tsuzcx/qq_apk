package com.huawei.updatesdk.service.c;

import android.content.ContextWrapper;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.updatesdk.service.e.c;
import java.io.File;

public final class g$a
  extends AsyncTask<Void, Void, Boolean>
{
  private final String a;
  private final int b;
  private boolean c = false;
  private b d;
  
  private g$a(String paramString, int paramInt, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramBoolean;
  }
  
  private void a()
  {
    if (TextUtils.isEmpty(this.d.d())) {}
    File localFile;
    do
    {
      return;
      localFile = new File(this.d.d());
    } while ((!localFile.exists()) || (localFile.delete()));
    com.huawei.updatesdk.a.a.b.a.a.a.d("PackageService", "file delete error.");
  }
  
  public static void a(String paramString, int paramInt)
  {
    new a(paramString, paramInt, false).execute(new Void[0]);
  }
  
  public static void a(String paramString, int paramInt, boolean paramBoolean)
  {
    new a(paramString, paramInt, paramBoolean).execute(new Void[0]);
  }
  
  private void a(String paramString, File paramFile)
  {
    String str = paramString + File.separator + paramFile.getName();
    paramString = new File(paramString);
    if ((!paramString.exists()) && (!paramString.mkdirs())) {
      com.huawei.updatesdk.a.a.b.a.a.a.d("PackageService", "getbackFile mkdirs failed!");
    }
    paramString = new File(str);
    if (!f.a(paramFile, paramString))
    {
      if (!b())
      {
        g.a(5, 0);
        return;
      }
      this.c = false;
      return;
    }
    paramFile = paramString.getParentFile();
    if (paramFile != null) {
      paramFile.setExecutable(true, false);
    }
    paramString.setReadable(true, false);
    this.d.b(str);
    paramString = "install|pkg:" + this.d.c() + "|path:" + this.d.d();
    paramFile = new Thread(new e(com.huawei.updatesdk.a.b.a.a.a().b(), this.d));
    paramFile.setName(paramString);
    paramFile.start();
  }
  
  private boolean a(String paramString)
  {
    this.d = g.a(paramString);
    if (this.d == null) {}
    do
    {
      return false;
      if (1 != this.b) {
        break;
      }
    } while (TextUtils.isEmpty(this.d.d()));
    g.a.remove(c.b.a);
    return c.a(this.d.d());
    if (this.c)
    {
      this.d.b(this.d.f() + 1);
      if (this.d.f() >= h.a().length)
      {
        com.huawei.updatesdk.a.a.b.a.a.a.d("PackageService", "getRetryBackupPaths large,can not change file path to retry install");
        this.c = false;
        return false;
      }
      paramString = h.a()[this.d.f()];
      File localFile = new File(this.d.d());
      if (!localFile.exists())
      {
        com.huawei.updatesdk.a.a.b.a.a.a.d("PackageService", "file do not exist,can not change file path to retry install");
        this.c = false;
        return false;
      }
      a(paramString, localFile);
      return false;
    }
    a();
    return false;
  }
  
  private boolean b()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 23)
    {
      bool1 = bool2;
      if (-1 == new ContextWrapper(com.huawei.updatesdk.a.b.a.a.a().b()).checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE")) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  protected Boolean a(Void... paramVarArgs)
  {
    boolean bool = a(this.a);
    if ((this.d != null) && (c.b.a == this.d.e()) && (1 != this.b) && (!this.c) && (this.d.f() > -1)) {
      a();
    }
    return Boolean.valueOf(bool);
  }
  
  protected void a(Boolean paramBoolean)
  {
    super.onPostExecute(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.c.g.a
 * JD-Core Version:    0.7.0.1
 */
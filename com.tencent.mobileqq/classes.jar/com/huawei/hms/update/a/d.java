package com.huawei.hms.update.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.a.a.c;
import com.huawei.hms.update.provider.UpdateProvider;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.FileUtil;
import com.huawei.hms.utils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class d
  implements com.huawei.hms.update.a.a.a
{
  private final Context a;
  private final com.huawei.hms.update.b.d b = new com.huawei.hms.update.b.b();
  private final a c = new a();
  private com.huawei.hms.update.a.a.b d;
  private File e;
  
  public d(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  private b a(File paramFile, int paramInt, String paramString)
  {
    return new d.1(this, paramFile, paramInt, paramInt, paramString);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (this.d != null) {
        this.d.a(paramInt1, paramInt2, paramInt3, this.e);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void a(com.huawei.hms.update.a.a.b paramb)
  {
    try
    {
      this.d = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public void a()
  {
    HMSLog.i("UpdateDownload", "Enter cancel.");
    a(null);
    this.b.b();
  }
  
  public void a(com.huawei.hms.update.a.a.b paramb, c paramc)
  {
    Checker.checkNonNull(paramb, "callback must not be null.");
    HMSLog.i("UpdateDownload", "Enter downloadPackage.");
    a(paramb);
    if ((paramc == null) || (!paramc.a()))
    {
      HMSLog.e("UpdateDownload", "In downloadPackage, Invalid update info.");
      a(2201, 0, 0);
      return;
    }
    if (!"mounted".equals(Environment.getExternalStorageState()))
    {
      HMSLog.e("UpdateDownload", "In downloadPackage, Invalid external storage for downloading file.");
      a(2204, 0, 0);
      return;
    }
    paramb = paramc.b;
    if (TextUtils.isEmpty(paramb))
    {
      HMSLog.e("UpdateDownload", "In DownloadHelper.downloadPackage, Download the package,  packageName is null: ");
      a(2201, 0, 0);
      return;
    }
    this.e = UpdateProvider.getLocalFile(this.a, paramb + ".apk");
    if (this.e == null)
    {
      HMSLog.e("UpdateDownload", "In downloadPackage, Failed to get local file for downloading.");
      a(2204, 0, 0);
      return;
    }
    paramb = this.e.getParentFile();
    if ((paramb == null) || ((!paramb.mkdirs()) && (!paramb.isDirectory())))
    {
      HMSLog.e("UpdateDownload", "In downloadPackage, Failed to create directory for downloading file.");
      a(2201, 0, 0);
      return;
    }
    if (paramb.getUsableSpace() < paramc.d * 3)
    {
      HMSLog.e("UpdateDownload", "In downloadPackage, No space for downloading file.");
      a(2203, 0, 0);
      return;
    }
    try
    {
      a(paramc);
      return;
    }
    catch (com.huawei.hms.update.b.a paramb)
    {
      HMSLog.w("UpdateDownload", "In downloadPackage, Canceled to download the update file.");
      a(2101, 0, 0);
    }
  }
  
  void a(c paramc)
  {
    HMSLog.i("UpdateDownload", "Enter downloadPackage.");
    localObject2 = null;
    localb1 = null;
    localb2 = localb1;
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        str = paramc.b;
        localb2 = localb1;
        localObject1 = localObject2;
        if (TextUtils.isEmpty(str))
        {
          localb2 = localb1;
          localObject1 = localObject2;
          HMSLog.e("UpdateDownload", "In DownloadHelper.downloadPackage, Download the package,  packageName is null: ");
          localb2 = localb1;
          localObject1 = localObject2;
          a(2201, 0, 0);
          this.b.a();
          IOUtils.closeQuietly(null);
          return;
        }
        localb2 = localb1;
        localObject1 = localObject2;
        this.c.a(b(), str);
        localb2 = localb1;
        localObject1 = localObject2;
        if (!this.c.b(paramc.c, paramc.d, paramc.e)) {
          continue;
        }
        localb2 = localb1;
        localObject1 = localObject2;
        if (this.c.b() != this.c.a()) {
          continue;
        }
        localb2 = localb1;
        localObject1 = localObject2;
        if (FileUtil.verifyHash(paramc.e, this.e))
        {
          localb2 = localb1;
          localObject1 = localObject2;
          a(2000, 0, 0);
          this.b.a();
          IOUtils.closeQuietly(null);
          return;
        }
        localb2 = localb1;
        localObject1 = localObject2;
        this.c.a(paramc.c, paramc.d, paramc.e);
        localb2 = localb1;
        localObject1 = localObject2;
        localb1 = a(this.e, paramc.d, str);
      }
      catch (IOException paramc)
      {
        String str;
        int i;
        localObject1 = localb2;
        HMSLog.e("UpdateDownload", "In DownloadHelper.downloadPackage, Failed to download." + paramc.getMessage());
        localObject1 = localb2;
        a(2201, 0, 0);
        this.b.a();
        IOUtils.closeQuietly(localb2);
        return;
        localb2 = localb1;
        localObject1 = localObject2;
        this.c.a(paramc.c, paramc.d, paramc.e);
        localb2 = localb1;
        localObject1 = localObject2;
        localb1 = a(this.e, paramc.d, str);
        continue;
        localb2 = localb1;
        localObject1 = localb1;
        if (FileUtil.verifyHash(paramc.e, this.e)) {
          continue;
        }
        localb2 = localb1;
        localObject1 = localb1;
        a(2202, 0, 0);
        this.b.a();
        IOUtils.closeQuietly(localb1);
        return;
        localb2 = localb1;
        localObject1 = localb1;
        a(2000, 0, 0);
        this.b.a();
        IOUtils.closeQuietly(localb1);
        return;
      }
      finally
      {
        this.b.a();
        IOUtils.closeQuietly((OutputStream)localObject1);
      }
      localb2 = localb1;
      localObject1 = localb1;
      i = this.b.a(paramc.c, localb1, this.c.b(), this.c.a(), this.a);
      if ((i == 200) || (i == 206)) {
        continue;
      }
      localb2 = localb1;
      localObject1 = localb1;
      HMSLog.e("UpdateDownload", "In DownloadHelper.downloadPackage, Download the package, HTTP code: " + i);
      localb2 = localb1;
      localObject1 = localb1;
      a(2201, 0, 0);
      this.b.a();
      IOUtils.closeQuietly(localb1);
      return;
      localb2 = localb1;
      localObject1 = localObject2;
      localb1 = a(this.e, paramc.d, str);
      localb2 = localb1;
      localObject1 = localb1;
      localb1.a(this.c.b());
    }
  }
  
  public Context b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.update.a.d
 * JD-Core Version:    0.7.0.1
 */
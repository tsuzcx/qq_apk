package com.huawei.updatesdk.support.pm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.huawei.updatesdk.a.a.b.a.a.a;
import com.huawei.updatesdk.a.b.c.b;
import com.huawei.updatesdk.fileprovider.UpdateSdkFileProvider;
import com.huawei.updatesdk.service.c.g;
import com.huawei.updatesdk.service.c.g.a;
import com.huawei.updatesdk.service.c.h;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

public class PackageInstallerActivity
  extends Activity
{
  private String a = "";
  private String b = "";
  private int c = -1;
  
  private Intent a(Context paramContext, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.contains("../")) || (paramString.contains("..")) || (paramString.contains("%00")) || (paramString.contains(".\\.\\")) || (paramString.contains("./"))) {
      throw new IllegalArgumentException("getNomalInstallIntent: Not a standard path");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.INSTALL_PACKAGE");
    if (Build.VERSION.SDK_INT >= 24)
    {
      localIntent.addFlags(1);
      localIntent.setData(UpdateSdkFileProvider.getUriForFile(paramContext, paramContext.getApplicationContext().getPackageName() + ".updateSdk.fileProvider", new File(paramString)));
    }
    for (;;)
    {
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      return localIntent;
      localIntent.setData(Uri.fromFile(new File(paramString)));
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = -10004;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (1000 == paramInt1)
    {
      if (paramInt2 != 0) {
        break label34;
      }
      g.a(7, 0);
    }
    for (;;)
    {
      finish();
      return;
      label34:
      paramInt1 = i;
      if (paramIntent != null) {
        paramInt1 = b.a(paramIntent).b("android.intent.extra.INSTALL_RESULT", -10004);
      }
      paramIntent = h.a();
      if ((Build.VERSION.SDK_INT < 24) && (-3 == paramInt1) && (this.c < paramIntent.length - 1)) {
        g.a.a(this.b, -3, true);
      } else if ((paramInt1 != 0) && (paramInt1 != 1)) {
        g.a(4, paramInt1);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      finish();
      a.d("PackageInstallerActivity", "PackageInstallerActivity error intent");
      return;
    }
    paramBundle = b.a(paramBundle);
    this.a = paramBundle.a("install_path");
    this.b = paramBundle.a("install_packagename");
    if (TextUtils.isEmpty(this.a))
    {
      g.a(4, -3);
      finish();
      a.d("PackageInstallerActivity", "PackageInstallerActivity can not find filePath.");
      return;
    }
    this.c = paramBundle.b("install_change_path_times", -1);
    try
    {
      paramBundle = a(this, this.a);
      paramBundle.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
      paramBundle.putExtra("android.intent.extra.RETURN_RESULT", true);
      a.c("PackageInstallerActivity", " onCreate filePath:" + this.a + ",packageName:" + this.b + ",taskId:" + getTaskId());
      startActivityForResult(paramBundle, 1000);
      return;
    }
    catch (Exception paramBundle)
    {
      a.d("PackageInstallerActivity", "can not start install action");
      g.a(4, -2);
      finish();
    }
  }
  
  protected void onDestroy()
  {
    finishActivity(1000);
    super.onDestroy();
    a.c("PackageInstallerActivity", " onDestroy removeTaskId:" + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.support.pm.PackageInstallerActivity
 * JD-Core Version:    0.7.0.1
 */
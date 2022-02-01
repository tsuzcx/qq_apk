package com.huawei.updatesdk.service.otaupdate;

import android.widget.Toast;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.f.a;

class AppUpdateActivity$6
  implements com.huawei.updatesdk.service.f.b
{
  AppUpdateActivity$6(AppUpdateActivity paramAppUpdateActivity, ApkUpgradeInfo paramApkUpgradeInfo, a parama) {}
  
  public void a()
  {
    if (!com.huawei.updatesdk.a.a.c.b.b.a(this.c))
    {
      Toast.makeText(this.c, g.b(this.c, "upsdk_no_available_network_prompt_toast"), 0).show();
      this.c.finish();
      return;
    }
    AppUpdateActivity.b(this.c, this.a);
    this.b.c();
  }
  
  public void b()
  {
    this.b.c();
    if (AppUpdateActivity.f(this.c))
    {
      AppUpdateActivity.a(this.c, AppUpdateActivity.g(this.c));
      return;
    }
    AppUpdateActivity.b(this.c, 4);
    this.c.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.6
 * JD-Core Version:    0.7.0.1
 */
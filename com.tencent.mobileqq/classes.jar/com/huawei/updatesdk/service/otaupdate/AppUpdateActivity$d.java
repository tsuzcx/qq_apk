package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.content.Intent;
import com.huawei.updatesdk.a.b.c.b;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.c.g.a;

class AppUpdateActivity$d
  extends com.huawei.updatesdk.a.b.c.a
{
  private AppUpdateActivity$d(AppUpdateActivity paramAppUpdateActivity) {}
  
  public void a(Context paramContext, b paramb)
  {
    if (!paramb.d()) {}
    do
    {
      do
      {
        do
        {
          return;
          if (AppUpdateActivity.e(this.a) != null) {
            AppUpdateActivity.e(this.a).c();
          }
          AppUpdateActivity.c(this.a);
          paramContext = paramb.b();
          paramb = paramb.c().getDataString();
        } while ((paramb == null) || (paramb.length() < 9));
        paramb = paramb.substring(8);
      } while ((!"android.intent.action.PACKAGE_ADDED".equals(paramContext)) || (!AppUpdateActivity.j(this.a).equals(paramb)));
      d.a().a(AppUpdateActivity.a(this.a, 6, 0, -1));
      g.a.a(paramb, 1);
      AppUpdateActivity.a(this.a, AppUpdateActivity.g(this.a).getPackage_(), AppUpdateActivity.g(this.a).getDetailId_());
    } while (!AppUpdateActivity.f(this.a));
    AppUpdateActivity.a(this.a, AppUpdateActivity.g(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.d
 * JD-Core Version:    0.7.0.1
 */
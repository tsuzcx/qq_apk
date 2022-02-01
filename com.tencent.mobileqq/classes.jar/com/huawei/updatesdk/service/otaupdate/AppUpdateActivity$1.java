package com.huawei.updatesdk.service.otaupdate;

import android.os.Bundle;
import com.huawei.updatesdk.a.b.c.b;

class AppUpdateActivity$1
  implements Runnable
{
  AppUpdateActivity$1(AppUpdateActivity paramAppUpdateActivity, b paramb) {}
  
  public void run()
  {
    Bundle localBundle = this.a.a();
    if (localBundle == null) {
      return;
    }
    int i = localBundle.getInt("INSTALL_STATE");
    int j = localBundle.getInt("INSTALL_TYPE");
    d.a().a(AppUpdateActivity.a(this.b, i, j, -1));
    AppUpdateActivity.a(this.b, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.1
 * JD-Core Version:    0.7.0.1
 */
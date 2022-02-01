package com.huawei.updatesdk.service.otaupdate;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.huawei.updatesdk.a.a.b.a.a.a;

public class AppUpdateActivity$a
  implements c.a
{
  public AppUpdateActivity$a(AppUpdateActivity paramAppUpdateActivity) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue()) {}
    try
    {
      paramBoolean = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateRemindAction");
      paramBoolean.setPackage("com.huawei.appmarket");
      this.a.startActivity(paramBoolean);
      this.a.finish();
      return;
    }
    catch (ActivityNotFoundException paramBoolean)
    {
      for (;;)
      {
        a.d("AppUpdateActivity", "goHiappUpgrade error: " + paramBoolean.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.AppUpdateActivity.a
 * JD-Core Version:    0.7.0.1
 */
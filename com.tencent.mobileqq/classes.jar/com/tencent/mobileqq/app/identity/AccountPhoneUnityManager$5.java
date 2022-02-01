package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class AccountPhoneUnityManager$5
  implements View.OnClickListener
{
  AccountPhoneUnityManager$5(AccountPhoneUnityManager paramAccountPhoneUnityManager, Activity paramActivity, boolean paramBoolean, AppRuntime paramAppRuntime) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - AccountPhoneUnityManager.b(this.d) >= 1000L)
    {
      AccountPhoneUnityManager.a(this.d, System.currentTimeMillis());
      QRoute.startUri(this.a, "/base/phoneUnityBindInfo");
      String str;
      if (this.b) {
        str = "0X800B3E7";
      } else {
        str = "0X800B3E4";
      }
      ReportController.b(this.c, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.5
 * JD-Core Version:    0.7.0.1
 */
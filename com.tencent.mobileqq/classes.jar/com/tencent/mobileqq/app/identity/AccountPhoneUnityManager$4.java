package com.tencent.mobileqq.app.identity;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class AccountPhoneUnityManager$4
  implements View.OnClickListener
{
  AccountPhoneUnityManager$4(AccountPhoneUnityManager paramAccountPhoneUnityManager, boolean paramBoolean, Activity paramActivity, AppRuntime paramAppRuntime) {}
  
  public void onClick(View paramView)
  {
    AccountPhoneUnityManager.a(this.d).dismiss();
    if (this.a)
    {
      ((ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class)).logout(this.b, this.c, true);
    }
    else
    {
      BannerManager.a().a(BannerTypeCollections.b, 2, null);
      ReportController.b(this.c, "dc00898", "", "", "0X800B3E5", "0X800B3E5", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.AccountPhoneUnityManager.4
 * JD-Core Version:    0.7.0.1
 */
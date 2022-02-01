package com.tencent.mobileqq.activity;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class AccountManageActivity$6
  implements CompoundButton.OnCheckedChangeListener
{
  AccountManageActivity$6(AccountManageActivity paramAccountManageActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    Object localObject = this.a;
    SettingCloneUtil.writeValue((Context)localObject, ((AccountManageActivity)localObject).app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", paramBoolean);
    ((ISubAccountService)this.a.app.getRuntimeService(ISubAccountService.class, "")).updateNotifySwitch(this.a.app);
    localObject = this.a.app;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBoolean ^ true);
    localStringBuilder.append("");
    ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X800AC3A", "0X800AC3A", 0, 0, localStringBuilder.toString(), "", "", "");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.6
 * JD-Core Version:    0.7.0.1
 */
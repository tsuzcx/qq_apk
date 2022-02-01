package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssociatedAccountActivity$2
  implements CompoundButton.OnCheckedChangeListener
{
  AssociatedAccountActivity$2(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    SettingCloneUtil.writeValue(this.a, this.a.app.getCurrentAccountUin(), null, "qqsetting_subaccount_notify", paramBoolean);
    ((SubAccountManager)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER)).a(this.a.app);
    QQAppInterface localQQAppInterface = this.a.app;
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800AC3A", "0X800AC3A", 0, 0, i + "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AssociatedAccountActivity$1
  implements View.OnClickListener
{
  AssociatedAccountActivity$1(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X8007144", "0X8007144", 0, 0, "", "", "", "");
    Object localObject = (SubAccountServiceImpl)this.a.app.getRuntimeService(ISubAccountService.class, "");
    boolean bool;
    if ((localObject != null) && (((SubAccountServiceImpl)localObject).getBindedNumber() >= 2)) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("click top right manage btn underTwo = ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("AssociatedAccountActivity", 2, ((StringBuilder)localObject).toString());
    }
    AssociatedAccountActivity.access$000(this.a, bool);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountActivity.1
 * JD-Core Version:    0.7.0.1
 */
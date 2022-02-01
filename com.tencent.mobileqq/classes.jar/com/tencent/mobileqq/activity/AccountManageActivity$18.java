package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class AccountManageActivity$18
  implements View.OnClickListener
{
  AccountManageActivity$18(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004038", "0X8004038", 0, 0, String.valueOf(this.a.jdField_a_of_type_JavaUtilList.size()), "", "", "");
    if (!AccountManageActivity.b(this.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      AccountManageActivity.b(this.a, SubAccountControll.a(this.a.app));
      Object localObject = paramView.getTag();
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Switch_Account", 2, "switch a non-existing account");
        }
      }
      else
      {
        int i = ((Integer)localObject).intValue();
        localObject = (SimpleAccount)this.a.jdField_a_of_type_JavaUtilList.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("Switch_Account", 2, "switch uin:" + ((SimpleAccount)localObject).getUin());
        }
        if ((localObject != null) && (!((SimpleAccount)localObject).getUin().equals(this.a.app.getCurrentAccountUin())))
        {
          ReportController.b(this.a.app, "CliOper", "", "", "0X8009C05", "0X8009C05", 0, 0, "", "", "", "");
          this.a.f();
          this.a.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = ((SimpleAccount)localObject);
          AccountManageActivity.c(this.a, true);
          AccountManageActivity.d(this.a, true);
          ReportController.b(this.a.app, "dc00898", "", "", "0X800AC38", "0X800AC38", 0, 0, "", "", "", "");
          this.a.app.switchAccount((SimpleAccount)localObject, null);
          SubAccountAssistantForward.a(this.a.app, this.a);
        }
        AlbumUtil.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.18
 * JD-Core Version:    0.7.0.1
 */
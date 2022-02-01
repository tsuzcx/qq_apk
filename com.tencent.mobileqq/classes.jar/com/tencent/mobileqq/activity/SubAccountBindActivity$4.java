package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SubAccountBindActivity$4
  implements View.OnClickListener
{
  SubAccountBindActivity$4(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onAddAccountClick.onClick:add account");
    }
    Object localObject = (SubAccountManager)this.a.app.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
    if (localObject != null) {}
    for (int i = ((SubAccountManager)localObject).a();; i = 0)
    {
      if (i < 2)
      {
        localObject = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject).putExtra("fromWhere", this.a.b);
        this.a.startActivity((Intent)localObject);
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        SubAccountControll.a(this.a.app, this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.4
 * JD-Core Version:    0.7.0.1
 */
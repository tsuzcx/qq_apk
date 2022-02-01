package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl;
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
    int i = 0;
    Object localObject = (SubAccountServiceImpl)this.a.app.getRuntimeService(ISubAccountService.class, "");
    if (localObject != null) {
      i = ((SubAccountServiceImpl)localObject).getBindedNumber();
    }
    if (i < 2)
    {
      localObject = new Intent(this.a, SubLoginActivity.class);
      ((Intent)localObject).putExtra("fromWhere", this.a.fromWhere);
      this.a.startActivity((Intent)localObject);
    }
    else
    {
      SubAccountControllUtil.a(this.a.app, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.4
 * JD-Core Version:    0.7.0.1
 */
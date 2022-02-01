package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LoginInfoActivity$10
  implements View.OnClickListener
{
  LoginInfoActivity$10(LoginInfoActivity paramLoginInfoActivity, Button paramButton, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (!NetworkUtil.isNetSupport(this.c))
    {
      localObject = this.c;
      QQToast.makeText((Context)localObject, ((LoginInfoActivity)localObject).getString(2131889169), 0).show(this.c.getTitleBarHeight());
    }
    else
    {
      ReportController.b(this.c.app, "CliOper", "", "", "My_eq", "Kick_off_PC", 0, 0, "", "", "", "");
      localObject = (SvcDevLoginInfo)this.a.getTag();
      if (localObject != null) {
        this.c.app.getSubAccountKey(this.c.app.getAccount(), this.c.app.getAccount(), new LoginInfoActivity.10.1(this, (SvcDevLoginInfo)localObject));
      } else {
        QQToast.makeText(this.c.getApplicationContext(), this.c.getString(2131892053), 0).show(this.c.getTitleBarHeight());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.10
 * JD-Core Version:    0.7.0.1
 */
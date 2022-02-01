package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.vas.qid.VipQidHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountManageActivity$34
  implements View.OnClickListener
{
  AccountManageActivity$34(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    VipQidHelper.a(this.a, null);
    VipQidHelper.a("0X800B5C7", AccountManageActivity.a(this.a));
    ((IRedTouchManager)this.a.app.getRuntimeService(IRedTouchManager.class, "")).onRedTouchItemClick("100190.100193.100192");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.34
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UserLoginLogic$2
  implements View.OnClickListener
{
  UserLoginLogic$2(UserLoginLogic paramUserLoginLogic) {}
  
  public void onClick(View paramView)
  {
    this.a.a.d();
    UserLoginLogic.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic.2
 * JD-Core Version:    0.7.0.1
 */
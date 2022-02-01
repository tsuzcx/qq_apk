package com.tencent.mobileqq.Doraemon.impl.commonModule;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UserLoginLogic$3
  implements View.OnClickListener
{
  UserLoginLogic$3(UserLoginLogic paramUserLoginLogic) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.d();
    DoraemonUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, 4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic.3
 * JD-Core Version:    0.7.0.1
 */
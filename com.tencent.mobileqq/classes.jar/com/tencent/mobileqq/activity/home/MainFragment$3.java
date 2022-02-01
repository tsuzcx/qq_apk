package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import mqq.app.AppRuntime;

class MainFragment$3
  implements Runnable
{
  MainFragment$3(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityMainMainAssistObserver.a();
    }
    if (this.this$0.jdField_a_of_type_MqqAppAppRuntime != null)
    {
      ((QIMNewFriendManager)this.this$0.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(MainFragment.a(this.this$0));
      this.this$0.jdField_a_of_type_MqqAppAppRuntime.registObserver(MainFragment.a(this.this$0));
      this.this$0.jdField_a_of_type_MqqAppAppRuntime.registObserver(MainFragment.a(this.this$0));
    }
    MainFragment.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.3
 * JD-Core Version:    0.7.0.1
 */
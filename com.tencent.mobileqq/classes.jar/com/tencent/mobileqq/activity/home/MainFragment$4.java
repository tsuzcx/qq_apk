package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.main.MainAssistObserver;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import mqq.app.AppRuntime;

class MainFragment$4
  implements Runnable
{
  MainFragment$4(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (this.this$0.e != null) {
      this.this$0.e.a();
    }
    if (this.this$0.A != null)
    {
      ((QIMNewFriendManager)this.this$0.A.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(MainFragment.a(this.this$0));
      this.this$0.A.registObserver(MainFragment.b(this.this$0));
      this.this$0.A.registObserver(MainFragment.c(this.this$0));
    }
    MainFragment.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.4
 * JD-Core Version:    0.7.0.1
 */
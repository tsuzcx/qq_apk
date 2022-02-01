package com.tencent.mobileqq.activity.home;

import akam;
import aoay;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class MainFragment$2
  implements Runnable
{
  MainFragment$2(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      this.this$0.a.a();
    }
    if (MainFragment.a(this.this$0) != null)
    {
      ((aoay)MainFragment.a(this.this$0).getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(MainFragment.a(this.this$0));
      MainFragment.a(this.this$0).registObserver(MainFragment.a(this.this$0));
      MainFragment.a(this.this$0).registObserver(MainFragment.a(this.this$0));
    }
    MainFragment.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.home;

import anri;
import azaz;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class MainFragment$20
  implements Runnable
{
  MainFragment$20(MainFragment paramMainFragment) {}
  
  public void run()
  {
    azaz localazaz = (azaz)MainFragment.a(this.this$0).getManager(QQManagerFactory.AUTO_REPLY_MANAGER);
    ((anri)MainFragment.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).B();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.20
 * JD-Core Version:    0.7.0.1
 */
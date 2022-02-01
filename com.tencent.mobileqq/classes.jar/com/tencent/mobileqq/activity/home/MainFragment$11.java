package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.onlinestatus.AutoReplyManager;
import mqq.app.AppRuntime;

class MainFragment$11
  implements Runnable
{
  MainFragment$11(MainFragment paramMainFragment) {}
  
  public void run()
  {
    AutoReplyManager localAutoReplyManager = (AutoReplyManager)this.this$0.a.getManager(QQManagerFactory.AUTO_REPLY_MANAGER);
    ((CardHandler)this.this$0.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).o();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.11
 * JD-Core Version:    0.7.0.1
 */
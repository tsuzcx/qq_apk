package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.vip.manager.BirthDayNoticeManager;

final class ChatActivityFacade$6
  implements Runnable
{
  ChatActivityFacade$6(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo) {}
  
  public void run()
  {
    BirthDayNoticeManager.a(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.6
 * JD-Core Version:    0.7.0.1
 */
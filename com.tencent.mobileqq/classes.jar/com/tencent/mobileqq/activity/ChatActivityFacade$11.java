package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.QQAppInterface;

final class ChatActivityFacade$11
  implements Runnable
{
  ChatActivityFacade$11(String paramString, BaseSessionInfo paramBaseSessionInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      String str = this.a;
      int i = this.b.a;
      QQAppInterface localQQAppInterface = this.c;
      StatisticConstants.a(new String[] { str }, i, false, false, -1, localQQAppInterface);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.11
 * JD-Core Version:    0.7.0.1
 */
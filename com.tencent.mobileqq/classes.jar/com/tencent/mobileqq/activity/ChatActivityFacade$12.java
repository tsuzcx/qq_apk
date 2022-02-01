package com.tencent.mobileqq.activity;

import akrx;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public final class ChatActivityFacade$12
  implements Runnable
{
  public ChatActivityFacade$12(String paramString, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      akrx.a(new String[] { str }, i, false, false, -1, localQQAppInterface);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.12
 * JD-Core Version:    0.7.0.1
 */
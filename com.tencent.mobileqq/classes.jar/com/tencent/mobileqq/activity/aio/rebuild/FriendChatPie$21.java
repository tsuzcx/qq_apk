package com.tencent.mobileqq.activity.aio.rebuild;

import abor;
import abot;
import abpd;
import aemc;
import agld;
import android.os.SystemClock;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendChatPie$21
  implements Runnable
{
  public FriendChatPie$21(agld paramagld) {}
  
  public void run()
  {
    if (!abot.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).f(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
    do
    {
      return;
      agld.a(this.this$0, SystemClock.uptimeMillis());
      ((aemc)agld.a(this.this$0).a).a(agld.b(this.this$0));
      agld.b(this.this$0).e = false;
      agld.c(this.this$0).f = true;
    } while (agld.d(this.this$0).c != 0);
    abpd localabpd = agld.e(this.this$0);
    localabpd.c += 1;
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, agld.f(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.21
 * JD-Core Version:    0.7.0.1
 */
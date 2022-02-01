package com.tencent.mobileqq.activity.aio.rebuild;

import adai;
import adak;
import aday;
import aggv;
import aijm;
import android.os.SystemClock;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendChatPie$21
  implements Runnable
{
  public FriendChatPie$21(aijm paramaijm) {}
  
  public void run()
  {
    if (!adak.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).f(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
    do
    {
      return;
      aijm.a(this.this$0, SystemClock.uptimeMillis());
      ((aggv)aijm.a(this.this$0).a).a(aijm.b(this.this$0));
      aijm.b(this.this$0).e = false;
      aijm.c(this.this$0).f = true;
    } while (aijm.d(this.this$0).c != 0);
    aday localaday = aijm.e(this.this$0);
    localaday.c += 1;
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, aijm.f(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.21
 * JD-Core Version:    0.7.0.1
 */
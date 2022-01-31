package com.tencent.mobileqq.activity.aio.rebuild;

import acus;
import aeom;
import akpu;
import akpx;
import akqr;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class FriendChatPie$21
  implements Runnable
{
  public FriendChatPie$21(aeom paramaeom) {}
  
  public void run()
  {
    if (!akpx.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).e(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
    do
    {
      return;
      aeom.a(this.this$0, SystemClock.uptimeMillis());
      ((acus)aeom.a(this.this$0).a).a(aeom.b(this.this$0));
      aeom.b(this.this$0).e = false;
      aeom.c(this.this$0).f = true;
    } while (aeom.d(this.this$0).c != 0);
    akqr localakqr = aeom.e(this.this$0);
    localakqr.c += 1;
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, aeom.f(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.21
 * JD-Core Version:    0.7.0.1
 */
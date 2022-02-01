package com.tencent.mobileqq.activity.aio.rebuild;

import acwf;
import acwh;
import acwr;
import afxb;
import ahzy;
import android.os.SystemClock;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class FriendChatPie$21
  implements Runnable
{
  public FriendChatPie$21(ahzy paramahzy) {}
  
  public void run()
  {
    if (!acwh.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).f(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
    do
    {
      return;
      ahzy.a(this.this$0, SystemClock.uptimeMillis());
      ((afxb)ahzy.a(this.this$0).a).a(ahzy.b(this.this$0));
      ahzy.b(this.this$0).e = false;
      ahzy.c(this.this$0).f = true;
    } while (ahzy.d(this.this$0).c != 0);
    acwr localacwr = ahzy.e(this.this$0);
    localacwr.c += 1;
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, ahzy.f(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.21
 * JD-Core Version:    0.7.0.1
 */
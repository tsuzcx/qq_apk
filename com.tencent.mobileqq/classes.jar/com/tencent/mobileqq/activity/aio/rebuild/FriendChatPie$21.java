package com.tencent.mobileqq.activity.aio.rebuild;

import acuw;
import aeoo;
import akpv;
import akpy;
import akqs;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class FriendChatPie$21
  implements Runnable
{
  public FriendChatPie$21(aeoo paramaeoo) {}
  
  public void run()
  {
    if (!akpy.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).e(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
    do
    {
      return;
      aeoo.a(this.this$0, SystemClock.uptimeMillis());
      ((acuw)aeoo.a(this.this$0).a).a(aeoo.b(this.this$0));
      aeoo.b(this.this$0).e = false;
      aeoo.c(this.this$0).f = true;
    } while (aeoo.d(this.this$0).c != 0);
    akqs localakqs = aeoo.e(this.this$0);
    localakqs.c += 1;
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, aeoo.f(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.21
 * JD-Core Version:    0.7.0.1
 */
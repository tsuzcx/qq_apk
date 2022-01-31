package com.tencent.mobileqq.activity.aio.rebuild;

import ackd;
import aedo;
import akbj;
import akbm;
import akcg;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;

public class FriendChatPie$22
  implements Runnable
{
  public FriendChatPie$22(aedo paramaedo) {}
  
  public void run()
  {
    if (!akbm.c(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).e(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {}
    do
    {
      return;
      aedo.a(this.this$0, SystemClock.uptimeMillis());
      ((ackd)aedo.a(this.this$0).a).a(aedo.b(this.this$0));
      aedo.b(this.this$0).e = false;
      aedo.c(this.this$0).f = true;
    } while (aedo.d(this.this$0).c != 0);
    akcg localakcg = aedo.e(this.this$0);
    localakcg.c += 1;
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 15, aedo.f(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.22
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild;

import aidf;
import aido;
import axby;
import bcsy;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class NearbyChatPieObserver$1
  implements Runnable
{
  public NearbyChatPieObserver$1(aido paramaido, boolean paramBoolean, String paramString, axby paramaxby) {}
  
  public void run()
  {
    bcsy localbcsy = new bcsy(aido.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "msg_suc";; str = "msg_fail")
    {
      localbcsy.d(str).e(aido.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a(new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Axby.b()) }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPieObserver.1
 * JD-Core Version:    0.7.0.1
 */
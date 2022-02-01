package com.tencent.mobileqq.activity.aio.rebuild;

import aimx;
import aing;
import axup;
import bdlq;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class NearbyChatPieObserver$1
  implements Runnable
{
  public NearbyChatPieObserver$1(aing paramaing, boolean paramBoolean, String paramString, axup paramaxup) {}
  
  public void run()
  {
    bdlq localbdlq = new bdlq(aing.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "msg_suc";; str = "msg_fail")
    {
      localbdlq.d(str).e(aing.a(this.this$0).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a(new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Axup.b()) }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPieObserver.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild;

import aerj;
import aerl;
import aszf;
import axrc;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class NearbyChatPie$11$1
  implements Runnable
{
  public NearbyChatPie$11$1(aerl paramaerl, boolean paramBoolean, String paramString, aszf paramaszf) {}
  
  public void run()
  {
    axrc localaxrc = new axrc(this.jdField_a_of_type_Aerl.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "msg_suc";; str = "msg_fail")
    {
      localaxrc.d(str).e(this.jdField_a_of_type_Aerl.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a(new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Aszf.b()) }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.11.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild;

import aego;
import aegq;
import ascz;
import awrb;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class NearbyChatPie$11$1
  implements Runnable
{
  public NearbyChatPie$11$1(aegq paramaegq, boolean paramBoolean, String paramString, ascz paramascz) {}
  
  public void run()
  {
    awrb localawrb = new awrb(this.jdField_a_of_type_Aegq.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "msg_suc";; str = "msg_fail")
    {
      localawrb.d(str).e(this.jdField_a_of_type_Aegq.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a(new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Ascz.b()) }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.11.1
 * JD-Core Version:    0.7.0.1
 */
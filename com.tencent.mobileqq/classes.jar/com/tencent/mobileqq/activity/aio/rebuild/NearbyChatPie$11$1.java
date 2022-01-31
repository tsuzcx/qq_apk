package com.tencent.mobileqq.activity.aio.rebuild;

import agsy;
import agta;
import auul;
import azqx;
import com.tencent.mobileqq.activity.aio.SessionInfo;

public class NearbyChatPie$11$1
  implements Runnable
{
  public NearbyChatPie$11$1(agta paramagta, boolean paramBoolean, String paramString, auul paramauul) {}
  
  public void run()
  {
    azqx localazqx = new azqx(this.jdField_a_of_type_Agta.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card");
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "msg_suc";; str = "msg_fail")
    {
      localazqx.d(str).e(this.jdField_a_of_type_Agta.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).a(new String[] { this.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Auul.b()) }).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.11.1
 * JD-Core Version:    0.7.0.1
 */
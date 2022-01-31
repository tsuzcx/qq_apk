package com.tencent.mobileqq.apollo;

import akpy;
import albf;
import alhp;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class ChatPieApolloViewController$5
  implements Runnable
{
  public ChatPieApolloViewController$5(akpy paramakpy, int paramInt, BaseChatPie paramBaseChatPie, albf paramalbf) {}
  
  public void run()
  {
    alhp.a(this.jdField_a_of_type_Int, 101, 0, new Object[] { "parallel surfaceReady" });
    QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil start preLoad Js");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_Albf != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null))
    {
      this.jdField_a_of_type_Albf.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a);
      this.jdField_a_of_type_Albf.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.5
 * JD-Core Version:    0.7.0.1
 */
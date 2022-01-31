package com.tencent.mobileqq.apollo;

import aitz;
import ajfg;
import ajlq;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;

public class ChatPieApolloViewController$5
  implements Runnable
{
  public ChatPieApolloViewController$5(aitz paramaitz, int paramInt, BaseChatPie paramBaseChatPie, ajfg paramajfg) {}
  
  public void run()
  {
    ajlq.a(this.jdField_a_of_type_Int, 101, 0, new Object[] { "parallel surfaceReady" });
    QLog.i("sava_ChatPieApolloViewController", 1, "TraceReport CmShowStatUtil start preLoad Js");
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_Ajfg != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null))
    {
      this.jdField_a_of_type_Ajfg.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a);
      this.jdField_a_of_type_Ajfg.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ChatPieApolloViewController.5
 * JD-Core Version:    0.7.0.1
 */
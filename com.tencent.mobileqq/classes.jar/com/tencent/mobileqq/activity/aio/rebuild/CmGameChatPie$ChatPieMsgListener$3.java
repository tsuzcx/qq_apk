package com.tencent.mobileqq.activity.aio.rebuild;

import ahek;
import ahew;
import ahex;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class CmGameChatPie$ChatPieMsgListener$3
  implements Runnable
{
  public CmGameChatPie$ChatPieMsgListener$3(ahew paramahew, ahek paramahek, String paramString) {}
  
  public void run()
  {
    ahek.a(this.jdField_a_of_type_Ahek, this.jdField_a_of_type_JavaLangString, null, 1);
    if ((this.jdField_a_of_type_Ahek.sessionInfo != null) && (this.jdField_a_of_type_Ahek.getApp() != null)) {
      this.jdField_a_of_type_Ahek.a(this.jdField_a_of_type_Ahek.sessionInfo.curFriendUin, this.jdField_a_of_type_Ahek.getApp().getCurrentUin(), ahek.a(this.jdField_a_of_type_Ahek).jdField_a_of_type_JavaLangString, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.3
 * JD-Core Version:    0.7.0.1
 */
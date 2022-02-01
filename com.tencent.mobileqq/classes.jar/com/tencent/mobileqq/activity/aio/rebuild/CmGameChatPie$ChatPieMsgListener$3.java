package com.tencent.mobileqq.activity.aio.rebuild;

import ahzc;
import ahzo;
import ahzp;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

public class CmGameChatPie$ChatPieMsgListener$3
  implements Runnable
{
  public CmGameChatPie$ChatPieMsgListener$3(ahzo paramahzo, ahzc paramahzc, String paramString) {}
  
  public void run()
  {
    ahzc.a(this.jdField_a_of_type_Ahzc, this.jdField_a_of_type_JavaLangString, null, 1);
    if ((this.jdField_a_of_type_Ahzc.sessionInfo != null) && (this.jdField_a_of_type_Ahzc.getApp() != null)) {
      this.jdField_a_of_type_Ahzc.a(this.jdField_a_of_type_Ahzc.sessionInfo.curFriendUin, this.jdField_a_of_type_Ahzc.getApp().getCurrentUin(), ahzc.a(this.jdField_a_of_type_Ahzc).jdField_a_of_type_JavaLangString, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.CmGameChatPie.ChatPieMsgListener.3
 * JD-Core Version:    0.7.0.1
 */
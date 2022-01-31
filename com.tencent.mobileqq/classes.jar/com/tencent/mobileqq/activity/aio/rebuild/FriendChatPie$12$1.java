package com.tencent.mobileqq.activity.aio.rebuild;

import aeoo;
import aeor;
import bcpw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class FriendChatPie$12$1
  implements Runnable
{
  public FriendChatPie$12$1(aeor paramaeor, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.sendFailCode == 41)
    {
      bcpw.a(this.jdField_a_of_type_Aeor.a.a.getApp(), 2131692046, 0).a();
      return;
    }
    bcpw.a(this.jdField_a_of_type_Aeor.a.a.getApp(), 2131719772, 0).a();
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_Aeor.a.a.c(), "Stick", "Send", "1", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.12.1
 * JD-Core Version:    0.7.0.1
 */
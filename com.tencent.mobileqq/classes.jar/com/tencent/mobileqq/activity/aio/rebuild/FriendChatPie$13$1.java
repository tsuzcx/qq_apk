package com.tencent.mobileqq.activity.aio.rebuild;

import aedo;
import aeds;
import bbmy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class FriendChatPie$13$1
  implements Runnable
{
  public FriendChatPie$13$1(aeds paramaeds, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.sendFailCode == 41)
    {
      bbmy.a(this.jdField_a_of_type_Aeds.a.a.getApp(), 2131626460, 0).a();
      return;
    }
    bbmy.a(this.jdField_a_of_type_Aeds.a.a.getApp(), 2131653888, 0).a();
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_Aeds.a.a.c(), "Stick", "Send", "1", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie.13.1
 * JD-Core Version:    0.7.0.1
 */
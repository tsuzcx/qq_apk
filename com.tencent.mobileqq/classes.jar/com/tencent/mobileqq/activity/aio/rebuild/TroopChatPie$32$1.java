package com.tencent.mobileqq.activity.aio.rebuild;

import aeuo;
import bcql;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class TroopChatPie$32$1
  implements Runnable
{
  public TroopChatPie$32$1(aeuo paramaeuo, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.sendFailCode == 41)
    {
      bcql.a(this.jdField_a_of_type_Aeuo.a.a.getApp(), 2131692046, 0).a();
      return;
    }
    bcql.a(this.jdField_a_of_type_Aeuo.a.a.getApp(), 2131719783, 0).a();
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_Aeuo.a.a.c(), "Stick", "Send", "2", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.32.1
 * JD-Core Version:    0.7.0.1
 */
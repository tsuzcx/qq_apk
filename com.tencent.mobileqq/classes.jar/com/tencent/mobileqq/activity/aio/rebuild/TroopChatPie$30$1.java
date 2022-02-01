package com.tencent.mobileqq.activity.aio.rebuild;

import aiqk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;

public class TroopChatPie$30$1
  implements Runnable
{
  public TroopChatPie$30$1(aiqk paramaiqk, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.sendFailCode == 41)
    {
      QQToast.a(this.jdField_a_of_type_Aiqk.a.a.getApp(), 2131691745, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Aiqk.a.a.getApp(), 2131718351, 0).a();
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_Aiqk.a.a.c(), "Stick", "Send", "2", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.30.1
 * JD-Core Version:    0.7.0.1
 */
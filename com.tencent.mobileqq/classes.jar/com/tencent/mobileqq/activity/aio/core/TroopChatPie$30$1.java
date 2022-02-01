package com.tencent.mobileqq.activity.aio.core;

import afkg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;

public class TroopChatPie$30$1
  implements Runnable
{
  public TroopChatPie$30$1(afkg paramafkg, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.sendFailCode == 41)
    {
      QQToast.a(this.jdField_a_of_type_Afkg.a.app.getApp(), 2131691791, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Afkg.a.app.getApp(), 2131718593, 0).a();
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_Afkg.a.app.getCurrentUin(), "Stick", "Send", "2", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.30.1
 * JD-Core Version:    0.7.0.1
 */
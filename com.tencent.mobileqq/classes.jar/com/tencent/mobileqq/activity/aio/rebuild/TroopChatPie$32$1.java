package com.tencent.mobileqq.activity.aio.rebuild;

import agro;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;

public class TroopChatPie$32$1
  implements Runnable
{
  public TroopChatPie$32$1(agro paramagro, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.sendFailCode == 41)
    {
      QQToast.a(this.jdField_a_of_type_Agro.a.a.getApp(), 2131692101, 0).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_Agro.a.a.getApp(), 2131720309, 0).a();
    VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_Agro.a.a.c(), "Stick", "Send", "2", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.32.1
 * JD-Core Version:    0.7.0.1
 */
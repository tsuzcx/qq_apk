package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbyRelevantHandler;
import com.tencent.mobileqq.statistics.ReportController;

final class ChatAVHelper$4
  implements DialogInterface.OnClickListener
{
  ChatAVHelper$4(QQAppInterface paramQQAppInterface, ChatActivityUtils.VideoCheckFlag paramVideoCheckFlag, long paramLong, Context paramContext, ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    NearbyRelevantHandler localNearbyRelevantHandler = (NearbyRelevantHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.NEARBY_RELEVANT_HANDLER);
    if (localNearbyRelevantHandler != null) {
      localNearbyRelevantHandler.a((byte)0);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNearbyProxy().a(true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.a) {
      ReportController.b(null, "CliOper", "", "", "Two_call", "Clk_shield_btn", 0, 0, "1", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag.e = false;
    ChatActivityUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$StartVideoListener, this.jdField_a_of_type_ComTencentMobileqqActivityChatActivityUtils$VideoCheckFlag);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatAVHelper.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class HotChatPie$17$1
  implements DialogInterface.OnClickListener
{
  HotChatPie$17$1(HotChatPie.17 param17) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.d = new ReportDialog(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(), 2131755842);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.d.setContentView(2131558435);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.d.setCancelable(true);
    ((TextView)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.d.findViewById(2131365807)).setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a().getString(2131719050));
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.d.show();
    ((HotChatHandler)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER)).b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.a.jdField_a_of_type_JavaLangString, 1);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D55", "0X8005D55", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.17.1
 * JD-Core Version:    0.7.0.1
 */
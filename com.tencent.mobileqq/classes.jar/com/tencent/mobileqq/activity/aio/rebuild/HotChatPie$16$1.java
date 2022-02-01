package com.tencent.mobileqq.activity.aio.rebuild;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class HotChatPie$16$1
  implements DialogInterface.OnClickListener
{
  HotChatPie$16$1(HotChatPie.16 param16) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.c = new ReportDialog(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a(), 2131756189);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.c.setContentView(2131558463);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.c.setCancelable(true);
    ((TextView)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.c.findViewById(2131365644)).setText(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.a().getString(2131718766));
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.c.show();
    ((IHotChatHandler)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName())).kickHotChatMember(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, this.a.jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin, this.a.jdField_a_of_type_JavaLangString, 1);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildHotChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005D55", "0X8005D55", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.16.1
 * JD-Core Version:    0.7.0.1
 */
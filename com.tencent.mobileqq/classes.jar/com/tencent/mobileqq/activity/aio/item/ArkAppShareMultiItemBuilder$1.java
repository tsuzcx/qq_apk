package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.share.api.IArkAsyncShareMsgService;
import com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class ArkAppShareMultiItemBuilder$1
  implements DialogInterface.OnClickListener
{
  ArkAppShareMultiItemBuilder$1(ArkAppShareMultiItemBuilder paramArkAppShareMultiItemBuilder, MessageForArkApp paramMessageForArkApp) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (MessageForArkApp)MessageRecordFactory.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
    if (paramDialogInterface.msgData == null)
    {
      if (paramDialogInterface.ark_app_message == null)
      {
        ArkAppCenter.a("ArkApp", String.format("resendMessage, msgData and ark_app_message are null", new Object[0]));
        return;
      }
      paramDialogInterface.msgData = paramDialogInterface.ark_app_message.toBytes();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
    {
      if ((paramDialogInterface.ark_app_message.containStructMsg == null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.containStructMsg != null)) {
        paramDialogInterface.ark_app_message.containStructMsg = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.ark_app_message.containStructMsg;
      }
      paramInt = paramDialogInterface.getProcessState();
      if (QLog.isColorLevel()) {
        QLog.d("ArkAppShareMultiItemBuilder", 2, new Object[] { "AAShare.get multiItem resend msg stat=", Integer.valueOf(paramInt), ", old.uniseq=", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.uniseq), ", new uniseq=", Long.valueOf(paramDialogInterface.uniseq) });
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp.uniseq);
      if ((paramInt != 1002) && (paramInt != 0))
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime instanceof QQAppInterface)) {
          ((IArkAsyncShareMsgService)localAppRuntime.getRuntimeService(IArkAsyncShareMsgService.class, "")).getAsyncShareMsgManager().a(paramDialogInterface);
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppShareMultiItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramDialogInterface, null, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppShareMultiItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.recent.msgbox.api.IFilterMsgBoxHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ChatSettingActivity$11
  implements DialogInterface.OnClickListener
{
  ChatSettingActivity$11(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      ((IFilterMsgBoxHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.FILTER_MSG_BOX_HANDLER)).a(Long.parseLong(ChatSettingActivity.a(this.a)));
      return;
    }
    catch (Exception paramDialogInterface)
    {
      label32:
      break label32;
    }
    QLog.e(ChatSettingActivity.e(this.a), 1, "showFilterMsgNoticeDialog(): the uin is not Long");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.11
 * JD-Core Version:    0.7.0.1
 */
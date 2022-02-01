package com.tencent.mobileqq.activity.history;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.activity.messagesearch.C2CMessageSearchDialog;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryC2CAllFragment$7
  implements DialogInterface.OnDismissListener
{
  ChatHistoryC2CAllFragment$7(ChatHistoryC2CAllFragment paramChatHistoryC2CAllFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = (C2CMessageSearchDialog)paramDialogInterface;
    paramDialogInterface.a();
    int i = paramDialogInterface.a();
    paramDialogInterface = (MessageRoamManager)this.a.a.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDismiss, recordCount : ");
      localStringBuilder.append(i);
      localStringBuilder.append(",showRoamFlag");
      localStringBuilder.append(paramDialogInterface.e());
      QLog.i("Q.history.C2CAllFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.7
 * JD-Core Version:    0.7.0.1
 */
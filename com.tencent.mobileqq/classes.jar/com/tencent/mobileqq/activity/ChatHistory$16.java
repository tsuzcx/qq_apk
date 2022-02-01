package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import java.util.List;
import mqq.os.MqqHandler;

class ChatHistory$16
  implements DialogInterface.OnClickListener
{
  ChatHistory$16(ChatHistory paramChatHistory, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.b.app.getMessageFacade().h(this.b.e, this.b.f);
    long l1;
    if ((paramDialogInterface != null) && (!paramDialogInterface.isEmpty()))
    {
      if ((1 != this.b.f) && (3000 != this.b.f))
      {
        if (((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).isSendFromLocal()) {
          l1 = ((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).time + 2L;
        } else {
          l1 = ((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).time;
        }
      }
      else {
        l1 = ((MessageRecord)paramDialogInterface.get(paramDialogInterface.size() - 1)).shmsgseq;
      }
    }
    else {
      l1 = 0L;
    }
    ThreadManager.getSubThreadHandler().post(new ChatHistory.16.1(this));
    this.b.app.getMessageFacade().g(this.b.e, this.b.f);
    ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.b.app, "chat_history_confirm_del_msg");
    paramDialogInterface = this.a;
    if (paramDialogInterface != null)
    {
      long l2;
      try
      {
        l2 = Long.parseLong(paramDialogInterface);
      }
      catch (Exception paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
        l2 = 0L;
      }
      l1 = Math.max(l2, l1);
      if (l1 > 0L) {
        this.b.app.getMsgCache().a(this.b.e, this.b.f, l1);
      }
    }
    paramDialogInterface = this.b.app.getHandler(Conversation.class);
    Message localMessage = paramDialogInterface.obtainMessage(1017);
    localMessage.obj = this.b.e;
    localMessage.arg1 = this.b.f;
    paramDialogInterface.sendMessage(localMessage);
    this.b.aa.dismiss();
    this.b.setResult(-1);
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.16
 * JD-Core Version:    0.7.0.1
 */
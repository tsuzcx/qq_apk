package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkSender;

class StructingMsgItemBuilder$22
  implements DialogInterface.OnClickListener
{
  StructingMsgItemBuilder$22(StructingMsgItemBuilder paramStructingMsgItemBuilder, ChatMessage paramChatMessage, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    if ((paramDialogInterface instanceof MessageForStructing))
    {
      paramDialogInterface = (MessageForStructing)paramDialogInterface;
      if ((paramDialogInterface.structingMsg != null) && (paramDialogInterface.structingMsg.mMsgServiceID == 35))
      {
        MultiMsgManager.a().a(this.c.d, this.a.frienduin, this.a.istroop, "", paramDialogInterface.structingMsg, paramDialogInterface.uniseq, true, 0);
        return;
      }
      if ((paramDialogInterface.structingMsg != null) && (paramDialogInterface.structingMsg.mMsgServiceID == 107))
      {
        MultiMsgManager.a().a(this.c.d, this.a.frienduin, this.a.istroop, "", paramDialogInterface.structingMsg, paramDialogInterface.uniseq, true, 5);
        return;
      }
      if ((paramDialogInterface.structingMsg != null) && (paramDialogInterface.structingMsg.mMsgServiceID == 95) && (new TeamWorkSender(this.c.d).a(paramDialogInterface, this.c.f))) {
        return;
      }
    }
    ChatActivityFacade.a(this.c.d, this.b, this.c.f, this.a.frienduin, this.a.istroop, this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.22
 * JD-Core Version:    0.7.0.1
 */
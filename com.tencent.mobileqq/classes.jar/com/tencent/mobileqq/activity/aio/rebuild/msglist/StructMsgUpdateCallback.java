package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;

public class StructMsgUpdateCallback
  implements IMsgUpdateCallback
{
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public boolean d(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void e(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForStructing)) && ((paramChatMessage.istroop == 1) || (paramChatMessage.istroop == 3000) || (paramChatMessage.istroop == 0)) && ("viewMultiMsg".equals(((MessageForStructing)paramChatMessage).structingMsg.mMsgAction))) {
      MultiMsgManager.a().a(paramAIOContext.a(), paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.StructMsgUpdateCallback
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

public class ArkMsgUpdateCallback
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
    boolean bool;
    if (((paramChatMessage instanceof MessageForArkApp)) && (((MessageForArkApp)paramChatMessage).getProcessState() == 1002)) {
      bool = false;
    } else {
      bool = true;
    }
    paramChatMessage.mMsgAnimFlag = bool;
    return false;
  }
  
  public void e(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.ArkMsgUpdateCallback
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild.msglist;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;

public class TroopGiftMsgUpdateCallback
  implements IMsgUpdateCallback
{
  public void a(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return AIOAnimationControlManager.a((BaseChatPie)paramAIOContext.a(), paramAIOContext.a(), paramChatMessage);
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public boolean b(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.msglist.TroopGiftMsgUpdateCallback
 * JD-Core Version:    0.7.0.1
 */
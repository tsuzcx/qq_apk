package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public abstract interface OnTroopChatMsgChangedCallback
{
  public abstract void a(int paramInt, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.OnTroopChatMsgChangedCallback
 * JD-Core Version:    0.7.0.1
 */
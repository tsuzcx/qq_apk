package com.tencent.mobileqq.activity.aio.core.input;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import java.util.ArrayList;

public abstract interface ISendMessageCallback
{
  public abstract void afterMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam);
  
  public abstract boolean beforeMessageSend(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam);
  
  public abstract boolean onMessageSending(AIOContext paramAIOContext, SendLogicParam paramSendLogicParam, ArrayList<AtTroopMemberInfo> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.input.ISendMessageCallback
 * JD-Core Version:    0.7.0.1
 */
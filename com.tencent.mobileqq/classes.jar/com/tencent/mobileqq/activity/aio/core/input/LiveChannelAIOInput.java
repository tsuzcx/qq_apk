package com.tencent.mobileqq.activity.aio.core.input;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import com.tencent.mobileqq.activity.aio.rebuild.input.LiveChannelInputCallbackRegister;

public class LiveChannelAIOInput
  extends AIOInput
{
  public LiveChannelAIOInput(AIOContext paramAIOContext, BaseMessageSender paramBaseMessageSender)
  {
    super(paramAIOContext, paramBaseMessageSender);
  }
  
  protected InputCallbackRegister a(AIOContext paramAIOContext)
  {
    return new LiveChannelInputCallbackRegister(paramAIOContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.input.LiveChannelAIOInput
 * JD-Core Version:    0.7.0.1
 */
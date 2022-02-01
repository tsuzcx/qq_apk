package com.tencent.mobileqq.activity.aio.core.input;

import com.tencent.mobileqq.activity.aio.core.AIOContext;

public class AIOInputBuilder
{
  protected AIOContext a;
  protected BaseMessageSender b;
  
  public AIOInput a()
  {
    return new AIOInput(this.a, this.b);
  }
  
  public AIOInputBuilder a(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
    return this;
  }
  
  public AIOInputBuilder a(BaseMessageSender paramBaseMessageSender)
  {
    this.b = paramBaseMessageSender;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.input.AIOInputBuilder
 * JD-Core Version:    0.7.0.1
 */
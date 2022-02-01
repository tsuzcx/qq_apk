package com.tencent.mobileqq.activity.aio.core.input;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;

public class AIOInput
{
  private InputUIContainer a;
  private final BaseMessageSender b;
  private final MessageSignal c;
  private final InputCallbackRegister d;
  private final AIOContext e;
  
  public AIOInput(AIOContext paramAIOContext, BaseMessageSender paramBaseMessageSender)
  {
    this.e = paramAIOContext;
    this.d = a(paramAIOContext);
    this.c = new MessageSignal(paramAIOContext);
    this.b = paramBaseMessageSender;
  }
  
  public BaseMessageSender a()
  {
    return this.b;
  }
  
  protected InputCallbackRegister a(AIOContext paramAIOContext)
  {
    return new InputCallbackRegister(paramAIOContext);
  }
  
  public final void a(InputUIContainer paramInputUIContainer)
  {
    this.a = paramInputUIContainer;
  }
  
  public MessageSignal b()
  {
    return this.c;
  }
  
  public InputCallbackRegister c()
  {
    return this.d;
  }
  
  public InputUIContainer d()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.input.AIOInput
 * JD-Core Version:    0.7.0.1
 */
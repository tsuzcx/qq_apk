package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.IMsgSendListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;

public class TroopMessageSender
  extends BaseTroopMessageSender
{
  public TroopMessageSender(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void b()
  {
    if (this.a.a().a().a(4).a(this.a)) {
      return;
    }
    IMsgSendListener localIMsgSendListener = this.a.a().a().a(3);
    if (localIMsgSendListener.a(this.a)) {
      return;
    }
    if (this.a.a().a().a(5).a(this.a)) {
      return;
    }
    super.b();
    localIMsgSendListener.a(this.a);
  }
  
  public void c()
  {
    IMsgSendListener localIMsgSendListener = this.a.a().a().a(6);
    if (localIMsgSendListener.a(this.a)) {
      return;
    }
    super.c();
    localIMsgSendListener.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopMessageSender
 * JD-Core Version:    0.7.0.1
 */
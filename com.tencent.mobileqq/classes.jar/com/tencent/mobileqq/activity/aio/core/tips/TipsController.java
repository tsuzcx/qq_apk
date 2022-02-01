package com.tencent.mobileqq.activity.aio.core.tips;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.tips.MsgBox;
import com.tencent.mobileqq.activity.aio.coreui.tips.TipsUI;
import com.tencent.mobileqq.activity.aio.rebuild.tips.TipsRegister;
import com.tencent.mobileqq.data.MessageRecord;

public class TipsController
{
  protected final AIOContext a;
  private final TipsRegister b;
  private final MsgBox c;
  private final TipsUI d;
  private MessageTips e;
  private boolean f;
  
  public TipsController(AIOContext paramAIOContext)
  {
    this.a = paramAIOContext;
    this.b = new TipsRegister(paramAIOContext);
    this.c = new MsgBox(paramAIOContext, b());
    this.d = new TipsUI(paramAIOContext);
  }
  
  public TipsRegister a()
  {
    return this.b;
  }
  
  public void a(MessageRecord paramMessageRecord, Message paramMessage)
  {
    if (this.f) {
      return;
    }
    this.c.a(this.a, paramMessageRecord, paramMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public MessageTips b()
  {
    if (this.e == null) {
      this.e = new MessageTips(this.a, this);
    }
    return this.e;
  }
  
  public MsgBox c()
  {
    return this.c;
  }
  
  public TipsUI d()
  {
    return this.d;
  }
  
  public void e()
  {
    this.c.b();
  }
  
  public void f()
  {
    this.c.a(this.a.b());
    this.d.a();
  }
  
  public void g()
  {
    this.c.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.tips.TipsController
 * JD-Core Version:    0.7.0.1
 */
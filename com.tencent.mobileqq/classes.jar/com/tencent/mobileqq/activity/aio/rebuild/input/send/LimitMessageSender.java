package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender;
import com.tencent.mobileqq.activity.aio.rebuild.LimitContext;

public class LimitMessageSender
  extends BaseMessageSender
{
  public LimitMessageSender(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void c()
  {
    ((LimitContext)this.a).a("1");
    super.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.LimitMessageSender
 * JD-Core Version:    0.7.0.1
 */
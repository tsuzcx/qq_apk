package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender;
import com.tencent.mobileqq.activity.aio.helper.AIODraftHelper;

public class BaseTroopMessageSender
  extends BaseMessageSender
{
  public BaseTroopMessageSender(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void c()
  {
    super.c();
    ((AIODraftHelper)this.a.a(111)).a = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.BaseTroopMessageSender
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.IMsgSendListener;
import com.tencent.mobileqq.activity.aio.helper.ArkHelper;

public class ArkMsgSendListener
  implements IMsgSendListener
{
  public void a(AIOContext paramAIOContext)
  {
    ((ArkHelper)paramAIOContext.a(110)).b();
  }
  
  public boolean a(AIOContext paramAIOContext)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.ArkMsgSendListener
 * JD-Core Version:    0.7.0.1
 */
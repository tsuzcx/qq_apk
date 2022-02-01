package com.tencent.mobileqq.activity.aio.rebuild.input.send;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.TroopAIOContext;
import com.tencent.mobileqq.activity.aio.core.input.IMsgSendListener;

public class TroopGagMsgSendListener
  implements IMsgSendListener
{
  public boolean a(AIOContext paramAIOContext)
  {
    return ((TroopAIOContext)paramAIOContext).d(true);
  }
  
  public void b(AIOContext paramAIOContext) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.send.TroopGagMsgSendListener
 * JD-Core Version:    0.7.0.1
 */
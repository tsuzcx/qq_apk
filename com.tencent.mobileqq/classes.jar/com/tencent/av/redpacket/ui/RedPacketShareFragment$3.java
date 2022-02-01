package com.tencent.av.redpacket.ui;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class RedPacketShareFragment$3
  implements Runnable
{
  RedPacketShareFragment$3(RedPacketShareFragment paramRedPacketShareFragment, int paramInt) {}
  
  public void run()
  {
    String str = RedPacketShareFragment.a(this.this$0);
    ThreadManager.getUIHandler().post(new RedPacketShareFragment.3.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.redpacket.ui;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class RedPacketShareFragment$2
  implements Runnable
{
  RedPacketShareFragment$2(RedPacketShareFragment paramRedPacketShareFragment) {}
  
  public void run()
  {
    String str = RedPacketShareFragment.a(this.this$0);
    ThreadManager.getUIHandler().post(new RedPacketShareFragment.2.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.2
 * JD-Core Version:    0.7.0.1
 */
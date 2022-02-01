package com.tencent.av.redpacket.ui;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class RedPacketShareFragment$1
  implements Runnable
{
  RedPacketShareFragment$1(RedPacketShareFragment paramRedPacketShareFragment) {}
  
  public void run()
  {
    String str = RedPacketShareFragment.a(this.this$0);
    ThreadManager.getUIHandler().post(new RedPacketShareFragment.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.1
 * JD-Core Version:    0.7.0.1
 */
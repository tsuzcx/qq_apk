package com.tencent.av.redpacket;

import ljm;
import ljp;

public class AVRedPacketManager$2
  implements Runnable
{
  AVRedPacketManager$2(AVRedPacketManager paramAVRedPacketManager) {}
  
  public void run()
  {
    AVRedPacketManager.a(this.this$0, this.this$0.g);
    long l = System.currentTimeMillis();
    this.this$0.a.a(new ljm(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketManager.2
 * JD-Core Version:    0.7.0.1
 */
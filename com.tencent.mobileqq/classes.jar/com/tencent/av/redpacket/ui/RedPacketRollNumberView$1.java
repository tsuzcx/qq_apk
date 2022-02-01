package com.tencent.av.redpacket.ui;

import android.view.View;

class RedPacketRollNumberView$1
  implements Runnable
{
  RedPacketRollNumberView$1(RedPacketRollNumberView paramRedPacketRollNumberView) {}
  
  public void run()
  {
    RedPacketRollNumberView.a(this.this$0, this.this$0.getChildCount());
    int i = 0;
    while (i < RedPacketRollNumberView.a(this.this$0))
    {
      View localView = this.this$0.getChildAt(i);
      if ((localView != null) && ((localView instanceof RedPacketRollTextView))) {
        ((RedPacketRollTextView)localView).b();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketRollNumberView.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.redpacket.ui;

import android.os.Bundle;
import android.os.Message;
import lvw;
import lvx;

class RedPacketRollTextView$ContentSupplyThread
  implements Runnable
{
  RedPacketRollTextView$ContentSupplyThread(RedPacketRollTextView paramRedPacketRollTextView) {}
  
  public void run()
  {
    while ((RedPacketRollTextView.b(this.this$0) != RedPacketRollTextView.c(this.this$0)) && (this.this$0.a)) {
      try
      {
        if (RedPacketRollTextView.b(this.this$0) != RedPacketRollTextView.c(this.this$0)) {
          RedPacketRollTextView.a(this.this$0, (RedPacketRollTextView.b(this.this$0) + 1) % 10);
        }
        int i = RedPacketRollTextView.b(this.this$0);
        Message localMessage = RedPacketRollTextView.a(this.this$0).obtainMessage();
        localMessage.what = 1;
        Bundle localBundle = new Bundle();
        localBundle.putString("content", Integer.toString(i % 10));
        localMessage.setData(localBundle);
        RedPacketRollTextView.a(this.this$0).sendMessage(localMessage);
        Thread.sleep(RedPacketRollTextView.d(this.this$0));
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
    if (RedPacketRollTextView.a(this.this$0) != null) {
      RedPacketRollTextView.a(this.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketRollTextView.ContentSupplyThread
 * JD-Core Version:    0.7.0.1
 */
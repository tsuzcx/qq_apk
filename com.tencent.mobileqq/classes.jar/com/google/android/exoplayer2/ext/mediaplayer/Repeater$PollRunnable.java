package com.google.android.exoplayer2.ext.mediaplayer;

import android.os.Handler;

class Repeater$PollRunnable
  implements Runnable
{
  private Repeater$PollRunnable(Repeater paramRepeater) {}
  
  void performPoll()
  {
    Repeater.access$500(this.this$0).postDelayed(Repeater.access$300(this.this$0), Repeater.access$400(this.this$0));
  }
  
  public void run()
  {
    if (Repeater.access$100(this.this$0) != null) {
      Repeater.access$100(this.this$0).onUpdate();
    }
    if (Repeater.access$200(this.this$0)) {
      performPoll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.Repeater.PollRunnable
 * JD-Core Version:    0.7.0.1
 */
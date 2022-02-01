package com.dataline.util.widget;

import android.os.Handler;
import fi;

class WaitTextView$1
  implements Runnable
{
  WaitTextView$1(WaitTextView paramWaitTextView) {}
  
  public void run()
  {
    WaitTextView.a(this.this$0);
    if (WaitTextView.a(this.this$0) != null) {
      WaitTextView.a(this.this$0).a();
    }
    WaitTextView.a(this.this$0).postDelayed(this, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.dataline.util.widget.WaitTextView.1
 * JD-Core Version:    0.7.0.1
 */
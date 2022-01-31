package com.tencent.mobileqq.activity.qwallet.widget;

import android.os.Bundle;
import android.os.Message;

class RollTextView$ContentSupplyThread
  implements Runnable
{
  RollTextView$ContentSupplyThread(RollTextView paramRollTextView) {}
  
  public void run()
  {
    if (RollTextView.access$400(this.this$0)) {}
    try
    {
      Thread.sleep(RollTextView.access$500(this.this$0) * 170);
      for (;;)
      {
        if ((RollTextView.access$600(this.this$0) == RollTextView.access$700(this.this$0)) || (!this.this$0.mAcitive)) {
          break label175;
        }
        try
        {
          int i = RollTextView.access$600(this.this$0);
          Message localMessage1 = RollTextView.access$800(this.this$0).obtainMessage();
          localMessage1.what = 1;
          localBundle = new Bundle();
          localBundle.putString("content", Integer.toString(i % 10));
          localMessage1.setData(localBundle);
          RollTextView.access$800(this.this$0).sendMessage(localMessage1);
          Thread.sleep(170L);
          if (RollTextView.access$600(this.this$0) <= RollTextView.access$700(this.this$0)) {
            break;
          }
          RollTextView.access$610(this.this$0);
        }
        catch (InterruptedException localInterruptedException1)
        {
          localInterruptedException1.printStackTrace();
        }
      }
    }
    catch (InterruptedException localInterruptedException2)
    {
      Bundle localBundle;
      for (;;)
      {
        localInterruptedException2.printStackTrace();
        continue;
        RollTextView.access$608(this.this$0);
      }
      label175:
      if (RollTextView.access$600(this.this$0) == RollTextView.access$700(this.this$0))
      {
        Message localMessage2 = RollTextView.access$800(this.this$0).obtainMessage();
        localMessage2.what = 1;
        localBundle = new Bundle();
        localBundle.putString("content", Integer.toString(RollTextView.access$600(this.this$0) % 10));
        localMessage2.setData(localBundle);
        RollTextView.access$800(this.this$0).sendMessage(localMessage2);
      }
      if (RollTextView.access$000(this.this$0) != null) {
        RollTextView.access$000(this.this$0).onRollTextComplete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.RollTextView.ContentSupplyThread
 * JD-Core Version:    0.7.0.1
 */
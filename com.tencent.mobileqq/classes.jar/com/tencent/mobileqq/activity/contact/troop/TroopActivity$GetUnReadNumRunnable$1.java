package com.tencent.mobileqq.activity.contact.troop;

import android.widget.ImageView;
import android.widget.TextView;

class TroopActivity$GetUnReadNumRunnable$1
  implements Runnable
{
  TroopActivity$GetUnReadNumRunnable$1(TroopActivity.GetUnReadNumRunnable paramGetUnReadNumRunnable, int paramInt) {}
  
  public void run()
  {
    if (TroopActivity.GetUnReadNumRunnable.a(this.this$0))
    {
      TroopActivity.GetUnReadNumRunnable.a(this.this$0).setVisibility(0);
      TroopActivity.GetUnReadNumRunnable.a(this.this$0).setVisibility(0);
      TroopActivity.GetUnReadNumRunnable.a(this.this$0).setText("" + this.a);
      if (this.a <= 0) {
        TroopActivity.GetUnReadNumRunnable.a(this.this$0).setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.GetUnReadNumRunnable.1
 * JD-Core Version:    0.7.0.1
 */
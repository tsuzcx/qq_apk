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
      TroopActivity.GetUnReadNumRunnable.b(this.this$0).setVisibility(0);
      TroopActivity.GetUnReadNumRunnable.c(this.this$0).setVisibility(0);
      TextView localTextView = TroopActivity.GetUnReadNumRunnable.b(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a);
      localTextView.setText(localStringBuilder.toString());
      if (this.a <= 0) {
        TroopActivity.GetUnReadNumRunnable.b(this.this$0).setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.GetUnReadNumRunnable.1
 * JD-Core Version:    0.7.0.1
 */
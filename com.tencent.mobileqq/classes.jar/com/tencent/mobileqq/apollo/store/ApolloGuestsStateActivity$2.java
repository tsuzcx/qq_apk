package com.tencent.mobileqq.apollo.store;

import android.widget.TextView;

class ApolloGuestsStateActivity$2
  implements Runnable
{
  ApolloGuestsStateActivity$2(ApolloGuestsStateActivity paramApolloGuestsStateActivity, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.mPraiseNumberText != null)
    {
      this.this$0.mPraiseNumberText.setText(String.valueOf(this.a));
      this.this$0.praiseNumber = this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity.2
 * JD-Core Version:    0.7.0.1
 */
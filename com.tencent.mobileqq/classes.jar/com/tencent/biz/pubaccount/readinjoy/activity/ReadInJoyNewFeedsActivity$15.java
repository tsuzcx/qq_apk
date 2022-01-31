package com.tencent.biz.pubaccount.readinjoy.activity;

import android.widget.TextView;

class ReadInJoyNewFeedsActivity$15
  implements Runnable
{
  ReadInJoyNewFeedsActivity$15(ReadInJoyNewFeedsActivity paramReadInJoyNewFeedsActivity, int paramInt) {}
  
  public void run()
  {
    if (this.a <= 0)
    {
      this.this$0.a.setText(2131654133);
      return;
    }
    if (this.a > 99)
    {
      this.this$0.a.setText(String.format("%s(%d+)", new Object[] { this.this$0.getString(2131654133), Integer.valueOf(99) }));
      return;
    }
    this.this$0.a.setText(String.format("%s(%d)", new Object[] { this.this$0.getString(2131654133), Integer.valueOf(this.a) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.15
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.activity;

import android.widget.TextView;

class ReadInJoyFeedsActivity$4
  implements Runnable
{
  ReadInJoyFeedsActivity$4(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity, int paramInt) {}
  
  public void run()
  {
    if (this.a <= 0)
    {
      this.this$0.a.setText(2131718523);
      return;
    }
    if (this.a > 99)
    {
      this.this$0.a.setText(String.format("%s(%d+)", new Object[] { this.this$0.getString(2131718523), Integer.valueOf(99) }));
      return;
    }
    this.this$0.a.setText(String.format("%s(%d)", new Object[] { this.this$0.getString(2131718523), Integer.valueOf(this.a) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity.4
 * JD-Core Version:    0.7.0.1
 */
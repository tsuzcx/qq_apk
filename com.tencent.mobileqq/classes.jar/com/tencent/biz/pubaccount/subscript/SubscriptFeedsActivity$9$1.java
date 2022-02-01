package com.tencent.biz.pubaccount.subscript;

import android.widget.TextView;

class SubscriptFeedsActivity$9$1
  implements Runnable
{
  SubscriptFeedsActivity$9$1(SubscriptFeedsActivity.9 param9, int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    if (i <= 0)
    {
      this.b.this$0.leftView.setText(2131917002);
      return;
    }
    if (i > 99)
    {
      this.b.this$0.leftView.setText(String.format("%s(%d+)", new Object[] { this.b.this$0.getString(2131917002), Integer.valueOf(99) }));
      return;
    }
    this.b.this$0.leftView.setText(String.format("%s(%d)", new Object[] { this.b.this$0.getString(2131917002), Integer.valueOf(this.a) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.9.1
 * JD-Core Version:    0.7.0.1
 */
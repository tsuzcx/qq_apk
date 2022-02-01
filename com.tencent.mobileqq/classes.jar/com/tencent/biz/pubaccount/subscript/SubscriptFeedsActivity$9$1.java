package com.tencent.biz.pubaccount.subscript;

import android.widget.TextView;

class SubscriptFeedsActivity$9$1
  implements Runnable
{
  SubscriptFeedsActivity$9$1(SubscriptFeedsActivity.9 param9, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int <= 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity$9.this$0.leftView.setText(2131719718);
      return;
    }
    if (this.jdField_a_of_type_Int > 99)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity$9.this$0.leftView.setText(String.format("%s(%d+)", new Object[] { this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity$9.this$0.getString(2131719718), Integer.valueOf(99) }));
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity$9.this$0.leftView.setText(String.format("%s(%d)", new Object[] { this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity$9.this$0.getString(2131719718), Integer.valueOf(this.jdField_a_of_type_Int) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.9.1
 * JD-Core Version:    0.7.0.1
 */
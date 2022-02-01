package com.tencent.biz.pubaccount.readinjoy.view;

import agej;
import android.app.Activity;
import android.os.Handler;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import sel;

class ReadInJoyBaseAdapter$39$1
  implements Runnable
{
  ReadInJoyBaseAdapter$39$1(ReadInJoyBaseAdapter.39 param39, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseAdapter", 2, "scroll " + this.jdField_a_of_type_Int + " to top");
    }
    View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$39.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(this.jdField_a_of_type_Int - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$39.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition());
    if (localView != null)
    {
      sel.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$39.this$0).removeMessages(1001);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$39.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.smoothScrollBy(localView.getBottom() - agej.a(175.0F, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$39.this$0.jdField_a_of_type_AndroidAppActivity.getResources()), 800);
      sel.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$39.this$0, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.39.1
 * JD-Core Version:    0.7.0.1
 */
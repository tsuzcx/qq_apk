package com.tencent.biz.pubaccount.readinjoy.view;

import aciy;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import qhp;
import qht;
import qoe;

public class ReadInJoyBaseAdapter$27
  implements Runnable
{
  public ReadInJoyBaseAdapter$27(qoe paramqoe, qht paramqht1, qht paramqht2) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount() + this.a.a + 1;
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "setSelectionFromTop selectIndex:" + i);
    }
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(i, aciy.a(175.0F, this.this$0.jdField_a_of_type_AndroidAppActivity.getResources()));
    if (this.this$0.jdField_a_of_type_Qhp.a() == 7)
    {
      this.this$0.a(this.b);
      return;
    }
    this.this$0.jdField_a_of_type_Omw = null;
    this.this$0.a(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.27
 * JD-Core Version:    0.7.0.1
 */
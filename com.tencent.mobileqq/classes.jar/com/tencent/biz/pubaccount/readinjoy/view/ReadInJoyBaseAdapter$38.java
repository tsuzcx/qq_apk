package com.tencent.biz.pubaccount.readinjoy.view;

import agej;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import rvy;
import rwc;
import sel;

public class ReadInJoyBaseAdapter$38
  implements Runnable
{
  public ReadInJoyBaseAdapter$38(sel paramsel, rwc paramrwc1, rwc paramrwc2) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount() + this.a.a + 1;
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "setSelectionFromTop selectIndex:" + i);
    }
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(i, agej.a(175.0F, this.this$0.jdField_a_of_type_AndroidAppActivity.getResources()));
    if (this.this$0.jdField_a_of_type_Rvy.a() == 7)
    {
      this.this$0.a(this.b);
      return;
    }
    this.this$0.jdField_a_of_type_Pmw = null;
    this.this$0.a(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.38
 * JD-Core Version:    0.7.0.1
 */
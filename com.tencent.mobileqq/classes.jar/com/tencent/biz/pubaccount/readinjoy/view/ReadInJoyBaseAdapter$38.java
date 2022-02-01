package com.tencent.biz.pubaccount.readinjoy.view;

import afur;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import seu;
import sey;
import snh;

public class ReadInJoyBaseAdapter$38
  implements Runnable
{
  public ReadInJoyBaseAdapter$38(snh paramsnh, sey paramsey1, sey paramsey2) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount() + this.a.a + 1;
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyBaseAdapter", 2, "setSelectionFromTop selectIndex:" + i);
    }
    this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(i, afur.a(175.0F, this.this$0.jdField_a_of_type_AndroidAppActivity.getResources()));
    if (this.this$0.jdField_a_of_type_Seu.a() == 7)
    {
      this.this$0.a(this.b);
      return;
    }
    this.this$0.jdField_a_of_type_Puj = null;
    this.this$0.a(this.b, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.38
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import bmqa;
import com.tencent.mobileqq.widget.QQToast;
import pha;
import puj;
import rvr;
import sey;
import snh;

public class ReadInJoyBaseAdapter$39
  implements Runnable
{
  public ReadInJoyBaseAdapter$39(snh paramsnh, sey paramsey) {}
  
  public void run()
  {
    if (!snh.d(this.this$0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.this$0.jdField_a_of_type_Puj == null) || (this.this$0.jdField_a_of_type_Puj.a() == null) || (this.a == null));
        this.a.d = 0L;
      } while ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) || (!snh.a(this.this$0).a()));
      int i = this.a.a;
      int j = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyBaseAdapter.39.1(this, i + j));
    } while (!bmqa.a(pha.a()));
    QQToast.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), "为你开启wifi下连续播放功能", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.39
 * JD-Core Version:    0.7.0.1
 */
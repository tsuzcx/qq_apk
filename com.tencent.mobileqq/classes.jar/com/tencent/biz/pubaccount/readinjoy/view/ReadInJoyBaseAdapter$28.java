package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import bjxj;
import com.tencent.mobileqq.widget.QQToast;
import ors;
import pdn;
import qzy;
import rjk;
import rqj;

public class ReadInJoyBaseAdapter$28
  implements Runnable
{
  public ReadInJoyBaseAdapter$28(rqj paramrqj, rjk paramrjk) {}
  
  public void run()
  {
    if (!rqj.d(this.this$0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.this$0.jdField_a_of_type_Pdn == null) || (this.this$0.jdField_a_of_type_Pdn.a() == null) || (this.a == null));
        this.a.d = 0L;
      } while ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) || (!rqj.a(this.this$0).a()));
      int i = this.a.a;
      int j = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyBaseAdapter.28.1(this, i + j));
    } while (!bjxj.a(ors.a()));
    QQToast.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), "为你开启wifi下连续播放功能", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.28
 * JD-Core Version:    0.7.0.1
 */
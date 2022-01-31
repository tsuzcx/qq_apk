package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import bbmy;
import bgmq;
import obz;
import omw;
import pyu;
import qht;
import qoe;

public class ReadInJoyBaseAdapter$28
  implements Runnable
{
  public ReadInJoyBaseAdapter$28(qoe paramqoe, qht paramqht) {}
  
  public void run()
  {
    if (!qoe.d(this.this$0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.this$0.jdField_a_of_type_Omw == null) || (this.this$0.jdField_a_of_type_Omw.a() == null) || (this.a == null));
        this.a.d = 0L;
      } while ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) || (!qoe.a(this.this$0).a()));
      int i = this.a.a;
      int j = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyBaseAdapter.28.1(this, i + j));
    } while (!bgmq.a(obz.a()));
    bbmy.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), "为你开启wifi下连续播放功能", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.28
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import bcpw;
import bhvh;
import onk;
import oyl;
import qku;
import qty;
import rap;

public class ReadInJoyBaseAdapter$28
  implements Runnable
{
  public ReadInJoyBaseAdapter$28(rap paramrap, qty paramqty) {}
  
  public void run()
  {
    if (!rap.d(this.this$0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.this$0.jdField_a_of_type_Oyl == null) || (this.this$0.jdField_a_of_type_Oyl.a() == null) || (this.a == null));
        this.a.d = 0L;
      } while ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) || (!rap.a(this.this$0).a()));
      int i = this.a.a;
      int j = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyBaseAdapter.28.1(this, i + j));
    } while (!bhvh.a(onk.a()));
    bcpw.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), "为你开启wifi下连续播放功能", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.28
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import bcql;
import bhvy;
import onh;
import oyi;
import qkr;
import qtv;
import ram;

public class ReadInJoyBaseAdapter$28
  implements Runnable
{
  public ReadInJoyBaseAdapter$28(ram paramram, qtv paramqtv) {}
  
  public void run()
  {
    if (!ram.d(this.this$0)) {}
    do
    {
      do
      {
        do
        {
          return;
        } while ((this.this$0.jdField_a_of_type_Oyi == null) || (this.this$0.jdField_a_of_type_Oyi.a() == null) || (this.a == null));
        this.a.d = 0L;
      } while ((this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) || (!ram.a(this.this$0).a()));
      int i = this.a.a;
      int j = this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      this.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyBaseAdapter.28.1(this, i + j));
    } while (!bhvy.a(onh.a()));
    bcql.a(this.this$0.jdField_a_of_type_AndroidAppActivity.getApplicationContext(), "为你开启wifi下连续播放功能", 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.28
 * JD-Core Version:    0.7.0.1
 */
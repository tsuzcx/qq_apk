package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyDeliverVideoActivity$8
  implements View.OnClickListener
{
  ReadInJoyDeliverVideoActivity$8(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyDeliverVideoActivity.b(this.a, true);
    ReadInJoyDeliverVideoActivity.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.8
 * JD-Core Version:    0.7.0.1
 */
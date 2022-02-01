package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class ReadInJoyDeliverVideoActivity$7
  implements View.OnClickListener
{
  ReadInJoyDeliverVideoActivity$7(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyDeliverVideoActivity.a(this.a).sendEmptyMessage(103);
    ReadInJoyDeliverVideoActivity.c(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity.7
 * JD-Core Version:    0.7.0.1
 */
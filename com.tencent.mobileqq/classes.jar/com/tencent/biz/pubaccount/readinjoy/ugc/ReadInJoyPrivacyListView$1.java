package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyPrivacyListView$1
  implements View.OnClickListener
{
  ReadInJoyPrivacyListView$1(ReadInJoyPrivacyListView paramReadInJoyPrivacyListView) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyPrivacyListView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListView.1
 * JD-Core Version:    0.7.0.1
 */
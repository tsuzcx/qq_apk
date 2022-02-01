package com.tencent.biz.pubaccount.readinjoy.proteus.view.helper;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyOverScrollListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ProteusItemHelper$1
  implements View.OnClickListener
{
  ProteusItemHelper$1(ProteusItemHelper paramProteusItemHelper) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyDailyOverScrollListener.a((Activity)ProteusItemHelper.a(this.a).getContext());
    ReadInJoyDailyOverScrollListener.a(2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.ProteusItemHelper.1
 * JD-Core Version:    0.7.0.1
 */
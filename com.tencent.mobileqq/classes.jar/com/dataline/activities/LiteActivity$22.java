package com.dataline.activities;

import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.ItemHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LiteActivity$22
  implements View.OnClickListener
{
  LiteActivity$22(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    ItemHolder localItemHolder = (ItemHolder)((ItemHolder)paramView.getTag()).clone();
    this.a.a(localItemHolder);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.22
 * JD-Core Version:    0.7.0.1
 */
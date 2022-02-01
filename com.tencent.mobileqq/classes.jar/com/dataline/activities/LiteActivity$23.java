package com.dataline.activities;

import android.view.View;
import android.view.View.OnClickListener;
import com.dataline.util.ItemHolder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LiteActivity$23
  implements View.OnClickListener
{
  LiteActivity$23(LiteActivity paramLiteActivity) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    ItemHolder localItemHolder = (ItemHolder)paramView.getTag();
    this.a.b(localItemHolder);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.23
 * JD-Core Version:    0.7.0.1
 */
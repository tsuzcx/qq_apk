package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MedalNewsItemBuilder$1
  implements View.OnClickListener
{
  MedalNewsItemBuilder$1(MedalNewsItemBuilder paramMedalNewsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    MedalNewsItemBuilder.a(this.a, true, this.a.a.getCurrentAccountUin());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MedalNewsItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */
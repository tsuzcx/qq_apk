package com.tencent.mobileqq.activity.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Conversation$UICallBack$7
  implements View.OnClickListener
{
  Conversation$UICallBack$7(Conversation.UICallBack paramUICallBack) {}
  
  public void onClick(View paramView)
  {
    this.a.a.onClick(this.a.a.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack.7
 * JD-Core Version:    0.7.0.1
 */
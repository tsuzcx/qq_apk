package com.tencent.mobileqq.activity.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Conversation$UICallBack$8
  implements View.OnClickListener
{
  Conversation$UICallBack$8(Conversation.UICallBack paramUICallBack) {}
  
  public void onClick(View paramView)
  {
    this.a.a.Y.ae.performLongClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.UICallBack.8
 * JD-Core Version:    0.7.0.1
 */
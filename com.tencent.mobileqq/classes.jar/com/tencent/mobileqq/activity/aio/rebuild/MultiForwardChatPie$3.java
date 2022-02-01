package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiForwardChatPie$3
  implements View.OnClickListener
{
  MultiForwardChatPie$3(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  public void onClick(View paramView)
  {
    MultiForwardChatPie.a(this.a, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.api.aio.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CmGameChatPie$18
  implements View.OnClickListener
{
  CmGameChatPie$18(CmGameChatPie paramCmGameChatPie) {}
  
  public void onClick(View paramView)
  {
    this.a.v(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.18
 * JD-Core Version:    0.7.0.1
 */
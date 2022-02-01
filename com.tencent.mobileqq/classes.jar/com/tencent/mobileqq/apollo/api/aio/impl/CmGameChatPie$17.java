package com.tencent.mobileqq.apollo.api.aio.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CmGameChatPie$17
  implements View.OnClickListener
{
  CmGameChatPie$17(CmGameChatPie paramCmGameChatPie) {}
  
  public void onClick(View paramView)
  {
    this.a.w(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.17
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class UpComingMsgChatPie$2
  implements View.OnClickListener
{
  UpComingMsgChatPie$2(UpComingMsgChatPie paramUpComingMsgChatPie) {}
  
  public void onClick(View paramView)
  {
    UpComingMsgChatPie.a(this.a, paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.UpComingMsgChatPie.2
 * JD-Core Version:    0.7.0.1
 */
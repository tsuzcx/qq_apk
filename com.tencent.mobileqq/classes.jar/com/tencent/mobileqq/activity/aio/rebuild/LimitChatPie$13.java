package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LimitChatPie$13
  implements View.OnClickListener
{
  LimitChatPie$13(LimitChatPie paramLimitChatPie) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.I) {
      LimitChatPie.d(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.13
 * JD-Core Version:    0.7.0.1
 */
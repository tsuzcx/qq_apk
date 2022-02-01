package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LimitChatPie$23
  implements View.OnClickListener
{
  LimitChatPie$23(LimitChatPie paramLimitChatPie) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.bD()) && (LimitChatPie.e(this.a) != 5))
    {
      LimitChatPie.f(this.a);
    }
    else
    {
      com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
      LimitChatPie.g(this.a);
      PlusPanelUtils.a(this.a.d, this.a.f, this.a.ah, true, null, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.23
 * JD-Core Version:    0.7.0.1
 */
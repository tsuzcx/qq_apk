package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LimitChatPie$28
  implements View.OnClickListener
{
  LimitChatPie$28(LimitChatPie paramLimitChatPie) {}
  
  public void onClick(View paramView)
  {
    this.a.aX().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.28
 * JD-Core Version:    0.7.0.1
 */
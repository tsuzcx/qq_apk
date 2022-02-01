package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseChatPie$28
  implements View.OnClickListener
{
  BaseChatPie$28(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    MultiMsgManager.a().a = 0;
    this.a.a.a(this.a.a(), this.a.a().getIntent());
    this.a.b(1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.28
 * JD-Core Version:    0.7.0.1
 */
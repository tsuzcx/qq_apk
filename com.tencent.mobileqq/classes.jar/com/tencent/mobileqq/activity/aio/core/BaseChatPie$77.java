package com.tencent.mobileqq.activity.aio.core;

import android.view.View;
import android.view.View.OnClickListener;
import awcm;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseChatPie$77
  implements View.OnClickListener
{
  BaseChatPie$77(BaseChatPie paramBaseChatPie) {}
  
  public void onClick(View paramView)
  {
    awcm.a().a = 0;
    this.this$0.chatPieHelper.a(this.this$0.getActivity(), this.this$0.getActivity().getIntent());
    this.this$0.finish(1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.77
 * JD-Core Version:    0.7.0.1
 */
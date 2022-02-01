package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DatalineChatPie$9
  implements View.OnClickListener
{
  DatalineChatPie$9(DatalineChatPie paramDatalineChatPie) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366802) {
      DatalineChatPie.c(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie.9
 * JD-Core Version:    0.7.0.1
 */
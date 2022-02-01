package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DatalineChatPie$6
  implements View.OnClickListener
{
  DatalineChatPie$6(DatalineChatPie paramDatalineChatPie) {}
  
  public void onClick(View paramView)
  {
    DatalineChatPie.c(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class ChatActivityUtils$15
  implements View.OnClickListener
{
  ChatActivityUtils$15(Toast paramToast) {}
  
  public void onClick(View paramView)
  {
    this.a.cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.15
 * JD-Core Version:    0.7.0.1
 */
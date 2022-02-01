package com.tencent.mobileqq.activity.contact.troop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotifyAndRecAdapter$5
  implements View.OnClickListener
{
  NotifyAndRecAdapter$5(NotifyAndRecAdapter paramNotifyAndRecAdapter) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      NotifyAndRecAdapter.a(this.a, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotifyAndRecAdapter.5
 * JD-Core Version:    0.7.0.1
 */
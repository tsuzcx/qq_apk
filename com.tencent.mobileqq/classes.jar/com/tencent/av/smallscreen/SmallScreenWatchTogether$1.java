package com.tencent.av.smallscreen;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SmallScreenWatchTogether$1
  implements View.OnClickListener
{
  SmallScreenWatchTogether$1(SmallScreenWatchTogether paramSmallScreenWatchTogether) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenWatchTogether.1
 * JD-Core Version:    0.7.0.1
 */
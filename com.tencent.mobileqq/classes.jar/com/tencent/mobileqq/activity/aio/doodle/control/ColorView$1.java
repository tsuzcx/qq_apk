package com.tencent.mobileqq.activity.aio.doodle.control;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ColorView$1
  implements View.OnClickListener
{
  ColorView$1(ColorView paramColorView) {}
  
  public void onClick(View paramView)
  {
    if (ColorView.a(this.a) != null) {
      ColorView.a(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.control.ColorView.1
 * JD-Core Version:    0.7.0.1
 */
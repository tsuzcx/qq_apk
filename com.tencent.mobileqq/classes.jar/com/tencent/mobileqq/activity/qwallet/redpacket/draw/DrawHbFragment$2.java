package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DrawHbFragment$2
  implements View.OnClickListener
{
  DrawHbFragment$2(DrawHbFragment paramDrawHbFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.a(DrawHbFragment.a(this.a).getText().toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawHbFragment.2
 * JD-Core Version:    0.7.0.1
 */
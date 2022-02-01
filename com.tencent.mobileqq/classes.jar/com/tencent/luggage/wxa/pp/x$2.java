package com.tencent.luggage.wxa.pp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class x$2
  implements View.OnClickListener
{
  x$2(x paramx) {}
  
  public void onClick(View paramView)
  {
    if (paramView.isSelected())
    {
      x.k().c(this.a);
      paramView.setSelected(false);
    }
    else
    {
      x.k().d(this.a);
      paramView.setSelected(true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.x.2
 * JD-Core Version:    0.7.0.1
 */
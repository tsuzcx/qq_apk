package com.tencent.luggage.game.widget.input;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public void onClick(View paramView)
  {
    if (a.a(this.a) != null) {
      a.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.widget.input.a.1
 * JD-Core Version:    0.7.0.1
 */
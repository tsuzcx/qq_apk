package com.tencent.av.ui.effect.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QavEffectSlidingTabView$1
  implements View.OnClickListener
{
  QavEffectSlidingTabView$1(QavEffectSlidingTabView paramQavEffectSlidingTabView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.b.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.view.QavEffectSlidingTabView.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gdtad.views.videoimax;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtVideoImaxFragment$3
  implements View.OnClickListener
{
  GdtVideoImaxFragment$3(GdtVideoImaxFragment paramGdtVideoImaxFragment) {}
  
  public void onClick(View paramView)
  {
    boolean bool = this.a.a(paramView);
    GdtVideoImaxFragment.b(this.a, bool);
    GdtVideoImaxFragment.g(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoimax.GdtVideoImaxFragment.3
 * JD-Core Version:    0.7.0.1
 */
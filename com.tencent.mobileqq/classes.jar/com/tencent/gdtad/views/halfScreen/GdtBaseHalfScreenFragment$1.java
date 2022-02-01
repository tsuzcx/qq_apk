package com.tencent.gdtad.views.halfScreen;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtBaseHalfScreenFragment$1
  implements View.OnClickListener
{
  GdtBaseHalfScreenFragment$1(GdtBaseHalfScreenFragment paramGdtBaseHalfScreenFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getBaseActivity() != null) {
      this.a.getBaseActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.halfScreen.GdtBaseHalfScreenFragment.1
 * JD-Core Version:    0.7.0.1
 */
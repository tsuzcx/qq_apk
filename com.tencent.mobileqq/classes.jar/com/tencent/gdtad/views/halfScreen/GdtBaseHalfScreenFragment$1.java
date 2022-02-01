package com.tencent.gdtad.views.halfScreen;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtBaseHalfScreenFragment$1
  implements View.OnClickListener
{
  GdtBaseHalfScreenFragment$1(GdtBaseHalfScreenFragment paramGdtBaseHalfScreenFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getActivity() != null) {
      this.a.getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.halfScreen.GdtBaseHalfScreenFragment.1
 * JD-Core Version:    0.7.0.1
 */
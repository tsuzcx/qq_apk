package com.tencent.gdtad.views.halfScreen;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtBaseHalfScreenFragment$2
  implements View.OnClickListener
{
  GdtBaseHalfScreenFragment$2(GdtBaseHalfScreenFragment paramGdtBaseHalfScreenFragment) {}
  
  public void onClick(View paramView)
  {
    if ((GdtBaseHalfScreenFragment.a(this.a) != null) && (GdtBaseHalfScreenFragment.a(this.a).canGoBack())) {
      GdtBaseHalfScreenFragment.a(this.a).goBack();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.getActivity() != null) {
        this.a.getActivity().finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.halfScreen.GdtBaseHalfScreenFragment.2
 * JD-Core Version:    0.7.0.1
 */
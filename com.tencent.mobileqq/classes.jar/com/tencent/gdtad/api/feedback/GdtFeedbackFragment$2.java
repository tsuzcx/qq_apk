package com.tencent.gdtad.api.feedback;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtFeedbackFragment$2
  implements View.OnClickListener
{
  GdtFeedbackFragment$2(GdtFeedbackFragment paramGdtFeedbackFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.GdtFeedbackFragment.2
 * JD-Core Version:    0.7.0.1
 */
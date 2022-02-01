package com.tencent.ad.tangram.views.feedback;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AdFeedbackDialogFragment$3
  implements View.OnClickListener
{
  AdFeedbackDialogFragment$3(AdFeedbackDialogFragment paramAdFeedbackDialogFragment) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.3
 * JD-Core Version:    0.7.0.1
 */
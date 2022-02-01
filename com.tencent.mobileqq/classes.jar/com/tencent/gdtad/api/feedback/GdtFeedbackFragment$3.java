package com.tencent.gdtad.api.feedback;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtFeedbackFragment$3
  implements View.OnClickListener
{
  GdtFeedbackFragment$3(GdtFeedbackFragment paramGdtFeedbackFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      int i = ((GdtFeedbackFragment.GdtFeedbackItemView)paramView).a;
      this.a.a.a(i);
      GdtFeedbackFragment.a(this.a, this.a.a.a(i), this.a.a.c(i));
      this.a.dismiss();
    }
    catch (Exception localException)
    {
      AdLog.e(GdtFeedbackFragment.a(), "onItemClicked error", localException);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.feedback.GdtFeedbackFragment.3
 * JD-Core Version:    0.7.0.1
 */
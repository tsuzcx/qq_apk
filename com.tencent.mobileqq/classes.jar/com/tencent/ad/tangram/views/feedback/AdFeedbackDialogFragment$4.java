package com.tencent.ad.tangram.views.feedback;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class AdFeedbackDialogFragment$4
  implements View.OnClickListener
{
  AdFeedbackDialogFragment$4(AdFeedbackDialogFragment paramAdFeedbackDialogFragment) {}
  
  public void onClick(View paramView)
  {
    try
    {
      int i = ((a)paramView).index;
      AdFeedbackDialogFragment.AdFeedbackItemModel localAdFeedbackItemModel = (AdFeedbackDialogFragment.AdFeedbackItemModel)AdFeedbackDialogFragment.access$200(this.this$0).get(i);
      AdFeedbackDialogFragment.access$300(this.this$0, localAdFeedbackItemModel.mReportType);
      AdFeedbackDialogFragment.access$400(this.this$0, localAdFeedbackItemModel.mActionType, localAdFeedbackItemModel.mJumpUrl);
      this.this$0.dismiss();
    }
    catch (Exception localException)
    {
      AdLog.e(AdFeedbackDialogFragment.access$500(), "onItemClicked error", localException);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.4
 * JD-Core Version:    0.7.0.1
 */
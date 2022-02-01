package com.tencent.ad.tangram.views.feedback;

import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;

class AdFeedbackDialogFragment$6
  implements Runnable
{
  AdFeedbackDialogFragment$6(AdFeedbackDialogFragment paramAdFeedbackDialogFragment, String paramString) {}
  
  public void run()
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl(this.val$url);
    localParams.method = "GET";
    AdHttp.send(localParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.api.notify;

import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.feedback.StartGdtFeedbackParams;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

class GdtNotify$7
  implements Runnable
{
  GdtNotify$7(GdtNotify paramGdtNotify, WeakReference paramWeakReference, GdtAd paramGdtAd, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtFeedbackFragment(StartGdtFeedbackParams.a(this.a, new WeakReference(GdtNotify.a(this.this$0)), this.b, this.c, this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.notify.GdtNotify.7
 * JD-Core Version:    0.7.0.1
 */
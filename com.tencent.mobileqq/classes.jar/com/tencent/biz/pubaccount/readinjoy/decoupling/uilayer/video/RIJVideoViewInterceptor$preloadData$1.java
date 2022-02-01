package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import psa;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class RIJVideoViewInterceptor$preloadData$1
  implements Runnable
{
  public RIJVideoViewInterceptor$preloadData$1(psa parampsa, BaseArticleInfo paramBaseArticleInfo) {}
  
  public final void run()
  {
    try
    {
      psa.a(this.this$0, this.a);
      psa.b(this.this$0, this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("RIJVideoViewInterceptor", 1, "innerPreloadAvatar exception", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.video.RIJVideoViewInterceptor.preloadData.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.channelbanner;

import com.tencent.pts.core.PTSComposer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import opy;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class RIJChannelBannerController$refreshChannelBannerView$1
  implements Runnable
{
  public RIJChannelBannerController$refreshChannelBannerView$1(opy paramopy, PTSComposer paramPTSComposer) {}
  
  public final void run()
  {
    RIJChannelBannerView localRIJChannelBannerView = this.this$0.a();
    if (localRIJChannelBannerView != null)
    {
      PTSComposer localPTSComposer = this.a;
      Intrinsics.checkExpressionValueIsNotNull(localPTSComposer, "newPtsComposer");
      localRIJChannelBannerView.a(localPTSComposer, opy.a(this.this$0));
    }
    opy.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerController.refreshChannelBannerView.1
 * JD-Core Version:    0.7.0.1
 */
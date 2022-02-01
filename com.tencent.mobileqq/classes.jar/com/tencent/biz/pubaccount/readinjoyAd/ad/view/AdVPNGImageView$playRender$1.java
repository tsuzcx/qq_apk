package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.mobileqq.vpng.glrenderer.VPNGRenderer;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AdVPNGImageView$playRender$1
  implements Runnable
{
  AdVPNGImageView$playRender$1(AdVPNGImageView paramAdVPNGImageView) {}
  
  public final void run()
  {
    if (this.this$0.getStopPlay()) {
      return;
    }
    VPNGRenderer localVPNGRenderer = AdVPNGImageView.a(this.this$0);
    if (localVPNGRenderer != null) {
      localVPNGRenderer.h();
    }
    if (this.this$0.getMuteVolume()) {
      AdVPNGImageView.a(this.this$0).k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.AdVPNGImageView.playRender.1
 * JD-Core Version:    0.7.0.1
 */
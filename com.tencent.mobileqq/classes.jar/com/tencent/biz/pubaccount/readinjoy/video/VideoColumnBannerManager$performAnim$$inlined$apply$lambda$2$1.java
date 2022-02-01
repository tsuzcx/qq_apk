package com.tencent.biz.pubaccount.readinjoy.video;

import kotlin.Metadata;
import pka;
import rvx;
import rwd;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$performAnim$columnTextTranslationAnim$1$2$onAnimationEnd$1"}, k=3, mv={1, 1, 16})
public final class VideoColumnBannerManager$performAnim$$inlined$apply$lambda$2$1
  implements Runnable
{
  public VideoColumnBannerManager$performAnim$$inlined$apply$lambda$2$1(rwd paramrwd) {}
  
  public final void run()
  {
    pka localpka = rvx.a(this.this$0.a);
    if (localpka != null) {
      localpka.setRepeatCount(0);
    }
    localpka = rvx.a(this.this$0.a);
    if (localpka != null) {
      localpka.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoColumnBannerManager.performAnim..inlined.apply.lambda.2.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.video;

import kotlin.Metadata;
import pid;
import rtv;
import rub;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/biz/pubaccount/readinjoy/video/VideoColumnBannerManager$performAnim$columnTextTranslationAnim$1$2$onAnimationEnd$1"}, k=3, mv={1, 1, 16})
public final class VideoColumnBannerManager$performAnim$$inlined$apply$lambda$2$1
  implements Runnable
{
  public VideoColumnBannerManager$performAnim$$inlined$apply$lambda$2$1(rub paramrub) {}
  
  public final void run()
  {
    pid localpid = rtv.a(this.this$0.a);
    if (localpid != null) {
      localpid.setRepeatCount(0);
    }
    localpid = rtv.a(this.this$0.a);
    if (localpid != null) {
      localpid.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoColumnBannerManager.performAnim..inlined.apply.lambda.2.1
 * JD-Core Version:    0.7.0.1
 */
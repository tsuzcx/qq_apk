package com.tencent.av.video.effect.beauty;

import com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautyFilter;

class BeautyRender$3
  implements Runnable
{
  BeautyRender$3(BeautyRender paramBeautyRender, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void run()
  {
    if (BeautyRender.access$000(this.this$0) != null) {
      BeautyRender.access$000(this.this$0).setBeauty(this.val$mixPercent, this.val$sharpen, this.val$exposure);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.video.effect.beauty.BeautyRender.3
 * JD-Core Version:    0.7.0.1
 */
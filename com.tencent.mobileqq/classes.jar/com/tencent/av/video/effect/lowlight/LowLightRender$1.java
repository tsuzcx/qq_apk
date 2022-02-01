package com.tencent.av.video.effect.lowlight;

import com.tencent.av.video.effect.core.qqavimage.lowlight.QQAVImageLowLightFilter;

class LowLightRender$1
  implements Runnable
{
  LowLightRender$1(LowLightRender paramLowLightRender) {}
  
  public void run()
  {
    LowLightRender.access$002(this.this$0, new QQAVImageLowLightFilter());
    LowLightRender.access$000(this.this$0).setLowLightImage(LowLightRender.access$100(this.this$0));
    LowLightRender.access$000(this.this$0).init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.lowlight.LowLightRender.1
 * JD-Core Version:    0.7.0.1
 */
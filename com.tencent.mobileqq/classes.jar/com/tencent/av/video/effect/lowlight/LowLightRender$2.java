package com.tencent.av.video.effect.lowlight;

import com.tencent.av.video.effect.core.qqavimage.lowlight.QQAVImageLowLightFilter;

class LowLightRender$2
  implements Runnable
{
  LowLightRender$2(LowLightRender paramLowLightRender) {}
  
  public void run()
  {
    LowLightRender.access$002(this.this$0, new QQAVImageLowLightFilter());
    LowLightRender.access$000(this.this$0).setLowLightImage(LowLightRender.access$100(this.this$0));
    LowLightRender.access$000(this.this$0).init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.lowlight.LowLightRender.2
 * JD-Core Version:    0.7.0.1
 */
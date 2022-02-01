package com.tencent.av.video.effect.denoise;

import com.tencent.av.video.effect.core.qqavimage.denoise.QQAVImageDenoiseFilter;

class DenoiseRender$1
  implements Runnable
{
  DenoiseRender$1(DenoiseRender paramDenoiseRender) {}
  
  public void run()
  {
    DenoiseRender.access$002(this.this$0, new QQAVImageDenoiseFilter());
    DenoiseRender.access$000(this.this$0).init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.denoise.DenoiseRender.1
 * JD-Core Version:    0.7.0.1
 */
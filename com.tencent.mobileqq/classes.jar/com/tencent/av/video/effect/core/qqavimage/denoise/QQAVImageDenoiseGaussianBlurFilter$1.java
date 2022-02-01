package com.tencent.av.video.effect.core.qqavimage.denoise;

import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import java.util.List;

class QQAVImageDenoiseGaussianBlurFilter$1
  implements Runnable
{
  QQAVImageDenoiseGaussianBlurFilter$1(QQAVImageDenoiseGaussianBlurFilter paramQQAVImageDenoiseGaussianBlurFilter) {}
  
  public void run()
  {
    if (QQAVImageDenoiseGaussianBlurFilter.access$000(this.this$0) != null)
    {
      int i = 0;
      while (i < QQAVImageDenoiseGaussianBlurFilter.access$100(this.this$0).size())
      {
        ((QQAVImageFilter)QQAVImageDenoiseGaussianBlurFilter.access$200(this.this$0).get(i)).init();
        ((QQAVImageFilter)QQAVImageDenoiseGaussianBlurFilter.access$500(this.this$0).get(i)).onOutputSizeChanged(QQAVImageDenoiseGaussianBlurFilter.access$300(this.this$0), QQAVImageDenoiseGaussianBlurFilter.access$400(this.this$0));
        QQAVImageDenoiseGaussianBlurFilter localQQAVImageDenoiseGaussianBlurFilter = this.this$0;
        localQQAVImageDenoiseGaussianBlurFilter.onOutputSizeChanged(QQAVImageDenoiseGaussianBlurFilter.access$600(localQQAVImageDenoiseGaussianBlurFilter), QQAVImageDenoiseGaussianBlurFilter.access$700(this.this$0));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.denoise.QQAVImageDenoiseGaussianBlurFilter.1
 * JD-Core Version:    0.7.0.1
 */
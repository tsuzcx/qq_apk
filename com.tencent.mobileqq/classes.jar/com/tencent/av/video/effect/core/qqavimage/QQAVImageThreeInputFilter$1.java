package com.tencent.av.video.effect.core.qqavimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;

class QQAVImageThreeInputFilter$1
  implements Runnable
{
  QQAVImageThreeInputFilter$1(QQAVImageThreeInputFilter paramQQAVImageThreeInputFilter, Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  public void run()
  {
    if (this.this$0.filterSourceTexture2 == -1)
    {
      GLES20.glActiveTexture(33987);
      this.this$0.filterSourceTexture2 = OpenGlUtils.loadTexture(this.val$bitmap2, -1, false);
    }
    if (this.this$0.filterSourceTexture3 == -1)
    {
      GLES20.glActiveTexture(33989);
      this.this$0.filterSourceTexture3 = OpenGlUtils.loadTexture(this.val$bitmap3, -1, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageThreeInputFilter.1
 * JD-Core Version:    0.7.0.1
 */
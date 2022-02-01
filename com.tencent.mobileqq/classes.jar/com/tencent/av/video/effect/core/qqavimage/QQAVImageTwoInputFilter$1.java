package com.tencent.av.video.effect.core.qqavimage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.util.OpenGlUtils;

class QQAVImageTwoInputFilter$1
  implements Runnable
{
  QQAVImageTwoInputFilter$1(QQAVImageTwoInputFilter paramQQAVImageTwoInputFilter, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.this$0.mFilterSourceTexture2 != -1) || (this.val$bitmap == null) || (this.val$bitmap.isRecycled())) {
      return;
    }
    GLES20.glActiveTexture(33987);
    this.this$0.mFilterSourceTexture2 = OpenGlUtils.loadTexture(this.val$bitmap, -1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqcircle.widgets.multiTouchImage;

import android.view.animation.Interpolator;
import com.tencent.qphone.base.util.QLog;
import wax;
import wbb;

class PhotoViewAttacher$AnimatedZoomRunnable
  implements Runnable
{
  private final float jdField_a_of_type_Float;
  private final long jdField_a_of_type_Long;
  private final float b;
  private final float c;
  private final float d;
  
  public PhotoViewAttacher$AnimatedZoomRunnable(PhotoViewAttacher paramPhotoViewAttacher, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.jdField_a_of_type_Float = paramFloat3;
    this.b = paramFloat4;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.c = paramFloat1;
    this.d = paramFloat2;
  }
  
  private float a()
  {
    float f = Math.min(1.0F, (float)(System.currentTimeMillis() - this.jdField_a_of_type_Long) * 1.0F / PhotoViewAttacher.c(this.this$0));
    return PhotoViewAttacher.a(this.this$0).getInterpolation(f);
  }
  
  public void run()
  {
    float f1 = a();
    float f2 = (this.c + (this.d - this.c) * f1) / this.this$0.a();
    PhotoViewAttacher.a(this.this$0).a(f2, this.jdField_a_of_type_Float, this.b);
    if (f1 < 1.0F)
    {
      wax.a(PhotoViewAttacher.a(this.this$0), this);
      QLog.d("PhotoViewAttacher", 4, "AnimatedZoomRunnable postOnAnimation t:" + f1 + " deltaScale:" + f2 + " mFocalX:" + this.jdField_a_of_type_Float + " mFocalY:" + this.b);
    }
    QLog.d("PhotoViewAttacher", 4, "AnimatedZoomRunnable t:" + f1 + " deltaScale:" + f2 + " mFocalX:" + this.jdField_a_of_type_Float + " mFocalY:" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.multiTouchImage.PhotoViewAttacher.AnimatedZoomRunnable
 * JD-Core Version:    0.7.0.1
 */
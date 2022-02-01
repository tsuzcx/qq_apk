package com.tencent.aelight.camera.ae.biz.circle.widget;

import android.view.animation.Interpolator;
import com.tencent.qphone.base.util.QLog;

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
    float f2 = this.c;
    f2 = (f2 + (this.d - f2) * f1) / this.this$0.a();
    PhotoViewAttacher.a(this.this$0).a(f2, this.jdField_a_of_type_Float, this.b);
    if (f1 < 1.0F)
    {
      Compat.a(PhotoViewAttacher.a(this.this$0), this);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("AnimatedZoomRunnable postOnAnimation t:");
      localStringBuilder.append(f1);
      localStringBuilder.append(" deltaScale:");
      localStringBuilder.append(f2);
      localStringBuilder.append(" mFocalX:");
      localStringBuilder.append(this.jdField_a_of_type_Float);
      localStringBuilder.append(" mFocalY:");
      localStringBuilder.append(this.b);
      QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AnimatedZoomRunnable t:");
    localStringBuilder.append(f1);
    localStringBuilder.append(" deltaScale:");
    localStringBuilder.append(f2);
    localStringBuilder.append(" mFocalX:");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(" mFocalY:");
    localStringBuilder.append(this.b);
    QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.widget.PhotoViewAttacher.AnimatedZoomRunnable
 * JD-Core Version:    0.7.0.1
 */
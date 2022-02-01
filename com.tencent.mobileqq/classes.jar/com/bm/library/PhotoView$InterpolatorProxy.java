package com.bm.library;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

class PhotoView$InterpolatorProxy
  implements Interpolator
{
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
  
  private PhotoView$InterpolatorProxy(PhotoView paramPhotoView) {}
  
  public void a(Interpolator paramInterpolator)
  {
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = paramInterpolator;
  }
  
  public float getInterpolation(float paramFloat)
  {
    Interpolator localInterpolator = this.jdField_a_of_type_AndroidViewAnimationInterpolator;
    float f = paramFloat;
    if (localInterpolator != null) {
      f = localInterpolator.getInterpolation(paramFloat);
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.bm.library.PhotoView.InterpolatorProxy
 * JD-Core Version:    0.7.0.1
 */
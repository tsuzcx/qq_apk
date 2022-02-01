package com.bm.library;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

class PhotoView$InterpolatorProxy
  implements Interpolator
{
  private Interpolator b = new DecelerateInterpolator();
  
  private PhotoView$InterpolatorProxy(PhotoView paramPhotoView) {}
  
  public void a(Interpolator paramInterpolator)
  {
    this.b = paramInterpolator;
  }
  
  public float getInterpolation(float paramFloat)
  {
    Interpolator localInterpolator = this.b;
    float f = paramFloat;
    if (localInterpolator != null) {
      f = localInterpolator.getInterpolation(paramFloat);
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bm.library.PhotoView.InterpolatorProxy
 * JD-Core Version:    0.7.0.1
 */
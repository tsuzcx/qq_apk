package com.bm.library;

import android.graphics.Matrix;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

class PhotoView$2
  implements ScaleGestureDetector.OnScaleGestureListener
{
  PhotoView$2(PhotoView paramPhotoView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f = paramScaleGestureDetector.getScaleFactor();
    if ((Float.isNaN(f)) || (Float.isInfinite(f))) {
      return false;
    }
    PhotoView.c(this.a, PhotoView.c(this.a) * f);
    PhotoView.a(this.a).postScale(f, f, paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY());
    PhotoView.a(this.a);
    return true;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.bm.library.PhotoView.2
 * JD-Core Version:    0.7.0.1
 */
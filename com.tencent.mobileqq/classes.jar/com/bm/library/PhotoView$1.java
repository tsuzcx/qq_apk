package com.bm.library;

import android.graphics.Matrix;

class PhotoView$1
  implements OnRotateListener
{
  PhotoView$1(PhotoView paramPhotoView) {}
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    PhotoView.a(this.a, PhotoView.a(this.a) + paramFloat1);
    if (PhotoView.a(this.a))
    {
      PhotoView.b(this.a, PhotoView.b(this.a) + paramFloat1);
      PhotoView.a(this.a).postRotate(paramFloat1, paramFloat2, paramFloat3);
    }
    while (Math.abs(PhotoView.a(this.a)) < PhotoView.a(this.a)) {
      return;
    }
    PhotoView.a(this.a, true);
    PhotoView.a(this.a, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.bm.library.PhotoView.1
 * JD-Core Version:    0.7.0.1
 */
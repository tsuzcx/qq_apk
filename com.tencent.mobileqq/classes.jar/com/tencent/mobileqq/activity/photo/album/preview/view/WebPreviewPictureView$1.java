package com.tencent.mobileqq.activity.photo.album.preview.view;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class WebPreviewPictureView$1
  implements URLDrawable.URLDrawableListener
{
  WebPreviewPictureView$1(WebPreviewPictureView paramWebPreviewPictureView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    WebPreviewPictureView.a(this.a, paramURLDrawable);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    WebPreviewPictureView.a(this.a, paramURLDrawable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    WebPreviewPictureView.a(this.a, paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.preview.view.WebPreviewPictureView.1
 * JD-Core Version:    0.7.0.1
 */
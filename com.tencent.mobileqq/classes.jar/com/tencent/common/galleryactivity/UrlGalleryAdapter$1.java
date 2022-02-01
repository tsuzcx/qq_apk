package com.tencent.common.galleryactivity;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;

class UrlGalleryAdapter$1
  extends URLDrawableDownListener.Adapter
{
  UrlGalleryAdapter$1(UrlGalleryAdapter paramUrlGalleryAdapter, int paramInt, ViewGroup paramViewGroup) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.c.a(this.a, false);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    this.c.b(this.a, paramInt / 100);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.c.a(this.a, true);
    paramView = this.c.b(paramURLDrawable.getURL(), this.b);
    if (paramView != null) {
      this.c.a(paramView, paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.UrlGalleryAdapter.1
 * JD-Core Version:    0.7.0.1
 */
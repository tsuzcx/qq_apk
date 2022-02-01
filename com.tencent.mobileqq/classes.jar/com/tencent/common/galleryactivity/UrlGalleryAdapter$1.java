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
    this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.a(this.jdField_a_of_type_Int, false);
  }
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.b(this.jdField_a_of_type_Int, paramInt / 100);
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.a(this.jdField_a_of_type_Int, true);
    paramView = this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.a(paramURLDrawable.getURL(), this.jdField_a_of_type_AndroidViewViewGroup);
    if (paramView != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityUrlGalleryAdapter.a(paramView, paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.galleryactivity.UrlGalleryAdapter.1
 * JD-Core Version:    0.7.0.1
 */
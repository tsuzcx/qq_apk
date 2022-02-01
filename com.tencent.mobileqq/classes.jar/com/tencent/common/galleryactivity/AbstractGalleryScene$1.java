package com.tencent.common.galleryactivity;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

class AbstractGalleryScene$1
  implements AnimationLister
{
  AbstractGalleryScene$1(AbstractGalleryScene paramAbstractGalleryScene) {}
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onEnterAnimationEnd");
    }
    if (this.a.jdField_a_of_type_ComTencentWidgetGallery.getVisibility() != 0) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    }
    this.a.f();
    if ((this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) && (!this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a())) {
      this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a();
    }
  }
  
  public void g()
  {
    if (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().b) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    }
    this.a.g();
    if ((this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) && (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a())) {
      this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.b();
    }
  }
  
  public void h()
  {
    if (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a().b) {
      this.a.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(4);
    }
    if (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView != null) {
      this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractGalleryPageView.a(4);
    }
    if ((this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView != null) && (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.a())) {
      this.a.jdField_a_of_type_ComTencentCommonGalleryactivityAbstractProgressView.b();
    }
    this.a.h();
    this.a.jdField_a_of_type_ComTencentWidgetGallery.reset();
  }
  
  public void i()
  {
    this.a.i();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gallery onExitAnimationEnd ");
      boolean bool;
      if (this.a.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a() == this.a) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("GalleryComponent", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    AbstractGalleryScene localAbstractGalleryScene = this.a;
    if (localObject == localAbstractGalleryScene)
    {
      localAbstractGalleryScene.jdField_a_of_type_AndroidAppActivity.finish();
      return;
    }
    localAbstractGalleryScene.jdField_a_of_type_ComTencentWidgetGallery.setVisibility(0);
    this.a.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractGalleryScene.1
 * JD-Core Version:    0.7.0.1
 */
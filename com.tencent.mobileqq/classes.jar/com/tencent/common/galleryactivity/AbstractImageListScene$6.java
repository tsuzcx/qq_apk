package com.tencent.common.galleryactivity;

import com.tencent.qphone.base.util.QLog;

class AbstractImageListScene$6
  implements AnimationLister
{
  AbstractImageListScene$6(AbstractImageListScene paramAbstractImageListScene) {}
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "image list onEnterAnimationEnd");
    }
    this.a.g();
  }
  
  public void h()
  {
    this.a.h();
  }
  
  public void i()
  {
    this.a.i();
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "image list onExitAnimationEnd");
    }
    this.a.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractImageListScene.6
 * JD-Core Version:    0.7.0.1
 */
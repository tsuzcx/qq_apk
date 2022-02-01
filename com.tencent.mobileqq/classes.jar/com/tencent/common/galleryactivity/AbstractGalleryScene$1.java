package com.tencent.common.galleryactivity;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;

class AbstractGalleryScene$1
  implements AnimationLister
{
  AbstractGalleryScene$1(AbstractGalleryScene paramAbstractGalleryScene) {}
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryComponent", 2, "gallery onEnterAnimationEnd");
    }
    if (this.a.q.getVisibility() != 0) {
      this.a.q.setVisibility(0);
    }
    this.a.g();
    if ((this.a.x != null) && (!this.a.x.d())) {
      this.a.x.a();
    }
  }
  
  public void h()
  {
    if (this.a.C.a().d) {
      this.a.q.setVisibility(4);
    }
    this.a.h();
    if ((this.a.x != null) && (this.a.x.d())) {
      this.a.x.b();
    }
  }
  
  public void i()
  {
    if (this.a.C.a().d) {
      this.a.q.setVisibility(4);
    }
    if (this.a.v != null) {
      this.a.v.a(4);
    }
    if ((this.a.x != null) && (this.a.x.d())) {
      this.a.x.b();
    }
    this.a.i();
    this.a.q.reset();
  }
  
  public void j()
  {
    this.a.j();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("gallery onExitAnimationEnd ");
      boolean bool;
      if (this.a.C.e() == this.a) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("GalleryComponent", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.C.e();
    AbstractGalleryScene localAbstractGalleryScene = this.a;
    if (localObject == localAbstractGalleryScene)
    {
      localAbstractGalleryScene.w.finish();
      return;
    }
    localAbstractGalleryScene.q.setVisibility(0);
    this.a.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractGalleryScene.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.common.galleryactivity;

import android.view.animation.Animation;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class AbstractGalleryScene$2
  extends AnimateUtils.AnimationAdapter
{
  AbstractGalleryScene$2(AbstractGalleryScene paramAbstractGalleryScene) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.C.a().g();
    this.a.C.a().d();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.C.a().h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractGalleryScene.2
 * JD-Core Version:    0.7.0.1
 */
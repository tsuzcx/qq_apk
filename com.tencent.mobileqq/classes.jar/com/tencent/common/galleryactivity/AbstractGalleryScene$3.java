package com.tencent.common.galleryactivity;

import android.view.animation.Animation;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class AbstractGalleryScene$3
  extends AnimateUtils.AnimationAdapter
{
  AbstractGalleryScene$3(AbstractGalleryScene paramAbstractGalleryScene) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.C.a().j();
    this.a.C.a().d();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.C.a().i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AbstractGalleryScene.3
 * JD-Core Version:    0.7.0.1
 */
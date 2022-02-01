package com.tencent.biz.qqstory.album.view;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AlbumGalleryAdapterHolder$HolderMsgUIHandler$1
  implements Animation.AnimationListener
{
  AlbumGalleryAdapterHolder$HolderMsgUIHandler$1(AlbumGalleryAdapterHolder.HolderMsgUIHandler paramHolderMsgUIHandler) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (AlbumGalleryAdapterHolder.c(this.a.a) == 1)
    {
      this.a.a.e.setVisibility(8);
      AlbumGalleryAdapterHolder.k(this.a.a).sendEmptyMessage(1);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryAdapterHolder.HolderMsgUIHandler.1
 * JD-Core Version:    0.7.0.1
 */
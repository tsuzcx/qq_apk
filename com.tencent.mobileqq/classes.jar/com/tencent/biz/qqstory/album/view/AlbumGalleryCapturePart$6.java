package com.tencent.biz.qqstory.album.view;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class AlbumGalleryCapturePart$6
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public void onGlobalLayout()
  {
    int i = AlbumGalleryCapturePart.a(this.a).getHeight();
    if (i != AlbumGalleryCapturePart.b(this.a)) {
      AlbumGalleryCapturePart.a(this.a, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.6
 * JD-Core Version:    0.7.0.1
 */
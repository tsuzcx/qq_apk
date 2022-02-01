package com.tencent.biz.qqstory.album.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AlbumGalleryAdapterHolder$3
  implements View.OnClickListener
{
  AlbumGalleryAdapterHolder$3(AlbumGalleryAdapterHolder paramAlbumGalleryAdapterHolder) {}
  
  public void onClick(View paramView)
  {
    if (AlbumGalleryAdapterHolder.a(this.a) != null) {
      AlbumGalleryAdapterHolder.a(this.a).a(AlbumGalleryAdapterHolder.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryAdapterHolder.3
 * JD-Core Version:    0.7.0.1
 */
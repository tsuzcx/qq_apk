package com.tencent.biz.qqstory.album.view;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AlbumGalleryAdapterHolder$2
  implements DialogInterface.OnClickListener
{
  AlbumGalleryAdapterHolder$2(AlbumGalleryAdapterHolder paramAlbumGalleryAdapterHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (AlbumGalleryAdapterHolder.a(this.a) != null) {
        AlbumGalleryAdapterHolder.a(this.a).a(AlbumGalleryAdapterHolder.b(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryAdapterHolder.2
 * JD-Core Version:    0.7.0.1
 */
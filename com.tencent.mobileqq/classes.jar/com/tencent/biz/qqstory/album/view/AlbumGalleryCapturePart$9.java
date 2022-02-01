package com.tencent.biz.qqstory.album.view;

import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

class AlbumGalleryCapturePart$9
  implements RecyclerView.OnChildAttachStateChangeListener
{
  public void onChildViewAttachedToWindow(View paramView)
  {
    paramView = (AlbumGalleryAdapterHolder)AlbumGalleryCapturePart.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == AlbumGalleryCapturePart.a(this.a)))
    {
      paramView.b();
      SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "attach from window , start play!");
    }
  }
  
  public void onChildViewDetachedFromWindow(View paramView)
  {
    paramView = (AlbumGalleryAdapterHolder)AlbumGalleryCapturePart.a(this.a).getChildViewHolder(paramView);
    if ((paramView != null) && (paramView == AlbumGalleryCapturePart.a(this.a)))
    {
      paramView.c();
      SLog.b("Q.qqstory.recommendAlbum.ui.AlbumGalleryCapturePart", "detach from window , stop play!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.9
 * JD-Core Version:    0.7.0.1
 */
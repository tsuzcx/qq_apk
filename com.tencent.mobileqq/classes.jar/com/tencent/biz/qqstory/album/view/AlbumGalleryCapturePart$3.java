package com.tencent.biz.qqstory.album.view;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import com.tencent.biz.qqstory.utils.UIUtils;
import dov.com.qq.im.capture.view.CustomLinearSnapHelper;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

class AlbumGalleryCapturePart$3
  implements Runnable
{
  public void run()
  {
    View localView = AlbumGalleryCapturePart.a(this.this$0).a(AlbumGalleryCapturePart.a(this.this$0).getLayoutManager());
    if ((AlbumGalleryCapturePart.b(this.this$0)) && (localView != null) && (AlbumGalleryCapturePart.a(this.this$0).getPosition(localView) == 0)) {
      AlbumGalleryCapturePart.a(this.this$0).a(AlbumGalleryCapturePart.a(this.this$0) - (int)UIUtils.a(AlbumGalleryCapturePart.a(this.this$0).getContext(), 30.0F), 0, 400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.3
 * JD-Core Version:    0.7.0.1
 */
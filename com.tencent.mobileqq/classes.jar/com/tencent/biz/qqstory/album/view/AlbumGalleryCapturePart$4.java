package com.tencent.biz.qqstory.album.view;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import bjke;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import srs;
import vzl;

public class AlbumGalleryCapturePart$4
  implements Runnable
{
  public AlbumGalleryCapturePart$4(srs paramsrs) {}
  
  public void run()
  {
    srs.a(this.this$0, true);
    View localView = srs.a(this.this$0).a(srs.a(this.this$0).getLayoutManager());
    if ((srs.b(this.this$0)) && (localView != null) && (srs.a(this.this$0).getPosition(localView) == 0)) {
      srs.a(this.this$0).a(-(srs.a(this.this$0) - (int)vzl.a(srs.a(this.this$0).getContext(), 30.0F)), 0, 1250);
    }
    srs.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.4
 * JD-Core Version:    0.7.0.1
 */
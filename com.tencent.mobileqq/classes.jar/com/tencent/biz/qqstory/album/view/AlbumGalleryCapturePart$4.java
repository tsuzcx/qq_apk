package com.tencent.biz.qqstory.album.view;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import bpuz;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import wia;
import zps;

public class AlbumGalleryCapturePart$4
  implements Runnable
{
  public AlbumGalleryCapturePart$4(wia paramwia) {}
  
  public void run()
  {
    wia.a(this.this$0, true);
    View localView = wia.a(this.this$0).a(wia.a(this.this$0).getLayoutManager());
    if ((wia.b(this.this$0)) && (localView != null) && (wia.a(this.this$0).getPosition(localView) == 0)) {
      wia.a(this.this$0).a(-(wia.a(this.this$0) - (int)zps.a(wia.a(this.this$0).getContext(), 30.0F)), 0, 1250);
    }
    wia.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.4
 * JD-Core Version:    0.7.0.1
 */
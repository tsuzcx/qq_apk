package com.tencent.biz.qqstory.album.view;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import bote;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import wef;
import zlx;

public class AlbumGalleryCapturePart$3
  implements Runnable
{
  public AlbumGalleryCapturePart$3(wef paramwef) {}
  
  public void run()
  {
    View localView = wef.a(this.this$0).a(wef.a(this.this$0).getLayoutManager());
    if ((wef.b(this.this$0)) && (localView != null) && (wef.a(this.this$0).getPosition(localView) == 0)) {
      wef.a(this.this$0).a(wef.a(this.this$0) - (int)zlx.a(wef.a(this.this$0).getContext(), 30.0F), 0, 400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.3
 * JD-Core Version:    0.7.0.1
 */
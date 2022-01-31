package com.tencent.biz.qqstory.album.view;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import bmaa;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import ukt;
import xsm;

public class AlbumGalleryCapturePart$4
  implements Runnable
{
  public AlbumGalleryCapturePart$4(ukt paramukt) {}
  
  public void run()
  {
    ukt.a(this.this$0, true);
    View localView = ukt.a(this.this$0).a(ukt.a(this.this$0).getLayoutManager());
    if ((ukt.b(this.this$0)) && (localView != null) && (ukt.a(this.this$0).getPosition(localView) == 0)) {
      ukt.a(this.this$0).a(-(ukt.a(this.this$0) - (int)xsm.a(ukt.a(this.this$0).getContext(), 30.0F)), 0, 1250);
    }
    ukt.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.4
 * JD-Core Version:    0.7.0.1
 */
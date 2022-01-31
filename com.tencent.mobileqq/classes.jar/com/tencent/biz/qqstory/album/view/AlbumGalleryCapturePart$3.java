package com.tencent.biz.qqstory.album.view;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import blvo;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import ugk;
import xod;

public class AlbumGalleryCapturePart$3
  implements Runnable
{
  public AlbumGalleryCapturePart$3(ugk paramugk) {}
  
  public void run()
  {
    View localView = ugk.a(this.this$0).a(ugk.a(this.this$0).getLayoutManager());
    if ((ugk.b(this.this$0)) && (localView != null) && (ugk.a(this.this$0).getPosition(localView) == 0)) {
      ugk.a(this.this$0).a(ugk.a(this.this$0) - (int)xod.a(ugk.a(this.this$0).getContext(), 30.0F), 0, 400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqstory.album.view;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import bhov;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import sez;
import vms;

public class AlbumGalleryCapturePart$3
  implements Runnable
{
  public AlbumGalleryCapturePart$3(sez paramsez) {}
  
  public void run()
  {
    View localView = sez.a(this.this$0).a(sez.a(this.this$0).getLayoutManager());
    if ((sez.b(this.this$0)) && (localView != null) && (sez.a(this.this$0).getPosition(localView) == 0)) {
      sez.a(this.this$0).a(sez.a(this.this$0) - (int)vms.a(sez.a(this.this$0).getContext(), 30.0F), 0, 400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.3
 * JD-Core Version:    0.7.0.1
 */
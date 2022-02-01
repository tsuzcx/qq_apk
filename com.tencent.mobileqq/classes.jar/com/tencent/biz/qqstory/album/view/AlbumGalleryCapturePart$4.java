package com.tencent.biz.qqstory.album.view;

import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import bonx;
import com.tencent.biz.qqstory.utils.UIUtils;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import vza;

public class AlbumGalleryCapturePart$4
  implements Runnable
{
  public void run()
  {
    vza.a(this.this$0, true);
    View localView = vza.a(this.this$0).a(vza.a(this.this$0).getLayoutManager());
    if ((vza.a(this.this$0)) && (localView != null) && (vza.a(this.this$0).getPosition(localView) == 0)) {
      vza.a(this.this$0).a(-(vza.a(this.this$0) - (int)UIUtils.px2dip(vza.a(this.this$0).getContext(), 30.0F)), 0, 1250);
    }
    vza.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.4
 * JD-Core Version:    0.7.0.1
 */
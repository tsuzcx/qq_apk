package com.tencent.gdtad.views.videoceiling;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.gdtad.views.video.GdtVideoCommonView;

class GdtVideoCeilingView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  GdtVideoCeilingView$2(GdtVideoCeilingView paramGdtVideoCeilingView) {}
  
  public void onGlobalLayout()
  {
    GdtVideoCeilingView.a(this.a, 4003028);
    GdtVideoCeilingView.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingView.2
 * JD-Core Version:    0.7.0.1
 */
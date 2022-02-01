package com.tencent.gdtad.views.videoceiling;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtVideoCeilingTitleBar$1
  implements View.OnClickListener
{
  GdtVideoCeilingTitleBar$1(GdtVideoCeilingTitleBar paramGdtVideoCeilingTitleBar) {}
  
  public void onClick(View paramView)
  {
    if (GdtVideoCeilingTitleBar.a(this.a) != null) {
      GdtVideoCeilingTitleBar.a(this.a).a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingTitleBar.1
 * JD-Core Version:    0.7.0.1
 */
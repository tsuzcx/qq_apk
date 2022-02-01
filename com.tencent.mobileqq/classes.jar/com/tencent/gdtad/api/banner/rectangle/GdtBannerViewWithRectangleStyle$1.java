package com.tencent.gdtad.api.banner.rectangle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtBannerViewWithRectangleStyle$1
  implements View.OnClickListener
{
  GdtBannerViewWithRectangleStyle$1(GdtBannerViewWithRectangleStyle paramGdtBannerViewWithRectangleStyle) {}
  
  public void onClick(View paramView)
  {
    if (!GdtBannerViewWithRectangleStyle.a(this.a))
    {
      GdtLog.d("GdtBannerViewWithRectangleStyle", "optionsContainerOnClickListener.OnClickListener error");
    }
    else
    {
      int j = GdtBannerViewWithRectangleStyle.b(this.a).getVisibility();
      int i = 8;
      if (j == 8) {
        i = 0;
      }
      GdtBannerViewWithRectangleStyle.b(this.a).setVisibility(i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleStyle.1
 * JD-Core Version:    0.7.0.1
 */
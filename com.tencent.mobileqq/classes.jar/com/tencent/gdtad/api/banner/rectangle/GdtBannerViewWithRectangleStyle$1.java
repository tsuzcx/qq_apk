package com.tencent.gdtad.api.banner.rectangle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GdtBannerViewWithRectangleStyle$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    int i = 8;
    if (!GdtBannerViewWithRectangleStyle.a(this.a)) {
      GdtLog.d("GdtBannerViewWithRectangleStyle", "optionsContainerOnClickListener.OnClickListener error");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (GdtBannerViewWithRectangleStyle.a(this.a).getVisibility() == 8) {
        i = 0;
      }
      GdtBannerViewWithRectangleStyle.a(this.a).setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.banner.rectangle.GdtBannerViewWithRectangleStyle.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqcircle.publish.outbox.banner;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NetStateCheckBanner$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.a.setVisibility(8);
    NetStateCheckBanner.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.banner.NetStateCheckBanner.1
 * JD-Core Version:    0.7.0.1
 */
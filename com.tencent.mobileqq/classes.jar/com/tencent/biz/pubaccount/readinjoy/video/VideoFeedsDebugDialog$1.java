package com.tencent.biz.pubaccount.readinjoy.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoFeedsDebugDialog$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (VideoFeedsDebugDialog.a(this.a).getVisibility() == 0) {
      VideoFeedsDebugDialog.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      VideoFeedsDebugDialog.a(this.a);
      VideoFeedsDebugDialog.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsDebugDialog.1
 * JD-Core Version:    0.7.0.1
 */
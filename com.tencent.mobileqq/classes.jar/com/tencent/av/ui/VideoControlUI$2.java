package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.utils.DataReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoControlUI$2
  implements View.OnClickListener
{
  VideoControlUI$2(VideoControlUI paramVideoControlUI) {}
  
  public void onClick(View paramView)
  {
    DataReport.c(paramView.getId());
    AVActivity localAVActivity = this.a.a();
    if (localAVActivity != null) {
      localAVActivity.BtnOnClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.2
 * JD-Core Version:    0.7.0.1
 */
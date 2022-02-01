package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DoubleVideoMeetingCtrlUI$3
  implements View.OnClickListener
{
  DoubleVideoMeetingCtrlUI$3(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void onClick(View paramView)
  {
    QLog.d(this.a.X, 1, "onClick R.id.qav_btn_accept_video");
    this.a.s();
    this.a.am.k().bA = true;
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.3
 * JD-Core Version:    0.7.0.1
 */
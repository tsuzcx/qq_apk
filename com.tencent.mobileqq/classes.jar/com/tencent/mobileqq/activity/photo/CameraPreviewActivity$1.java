package com.tencent.mobileqq.activity.photo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class CameraPreviewActivity$1
  implements View.OnClickListener
{
  CameraPreviewActivity$1(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (CameraPreviewActivity.a(this.a, (String)CameraPreviewActivity.a(this.a).get(0))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.b) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004D96", "0X8004D96", 0, 0, "", "", "", "");
      }
      PhotoUtils.sendPhoto(this.a, this.a.getIntent(), CameraPreviewActivity.a(this.a), 2, true);
      paramView.setClickable(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.CameraPreviewActivity.1
 * JD-Core Version:    0.7.0.1
 */
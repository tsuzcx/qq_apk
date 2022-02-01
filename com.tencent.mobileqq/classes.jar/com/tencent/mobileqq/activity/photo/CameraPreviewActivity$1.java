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
    CameraPreviewActivity localCameraPreviewActivity = this.a;
    if (!CameraPreviewActivity.a(localCameraPreviewActivity, (String)CameraPreviewActivity.a(localCameraPreviewActivity).get(0)))
    {
      if (this.a.b) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004D96", "0X8004D96", 0, 0, "", "", "", "");
      }
      localCameraPreviewActivity = this.a;
      PhotoUtils.sendPhoto(localCameraPreviewActivity, localCameraPreviewActivity.getIntent(), CameraPreviewActivity.a(this.a), 2, true);
      paramView.setClickable(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.CameraPreviewActivity.1
 * JD-Core Version:    0.7.0.1
 */
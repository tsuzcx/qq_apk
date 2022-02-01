package com.tencent.mobileqq.activity.photo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.AutoSaveUtils;
import java.util.ArrayList;

class CameraPreviewActivity$2
  implements View.OnClickListener
{
  CameraPreviewActivity$2(CameraPreviewActivity paramCameraPreviewActivity) {}
  
  public void onClick(View paramView)
  {
    if (!CameraPreviewActivity.a(this.a))
    {
      if (this.a.b) {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8004D93", "0X8004D93", 0, 0, "", "", "", "");
      }
      if (this.a.b) {
        StatisticConstants.d();
      } else {
        StatisticConstants.b();
      }
      if ((CameraPreviewActivity.a(this.a) != null) && (CameraPreviewActivity.a(this.a).size() > 0)) {
        AutoSaveUtils.a((String)CameraPreviewActivity.a(this.a).get(0), true);
      }
      CameraPreviewActivity localCameraPreviewActivity = this.a;
      PhotoUtils.sendPhoto(localCameraPreviewActivity, localCameraPreviewActivity.getIntent(), CameraPreviewActivity.a(this.a), 0, true);
      paramView.setClickable(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.CameraPreviewActivity.2
 * JD-Core Version:    0.7.0.1
 */
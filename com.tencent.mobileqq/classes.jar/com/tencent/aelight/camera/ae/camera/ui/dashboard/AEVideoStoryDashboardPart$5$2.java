package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.mobileqq.widget.QQToast;

class AEVideoStoryDashboardPart$5$2
  implements Runnable
{
  AEVideoStoryDashboardPart$5$2(AEVideoStoryDashboardPart.5 param5) {}
  
  public void run()
  {
    AEVideoStoryDashboardPart.a(this.a.d, false);
    QQToast.makeText(AEVideoStoryDashboardPart.d(this.a.d).s(), "下载素材失败", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.5.2
 * JD-Core Version:    0.7.0.1
 */
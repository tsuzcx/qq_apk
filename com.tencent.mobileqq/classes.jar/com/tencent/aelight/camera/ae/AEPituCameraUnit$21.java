package com.tencent.aelight.camera.ae;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.qqlive.module.videoreport.VideoReport;

class AEPituCameraUnit$21
  implements Observer<QIMFilterCategoryItem>
{
  AEPituCameraUnit$21(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    if (paramQIMFilterCategoryItem != null) {
      VideoReport.setPageParams(this.a.s(), "ae_filter_id", paramQIMFilterCategoryItem.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.21
 * JD-Core Version:    0.7.0.1
 */
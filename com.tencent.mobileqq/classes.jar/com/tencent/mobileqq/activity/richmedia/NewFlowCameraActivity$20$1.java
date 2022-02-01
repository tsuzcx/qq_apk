package com.tencent.mobileqq.activity.richmedia;

import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$20$1
  implements VideoFilterTools.OnResourceDownloadListener
{
  NewFlowCameraActivity$20$1(NewFlowCameraActivity.20 param20, VideoFilterTools paramVideoFilterTools) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onResourceDownload isOnlineRes: " + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$20.this$0.runOnUiThread(new NewFlowCameraActivity.20.1.1(this));
      return;
    }
    QLog.w("PTV.NewFlowCameraActivity", 2, "has not valid video filter!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.20.1
 * JD-Core Version:    0.7.0.1
 */
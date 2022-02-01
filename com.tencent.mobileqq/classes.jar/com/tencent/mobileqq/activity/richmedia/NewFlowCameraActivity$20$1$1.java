package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.qphone.base.util.QLog;

class NewFlowCameraActivity$20$1$1
  implements Runnable
{
  NewFlowCameraActivity$20$1$1(NewFlowCameraActivity.20.1 param1) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onResourceDownload update filterpager begin");
    }
    NewFlowCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$20.this$0, (VideoFilterViewPager)this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$20.this$0.findViewById(2131367180));
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$20.this$0.a = new NewFlowCameraActivity.20.1.1.1(this);
    NewFlowCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$20.this$0).setViewPagerItemVisiableChangeListener(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$20.this$0.a);
    NewFlowCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$20.this$0).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools.a());
    FilterDesc localFilterDesc = NewFlowCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$20.this$0).a(NewFlowCameraActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaNewFlowCameraActivity$20.this$0).getCurrentItem());
    this.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaVideoFilterTools.a(localFilterDesc);
    if (QLog.isColorLevel()) {
      QLog.d("PTV.NewFlowCameraActivity", 2, "onResourceDownload update filterpager end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.20.1.1
 * JD-Core Version:    0.7.0.1
 */
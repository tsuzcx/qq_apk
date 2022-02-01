package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;

class FlowCameraActivity2$14
  implements View.OnClickListener
{
  FlowCameraActivity2$14(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.i();
    if (((!QLog.isColorLevel()) || (!FileUtils.e(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()))) || (FlowCameraConstant.a == 1)) {
      FlowCameraMqqAction.b("", "0X8005F5B", "0");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FlowCameraMqqAction.b("", "0X8005F5B", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.14
 * JD-Core Version:    0.7.0.1
 */
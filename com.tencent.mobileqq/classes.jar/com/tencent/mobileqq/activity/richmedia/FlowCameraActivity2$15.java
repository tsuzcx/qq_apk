package com.tencent.mobileqq.activity.richmedia;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;

class FlowCameraActivity2$15
  implements View.OnClickListener
{
  FlowCameraActivity2$15(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    if (new File(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.b).exists())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.jdField_a_of_type_JavaIoFile)));
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.i();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.b);
      FlowCameraMqqAction.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2, localArrayList);
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.setResult(1001);
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.finish();
      if (FlowCameraConstant.a != 1) {
        break label127;
      }
      FlowCameraMqqAction.b("", "0X8005F5C", "0");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label127:
      FlowCameraMqqAction.b("", "0X8005F5C", "1");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.15
 * JD-Core Version:    0.7.0.1
 */
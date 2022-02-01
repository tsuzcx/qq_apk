package com.tencent.mobileqq.activity.richmedia;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;

class FlowCameraActivity2$23$1
  implements DialogInterface.OnClickListener
{
  FlowCameraActivity2$23$1(FlowCameraActivity2.23 param23) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.this$0.getIntent();
    paramDialogInterface.putExtra("flow_back", 0);
    this.a.this$0.setResult(1001, paramDialogInterface);
    paramDialogInterface = null;
    if (this.a.this$0.f) {
      paramDialogInterface = this.a.this$0.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    }
    this.a.this$0.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.a.this$0.d, this.a.this$0.e, this.a.this$0.m, this.a.this$0.f, paramDialogInterface);
    this.a.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.23.1
 * JD-Core Version:    0.7.0.1
 */
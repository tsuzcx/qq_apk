package com.tencent.mobileqq.activity.richmedia;

import android.graphics.Bitmap;
import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;

class NewFlowCameraActivity$23
  implements Runnable
{
  NewFlowCameraActivity$23(NewFlowCameraActivity paramNewFlowCameraActivity) {}
  
  public void run()
  {
    Bitmap localBitmap = null;
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr != null) {
      localBitmap = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a.a(false);
    }
    if (this.this$0.jdField_a_of_type_AndroidOsHandler != null) {
      this.this$0.jdField_a_of_type_AndroidOsHandler.post(new NewFlowCameraActivity.RunnableUpdate(localBitmap, this.this$0.e));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity.23
 * JD-Core Version:    0.7.0.1
 */
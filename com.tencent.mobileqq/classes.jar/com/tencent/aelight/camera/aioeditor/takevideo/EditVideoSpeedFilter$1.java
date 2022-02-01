package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer;

class EditVideoSpeedFilter$1
  implements Runnable
{
  EditVideoSpeedFilter$1(EditVideoSpeedFilter paramEditVideoSpeedFilter) {}
  
  public void run()
  {
    if (!EditVideoSpeedFilter.a(this.this$0)) {
      return;
    }
    if (this.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a() == null) {
      return;
    }
    Object localObject = this.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a().getActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if ((Build.VERSION.SDK_INT > 16) && (((Activity)localObject).isDestroyed())) {
        return;
      }
      localObject = this.this$0;
      EditVideoSpeedFilter.a((EditVideoSpeedFilter)localObject, (ViewStub)((EditVideoSpeedFilter)localObject).a(2064122500));
      if (this.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer == null)
      {
        localObject = EditVideoSpeedFilter.a(this.this$0).getParent();
        if ((localObject != null) && ((localObject instanceof ViewGroup)))
        {
          localObject = this.this$0;
          ((EditVideoSpeedFilter)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer = ((PickerContainer)EditVideoSpeedFilter.a((EditVideoSpeedFilter)localObject).inflate());
        }
        else
        {
          localObject = this.this$0;
          ((EditVideoSpeedFilter)localObject).jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer = ((PickerContainer)((EditVideoSpeedFilter)localObject).a(2131376742));
        }
        this.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer.a(this.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a, this.this$0);
        this.this$0.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerContainer.a(2, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSpeedFilter.1
 * JD-Core Version:    0.7.0.1
 */
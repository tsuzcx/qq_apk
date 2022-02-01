package com.tencent.aelight.camera.aioeditor.takevideo;

import com.tencent.aelight.camera.aioeditor.capture.view.ProviderViewEditContainer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView.DoodleEditViewListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;

class EditVideoDoodle$1
  implements DoodleEditView.DoodleEditViewListener
{
  EditVideoDoodle$1(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer.a();
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.f == 11) {
      this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
    }
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewProviderViewEditContainer.a(103, new Object[] { paramZoomItem });
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.f == 0) {
      this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(11);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.1
 * JD-Core Version:    0.7.0.1
 */
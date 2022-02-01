package com.tencent.aelight.camera.aioeditor.takevideo;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;

class EditProviderPart$TapDetectorListener
  extends GestureDetector.SimpleOnGestureListener
{
  private boolean jdField_a_of_type_Boolean = false;
  
  private EditProviderPart$TapDetectorListener(EditProviderPart paramEditProviderPart) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (EditProviderPart.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart).c())
    {
      paramMotionEvent = (EditDoodleExport)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart.a(EditDoodleExport.class);
      if (paramMotionEvent != null) {
        paramMotionEvent.e_();
      }
    }
    try
    {
      boolean bool = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart.a.c();
      if (!bool) {
        return false;
      }
      int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart.a.f;
      if (i == 0)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart.a.b(11);
        return true;
      }
      if ((this.jdField_a_of_type_Boolean) && (i == 11))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditProviderPart.a.b(0);
        return true;
      }
      return false;
    }
    catch (RuntimeException paramMotionEvent) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditProviderPart.TapDetectorListener
 * JD-Core Version:    0.7.0.1
 */
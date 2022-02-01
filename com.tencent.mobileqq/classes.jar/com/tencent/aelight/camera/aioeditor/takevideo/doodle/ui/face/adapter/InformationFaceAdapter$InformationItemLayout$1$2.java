package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import java.lang.ref.WeakReference;

class InformationFaceAdapter$InformationItemLayout$1$2
  implements Runnable
{
  InformationFaceAdapter$InformationItemLayout$1$2(InformationFaceAdapter.InformationItemLayout.1 param1, int paramInt) {}
  
  public void run()
  {
    if (((QIMCommonLoadingView)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter$InformationItemLayout$1.a.get()).getVisibility() == 8)
    {
      ((ProgressBar)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter$InformationItemLayout$1.c.get()).setVisibility(8);
      ((QIMCommonLoadingView)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter$InformationItemLayout$1.a.get()).setProgress(0L);
      ((QIMCommonLoadingView)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter$InformationItemLayout$1.a.get()).setVisibility(0);
      ((ImageView)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter$InformationItemLayout$1.b.get()).setVisibility(8);
    }
    ((QIMCommonLoadingView)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter$InformationItemLayout$1.a.get()).setProgress(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1.2
 * JD-Core Version:    0.7.0.1
 */
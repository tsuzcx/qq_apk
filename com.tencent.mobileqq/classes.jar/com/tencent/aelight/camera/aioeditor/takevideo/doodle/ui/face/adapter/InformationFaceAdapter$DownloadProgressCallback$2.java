package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class InformationFaceAdapter$DownloadProgressCallback$2
  implements Runnable
{
  InformationFaceAdapter$DownloadProgressCallback$2(InformationFaceAdapter.DownloadProgressCallback paramDownloadProgressCallback, boolean paramBoolean, InformationFacePackage.Item paramItem) {}
  
  public void run()
  {
    InformationFaceAdapter.DownloadProgressCallback.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter$DownloadProgressCallback).setVisibility(8);
    if (this.jdField_a_of_type_Boolean) {
      InformationFaceAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter$DownloadProgressCallback.a, InformationFaceAdapter.DownloadProgressCallback.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter$DownloadProgressCallback), this.jdField_a_of_type_ComTencentAelightCameraAioeditorDoodleUiFaceInformationFacePackage$Item);
    } else {
      QQToast.a(InformationFaceAdapter.DownloadProgressCallback.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter$DownloadProgressCallback).getContext(), 0, HardCodeUtil.a(2131705844), 0).a();
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiFaceAdapterInformationFaceAdapter$DownloadProgressCallback.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.DownloadProgressCallback.2
 * JD-Core Version:    0.7.0.1
 */
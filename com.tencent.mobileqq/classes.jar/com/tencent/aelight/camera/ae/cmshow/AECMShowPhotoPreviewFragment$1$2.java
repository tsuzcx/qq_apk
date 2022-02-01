package com.tencent.aelight.camera.ae.cmshow;

import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.cmsshow.api.CmShowDataWrapper;

class AECMShowPhotoPreviewFragment$1$2
  implements Runnable
{
  AECMShowPhotoPreviewFragment$1$2(AECMShowPhotoPreviewFragment.1 param1, int paramInt, CmShowDataWrapper paramCmShowDataWrapper) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper != null))
    {
      if (!AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment$1.a))
      {
        AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment$1.a.getBaseActivity(), this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper);
        return;
      }
      AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment$1.a, this.jdField_a_of_type_ComTencentAelightCameraCmsshowApiCmShowDataWrapper);
      return;
    }
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment$1.a, 2);
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment$1.a, System.currentTimeMillis());
    AEBaseDataReporter.a().d(1);
    if (this.jdField_a_of_type_Int == 4)
    {
      AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment$1.a).a(2, this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment$1.a.getString(2064515082));
      return;
    }
    AECMShowPhotoPreviewFragment.a(this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment$1.a).a(2, this.jdField_a_of_type_ComTencentAelightCameraAeCmshowAECMShowPhotoPreviewFragment$1.a.getString(2064515310));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.cmshow.AECMShowPhotoPreviewFragment.1.2
 * JD-Core Version:    0.7.0.1
 */
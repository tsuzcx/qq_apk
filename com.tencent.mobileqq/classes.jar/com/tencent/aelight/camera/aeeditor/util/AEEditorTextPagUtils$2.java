package com.tencent.aelight.camera.aeeditor.util;

import android.support.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.MaterialStatusCallback;
import com.tencent.aelight.camera.aeeditor.view.classifier.ApplyMaterialTask.Status;
import java.util.concurrent.CountDownLatch;

final class AEEditorTextPagUtils$2
  implements ApplyMaterialTask.MaterialStatusCallback
{
  AEEditorTextPagUtils$2(MetaMaterial paramMetaMaterial, ApplyMaterialTask.MaterialStatusCallback paramMaterialStatusCallback, CountDownLatch paramCountDownLatch) {}
  
  public void a(@NonNull ApplyMaterialTask.Status paramStatus, int paramInt)
  {
    if (paramStatus == ApplyMaterialTask.Status.SUCCEEDED)
    {
      AEEditorTextPagUtils.a(this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewClassifierApplyMaterialTask$MaterialStatusCallback);
      return;
    }
    if (paramStatus == ApplyMaterialTask.Status.FAILED) {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.util.AEEditorTextPagUtils.2
 * JD-Core Version:    0.7.0.1
 */
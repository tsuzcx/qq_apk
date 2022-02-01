package com.tencent.aelight.camera.aeeditor.view.classifier;

import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class MaterialContentAdapter$3
  implements ApplyMaterialTask.MaterialStatusCallback
{
  MaterialContentAdapter$3(MaterialContentAdapter paramMaterialContentAdapter, MetaMaterial paramMetaMaterial, ApplyMaterialTask.Status paramStatus, int paramInt) {}
  
  public void a(@NonNull ApplyMaterialTask.Status paramStatus, int paramInt)
  {
    ApplyMaterialTaskHelper.a("onPostDownloadMaterial", this.jdField_a_of_type_CameraXEFFECT_MATERIALS_GENERAL_DATASTRUCTMetaMaterial, String.format("callback: %s-%s", new Object[] { paramStatus, Integer.valueOf(paramInt) }));
    ThreadManager.getUIHandler().post(new MaterialContentAdapter.3.1(this, paramStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.classifier.MaterialContentAdapter.3
 * JD-Core Version:    0.7.0.1
 */
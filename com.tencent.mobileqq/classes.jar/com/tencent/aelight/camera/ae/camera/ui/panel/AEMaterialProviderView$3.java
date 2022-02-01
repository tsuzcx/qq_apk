package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AEMaterialProviderView$3
  implements Runnable
{
  AEMaterialProviderView$3(AEMaterialProviderView paramAEMaterialProviderView, int paramInt, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    AEGridView localAEGridView = (AEGridView)AEMaterialProviderView.a(this.this$0).a.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localAEGridView != null)
    {
      AEMaterialAdapter localAEMaterialAdapter = (AEMaterialAdapter)localAEGridView.getAdapter();
      localAEGridView.a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.c);
      localAEMaterialAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AEMaterialProviderView", 2, "gridView is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialProviderView.3
 * JD-Core Version:    0.7.0.1
 */
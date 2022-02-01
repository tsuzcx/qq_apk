package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import java.util.List;

class AEBottomListPart$15
  implements Runnable
{
  AEBottomListPart$15(AEBottomListPart paramAEBottomListPart) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialManager.b(this.this$0.a());
    this.this$0.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter.a((List)localObject);
    localObject = AEMaterialManager.a();
    if ((localObject != null) && (!((AEMaterialMetaData)localObject).equals(AEMaterialMetaData.a)))
    {
      AEBottomListPart.a(this.this$0, (AEMaterialMetaData)localObject);
      return;
    }
    this.this$0.c(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListPart.15
 * JD-Core Version:    0.7.0.1
 */
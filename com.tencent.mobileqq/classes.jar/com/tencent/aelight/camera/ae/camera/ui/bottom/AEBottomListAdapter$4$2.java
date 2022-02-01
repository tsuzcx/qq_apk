package com.tencent.aelight.camera.ae.camera.ui.bottom;

import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import java.util.Map;

class AEBottomListAdapter$4$2
  implements Runnable
{
  AEBottomListAdapter$4$2(AEBottomListAdapter.4 param4, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter$4.a.notifyDataSetChanged();
    if (AEBottomListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter$4.a).get(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k) != null) {
      ((AEBottomListAdapter.ViewHolder)AEBottomListAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiBottomAEBottomListAdapter$4.a).get(this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData.k)).a(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AEBottomListAdapter.4.2
 * JD-Core Version:    0.7.0.1
 */
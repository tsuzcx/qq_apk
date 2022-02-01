package com.tencent.aelight.camera.ae.camera.ui.poi;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;

class AESelectionLocationAdapter$1
  implements View.OnClickListener
{
  AESelectionLocationAdapter$1(AESelectionLocationAdapter paramAESelectionLocationAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPoiAESelectionLocationAdapter;
    AESelectionLocationAdapter.a(paramView, (AESelectionLocationAdapter.LocationData)paramView.a.get(this.jdField_a_of_type_Int));
    if (AESelectionLocationAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPoiAESelectionLocationAdapter) != null) {
      paramView = AESelectionLocationAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPoiAESelectionLocationAdapter).a;
    } else {
      paramView = "";
    }
    if (AESelectionLocationAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPoiAESelectionLocationAdapter) == null) {
      return;
    }
    AESelectionLocationAdapter.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPoiAESelectionLocationAdapter).a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.poi.AESelectionLocationAdapter.1
 * JD-Core Version:    0.7.0.1
 */
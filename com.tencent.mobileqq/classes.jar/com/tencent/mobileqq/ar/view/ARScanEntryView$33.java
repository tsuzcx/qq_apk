package com.tencent.mobileqq.ar.view;

import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

class ARScanEntryView$33
  implements TencentMap.OnCameraChangeListener
{
  ARScanEntryView$33(ARScanEntryView paramARScanEntryView) {}
  
  public void onCameraChange(CameraPosition paramCameraPosition) {}
  
  public void onCameraChangeFinished(CameraPosition paramCameraPosition)
  {
    if ((ARScanEntryView.w(this.a) != null) && (QLog.isColorLevel())) {
      QLog.d("AREngine_ARScanEntryView", 2, "ARLBSPOIDialog onCameraChangeFinish");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ARScanEntryView.33
 * JD-Core Version:    0.7.0.1
 */
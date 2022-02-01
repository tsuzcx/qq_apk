package com.tencent.aelight.camera.ae.camera.ui.watermark;

import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

class WatermarkDataManager$1
  extends LbsManagerServiceOnLocationChangeListener
{
  WatermarkDataManager$1(WatermarkDataManager paramWatermarkDataManager, String paramString, boolean paramBoolean, WatermarkDataManager.IWatermarkDictCallback paramIWatermarkDictCallback)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      if ((paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
      {
        SosoLocation localSosoLocation = paramSosoLbsInfo.mLocation;
        WatermarkDataManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager, paramSosoLbsInfo.mLocation);
        double d1 = localSosoLocation.mLat02;
        double d2 = localSosoLocation.mLon02;
        AEQLog.b("WaterMarkManager", "LbsManagerService.startLocation: success");
        WatermarkDataManager.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager, d1, d2, this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager$IWatermarkDictCallback);
        return;
      }
      AEQLog.d("WaterMarkManager", "LbsManagerService.startLocation: location is null");
      return;
    }
    AEQLog.d("WaterMarkManager", "LbsManagerService.startLocation: failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager.1
 * JD-Core Version:    0.7.0.1
 */
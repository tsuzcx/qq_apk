package com.tencent.aelight.camera.watermark.api.impl;

import com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager;
import com.tencent.aelight.camera.watermark.api.IAEWaterMarkManager;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

public class AEWaterMarkManagerImpl
  implements IAEWaterMarkManager
{
  public SosoLocation getLocation()
  {
    return WatermarkDataManager.a().a();
  }
  
  public void onConfigChange(boolean paramBoolean)
  {
    WatermarkDataManager.a().a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.watermark.api.impl.AEWaterMarkManagerImpl
 * JD-Core Version:    0.7.0.1
 */
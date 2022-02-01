package com.tencent.aelight.camera.ae.camera.ui.watermark;

import NS_COMM.COMM.StCommonExt;
import com.dataline.util.DatalineMathUtil;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.GetWatermarkDictRequest;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

public class WatermarkDataManager
{
  private static volatile WatermarkDataManager jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager;
  private final int jdField_a_of_type_Int = 60000;
  private long jdField_a_of_type_Long = 0L;
  private AEMaterialMetaData jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
  private SosoLocation jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLocation;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public static WatermarkDataManager a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager == null) {
          jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager = new WatermarkDataManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAelightCameraAeCameraUiWatermarkWatermarkDataManager;
  }
  
  private void a(double paramDouble1, double paramDouble2, WatermarkDataManager.IWatermarkDictCallback paramIWatermarkDictCallback)
  {
    long l = DatalineMathUtil.a();
    GetWatermarkDictRequest localGetWatermarkDictRequest = new GetWatermarkDictRequest(new COMM.StCommonExt(), paramDouble1, paramDouble2, String.valueOf(l));
    VSNetworkHelper.getInstance().sendRequest(localGetWatermarkDictRequest, new WatermarkDataManager.2(this, paramIWatermarkDictCallback));
  }
  
  private boolean a()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      boolean bool;
      if (l1 - l2 <= 60000L) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b(WatermarkDataManager.IWatermarkDictCallback paramIWatermarkDictCallback)
  {
    AEQLog.b("WaterMarkManager", "updateWMProps start");
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new WatermarkDataManager.1(this, "qq_story_water_mark", false, paramIWatermarkDictCallback));
  }
  
  public AEMaterialMetaData a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData;
  }
  
  public SosoLocation a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLocation;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = null;
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLocation = null;
      return;
    }
    finally {}
  }
  
  public void a(@Nonnull WatermarkDataManager.IWatermarkDictCallback paramIWatermarkDictCallback)
  {
    try
    {
      if (a())
      {
        paramIWatermarkDictCallback.onGetWatermarkDict(Collections.unmodifiableMap(this.jdField_a_of_type_JavaUtilMap));
        return;
      }
      b(paramIWatermarkDictCallback);
      return;
    }
    finally {}
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeDataAEMaterialMetaData = paramAEMaterialMetaData;
  }
  
  public void a(boolean paramBoolean)
  {
    VSConfigManager.a().a("WM_LIST_CONFIG_CHANGED", Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager
 * JD-Core Version:    0.7.0.1
 */
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
  private static volatile WatermarkDataManager b;
  private final int a = 60000;
  private AEMaterialMetaData c;
  private SosoLocation d;
  private final Map<String, String> e = new HashMap();
  private long f = 0L;
  
  public static WatermarkDataManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new WatermarkDataManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(double paramDouble1, double paramDouble2, WatermarkDataManager.IWatermarkDictCallback paramIWatermarkDictCallback)
  {
    long l = DatalineMathUtil.a();
    GetWatermarkDictRequest localGetWatermarkDictRequest = new GetWatermarkDictRequest(new COMM.StCommonExt(), paramDouble1, paramDouble2, String.valueOf(l));
    VSNetworkHelper.getInstance().sendRequest(localGetWatermarkDictRequest, new WatermarkDataManager.2(this, paramIWatermarkDictCallback));
  }
  
  private void b(WatermarkDataManager.IWatermarkDictCallback paramIWatermarkDictCallback)
  {
    AEQLog.b("WaterMarkManager", "updateWMProps start");
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new WatermarkDataManager.1(this, "qq_story_water_mark", false, paramIWatermarkDictCallback));
  }
  
  private boolean e()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.f;
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
  
  public void a(@Nonnull WatermarkDataManager.IWatermarkDictCallback paramIWatermarkDictCallback)
  {
    try
    {
      if (e())
      {
        paramIWatermarkDictCallback.onGetWatermarkDict(Collections.unmodifiableMap(this.e));
        return;
      }
      b(paramIWatermarkDictCallback);
      return;
    }
    finally {}
  }
  
  public void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.c = paramAEMaterialMetaData;
  }
  
  public void a(boolean paramBoolean)
  {
    VSConfigManager.a().b("WM_LIST_CONFIG_CHANGED", Boolean.valueOf(paramBoolean));
  }
  
  public void b()
  {
    try
    {
      this.c = null;
      this.f = 0L;
      this.e.clear();
      this.d = null;
      return;
    }
    finally {}
  }
  
  public SosoLocation c()
  {
    return this.d;
  }
  
  public AEMaterialMetaData d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkDataManager
 * JD-Core Version:    0.7.0.1
 */
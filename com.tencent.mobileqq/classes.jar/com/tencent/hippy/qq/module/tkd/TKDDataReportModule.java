package com.tencent.hippy.qq.module.tkd;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import olh;

@HippyNativeModule(name="TKDDataReportModule")
public class TKDDataReportModule
  extends HippyNativeModuleBase
{
  public TKDDataReportModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="dataReport")
  public void dataReport(HippyMap paramHippyMap)
  {
    paramHippyMap = (HippyMap)paramHippyMap.get("qq");
    olh.a(null, "dc01160", "Pb_account_lifeservice", "", paramHippyMap.getString("subAction"), paramHippyMap.getString("actionName"), 0, 0, paramHippyMap.getString("r2"), paramHippyMap.getString("r3"), paramHippyMap.getString("r4"), paramHippyMap.getString("r5"), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDDataReportModule
 * JD-Core Version:    0.7.0.1
 */
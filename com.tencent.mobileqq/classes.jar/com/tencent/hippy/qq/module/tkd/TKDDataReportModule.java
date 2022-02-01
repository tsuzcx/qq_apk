package com.tencent.hippy.qq.module.tkd;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;

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
    Object localObject = (HippyMap)paramHippyMap.get("qq");
    paramHippyMap = ((HippyMap)localObject).getString("subAction");
    String str1 = ((HippyMap)localObject).getString("actionName");
    String str2 = ((HippyMap)localObject).getString("r2");
    String str3 = ((HippyMap)localObject).getString("r3");
    String str4 = ((HippyMap)localObject).getString("r4");
    localObject = ((HippyMap)localObject).getString("r5");
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc01160", "Pb_account_lifeservice", "", paramHippyMap, str1, 0, 0, str2, str3, str4, (String)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.tkd.TKDDataReportModule
 * JD-Core Version:    0.7.0.1
 */
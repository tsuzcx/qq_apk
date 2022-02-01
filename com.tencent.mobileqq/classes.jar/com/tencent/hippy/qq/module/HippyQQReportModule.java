package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.viola.api.IQReportModule;
import com.tencent.mobileqq.kandian.biz.viola.api.IQReportModuleFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import org.json.JSONObject;

@HippyNativeModule(name="QReport")
public class HippyQQReportModule
  extends HippyNativeModuleBase
{
  static final String CLASSNAME = "QReport";
  private IQReportModule mQReportModule = ((IQReportModuleFactory)QRoute.api(IQReportModuleFactory.class)).create();
  
  public HippyQQReportModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="reportDT")
  public void reportDT(String paramString, HippyMap paramHippyMap)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramHippyMap != null) {
      paramHippyMap = paramHippyMap.toJSONObject();
    } else {
      paramHippyMap = new JSONObject();
    }
    this.mQReportModule.reportDT(paramString, paramHippyMap);
  }
  
  @HippyMethod(name="reportT")
  public void reportT(String paramString, HippyMap paramHippyMap)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramHippyMap != null) {
      paramHippyMap = paramHippyMap.toJSONObject();
    } else {
      paramHippyMap = new JSONObject();
    }
    this.mQReportModule.reportT(paramString, paramHippyMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyQQReportModule
 * JD-Core Version:    0.7.0.1
 */
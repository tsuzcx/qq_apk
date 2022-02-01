package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.QReportModule;
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
  private QReportModule mQReportModule = new QReportModule();
  
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
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mQReportModule.reportDT(paramString, paramHippyMap);
      return;
    }
  }
  
  @HippyMethod(name="reportT")
  public void reportT(String paramString, HippyMap paramHippyMap)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramHippyMap != null) {}
    for (paramHippyMap = paramHippyMap.toJSONObject();; paramHippyMap = new JSONObject())
    {
      this.mQReportModule.reportT(paramString, paramHippyMap);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.HippyQQReportModule
 * JD-Core Version:    0.7.0.1
 */
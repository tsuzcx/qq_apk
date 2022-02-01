package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkVipReport;
import com.tencent.mobileqq.ark.vipreport.ArkVipReporter;
import com.tencent.mobileqq.ark.vipreport.ArkVipSceneConfig;
import java.util.HashMap;

public class ArkVipReportImpl
  implements IArkVipReport
{
  public void addEventToScene(String paramString, boolean paramBoolean, long paramLong, HashMap<String, String> paramHashMap)
  {
    ArkVipReporter.a().a(paramString, paramBoolean, paramLong, paramHashMap);
  }
  
  public void initScene(String paramString, ArkVipSceneConfig paramArkVipSceneConfig)
  {
    ArkVipReporter.a().a(paramString, paramArkVipSceneConfig);
  }
  
  public void startSceneByEvent(String paramString, long paramLong)
  {
    ArkVipReporter.a().a(paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkVipReportImpl
 * JD-Core Version:    0.7.0.1
 */
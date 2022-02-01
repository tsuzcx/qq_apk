package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.base.ArkAppCenter;
import com.tencent.mobileqq.ark.config.ApiFrequencyConfig;
import com.tencent.mobileqq.ark.config.bean.ArkConfBean;
import com.tencent.mobileqq.ark.config.processor.ArkConfProcessor;
import java.util.List;
import java.util.Map;

public class ArkConfigImpl
  implements IArkConfig
{
  public Map<String, List<ApiFrequencyConfig>> getAPIFrequencyConfig()
  {
    return ArkAiAppCenter.d;
  }
  
  public boolean isPANonShow()
  {
    return ArkAppCenter.i();
  }
  
  public <T extends ArkConfBean> T loadConfig(Class<T> paramClass)
  {
    return ArkConfProcessor.a(paramClass);
  }
  
  public void setPANonShow(String paramString)
  {
    ArkAppCenter.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkConfigImpl
 * JD-Core Version:    0.7.0.1
 */
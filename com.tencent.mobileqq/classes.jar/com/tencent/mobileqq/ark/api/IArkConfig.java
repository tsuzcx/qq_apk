package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.ark.config.ApiFrequencyConfig;
import com.tencent.mobileqq.ark.config.bean.ArkConfBean;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.List;
import java.util.Map;

@QAPI(process={"all"})
@QRouteFactory
public abstract interface IArkConfig
  extends QRouteApi
{
  public abstract Map<String, List<ApiFrequencyConfig>> getAPIFrequencyConfig();
  
  public abstract boolean isPANonShow();
  
  public abstract <T extends ArkConfBean> T loadConfig(Class<T> paramClass);
  
  public abstract void setPANonShow(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkConfig
 * JD-Core Version:    0.7.0.1
 */
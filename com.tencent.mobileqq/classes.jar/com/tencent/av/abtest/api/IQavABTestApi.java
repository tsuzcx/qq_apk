package com.tencent.av.abtest.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.Map;

@QAPI(process={"all"})
@QRouteFactory(singleton=true)
public abstract interface IQavABTestApi
  extends QRouteApi
{
  public abstract Map<String, String> getParams();
  
  public abstract boolean isContrast();
  
  public abstract boolean isExpHit(String paramString);
  
  public abstract boolean isExpOnline();
  
  public abstract boolean isExperiment();
  
  public abstract IQavABTestApi loadExperiment(String paramString);
  
  public abstract void registerExpConfigInfo(String paramString);
  
  public abstract void reportEvent(int paramInt, String paramString);
  
  public abstract void reportExpExposure();
  
  public abstract void reportExposure(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.abtest.api.IQavABTestApi
 * JD-Core Version:    0.7.0.1
 */
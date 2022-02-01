package com.tencent.av.config.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IConfigParser
  extends QRouteApi
{
  public static final String DEFAULT_VALUE = "unknown";
  
  public abstract String getData();
  
  public abstract int getIntValue(String paramString, int paramInt);
  
  public abstract int[] getIntValues(String paramString);
  
  public abstract String getStringValue(String paramString1, String paramString2);
  
  public abstract String[] getStringValues(String paramString);
  
  public abstract boolean isEmpty();
  
  public abstract void setData(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.api.IConfigParser
 * JD-Core Version:    0.7.0.1
 */
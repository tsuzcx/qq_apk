package com.tencent.biz.pubaccount.util.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPublicAccountH5AbilityPtt
  extends QRouteApi
{
  public abstract void setLocalPathForPtt(String paramString);
  
  public abstract void setServerIdForPtt(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPtt
 * JD-Core Version:    0.7.0.1
 */
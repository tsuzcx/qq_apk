package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.ark.secure.CheckShareUrlResult;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory
public abstract interface IArkSecure
  extends QRouteApi
{
  public abstract void checkShareUrl(String paramString1, String paramString2, String paramString3, CheckShareUrlResult paramCheckShareUrlResult);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkSecure
 * JD-Core Version:    0.7.0.1
 */
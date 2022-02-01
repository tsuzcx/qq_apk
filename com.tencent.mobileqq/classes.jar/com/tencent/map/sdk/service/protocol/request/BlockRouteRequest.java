package com.tencent.map.sdk.service.protocol.request;

import com.tencent.map.sdk.a.nc.a;
import com.tencent.map.sdk.service.net.annotation.NetRequest;
import com.tencent.map.tools.net.NetMethod;

public abstract interface BlockRouteRequest
  extends nc.a
{
  @NetRequest(constQuery="iszip=true&p=sdk&pf=android", method=NetMethod.URL, path="closed_road_v2", queryKeys={"imei", "sdkversion", "nettype"})
  public abstract String getBlockRouteUrl(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.request.BlockRouteRequest
 * JD-Core Version:    0.7.0.1
 */
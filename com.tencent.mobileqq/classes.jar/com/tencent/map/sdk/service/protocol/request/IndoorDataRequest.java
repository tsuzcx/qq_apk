package com.tencent.map.sdk.service.protocol.request;

import com.tencent.map.sdk.a.nc.a;
import com.tencent.map.sdk.service.net.annotation.NetRequest;
import com.tencent.map.tools.net.NetMethod;

public abstract interface IndoorDataRequest
  extends nc.a
{
  @NetRequest(method=NetMethod.URL, path="indoormap2")
  public abstract String getIndoorMapUrl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.request.IndoorDataRequest
 * JD-Core Version:    0.7.0.1
 */
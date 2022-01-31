package com.tencent.map.sdk.service.protocol.request;

import com.tencent.map.sdk.a.nc.a;
import com.tencent.map.sdk.service.net.annotation.NetRequest;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;

public abstract interface RttDataRequest
  extends nc.a
{
  @NetRequest(method=NetMethod.POST, path="rttserverex/", userAgent="sosomap navsns")
  public abstract NetResponse rttData(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.request.RttDataRequest
 * JD-Core Version:    0.7.0.1
 */
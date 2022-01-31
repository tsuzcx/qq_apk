package com.tencent.map.sdk.service.protocol.request;

import com.tencent.map.sdk.a.nc.a;
import com.tencent.map.sdk.service.net.annotation.NetHead;
import com.tencent.map.sdk.service.net.annotation.NetRequest;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;

public abstract interface StatisticRequest
  extends nc.a
{
  @NetRequest(constQuery="channel=1&output=json&uuid=unknown", head=@NetHead(keys={"Content-Type"}, values={"application/json"}), method=NetMethod.POST, path="ditusdk/monitor", queryKeys={"key", "key2", "pid", "pid2", "hm", "suid", "os", "psv", "ver", "dpi", "pf", "nt"}, userAgent="QQ Map Mobile")
  public abstract NetResponse report(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.request.StatisticRequest
 * JD-Core Version:    0.7.0.1
 */
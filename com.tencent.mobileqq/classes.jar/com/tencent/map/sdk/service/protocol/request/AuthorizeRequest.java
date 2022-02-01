package com.tencent.map.sdk.service.protocol.request;

import com.tencent.map.sdk.a.nc.a;
import com.tencent.map.sdk.service.net.annotation.NetRequest;
import com.tencent.map.tools.net.NetMethod;
import com.tencent.map.tools.net.NetResponse;

public abstract interface AuthorizeRequest
  extends nc.a
{
  @NetRequest(constQuery="channel=1&output=json&uuid=unknown", method=NetMethod.GET, path="mkey/index.php/mkey/check", queryKeys={"key", "key2", "pid", "pid2", "hm", "suid", "os", "psv", "ver", "dpi", "pf", "nt"})
  public abstract NetResponse checkAuth(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.request.AuthorizeRequest
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.map.sdk.service.protocol.request;

import com.tencent.map.sdk.a.nc.a;
import com.tencent.map.sdk.service.net.annotation.NetRequest;
import com.tencent.map.tools.net.NetMethod;

public abstract interface SketchDataRequest
  extends nc.a
{
  @NetRequest(constQuery="styleid=7", method=NetMethod.URL, path="scenic/", queryKeys={"x", "y", "z", "version"})
  public abstract String sketchTileUrl(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.service.protocol.request.SketchDataRequest
 * JD-Core Version:    0.7.0.1
 */
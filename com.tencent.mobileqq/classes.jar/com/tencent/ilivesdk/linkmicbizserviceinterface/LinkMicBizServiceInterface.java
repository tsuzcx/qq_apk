package com.tencent.ilivesdk.linkmicbizserviceinterface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface LinkMicBizServiceInterface
  extends ServiceBaseInterface
{
  public abstract void a(long paramLong, String paramString, RequestLinkMicSigCallback paramRequestLinkMicSigCallback);
  
  public abstract void a(LinkMicBizServiceAdapter paramLinkMicBizServiceAdapter);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.linkmicbizserviceinterface.LinkMicBizServiceInterface
 * JD-Core Version:    0.7.0.1
 */
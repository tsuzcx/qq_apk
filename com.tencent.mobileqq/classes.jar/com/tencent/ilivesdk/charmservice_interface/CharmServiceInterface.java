package com.tencent.ilivesdk.charmservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.charmservice_interface.model.CharmInfoReq;

public abstract interface CharmServiceInterface
  extends ServiceBaseInterface
{
  public abstract void getCharmInfo(CharmInfoReq paramCharmInfoReq, GetCharmInfoCallback paramGetCharmInfoCallback);
  
  public abstract void init(CharmServiceAdapter paramCharmServiceAdapter);
  
  public abstract void setCharmPushCallback(CharmPushCallback paramCharmPushCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.charmservice_interface.CharmServiceInterface
 * JD-Core Version:    0.7.0.1
 */
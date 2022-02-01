package com.tencent.ilivesdk.pendantservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface PendantServiceInterface
  extends ServiceBaseInterface
{
  public abstract void addFetchPendantInfoListener(PendantServiceInterface.PendantInfoCallBack paramPendantInfoCallBack);
  
  public abstract void addPendantPushListener(long paramLong, PendantServiceInterface.PendantPushListener paramPendantPushListener);
  
  public abstract void addPendantWebPushListener(long paramLong, PendantServiceInterface.PendantWebDataCallBack paramPendantWebDataCallBack);
  
  public abstract void init(PendantServiceAdapter paramPendantServiceAdapter);
  
  public abstract void removeFetchPendantInfoListener(PendantServiceInterface.PendantInfoCallBack paramPendantInfoCallBack);
  
  public abstract void removePendantPushListener(PendantServiceInterface.PendantPushListener paramPendantPushListener);
  
  public abstract void removePendantWebPushListener(PendantServiceInterface.PendantWebDataCallBack paramPendantWebDataCallBack);
  
  public abstract void startFetchPendantInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.pendantservice_interface.PendantServiceInterface
 * JD-Core Version:    0.7.0.1
 */
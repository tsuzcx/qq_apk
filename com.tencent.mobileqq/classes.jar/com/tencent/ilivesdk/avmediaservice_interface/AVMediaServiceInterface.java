package com.tencent.ilivesdk.avmediaservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;

public abstract interface AVMediaServiceInterface
  extends ServiceBaseInterface
{
  public abstract void avInit(AvInitCallBack paramAvInitCallBack);
  
  public abstract MediaBeautyStatusInterface getMediaBeautyStatusInterface();
  
  public abstract MediaResLoadServiceInterface getMediaResLoadServiceInterface();
  
  public abstract AVMediaPreviewInterface getPreviewInterface();
  
  public abstract AVMediaRecordInterface getRecordInterface();
  
  public abstract void init(AVMediaServiceAdapter paramAVMediaServiceAdapter);
  
  public abstract void startMonitoringNetwork();
  
  public abstract void stopMonitoringNetwork();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avmediaservice_interface.AVMediaServiceInterface
 * JD-Core Version:    0.7.0.1
 */
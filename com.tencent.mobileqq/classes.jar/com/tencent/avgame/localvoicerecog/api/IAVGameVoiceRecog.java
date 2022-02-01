package com.tencent.avgame.localvoicerecog.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAVGameVoiceRecog
  extends QRouteApi
{
  public abstract boolean begin();
  
  public abstract boolean destroy();
  
  public abstract boolean end();
  
  public abstract boolean init();
  
  public abstract boolean isLocalVoiceModelReady();
  
  public abstract int recognize(byte[] paramArrayOfByte, int paramInt);
  
  public abstract boolean update(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.localvoicerecog.api.IAVGameVoiceRecog
 * JD-Core Version:    0.7.0.1
 */
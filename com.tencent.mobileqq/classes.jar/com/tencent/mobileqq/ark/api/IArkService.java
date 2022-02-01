package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.ark.IArkAppSSO;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface IArkService
  extends IRuntimeService
{
  public abstract void doURLReport(String paramString);
  
  public abstract IArkAppSSO getSSO();
  
  public abstract void reportPredownloadFirstHit(String paramString, boolean paramBoolean);
  
  public abstract void sendAppMsg(String paramString1, String paramString2, int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver);
  
  public abstract void startPreloadApp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkService
 * JD-Core Version:    0.7.0.1
 */
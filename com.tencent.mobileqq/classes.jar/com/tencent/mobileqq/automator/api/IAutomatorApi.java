package com.tencent.mobileqq.automator.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IAutomatorApi
  extends QRouteApi
{
  public abstract int getInActionLoginB();
  
  public abstract String getPREFERENCE_NAME();
  
  public abstract boolean isFirstLaunchNew();
  
  public abstract boolean isInRealActionLoginB();
  
  public abstract boolean isLogining();
  
  public abstract boolean isSyncNormalMsgFinish();
  
  public abstract boolean isSyncingMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.automator.api.IAutomatorApi
 * JD-Core Version:    0.7.0.1
 */
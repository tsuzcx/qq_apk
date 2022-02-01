package com.tencent.imcore.message.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IOnLinePushMessageProcessorService
  extends QRouteApi
{
  public abstract void changeBuddyOnline(AppInterface paramAppInterface, long paramLong);
  
  public abstract String getPhoneNumByUin(AppInterface paramAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.api.IOnLinePushMessageProcessorService
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPublicAccountProxy
  extends QRouteApi
{
  public abstract Class getImplClass(Class paramClass);
  
  public abstract String getImplName(Class paramClass);
  
  public abstract boolean isPublicAccountBrowser(Activity paramActivity);
  
  public abstract void setDataManagerAfterMsgSync();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountProxy
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.avatar.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQAvatarHandlerApi
  extends QRouteApi
{
  public abstract String getClassName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.IQQAvatarHandlerApi
 * JD-Core Version:    0.7.0.1
 */
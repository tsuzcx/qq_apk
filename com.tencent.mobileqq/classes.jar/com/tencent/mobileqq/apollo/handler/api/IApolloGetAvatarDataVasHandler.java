package com.tencent.mobileqq.apollo.handler.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IApolloGetAvatarDataVasHandler
  extends QRouteApi
{
  public abstract void getApolloAvatarData(AppInterface paramAppInterface, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.api.IApolloGetAvatarDataVasHandler
 * JD-Core Version:    0.7.0.1
 */
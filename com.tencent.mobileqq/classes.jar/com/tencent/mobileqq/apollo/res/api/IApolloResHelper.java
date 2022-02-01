package com.tencent.mobileqq.apollo.res.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IApolloResHelper
  extends QRouteApi
{
  public abstract int[] readRoleDefaultDressIds(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.IApolloResHelper
 * JD-Core Version:    0.7.0.1
 */
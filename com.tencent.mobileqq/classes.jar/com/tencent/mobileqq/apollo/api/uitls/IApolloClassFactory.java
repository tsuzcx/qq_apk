package com.tencent.mobileqq.apollo.api.uitls;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IApolloClassFactory
  extends QRouteApi
{
  public abstract Class getApolloDebugFragment();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.IApolloClassFactory
 * JD-Core Version:    0.7.0.1
 */
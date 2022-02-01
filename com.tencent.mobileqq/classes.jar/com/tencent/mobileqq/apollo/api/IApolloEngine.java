package com.tencent.mobileqq.apollo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/IApolloEngine;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkEngineReady", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface IApolloEngine
  extends QRouteApi
{
  public abstract boolean checkEngineReady();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.IApolloEngine
 * JD-Core Version:    0.7.0.1
 */
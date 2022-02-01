package com.tencent.mobileqq.apollo.aio.panel.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface ICmGamePanelProvider
  extends QRouteApi
{
  public abstract void init(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.api.ICmGamePanelProvider
 * JD-Core Version:    0.7.0.1
 */
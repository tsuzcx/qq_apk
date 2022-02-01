package com.tencent.biz.expand.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IServerTimeApi
  extends QRouteApi
{
  public abstract long getServerTime();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.api.IServerTimeApi
 * JD-Core Version:    0.7.0.1
 */
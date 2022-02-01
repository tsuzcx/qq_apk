package com.tencent.mobileqq.app.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMemoryManagerApi
  extends QRouteApi
{
  public abstract long getAvailClassSize();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.api.IMemoryManagerApi
 * JD-Core Version:    0.7.0.1
 */
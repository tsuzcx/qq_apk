package com.tencent.mobileqq.apollo.res.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IApolloQueueDownloader
  extends QRouteApi, DownloaderInterface
{
  public abstract void init(AppRuntime paramAppRuntime, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.IApolloQueueDownloader
 * JD-Core Version:    0.7.0.1
 */
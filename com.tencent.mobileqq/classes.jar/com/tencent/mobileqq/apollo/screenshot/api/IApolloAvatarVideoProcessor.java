package com.tencent.mobileqq.apollo.screenshot.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IApolloAvatarVideoProcessor
  extends QRouteApi
{
  public abstract void init(AppInterface paramAppInterface);
  
  public abstract void process(int paramInt1, int paramInt2);
  
  public abstract void setProcessFinishListener(IApolloAvatarVideoProcessor.OnProcessFinishListener paramOnProcessFinishListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.api.IApolloAvatarVideoProcessor
 * JD-Core Version:    0.7.0.1
 */
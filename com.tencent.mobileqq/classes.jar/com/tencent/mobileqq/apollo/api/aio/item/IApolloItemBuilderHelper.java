package com.tencent.mobileqq.apollo.api.aio.item;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IApolloItemBuilderHelper
  extends QRouteApi
{
  public abstract void pauseAllBrickPlayer();
  
  public abstract void releaseAllBrickPlayer();
  
  public abstract void resumeAllBrickPlayer();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.IApolloItemBuilderHelper
 * JD-Core Version:    0.7.0.1
 */
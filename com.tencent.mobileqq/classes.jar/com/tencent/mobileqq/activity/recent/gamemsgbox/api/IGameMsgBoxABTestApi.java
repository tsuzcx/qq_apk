package com.tencent.mobileqq.activity.recent.gamemsgbox.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.os.MqqHandler;

@QAPI(process={"all"})
public abstract interface IGameMsgBoxABTestApi
  extends QRouteApi
{
  public abstract boolean isGameMsgAddTab();
  
  public abstract void reportGameTabExposure(MqqHandler paramMqqHandler);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi
 * JD-Core Version:    0.7.0.1
 */
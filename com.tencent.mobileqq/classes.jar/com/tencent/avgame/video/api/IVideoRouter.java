package com.tencent.avgame.video.api;

import com.tencent.avgame.gamelogic.controller.SurvivalAssistCallback;
import com.tencent.avgame.qav.IAVGameMediaPlayerCtrl;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVideoRouter
  extends SurvivalAssistCallback, QRouteApi
{
  public abstract IAVGameMediaPlayerCtrl getAVGameMediaPlayerCtrl();
  
  public abstract void start();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.video.api.IVideoRouter
 * JD-Core Version:    0.7.0.1
 */
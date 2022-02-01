package com.tencent.avgame.localvoicerecog.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAILabVoiceRecogEngine
  extends QRouteApi
{
  public abstract float getCurSceneWordScore();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.localvoicerecog.api.IAILabVoiceRecogEngine
 * JD-Core Version:    0.7.0.1
 */
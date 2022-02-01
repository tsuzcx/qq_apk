package com.tencent.aelight.camera.qqstory.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAECaptureContext
  extends QRouteApi
{
  public abstract AppInterface getAppInterface();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IAECaptureContext
 * JD-Core Version:    0.7.0.1
 */
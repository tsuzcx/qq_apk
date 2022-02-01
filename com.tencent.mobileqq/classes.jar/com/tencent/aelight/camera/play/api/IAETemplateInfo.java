package com.tencent.aelight.camera.play.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAETemplateInfo
  extends QRouteApi
{
  public abstract void sendPickedPhotosToMe(Context paramContext, Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.play.api.IAETemplateInfo
 * JD-Core Version:    0.7.0.1
 */
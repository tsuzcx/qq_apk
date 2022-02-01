package com.tencent.gamecenter.wadl.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQQGameCommApi
  extends QRouteApi
{
  public abstract AppRuntime createAppRuntime(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.IQQGameCommApi
 * JD-Core Version:    0.7.0.1
 */
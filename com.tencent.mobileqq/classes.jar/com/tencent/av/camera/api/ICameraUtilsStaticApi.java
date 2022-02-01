package com.tencent.av.camera.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ICameraUtilsStaticApi
  extends QRouteApi
{
  public abstract ICameraManagerApi getInstance(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.api.ICameraUtilsStaticApi
 * JD-Core Version:    0.7.0.1
 */
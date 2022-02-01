package com.tencent.mobileqq.activity.qqsettingme.api;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IFaceDrawableApi
  extends QRouteApi
{
  public abstract void cancelFaceDrawable(Drawable paramDrawable1, Drawable paramDrawable2);
  
  public abstract Drawable getFaceDrawable(AppInterface paramAppInterface, String paramString, Drawable paramDrawable1, Drawable paramDrawable2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.IFaceDrawableApi
 * JD-Core Version:    0.7.0.1
 */
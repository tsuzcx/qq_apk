package com.tencent.mobileqq.activity.qqsettingme.api;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IAvatarLayoutApi
  extends QRouteApi
{
  public abstract void putAvatar(View paramView1, View paramView2, boolean paramBoolean);
  
  public abstract void setFaceDrawable(View paramView, AppInterface paramAppInterface, Drawable paramDrawable, String paramString, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.IAvatarLayoutApi
 * JD-Core Version:    0.7.0.1
 */
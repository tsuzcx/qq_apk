package com.tencent.mobileqq.activity.qqsettingme.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IThemeLabelTextViewApi
  extends QRouteApi
{
  public abstract void setSupportMaskView(View paramView, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.IThemeLabelTextViewApi
 * JD-Core Version:    0.7.0.1
 */
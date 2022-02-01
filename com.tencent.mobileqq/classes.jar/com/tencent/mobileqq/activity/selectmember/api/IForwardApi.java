package com.tencent.mobileqq.activity.selectmember.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IForwardApi
  extends QRouteApi
{
  public abstract void startGameSdkCallback(Activity paramActivity, boolean paramBoolean, String paramString1, long paramLong, int paramInt, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.api.IForwardApi
 * JD-Core Version:    0.7.0.1
 */
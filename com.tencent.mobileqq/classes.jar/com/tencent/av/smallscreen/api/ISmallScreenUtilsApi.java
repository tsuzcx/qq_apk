package com.tencent.av.smallscreen.api;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISmallScreenUtilsApi
  extends QRouteApi
{
  public abstract void actionOff(long paramLong, int paramInt, Context paramContext);
  
  public abstract void actionOn(long paramLong, int paramInt, Context paramContext, boolean paramBoolean1, String paramString, boolean paramBoolean2);
  
  public abstract int getFinishAnimId(int paramInt);
  
  public abstract boolean isLock(Context paramContext);
  
  public abstract boolean isSupportSmallScreen();
  
  public abstract boolean isSupportSmallScreenAudio();
  
  public abstract boolean isSupportSmallScreenVideo();
  
  public abstract boolean sendSmallScreenStateBroadcast(long paramLong, BaseVideoAppInterface paramBaseVideoAppInterface, int paramInt);
  
  public abstract void startSetVisibleAnimation(View paramView, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.api.ISmallScreenUtilsApi
 * JD-Core Version:    0.7.0.1
 */
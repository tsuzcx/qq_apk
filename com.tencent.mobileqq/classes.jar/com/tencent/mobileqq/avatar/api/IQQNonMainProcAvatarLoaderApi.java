package com.tencent.mobileqq.avatar.api;

import android.content.Context;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQNonMainProcAvatarLoaderApi
  extends QRouteApi
{
  public abstract INonMainProcAvatarLoader getNonMainAppHeadLoader(Context paramContext, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.smallscreen.api;

import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISmallScreenActivityPluginHelperApi
  extends QRouteApi
{
  public abstract void onPauseRender(long paramLong, BaseVideoAppInterface paramBaseVideoAppInterface, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.smallscreen.api.ISmallScreenActivityPluginHelperApi
 * JD-Core Version:    0.7.0.1
 */
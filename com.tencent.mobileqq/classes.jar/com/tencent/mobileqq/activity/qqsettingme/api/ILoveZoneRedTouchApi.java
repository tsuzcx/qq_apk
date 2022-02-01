package com.tencent.mobileqq.activity.qqsettingme.api;

import android.view.View;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;

@QAPI(process={""})
public abstract interface ILoveZoneRedTouchApi
  extends QRouteApi
{
  public abstract void setRedData(View paramView, BusinessInfoCheckUpdate.AppInfo paramAppInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.ILoveZoneRedTouchApi
 * JD-Core Version:    0.7.0.1
 */
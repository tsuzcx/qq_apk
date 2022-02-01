package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.view.View;
import com.tencent.mobileqq.activity.qqsettingme.api.ILoveZoneRedTouchApi;
import com.tencent.mobileqq.loverzone.LoveZoneTabRedDotView;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;

public class LoveZoneRedTouchApiImpl
  implements ILoveZoneRedTouchApi
{
  public void setRedData(View paramView, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    ((LoveZoneTabRedDotView)paramView).setRedDotData(paramAppInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.impl.LoveZoneRedTouchApiImpl
 * JD-Core Version:    0.7.0.1
 */
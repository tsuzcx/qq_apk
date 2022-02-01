package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;

class GrayTipsItemBuilder$1
  implements QQFileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$1(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("device_info", ((SmartDeviceProxyMgr)this.a.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).g(Long.parseLong(this.a.d.b)));
    SmartDevicePluginLoader.a().a((Activity)this.a.c, this.a.a, this.a.a.getAccount(), paramView, "com.tencent.device.activities.DeviceUnBindActivity", -1, null, SmartDevicePluginProxyActivity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */
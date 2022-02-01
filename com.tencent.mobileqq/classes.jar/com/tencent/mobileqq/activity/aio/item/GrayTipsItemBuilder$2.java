package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;

class GrayTipsItemBuilder$2
  implements QQFileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$2(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("uin", this.a.d.b);
    paramView.putExtra("uinname", this.a.d.e);
    SmartDevicePluginLoader.a().a((Activity)this.a.c, this.a.a, this.a.a.getAccount(), paramView, "com.tencent.device.activities.DeviceGroupChatConfirmActivity", -1, null, SmartDevicePluginProxyActivity.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */
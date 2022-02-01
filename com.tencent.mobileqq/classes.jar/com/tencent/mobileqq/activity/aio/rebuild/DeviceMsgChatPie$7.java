package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;

class DeviceMsgChatPie$7
  extends BroadcastReceiver
{
  DeviceMsgChatPie$7(DeviceMsgChatPie paramDeviceMsgChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null) {
      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceUnBindRst"))
      {
        paramContext = paramIntent.getExtras();
        if (paramContext == null) {
          return;
        }
        long l = paramContext.getLong("deviceopdin", 0L);
        if ((paramContext.getInt("deviceoprstcode", 0) == 0) && (Long.parseLong(this.a.ah.b) == l)) {
          this.a.L();
        }
      }
      else if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_ProductFetchRst"))
      {
        paramContext = paramIntent.getExtras();
        if (paramContext == null) {
          return;
        }
        if (paramContext.getInt("deviceoprstcode", 0) == 0) {
          this.a.bz();
        }
      }
      else
      {
        if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_receiveVasFlagResult"))
        {
          paramContext = paramIntent.getExtras();
          if (paramContext == null) {
            return;
          }
          int i = paramContext.getInt("Flag", 0);
          paramContext = (DeviceMsgHandle)this.a.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
          if (i == 1)
          {
            DeviceMsgChatPie.br = true;
            paramIntent = new StringBuilder();
            paramIntent.append(this.a.d.getApp().getString(2131888766));
            paramIntent.append(this.a.d.getApp().getString(2131888498));
            paramIntent = paramIntent.toString();
            paramContext.a(this.a.ah.b, paramIntent, MessageCache.c(), true, false, 0);
            return;
          }
          DeviceMsgChatPie.br = false;
          paramIntent = new StringBuilder();
          paramIntent.append(this.a.d.getApp().getString(2131888766));
          paramIntent.append(this.a.d.getApp().getString(2131888497));
          paramIntent.append(this.a.d.getApp().getString(2131888480));
          paramIntent = paramIntent.toString();
          paramContext.a(this.a.ah.b, paramIntent, MessageCache.c(), true, false, 2);
          return;
        }
        if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnDataPointFileMsgProgress"))
        {
          DeviceMsgChatPie.a(this.a, paramIntent);
          return;
        }
        if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnDataPointFileMsgSendRet")) {
          DeviceMsgChatPie.b(this.a, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.7
 * JD-Core Version:    0.7.0.1
 */
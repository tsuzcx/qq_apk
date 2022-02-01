package com.tencent.device.devicemgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.utils.LightAppUtil;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Arrays;
import mqq.os.MqqHandler;

class SmartDeviceProxyMgr$BroadcastHandler
  extends BroadcastReceiver
{
  SmartDeviceProxyMgr$BroadcastHandler(SmartDeviceProxyMgr paramSmartDeviceProxyMgr) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!paramIntent.getAction().equalsIgnoreCase("SmartDevice_devListChang")) && (!paramIntent.getAction().equalsIgnoreCase("onDeviceDisconnected")) && (!paramIntent.getAction().equalsIgnoreCase("onDeviceLogined")))
    {
      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_devListChangeUI"))
      {
        paramContext = this.a.a();
        paramIntent = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DeviceList @@ cache receivechange for ui list:");
        localStringBuilder.append(paramContext);
        SmartDeviceProxyMgr.a(paramIntent, localStringBuilder.toString());
        if (paramContext != null) {
          this.a.notifyUI(1, true, new ArrayList(Arrays.asList(paramContext)));
        }
      }
      else
      {
        int i;
        if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_login"))
        {
          i = paramIntent.getExtras().getInt("logincode");
          paramContext = this.a;
          paramIntent = new StringBuilder();
          paramIntent.append("SmartDeviceProxyMgr::receive qq login broadcast!!!resultCode = ");
          paramIntent.append(i);
          SmartDeviceProxyMgr.a(paramContext, paramIntent.toString());
          SettingCloneUtil.writeValue(SmartDeviceProxyMgr.a(this.a).getApp(), SmartDeviceProxyMgr.a(this.a).getCurrentAccountUin(), null, "account_login_success_time", String.valueOf(MessageCache.a()));
          if (i == 0)
          {
            this.a.jdField_a_of_type_Int = 2;
            return;
          }
          this.a.jdField_a_of_type_Int = 3;
          return;
        }
        if ((!paramIntent.getAction().equalsIgnoreCase("mqq.intent.action.LOGOUT")) && (!paramIntent.getAction().equalsIgnoreCase("mqq.intent.action.ACCOUNT_CHANGED")))
        {
          boolean bool = paramIntent.getAction().equalsIgnoreCase("SmartDevice_clickOnDeviceList");
          i = 0;
          if (bool)
          {
            if (this.a.a())
            {
              this.a.b(false);
              this.a.e();
            }
            SmartDeviceReport.a(null, "Usr_Click_MyDevice", 0, 0, 0);
            return;
          }
          long l;
          if (paramIntent.getAction().equalsIgnoreCase("onQFindLostDeviceList"))
          {
            if (paramIntent.getExtras().getInt("qfind_result", 1) == 0)
            {
              this.a.jdField_a_of_type_JavaUtilArrayList.clear();
              paramContext = paramIntent.getExtras().getLongArray("qfind_dins");
              int j = paramContext.length;
              while (i < j)
              {
                l = paramContext[i];
                this.a.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(l));
                i += 1;
              }
              paramContext = this.a.a();
              if (paramContext != null) {
                this.a.notifyUI(1, true, new ArrayList(Arrays.asList(paramContext)));
              }
            }
          }
          else
          {
            if (paramIntent.getAction().equals("SmartDevice_receiveDPMsg")) {
              return;
            }
            if ((paramIntent.getAction().equals("SmartDevice_DeviceBindRst")) && (paramIntent.getExtras().getInt("deviceoprstcode") == 0))
            {
              SmartDeviceProxyMgr.a(this.a, 1);
              SettingCloneUtil.writeValueForInt(BaseApplication.getContext(), SmartDeviceProxyMgr.a(this.a).getCurrentAccountUin(), null, "qqsetting_deviceplugin_bind_flag", SmartDeviceProxyMgr.a(this.a));
              l = paramIntent.getExtras().getLong("deviceopdin", 0L);
              paramContext = this.a.a(l);
              if ((paramContext != null) && (paramContext.productId >= 2000000000L) && (paramContext.productId < 3000000000L)) {
                this.a.a(l);
              }
            }
          }
        }
        else
        {
          if (this.a.a())
          {
            SmartDeviceProxyMgr.a(this.a, "SmartDeviceProxyMgr::receive qq logout broadcast!!!");
            this.a.d();
          }
          LightAppUtil.c();
        }
      }
    }
    else
    {
      SmartDeviceProxyMgr.a(this.a).sendEmptyMessage(1003);
      new LightAppUtil().a();
      this.a.b = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.devicemgr.SmartDeviceProxyMgr.BroadcastHandler
 * JD-Core Version:    0.7.0.1
 */
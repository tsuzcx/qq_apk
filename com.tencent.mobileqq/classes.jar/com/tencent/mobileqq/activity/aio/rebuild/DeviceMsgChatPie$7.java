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
    if (paramIntent != null)
    {
      if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_DeviceUnBindRst")) {
        break label72;
      }
      paramContext = paramIntent.getExtras();
      if (paramContext != null) {
        break label26;
      }
    }
    label26:
    label72:
    do
    {
      do
      {
        do
        {
          long l;
          do
          {
            return;
            l = paramContext.getLong("deviceopdin", 0L);
          } while ((paramContext.getInt("deviceoprstcode", 0) != 0) || (Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) != l));
          this.a.K();
          return;
          if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_ProductFetchRst")) {
            break;
          }
          paramContext = paramIntent.getExtras();
        } while ((paramContext == null) || (paramContext.getInt("deviceoprstcode", 0) != 0));
        this.a.a();
        return;
        if (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_receiveVasFlagResult")) {
          break;
        }
        paramContext = paramIntent.getExtras();
      } while (paramContext == null);
      int i = paramContext.getInt("Flag", 0);
      paramContext = (DeviceMsgHandle)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
      if (i == 1)
      {
        DeviceMsgChatPie.R = true;
        paramIntent = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691882) + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691614);
        paramContext.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramIntent, MessageCache.a(), true, false, 0);
        return;
      }
      DeviceMsgChatPie.R = false;
      paramIntent = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691882) + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691613) + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691596);
      paramContext.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramIntent, MessageCache.a(), true, false, 2);
      return;
      if (paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnDataPointFileMsgProgress"))
      {
        DeviceMsgChatPie.a(this.a, paramIntent);
        return;
      }
    } while (!paramIntent.getAction().equalsIgnoreCase("SmartDevice_OnDataPointFileMsgSendRet"));
    DeviceMsgChatPie.b(this.a, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.7
 * JD-Core Version:    0.7.0.1
 */
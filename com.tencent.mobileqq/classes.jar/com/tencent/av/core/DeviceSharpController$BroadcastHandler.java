package com.tencent.av.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.avcore.netchannel.AbstractNetChannel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class DeviceSharpController$BroadcastHandler
  extends BroadcastReceiver
{
  DeviceSharpController$BroadcastHandler(DeviceSharpController paramDeviceSharpController) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equalsIgnoreCase(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getSmartDeviceReceiveSharpMsg()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(DeviceSharpController.jdField_a_of_type_JavaLangString, 2, "recv broadcast : smartdevice receive sharp msg");
      }
      paramContext = paramIntent.getBundleExtra("msgData");
      if (paramContext != null)
      {
        paramContext = paramContext.getByteArray("value");
        if (paramContext != null) {
          this.a.jdField_a_of_type_ComTencentAvcoreNetchannelAbstractNetChannel.receiveSharpVideoCall(0L, paramContext, null);
        }
      }
    }
    else if (paramIntent.getAction().equalsIgnoreCase(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getSmartDeviceReceiveSharpAckMsg()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(DeviceSharpController.jdField_a_of_type_JavaLangString, 2, "recv broadcast : smartdevice receive sharp ack msg");
      }
      if (paramIntent.getBooleanExtra("timeout", false))
      {
        if (QLog.isColorLevel()) {
          QLog.d(DeviceSharpController.jdField_a_of_type_JavaLangString, 2, "recv broadcast : smartdevice receive sharp timeout msg");
        }
      }
      else
      {
        paramContext = paramIntent.getBundleExtra("msgData");
        if (paramContext != null)
        {
          paramContext = paramContext.getByteArray("value");
          if (paramContext != null) {
            this.a.jdField_a_of_type_ComTencentAvcoreNetchannelAbstractNetChannel.receiveSharpVideoAck(0L, paramContext, null);
          }
        }
      }
    }
    else if (paramIntent.getAction().equals(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getDeviceUnBindRst()))
    {
      paramContext = paramIntent.getExtras();
      if (paramContext == null) {
        return;
      }
      ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).deviceExitVideoProcess(this.a.jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.core.DeviceSharpController.BroadcastHandler
 * JD-Core Version:    0.7.0.1
 */
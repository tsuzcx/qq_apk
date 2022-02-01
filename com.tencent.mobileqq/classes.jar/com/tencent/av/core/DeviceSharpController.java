package com.tencent.av.core;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.av.temp.IExternalUtilsApi;
import com.tencent.avcore.netchannel.AbstractNetChannel;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class DeviceSharpController
{
  static String a = "smartdevice::sharp";
  BaseVideoAppInterface b;
  AbstractNetChannel c;
  DeviceSharpController.BroadcastHandler d;
  
  public DeviceSharpController(AbstractNetChannel paramAbstractNetChannel, BaseVideoAppInterface paramBaseVideoAppInterface)
  {
    this.c = paramAbstractNetChannel;
    this.b = paramBaseVideoAppInterface;
    this.d = new DeviceSharpController.BroadcastHandler(this);
    paramAbstractNetChannel = new IntentFilter();
    paramAbstractNetChannel.addAction(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getSmartDeviceReceiveSharpMsg());
    paramAbstractNetChannel.addAction(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getSmartDeviceReceiveSharpAckMsg());
    paramAbstractNetChannel.addAction(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getDeviceUnBindRst());
    this.b.getApp().registerReceiver(this.d, paramAbstractNetChannel, ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getBroadcastPermission(), null);
  }
  
  void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "send broadcast : smartdevice send sharp msg");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("size", paramArrayOfByte.length);
    localBundle.putLong("uin", paramLong);
    localBundle.putByteArray("value", paramArrayOfByte);
    paramArrayOfByte = new Intent();
    paramArrayOfByte.putExtra("msgData", localBundle);
    paramArrayOfByte.setAction(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getSmartDeviceSendSharpMsg());
    this.b.getApp().sendBroadcast(paramArrayOfByte, ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getBroadcastPermission());
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    a(paramArrayOfByte, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.core.DeviceSharpController
 * JD-Core Version:    0.7.0.1
 */
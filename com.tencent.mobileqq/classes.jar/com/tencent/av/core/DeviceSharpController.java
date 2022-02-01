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
  static String jdField_a_of_type_JavaLangString = "smartdevice::sharp";
  DeviceSharpController.BroadcastHandler jdField_a_of_type_ComTencentAvCoreDeviceSharpController$BroadcastHandler;
  AbstractNetChannel jdField_a_of_type_ComTencentAvcoreNetchannelAbstractNetChannel;
  BaseVideoAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface;
  
  public DeviceSharpController(AbstractNetChannel paramAbstractNetChannel, BaseVideoAppInterface paramBaseVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvcoreNetchannelAbstractNetChannel = paramAbstractNetChannel;
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface = paramBaseVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController$BroadcastHandler = new DeviceSharpController.BroadcastHandler(this);
    paramAbstractNetChannel = new IntentFilter();
    paramAbstractNetChannel.addAction(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getSmartDeviceReceiveSharpMsg());
    paramAbstractNetChannel.addAction(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getSmartDeviceReceiveSharpAckMsg());
    paramAbstractNetChannel.addAction(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getDeviceUnBindRst());
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface.getApp().registerReceiver(this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController$BroadcastHandler, paramAbstractNetChannel, ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getBroadcastPermission(), null);
  }
  
  void a(byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "send broadcast : smartdevice send sharp msg");
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("size", paramArrayOfByte.length);
    localBundle.putLong("uin", paramLong);
    localBundle.putByteArray("value", paramArrayOfByte);
    paramArrayOfByte = new Intent();
    paramArrayOfByte.putExtra("msgData", localBundle);
    paramArrayOfByte.setAction(((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getSmartDeviceSendSharpMsg());
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseVideoAppInterface.getApp().sendBroadcast(paramArrayOfByte, ((IExternalUtilsApi)QRoute.api(IExternalUtilsApi.class)).getBroadcastPermission());
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
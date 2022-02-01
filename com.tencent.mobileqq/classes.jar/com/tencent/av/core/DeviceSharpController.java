package com.tencent.av.core;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.netchannel.AbstractNetChannel;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class DeviceSharpController
{
  static String jdField_a_of_type_JavaLangString = "smartdevice::sharp";
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  DeviceSharpController.BroadcastHandler jdField_a_of_type_ComTencentAvCoreDeviceSharpController$BroadcastHandler = null;
  AbstractNetChannel jdField_a_of_type_ComTencentAvcoreNetchannelAbstractNetChannel = null;
  
  public DeviceSharpController(AbstractNetChannel paramAbstractNetChannel, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvcoreNetchannelAbstractNetChannel = paramAbstractNetChannel;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController$BroadcastHandler = new DeviceSharpController.BroadcastHandler(this);
    paramAbstractNetChannel = new IntentFilter();
    paramAbstractNetChannel.addAction("SmartDevice_ReceiveSharpMsg");
    paramAbstractNetChannel.addAction("SmartDevice_ReceiveSharpAckMsg");
    paramAbstractNetChannel.addAction("SmartDevice_DeviceUnBindRst");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().registerReceiver(this.jdField_a_of_type_ComTencentAvCoreDeviceSharpController$BroadcastHandler, paramAbstractNetChannel, "com.tencent.smartdevice.permission.broadcast", null);
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
    paramArrayOfByte.setAction("SmartDevice_SendSharpMsg");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().sendBroadcast(paramArrayOfByte, "com.tencent.smartdevice.permission.broadcast");
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    a(paramArrayOfByte, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.core.DeviceSharpController
 * JD-Core Version:    0.7.0.1
 */
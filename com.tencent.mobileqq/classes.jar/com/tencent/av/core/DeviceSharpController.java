package com.tencent.av.core;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import jhj;

public class DeviceSharpController
{
  public static String a;
  public VideoAppInterface a;
  public AbstractNetChannel a;
  jhj a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "smartdevice::sharp";
  }
  
  public DeviceSharpController(AbstractNetChannel paramAbstractNetChannel, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvCoreAbstractNetChannel = null;
    this.jdField_a_of_type_Jhj = null;
    this.jdField_a_of_type_ComTencentAvCoreAbstractNetChannel = paramAbstractNetChannel;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Jhj = new jhj(this);
    paramAbstractNetChannel = new IntentFilter();
    paramAbstractNetChannel.addAction("SmartDevice_ReceiveSharpMsg");
    paramAbstractNetChannel.addAction("SmartDevice_ReceiveSharpAckMsg");
    paramAbstractNetChannel.addAction("SmartDevice_DeviceUnBindRst");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().registerReceiver(this.jdField_a_of_type_Jhj, paramAbstractNetChannel, "com.tencent.smartdevice.permission.broadcast", null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.core.DeviceSharpController
 * JD-Core Version:    0.7.0.1
 */
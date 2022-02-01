package com.tencent.device.ble;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class JNIEngineLite
{
  private static final String TAG = "QFindBLEJNI";
  
  static
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLEJNI", 2, "QFind load blesdk");
    }
    try
    {
      System.loadLibrary("blesdklite");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
    }
  }
  
  public static native int bleReceived(int paramInt, byte[] paramArrayOfByte);
  
  public static native void disconnectBle(int paramInt);
  
  static void getProperty(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("onDeviceGetProperty");
    Bundle localBundle = new Bundle();
    localBundle.putInt("bleId", paramInt1);
    localBundle.putInt("seqNo", paramInt2);
    localBundle.putInt("propId", paramInt3);
    localBundle.putByteArray("propValue", paramArrayOfByte);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  static void nativeLog(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.i("QFindBLEJNI", 2, paramString);
        return;
      } while (!QLog.isColorLevel());
      QLog.w("QFindBLEJNI", 2, paramString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("QFindBLEJNI", 2, paramString);
  }
  
  static void onBindReq(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLEJNI", 2, "begin JNIEngine onBindReq");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("onDeviceBindReq");
    Bundle localBundle = new Bundle();
    localBundle.putInt("bleId", paramInt);
    localBundle.putByteArray("license", paramArrayOfByte);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  static void onHandshakeReq(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("onDeviceHandshakeReq");
    Bundle localBundle = new Bundle();
    localBundle.putInt("bleId", paramInt);
    localBundle.putByteArray("buffer", paramArrayOfByte1);
    localBundle.putByteArray("puk", paramArrayOfByte2);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  static void onVerifyRsp(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLEJNI", 2, "begin JNIEngine onVerifyRsp");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("onDeviceVerifyRsp");
    Bundle localBundle = new Bundle();
    localBundle.putInt("bleId", paramInt);
    localBundle.putByteArray("buffer", paramArrayOfByte);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  public static native byte[] packBindRsp(int paramInt1, int paramInt2, int paramInt3, long paramLong);
  
  public static native byte[] packCommonHandshakeWait(int paramInt1, int paramInt2);
  
  public static native byte[] packGetProperty(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  public static native byte[] packHandshakeRsp(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  public static native byte[] packHandshakeWait(int paramInt);
  
  public static native byte[] packPostResult(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte);
  
  public static native byte[] packQuickHandshakeWait(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native byte[] packSetProperty(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte);
  
  public static native byte[] packVerifyReq(int paramInt);
  
  static void postResult(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("onDevicePostResult");
    Bundle localBundle = new Bundle();
    localBundle.putInt("bleId", paramInt1);
    localBundle.putInt("retCode", paramInt2);
    localBundle.putInt("seqNo", paramInt3);
    localBundle.putInt("propId", paramInt4);
    localBundle.putInt("errCode", paramInt5);
    localBundle.putByteArray("msg", paramArrayOfByte);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  public static native void setLogined(int paramInt, boolean paramBoolean);
  
  static void setProperty(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("onDeviceSetProperty");
    Bundle localBundle = new Bundle();
    localBundle.putInt("bleId", paramInt1);
    localBundle.putInt("seqNo", paramInt2);
    localBundle.putInt("propId", paramInt3);
    localBundle.putByteArray("propValue", paramArrayOfByte);
    localIntent.putExtras(localBundle);
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  public static native void setSafe(int paramInt, boolean paramBoolean);
  
  public static native int setSkey(int paramInt, byte[] paramArrayOfByte);
  
  public static native byte[] teaDecrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native byte[] teaEncrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.ble.JNIEngineLite
 * JD-Core Version:    0.7.0.1
 */
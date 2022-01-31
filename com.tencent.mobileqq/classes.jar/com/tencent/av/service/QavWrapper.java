package com.tencent.av.service;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;
import joe;

public class QavWrapper
{
  Context jdField_a_of_type_AndroidContentContext = null;
  public IAVServiceForQQ a;
  public QavWrapper.OnReadyListener a;
  joe jdField_a_of_type_Joe = new joe(this);
  
  public QavWrapper(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ = null;
    this.jdField_a_of_type_ComTencentAvServiceQavWrapper$OnReadyListener = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return 0;
      try
      {
        paramInt = this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a(paramLong, paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", localRemoteException);
    return 0;
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return null;
      try
      {
        paramArrayOfByte = this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a(paramArrayOfByte);
        return paramArrayOfByte;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "processQCallPush RemoteException", paramArrayOfByte);
    return null;
  }
  
  public void a()
  {
    b(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentAvServiceQavWrapper$OnReadyListener = null;
  }
  
  public void a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null)
    {
      Intent localIntent = new Intent(paramContext, AVServiceForQQ.class);
      boolean bool = paramContext.getApplicationContext().bindService(localIntent, this.jdField_a_of_type_Joe, 1);
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "bindService result == " + bool);
      }
    }
  }
  
  public void a(QavWrapper.OnReadyListener paramOnReadyListener)
  {
    this.jdField_a_of_type_ComTencentAvServiceQavWrapper$OnReadyListener = paramOnReadyListener;
    a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a(paramString);
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "onGetQCallNickName RemoteException", paramString);
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a(paramString, paramBitmap);
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "pushStrangeFace RemoteException", paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
  }
  
  public void b(Context paramContext)
  {
    paramContext.getApplicationContext().unbindService(this.jdField_a_of_type_Joe);
    this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ = null;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
    }
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.c(paramArrayOfByte);
        return;
      }
      catch (RemoteException paramArrayOfByte) {}
    } while (!QLog.isColorLevel());
    QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.service.QavWrapper
 * JD-Core Version:    0.7.0.1
 */
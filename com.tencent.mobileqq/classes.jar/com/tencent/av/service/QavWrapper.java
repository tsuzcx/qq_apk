package com.tencent.av.service;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

public class QavWrapper
{
  Context jdField_a_of_type_AndroidContentContext = null;
  IAVServiceForQQ jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ = null;
  QavWrapper.OnReadyListener jdField_a_of_type_ComTencentAvServiceQavWrapper$OnReadyListener = null;
  QavWrapper.QavServiceConnection jdField_a_of_type_ComTencentAvServiceQavWrapper$QavServiceConnection = new QavWrapper.QavServiceConnection(this);
  
  public QavWrapper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public AVPbInfo a(byte[] paramArrayOfByte)
  {
    IAVServiceForQQ localIAVServiceForQQ = this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ;
    if (localIAVServiceForQQ == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
      return null;
    }
    try
    {
      paramArrayOfByte = localIAVServiceForQQ.a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (RemoteException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "processQCallPush RemoteException", paramArrayOfByte);
      }
    }
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
      boolean bool = paramContext.getApplicationContext().bindService(localIntent, this.jdField_a_of_type_ComTencentAvServiceQavWrapper$QavServiceConnection, 1);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("bindService result == ");
        paramContext.append(bool);
        QLog.d("QavWrapper", 2, paramContext.toString());
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
    IAVServiceForQQ localIAVServiceForQQ = this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ;
    if (localIAVServiceForQQ == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
      return;
    }
    try
    {
      localIAVServiceForQQ.a(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "onGetQCallNickName RemoteException", paramString);
      }
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    IAVServiceForQQ localIAVServiceForQQ = this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ;
    if (localIAVServiceForQQ == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
      return;
    }
    try
    {
      localIAVServiceForQQ.a(paramString, paramBitmap);
      return;
    }
    catch (RemoteException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "pushStrangeFace RemoteException", paramString);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    IAVServiceForQQ localIAVServiceForQQ = this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ;
    if (localIAVServiceForQQ == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
      return;
    }
    try
    {
      localIAVServiceForQQ.a(paramArrayOfByte);
      return;
    }
    catch (RemoteException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
      }
    }
  }
  
  public void b(Context paramContext)
  {
    paramContext.getApplicationContext().unbindService(this.jdField_a_of_type_ComTencentAvServiceQavWrapper$QavServiceConnection);
    this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ = null;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    IAVServiceForQQ localIAVServiceForQQ = this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ;
    if (localIAVServiceForQQ == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
      return;
    }
    try
    {
      localIAVServiceForQQ.c(paramArrayOfByte);
      return;
    }
    catch (RemoteException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "RemoteException", paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QavWrapper
 * JD-Core Version:    0.7.0.1
 */
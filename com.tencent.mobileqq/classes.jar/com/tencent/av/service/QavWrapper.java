package com.tencent.av.service;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.RemoteException;
import com.tencent.qphone.base.util.QLog;

public class QavWrapper
{
  IAVServiceForQQ a = null;
  Context b = null;
  QavWrapper.OnReadyListener c = null;
  QavWrapper.QavServiceConnection d = new QavWrapper.QavServiceConnection(this);
  
  public QavWrapper(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public void a()
  {
    b(this.b);
    this.c = null;
  }
  
  public void a(Context paramContext)
  {
    if (this.a == null)
    {
      Intent localIntent = new Intent(paramContext, AVServiceForQQ.class);
      boolean bool = paramContext.getApplicationContext().bindService(localIntent, this.d, 1);
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
    this.c = paramOnReadyListener;
    a(this.b);
  }
  
  public void a(String paramString)
  {
    IAVServiceForQQ localIAVServiceForQQ = this.a;
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
    IAVServiceForQQ localIAVServiceForQQ = this.a;
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
    IAVServiceForQQ localIAVServiceForQQ = this.a;
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
    paramContext.getApplicationContext().unbindService(this.d);
    this.a = null;
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    IAVServiceForQQ localIAVServiceForQQ = this.a;
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
  
  public AVPbInfo c(byte[] paramArrayOfByte)
  {
    IAVServiceForQQ localIAVServiceForQQ = this.a;
    if (localIAVServiceForQQ == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavWrapper", 2, "mQavProxy == null");
      }
      return null;
    }
    try
    {
      paramArrayOfByte = localIAVServiceForQQ.d(paramArrayOfByte);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.service.QavWrapper
 * JD-Core Version:    0.7.0.1
 */
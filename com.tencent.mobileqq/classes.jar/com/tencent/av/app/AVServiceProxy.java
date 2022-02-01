package com.tencent.av.app;

import android.app.Application;
import android.app.Notification;
import android.content.Intent;
import android.os.RemoteException;
import com.tencent.av.AVLog;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.IAVServiceForQQ;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class AVServiceProxy
{
  private static String jdField_a_of_type_JavaLangString = "AVServiceProxy";
  protected AVServiceProxy.AVServiceForQQConnection a;
  protected VideoAppInterface a;
  protected IAVServiceForQQ a;
  private boolean jdField_a_of_type_Boolean = true;
  
  public AVServiceProxy(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ = null;
    this.jdField_a_of_type_ComTencentAvAppAVServiceProxy$AVServiceForQQConnection = null;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  protected void a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), AVServiceForQQ.class);
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().startService(localIntent);
      this.jdField_a_of_type_ComTencentAvAppAVServiceProxy$AVServiceForQQConnection = new AVServiceProxy.AVServiceForQQConnection(this);
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().bindService(localIntent, this.jdField_a_of_type_ComTencentAvAppAVServiceProxy$AVServiceForQQConnection, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        AVLog.printErrorLog(jdField_a_of_type_JavaLangString, "bindService " + localThrowable.getMessage());
      }
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("setAVServiceForegroud start=%s mAvService=%s", new Object[] { Boolean.valueOf(paramBoolean), this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ }));
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ != null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a(paramBoolean, paramNotification);
        this.jdField_a_of_type_Boolean = paramBoolean;
        return;
      }
      catch (RemoteException paramNotification)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud fail.", paramNotification);
        continue;
      }
      catch (Throwable paramNotification)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud fail.", paramNotification);
        continue;
      }
      try
      {
        MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication();
        Intent localIntent = new Intent(localMobileQQ, AVServiceForQQ.class);
        localIntent.putExtra("setForeground", true);
        localIntent.putExtra("foreground", paramBoolean);
        localIntent.putExtra("notification", paramNotification);
        localMobileQQ.startService(localIntent);
      }
      catch (Throwable paramNotification)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud fail.", paramNotification);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), AVServiceForQQ.class);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().stopService(localIntent);
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unbindService(this.jdField_a_of_type_ComTencentAvAppAVServiceProxy$AVServiceForQQConnection);
      return;
    }
    catch (Exception localException)
    {
      AVLog.printErrorLog(jdField_a_of_type_JavaLangString, "disconnect msg = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.AVServiceProxy
 * JD-Core Version:    0.7.0.1
 */
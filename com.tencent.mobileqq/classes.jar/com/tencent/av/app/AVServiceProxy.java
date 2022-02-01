package com.tencent.av.app;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
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
    }
    catch (Throwable localThrowable)
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bindService ");
      localStringBuilder.append(localThrowable.getMessage());
      AVLog.printErrorLog(str, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvAppAVServiceProxy$AVServiceForQQConnection = new AVServiceProxy.AVServiceForQQConnection(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().bindService(localIntent, this.jdField_a_of_type_ComTencentAvAppAVServiceProxy$AVServiceForQQConnection, 1);
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("setAVServiceForegroud start=%s mAvService=%s", new Object[] { Boolean.valueOf(paramBoolean), this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ }));
    Object localObject = this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ;
    if (localObject != null) {
      try
      {
        ((IAVServiceForQQ)localObject).a(paramBoolean, paramNotification);
      }
      catch (Throwable paramNotification)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud fail.", paramNotification);
      }
      catch (RemoteException paramNotification)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud fail.", paramNotification);
      }
    } else {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication();
        Intent localIntent = new Intent((Context)localObject, AVServiceForQQ.class);
        localIntent.putExtra("setForeground", true);
        localIntent.putExtra("foreground", paramBoolean);
        localIntent.putExtra("notification", paramNotification);
        ((Application)localObject).startService(localIntent);
      }
      catch (Throwable paramNotification)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud fail.", paramNotification);
      }
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), AVServiceForQQ.class);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().stopService(localIntent);
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ != null) {
      try
      {
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unbindService(this.jdField_a_of_type_ComTencentAvAppAVServiceProxy$AVServiceForQQConnection);
        return;
      }
      catch (Exception localException)
      {
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("disconnect msg = ");
        localStringBuilder.append(localException.getMessage());
        AVLog.printErrorLog(str, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.AVServiceProxy
 * JD-Core Version:    0.7.0.1
 */
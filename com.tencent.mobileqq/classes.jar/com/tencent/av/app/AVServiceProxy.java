package com.tencent.av.app;

import android.app.Notification;
import android.content.Intent;
import android.os.RemoteException;
import com.tencent.av.AVLog;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.IAVServiceForQQ;
import com.tencent.qphone.base.util.QLog;
import jeq;
import mqq.app.MobileQQ;

public class AVServiceProxy
{
  private static String jdField_a_of_type_JavaLangString = "AVServiceProxy";
  protected VideoAppInterface a;
  public IAVServiceForQQ a;
  protected jeq a;
  private boolean jdField_a_of_type_Boolean = true;
  
  public AVServiceProxy(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  protected void a()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication(), AVServiceForQQ.class);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().startService(localIntent);
    this.jdField_a_of_type_Jeq = new jeq(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().bindService(localIntent, this.jdField_a_of_type_Jeq, 1);
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ != null) {}
    try
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "avideo setAVServiceForegroud, start=" + paramBoolean);
      this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a(paramBoolean, paramNotification);
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
    catch (RemoteException paramNotification)
    {
      for (;;)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud, e = " + paramNotification);
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
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unbindService(this.jdField_a_of_type_Jeq);
      return;
    }
    catch (Exception localException)
    {
      AVLog.e(jdField_a_of_type_JavaLangString, "unbindService msg = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.app.AVServiceProxy
 * JD-Core Version:    0.7.0.1
 */
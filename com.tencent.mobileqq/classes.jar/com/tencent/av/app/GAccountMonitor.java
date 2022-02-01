package com.tencent.av.app;

import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class GAccountMonitor
{
  public static String a = "AccountReceiver";
  GAccountMonitor.AccountReceiver jdField_a_of_type_ComTencentAvAppGAccountMonitor$AccountReceiver;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  boolean jdField_a_of_type_Boolean = false;
  
  public GAccountMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_ComTencentAvAppGAccountMonitor$AccountReceiver = new GAccountMonitor.AccountReceiver(paramVideoAppInterface);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentAvAppGAccountMonitor$AccountReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "regist QQ Account Receiver, Declare permissions");
    }
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mqq.intent.action.EXIT_");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getPackageName());
    localIntentFilter.addAction(localStringBuilder.toString());
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("tencent.video.q2v.membersChange");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentAvAppGAccountMonitor$AccountReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null) != null) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GAccountMonitor
 * JD-Core Version:    0.7.0.1
 */
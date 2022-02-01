package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QAVNotifyActionMonitor
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  QAVNotifyActionMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new QAVNotifyActionMonitor.QAVNotifyActionReceiver(paramVideoAppInterface, null);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.qav.notify.accept");
    localIntentFilter.addAction("com.tencent.qav.notify.refuse");
    localIntentFilter.addAction("tencent.video.q2v.ptusoDownloadRet");
    localIntentFilter.addAction("tencent.video.q2v.avReceivePushMsg");
    localIntentFilter.addAction("com.tencent.qqhead.getheadresp2");
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotifyActionMonitor", 2, "register");
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotifyActionMonitor", 2, "unRegister");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.QAVNotifyActionMonitor
 * JD-Core Version:    0.7.0.1
 */
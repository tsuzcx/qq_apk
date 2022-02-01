package com.tencent.av.app;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GVipFunCallMonitor
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  
  public GVipFunCallMonitor(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new GVipFunCallMonitor.VipFunCallReceiver(this);
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.q2v.MultiVideo");
    localIntentFilter.addAction("tencent.video.q2v.AnnimateDownloadFinish");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter) != null) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GVipFunCallMonitor", 2, "regist vipFunCall " + this.jdField_a_of_type_Boolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.GVipFunCallMonitor
 * JD-Core Version:    0.7.0.1
 */
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
    Object localObject = new IntentFilter("tencent.video.q2v.MultiVideo");
    ((IntentFilter)localObject).addAction("tencent.video.q2v.AnnimateDownloadFinish");
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject) != null) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("regist vipFunCall ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("GVipFunCallMonitor", 2, ((StringBuilder)localObject).toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.GVipFunCallMonitor
 * JD-Core Version:    0.7.0.1
 */
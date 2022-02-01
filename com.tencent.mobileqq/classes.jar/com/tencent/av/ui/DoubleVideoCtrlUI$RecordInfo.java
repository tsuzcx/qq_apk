package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$RecordInfo
{
  private int jdField_a_of_type_Int = 0;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  private AVActivity jdField_a_of_type_ComTencentAvUiAVActivity = null;
  Runnable jdField_a_of_type_JavaLangRunnable = new DoubleVideoCtrlUI.RecordInfo.1(this);
  private int b = 0;
  private int c = 2130842271;
  
  void a()
  {
    this.c = 2130842271;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvUiAVActivity = null;
  }
  
  void a(long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Record, cancel, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("RecordInfo", 1, localStringBuilder.toString());
    a();
  }
  
  void a(long paramLong, VideoAppInterface paramVideoAppInterface, AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      a(paramLong, paramAVActivity);
      return;
    }
    if (i == 1) {
      a(paramLong);
    }
  }
  
  void a(long paramLong, AVActivity paramAVActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick_Record, start, seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w("RecordInfo", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Int = 1;
    this.c = 2130842274;
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo
 * JD-Core Version:    0.7.0.1
 */
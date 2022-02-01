package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$RecordInfo
{
  Runnable a = new DoubleVideoCtrlUI.RecordInfo.1(this);
  private int b = 0;
  private int c = 0;
  private int d = 2130843215;
  private VideoAppInterface e = null;
  private AVActivity f = null;
  
  void a()
  {
    this.d = 2130843215;
    this.b = 0;
    this.c = 0;
    this.e = null;
    this.f = null;
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
    this.e = paramVideoAppInterface;
    int i = this.b;
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
    this.b = 1;
    this.d = 2130843218;
    this.f = paramAVActivity;
    this.e.a().postDelayed(this.a, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.RecordInfo
 * JD-Core Version:    0.7.0.1
 */
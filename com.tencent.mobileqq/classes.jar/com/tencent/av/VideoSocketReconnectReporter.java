package com.tencent.av;

import com.tencent.av.ui.funchat.record.QavRecordDpc;
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class VideoSocketReconnectReporter
{
  public static void a()
  {
    int i = QavRecordDpc.a().o;
    int j = NetworkUtil.a(BaseApplication.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoSocketReconnectReporter", 2, String.format("reportSocketReconRequest policyType=%s netType=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    ThreadManager.post(new VideoSocketReconnectReporter.1(i, j), 5, null, false);
  }
  
  public static void a(long paramLong)
  {
    int i = QavRecordDpc.a().o;
    int j = NetworkUtil.a(BaseApplication.getContext());
    if (QLog.isColorLevel()) {
      QLog.d("VideoSocketReconnectReporter", 2, String.format("reportSocketReconResult policyType=%s netType=%s timeCost=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(paramLong) }));
    }
    ThreadManager.post(new VideoSocketReconnectReporter.2(i, j, paramLong), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoSocketReconnectReporter
 * JD-Core Version:    0.7.0.1
 */
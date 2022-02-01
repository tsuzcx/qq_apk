package com.tencent.av.qavperf;

import com.tencent.qphone.base.util.QLog;

public class QAVPLogger
{
  public static void a(String paramString)
  {
    QLog.d("QAVP_LOG", 2, paramString);
  }
  
  public static void b(String paramString)
  {
    QLog.e("QAVP_LOG", 2, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qavperf.QAVPLogger
 * JD-Core Version:    0.7.0.1
 */
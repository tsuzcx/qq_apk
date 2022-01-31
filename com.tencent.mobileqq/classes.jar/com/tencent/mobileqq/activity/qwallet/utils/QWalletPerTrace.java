package com.tencent.mobileqq.activity.qwallet.utils;

import com.tencent.qphone.base.util.QLog;

public class QWalletPerTrace
{
  public static void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QWalletPerTrace", 2, "markTimeStamp " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.utils.QWalletPerTrace
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.qwallet.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class QWalletConfigHandler
{
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletConfigHandler", 2, "onReceivePreExec|" + paramString1 + "|" + paramString2 + "|" + paramString3);
    }
    if ((!TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfigHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securemodule.impl.AppInfo;
import com.tencent.securemodule.service.CloudScanListener;
import java.util.List;

class QQAppInterface$13
  implements CloudScanListener
{
  QQAppInterface$13(QQAppInterface paramQQAppInterface) {}
  
  public void onFinish(int paramInt)
  {
    if (paramInt == 0) {
      PreferenceManager.getDefaultSharedPreferences(QQAppInterface.access$2300(this.this$0)).edit().putLong("security_scan_last_time", System.currentTimeMillis()).putBoolean("security_scan_last_result", false).commit();
    }
  }
  
  public void onRiskFoud(List<AppInfo> paramList) {}
  
  public void onRiskFound()
  {
    if (QLog.isColorLevel()) {
      QLog.d("security_scan", 2, "Find Risk");
    }
    PreferenceManager.getDefaultSharedPreferences(QQAppInterface.access$2200(this.this$0)).edit().putBoolean("security_scan_last_result", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQAppInterface.13
 * JD-Core Version:    0.7.0.1
 */
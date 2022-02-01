package com.tencent.mobileqq.activity.aio.navigate;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class TroopDNANavBar$2
  implements Runnable
{
  TroopDNANavBar$2(TroopDNANavBar paramTroopDNANavBar) {}
  
  public void run()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.this$0.c);
    int i = ((SharedPreferences)localObject).getInt(TroopDNANavBar.a(this.this$0.b), 0);
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager.TroopDNANavBar", 2, String.format("onShow guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(TroopDNANavBar.a(this.this$0.b), i + 1).commit();
    ((SharedPreferences.Editor)localObject).apply();
    ReportController.b(null, "dc00898", "", "", "0X800A468", "0X800A468", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopDNANavBar.2
 * JD-Core Version:    0.7.0.1
 */
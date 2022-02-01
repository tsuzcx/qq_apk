package com.tencent.mobileqq.activity.aio.navigate;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class IntimateInfoNavBar$2
  implements Runnable
{
  IntimateInfoNavBar$2(IntimateInfoNavBar paramIntimateInfoNavBar) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.this$0.a.getApp().getSharedPreferences("IntimateInfo" + this.this$0.a.getCurrentAccountUin(), 0);
    int i = localSharedPreferences.getInt("key_aio_score_guide_count", 0);
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager.IntimateInfoNavBar", 2, String.format("onShow score guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    localSharedPreferences.edit().putInt("key_aio_score_guide_count", i + 1).commit();
    ReportController.b(null, "dc00898", "", "", "0X800A11C", "0X800A11C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.IntimateInfoNavBar.2
 * JD-Core Version:    0.7.0.1
 */
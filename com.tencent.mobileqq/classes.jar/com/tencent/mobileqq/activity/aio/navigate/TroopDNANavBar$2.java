package com.tencent.mobileqq.activity.aio.navigate;

import ahqq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import bcst;
import com.tencent.qphone.base.util.QLog;

public class TroopDNANavBar$2
  implements Runnable
{
  public TroopDNANavBar$2(ahqq paramahqq) {}
  
  public void run()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.this$0.jdField_a_of_type_AndroidContentContext);
    int i = ((SharedPreferences)localObject).getInt(ahqq.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0);
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager.TroopDNANavBar", 2, String.format("onShow guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(ahqq.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), i + 1).commit();
    ((SharedPreferences.Editor)localObject).apply();
    bcst.b(null, "dc00898", "", "", "0X800A468", "0X800A468", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopDNANavBar.2
 * JD-Core Version:    0.7.0.1
 */
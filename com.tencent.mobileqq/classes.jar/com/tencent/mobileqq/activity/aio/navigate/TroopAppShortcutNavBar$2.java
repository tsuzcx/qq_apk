package com.tencent.mobileqq.activity.aio.navigate;

import agwr;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.qphone.base.util.QLog;

public class TroopAppShortcutNavBar$2
  implements Runnable
{
  public TroopAppShortcutNavBar$2(agwr paramagwr) {}
  
  public void run()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.this$0.jdField_a_of_type_AndroidContentContext);
    int i = ((SharedPreferences)localObject).getInt(agwr.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 0);
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager.TroopAppShortcutNavBar", 2, String.format("onShow guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(agwr.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), i + 1).commit();
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.2
 * JD-Core Version:    0.7.0.1
 */
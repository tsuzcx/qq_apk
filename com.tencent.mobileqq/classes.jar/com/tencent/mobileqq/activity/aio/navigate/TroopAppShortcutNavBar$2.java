package com.tencent.mobileqq.activity.aio.navigate;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.qphone.base.util.QLog;

class TroopAppShortcutNavBar$2
  implements Runnable
{
  TroopAppShortcutNavBar$2(TroopAppShortcutNavBar paramTroopAppShortcutNavBar) {}
  
  public void run()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.this$0.c);
    int i = ((SharedPreferences)localObject).getInt(TroopAppShortcutNavBar.a(this.this$0.b), 0);
    if (QLog.isColorLevel()) {
      QLog.d("NavigateBarManager.TroopAppShortcutNavBar", 2, String.format("onShow guide count: %s", new Object[] { Integer.valueOf(i) }));
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(TroopAppShortcutNavBar.a(this.this$0.b), i + 1).commit();
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopAppShortcutNavBar.2
 * JD-Core Version:    0.7.0.1
 */
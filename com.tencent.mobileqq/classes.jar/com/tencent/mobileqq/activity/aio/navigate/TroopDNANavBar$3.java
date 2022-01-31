package com.tencent.mobileqq.activity.aio.navigate;

import agch;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;

public final class TroopDNANavBar$3
  implements Runnable
{
  public void run()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication());
    if ((localObject == null) || (((SharedPreferences)localObject).getInt(agch.a(null), 0) >= 3)) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt(agch.a(null), 3).commit();
    ((SharedPreferences.Editor)localObject).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.navigate.TroopDNANavBar.3
 * JD-Core Version:    0.7.0.1
 */
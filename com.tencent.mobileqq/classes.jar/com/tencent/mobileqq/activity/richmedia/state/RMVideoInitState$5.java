package com.tencent.mobileqq.activity.richmedia.state;

import aluf;
import alwe;
import alxv;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bday;
import com.tencent.common.app.BaseApplicationImpl;

public class RMVideoInitState$5
  implements Runnable
{
  public RMVideoInitState$5(alxv paramalxv) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    boolean bool1 = localSharedPreferences.getBoolean("sv_has_reported_front_camera_compatibility", false);
    boolean bool2 = localSharedPreferences.getBoolean("sv_has_reported_back_camera_compatibility", false);
    bday localbday = bday.a();
    if ((!bool1) && (aluf.a == 1))
    {
      alwe.a(localbday.a(), "front");
      localSharedPreferences.edit().putBoolean("sv_has_reported_front_camera_compatibility", true).commit();
    }
    while ((bool2) || (aluf.a != 2)) {
      return;
    }
    alwe.a(localbday.a(), "back");
    localSharedPreferences.edit().putBoolean("sv_has_reported_back_camera_compatibility", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.5
 * JD-Core Version:    0.7.0.1
 */
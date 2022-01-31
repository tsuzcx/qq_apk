package com.tencent.mobileqq.activity.richmedia.state;

import ahty;
import ahvx;
import ahxo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import axhr;
import com.tencent.common.app.BaseApplicationImpl;

public class RMVideoInitState$5
  implements Runnable
{
  public RMVideoInitState$5(ahxo paramahxo) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    boolean bool1 = localSharedPreferences.getBoolean("sv_has_reported_front_camera_compatibility", false);
    boolean bool2 = localSharedPreferences.getBoolean("sv_has_reported_back_camera_compatibility", false);
    axhr localaxhr = axhr.a();
    if ((!bool1) && (ahty.a == 1))
    {
      ahvx.a(localaxhr.a(), "front");
      localSharedPreferences.edit().putBoolean("sv_has_reported_front_camera_compatibility", true).commit();
    }
    while ((bool2) || (ahty.a != 2)) {
      return;
    }
    ahvx.a(localaxhr.a(), "back");
    localSharedPreferences.edit().putBoolean("sv_has_reported_back_camera_compatibility", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.5
 * JD-Core Version:    0.7.0.1
 */
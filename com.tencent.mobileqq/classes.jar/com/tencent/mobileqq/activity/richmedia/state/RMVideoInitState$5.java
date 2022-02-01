package com.tencent.mobileqq.activity.richmedia.state;

import alps;
import alrr;
import altg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bdax;
import com.tencent.common.app.BaseApplicationImpl;

public class RMVideoInitState$5
  implements Runnable
{
  public RMVideoInitState$5(altg paramaltg) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    boolean bool1 = localSharedPreferences.getBoolean("sv_has_reported_front_camera_compatibility", false);
    boolean bool2 = localSharedPreferences.getBoolean("sv_has_reported_back_camera_compatibility", false);
    bdax localbdax = bdax.a();
    if ((!bool1) && (alps.a == 1))
    {
      alrr.a(localbdax.a(), "front");
      localSharedPreferences.edit().putBoolean("sv_has_reported_front_camera_compatibility", true).commit();
    }
    while ((bool2) || (alps.a != 2)) {
      return;
    }
    alrr.a(localbdax.a(), "back");
    localSharedPreferences.edit().putBoolean("sv_has_reported_back_camera_compatibility", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.5
 * JD-Core Version:    0.7.0.1
 */
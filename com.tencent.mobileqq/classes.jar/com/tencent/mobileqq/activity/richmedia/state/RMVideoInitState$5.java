package com.tencent.mobileqq.activity.richmedia.state;

import ajli;
import ajnh;
import ajoy;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import azcx;
import com.tencent.common.app.BaseApplicationImpl;

public class RMVideoInitState$5
  implements Runnable
{
  public RMVideoInitState$5(ajoy paramajoy) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    boolean bool1 = localSharedPreferences.getBoolean("sv_has_reported_front_camera_compatibility", false);
    boolean bool2 = localSharedPreferences.getBoolean("sv_has_reported_back_camera_compatibility", false);
    azcx localazcx = azcx.a();
    if ((!bool1) && (ajli.a == 1))
    {
      ajnh.a(localazcx.a(), "front");
      localSharedPreferences.edit().putBoolean("sv_has_reported_front_camera_compatibility", true).commit();
    }
    while ((bool2) || (ajli.a != 2)) {
      return;
    }
    ajnh.a(localazcx.a(), "back");
    localSharedPreferences.edit().putBoolean("sv_has_reported_back_camera_compatibility", true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.5
 * JD-Core Version:    0.7.0.1
 */
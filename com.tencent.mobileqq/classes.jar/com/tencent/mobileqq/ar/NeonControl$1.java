package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import aowx;
import aoxi;
import bcuj;
import com.tencent.qphone.base.util.QLog;

public class NeonControl$1
  implements Runnable
{
  public NeonControl$1(aowx paramaowx, SharedPreferences paramSharedPreferences, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool1 = true;
    ??? = new bcuj();
    ((bcuj)???).a();
    boolean bool2 = ((bcuj)???).a();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("sp_cpu_neon_support", bool2).apply();
    boolean bool3 = aoxi.a().e;
    int i;
    int j;
    if (QLog.isColorLevel())
    {
      if (!bool3) {
        break label216;
      }
      i = 1;
      if (!bool2) {
        break label221;
      }
      j = 1;
      label76:
      if (!this.jdField_a_of_type_Boolean) {
        break label226;
      }
    }
    label216:
    label221:
    label226:
    for (int k = 1;; k = 0)
    {
      QLog.i("NeonControl", 2, String.format("dpcNeonCfgSwitch:%d isCpuNeonSupport:%d forceOpenNeon:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) }));
      if (this.jdField_a_of_type_Boolean) {
        synchronized (this.this$0.a)
        {
          aowx.a(this.this$0, bool2);
          return;
        }
      }
      for (;;)
      {
        synchronized (this.this$0.a)
        {
          aowx localaowx = this.this$0;
          if ((bool3) && (bool2))
          {
            aowx.a(localaowx, bool1);
            return;
          }
        }
        bool1 = false;
      }
      i = 0;
      break;
      j = 0;
      break label76;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.NeonControl.1
 * JD-Core Version:    0.7.0.1
 */
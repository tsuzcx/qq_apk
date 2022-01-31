package com.tencent.biz.pubaccount.readinjoy.pts.util;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import pep;

public class PTSSwitchManager$1
  implements Runnable
{
  public PTSSwitchManager$1(pep parampep) {}
  
  public void run()
  {
    boolean bool4 = false;
    Object localObject = Build.CPU_ABI;
    boolean bool1;
    int i;
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("armeabi")))
    {
      bool1 = true;
      localObject = Aladdin.getConfig(223);
      if (localObject == null) {
        break label221;
      }
      if (((AladdinConfig)localObject).getIntegerFromString("pts_switch", 0) != 1) {
        break label200;
      }
      i = 1;
    }
    for (;;)
    {
      label55:
      AladdinConfig localAladdinConfig = Aladdin.getConfig(246);
      int j;
      if (localObject != null) {
        if (localAladdinConfig.getIntegerFromString("pts_item_view_switch", 0) == 1) {
          j = 1;
        }
      }
      for (;;)
      {
        label82:
        if ((i != 0) && (bool1)) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          boolean bool3 = bool4;
          if (j != 0)
          {
            bool3 = bool4;
            if (bool1) {
              bool3 = true;
            }
          }
          QLog.i("PTSSwitchManager", 1, "[init], pageEnabledTmp = " + bool2 + ", viewEnabledTmp = " + bool3 + ", isArm = " + bool1);
          if ((bool2) || (bool3)) {
            pep.a(this.this$0);
          }
          pep.a(this.this$0, bool2);
          pep.b(this.this$0, bool3);
          return;
          bool1 = false;
          break;
          label200:
          i = 0;
          break label55;
          j = 0;
          break label82;
        }
        j = 0;
      }
      label221:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager.1
 * JD-Core Version:    0.7.0.1
 */
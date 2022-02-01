package com.tencent.biz.pubaccount.readinjoy.pts.util;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.pts.loader.PTSJSCLoader;
import com.tencent.qphone.base.util.QLog;

class PTSSwitchManager$1
  implements Runnable
{
  PTSSwitchManager$1(PTSSwitchManager paramPTSSwitchManager) {}
  
  public void run()
  {
    boolean bool4 = false;
    Object localObject = Aladdin.getConfig(266);
    boolean bool1;
    if (localObject != null) {
      if (((AladdinConfig)localObject).getIntegerFromString("pts_jsc_switch", 0) == 1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      PTSSwitchManager.a(this.this$0, bool1);
      QLog.i("PTSSwitchManager", 1, "[init], ptsJSCEnabled = " + PTSSwitchManager.a(this.this$0));
      label111:
      int i;
      if (PTSSwitchManager.a(this.this$0))
      {
        PTSJSCLoader.a().a();
        localObject = Build.CPU_ABI;
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).contains("armeabi"))) {
          break label283;
        }
        bool1 = true;
        localObject = Aladdin.getConfig(223);
        if (localObject == null) {
          break label309;
        }
        if (((AladdinConfig)localObject).getIntegerFromString("pts_switch", 0) != 1) {
          break label288;
        }
        i = 1;
      }
      for (;;)
      {
        label138:
        localObject = Aladdin.getConfig(246);
        int j;
        if (localObject != null) {
          if (((AladdinConfig)localObject).getIntegerFromString("pts_item_view_switch", 0) == 1) {
            j = 1;
          }
        }
        for (;;)
        {
          label165:
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
              PTSSwitchManager.a(this.this$0);
            }
            PTSSwitchManager.b(this.this$0, bool2);
            PTSSwitchManager.c(this.this$0, bool3);
            return;
            bool1 = false;
            break;
            label283:
            bool1 = false;
            break label111;
            label288:
            i = 0;
            break label138;
            j = 0;
            break label165;
          }
          j = 0;
        }
        label309:
        i = 0;
      }
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager.1
 * JD-Core Version:    0.7.0.1
 */
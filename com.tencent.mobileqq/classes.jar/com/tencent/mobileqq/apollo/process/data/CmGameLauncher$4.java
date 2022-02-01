package com.tencent.mobileqq.apollo.process.data;

import amrk;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

public class CmGameLauncher$4
  implements Runnable
{
  public CmGameLauncher$4(amrk paramamrk, Activity paramActivity) {}
  
  public void run()
  {
    boolean bool2 = false;
    amrk localamrk;
    Activity localActivity;
    if (!amrk.b(this.this$0))
    {
      if (QLog.isColorLevel())
      {
        if (amrk.a(this.this$0) != null) {
          break label101;
        }
        bool1 = false;
        QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "checkInitStartGame mIsEnableMSAA:", Boolean.valueOf(bool1) });
      }
      localamrk = this.this$0;
      localActivity = this.a;
      if (amrk.a(this.this$0) != null) {
        break label115;
      }
    }
    label101:
    label115:
    for (boolean bool1 = bool2;; bool1 = amrk.a(this.this$0).mIsEnableMSAA)
    {
      localamrk.a(localActivity, bool1);
      this.this$0.a(this.a, amrk.a(this.this$0));
      return;
      bool1 = amrk.a(this.this$0).mIsEnableMSAA;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.4
 * JD-Core Version:    0.7.0.1
 */
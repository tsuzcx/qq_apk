package com.tencent.mobileqq.apollo.process.data;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class CmGameLauncher$4
  implements Runnable
{
  CmGameLauncher$4(CmGameLauncher paramCmGameLauncher, Activity paramActivity) {}
  
  public void run()
  {
    boolean bool2 = false;
    CmGameLauncher localCmGameLauncher;
    Activity localActivity;
    if (!CmGameLauncher.b(this.this$0))
    {
      if (QLog.isColorLevel())
      {
        if (CmGameLauncher.a(this.this$0) != null) {
          break label101;
        }
        bool1 = false;
        QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "checkInitStartGame mIsEnableMSAA:", Boolean.valueOf(bool1) });
      }
      localCmGameLauncher = this.this$0;
      localActivity = this.a;
      if (CmGameLauncher.a(this.this$0) != null) {
        break label115;
      }
    }
    label101:
    label115:
    for (boolean bool1 = bool2;; bool1 = CmGameLauncher.a(this.this$0).mIsEnableMSAA)
    {
      localCmGameLauncher.a(localActivity, bool1);
      this.this$0.a(this.a, CmGameLauncher.a(this.this$0));
      return;
      bool1 = CmGameLauncher.a(this.this$0).mIsEnableMSAA;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.4
 * JD-Core Version:    0.7.0.1
 */
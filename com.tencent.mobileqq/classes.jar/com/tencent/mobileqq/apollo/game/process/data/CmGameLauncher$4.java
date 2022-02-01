package com.tencent.mobileqq.apollo.game.process.data;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

class CmGameLauncher$4
  implements Runnable
{
  CmGameLauncher$4(CmGameLauncher paramCmGameLauncher, Activity paramActivity) {}
  
  public void run()
  {
    if (!CmGameLauncher.d(this.this$0))
    {
      boolean bool1 = QLog.isColorLevel();
      boolean bool2 = false;
      if (bool1)
      {
        if (CmGameLauncher.e(this.this$0) == null) {
          bool1 = false;
        } else {
          bool1 = CmGameLauncher.e(this.this$0).mIsEnableMSAA;
        }
        QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "checkInitStartGame mIsEnableMSAA:", Boolean.valueOf(bool1) });
      }
      localCmGameLauncher = this.this$0;
      Activity localActivity = this.a;
      if (CmGameLauncher.e(localCmGameLauncher) == null) {
        bool1 = bool2;
      } else {
        bool1 = CmGameLauncher.e(this.this$0).mIsEnableMSAA;
      }
      localCmGameLauncher.a(localActivity, bool1);
    }
    CmGameLauncher localCmGameLauncher = this.this$0;
    localCmGameLauncher.a(this.a, CmGameLauncher.e(localCmGameLauncher));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher.4
 * JD-Core Version:    0.7.0.1
 */
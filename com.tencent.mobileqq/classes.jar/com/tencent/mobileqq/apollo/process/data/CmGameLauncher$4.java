package com.tencent.mobileqq.apollo.process.data;

import ande;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

public class CmGameLauncher$4
  implements Runnable
{
  public CmGameLauncher$4(ande paramande, Activity paramActivity) {}
  
  public void run()
  {
    boolean bool2 = false;
    ande localande;
    Activity localActivity;
    if (!ande.b(this.this$0))
    {
      if (QLog.isColorLevel())
      {
        if (ande.a(this.this$0) != null) {
          break label101;
        }
        bool1 = false;
        QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "checkInitStartGame mIsEnableMSAA:", Boolean.valueOf(bool1) });
      }
      localande = this.this$0;
      localActivity = this.a;
      if (ande.a(this.this$0) != null) {
        break label115;
      }
    }
    label101:
    label115:
    for (boolean bool1 = bool2;; bool1 = ande.a(this.this$0).mIsEnableMSAA)
    {
      localande.a(localActivity, bool1);
      this.this$0.a(this.a, ande.a(this.this$0));
      return;
      bool1 = ande.a(this.this$0).mIsEnableMSAA;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.4
 * JD-Core Version:    0.7.0.1
 */
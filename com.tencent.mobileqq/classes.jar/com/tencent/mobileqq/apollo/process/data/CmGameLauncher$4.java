package com.tencent.mobileqq.apollo.process.data;

import amyo;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;

public class CmGameLauncher$4
  implements Runnable
{
  public CmGameLauncher$4(amyo paramamyo, Activity paramActivity) {}
  
  public void run()
  {
    boolean bool2 = false;
    amyo localamyo;
    Activity localActivity;
    if (!amyo.b(this.this$0))
    {
      if (QLog.isColorLevel())
      {
        if (amyo.a(this.this$0) != null) {
          break label101;
        }
        bool1 = false;
        QLog.d("cmgame_process.CmGameLauncher", 2, new Object[] { "checkInitStartGame mIsEnableMSAA:", Boolean.valueOf(bool1) });
      }
      localamyo = this.this$0;
      localActivity = this.a;
      if (amyo.a(this.this$0) != null) {
        break label115;
      }
    }
    label101:
    label115:
    for (boolean bool1 = bool2;; bool1 = amyo.a(this.this$0).mIsEnableMSAA)
    {
      localamyo.a(localActivity, bool1);
      this.this$0.a(this.a, amyo.a(this.this$0));
      return;
      bool1 = amyo.a(this.this$0).mIsEnableMSAA;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.4
 * JD-Core Version:    0.7.0.1
 */
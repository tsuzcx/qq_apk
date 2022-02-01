package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class GesturePWDUnlockActivity$7
  extends BroadcastReceiver
{
  GesturePWDUnlockActivity$7(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.a.mIsFromJump) {
      return;
    }
    if (paramIntent != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.gesturelock.unlock", 2, "GesturePWDUnlockActivity finish onReceive");
      }
      if ((paramIntent.getLongExtra("timeid", 0L) > this.a.createTime) && (!this.a.isFinishing())) {
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDUnlockActivity.7
 * JD-Core Version:    0.7.0.1
 */
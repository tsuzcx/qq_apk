package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;

class GesturePWDUnlockActivity$5
  implements DialogInterface.OnDismissListener
{
  GesturePWDUnlockActivity$5(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!GesturePWDUnlockActivity.access$100(this.a))
    {
      GesturePWDUnlockActivity.access$102(this.a, true);
      return;
    }
    this.a.unLockFailed();
    GesturePWDUtils.setGestureUnlockFailedType(this.a, 1);
    StatisticCollector.getInstance(this.a.getBaseContext()).reportActionCount(this.a.app, this.a.app.getCurrentAccountUin(), "Gesture_pwd", "click_wrong_pwd", 0, 1, "0", null, null, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDUnlockActivity.5
 * JD-Core Version:    0.7.0.1
 */
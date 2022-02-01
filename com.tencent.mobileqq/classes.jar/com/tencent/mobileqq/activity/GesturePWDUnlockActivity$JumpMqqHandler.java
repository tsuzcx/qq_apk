package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

class GesturePWDUnlockActivity$JumpMqqHandler
  extends MqqHandler
{
  private WeakReference<GesturePWDUnlockActivity> a;
  
  public GesturePWDUnlockActivity$JumpMqqHandler(GesturePWDUnlockActivity paramGesturePWDUnlockActivity)
  {
    this.a = new WeakReference(paramGesturePWDUnlockActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    GesturePWDUnlockActivity localGesturePWDUnlockActivity = (GesturePWDUnlockActivity)this.a.get();
    if (localGesturePWDUnlockActivity != null)
    {
      if (localGesturePWDUnlockActivity.isFinishing()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MqqHandler, handleMessage: what=");
      localStringBuilder.append(paramMessage.what);
      localStringBuilder.append(", resume=");
      localStringBuilder.append(localGesturePWDUnlockActivity.isResume());
      QLog.i("qqBaseActivity", 1, localStringBuilder.toString());
      int i = paramMessage.what;
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        localGesturePWDUnlockActivity.finish();
        return;
      }
      if (localGesturePWDUnlockActivity.isResume())
      {
        GesturePWDUnlockActivity.access$200(localGesturePWDUnlockActivity);
        return;
      }
      GesturePWDUnlockActivity.access$302(localGesturePWDUnlockActivity, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GesturePWDUnlockActivity.JumpMqqHandler
 * JD-Core Version:    0.7.0.1
 */
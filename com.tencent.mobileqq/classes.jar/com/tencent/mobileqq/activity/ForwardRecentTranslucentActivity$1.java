package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

class ForwardRecentTranslucentActivity$1
  extends ResultReceiver
{
  ForwardRecentTranslucentActivity$1(ForwardRecentTranslucentActivity paramForwardRecentTranslucentActivity, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "] #this = " + Integer.toHexString(System.identityHashCode(this.a)));
    }
    if (paramInt == 1) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity.1
 * JD-Core Version:    0.7.0.1
 */
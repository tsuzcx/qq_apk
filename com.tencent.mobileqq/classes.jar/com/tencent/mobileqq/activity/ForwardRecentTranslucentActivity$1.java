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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveResult() called with: resultCode = [");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], resultData = [");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append("] #this = ");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this.a)));
      QLog.d("ForwardOption.ForwardEntranceActivity", 2, localStringBuilder.toString());
    }
    if (paramInt == 1) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.TMG.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class PhoneStatusMonitor$PhoneStatusReceiver
  extends BroadcastReceiver
{
  PhoneStatusMonitor$PhoneStatusReceiver(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 0, "onReceive NEW_OUTGOING_CALL");
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 0, "onReceive PHONE_STATE");
      }
      if ((this.this$0.mIsCalling) && (!PhoneStatusTools.isCalling(this.this$0.mContext)))
      {
        paramContext = this.this$0;
        paramContext.mIsCalling = false;
        if (paramContext.mPhoneStatusListener != null) {
          this.this$0.mPhoneStatusListener.onCallStateChanged(false);
        }
      }
      else if ((!this.this$0.mIsCalling) && (PhoneStatusTools.isCalling(this.this$0.mContext)))
      {
        paramContext = this.this$0;
        paramContext.mIsCalling = true;
        if (paramContext.mPhoneStatusListener != null) {
          this.this$0.mPhoneStatusListener.onCallStateChanged(true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.utils.PhoneStatusMonitor.PhoneStatusReceiver
 * JD-Core Version:    0.7.0.1
 */
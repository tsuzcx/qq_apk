package com.tencent.TMG.utils;

import android.telephony.PhoneStateListener;

class PhoneStatusMonitor$QQPhoneStateListener
  extends PhoneStateListener
{
  PhoneStatusMonitor$QQPhoneStateListener(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    PhoneStatusMonitor localPhoneStatusMonitor;
    if (paramInt != 0)
    {
      if ((paramInt == 1) || (paramInt == 2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusMonitor", 0, "onCallStateChanged CALL_STATE_RINGING or CALL_STATE_OFFHOOK");
        }
        if (!this.this$0.mIsCalling)
        {
          localPhoneStatusMonitor = this.this$0;
          localPhoneStatusMonitor.mIsCalling = true;
          if (localPhoneStatusMonitor.mPhoneStatusListener != null) {
            this.this$0.mPhoneStatusListener.onCallStateChanged(true);
          }
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 0, "onCallStateChanged CALL_STATE_IDLE");
      }
      if ((this.this$0.mIsCalling) && (!PhoneStatusTools.isCalling(this.this$0.mContext)))
      {
        localPhoneStatusMonitor = this.this$0;
        localPhoneStatusMonitor.mIsCalling = false;
        if (localPhoneStatusMonitor.mPhoneStatusListener != null) {
          this.this$0.mPhoneStatusListener.onCallStateChanged(false);
        }
      }
    }
    super.onCallStateChanged(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.utils.PhoneStatusMonitor.QQPhoneStateListener
 * JD-Core Version:    0.7.0.1
 */
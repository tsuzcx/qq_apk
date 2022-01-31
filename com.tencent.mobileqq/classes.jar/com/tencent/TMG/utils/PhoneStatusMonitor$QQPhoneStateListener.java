package com.tencent.TMG.utils;

import android.telephony.PhoneStateListener;

class PhoneStatusMonitor$QQPhoneStateListener
  extends PhoneStateListener
{
  PhoneStatusMonitor$QQPhoneStateListener(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onCallStateChanged(paramInt, paramString);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 0, "onCallStateChanged CALL_STATE_IDLE");
      }
      if ((this.this$0.mIsCalling) && (!PhoneStatusTools.isCalling(this.this$0.mContext)))
      {
        this.this$0.mIsCalling = false;
        if (this.this$0.mPhoneStatusListener != null)
        {
          this.this$0.mPhoneStatusListener.onCallStateChanged(false);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 0, "onCallStateChanged CALL_STATE_RINGING or CALL_STATE_OFFHOOK");
          }
          if (!this.this$0.mIsCalling)
          {
            this.this$0.mIsCalling = true;
            if (this.this$0.mPhoneStatusListener != null) {
              this.this$0.mPhoneStatusListener.onCallStateChanged(true);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.utils.PhoneStatusMonitor.QQPhoneStateListener
 * JD-Core Version:    0.7.0.1
 */
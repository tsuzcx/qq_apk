package com.tencent.av.utils;

import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;

class PhoneStatusMonitor$QQPhoneStateListener
  extends PhoneStateListener
{
  PhoneStatusMonitor$QQPhoneStateListener(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhoneStatusMonitor", 2, "onCallStateChanged, state[" + paramInt + "], isCalling[" + PhoneStatusMonitor.a(this.a) + "]");
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      super.onCallStateChanged(paramInt, paramString);
      return;
      if (PhoneStatusMonitor.a(this.a))
      {
        PhoneStatusMonitor.a(this.a, false);
        continue;
        if (!PhoneStatusMonitor.a(this.a)) {
          PhoneStatusMonitor.a(this.a, true);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.QQPhoneStateListener
 * JD-Core Version:    0.7.0.1
 */
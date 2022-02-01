package com.tencent.av.utils;

import android.telephony.PhoneStateListener;
import com.tencent.qphone.base.util.QLog;

class PhoneStatusMonitor$QQPhoneStateListener
  extends PhoneStateListener
{
  PhoneStatusMonitor$QQPhoneStateListener(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCallStateChanged, state[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], isCalling[");
      localStringBuilder.append(PhoneStatusMonitor.a(this.a));
      localStringBuilder.append("]");
      QLog.i("PhoneStatusMonitor", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if (((paramInt == 1) || (paramInt == 2)) && (!PhoneStatusMonitor.a(this.a))) {
        PhoneStatusMonitor.a(this.a, true);
      }
    }
    else if (PhoneStatusMonitor.a(this.a)) {
      PhoneStatusMonitor.a(this.a, false);
    }
    super.onCallStateChanged(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PhoneStatusMonitor.QQPhoneStateListener
 * JD-Core Version:    0.7.0.1
 */
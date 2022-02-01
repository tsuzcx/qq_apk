package com.tencent.av.utils;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

class SignalStrengthReport$QavPhoneStateListener
  extends PhoneStateListener
{
  SignalStrengthReport$QavPhoneStateListener(SignalStrengthReport paramSignalStrengthReport) {}
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    SignalStrengthReport localSignalStrengthReport = this.a;
    localSignalStrengthReport.c = localSignalStrengthReport.a(paramSignalStrength);
    localSignalStrengthReport = this.a;
    localSignalStrengthReport.d = localSignalStrengthReport.b(paramSignalStrength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport.QavPhoneStateListener
 * JD-Core Version:    0.7.0.1
 */
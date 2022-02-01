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
    this.a.c = this.a.a(paramSignalStrength);
    this.a.d = this.a.b(paramSignalStrength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport.QavPhoneStateListener
 * JD-Core Version:    0.7.0.1
 */
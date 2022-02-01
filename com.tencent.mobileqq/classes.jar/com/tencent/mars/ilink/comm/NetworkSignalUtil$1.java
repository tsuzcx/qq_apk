package com.tencent.mars.ilink.comm;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

final class NetworkSignalUtil$1
  extends PhoneStateListener
{
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    NetworkSignalUtil.access$000(paramSignalStrength);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.NetworkSignalUtil.1
 * JD-Core Version:    0.7.0.1
 */
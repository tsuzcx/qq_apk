package com.tencent.mars.ilink.comm;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

public class NetStatusUtil$StrengthListener
  extends PhoneStateListener
{
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (!paramSignalStrength.isGsm())
    {
      NetStatusUtil.access$002(paramSignalStrength.getCdmaDbm());
      return;
    }
    NetStatusUtil.access$002(paramSignalStrength.getGsmSignalStrength());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.NetStatusUtil.StrengthListener
 * JD-Core Version:    0.7.0.1
 */
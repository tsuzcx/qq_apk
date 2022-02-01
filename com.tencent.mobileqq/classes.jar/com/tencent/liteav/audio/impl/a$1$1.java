package com.tencent.liteav.audio.impl;

import android.telephony.PhoneStateListener;
import com.tencent.liteav.basic.log.TXCLog;

class a$1$1
  extends PhoneStateListener
{
  a$1$1(a.1 param1) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    paramString = new StringBuilder();
    paramString.append("onCallStateChanged:");
    paramString.append(paramInt);
    TXCLog.i("AudioCenter:TXCTelephonyMgr", paramString.toString());
    a.a(this.a.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a.1.1
 * JD-Core Version:    0.7.0.1
 */
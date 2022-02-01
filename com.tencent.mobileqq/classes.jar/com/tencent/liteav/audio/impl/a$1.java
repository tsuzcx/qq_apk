package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;

class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public void run()
  {
    if (a.a(this.a) != null) {
      return;
    }
    a.a(this.a, new a.1.1(this));
    try
    {
      ((TelephonyManager)a.b(this.a).getSystemService("phone")).listen(a.a(this.a), 32);
      return;
    }
    catch (Exception localException)
    {
      TXCLog.e("AudioCenter:TXCTelephonyMgr", "TelephonyManager listen error ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.liteav.basic.log.TXCLog;

class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public void run()
  {
    if ((a.a(this.a) != null) && (a.b(this.a) != null)) {
      try
      {
        ((TelephonyManager)a.b(this.a).getApplicationContext().getSystemService("phone")).listen(a.a(this.a), 0);
      }
      catch (Exception localException)
      {
        TXCLog.e("AudioCenter:TXCTelephonyMgr", "TelephonyManager listen error ", localException);
      }
    }
    a.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a.2
 * JD-Core Version:    0.7.0.1
 */
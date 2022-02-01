package com.tencent.luggage.wxa.hj;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.luggage.wxa.hq.a;
import com.tencent.luggage.wxa.hs.b;

class d$2$1
  implements IBinder.DeathRecipient
{
  d$2$1(d.2 param2, IBinder paramIBinder) {}
  
  public void binderDied()
  {
    b.a("IPC.IPCBridgeManager", "binderDied(%d, tid:%d)", new Object[] { Integer.valueOf(this.b.b.hashCode()), Long.valueOf(Thread.currentThread().getId()) });
    a locala = new a(this.b.a);
    this.b.e.b(this.b.a);
    locala.binderDied();
    d.a(this.b.e, this.b.a);
    this.a.unlinkToDeath(this, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.d.2.1
 * JD-Core Version:    0.7.0.1
 */
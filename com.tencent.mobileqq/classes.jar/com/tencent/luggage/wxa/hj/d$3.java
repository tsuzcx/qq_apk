package com.tencent.luggage.wxa.hj;

import com.tencent.luggage.wxa.hs.b;
import java.util.Map;

class d$3
  implements Runnable
{
  d$3(d paramd, d.a parama, long paramLong, String paramString) {}
  
  public void run()
  {
    b.a("IPC.IPCBridgeManager", "[getIPCBridge]onConnectTimeout(%s, id:%d, tid : %s)", new Object[] { Integer.valueOf(this.a.hashCode()), Long.valueOf(this.b), Long.valueOf(Thread.currentThread().getId()) });
    if (!this.a.c) {
      return;
    }
    synchronized (this.a)
    {
      if (!this.a.c) {
        return;
      }
      this.a.c = false;
      this.a.notifyAll();
      this.a.d = null;
      synchronized (d.a(this.d))
      {
        d.a(this.d).remove(this.c);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.d.3
 * JD-Core Version:    0.7.0.1
 */
package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

final class ek
{
  volatile boolean a;
  byte[] b = new byte[0];
  final dx c;
  eq d = null;
  ServiceState e = null;
  HandlerThread f;
  ek.a g;
  ek.b h;
  Handler i;
  SignalStrength j;
  private eq k = null;
  private eq l = null;
  private int m = 0;
  
  public ek(dx paramdx)
  {
    this.c = paramdx;
  }
  
  private void a(eq parameq)
  {
    if ((!this.a) || (parameq == null) || (this.c == null)) {
      return;
    }
    try
    {
      if (this.d != null) {
        parameq.a(this.d.a());
      }
      this.d = parameq;
      this.c.b(parameq);
      return;
    }
    finally {}
  }
  
  public final void a()
  {
    if (!this.a) {
      return;
    }
    this.a = false;
    synchronized (this.b)
    {
      if (this.h != null) {
        this.h.a(0);
      }
      if (this.g != null)
      {
        this.g.a = true;
        this.g.removeCallbacksAndMessages(null);
        this.g = null;
      }
      if (this.f != null)
      {
        this.f.quit();
        this.f = null;
      }
      this.d = null;
      this.e = null;
      this.h = null;
      this.j = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.ek
 * JD-Core Version:    0.7.0.1
 */
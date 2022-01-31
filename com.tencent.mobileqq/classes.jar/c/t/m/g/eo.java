package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

final class eo
{
  volatile boolean a;
  byte[] b = new byte[0];
  final ea c;
  eu d = null;
  ServiceState e = null;
  HandlerThread f;
  eo.a g;
  eo.b h;
  Handler i;
  SignalStrength j;
  private eu k = null;
  private eu l = null;
  private int m = 0;
  
  public eo(ea paramea)
  {
    this.c = paramea;
  }
  
  private void a(eu parameu)
  {
    if ((!this.a) || (parameu == null) || (this.c == null)) {
      return;
    }
    try
    {
      if (this.d != null) {
        parameu.a(this.d.a());
      }
      this.d = parameu;
      this.c.b(parameu);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.eo
 * JD-Core Version:    0.7.0.1
 */
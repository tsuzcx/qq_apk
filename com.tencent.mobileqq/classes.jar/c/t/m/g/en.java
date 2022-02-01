package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;

final class en
{
  volatile boolean a;
  byte[] b = new byte[0];
  final ea c;
  et d = null;
  ServiceState e = null;
  HandlerThread f;
  en.a g;
  en.b h;
  Handler i;
  SignalStrength j;
  private et k = null;
  private et l = null;
  private int m = 0;
  
  public en(ea paramea)
  {
    this.c = paramea;
  }
  
  private void a(et paramet)
  {
    if ((!this.a) || (paramet == null) || (this.c == null)) {
      return;
    }
    try
    {
      if (this.d != null) {
        paramet.a(this.d.a());
      }
      this.d = paramet;
      this.c.b(paramet);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.en
 * JD-Core Version:    0.7.0.1
 */
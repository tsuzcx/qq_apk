package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;

final class eg
  extends PhoneStateListener
{
  volatile boolean a;
  final ea b;
  CellLocation c = null;
  HandlerThread d;
  Handler e;
  private SignalStrength f = null;
  private ServiceState g = null;
  private long h;
  
  public eg(ea paramea)
  {
    this.b = paramea;
  }
  
  private void b()
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      if (this.c != null)
      {
        long l = System.currentTimeMillis();
        if (l - this.h > 2000L) {}
        for (int i = 1; i != 0; i = 0)
        {
          this.h = l;
          c();
          return;
        }
      }
    }
  }
  
  private void c()
  {
    eu localeu = eu.a(this.b, this.c, this.f);
    try
    {
      if ((this.e != null) && (localeu != null))
      {
        eg.b localb = new eg.b(this.b);
        localb.a = localeu;
        this.e.post(localb);
      }
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
    a(0);
    try
    {
      if (this.e != null)
      {
        this.e.removeCallbacksAndMessages(null);
        this.e = null;
      }
      this.d.quit();
      this.d = null;
      this.c = null;
      this.f = null;
      this.g = null;
      this.h = 0L;
      new StringBuilder("unregister system cell provider:").append(Thread.currentThread().getName());
      return;
    }
    finally {}
  }
  
  final void a(int paramInt)
  {
    TelephonyManager localTelephonyManager = this.b.f;
    try
    {
      localTelephonyManager.listen(this, paramInt);
      return;
    }
    catch (Exception localException) {}
  }
  
  final boolean a(CellLocation paramCellLocation)
  {
    if (paramCellLocation == null) {
      return false;
    }
    try
    {
      GsmCellLocation localGsmCellLocation = (GsmCellLocation)paramCellLocation;
      if (localGsmCellLocation.getCid() == 0)
      {
        int i = localGsmCellLocation.getLac();
        if (i == 0) {
          return false;
        }
      }
    }
    catch (ClassCastException localClassCastException)
    {
      if (fj.a(paramCellLocation) < 0) {
        return false;
      }
      if (fj.a(this.c, paramCellLocation)) {
        return false;
      }
      paramCellLocation = eu.a(this.b, paramCellLocation, null);
      if (paramCellLocation == null) {}
      for (boolean bool = true; bool; bool = fj.a(paramCellLocation)) {
        return true;
      }
    }
    return false;
  }
  
  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    super.onCellLocationChanged(paramCellLocation);
    try
    {
      if (a(paramCellLocation))
      {
        this.c = paramCellLocation;
        b();
        return;
      }
      new StringBuilder("onCellLocationChanged: illegal cell or same cell ").append(paramCellLocation);
      return;
    }
    catch (Throwable paramCellLocation) {}
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState)
  {
    int j = 1;
    int m = 0;
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null) {}
    for (;;)
    {
      return;
      try
      {
        ServiceState localServiceState = this.g;
        if ((localServiceState != null) && (localServiceState.getState() == paramServiceState.getState())) {
          continue;
        }
        this.g = paramServiceState;
        if (!this.a) {
          continue;
        }
        int i;
        boolean bool;
        if (this.g != null) {
          if (this.g.getState() == 0)
          {
            i = 1;
            paramServiceState = this.b.f;
            bool = fj.a(this.b.a);
            if (paramServiceState == null) {
              break label175;
            }
            if (paramServiceState.getSimState() != 5) {
              break label164;
            }
            break label177;
          }
        }
        for (;;)
        {
          paramServiceState = new Message();
          paramServiceState.what = 12999;
          paramServiceState.arg1 = 12003;
          paramServiceState.arg2 = k;
          this.b.b(paramServiceState);
          return;
          i = this.g.getState();
          if (i == 1)
          {
            i = 0;
            break;
          }
          i = -1;
          break;
          label164:
          j = 0;
          label175:
          label177:
          do
          {
            k = i;
            break;
            j = 0;
            k = m;
            if (bool) {
              break;
            }
          } while (j != 0);
          int k = m;
        }
        return;
      }
      catch (Throwable paramServiceState) {}
    }
  }
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (paramSignalStrength == null) {}
    for (;;)
    {
      return;
      try
      {
        SignalStrength localSignalStrength = this.f;
        int i = this.b.b.a;
        if ((localSignalStrength == null) || (fj.a(i, localSignalStrength, paramSignalStrength)))
        {
          this.f = paramSignalStrength;
          b();
          return;
        }
      }
      catch (Throwable paramSignalStrength) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.eg
 * JD-Core Version:    0.7.0.1
 */
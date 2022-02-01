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

final class ef
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
  
  public ef(ea paramea)
  {
    this.b = paramea;
  }
  
  private void b()
  {
    if (!this.a) {
      return;
    }
    if (this.c == null) {
      return;
    }
    long l = System.currentTimeMillis();
    int i;
    if (l - this.h > 2000L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.h = l;
      c();
    }
  }
  
  private void c()
  {
    et localet = et.a(this.b, this.c, this.f);
    try
    {
      if ((this.e != null) && (localet != null))
      {
        ef.b localb = new ef.b(this.b);
        localb.a = localet;
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
      label32:
      boolean bool;
      break label32;
    }
    if (fj.a(paramCellLocation) < 0) {
      return false;
    }
    if (fj.a(this.c, paramCellLocation)) {
      return false;
    }
    paramCellLocation = et.a(this.b, paramCellLocation, null);
    if (paramCellLocation == null) {
      bool = true;
    } else {
      bool = fj.a(paramCellLocation);
    }
    return bool;
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
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null) {
      return;
    }
    for (;;)
    {
      boolean bool;
      try
      {
        ServiceState localServiceState = this.g;
        if ((localServiceState == null) || (localServiceState.getState() != paramServiceState.getState()))
        {
          this.g = paramServiceState;
          if (this.a)
          {
            paramServiceState = this.g;
            j = 1;
            if (paramServiceState == null) {
              break label160;
            }
            if (this.g.getState() == 0)
            {
              i = 1;
            }
            else
            {
              if (this.g.getState() != 1) {
                break label160;
              }
              i = 0;
            }
            paramServiceState = this.b.f;
            bool = fj.a(this.b.a);
            if ((paramServiceState == null) || (paramServiceState.getSimState() != 5)) {
              break label165;
            }
            break label167;
            paramServiceState = new Message();
            paramServiceState.what = 12999;
            paramServiceState.arg1 = 12003;
            paramServiceState.arg2 = i;
            this.b.b(paramServiceState);
          }
        }
        return;
      }
      catch (Throwable paramServiceState)
      {
        return;
      }
      label160:
      int i = -1;
      continue;
      label165:
      int j = 0;
      label167:
      if ((bool) || (j == 0)) {
        i = 0;
      }
    }
  }
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (paramSignalStrength == null) {
      return;
    }
    try
    {
      SignalStrength localSignalStrength = this.f;
      int i = this.b.b.a;
      if ((localSignalStrength == null) || (fj.a(i, localSignalStrength, paramSignalStrength)))
      {
        this.f = paramSignalStrength;
        b();
      }
      return;
    }
    catch (Throwable paramSignalStrength) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ef
 * JD-Core Version:    0.7.0.1
 */
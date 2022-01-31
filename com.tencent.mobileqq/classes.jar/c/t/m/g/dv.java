package c.t.m.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class dv
  extends PhoneStateListener
{
  volatile boolean a;
  HandlerThread b;
  Handler c;
  Runnable d;
  Handler e;
  List<String> f;
  private final de g;
  private final TelephonyManager h;
  private ee i = null;
  private ServiceState j = null;
  private CellLocation k;
  
  public dv(de paramde)
  {
    this.g = paramde;
    this.h = paramde.f;
    this.d = new Runnable()
    {
      public final void run()
      {
        dv.a(dv.this);
        dv.this.a = true;
      }
    };
  }
  
  private void a(int paramInt)
  {
    try
    {
      this.g.f.listen(this, paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      ev.b("TxNewCellProvider", "listenCellState: failed! flags=" + paramInt + localThrowable.toString());
    }
  }
  
  private void a(List<ee> paramList)
  {
    ee localee = null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = localee;
    if (localIterator.hasNext())
    {
      localee = (ee)localIterator.next();
      localArrayList.add(localee.b());
      if ((this.f == null) || (this.f.contains(localee.b()))) {
        break label152;
      }
      paramList = localee;
    }
    label152:
    for (;;)
    {
      break;
      this.f = localArrayList;
      if (paramList != null)
      {
        this.i = paramList;
        ev.b("TxNewCellProvider", "notify");
        if ((!this.a) || (this.i == null) || (this.g == null)) {
          return;
        }
        try
        {
          this.g.b(this.i);
          return;
        }
        finally {}
      }
      ev.b("TxNewCellProvider", "onTxCellInfoChange: same cell ");
      return;
    }
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
      if (this.c != null)
      {
        this.c.removeCallbacksAndMessages(null);
        this.c = null;
      }
      if (this.b != null)
      {
        this.b.quit();
        this.b = null;
      }
      this.j = null;
      if (this.f != null) {
        this.f = null;
      }
      ev.a("TxNewCellProvider", 4, "shutdown: state=[shutdown]");
      return;
    }
    finally {}
  }
  
  @SuppressLint({"NewApi"})
  public final void onCellInfoChanged(List<CellInfo> paramList)
  {
    ArrayList localArrayList;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localArrayList = new ArrayList();
      paramList = paramList.iterator();
      label126:
      while (paramList.hasNext())
      {
        Object localObject = (CellInfo)paramList.next();
        if (((CellInfo)localObject).isRegistered())
        {
          localObject = ee.a(this.g, (CellInfo)localObject);
          if ((((ee)localObject).b < 0) || (((ee)localObject).c < 0) || (((ee)localObject).b == 535) || (((ee)localObject).c == 535)) {}
          for (int m = 0;; m = 1)
          {
            if (m == 0) {
              break label126;
            }
            localArrayList.add(localObject);
            break;
          }
        }
      }
      if (localArrayList.size() <= 0) {
        break label150;
      }
      a(localArrayList);
    }
    label150:
    do
    {
      return;
      ev.b("TxNewCellProvider", "cellInfos list is null");
      ev.b("TxNewCellProvider", "cell info maybe has no rigister");
      paramList = this.k;
      if (paramList != null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(ee.a(this.g, paramList, null));
        a(localArrayList);
        return;
      }
      ev.b("TxNewCellProvider", "cellLocation is still null,so we use the last CellInfo,this happen when restart requestLocationUpdate");
    } while (this.i == null);
    paramList = new ArrayList();
    paramList.add(this.i);
    a(paramList);
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState)
  {
    int n = 1;
    int i2 = 0;
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null) {}
    for (;;)
    {
      return;
      try
      {
        ServiceState localServiceState = this.j;
        if ((localServiceState != null) && (localServiceState.getState() == paramServiceState.getState())) {
          continue;
        }
        this.j = paramServiceState;
        if (!this.a) {
          continue;
        }
        int m;
        boolean bool;
        if (this.j != null) {
          if (this.j.getState() == 0)
          {
            m = 1;
            paramServiceState = this.g.f;
            bool = er.a(this.g.a);
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
          paramServiceState.arg2 = i1;
          this.g.b(paramServiceState);
          return;
          m = this.j.getState();
          if (m == 1)
          {
            m = 0;
            break;
          }
          m = -1;
          break;
          label164:
          n = 0;
          label175:
          label177:
          do
          {
            i1 = m;
            break;
            n = 0;
            i1 = i2;
            if (bool) {
              break;
            }
          } while (n != 0);
          int i1 = i2;
        }
        return;
      }
      catch (Throwable paramServiceState) {}
    }
  }
  
  final class a
    extends Handler
  {
    private a(Looper paramLooper)
    {
      super();
    }
    
    @SuppressLint({"NewApi"})
    public final void handleMessage(Message paramMessage)
    {
      if (!dv.this.a) {}
      do
      {
        return;
        paramMessage = null;
        if (dv.b(dv.this) != null) {}
        try
        {
          List localList = dv.b(dv.this).getAllCellInfo();
          paramMessage = localList;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ev.a("TxNewCellProvider", "cannot get cellinfo", localThrowable);
          }
        }
        dv.a(dv.this, er.a(dv.c(dv.this)));
        dv.this.onCellInfoChanged(paramMessage);
      } while (dv.d(dv.this) == null);
      sendEmptyMessageDelayed(0, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dv
 * JD-Core Version:    0.7.0.1
 */
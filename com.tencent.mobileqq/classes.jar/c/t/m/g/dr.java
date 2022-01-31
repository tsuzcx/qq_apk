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

final class dr
  extends PhoneStateListener
{
  volatile boolean a;
  private final da b;
  private final TelephonyManager c;
  private ea d = null;
  private ServiceState e = null;
  private HandlerThread f;
  private Handler g;
  private Runnable h;
  private Handler i;
  private List<String> j;
  private CellLocation k;
  
  public dr(da paramda)
  {
    this.b = paramda;
    this.c = paramda.c();
    this.h = new Runnable()
    {
      public final void run()
      {
        dr.a(dr.this);
        dr.this.a = true;
      }
    };
  }
  
  private void a(int paramInt)
  {
    try
    {
      this.b.c().listen(this, paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      f.a.b("TxNewCellProvider", "listenCellState: failed! flags=" + paramInt + localThrowable.toString());
    }
  }
  
  private void a(List<ea> paramList)
  {
    ea localea = null;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    paramList = localea;
    if (localIterator.hasNext())
    {
      localea = (ea)localIterator.next();
      localArrayList.add(localea.b());
      if ((this.j == null) || (this.j.contains(localea.b()))) {
        break label152;
      }
      paramList = localea;
    }
    label152:
    for (;;)
    {
      break;
      this.j = localArrayList;
      if (paramList != null)
      {
        this.d = paramList;
        f.a.b("TxNewCellProvider", "notify");
        if ((!this.a) || (this.d == null) || (this.b == null)) {
          return;
        }
        try
        {
          this.b.b(this.d);
          return;
        }
        finally
        {
          paramList = finally;
          throw paramList;
        }
      }
      f.a.b("TxNewCellProvider", "onTxCellInfoChange: same cell ");
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
      if (this.g != null)
      {
        this.g.removeCallbacksAndMessages(null);
        this.g = null;
      }
      if (this.f != null)
      {
        this.f.quit();
        this.f = null;
      }
      this.e = null;
      if (this.j != null) {
        this.j = null;
      }
      f.a.a("TxNewCellProvider", "shutdown: state=[shutdown]");
      return;
    }
    finally {}
  }
  
  @SuppressLint({"NewApi"})
  public final void a(Handler paramHandler, boolean paramBoolean)
  {
    if (this.a) {}
    for (;;)
    {
      return;
      this.i = paramHandler;
      if (this.j == null) {
        this.j = new ArrayList();
      }
      this.f = new HandlerThread("new_cell_provider");
      if (this.f == null) {
        continue;
      }
      try
      {
        this.f.start();
        this.g = new a(this.f.getLooper(), (byte)0);
        this.g.post(this.h);
        if (paramBoolean) {
          continue;
        }
        this.g.sendEmptyMessage(0);
        return;
      }
      catch (Throwable paramHandler)
      {
        for (;;)
        {
          this.g = new a(this.i.getLooper(), (byte)0);
        }
      }
    }
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
          localObject = ea.a(this.b, (CellInfo)localObject);
          if ((((ea)localObject).b < 0) || (((ea)localObject).c < 0) || (((ea)localObject).b == 535) || (((ea)localObject).c == 535)) {}
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
      f.a.b("TxNewCellProvider", "cellInfos list is null");
      f.a.b("TxNewCellProvider", "cell info maybe has no rigister");
      paramList = this.k;
      if (paramList != null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(ea.a(this.b, paramList, null));
        a(localArrayList);
        return;
      }
      f.a.b("TxNewCellProvider", "cellLocation is still null,so we use the last CellInfo,this happen when restart requestLocationUpdate");
    } while (this.d == null);
    paramList = new ArrayList();
    paramList.add(this.d);
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
        ServiceState localServiceState = this.e;
        if ((localServiceState != null) && (localServiceState.getState() == paramServiceState.getState())) {
          continue;
        }
        this.e = paramServiceState;
        if (!this.a) {
          continue;
        }
        int m;
        boolean bool;
        if (this.e != null) {
          if (this.e.getState() == 0)
          {
            m = 1;
            paramServiceState = this.b.c();
            bool = en.a(this.b.a);
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
          this.b.b(paramServiceState);
          return;
          m = this.e.getState();
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
      if (!dr.this.a) {}
      do
      {
        return;
        paramMessage = null;
        if (dr.b(dr.this) != null) {}
        try
        {
          List localList = dr.b(dr.this).getAllCellInfo();
          paramMessage = localList;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            f.a.a("TxNewCellProvider", "cannot get cellinfo", localThrowable);
          }
        }
        dr.a(dr.this, en.a(dr.c(dr.this)));
        dr.this.onCellInfoChanged(paramMessage);
      } while (dr.d(dr.this) == null);
      sendEmptyMessageDelayed(0, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dr
 * JD-Core Version:    0.7.0.1
 */
package c.t.m.g;

import android.annotation.SuppressLint;
import android.os.Message;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import java.util.List;

final class ek$b
  extends PhoneStateListener
{
  public ek$b(ek paramek)
  {
    a(1297);
  }
  
  final void a(int paramInt)
  {
    try
    {
      this.a.c.f.listen(this, paramInt);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  @SuppressLint({"NewApi"})
  public final void onCellInfoChanged(List<CellInfo> paramList)
  {
    if (paramList != null) {
      paramList.size();
    }
    paramList = eq.a(this.a.c, paramList);
    ek.a(this.a, paramList, 0);
  }
  
  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    super.onCellLocationChanged(paramCellLocation);
    paramCellLocation = eq.a(this.a.c, paramCellLocation, this.a.j);
    ek.a(this.a, paramCellLocation, 1);
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
        Object localObject = this.a.e;
        if ((localObject != null) && (((ServiceState)localObject).getState() == paramServiceState.getState())) {
          continue;
        }
        this.a.e = paramServiceState;
        paramServiceState = this.a;
        if (!paramServiceState.a) {
          continue;
        }
        int i;
        boolean bool;
        if (paramServiceState.e != null) {
          if (paramServiceState.e.getState() == 0)
          {
            i = 1;
            localObject = paramServiceState.c.f;
            bool = fg.a(paramServiceState.c.a);
            if (localObject == null) {
              break label194;
            }
            if (((TelephonyManager)localObject).getSimState() != 5) {
              break label183;
            }
            break label196;
          }
        }
        for (;;)
        {
          localObject = new Message();
          ((Message)localObject).what = 12999;
          ((Message)localObject).arg1 = 12003;
          ((Message)localObject).arg2 = k;
          paramServiceState.c.b(localObject);
          return;
          i = paramServiceState.e.getState();
          if (i == 1)
          {
            i = 0;
            break;
          }
          i = -1;
          break;
          label183:
          j = 0;
          label194:
          label196:
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
    this.a.j = paramSignalStrength;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.ek.b
 * JD-Core Version:    0.7.0.1
 */
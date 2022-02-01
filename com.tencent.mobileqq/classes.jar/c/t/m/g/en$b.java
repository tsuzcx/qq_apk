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

final class en$b
  extends PhoneStateListener
{
  public en$b(en paramen)
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
    paramList = et.a(this.a.c, paramList);
    en.a(this.a, paramList, 0);
  }
  
  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    super.onCellLocationChanged(paramCellLocation);
    paramCellLocation = et.a(this.a.c, paramCellLocation, this.a.j);
    en.a(this.a, paramCellLocation, 1);
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
        Object localObject = this.a.e;
        if ((localObject == null) || (((ServiceState)localObject).getState() != paramServiceState.getState()))
        {
          this.a.e = paramServiceState;
          paramServiceState = this.a;
          if (paramServiceState.a)
          {
            localObject = paramServiceState.e;
            j = 1;
            if (localObject == null) {
              break label181;
            }
            if (paramServiceState.e.getState() == 0)
            {
              i = 1;
            }
            else
            {
              if (paramServiceState.e.getState() != 1) {
                break label181;
              }
              i = 0;
            }
            localObject = paramServiceState.c.f;
            bool = fj.a(paramServiceState.c.a);
            if ((localObject == null) || (((TelephonyManager)localObject).getSimState() != 5)) {
              break label186;
            }
            break label188;
            localObject = new Message();
            ((Message)localObject).what = 12999;
            ((Message)localObject).arg1 = 12003;
            ((Message)localObject).arg2 = i;
            paramServiceState.c.b(localObject);
          }
        }
        return;
      }
      catch (Throwable paramServiceState)
      {
        return;
      }
      label181:
      int i = -1;
      continue;
      label186:
      int j = 0;
      label188:
      if ((bool) || (j == 0)) {
        i = 0;
      }
    }
  }
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    this.a.j = paramSignalStrength;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.en.b
 * JD-Core Version:    0.7.0.1
 */
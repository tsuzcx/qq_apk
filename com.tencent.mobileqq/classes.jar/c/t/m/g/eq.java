package c.t.m.g;

import android.annotation.SuppressLint;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.telephony.CellInfo;>;

public final class eq
  extends et
{
  public eq.a a = eq.a.a;
  public int b = 460;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 2147483647;
  public int h = 2147483647;
  public final long i = System.currentTimeMillis();
  public boolean j = false;
  public List<String> k = new ArrayList();
  private List<NeighboringCellInfo> l;
  private List<eq> m;
  
  @SuppressLint({"NewApi"})
  private static eq a(dx paramdx, CellInfo paramCellInfo)
  {
    int n = -88;
    if ((paramCellInfo == null) || (paramdx == null)) {
      return null;
    }
    Object localObject = paramdx.f;
    paramdx = new eq();
    do
    {
      for (;;)
      {
        try
        {
          if (!(paramCellInfo instanceof CellInfoCdma)) {
            continue;
          }
          paramCellInfo = (CellInfoCdma)paramCellInfo;
          CellIdentityCdma localCellIdentityCdma = paramCellInfo.getCellIdentity();
          paramdx.a = eq.a.c;
          paramdx.a((TelephonyManager)localObject, eq.a.c);
          paramdx.c = localCellIdentityCdma.getSystemId();
          paramdx.d = localCellIdentityCdma.getNetworkId();
          paramdx.e = localCellIdentityCdma.getBasestationId();
          paramdx.g = localCellIdentityCdma.getLatitude();
          paramdx.h = localCellIdentityCdma.getLongitude();
          i2 = paramCellInfo.getCellSignalStrength().getDbm();
          i1 = n;
          if (i2 > -110)
          {
            i1 = n;
            if (i2 < -40) {
              i1 = i2;
            }
          }
          paramdx.f = i1;
        }
        catch (Throwable paramCellInfo)
        {
          int i2;
          int i1;
          continue;
        }
        if (paramdx.d()) {
          paramdx.j = true;
        }
        paramdx.k.add(paramdx.c());
        return paramdx;
        if ((paramCellInfo instanceof CellInfoGsm))
        {
          paramCellInfo = (CellInfoGsm)paramCellInfo;
          paramdx.a = eq.a.b;
          localObject = paramCellInfo.getCellIdentity();
          paramdx.d = ((CellIdentityGsm)localObject).getLac();
          paramdx.e = ((CellIdentityGsm)localObject).getCid();
          paramdx.b = ((CellIdentityGsm)localObject).getMcc();
          paramdx.c = ((CellIdentityGsm)localObject).getMnc();
          i2 = paramCellInfo.getCellSignalStrength().getDbm();
          i1 = n;
          if (i2 > -110)
          {
            i1 = n;
            if (i2 < -40) {
              i1 = i2;
            }
          }
          paramdx.f = i1;
        }
        else
        {
          if (!(paramCellInfo instanceof CellInfoWcdma)) {
            continue;
          }
          paramCellInfo = (CellInfoWcdma)paramCellInfo;
          paramdx.a = eq.a.d;
          localObject = paramCellInfo.getCellIdentity();
          paramdx.d = ((CellIdentityWcdma)localObject).getLac();
          paramdx.e = ((CellIdentityWcdma)localObject).getCid();
          paramdx.b = ((CellIdentityWcdma)localObject).getMcc();
          paramdx.c = ((CellIdentityWcdma)localObject).getMnc();
          i2 = paramCellInfo.getCellSignalStrength().getDbm();
          i1 = n;
          if (i2 > -110)
          {
            i1 = n;
            if (i2 < -40) {
              i1 = i2;
            }
          }
          paramdx.f = i1;
        }
      }
    } while (!(paramCellInfo instanceof CellInfoLte));
    paramCellInfo = (CellInfoLte)paramCellInfo;
    paramdx.a = eq.a.e;
    localObject = paramCellInfo.getCellIdentity();
    paramdx.d = ((CellIdentityLte)localObject).getTac();
    paramdx.e = ((CellIdentityLte)localObject).getCi();
    paramdx.b = ((CellIdentityLte)localObject).getMcc();
    paramdx.c = ((CellIdentityLte)localObject).getMnc();
    n = paramCellInfo.getCellSignalStrength().getDbm();
    if ((n > -110) && (n < -40)) {}
    for (;;)
    {
      paramdx.f = n;
      break;
      n = -88;
    }
  }
  
  public static eq a(dx paramdx, CellLocation paramCellLocation, SignalStrength paramSignalStrength)
  {
    if ((!paramdx.b()) || (paramCellLocation == null)) {
      return null;
    }
    TelephonyManager localTelephonyManager = paramdx.f;
    paramdx = new eq();
    for (;;)
    {
      try
      {
        if (!(paramCellLocation instanceof CdmaCellLocation)) {
          continue;
        }
        paramCellLocation = (CdmaCellLocation)paramCellLocation;
        paramdx.a = eq.a.c;
        paramdx.a(localTelephonyManager, eq.a.c);
        paramdx.c = paramCellLocation.getSystemId();
        paramdx.d = paramCellLocation.getNetworkId();
        paramdx.e = paramCellLocation.getBaseStationId();
        paramdx.g = paramCellLocation.getBaseStationLatitude();
        paramdx.h = paramCellLocation.getBaseStationLongitude();
        if (paramSignalStrength != null) {
          continue;
        }
        paramdx.f = -1;
      }
      catch (Throwable paramCellLocation)
      {
        continue;
      }
      if (paramdx.d()) {
        paramdx.j = true;
      }
      paramdx.k.add(paramdx.c());
      return paramdx;
      paramdx.f = paramSignalStrength.getCdmaDbm();
      continue;
      paramCellLocation = (GsmCellLocation)paramCellLocation;
      paramdx.a = eq.a.b;
      paramdx.a(localTelephonyManager, eq.a.b);
      paramdx.d = paramCellLocation.getLac();
      paramdx.e = paramCellLocation.getCid();
      if (paramSignalStrength == null) {
        paramdx.f = -1;
      } else {
        paramdx.f = (paramSignalStrength.getGsmSignalStrength() * 2 - 113);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public static eq a(dx paramdx, List<CellInfo> paramList)
  {
    if ((paramList == null) || (paramdx == null) || (paramList.size() == 0)) {
      return new eq();
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = new eq();
    Iterator localIterator = paramList.iterator();
    int n = 1;
    paramList = (List<CellInfo>)localObject;
    while (localIterator.hasNext())
    {
      localObject = (CellInfo)localIterator.next();
      if (((CellInfo)localObject).isRegistered())
      {
        localObject = a(paramdx, (CellInfo)localObject);
        if (((eq)localObject).d())
        {
          paramList.k.add(((eq)localObject).c());
          if (n != 0)
          {
            ((eq)localObject).j = true;
            n = 0;
            paramList = (List<CellInfo>)localObject;
          }
          else
          {
            localArrayList.add(localObject);
          }
        }
      }
    }
    paramList.m = localArrayList;
    return paramList;
  }
  
  private void a(TelephonyManager paramTelephonyManager, eq.a parama)
  {
    int i2 = 0;
    int n = 0;
    paramTelephonyManager = paramTelephonyManager.getNetworkOperator();
    if ((paramTelephonyManager != null) && (paramTelephonyManager.length() >= 5)) {}
    for (;;)
    {
      int i3;
      try
      {
        i3 = Integer.parseInt(paramTelephonyManager.substring(0, 3));
      }
      catch (Throwable paramTelephonyManager)
      {
        int i4;
        i1 = 460;
        continue;
      }
      try
      {
        i4 = Integer.parseInt(paramTelephonyManager.substring(3, 5));
        n = i4;
        i1 = i3;
        if (i3 == 460)
        {
          n = i4;
          i1 = i3;
          if (i4 == 3)
          {
            n = i4;
            i1 = i3;
            i2 = i4;
            if (parama != eq.a.c)
            {
              n = i4;
              i1 = i3;
              i2 = i4;
              if (paramTelephonyManager.length() == 11)
              {
                i2 = i4;
                n = Integer.parseInt(paramTelephonyManager.substring(9, 11));
                i1 = i3;
              }
            }
          }
        }
      }
      catch (Throwable paramTelephonyManager)
      {
        n = i2;
        i1 = i3;
        continue;
      }
      if ((i1 > 0) && (n >= 0))
      {
        this.b = i1;
        this.c = n;
      }
      return;
      int i1 = 460;
    }
  }
  
  private boolean d()
  {
    boolean bool = true;
    if (this.a != eq.a.c) {
      if ((this.b < 0) || (this.c < 0) || (this.b == 535) || (this.c == 535) || (this.d < 0) || (this.d == 65535) || (this.d == 25840) || (this.e == 65535) || (this.e == 268435455) || (this.e == 2147483647) || (this.e == 50594049) || (this.e == 8) || (this.e == 10) || (this.e == 33) || (this.e <= 0)) {
        bool = false;
      }
    }
    while ((this.b >= 0) && (this.c >= 0) && (this.b != 535) && (this.c != 535) && (this.d >= 0) && (this.d != 65535) && (this.e != 65535) && (this.e > 0)) {
      return bool;
    }
    return false;
  }
  
  public final List<NeighboringCellInfo> a()
  {
    try
    {
      if (this.l == null) {
        this.l = Collections.emptyList();
      }
      List localList = this.l;
      return localList;
    }
    finally {}
  }
  
  public final void a(List<NeighboringCellInfo> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        this.l = Collections.unmodifiableList(paramList);
        return;
      }
      finally {}
      this.l = Collections.emptyList();
    }
  }
  
  public final List<eq> b()
  {
    if (this.m == null) {
      this.m = Collections.emptyList();
    }
    return this.m;
  }
  
  public final String c()
  {
    return this.b + this.c + this.d + this.e;
  }
  
  public final String toString()
  {
    return "TxCellInfo [PhoneType=" + this.a + ", MCC=" + this.b + ", MNC=" + this.c + ", LAC=" + this.d + ", CID=" + this.e + ", RSSI=" + this.f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.eq
 * JD-Core Version:    0.7.0.1
 */
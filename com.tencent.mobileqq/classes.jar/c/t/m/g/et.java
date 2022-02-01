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

public final class et
  extends ew
{
  public et.a a = et.a.a;
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
  private List<et> m;
  
  @SuppressLint({"NewApi"})
  private static et a(ea paramea, CellInfo paramCellInfo)
  {
    Object localObject;
    if ((paramCellInfo != null) && (paramea != null))
    {
      localObject = paramea.f;
      paramea = new et();
    }
    try
    {
      if (!(paramCellInfo instanceof CellInfoCdma)) {
        break label133;
      }
      paramCellInfo = (CellInfoCdma)paramCellInfo;
      CellIdentityCdma localCellIdentityCdma = paramCellInfo.getCellIdentity();
      paramea.a = et.a.c;
      paramea.a((TelephonyManager)localObject, et.a.c);
      paramea.c = localCellIdentityCdma.getSystemId();
      paramea.d = localCellIdentityCdma.getNetworkId();
      paramea.e = localCellIdentityCdma.getBasestationId();
      paramea.g = localCellIdentityCdma.getLatitude();
      paramea.h = localCellIdentityCdma.getLongitude();
      n = paramCellInfo.getCellSignalStrength().getDbm();
      if ((n <= -110) || (n >= -40)) {
        break label428;
      }
    }
    catch (Throwable paramCellInfo)
    {
      for (;;)
      {
        continue;
        int n = -88;
        continue;
        n = -88;
        continue;
        n = -88;
        continue;
        n = -88;
      }
    }
    paramea.f = n;
    break label394;
    label133:
    if ((paramCellInfo instanceof CellInfoGsm))
    {
      paramCellInfo = (CellInfoGsm)paramCellInfo;
      paramea.a = et.a.b;
      localObject = paramCellInfo.getCellIdentity();
      paramea.d = ((CellIdentityGsm)localObject).getLac();
      paramea.e = ((CellIdentityGsm)localObject).getCid();
      paramea.b = ((CellIdentityGsm)localObject).getMcc();
      paramea.c = ((CellIdentityGsm)localObject).getMnc();
      n = paramCellInfo.getCellSignalStrength().getDbm();
      if ((n <= -110) || (n >= -40)) {
        break label434;
      }
      paramea.f = n;
    }
    else if ((paramCellInfo instanceof CellInfoWcdma))
    {
      paramCellInfo = (CellInfoWcdma)paramCellInfo;
      paramea.a = et.a.d;
      localObject = paramCellInfo.getCellIdentity();
      paramea.d = ((CellIdentityWcdma)localObject).getLac();
      paramea.e = ((CellIdentityWcdma)localObject).getCid();
      paramea.b = ((CellIdentityWcdma)localObject).getMcc();
      paramea.c = ((CellIdentityWcdma)localObject).getMnc();
      n = paramCellInfo.getCellSignalStrength().getDbm();
      if ((n <= -110) || (n >= -40)) {
        break label440;
      }
      paramea.f = n;
    }
    else if ((paramCellInfo instanceof CellInfoLte))
    {
      paramCellInfo = (CellInfoLte)paramCellInfo;
      paramea.a = et.a.e;
      localObject = paramCellInfo.getCellIdentity();
      paramea.d = ((CellIdentityLte)localObject).getTac();
      paramea.e = ((CellIdentityLte)localObject).getCi();
      paramea.b = ((CellIdentityLte)localObject).getMcc();
      paramea.c = ((CellIdentityLte)localObject).getMnc();
      n = paramCellInfo.getCellSignalStrength().getDbm();
      if ((n <= -110) || (n >= -40)) {
        break label446;
      }
      paramea.f = n;
    }
    label394:
    if (paramea.d()) {
      paramea.j = true;
    }
    paramea.k.add(paramea.c());
    return paramea;
    return null;
  }
  
  public static et a(ea paramea, CellLocation paramCellLocation, SignalStrength paramSignalStrength)
  {
    TelephonyManager localTelephonyManager;
    if ((paramea.b()) && (paramCellLocation != null))
    {
      localTelephonyManager = paramea.f;
      paramea = new et();
    }
    try
    {
      if ((paramCellLocation instanceof CdmaCellLocation))
      {
        paramCellLocation = (CdmaCellLocation)paramCellLocation;
        paramea.a = et.a.c;
        paramea.a(localTelephonyManager, et.a.c);
        paramea.c = paramCellLocation.getSystemId();
        paramea.d = paramCellLocation.getNetworkId();
        paramea.e = paramCellLocation.getBaseStationId();
        paramea.g = paramCellLocation.getBaseStationLatitude();
        paramea.h = paramCellLocation.getBaseStationLongitude();
        if (paramSignalStrength == null) {
          paramea.f = -1;
        } else {
          paramea.f = paramSignalStrength.getCdmaDbm();
        }
      }
      else
      {
        paramCellLocation = (GsmCellLocation)paramCellLocation;
        paramea.a = et.a.b;
        paramea.a(localTelephonyManager, et.a.b);
        paramea.d = paramCellLocation.getLac();
        paramea.e = paramCellLocation.getCid();
        if (paramSignalStrength == null) {
          paramea.f = -1;
        } else {
          paramea.f = (paramSignalStrength.getGsmSignalStrength() * 2 - 113);
        }
      }
    }
    catch (Throwable paramCellLocation)
    {
      label181:
      break label181;
    }
    if (paramea.d()) {
      paramea.j = true;
    }
    paramea.k.add(paramea.c());
    return paramea;
    return null;
  }
  
  @SuppressLint({"NewApi"})
  public static et a(ea paramea, List<CellInfo> paramList)
  {
    if ((paramList != null) && (paramea != null) && (paramList.size() != 0))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject = new et();
      Iterator localIterator = paramList.iterator();
      int n = 1;
      paramList = (List<CellInfo>)localObject;
      while (localIterator.hasNext())
      {
        localObject = (CellInfo)localIterator.next();
        if (((CellInfo)localObject).isRegistered())
        {
          localObject = a(paramea, (CellInfo)localObject);
          if (((et)localObject).d())
          {
            paramList.k.add(((et)localObject).c());
            if (n != 0)
            {
              n = 0;
              ((et)localObject).j = true;
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
    return new et();
  }
  
  private void a(TelephonyManager paramTelephonyManager, et.a parama)
  {
    paramTelephonyManager = paramTelephonyManager.getNetworkOperator();
    int i5 = 0;
    i2 = 0;
    i4 = 460;
    n = i2;
    i1 = i4;
    if (paramTelephonyManager != null)
    {
      n = i2;
      i1 = i4;
      if (paramTelephonyManager.length() < 5) {}
    }
    try
    {
      i3 = Integer.parseInt(paramTelephonyManager.substring(0, 3));
      i1 = i5;
    }
    catch (Throwable paramTelephonyManager)
    {
      for (;;)
      {
        int i3;
        label134:
        n = i2;
        i1 = i4;
      }
    }
    try
    {
      i2 = Integer.parseInt(paramTelephonyManager.substring(3, 5));
      n = i2;
      if (i3 == 460)
      {
        n = i2;
        if (i2 == 3)
        {
          n = i2;
          i1 = i2;
          if (parama != et.a.c)
          {
            n = i2;
            i1 = i2;
            if (paramTelephonyManager.length() == 11)
            {
              i1 = i2;
              n = Integer.parseInt(paramTelephonyManager.substring(9, 11));
            }
          }
        }
      }
    }
    catch (Throwable paramTelephonyManager)
    {
      n = i1;
      break label134;
    }
    i1 = i3;
    if ((i1 > 0) && (n >= 0))
    {
      this.b = i1;
      this.c = n;
    }
  }
  
  private boolean d()
  {
    int i1;
    if (this.a != et.a.c)
    {
      n = this.b;
      if (n >= 0)
      {
        i1 = this.c;
        if ((i1 >= 0) && (n != 535) && (i1 != 535))
        {
          n = this.d;
          if ((n >= 0) && (n != 65535) && (n != 25840))
          {
            n = this.e;
            if ((n != 65535) && (n != 268435455) && (n != 2147483647) && (n != 50594049) && (n != 8) && (n != 10) && (n != 33)) {
              return n > 0;
            }
          }
        }
      }
      return false;
    }
    int n = this.b;
    if (n >= 0)
    {
      i1 = this.c;
      if ((i1 >= 0) && (n != 535) && (i1 != 535))
      {
        n = this.d;
        if ((n >= 0) && (n != 65535))
        {
          n = this.e;
          if (n != 65535) {
            return n > 0;
          }
        }
      }
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
    try
    {
      this.l = Collections.unmodifiableList(paramList);
      return;
    }
    finally {}
    this.l = Collections.emptyList();
  }
  
  public final List<et> b()
  {
    if (this.m == null) {
      this.m = Collections.emptyList();
    }
    return this.m;
  }
  
  public final String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(this.c);
    localStringBuilder.append(this.d);
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TxCellInfo [PhoneType=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", MCC=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", MNC=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", LAC=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", CID=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", RSSI=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", LAT=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", LNG=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mTime=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.et
 * JD-Core Version:    0.7.0.1
 */
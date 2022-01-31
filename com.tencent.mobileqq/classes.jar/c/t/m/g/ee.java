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
import android.util.Log;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class ee
  extends eh
{
  public int a = 0;
  public int b = 460;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 2147483647;
  public int h = 2147483647;
  private final long i = System.currentTimeMillis();
  private List<NeighboringCellInfo> j;
  
  @SuppressLint({"NewApi"})
  @Nullable
  public static ee a(de paramde, CellInfo paramCellInfo)
  {
    int k = -88;
    if (paramCellInfo == null) {
      paramde = null;
    }
    ee localee;
    do
    {
      return paramde;
      paramde = paramde.f;
      localee = new ee();
      int n;
      int m;
      try
      {
        if ((paramCellInfo instanceof CellInfoCdma))
        {
          paramCellInfo = (CellInfoCdma)paramCellInfo;
          CellIdentityCdma localCellIdentityCdma = paramCellInfo.getCellIdentity();
          localee.a = 2;
          localee.a(paramde);
          localee.c = localCellIdentityCdma.getSystemId();
          localee.d = localCellIdentityCdma.getNetworkId();
          localee.e = localCellIdentityCdma.getBasestationId();
          localee.g = localCellIdentityCdma.getLatitude();
          localee.h = localCellIdentityCdma.getLongitude();
          n = paramCellInfo.getCellSignalStrength().getDbm();
          m = k;
          if (n > -110)
          {
            m = k;
            if (n < -40) {
              m = n;
            }
          }
          localee.f = m;
          return localee;
        }
      }
      catch (Throwable paramde)
      {
        Log.e("TxCellInfo", paramde.toString());
        return localee;
      }
      if ((paramCellInfo instanceof CellInfoGsm))
      {
        paramde = (CellInfoGsm)paramCellInfo;
        localee.a = 1;
        paramCellInfo = paramde.getCellIdentity();
        localee.d = paramCellInfo.getLac();
        localee.e = paramCellInfo.getCid();
        localee.b = paramCellInfo.getMcc();
        localee.c = paramCellInfo.getMnc();
        n = paramde.getCellSignalStrength().getDbm();
        m = k;
        if (n > -110)
        {
          m = k;
          if (n < -40) {
            m = n;
          }
        }
        localee.f = m;
        return localee;
      }
      if ((paramCellInfo instanceof CellInfoWcdma))
      {
        paramde = (CellInfoWcdma)paramCellInfo;
        localee.a = 1;
        paramCellInfo = paramde.getCellIdentity();
        localee.d = paramCellInfo.getLac();
        localee.e = paramCellInfo.getCid();
        localee.b = paramCellInfo.getMcc();
        localee.c = paramCellInfo.getMnc();
        n = paramde.getCellSignalStrength().getDbm();
        m = k;
        if (n > -110)
        {
          m = k;
          if (n < -40) {
            m = n;
          }
        }
        localee.f = m;
        return localee;
      }
      paramde = localee;
    } while (!(paramCellInfo instanceof CellInfoLte));
    paramde = (CellInfoLte)paramCellInfo;
    localee.a = 1;
    paramCellInfo = paramde.getCellIdentity();
    localee.d = paramCellInfo.getTac();
    localee.e = paramCellInfo.getCi();
    localee.b = paramCellInfo.getMcc();
    localee.c = paramCellInfo.getMnc();
    k = paramde.getCellSignalStrength().getDbm();
    if ((k > -110) && (k < -40)) {}
    for (;;)
    {
      localee.f = k;
      return localee;
      k = -88;
    }
  }
  
  @Nullable
  public static ee a(de paramde, CellLocation paramCellLocation, SignalStrength paramSignalStrength)
  {
    if ((!paramde.b()) || (paramCellLocation == null)) {
      return null;
    }
    TelephonyManager localTelephonyManager = paramde.f;
    paramde = new ee();
    try
    {
      if (!(paramCellLocation instanceof CdmaCellLocation)) {
        break label123;
      }
      paramCellLocation = (CdmaCellLocation)paramCellLocation;
      paramde.a = 2;
      paramde.a(localTelephonyManager);
      paramde.c = paramCellLocation.getSystemId();
      paramde.d = paramCellLocation.getNetworkId();
      paramde.e = paramCellLocation.getBaseStationId();
      paramde.g = paramCellLocation.getBaseStationLatitude();
      paramde.h = paramCellLocation.getBaseStationLongitude();
      if (paramSignalStrength == null)
      {
        paramde.f = -1;
        return paramde;
      }
    }
    catch (Throwable paramCellLocation)
    {
      ev.a("TxCellInfo", 6, paramCellLocation.toString());
      return paramde;
    }
    paramde.f = paramSignalStrength.getCdmaDbm();
    return paramde;
    label123:
    paramCellLocation = (GsmCellLocation)paramCellLocation;
    paramde.a = 1;
    paramde.a(localTelephonyManager);
    paramde.d = paramCellLocation.getLac();
    paramde.e = paramCellLocation.getCid();
    if (paramSignalStrength == null)
    {
      paramde.f = -1;
      return paramde;
    }
    paramde.f = (paramSignalStrength.getGsmSignalStrength() * 2 - 113);
    return paramde;
  }
  
  private void a(TelephonyManager paramTelephonyManager)
  {
    int[] arrayOfInt = new int[2];
    er.a(paramTelephonyManager, arrayOfInt);
    if ((arrayOfInt[0] > 0) && (arrayOfInt[1] >= 0))
    {
      this.b = arrayOfInt[0];
      this.c = arrayOfInt[1];
    }
  }
  
  @NonNull
  public final List<NeighboringCellInfo> a()
  {
    try
    {
      if (this.j == null) {
        this.j = Collections.emptyList();
      }
      List localList = this.j;
      return localList;
    }
    finally {}
  }
  
  public final void a(@Nullable List<NeighboringCellInfo> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        this.j = Collections.unmodifiableList(paramList);
        return;
      }
      finally {}
      this.j = Collections.emptyList();
    }
  }
  
  public final String b()
  {
    return this.b + this.c + this.d + this.e;
  }
  
  public final String toString()
  {
    return "TxCellInfo [PhoneType=" + this.a + ", MCC=" + this.b + ", MNC=" + this.c + ", LAC=" + this.d + ", CID=" + this.e + ", RSSI=" + this.f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ee
 * JD-Core Version:    0.7.0.1
 */
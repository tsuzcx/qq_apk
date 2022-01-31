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

public final class ea
  extends ed
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
  public static ea a(da paramda, CellInfo paramCellInfo)
  {
    int k = -88;
    if (paramCellInfo == null) {
      paramda = null;
    }
    ea localea;
    do
    {
      return paramda;
      paramda = paramda.c();
      localea = new ea();
      int n;
      int m;
      try
      {
        if ((paramCellInfo instanceof CellInfoCdma))
        {
          paramCellInfo = (CellInfoCdma)paramCellInfo;
          CellIdentityCdma localCellIdentityCdma = paramCellInfo.getCellIdentity();
          localea.a = 2;
          localea.a(paramda);
          localea.c = localCellIdentityCdma.getSystemId();
          localea.d = localCellIdentityCdma.getNetworkId();
          localea.e = localCellIdentityCdma.getBasestationId();
          localea.g = localCellIdentityCdma.getLatitude();
          localea.h = localCellIdentityCdma.getLongitude();
          n = paramCellInfo.getCellSignalStrength().getDbm();
          m = k;
          if (n > -110)
          {
            m = k;
            if (n < -40) {
              m = n;
            }
          }
          localea.f = m;
          return localea;
        }
      }
      catch (Throwable paramda)
      {
        Log.e("TxCellInfo", paramda.toString());
        return localea;
      }
      if ((paramCellInfo instanceof CellInfoGsm))
      {
        paramda = (CellInfoGsm)paramCellInfo;
        localea.a = 1;
        paramCellInfo = paramda.getCellIdentity();
        localea.d = paramCellInfo.getLac();
        localea.e = paramCellInfo.getCid();
        localea.b = paramCellInfo.getMcc();
        localea.c = paramCellInfo.getMnc();
        n = paramda.getCellSignalStrength().getDbm();
        m = k;
        if (n > -110)
        {
          m = k;
          if (n < -40) {
            m = n;
          }
        }
        localea.f = m;
        return localea;
      }
      if ((paramCellInfo instanceof CellInfoWcdma))
      {
        paramda = (CellInfoWcdma)paramCellInfo;
        localea.a = 1;
        paramCellInfo = paramda.getCellIdentity();
        localea.d = paramCellInfo.getLac();
        localea.e = paramCellInfo.getCid();
        localea.b = paramCellInfo.getMcc();
        localea.c = paramCellInfo.getMnc();
        n = paramda.getCellSignalStrength().getDbm();
        m = k;
        if (n > -110)
        {
          m = k;
          if (n < -40) {
            m = n;
          }
        }
        localea.f = m;
        return localea;
      }
      paramda = localea;
    } while (!(paramCellInfo instanceof CellInfoLte));
    paramda = (CellInfoLte)paramCellInfo;
    localea.a = 1;
    paramCellInfo = paramda.getCellIdentity();
    localea.d = paramCellInfo.getTac();
    localea.e = paramCellInfo.getCi();
    localea.b = paramCellInfo.getMcc();
    localea.c = paramCellInfo.getMnc();
    k = paramda.getCellSignalStrength().getDbm();
    if ((k > -110) && (k < -40)) {}
    for (;;)
    {
      localea.f = k;
      return localea;
      k = -88;
    }
  }
  
  @Nullable
  public static ea a(da paramda, CellLocation paramCellLocation, SignalStrength paramSignalStrength)
  {
    if ((!paramda.f()) || (paramCellLocation == null)) {
      return null;
    }
    TelephonyManager localTelephonyManager = paramda.c();
    paramda = new ea();
    try
    {
      if (!(paramCellLocation instanceof CdmaCellLocation)) {
        break label121;
      }
      paramCellLocation = (CdmaCellLocation)paramCellLocation;
      paramda.a = 2;
      paramda.a(localTelephonyManager);
      paramda.c = paramCellLocation.getSystemId();
      paramda.d = paramCellLocation.getNetworkId();
      paramda.e = paramCellLocation.getBaseStationId();
      paramda.g = paramCellLocation.getBaseStationLatitude();
      paramda.h = paramCellLocation.getBaseStationLongitude();
      if (paramSignalStrength == null)
      {
        paramda.f = -1;
        return paramda;
      }
    }
    catch (Throwable paramCellLocation)
    {
      f.a.b("TxCellInfo", paramCellLocation.toString());
      return paramda;
    }
    paramda.f = paramSignalStrength.getCdmaDbm();
    return paramda;
    label121:
    paramCellLocation = (GsmCellLocation)paramCellLocation;
    paramda.a = 1;
    paramda.a(localTelephonyManager);
    paramda.d = paramCellLocation.getLac();
    paramda.e = paramCellLocation.getCid();
    if (paramSignalStrength == null)
    {
      paramda.f = -1;
      return paramda;
    }
    paramda.f = (paramSignalStrength.getGsmSignalStrength() * 2 - 113);
    return paramda;
  }
  
  private void a(TelephonyManager paramTelephonyManager)
  {
    int[] arrayOfInt = new int[2];
    en.a(paramTelephonyManager, arrayOfInt);
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
 * Qualified Name:     c.t.m.g.ea
 * JD-Core Version:    0.7.0.1
 */
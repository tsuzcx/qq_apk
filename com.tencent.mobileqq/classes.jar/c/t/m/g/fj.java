package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class fj
{
  public static boolean a = false;
  
  public static int a(CellLocation paramCellLocation)
  {
    if ((paramCellLocation instanceof CdmaCellLocation)) {
      return ((CdmaCellLocation)paramCellLocation).getBaseStationId();
    }
    try
    {
      int i = ((GsmCellLocation)paramCellLocation).getCid();
      return i;
    }
    catch (Exception paramCellLocation)
    {
      label25:
      break label25;
    }
    return -1;
  }
  
  public static CellLocation a(ea paramea)
  {
    TelephonyManager localTelephonyManager = paramea.f;
    if (localTelephonyManager != null) {}
    try
    {
      localCellLocation = PhoneInfoMonitor.getCellLocation(localTelephonyManager);
      i = localTelephonyManager.getSimState();
      bool2 = false;
      if (i == 5) {
        i = 1;
      } else {
        i = 0;
      }
    }
    catch (Exception paramea)
    {
      CellLocation localCellLocation;
      int i;
      int j;
      label55:
      label103:
      label110:
      break label110;
    }
    try
    {
      bool1 = TextUtils.isEmpty(PhoneInfoMonitor.getSubscriberId(localTelephonyManager));
      j = bool1 ^ true;
    }
    catch (Exception localException)
    {
      break label55;
      bool1 = bool2;
      if (bool3) {
        break label103;
      }
      bool1 = true;
      break label103;
    }
    j = 1;
    if ((i != 0) && (j != 0))
    {
      bool3 = a(paramea.a);
      i = a(localCellLocation);
      if ((localCellLocation != null) && (!b(localCellLocation)))
      {
        bool1 = bool2;
        if (i >= 0) {
          a = bool1;
        }
      }
    }
    else
    {
      return localCellLocation;
      a = true;
      return CellLocation.getEmpty();
    }
  }
  
  private static boolean a(int paramInt)
  {
    return paramInt != et.a.c.ordinal();
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (b(paramInt1))
    {
      if ((paramInt2 >= 0) && (paramInt3 >= 0) && (paramInt4 > 0) && (paramInt4 < 65535) && (paramInt5 > 0) && (paramInt5 < 65535)) {
        return (paramInt3 != 0) || (paramInt4 != 0) || (paramInt5 != 0);
      }
      return false;
    }
    if ((paramInt2 >= 0) && (paramInt3 >= 0) && (paramInt4 > 0) && (paramInt4 < 65535) && (paramInt5 != 268435455) && (paramInt5 != 2147483647) && (paramInt5 != 50594049) && (paramInt5 != 65535)) {
      return paramInt5 > 0;
    }
    return false;
  }
  
  public static boolean a(int paramInt, SignalStrength paramSignalStrength1, SignalStrength paramSignalStrength2)
  {
    if (paramSignalStrength1 != null)
    {
      if (paramSignalStrength2 == null) {
        return true;
      }
      int i = Math.abs(b(paramInt, paramSignalStrength1, paramSignalStrength2));
      if (a(paramInt)) {
        return i > 3;
      }
      return (b(paramInt)) && (i > 6);
    }
    return true;
  }
  
  @SuppressLint({"NewApi"})
  public static boolean a(Context paramContext)
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 17)
      {
        if (Settings.Global.getInt(paramContext.getContentResolver(), "airplane_mode_on") == 1) {
          break label49;
        }
      }
      else
      {
        i = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on");
        if (i == 1) {
          break label49;
        }
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      return false;
    }
    label49:
    return true;
  }
  
  public static boolean a(CellLocation paramCellLocation1, CellLocation paramCellLocation2)
  {
    int i;
    if ((paramCellLocation1 != null) && (paramCellLocation2 != null)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    if (paramCellLocation1.getClass() != paramCellLocation2.getClass()) {
      return false;
    }
    if ((paramCellLocation1 instanceof GsmCellLocation))
    {
      paramCellLocation1 = (GsmCellLocation)paramCellLocation1;
      paramCellLocation2 = (GsmCellLocation)paramCellLocation2;
      return paramCellLocation1.getCid() == paramCellLocation2.getCid();
    }
    if ((paramCellLocation1 instanceof CdmaCellLocation))
    {
      paramCellLocation1 = (CdmaCellLocation)paramCellLocation1;
      paramCellLocation2 = (CdmaCellLocation)paramCellLocation2;
      if (paramCellLocation1.getBaseStationId() == paramCellLocation2.getBaseStationId()) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(et paramet)
  {
    int i;
    if (paramet == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return false;
    }
    return a(paramet.a.ordinal(), paramet.b, paramet.c, paramet.d, paramet.e);
  }
  
  private static int b(int paramInt, SignalStrength paramSignalStrength1, SignalStrength paramSignalStrength2)
  {
    try
    {
      if (a(paramInt)) {
        return paramSignalStrength1.getGsmSignalStrength() - paramSignalStrength2.getGsmSignalStrength();
      }
      if (b(paramInt))
      {
        paramInt = paramSignalStrength1.getCdmaDbm();
        int i = paramSignalStrength2.getCdmaDbm();
        return paramInt - i;
      }
    }
    catch (Throwable paramSignalStrength1)
    {
      label38:
      break label38;
    }
    return 0;
  }
  
  @SuppressLint({"NewApi"})
  public static List<CellInfo> b(ea paramea)
  {
    try
    {
      paramea = PhoneInfoMonitor.getAllCellInfo(paramea.f);
      if (paramea != null) {
        return paramea;
      }
    }
    catch (Throwable paramea)
    {
      label14:
      break label14;
    }
    return new ArrayList();
  }
  
  private static boolean b(int paramInt)
  {
    return paramInt == et.a.c.ordinal();
  }
  
  private static boolean b(CellLocation paramCellLocation)
  {
    try
    {
      paramCellLocation = (GsmCellLocation)paramCellLocation;
      if (paramCellLocation.getCid() == 0)
      {
        int i = paramCellLocation.getLac();
        if (i == 0) {
          return true;
        }
      }
    }
    catch (ClassCastException paramCellLocation)
    {
      label23:
      break label23;
    }
    return false;
  }
  
  public static List<NeighboringCellInfo> c(ea paramea)
  {
    paramea = paramea.f;
    if (paramea != null) {}
    try
    {
      paramea = paramea.getNeighboringCellInfo();
      return paramea;
    }
    catch (Exception paramea)
    {
      label16:
      break label16;
    }
    return Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.fj
 * JD-Core Version:    0.7.0.1
 */
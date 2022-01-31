package c.t.m.g;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.map.geolocation.internal.TencentLog;
import com.tencent.tencentmap.lbssdk.service.e;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Landroid.net.wifi.ScanResult;>;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ev
{
  private long A = 20000L;
  private long B = 30000L;
  private String C = "5.4.2";
  private String D = "180531";
  private String E = "5.4.2";
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public String j;
  public int k;
  public int l;
  public long m;
  public boolean n = true;
  public boolean o = true;
  public boolean p = true;
  public int q = -2;
  private final de r;
  private String s;
  private int t = 0;
  private int u = 0;
  private int v = 0;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private boolean z = false;
  
  public ev(de paramde)
  {
    this.r = paramde;
  }
  
  private static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    paramDouble4 = a(paramDouble4);
    double d1 = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    return Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d1)) * 2.0D * 6378.1369999999997D * 10000.0D) / 10000.0D * 1000.0D;
  }
  
  public static double a(double paramDouble, int paramInt)
  {
    try
    {
      if (Double.isNaN(paramDouble)) {
        return 0.0D;
      }
      paramDouble = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.HALF_DOWN).doubleValue();
      return paramDouble;
    }
    catch (Exception localException) {}
    return 0.0D;
  }
  
  public static int a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    for (int i1 = 1; i1 != 0; i1 = 0) {
      return -1;
    }
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null)
      {
        i1 = paramContext.getType();
        return i1;
      }
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  public static <T> T a(T paramT, Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramObject));
    }
    return paramT;
  }
  
  public static String a(ee paramee, boolean paramBoolean)
  {
    if (paramee == null) {
      return "[]";
    }
    int i2 = paramee.b;
    int i3 = paramee.c;
    int i4 = paramee.a;
    Object localObject1 = new ArrayList();
    Object localObject2 = paramee.a();
    int i1;
    int i5;
    int i6;
    if (er.a(i4, i2, i3, paramee.d, paramee.e))
    {
      i1 = paramee.d;
      int i7 = paramee.e;
      int i8 = paramee.f;
      i5 = paramee.g;
      i6 = paramee.h;
      paramee = new StringBuilder();
      paramee.append("{");
      paramee.append("\"mcc\":");
      paramee.append(i2);
      paramee.append(",\"mnc\":");
      paramee.append(i3);
      paramee.append(",\"lac\":");
      paramee.append(i1);
      paramee.append(",\"cellid\":");
      paramee.append(i7);
      paramee.append(",\"rss\":");
      paramee.append(i8);
      paramee.append(",\"seed\":");
      if (paramBoolean)
      {
        i1 = 1;
        paramee.append(i1);
        if ((i5 != 2147483647) && (i6 != 2147483647))
        {
          paramee.append(",\"stationLat\":");
          paramee.append(String.format("%.6f", new Object[] { Float.valueOf(i5 / 14400.0F) }));
          paramee.append(",\"stationLng\":");
          paramee.append(String.format("%.6f", new Object[] { Float.valueOf(i6 / 14400.0F) }));
        }
        paramee.append("}");
        ((ArrayList)localObject1).add(paramee.toString());
      }
    }
    for (;;)
    {
      try
      {
        paramee = ((List)localObject2).iterator();
        if (paramee.hasNext())
        {
          localObject2 = (NeighboringCellInfo)paramee.next();
          i1 = ((NeighboringCellInfo)localObject2).getLac();
          i5 = ((NeighboringCellInfo)localObject2).getCid();
          if (!er.a(i4, i2, i3, i1, i5)) {
            break label568;
          }
          i6 = ((NeighboringCellInfo)localObject2).getRssi();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("{");
          ((StringBuilder)localObject2).append("\"mcc\":");
          ((StringBuilder)localObject2).append(i2);
          ((StringBuilder)localObject2).append(",\"mnc\":");
          ((StringBuilder)localObject2).append(i3);
          ((StringBuilder)localObject2).append(",\"lac\":");
          ((StringBuilder)localObject2).append(i1);
          ((StringBuilder)localObject2).append(",\"cellid\":");
          ((StringBuilder)localObject2).append(i5);
          ((StringBuilder)localObject2).append(",\"rss\":");
          ((StringBuilder)localObject2).append((i6 << 1) - 113);
          ((StringBuilder)localObject2).append("}");
          ((ArrayList)localObject1).add(((StringBuilder)localObject2).toString());
          continue;
        }
        i1 = 0;
      }
      catch (Exception paramee)
      {
        paramee = new StringBuilder("[");
        localObject2 = new et(",");
        localObject1 = ((Iterable)localObject1).iterator();
        paramee.append(((et)localObject2).a(new StringBuilder(), (Iterator)localObject1).toString());
        paramee.append("]");
        return paramee.toString();
      }
      break;
      a("illeagal main cell! ", i2, i3, i4, paramee.d, paramee.e);
      continue;
      label568:
      a("illeagal neighboringCell! ", i2, i3, i4, i1, i5);
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void a(String paramString)
  {
    a("#", 4, paramString);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCellInfoWithJsonFormat: ");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.append("isGsm=");
    if (paramInt3 == 1) {}
    for (;;)
    {
      paramString.append(bool);
      localStringBuilder.append(", mcc,mnc=").append(paramInt1).append(",").append(paramInt2);
      localStringBuilder.append(", lac,cid=").append(paramInt4).append(",").append(paramInt5);
      return;
      bool = false;
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = TencentExtraKeys.getTencentLogs();
    if (paramString2 != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TencentLog)((Iterator)localObject).next()).println(paramString1, paramInt, paramString2);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, 4, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(paramString1, 6, paramString2 + " exception: " + Log.getStackTraceString(paramThrowable));
  }
  
  public static boolean a(Location paramLocation, double[] paramArrayOfDouble)
  {
    int i5 = (int)(paramLocation.getLatitude() * 1000000.0D);
    int i6 = (int)(paramLocation.getLongitude() * 1000000.0D);
    paramLocation = dk.a("tencent_loc_lib");
    int i3 = 0;
    int i4 = 0;
    while (i3 < paramLocation.length())
    {
      int i7 = paramLocation.charAt(i3);
      int i2 = 256;
      int i1 = i2;
      if (i7 >= 65)
      {
        i1 = i2;
        if (i7 <= 90) {
          i1 = i7 - 65;
        }
      }
      i2 = i1;
      if (i7 >= 97)
      {
        i2 = i1;
        if (i7 <= 122) {
          i2 = i7 - 97 + 64;
        }
      }
      i1 = i2;
      if (i7 >= 48)
      {
        i1 = i2;
        if (i7 <= 57) {
          i1 = i7 + 128 - 48;
        }
      }
      i4 += i1;
      i3 += 1;
    }
    paramLocation = new double[2];
    try
    {
      e.b(i5 ^ i4, i4 ^ i6, paramLocation);
      label169:
      paramArrayOfDouble[0] = paramLocation[0];
      paramArrayOfDouble[1] = paramLocation[1];
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label169;
    }
  }
  
  public static boolean a(List<ScanResult> paramList1, List<ScanResult> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return false;
    }
    int i5 = paramList1.size();
    int i6 = paramList2.size();
    if ((i5 == 0) && (i6 == 0)) {
      return true;
    }
    if ((i5 == 0) || (i6 == 0)) {
      return false;
    }
    int i4;
    int i2;
    int i1;
    label79:
    Object localObject;
    label161:
    int i3;
    if (paramList1.size() > paramList2.size())
    {
      paramList2 = paramList2.iterator();
      i4 = 1;
      i2 = 0;
      i1 = 0;
      if (!paramList2.hasNext()) {
        break label233;
      }
      localObject = (ScanResult)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      for (;;)
      {
        if (localIterator.hasNext()) {
          if (((ScanResult)localIterator.next()).BSSID.equals(((ScanResult)localObject).BSSID)) {
            if ((i4 == 1) && (((ScanResult)localObject).level > -50))
            {
              i1 += 1;
              i3 = i1;
              if (i4 == 2)
              {
                i3 = i1;
                if (((ScanResult)localObject).level > -60) {
                  i3 = i1 + 1;
                }
              }
              if ((i4 == 3) && (((ScanResult)localObject).level > -60))
              {
                i1 = i3 + 1;
                label209:
                i2 += 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      i4 += 1;
      break label79;
      localObject = paramList1;
      paramList1 = paramList2;
      paramList2 = (List<ScanResult>)localObject;
      break;
      label233:
      if (i1 == 3)
      {
        a("TxWifiChange", 4, "big 3 is similar");
        return false;
      }
      i1 = i5 + i6;
      if ((i2 << 1 < i1 * 0.85D) || (i2 < 13)) {}
      for (boolean bool = true;; bool = false)
      {
        a("TxWifiChange", "isDiffrent:c=" + i5 + ",k=" + i2 + ",f=" + i1 + ",r=0.85,s=" + bool);
        return bool;
      }
      i1 = i3;
      break label209;
      break label161;
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(paramString1, 6, paramString2);
  }
  
  public static boolean b(Context paramContext)
  {
    int i1;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null) {
        break label62;
      }
      i1 = 1;
    }
    catch (Exception paramContext)
    {
      NetworkInfo.State localState;
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnected()))
    {
      paramContext = paramContext.getState();
      localState = NetworkInfo.State.CONNECTED;
      if (paramContext == localState) {
        return true;
      }
    }
    return false;
    while (i1 != 0)
    {
      return false;
      label62:
      i1 = 0;
    }
  }
  
  public static boolean b(String paramString)
  {
    do
    {
      JSONObject localJSONObject;
      do
      {
        try
        {
          localJSONObject = new JSONObject(paramString);
          if (paramString.contains("latitude")) {
            return true;
          }
        }
        catch (Exception paramString)
        {
          return false;
        }
        paramString = localJSONObject.optJSONArray("cells");
      } while ((paramString != null) && (paramString.length() > 0));
      paramString = localJSONObject.optJSONArray("wifis");
    } while ((paramString != null) && (paramString.length() > 0));
    return false;
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public final String a()
  {
    if (TextUtils.isEmpty(this.b)) {
      return "0123456789ABCDEF";
    }
    return this.b;
  }
  
  public final String b()
  {
    if (TextUtils.isEmpty(this.c)) {
      return "0123456789ABCDEF";
    }
    return this.c;
  }
  
  public final String c()
  {
    if ((TextUtils.isEmpty(this.e)) || (this.e.contains("0000"))) {
      return "0123456789ABCDEF";
    }
    return this.e;
  }
  
  public final String d()
  {
    if (this.C == null) {
      return "None";
    }
    return this.C;
  }
  
  public final String e()
  {
    if (this.D == null) {
      return "None";
    }
    return this.D;
  }
  
  public final String f()
  {
    if (this.s == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(a()).append("_").append(b()).append("_").append(c()).append("_QQGeoLocation");
      this.s = dk.a(localStringBuilder.toString());
    }
    return this.s;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ev
 * JD-Core Version:    0.7.0.1
 */
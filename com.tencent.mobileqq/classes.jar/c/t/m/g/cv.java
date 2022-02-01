package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

public final class cv
{
  private static volatile String a = "209";
  private static volatile String b = "fc_sdk";
  private static final Comparator<Object> c = new cv.1();
  
  public static String a(dt paramdt, Location paramLocation, List<ScanResult> paramList, List<cp> paramList1)
  {
    int i;
    int j;
    if (paramList != null)
    {
      try
      {
        i = paramList.size();
        if (paramList1 == null) {
          break label988;
        }
        j = paramList1.size();
      }
      catch (Throwable paramdt)
      {
        label27:
        StringBuilder localStringBuilder2;
        StringBuilder localStringBuilder3;
        StringBuilder localStringBuilder4;
        StringBuilder localStringBuilder1;
        Object localObject1;
        label254:
        long l;
        label369:
        co.a("get write string error!", paramdt);
        label392:
        label469:
        return "";
      }
      dp.a();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder3 = new StringBuilder();
      localStringBuilder4 = new StringBuilder();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2.append(0).append(",").append(String.format("%.6f", new Object[] { Double.valueOf(paramLocation.getLatitude()) })).append(",").append(String.format("%.6f", new Object[] { Double.valueOf(paramLocation.getLongitude()) })).append(",").append((int)paramLocation.getAltitude()).append(",").append((int)paramLocation.getAccuracy()).append(",").append((int)paramLocation.getBearing()).append(",").append(String.format("%.1f", new Object[] { Float.valueOf(paramLocation.getSpeed()) })).append(",").append(paramLocation.getTime());
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        i = 0;
        while (i < paramList1.size())
        {
          localObject1 = (cp)paramList1.get(i);
          if (i != 0) {
            break label994;
          }
          paramLocation = "";
          localStringBuilder3.append(paramLocation).append(((cp)localObject1).a).append(",").append(((cp)localObject1).b).append(",").append(((cp)localObject1).c).append(",").append(((cp)localObject1).d).append(",").append(((cp)localObject1).e);
          i += 1;
        }
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        paramList = paramList.toArray();
        Arrays.sort(paramList, c);
        l = SystemClock.elapsedRealtime() / 1000L;
        i = 0;
        if (i < paramList.length)
        {
          paramList1 = (ScanResult)paramList[i];
          if (i != 0) {
            break label1021;
          }
          paramLocation = "";
          localStringBuilder4.append(paramLocation).append(paramList1.BSSID.replaceAll(":", "").toLowerCase()).append("&").append(paramList1.level);
          if (Build.VERSION.SDK_INT < 17) {
            break label1012;
          }
          j = -1;
          if (paramList1.timestamp <= 0L) {
            break label1001;
          }
          j = (int)(l - paramList1.timestamp / 1000L / 1000L);
          break label1001;
          localStringBuilder1.append(paramLocation).append(j);
          break label1012;
        }
      }
      paramLocation = new StringBuilder();
      paramList = cy.a();
      if (paramList != null)
      {
        i = paramList.length();
        if (i <= 5) {}
      }
    }
    for (;;)
    {
      try
      {
        paramList = new JSONObject(paramList);
        paramLocation.append(paramList.optString("mac").replaceAll(":", "").toLowerCase()).append("&").append(paramList.optString("ssid")).append("&").append(paramList.optString("rssi"));
        if (paramLocation.length() < 5) {
          paramLocation.setLength(0);
        }
        paramList = dt.a(paramdt.b).replaceAll("[| _]", "");
        paramList = paramList + "_" + dt.a(paramdt.a);
        paramList1 = dt.a(Build.MANUFACTURER).replaceAll("[| _]", "");
        paramList1 = paramList1 + "_" + dt.a(Build.MODEL).replaceAll("[| _]", "");
        localObject1 = new StringBuilder();
        Object localObject2 = dq.a("yyyy-MM-dd HH:mm:ss");
        localObject2 = ((StringBuilder)localObject1).append("[").append(((SimpleDateFormat)localObject2).format(new Date())).append("]:1.5.4|").append(a).append("|").append(dt.a(paramdt.c)).append("|");
        if (cu.d)
        {
          paramdt = cx.a();
          localObject2 = ((StringBuilder)localObject2).append(paramdt).append("|");
          if (!cu.d) {
            break label1033;
          }
          paramdt = cx.c();
          paramLocation = ((StringBuilder)localObject2).append(paramdt).append("|||||||").append(localStringBuilder2).append("||").append(localStringBuilder3).append("|").append(localStringBuilder4).append("||||||||||||||||").append(b).append("||||").append(paramLocation).append("||");
          if (!cu.d) {
            break label955;
          }
          paramdt = cx.d().replaceAll(":", "").toLowerCase();
          paramLocation.append(paramdt).append("|").append(paramList).append("|").append(cx.b()).append("||").append(paramList1).append("||||||||||||").append(localStringBuilder1.toString()).append("|");
          return ((StringBuilder)localObject1).toString();
        }
      }
      catch (Throwable paramList)
      {
        paramLocation.setLength(0);
        continue;
      }
      paramdt = "";
      continue;
      label955:
      paramdt = "";
      continue;
      for (;;)
      {
        if ((paramdt != null) && (paramLocation != null) && ((i != 0) || (j != 0))) {
          break label992;
        }
        return "";
        i = 0;
        break;
        label988:
        j = 0;
      }
      label992:
      break label27;
      label994:
      paramLocation = ";";
      break label254;
      label1001:
      if (i == 0)
      {
        paramLocation = "";
        break label469;
        label1012:
        i += 1;
        break label369;
        label1021:
        paramLocation = "&";
        break label392;
      }
      paramLocation = "&";
      break label469;
      label1033:
      paramdt = "";
    }
  }
  
  public static void a(String paramString)
  {
    b = paramString;
  }
  
  public static void b(String paramString)
  {
    a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.cv
 * JD-Core Version:    0.7.0.1
 */
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

public final class cu
{
  private static volatile String a = "209";
  private static volatile String b = "fc_sdk";
  private static final Comparator<Object> c = new cu.1();
  
  public static String a(cx paramcx, Location paramLocation, List<ScanResult> paramList, List<cp> paramList1)
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
      catch (Throwable paramcx)
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
        co.a("get write string error!", paramcx);
        label392:
        label469:
        return "";
      }
      do.a();
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
      paramList = cx.a();
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
        paramList = cx.a(paramcx.b).replaceAll("[| _]", "");
        paramList = paramList + "_" + cx.a(paramcx.a);
        paramList1 = cx.a(Build.MANUFACTURER).replaceAll("[| _]", "");
        paramList1 = paramList1 + "_" + cx.a(Build.MODEL).replaceAll("[| _]", "");
        localObject1 = new StringBuilder();
        Object localObject2 = dp.a("yyyy-MM-dd HH:mm:ss");
        localObject2 = ((StringBuilder)localObject1).append("[").append(((SimpleDateFormat)localObject2).format(new Date())).append("]:1.4.9|").append(a).append("|").append(cx.a(paramcx.c)).append("|");
        if (ct.d)
        {
          paramcx = cw.a();
          localObject2 = ((StringBuilder)localObject2).append(paramcx).append("|");
          if (!ct.d) {
            break label1033;
          }
          paramcx = cw.c();
          paramLocation = ((StringBuilder)localObject2).append(paramcx).append("|||||||").append(localStringBuilder2).append("||").append(localStringBuilder3).append("|").append(localStringBuilder4).append("||||||||||||||||").append(b).append("||||").append(paramLocation).append("||");
          if (!ct.d) {
            break label955;
          }
          paramcx = cw.d().replaceAll(":", "").toLowerCase();
          paramLocation.append(paramcx).append("|").append(paramList).append("|").append(cw.b()).append("||").append(paramList1).append("||||||||||||").append(localStringBuilder1.toString()).append("|");
          return ((StringBuilder)localObject1).toString();
        }
      }
      catch (Throwable paramList)
      {
        paramLocation.setLength(0);
        continue;
      }
      paramcx = "";
      continue;
      label955:
      paramcx = "";
      continue;
      for (;;)
      {
        if ((paramcx != null) && (paramLocation != null) && ((i != 0) || (j != 0))) {
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
      paramcx = "";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.cu
 * JD-Core Version:    0.7.0.1
 */
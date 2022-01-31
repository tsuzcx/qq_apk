package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class cq
{
  private static volatile String a = "209";
  private static volatile String b = "fc_sdk";
  private static SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
  
  public static String a(cj paramcj, Location paramLocation, List<ScanResult> paramList, List<ck> paramList1)
  {
    int i;
    int j;
    if (paramList != null)
    {
      try
      {
        i = paramList.size();
        if (paramList1 == null) {
          break label788;
        }
        j = paramList1.size();
      }
      catch (Throwable paramcj)
      {
        label27:
        StringBuilder localStringBuilder1;
        StringBuilder localStringBuilder2;
        StringBuilder localStringBuilder3;
        Object localObject;
        label241:
        cl.a("DCUtils", "get write string error!", paramcj);
        label333:
        return "";
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder3 = new StringBuilder();
      localStringBuilder1.append(0).append(",").append(String.format("%.6f", new Object[] { Double.valueOf(paramLocation.getLatitude()) })).append(",").append(String.format("%.6f", new Object[] { Double.valueOf(paramLocation.getLongitude()) })).append(",").append((int)paramLocation.getAltitude()).append(",").append((int)paramLocation.getAccuracy()).append(",").append((int)paramLocation.getBearing()).append(",").append(String.format("%.1f", new Object[] { Float.valueOf(paramLocation.getSpeed()) })).append(",").append(paramLocation.getTime());
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        i = 0;
        while (i < paramList1.size())
        {
          localObject = (ck)paramList1.get(i);
          if (i != 0) {
            break label794;
          }
          paramLocation = "";
          localStringBuilder2.append(paramLocation).append(((ck)localObject).a).append(",").append(((ck)localObject).b).append(",").append(((ck)localObject).c).append(",").append(((ck)localObject).d).append(",").append(((ck)localObject).e);
          i += 1;
        }
      }
      if ((paramList != null) && (paramList.size() > 0))
      {
        i = 0;
        if (i < paramList.size())
        {
          paramList1 = (ScanResult)paramList.get(i);
          if (i != 0) {
            break label800;
          }
        }
      }
    }
    label788:
    label792:
    label794:
    label800:
    for (paramLocation = "";; paramLocation = "&")
    {
      localStringBuilder3.append(paramLocation).append(paramList1.BSSID.replaceAll(":", "").toLowerCase()).append("&").append(paramList1.level);
      i += 1;
      break label333;
      paramLocation = new StringBuilder();
      paramList = f.a.c(paramcj.a);
      if (paramList != null)
      {
        i = paramList.length();
        if (i <= 5) {}
      }
      try
      {
        paramList = new JSONObject(paramList);
        paramLocation.append(paramList.optString("mac").replaceAll(":", "").toLowerCase()).append("&").append(paramList.optString("ssid")).append("&").append(paramList.optString("rssi"));
        if (paramLocation.length() < 5) {
          paramLocation.setLength(0);
        }
        paramList = cj.a(paramcj.c).replaceAll("[| _]", "");
        paramList = paramList + "_" + cj.a(paramcj.b);
        paramList1 = cj.a(Build.MANUFACTURER).replaceAll("[| _]", "");
        paramList1 = paramList1 + "_" + cj.a(Build.MODEL).replaceAll("[| _]", "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[").append(c.format(new Date())).append("]:1.2.8|").append(a).append("|").append(cj.a(paramcj.d)).append("|||||||||").append(localStringBuilder1).append("||").append(localStringBuilder2).append("|").append(localStringBuilder3).append("||||||||||||||||").append(b).append("||||").append(paramLocation).append("|||").append(paramList).append("|||").append(paramList1);
        return ((StringBuilder)localObject).toString();
      }
      catch (Throwable paramList)
      {
        for (;;)
        {
          paramLocation.setLength(0);
        }
      }
      for (;;)
      {
        if ((paramcj != null) && (paramLocation != null) && ((i != 0) || (j != 0))) {
          break label792;
        }
        return "";
        i = 0;
        break;
        j = 0;
      }
      break label27;
      paramLocation = ";";
      break label241;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.cq
 * JD-Core Version:    0.7.0.1
 */
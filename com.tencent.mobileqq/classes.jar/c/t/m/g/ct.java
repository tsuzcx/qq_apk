package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class ct
{
  private static volatile String a = "209";
  private static volatile String b = "fc_sdk";
  private static SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
  
  public static String a(cv paramcv, Location paramLocation, List<ScanResult> paramList, List<cw> paramList1)
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
      catch (Throwable paramcv)
      {
        label27:
        StringBuilder localStringBuilder1;
        StringBuilder localStringBuilder2;
        StringBuilder localStringBuilder3;
        Object localObject;
        label241:
        cp.a("DCUtils", "get write string error!", paramcv);
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
          localObject = (cw)paramList1.get(i);
          if (i != 0) {
            break label794;
          }
          paramLocation = "";
          localStringBuilder2.append(paramLocation).append(((cw)localObject).a).append(",").append(((cw)localObject).b).append(",").append(((cw)localObject).c).append(",").append(((cw)localObject).d).append(",").append(((cw)localObject).e);
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
      paramList = co.a(paramcv.a);
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
        paramList = cv.a(paramcv.c).replaceAll("[| _]", "");
        paramList = paramList + "_" + cv.a(paramcv.b);
        paramList1 = cv.a(Build.MANUFACTURER).replaceAll("[| _]", "");
        paramList1 = paramList1 + "_" + cv.a(Build.MODEL).replaceAll("[| _]", "");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[").append(c.format(new Date())).append("]:1.2.8|").append(a).append("|").append(cv.a(paramcv.d)).append("|||||||||").append(localStringBuilder1).append("||").append(localStringBuilder2).append("|").append(localStringBuilder3).append("||||||||||||||||").append(b).append("||||").append(paramLocation).append("|||").append(paramList).append("|||").append(paramList1);
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
        if ((paramcv != null) && (paramLocation != null) && ((i != 0) || (j != 0))) {
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
 * Qualified Name:     c.t.m.g.ct
 * JD-Core Version:    0.7.0.1
 */
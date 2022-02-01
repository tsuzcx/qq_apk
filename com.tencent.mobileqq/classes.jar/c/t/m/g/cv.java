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
import java.util.List<Lc.t.m.g.cp;>;
import org.json.JSONObject;

public final class cv
{
  private static volatile String a = "209";
  private static volatile String b = "fc_sdk";
  private static final Comparator<Object> c = new cv.1();
  
  public static String a(dt paramdt, Location paramLocation, List<ScanResult> paramList, List<cp> paramList1)
  {
    Object localObject1 = "||";
    int i;
    int j;
    label34:
    String str;
    if (paramList != null)
    {
      label692:
      try
      {
        i = paramList.size();
        if (paramList1 == null) {
          break label1202;
        }
        j = paramList1.size();
      }
      catch (Throwable paramdt)
      {
        StringBuilder localStringBuilder2;
        StringBuilder localStringBuilder3;
        StringBuilder localStringBuilder4;
        StringBuilder localStringBuilder1;
        Object localObject2;
        label310:
        label461:
        label490:
        SimpleDateFormat localSimpleDateFormat;
        label577:
        label963:
        break label1178;
      }
      dp.a();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder3 = new StringBuilder();
      localStringBuilder4 = new StringBuilder();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2.append(0);
      localStringBuilder2.append(",");
      localStringBuilder2.append(String.format("%.6f", new Object[] { Double.valueOf(paramLocation.getLatitude()) }));
      localStringBuilder2.append(",");
      localStringBuilder2.append(String.format("%.6f", new Object[] { Double.valueOf(paramLocation.getLongitude()) }));
      localStringBuilder2.append(",");
      str = "";
      try
      {
        localStringBuilder2.append((int)paramLocation.getAltitude());
        localStringBuilder2.append(",");
        localStringBuilder2.append((int)paramLocation.getAccuracy());
        localStringBuilder2.append(",");
        localStringBuilder2.append((int)paramLocation.getBearing());
        localStringBuilder2.append(",");
        localStringBuilder2.append(String.format("%.1f", new Object[] { Float.valueOf(paramLocation.getSpeed()) }));
        localStringBuilder2.append(",");
        localStringBuilder2.append(paramLocation.getTime());
        if ((paramList1 != null) && (paramList1.size() > 0))
        {
          i = 0;
          while (i < paramList1.size())
          {
            localObject2 = (cp)paramList1.get(i);
            if (i != 0) {
              break label1226;
            }
            paramLocation = str;
            localStringBuilder3.append(paramLocation);
            localStringBuilder3.append(((cp)localObject2).a);
            localStringBuilder3.append(",");
            localStringBuilder3.append(((cp)localObject2).b);
            localStringBuilder3.append(",");
            localStringBuilder3.append(((cp)localObject2).c);
            localStringBuilder3.append(",");
            localStringBuilder3.append(((cp)localObject2).d);
            localStringBuilder3.append(",");
            localStringBuilder3.append(((cp)localObject2).e);
            i += 1;
          }
        }
        paramList1 = (List<cp>)localObject1;
        if (paramList != null)
        {
          paramList1 = (List<cp>)localObject1;
          if (paramList.size() > 0)
          {
            paramList = paramList.toArray();
            Arrays.sort(paramList, c);
            long l = SystemClock.elapsedRealtime() / 1000L;
            i = 0;
            paramLocation = (Location)localObject1;
            paramList1 = paramLocation;
            if (i < paramList.length)
            {
              localObject1 = (ScanResult)paramList[i];
              if (i != 0) {
                break label1233;
              }
              paramList1 = str;
              localStringBuilder4.append(paramList1);
              localStringBuilder4.append(((ScanResult)localObject1).BSSID.replaceAll(":", str).toLowerCase());
              localStringBuilder4.append("&");
              localStringBuilder4.append(((ScanResult)localObject1).level);
              if (Build.VERSION.SDK_INT < 17) {
                break label1259;
              }
              if (((ScanResult)localObject1).timestamp <= 0L) {
                break label1239;
              }
              j = (int)(l - ((ScanResult)localObject1).timestamp / 1000L / 1000L);
              break label1242;
              localStringBuilder1.append(paramList1);
              localStringBuilder1.append(j);
              break label1259;
            }
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
      catch (Throwable paramdt) {}
      try
      {
        paramList = new JSONObject(paramList);
        paramLocation.append(paramList.optString("mac").replaceAll(":", str).toLowerCase());
        paramLocation.append("&");
        paramLocation.append(paramList.optString("ssid"));
        paramLocation.append("&");
        paramLocation.append(paramList.optString("rssi"));
      }
      catch (Throwable paramList)
      {
        break label692;
      }
      paramLocation.setLength(0);
      if (paramLocation.length() < 5) {
        paramLocation.setLength(0);
      }
      paramList = dt.a(paramdt.b).replaceAll("[| _]", str);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramList);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(dt.a(paramdt.a));
      paramList = ((StringBuilder)localObject1).toString();
      localObject1 = dt.a(Build.MANUFACTURER).replaceAll("[| _]", str);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(dt.a(Build.MODEL).replaceAll("[| _]", str));
      localObject1 = ((StringBuilder)localObject2).toString();
      localObject2 = new StringBuilder();
      localSimpleDateFormat = dq.a("yyyy-MM-dd HH:mm:ss");
      ((StringBuilder)localObject2).append("[");
      ((StringBuilder)localObject2).append(localSimpleDateFormat.format(new Date()));
      ((StringBuilder)localObject2).append("]:1.5.4|");
      ((StringBuilder)localObject2).append(a);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(dt.a(paramdt.c));
      ((StringBuilder)localObject2).append("|");
      if (!cu.d) {
        break label1268;
      }
      paramdt = cx.a();
      label935:
      ((StringBuilder)localObject2).append(paramdt);
      ((StringBuilder)localObject2).append("|");
      if (!cu.d) {
        break label1274;
      }
      paramdt = cx.c();
      ((StringBuilder)localObject2).append(paramdt);
      ((StringBuilder)localObject2).append("|||||||");
      ((StringBuilder)localObject2).append(localStringBuilder2);
      ((StringBuilder)localObject2).append(paramList1);
      ((StringBuilder)localObject2).append(localStringBuilder3);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(localStringBuilder4);
      ((StringBuilder)localObject2).append("||||||||||||||||");
      ((StringBuilder)localObject2).append(b);
      ((StringBuilder)localObject2).append("||||");
      ((StringBuilder)localObject2).append(paramLocation);
      ((StringBuilder)localObject2).append(paramList1);
      if (!cu.d) {
        break label1280;
      }
      paramdt = cx.d().replaceAll(":", str).toLowerCase();
    }
    for (;;)
    {
      ((StringBuilder)localObject2).append(paramdt);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(paramList);
      ((StringBuilder)localObject2).append("|");
      ((StringBuilder)localObject2).append(cx.b());
      ((StringBuilder)localObject2).append(paramList1);
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("||||||||||||");
      ((StringBuilder)localObject2).append(localStringBuilder1.toString());
      ((StringBuilder)localObject2).append("|");
      paramdt = ((StringBuilder)localObject2).toString();
      return paramdt;
      for (;;)
      {
        return "";
        label1178:
        co.a("get write string error!", paramdt);
        return "";
        i = 0;
        break;
        label1202:
        j = 0;
        if ((paramdt != null) && (paramLocation != null)) {
          if ((i != 0) || (j != 0)) {
            break label34;
          }
        }
      }
      label1226:
      paramLocation = ";";
      break label310;
      label1233:
      paramList1 = "&";
      break label490;
      label1239:
      j = -1;
      label1242:
      if (i == 0)
      {
        paramList1 = str;
        break label577;
      }
      paramList1 = "&";
      break label577;
      label1259:
      i += 1;
      break label461;
      label1268:
      paramdt = str;
      break label935;
      label1274:
      paramdt = str;
      break label963;
      label1280:
      paramdt = str;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cv
 * JD-Core Version:    0.7.0.1
 */
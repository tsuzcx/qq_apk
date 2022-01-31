package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class es
{
  public static int a = 0;
  public final eu b;
  public final eq c;
  public final er d;
  
  public es(eu parameu, eq parameq, er paramer)
  {
    this.b = parameu;
    this.c = parameq;
    this.d = paramer;
  }
  
  private String a(int paramInt1, int paramInt2, String paramString, dx paramdx, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramdx == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject4;
        if (this.c == null)
        {
          bool = true;
          localObject1 = this.b;
          if (localObject1 == null)
          {
            localObject1 = null;
            break label1050;
            localObject4 = fm.a(this.c, bool);
            localObject2 = this.d;
            if (localObject2 != null) {
              continue;
            }
            localObject2 = "{}";
            dr localdr = paramdx.b;
            localObject3 = new HashMap();
            ((HashMap)localObject3).put("imei", localdr.a());
            ((HashMap)localObject3).put("imsi", localdr.b());
            ((HashMap)localObject3).put("phonenum", co.d(localdr.d));
            ((HashMap)localObject3).put("qq", co.d(localdr.f));
            ((HashMap)localObject3).put("mac", localdr.c().toLowerCase(Locale.ENGLISH));
            localObject5 = new JSONObject((Map)localObject3).toString();
            String str2 = localdr.f();
            fj.a();
            int k = fj.a(paramdx.a);
            String str1 = fn.c(paramdx);
            localObject3 = localdr.j;
            paramdx = (dx)localObject3;
            if (localObject3 != null) {
              paramdx = ((String)localObject3).replace("\"", "");
            }
            localObject3 = paramdx;
            if (paramdx != null) {
              localObject3 = paramdx.replace("|", "");
            }
            paramdx = (String)localObject3 + "_" + localdr.h;
            int j = 203;
            i = j;
            if (paramBoolean2)
            {
              localObject3 = localdr.a();
              i = j;
              if (localObject3 != null) {
                i = Math.abs(((String)localObject3).hashCode()) % 1000 + 1001;
              }
            }
            localObject3 = "{\"version\":\"" + localdr.d() + "\",\"address\":" + paramInt1;
            paramdx = (String)localObject3 + ",\"source\":" + i + ",\"access_token\":\"" + str2 + "\",\"app_name\":\"" + paramString + "\",\"app_label\":\"" + paramdx + "\",\"bearing\":1";
            paramString = paramdx;
            if (paramInt2 >= 0) {
              paramString = paramdx + ",\"control\":" + paramInt2;
            }
            if ((!paramBoolean1) || (paramBoolean2)) {
              continue;
            }
            paramString = paramString + ",\"detectgps\":1";
            paramString = paramString + ",\"pstat\":" + k;
            paramString = paramString + ",\"wlan\":" + str1;
            return paramString + ",\"attribute\":" + (String)localObject5 + ",\"location\":" + (String)localObject2 + ",\"cells\":" + (String)localObject4 + ",\"wifis\":" + (String)localObject1 + "}";
          }
        }
        else
        {
          if (a == this.c.e) {
            break label1063;
          }
          bool = true;
          a = this.c.e;
          continue;
        }
        localObject1 = Collections.unmodifiableList(((eu)localObject1).b);
        break label1050;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        if (((List)localObject1).size() <= 0)
        {
          ((StringBuilder)localObject2).append("]");
          localObject1 = ((StringBuilder)localObject2).toString();
          continue;
        }
        Object localObject3 = ((List)localObject1).iterator();
        int i = 0;
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ScanResult)((Iterator)localObject3).next();
          ((List)localObject1).size();
          if (i > 0) {
            ((StringBuilder)localObject2).append(",");
          }
          ((StringBuilder)localObject2).append("{\"mac\":\"").append(((ScanResult)localObject4).BSSID).append("\",");
          ((StringBuilder)localObject2).append("\"rssi\":").append(((ScanResult)localObject4).level).append("}");
          i += 1;
          continue;
        }
        ((StringBuilder)localObject2).append("]");
        localObject1 = ((StringBuilder)localObject2).toString();
        continue;
        localObject3 = ((er)localObject2).a;
        Object localObject5 = new StringBuilder();
        double d1 = fm.a(((Location)localObject3).getLatitude(), 6);
        double d2 = fm.a(((Location)localObject3).getLongitude(), 6);
        double d3 = fm.a(((Location)localObject3).getAltitude(), 1);
        double d4 = fm.a(((Location)localObject3).getAccuracy(), 1);
        double d5 = fm.a(((Location)localObject3).getBearing(), 1);
        double d6 = fm.a(((Location)localObject3).getSpeed(), 1);
        ((StringBuilder)localObject5).append("{");
        ((StringBuilder)localObject5).append("\"latitude\":");
        ((StringBuilder)localObject5).append(d1);
        ((StringBuilder)localObject5).append(",\"longitude\":");
        ((StringBuilder)localObject5).append(d2);
        ((StringBuilder)localObject5).append(",\"additional\":");
        ((StringBuilder)localObject5).append("\"" + d3 + "," + d4 + "," + d5 + "," + d6 + "," + ((er)localObject2).b + "\"");
        ((StringBuilder)localObject5).append("}");
        localObject2 = ((StringBuilder)localObject5).toString();
        continue;
        paramString = paramString + ",\"detectgps\":0";
        continue;
        if (localObject1 != null) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      label1050:
      Object localObject1 = "[]";
      continue;
      label1063:
      boolean bool = false;
    }
  }
  
  public final String a(int paramInt, String paramString, dx paramdx, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2) {
      return a(paramInt, 1, paramString, paramdx, paramBoolean1, paramBoolean3);
    }
    return a(paramInt, 0, paramString, paramdx, paramBoolean1, paramBoolean3);
  }
  
  public final boolean a()
  {
    return this.c != null;
  }
  
  public final boolean b()
  {
    return this.b != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.es
 * JD-Core Version:    0.7.0.1
 */
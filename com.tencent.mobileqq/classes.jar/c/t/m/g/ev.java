package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.util.Pair;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class ev
{
  public static int a = 0;
  public final ex b;
  public final et c;
  public final eu d;
  
  public ev(ex paramex, et paramet, eu parameu)
  {
    this.b = paramex;
    this.c = paramet;
    this.d = parameu;
  }
  
  private String a(int paramInt1, int paramInt2, String paramString, ea paramea, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramea == null) {
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
            break label1118;
            localObject4 = fp.a(this.c, bool);
            localObject2 = this.d;
            if (localObject2 != null) {
              continue;
            }
            localObject2 = "{}";
            du localdu = paramea.b;
            localObject3 = new HashMap();
            ((HashMap)localObject3).put("imei", localdu.a());
            ((HashMap)localObject3).put("imsi", localdu.b());
            if (localdu.p == null) {
              localdu.p = new Pair((String)dy.b("LocationSDK", "location_device_id_type", ""), (String)dy.b("LocationSDK", "location_device_id", ""));
            }
            ((HashMap)localObject3).put("idfa", localdu.p.second);
            ((HashMap)localObject3).put("phonenum", co.e(localdu.d));
            ((HashMap)localObject3).put("qq", co.e(localdu.f));
            ((HashMap)localObject3).put("mac", localdu.c().toLowerCase(Locale.ENGLISH));
            localObject5 = new JSONObject((Map)localObject3).toString();
            String str2 = localdu.f();
            fm.a();
            int k = fm.a(paramea.a);
            String str1 = fq.c(paramea);
            localObject3 = localdu.j;
            paramea = (ea)localObject3;
            if (localObject3 != null) {
              paramea = ((String)localObject3).replace("\"", "");
            }
            localObject3 = paramea;
            if (paramea != null) {
              localObject3 = paramea.replace("|", "");
            }
            paramea = (String)localObject3 + "_" + localdu.h;
            int j = 203;
            i = j;
            if (paramBoolean2)
            {
              localObject3 = localdu.a();
              i = j;
              if (localObject3 != null) {
                i = Math.abs(((String)localObject3).hashCode()) % 1000 + 1001;
              }
            }
            localObject3 = "{\"version\":\"" + localdu.d() + "\",\"address\":" + paramInt1;
            paramea = (String)localObject3 + ",\"source\":" + i + ",\"access_token\":\"" + str2 + "\",\"app_name\":\"" + paramString + "\",\"app_label\":\"" + paramea + "\",\"bearing\":1";
            paramString = paramea;
            if (paramInt2 >= 0) {
              paramString = paramea + ",\"control\":" + paramInt2;
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
            break label1131;
          }
          bool = true;
          a = this.c.e;
          continue;
        }
        localObject1 = Collections.unmodifiableList(((ex)localObject1).b);
        break label1118;
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
        localObject3 = ((eu)localObject2).a;
        Object localObject5 = new StringBuilder();
        double d1 = fp.a(((Location)localObject3).getLatitude(), 6);
        double d2 = fp.a(((Location)localObject3).getLongitude(), 6);
        double d3 = fp.a(((Location)localObject3).getAltitude(), 1);
        double d4 = fp.a(((Location)localObject3).getAccuracy(), 1);
        double d5 = fp.a(((Location)localObject3).getBearing(), 1);
        double d6 = fp.a(((Location)localObject3).getSpeed(), 1);
        ((StringBuilder)localObject5).append("{");
        ((StringBuilder)localObject5).append("\"latitude\":");
        ((StringBuilder)localObject5).append(d1);
        ((StringBuilder)localObject5).append(",\"longitude\":");
        ((StringBuilder)localObject5).append(d2);
        ((StringBuilder)localObject5).append(",\"additional\":");
        ((StringBuilder)localObject5).append("\"" + d3 + "," + d4 + "," + d5 + "," + d6 + "," + ((eu)localObject2).b + "\"");
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
      label1118:
      Object localObject1 = "[]";
      continue;
      label1131:
      boolean bool = false;
    }
  }
  
  public final String a(int paramInt, String paramString, ea paramea, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean2) {
      return a(paramInt, 1, paramString, paramea, paramBoolean1, paramBoolean3);
    }
    return a(paramInt, 0, paramString, paramea, paramBoolean1, paramBoolean3);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.ev
 * JD-Core Version:    0.7.0.1
 */
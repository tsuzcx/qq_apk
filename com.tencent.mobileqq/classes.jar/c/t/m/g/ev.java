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
  public static int a;
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
    try
    {
      localObject1 = this.c;
      i = 0;
      if (localObject1 == null)
      {
        bool = true;
        break label56;
      }
      if (a == this.c.e) {
        break label1357;
      }
      bool = true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Object localObject1;
        int i;
        Object localObject2;
        int j;
        Object localObject3;
        Object localObject4;
        Object localObject5;
        double d1;
        continue;
        boolean bool = false;
      }
    }
    a = this.c.e;
    label56:
    localObject1 = this.b;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = Collections.unmodifiableList(((ex)localObject1).b);
    }
    if (localObject1 == null)
    {
      localObject1 = "[]";
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[");
      j = ((List)localObject1).size();
      if (j <= 0)
      {
        ((StringBuilder)localObject2).append("]");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject3 = ((List)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (ScanResult)((Iterator)localObject3).next();
          ((List)localObject1).size();
          if (i > 0) {
            ((StringBuilder)localObject2).append(",");
          }
          ((StringBuilder)localObject2).append("{\"mac\":\"");
          ((StringBuilder)localObject2).append(((ScanResult)localObject4).BSSID);
          ((StringBuilder)localObject2).append("\",");
          ((StringBuilder)localObject2).append("\"rssi\":");
          ((StringBuilder)localObject2).append(((ScanResult)localObject4).level);
          ((StringBuilder)localObject2).append("}");
          i += 1;
        }
        ((StringBuilder)localObject2).append("]");
        localObject1 = ((StringBuilder)localObject2).toString();
      }
    }
    localObject4 = fp.a(this.c, bool);
    localObject2 = this.d;
    if (localObject2 == null)
    {
      localObject2 = "{}";
    }
    else
    {
      localObject5 = ((eu)localObject2).a;
      localObject3 = new StringBuilder();
      d1 = ((Location)localObject5).getLatitude();
    }
    try
    {
      d1 = fp.a(d1, 6);
      double d2 = fp.a(((Location)localObject5).getLongitude(), 6);
      double d3 = fp.a(((Location)localObject5).getAltitude(), 1);
      double d4 = fp.a(((Location)localObject5).getAccuracy(), 1);
      double d5 = fp.a(((Location)localObject5).getBearing(), 1);
      double d6 = fp.a(((Location)localObject5).getSpeed(), 1);
      ((StringBuilder)localObject3).append("{");
      ((StringBuilder)localObject3).append("\"latitude\":");
      ((StringBuilder)localObject3).append(d1);
      ((StringBuilder)localObject3).append(",\"longitude\":");
      ((StringBuilder)localObject3).append(d2);
      ((StringBuilder)localObject3).append(",\"additional\":");
      localObject5 = new StringBuilder("\"");
      ((StringBuilder)localObject5).append(d3);
      ((StringBuilder)localObject5).append(",");
      ((StringBuilder)localObject5).append(d4);
      ((StringBuilder)localObject5).append(",");
      ((StringBuilder)localObject5).append(d5);
      ((StringBuilder)localObject5).append(",");
      ((StringBuilder)localObject5).append(d6);
      ((StringBuilder)localObject5).append(",");
      ((StringBuilder)localObject5).append(((eu)localObject2).b);
      ((StringBuilder)localObject5).append("\"");
      ((StringBuilder)localObject3).append(((StringBuilder)localObject5).toString());
      ((StringBuilder)localObject3).append("}");
      localObject2 = ((StringBuilder)localObject3).toString();
      localObject3 = paramea;
      Object localObject7 = ((ea)localObject3).b;
      localObject5 = new HashMap();
      ((HashMap)localObject5).put("imei", ((du)localObject7).a());
      ((HashMap)localObject5).put("imsi", ((du)localObject7).b());
      Object localObject6 = ((du)localObject7).p;
      if (localObject6 == null) {
        ((du)localObject7).p = new Pair((String)dy.b("LocationSDK", "location_device_id_type", ""), (String)dy.b("LocationSDK", "location_device_id", ""));
      }
      ((HashMap)localObject5).put("idfa", ((du)localObject7).p.second);
      ((HashMap)localObject5).put("phonenum", co.e(((du)localObject7).d));
      ((HashMap)localObject5).put("qq", co.e(((du)localObject7).f));
      ((HashMap)localObject5).put("mac", ((du)localObject7).c().toLowerCase(Locale.ENGLISH));
      localObject5 = new JSONObject((Map)localObject5).toString();
      String str = ((du)localObject7).f();
      fm.a();
      int k = fm.a(((ea)localObject3).a);
      localObject6 = fq.c(paramea);
      localObject3 = ((du)localObject7).j;
      paramea = (ea)localObject3;
      if (localObject3 != null) {
        paramea = ((String)localObject3).replace("\"", "");
      }
      localObject3 = paramea;
      if (paramea != null) {
        localObject3 = paramea.replace("|", "");
      }
      paramea = new StringBuilder();
      paramea.append((String)localObject3);
      paramea.append("_");
      paramea.append(((du)localObject7).h);
      paramea = paramea.toString();
      j = 203;
      i = j;
      if (paramBoolean2)
      {
        localObject3 = ((du)localObject7).a();
        i = j;
        if (localObject3 != null) {
          i = Math.abs(((String)localObject3).hashCode()) % 1000 + 1001;
        }
      }
      localObject3 = new StringBuilder("{\"version\":\"");
      ((StringBuilder)localObject3).append(((du)localObject7).d());
      ((StringBuilder)localObject3).append("\",\"address\":");
      ((StringBuilder)localObject3).append(paramInt1);
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append((String)localObject3);
      ((StringBuilder)localObject7).append(",\"source\":");
      ((StringBuilder)localObject7).append(i);
      ((StringBuilder)localObject7).append(",\"access_token\":\"");
      ((StringBuilder)localObject7).append(str);
      ((StringBuilder)localObject7).append("\",\"app_name\":\"");
      ((StringBuilder)localObject7).append(paramString);
      ((StringBuilder)localObject7).append("\",\"app_label\":\"");
      ((StringBuilder)localObject7).append(paramea);
      ((StringBuilder)localObject7).append("\",\"bearing\":1");
      paramea = ((StringBuilder)localObject7).toString();
      paramString = paramea;
      if (paramInt2 >= 0)
      {
        paramString = new StringBuilder();
        paramString.append(paramea);
        paramString.append(",\"control\":");
        paramString.append(paramInt2);
        paramString = paramString.toString();
      }
      if ((paramBoolean1) && (!paramBoolean2))
      {
        paramea = new StringBuilder();
        paramea.append(paramString);
        paramea.append(",\"detectgps\":1");
        paramString = paramea.toString();
      }
      else
      {
        paramea = new StringBuilder();
        paramea.append(paramString);
        paramea.append(",\"detectgps\":0");
        paramString = paramea.toString();
      }
      paramea = new StringBuilder();
      paramea.append(paramString);
      paramea.append(",\"pstat\":");
      paramea.append(k);
      paramString = paramea.toString();
      paramea = new StringBuilder();
      paramea.append(paramString);
      paramea.append(",\"wlan\":");
      paramea.append((String)localObject6);
      paramString = paramea.toString();
      paramea = new StringBuilder();
      paramea.append(paramString);
      paramea.append(",\"attribute\":");
      paramea.append((String)localObject5);
      paramea.append(",\"location\":");
      paramea.append((String)localObject2);
      paramea.append(",\"cells\":");
      paramea.append((String)localObject4);
      paramea.append(",\"wifis\":");
      paramea.append((String)localObject1);
      paramea.append("}");
      paramString = paramea.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      label1345:
      break label1345;
    }
    return null;
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ev
 * JD-Core Version:    0.7.0.1
 */
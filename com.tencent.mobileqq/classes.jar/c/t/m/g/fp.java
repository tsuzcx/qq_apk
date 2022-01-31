package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.telephony.NeighboringCellInfo;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.tencentmap.lbssdk.service.e;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fp
{
  public int a;
  public final ArrayList<TencentPoi> b = new ArrayList();
  public fg c;
  
  public fp() {}
  
  public fp(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("stat");
    if (paramJSONObject.has("subnation")) {
      this.c = new fg(paramJSONObject.optJSONObject("subnation"));
    }
    for (;;)
    {
      paramJSONObject = paramJSONObject.optJSONArray("poilist");
      if (paramJSONObject != null) {
        try
        {
          int j = paramJSONObject.length();
          int i = 0;
          for (;;)
          {
            if (i < j)
            {
              ff localff = new ff(paramJSONObject.getJSONObject(i));
              this.b.add(localff);
              i += 1;
              continue;
              if (paramJSONObject.has("results"))
              {
                this.c = a(paramJSONObject.optJSONArray("results"));
                break;
              }
              this.c = fg.a;
              new StringBuilder("DetailsData: unknown json ").append(paramJSONObject.toString());
            }
          }
        }
        catch (JSONException paramJSONObject) {}
      }
    }
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
    double d = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    return Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D) + d)) * 2.0D * 6378.1369999999997D * 10000.0D) / 10000.0D * 1000.0D;
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
  
  private static fg a(JSONArray paramJSONArray)
  {
    int i = 2;
    if (paramJSONArray == null) {
      localObject1 = null;
    }
    fg localfg;
    int j;
    Object localObject2;
    do
    {
      return localObject1;
      localfg = fg.a(fg.a);
      j = paramJSONArray.length();
      if (j > 0)
      {
        localObject1 = paramJSONArray.optJSONObject(0);
        localfg.b = ((JSONObject)localObject1).optString("n");
        localfg.e = ((JSONObject)localObject1).optString("p");
        localfg.f = ((JSONObject)localObject1).optString("c");
        localfg.g = ((JSONObject)localObject1).optString("d");
        localfg.d = ((JSONObject)localObject1).optString("adcode");
      }
      if (j > 1)
      {
        localObject1 = paramJSONArray.optJSONObject(1);
        localObject2 = ((JSONObject)localObject1).optString("address_name");
        localfg.m.putString("addrdesp.name", (String)localObject2);
        localObject2 = ((JSONObject)localObject1).optJSONObject("landmark");
        localObject1 = ((JSONObject)localObject1).optJSONObject("second_landmark");
        if (localObject2 != null) {
          localfg.m.putParcelable("addrdesp.landmark", new fb((JSONObject)localObject2));
        }
        if (localObject1 != null) {
          localfg.m.putParcelable("addrdesp.second_landmark", new fb((JSONObject)localObject1));
        }
      }
      localObject1 = localfg;
    } while (j <= 2);
    Object localObject1 = new ArrayList();
    if (i < j)
    {
      localObject2 = new fb(paramJSONArray.optJSONObject(i));
      ((ArrayList)localObject1).add(localObject2);
      if ("ST".equals(((fb)localObject2).b)) {
        localfg.j = ((fb)localObject2).a;
      }
      for (;;)
      {
        i += 1;
        break;
        if ("ST_NO".equals(((fb)localObject2).b)) {
          localfg.k = ((fb)localObject2).a;
        }
      }
    }
    localfg.m.putParcelableArrayList("addrdesp.results", (ArrayList)localObject1);
    return localfg;
  }
  
  private static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"mcc\":");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",\"mnc\":");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",\"lac\":");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(",\"cellid\":");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(",\"rss\":");
    localStringBuilder.append(paramInt5);
    if ((paramInt6 != 2147483647) && (paramInt7 != 2147483647))
    {
      localStringBuilder.append(",\"stationLat\":");
      localStringBuilder.append(String.format("%.6f", new Object[] { Float.valueOf(paramInt6 / 14400.0F) }));
      localStringBuilder.append(",\"stationLng\":");
      localStringBuilder.append(String.format("%.6f", new Object[] { Float.valueOf(paramInt7 / 14400.0F) }));
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public static String a(eu parameu, boolean paramBoolean)
  {
    if (parameu == null) {
      return "[]";
    }
    int j = parameu.b;
    int k = parameu.c;
    int m = parameu.a.ordinal();
    Object localObject1 = new ArrayList();
    Object localObject2 = parameu.a();
    int i;
    int n;
    Object localObject4;
    if (fj.a(m, j, k, parameu.d, parameu.e))
    {
      i = parameu.d;
      int i2 = parameu.e;
      int i3 = parameu.f;
      n = parameu.g;
      int i1 = parameu.h;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("{");
      ((StringBuilder)localObject4).append("\"mcc\":");
      ((StringBuilder)localObject4).append(j);
      ((StringBuilder)localObject4).append(",\"mnc\":");
      ((StringBuilder)localObject4).append(k);
      ((StringBuilder)localObject4).append(",\"lac\":");
      ((StringBuilder)localObject4).append(i);
      ((StringBuilder)localObject4).append(",\"cellid\":");
      ((StringBuilder)localObject4).append(i2);
      ((StringBuilder)localObject4).append(",\"rss\":");
      ((StringBuilder)localObject4).append(i3);
      ((StringBuilder)localObject4).append(",\"seed\":");
      if (paramBoolean)
      {
        i = 1;
        ((StringBuilder)localObject4).append(i);
        ((StringBuilder)localObject4).append(",\"networktype\":");
        ((StringBuilder)localObject4).append(m);
        if ((n != 2147483647) && (i1 != 2147483647))
        {
          ((StringBuilder)localObject4).append(",\"stationLat\":");
          ((StringBuilder)localObject4).append(String.format("%.6f", new Object[] { Float.valueOf(n / 14400.0F) }));
          ((StringBuilder)localObject4).append(",\"stationLng\":");
          ((StringBuilder)localObject4).append(String.format("%.6f", new Object[] { Float.valueOf(i1 / 14400.0F) }));
        }
        ((StringBuilder)localObject4).append("}");
        ((ArrayList)localObject1).add(((StringBuilder)localObject4).toString());
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (NeighboringCellInfo)((Iterator)localObject2).next();
          i = ((NeighboringCellInfo)localObject4).getLac();
          n = ((NeighboringCellInfo)localObject4).getCid();
          if (!fj.a(m, j, k, i, n)) {
            break label607;
          }
          ((ArrayList)localObject1).add(a(j, k, i, n, (((NeighboringCellInfo)localObject4).getRssi() << 1) - 113, 2147483647, 2147483647));
          continue;
        }
      }
      catch (Exception localException)
      {
        try
        {
          parameu = parameu.b().iterator();
          Object localObject3;
          if (parameu.hasNext())
          {
            localObject3 = (eu)parameu.next();
            ((ArrayList)localObject1).add(a(((eu)localObject3).b, ((eu)localObject3).c, ((eu)localObject3).d, ((eu)localObject3).e, ((eu)localObject3).f, ((eu)localObject3).g, ((eu)localObject3).h));
            continue;
          }
          i = 0;
        }
        catch (Throwable parameu)
        {
          parameu = new StringBuilder("[");
          localObject3 = new fl(",");
          localObject1 = ((Iterable)localObject1).iterator();
          parameu.append(((fl)localObject3).a(new StringBuilder(), (Iterator)localObject1).toString());
          parameu.append("]");
          return parameu.toString();
        }
      }
      a("illeagal main cell! ", j, k, m, parameu.d, parameu.e);
      continue;
      label607:
      a("illeagal neighboringCell! ", j, k, m, i, n);
    }
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
  
  public static boolean a(Location paramLocation, double[] paramArrayOfDouble)
  {
    int n = (int)(paramLocation.getLatitude() * 1000000.0D);
    int i1 = (int)(paramLocation.getLongitude() * 1000000.0D);
    paramLocation = co.d("tencent_loc_lib");
    int k = 0;
    int m = 0;
    while (k < paramLocation.length())
    {
      int i2 = paramLocation.charAt(k);
      int j = 256;
      int i = j;
      if (i2 >= 65)
      {
        i = j;
        if (i2 <= 90) {
          i = i2 - 65;
        }
      }
      j = i;
      if (i2 >= 97)
      {
        j = i;
        if (i2 <= 122) {
          j = i2 - 97 + 64;
        }
      }
      i = j;
      if (i2 >= 48)
      {
        i = j;
        if (i2 <= 57) {
          i = i2 + 128 - 48;
        }
      }
      m += i;
      k += 1;
    }
    paramLocation = new double[2];
    try
    {
      e.b(n ^ m, m ^ i1, paramLocation);
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
  
  public static boolean a(String paramString)
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
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DetailsData{");
    localStringBuilder.append("subnation=").append(this.c).append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((TencentPoi)localIterator.next()).append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.fp
 * JD-Core Version:    0.7.0.1
 */
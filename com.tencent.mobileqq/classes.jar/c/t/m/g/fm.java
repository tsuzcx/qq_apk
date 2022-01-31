package c.t.m.g;

import android.location.Location;
import android.telephony.NeighboringCellInfo;
import com.tencent.tencentmap.lbssdk.service.e;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class fm
{
  public final float a;
  public final float b;
  public final float c;
  private final long d;
  private final long e;
  
  public fm(long paramLong1, long paramLong2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.d = paramLong1;
    this.e = paramLong2;
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
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
  
  public static String a(eq parameq, boolean paramBoolean)
  {
    if (parameq == null) {
      return "[]";
    }
    int j = parameq.b;
    int k = parameq.c;
    int m = parameq.a.ordinal();
    Object localObject1 = new ArrayList();
    Object localObject2 = parameq.a();
    int i;
    int n;
    Object localObject4;
    if (fg.a(m, j, k, parameq.d, parameq.e))
    {
      i = parameq.d;
      int i2 = parameq.e;
      int i3 = parameq.f;
      n = parameq.g;
      int i1 = parameq.h;
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
          if (!fg.a(m, j, k, i, n)) {
            break label585;
          }
          ((ArrayList)localObject1).add(a(j, k, i, n, (((NeighboringCellInfo)localObject4).getRssi() << 1) - 113, 2147483647, 2147483647));
          continue;
        }
      }
      catch (Exception localException)
      {
        try
        {
          parameq = parameq.b().iterator();
          Object localObject3;
          if (parameq.hasNext())
          {
            localObject3 = (eq)parameq.next();
            ((ArrayList)localObject1).add(a(((eq)localObject3).b, ((eq)localObject3).c, ((eq)localObject3).d, ((eq)localObject3).e, ((eq)localObject3).f, ((eq)localObject3).g, ((eq)localObject3).h));
            continue;
          }
          i = 0;
        }
        catch (Throwable parameq)
        {
          parameq = new StringBuilder("[");
          localObject3 = new fi(",");
          localObject1 = ((Iterable)localObject1).iterator();
          parameq.append(((fi)localObject3).a(new StringBuilder(), (Iterator)localObject1).toString());
          parameq.append("]");
          return parameq.toString();
        }
      }
      a("illeagal main cell! ", j, k, m, parameq.d, parameq.e);
      continue;
      label585:
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
    paramLocation = co.c("tencent_loc_lib");
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
  
  public final float a()
  {
    return (float)Math.sqrt(Math.pow(this.a, 2.0D) + Math.pow(this.b, 2.0D) + Math.pow(this.c, 2.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.fm
 * JD-Core Version:    0.7.0.1
 */
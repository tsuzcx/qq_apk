package com.tencent.biz.qqstory.album.tools;

import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.List;

public class GeoHashUtils
{
  private static final String[] a = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "b", "c", "d", "e", "f", "g", "h", "j", "k", "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
  private static String b = "0123456789bcdefghjkmnpqrstuvwxyz";
  
  public static GeoHashUtils.Gps a(String paramString)
  {
    Object localObject = b(paramString);
    GeoHashUtils.Gps localGps = (GeoHashUtils.Gps)((List)localObject).get(0);
    localObject = (GeoHashUtils.Gps)((List)localObject).get(1);
    double d3 = GeoHashUtils.Gps.a(localGps);
    double d1 = GeoHashUtils.Gps.b(localGps);
    double d4 = GeoHashUtils.Gps.a((GeoHashUtils.Gps)localObject);
    double d2 = GeoHashUtils.Gps.b((GeoHashUtils.Gps)localObject);
    d3 = (d3 + d4) / 2.0D;
    d1 = (d1 + d2) / 2.0D;
    localGps = new GeoHashUtils.Gps(d3, d1);
    SLog.a("Q.qqstory.recommendAlbum.logic.decodeGeoHash", " geoHash=%s, lat=%s, lon=%s", paramString, Double.valueOf(d3), Double.valueOf(d1));
    return localGps;
  }
  
  public static String a(double paramDouble1, double paramDouble2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    double d3 = 90.0D;
    double d6 = -90.0D;
    double d1 = 0.0D;
    double d5 = -180.0D;
    double d2 = 180.0D;
    int k = 0;
    double d7 = d1;
    while (k < paramInt)
    {
      double d4 = d3;
      int m = 0;
      int n = 0;
      d3 = d2;
      d2 = d7;
      int j = i;
      i = m;
      m = n;
      while (m < 5)
      {
        if (j != 0)
        {
          i <<= 1;
          if (paramDouble2 >= d1)
          {
            d7 = (d3 + d1) / 2.0D;
            i += 1;
            d5 = d1;
            d1 = d7;
          }
          else
          {
            d3 = (d1 + d5) / 2.0D;
            d7 = d1;
            d1 = d3;
            d3 = d7;
          }
        }
        else
        {
          i <<= 1;
          if (paramDouble1 >= d2)
          {
            d7 = (d4 + d2) / 2.0D;
            i += 1;
            d6 = d2;
            d2 = d7;
          }
          else
          {
            d7 = (d2 + d6) / 2.0D;
            d4 = d2;
            d2 = d7;
          }
        }
        j ^= 0x1;
        m += 1;
      }
      localStringBuilder.append(a[i]);
      k += 1;
      i = j;
      d7 = d4;
      d4 = d3;
      d3 = d7;
      d7 = d2;
      d2 = d4;
    }
    return localStringBuilder.toString();
  }
  
  public static List<GeoHashUtils.Gps> b(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      paramString = paramString.toLowerCase();
      double d4 = -90.0D;
      double d3 = 90.0D;
      double d2 = -180.0D;
      double d1 = 180.0D;
      int i = 0;
      int j = 1;
      while (i < paramString.length())
      {
        int k = paramString.charAt(i);
        int m = b.indexOf(k);
        if (m != -1)
        {
          k = 4;
          while (k >= 0)
          {
            double d6 = m >> k & 0x1;
            double d5;
            if (j != 0)
            {
              d5 = (d2 + d1) / 2.0D;
              if (d6 == 1.0D) {
                d2 = d5;
              } else {
                d1 = d5;
              }
            }
            else
            {
              d5 = (d4 + d3) / 2.0D;
              if (d6 == 1.0D) {
                d4 = d5;
              } else {
                d3 = d5;
              }
            }
            j ^= 0x1;
            k -= 1;
          }
          i += 1;
        }
        else
        {
          throw new Error("Invalid geoHash");
        }
      }
      paramString = new GeoHashUtils.Gps(d4, d2);
      GeoHashUtils.Gps localGps = new GeoHashUtils.Gps(d3, d1);
      ArrayList localArrayList = new ArrayList(2);
      localArrayList.add(paramString);
      localArrayList.add(localGps);
      return localArrayList;
    }
    paramString = new Error("Invalid geoHash");
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.tools.GeoHashUtils
 * JD-Core Version:    0.7.0.1
 */
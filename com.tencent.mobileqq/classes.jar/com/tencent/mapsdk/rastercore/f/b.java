package com.tencent.mapsdk.rastercore.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.d.e;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public final class b
{
  private static final int a;
  private static final int b;
  
  static
  {
    Double.doubleToRawLongBits(0.0D);
    Double.doubleToRawLongBits(0.0D);
    a = Float.floatToRawIntBits(0.0F);
    b = Float.floatToRawIntBits(0.0F);
    Double.longBitsToDouble(4368491638549381120L);
    Double.longBitsToDouble(4503599627370496L);
  }
  
  public static int a(Object[] paramArrayOfObject)
  {
    return Arrays.hashCode(paramArrayOfObject);
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null) {
      return null;
    }
    return Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * paramFloat), (int)(paramBitmap.getHeight() * paramFloat), true);
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      paramString = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + paramString);
      Bitmap localBitmap = BitmapFactory.decodeStream(paramString);
      paramString.close();
      return localBitmap;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static GeoPoint a(LatLng paramLatLng)
  {
    return new GeoPoint((int)(paramLatLng.getLatitude() * 1000000.0D), (int)(paramLatLng.getLongitude() * 1000000.0D));
  }
  
  public static LatLng a(GeoPoint paramGeoPoint)
  {
    return new LatLng(paramGeoPoint.getLatitudeE6() * 1.0D / 1000000.0D, paramGeoPoint.getLongitudeE6() * 1.0D / 1000000.0D);
  }
  
  public static String a(Context paramContext)
  {
    Object localObject;
    if (paramContext == null) {
      localObject = "";
    }
    for (;;)
    {
      return localObject;
      try
      {
        localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(e.a().getPackageName(), 128);
        paramContext = localApplicationInfo.metaData.getString("com.tencent.map.api_key");
        localObject = paramContext;
      }
      catch (Exception localException1)
      {
        try
        {
          ApplicationInfo localApplicationInfo;
          if (!TextUtils.isEmpty(paramContext)) {
            continue;
          }
          localObject = localApplicationInfo.metaData.getString("TencentMapSDK");
          return localObject;
        }
        catch (Exception localException2)
        {
          break;
        }
        localException1 = localException1;
        paramContext = "";
      }
    }
    new StringBuilder("error get mapkey:").append(localException1.getMessage());
    return paramContext;
  }
  
  public static String a(String paramString, Object paramObject)
  {
    return paramString + "=" + String.valueOf(paramObject);
  }
  
  public static String a(String... paramVarArgs)
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramVarArgs.length;
    int j = 0;
    while (i < k)
    {
      localStringBuilder.append(paramVarArgs[i]);
      if (j != paramVarArgs.length - 1) {
        localStringBuilder.append(",");
      }
      j += 1;
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Math.abs((paramDouble3 - paramDouble1) * (paramDouble6 - paramDouble2) - (paramDouble5 - paramDouble1) * (paramDouble4 - paramDouble2)) < 1.E-009D)
    {
      bool1 = bool2;
      if ((paramDouble1 - paramDouble3) * (paramDouble1 - paramDouble5) <= 0.0D)
      {
        bool1 = bool2;
        if ((paramDouble2 - paramDouble4) * (paramDouble2 - paramDouble6) <= 0.0D) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    int j = Float.floatToRawIntBits(paramFloat1);
    int k = Float.floatToRawIntBits(0.0F);
    int i;
    if (((j ^ k) & 0x80000000) == 0) {
      if (Math.abs(j - k) <= 1) {
        i = 1;
      }
    }
    while ((i != 0) && (!Float.isNaN(paramFloat1)) && (!Float.isNaN(0.0F)))
    {
      return true;
      i = 0;
      continue;
      if (j < k)
      {
        i = k - a;
        j -= b;
      }
      for (;;)
      {
        if ((i > 1) || (j > 1 - i)) {
          break label111;
        }
        i = 1;
        break;
        i = j - a;
        j = k - b;
      }
      label111:
      i = 0;
    }
    return false;
  }
  
  public static boolean a(LatLng paramLatLng, List<LatLng> paramList)
  {
    double d1 = paramLatLng.getLongitude();
    double d2 = paramLatLng.getLatitude();
    double d3 = paramLatLng.getLatitude();
    int i = 0;
    int j = 0;
    if (j < paramList.size() - 1)
    {
      double d5 = ((LatLng)paramList.get(j)).getLongitude();
      double d6 = ((LatLng)paramList.get(j)).getLatitude();
      double d7 = ((LatLng)paramList.get(j + 1)).getLongitude();
      double d8 = ((LatLng)paramList.get(j + 1)).getLatitude();
      if (a(d1, d2, d5, d6, d7, d8)) {
        return true;
      }
      if (Math.abs(d8 - d6) < 1.E-009D) {
        break label356;
      }
      if (a(d5, d6, d1, d2, 180.0D, d3))
      {
        if (d6 <= d8) {
          break label356;
        }
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (!a(d7, d8, d1, d2, 180.0D, d3)) {
          break label214;
        }
        if (d8 <= d6) {
          break label356;
        }
        i += 1;
      }
      label214:
      double d9 = (d7 - d5) * (d3 - d2) - (d8 - d6) * (180.0D - d1);
      if (d9 == 0.0D) {
        break label359;
      }
      double d4 = ((d6 - d2) * (180.0D - d1) - (d5 - d1) * (d3 - d2)) / d9;
      d5 = ((d7 - d5) * (d6 - d2) - (d5 - d1) * (d8 - d6)) / d9;
      if ((d4 < 0.0D) || (d4 > 1.0D) || (d5 < 0.0D) || (d5 > 1.0D)) {
        break label359;
      }
    }
    label356:
    label359:
    for (int k = 1;; k = 0)
    {
      if (k != 0)
      {
        i += 1;
        break;
        return i % 2 != 0;
      }
      break;
    }
  }
  
  public static final boolean a(Collection<?> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.size() <= 0);
  }
  
  public static void b(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return;
      Stack localStack = new Stack();
      localStack.push(paramString);
      while (!localStack.isEmpty())
      {
        File localFile = new File((String)localStack.peek());
        if (localFile.exists())
        {
          if (localFile.isDirectory())
          {
            paramString = localFile.listFiles();
            if ((paramString == null) || (paramString.length == 0))
            {
              localFile.delete();
              localStack.pop();
            }
            else
            {
              int j = paramString.length;
              int i = 0;
              label99:
              if (i < j)
              {
                localFile = paramString[i];
                if (!localFile.isDirectory()) {
                  break label134;
                }
                localStack.push(localFile.getAbsolutePath());
              }
              for (;;)
              {
                i += 1;
                break label99;
                break;
                label134:
                localFile.delete();
              }
            }
          }
          else
          {
            localFile.delete();
            localStack.pop();
          }
        }
        else {
          localStack.pop();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.f.b
 * JD-Core Version:    0.7.0.1
 */
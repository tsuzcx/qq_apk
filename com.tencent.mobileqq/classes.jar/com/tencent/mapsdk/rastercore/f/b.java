package com.tencent.mapsdk.rastercore.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.d.f;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    int i = (int)(paramBitmap.getWidth() * paramFloat);
    int j = (int)(paramBitmap.getHeight() * paramFloat);
    try
    {
      paramBitmap = Bitmap.createScaledBitmap(paramBitmap, i, j, true);
      return paramBitmap;
    }
    catch (Exception paramBitmap) {}
    return null;
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
        localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(f.a().getPackageName(), 128);
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
  
  public static void a(View paramView, int paramInt)
  {
    Field localField = null;
    Object localObject2 = View.class.getMethods();
    int j = localObject2.length;
    int i = 0;
    for (;;)
    {
      Object localObject1;
      if (i < j)
      {
        localObject1 = localObject2[i];
        if (!localObject1.getName().equals("setLayerType")) {}
      }
      else
      {
        while (localObject1 != null)
        {
          switch (paramInt)
          {
          }
          for (;;)
          {
            localObject2 = localField;
            if (localField == null) {}
            try
            {
              localObject2 = View.class.getField("LAYER_TYPE_SOFTWARE");
              localObject1.invoke(paramView, new Object[] { Integer.valueOf(((Field)localObject2).getInt(null)), null });
              return;
            }
            catch (Exception paramView)
            {
              paramView.printStackTrace();
              return;
            }
            localField = View.class.getField("LAYER_TYPE_NONE");
            continue;
            localField = View.class.getField("LAYER_TYPE_SOFTWARE");
            continue;
            localField = View.class.getField("LAYER_TYPE_HARDWARE");
          }
          localObject1 = null;
        }
        return;
      }
      i += 1;
    }
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
    boolean bool;
    if ((paramList == null) || (paramList.size() < 3) || (paramLatLng == null)) {
      bool = false;
    }
    int i;
    int k;
    int j;
    do
    {
      return bool;
      i = paramList.size();
      k = 0;
      j = i - 1;
      i = 0;
      bool = k;
    } while (i >= paramList.size());
    if (((((LatLng)paramList.get(i)).getLatitude() < paramLatLng.getLatitude()) && (((LatLng)paramList.get(j)).getLatitude() >= paramLatLng.getLatitude())) || ((((LatLng)paramList.get(j)).getLatitude() < paramLatLng.getLatitude()) && (((LatLng)paramList.get(i)).getLatitude() >= paramLatLng.getLatitude()) && ((((LatLng)paramList.get(i)).getLongitude() <= paramLatLng.getLongitude()) || (((LatLng)paramList.get(j)).getLongitude() <= paramLatLng.getLongitude())))) {
      if (((LatLng)paramList.get(i)).getLongitude() + (paramLatLng.getLatitude() - ((LatLng)paramList.get(i)).getLatitude()) / (((LatLng)paramList.get(j)).getLatitude() - ((LatLng)paramList.get(i)).getLatitude()) * (((LatLng)paramList.get(j)).getLongitude() - ((LatLng)paramList.get(i)).getLongitude()) < paramLatLng.getLongitude())
      {
        j = 1;
        label278:
        k ^= j;
      }
    }
    for (;;)
    {
      j = i;
      i += 1;
      break;
      j = 0;
      break label278;
    }
  }
  
  public static final boolean a(Collection<?> paramCollection)
  {
    return (paramCollection == null) || (paramCollection.size() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.f.b
 * JD-Core Version:    0.7.0.1
 */
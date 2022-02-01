package com.tencent.ad.tangram.lbs;

import android.support.annotation.Keep;
import java.io.Serializable;

@Keep
public final class AdLocation
  implements Serializable
{
  private static final String TAG = "AdLocation";
  public double latitude = -2147483648.0D;
  public double longitude = -2147483648.0D;
  public long timeMillis = -2147483648L;
  
  public static AdLocation merge(AdLocation paramAdLocation1, AdLocation paramAdLocation2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramAdLocation1 != null)
    {
      localObject1 = localObject2;
      if (paramAdLocation1.isValid()) {
        localObject1 = paramAdLocation1;
      }
    }
    if ((paramAdLocation2 != null) && (paramAdLocation2.isValid()))
    {
      if (localObject1 == null) {}
      while (((((AdLocation)localObject1).timeMillis == -2147483648L) && (paramAdLocation2.timeMillis != -2147483648L)) || ((((AdLocation)localObject1).timeMillis != -2147483648L) && (paramAdLocation2.timeMillis != -2147483648L) && (((AdLocation)localObject1).timeMillis < paramAdLocation2.timeMillis))) {
        return paramAdLocation2;
      }
    }
    return localObject1;
  }
  
  public boolean isValid()
  {
    return (this.latitude != -2147483648.0D) && (this.longitude != -2147483648.0D);
  }
  
  public String toString()
  {
    return String.format("latitude:%f longitude:%f timeMillis:%d", new Object[] { Double.valueOf(this.latitude), Double.valueOf(this.longitude), Long.valueOf(this.timeMillis) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.lbs.AdLocation
 * JD-Core Version:    0.7.0.1
 */
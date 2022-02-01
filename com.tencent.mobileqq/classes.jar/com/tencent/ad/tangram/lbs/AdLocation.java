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
    if ((paramAdLocation1 == null) || (!paramAdLocation1.isValid())) {
      paramAdLocation1 = null;
    }
    AdLocation localAdLocation = paramAdLocation1;
    if (paramAdLocation2 != null)
    {
      localAdLocation = paramAdLocation1;
      if (paramAdLocation2.isValid()) {
        if ((paramAdLocation1 != null) && ((paramAdLocation1.timeMillis != -2147483648L) || (paramAdLocation2.timeMillis == -2147483648L)))
        {
          long l1 = paramAdLocation1.timeMillis;
          localAdLocation = paramAdLocation1;
          if (l1 != -2147483648L)
          {
            long l2 = paramAdLocation2.timeMillis;
            localAdLocation = paramAdLocation1;
            if (l2 != -2147483648L)
            {
              localAdLocation = paramAdLocation1;
              if (l1 >= l2) {}
            }
          }
        }
        else
        {
          localAdLocation = paramAdLocation2;
        }
      }
    }
    return localAdLocation;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.lbs.AdLocation
 * JD-Core Version:    0.7.0.1
 */
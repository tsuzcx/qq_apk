package androidx.core.location;

import android.location.LocationManager;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;

public final class LocationManagerCompat
{
  public static boolean isLocationEnabled(@NonNull LocationManager paramLocationManager)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramLocationManager.isLocationEnabled();
    }
    return (paramLocationManager.isProviderEnabled("network")) || (paramLocationManager.isProviderEnabled("gps"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.location.LocationManagerCompat
 * JD-Core Version:    0.7.0.1
 */
package androidx.core.net;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;

public final class ConnectivityManagerCompat
{
  public static final int RESTRICT_BACKGROUND_STATUS_DISABLED = 1;
  public static final int RESTRICT_BACKGROUND_STATUS_ENABLED = 3;
  public static final int RESTRICT_BACKGROUND_STATUS_WHITELISTED = 2;
  
  @SuppressLint({"ReferencesDeprecated"})
  @Nullable
  @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
  public static NetworkInfo getNetworkInfoFromBroadcast(@NonNull ConnectivityManager paramConnectivityManager, @NonNull Intent paramIntent)
  {
    paramIntent = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    if (paramIntent != null) {
      return paramConnectivityManager.getNetworkInfo(paramIntent.getType());
    }
    return null;
  }
  
  public static int getRestrictBackgroundStatus(@NonNull ConnectivityManager paramConnectivityManager)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return paramConnectivityManager.getRestrictBackgroundStatus();
    }
    return 3;
  }
  
  @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
  public static boolean isActiveNetworkMetered(@NonNull ConnectivityManager paramConnectivityManager)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return paramConnectivityManager.isActiveNetworkMetered();
    }
    paramConnectivityManager = paramConnectivityManager.getActiveNetworkInfo();
    if (paramConnectivityManager == null) {
      return true;
    }
    switch (paramConnectivityManager.getType())
    {
    case 8: 
    default: 
      return true;
    case 1: 
    case 7: 
    case 9: 
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.net.ConnectivityManagerCompat
 * JD-Core Version:    0.7.0.1
 */
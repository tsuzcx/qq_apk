package androidx.appcompat.app;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import androidx.annotation.NonNull;

class AppCompatDelegateImpl$AutoBatteryNightModeManager
  extends AppCompatDelegateImpl.AutoNightModeManager
{
  private final PowerManager mPowerManager;
  
  AppCompatDelegateImpl$AutoBatteryNightModeManager(AppCompatDelegateImpl paramAppCompatDelegateImpl, @NonNull Context paramContext)
  {
    super(paramAppCompatDelegateImpl);
    this.mPowerManager = ((PowerManager)paramContext.getApplicationContext().getSystemService("power"));
  }
  
  IntentFilter createIntentFilterForBroadcastReceiver()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
      return localIntentFilter;
    }
    return null;
  }
  
  public int getApplyableNightMode()
  {
    int k = Build.VERSION.SDK_INT;
    int j = 1;
    int i = j;
    if (k >= 21)
    {
      i = j;
      if (this.mPowerManager.isPowerSaveMode()) {
        i = 2;
      }
    }
    return i;
  }
  
  public void onChange()
  {
    this.this$0.applyDayNight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.AutoBatteryNightModeManager
 * JD-Core Version:    0.7.0.1
 */
package androidx.appcompat.app;

import android.content.IntentFilter;
import androidx.annotation.NonNull;

class AppCompatDelegateImpl$AutoTimeNightModeManager
  extends AppCompatDelegateImpl.AutoNightModeManager
{
  private final TwilightManager mTwilightManager;
  
  AppCompatDelegateImpl$AutoTimeNightModeManager(AppCompatDelegateImpl paramAppCompatDelegateImpl, @NonNull TwilightManager paramTwilightManager)
  {
    super(paramAppCompatDelegateImpl);
    this.mTwilightManager = paramTwilightManager;
  }
  
  IntentFilter createIntentFilterForBroadcastReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
    localIntentFilter.addAction("android.intent.action.TIME_TICK");
    return localIntentFilter;
  }
  
  public int getApplyableNightMode()
  {
    if (this.mTwilightManager.isNight()) {
      return 2;
    }
    return 1;
  }
  
  public void onChange()
  {
    this.this$0.applyDayNight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.AutoTimeNightModeManager
 * JD-Core Version:    0.7.0.1
 */
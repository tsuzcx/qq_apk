package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@VisibleForTesting
abstract class AppCompatDelegateImpl$AutoNightModeManager
{
  private BroadcastReceiver mReceiver;
  
  AppCompatDelegateImpl$AutoNightModeManager(AppCompatDelegateImpl paramAppCompatDelegateImpl) {}
  
  void cleanup()
  {
    if (this.mReceiver != null) {}
    try
    {
      this.this$0.mContext.unregisterReceiver(this.mReceiver);
      label21:
      this.mReceiver = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label21;
    }
  }
  
  @Nullable
  abstract IntentFilter createIntentFilterForBroadcastReceiver();
  
  abstract int getApplyableNightMode();
  
  boolean isListening()
  {
    return this.mReceiver != null;
  }
  
  abstract void onChange();
  
  void setup()
  {
    cleanup();
    IntentFilter localIntentFilter = createIntentFilterForBroadcastReceiver();
    if (localIntentFilter != null)
    {
      if (localIntentFilter.countActions() == 0) {
        return;
      }
      if (this.mReceiver == null) {
        this.mReceiver = new AppCompatDelegateImpl.AutoNightModeManager.1(this);
      }
      this.this$0.mContext.registerReceiver(this.mReceiver, localIntentFilter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
 * JD-Core Version:    0.7.0.1
 */
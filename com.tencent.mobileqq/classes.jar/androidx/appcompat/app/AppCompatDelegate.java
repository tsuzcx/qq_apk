package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode.Callback;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class AppCompatDelegate
{
  static final boolean DEBUG = false;
  public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
  public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
  public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;
  @Deprecated
  public static final int MODE_NIGHT_AUTO = 0;
  public static final int MODE_NIGHT_AUTO_BATTERY = 3;
  @Deprecated
  public static final int MODE_NIGHT_AUTO_TIME = 0;
  public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
  public static final int MODE_NIGHT_NO = 1;
  public static final int MODE_NIGHT_UNSPECIFIED = -100;
  public static final int MODE_NIGHT_YES = 2;
  static final String TAG = "AppCompatDelegate";
  private static final ArraySet<WeakReference<AppCompatDelegate>> sActivityDelegates = new ArraySet();
  private static final Object sActivityDelegatesLock = new Object();
  private static int sDefaultNightMode = -100;
  
  static void addActiveDelegate(@NonNull AppCompatDelegate paramAppCompatDelegate)
  {
    synchronized (sActivityDelegatesLock)
    {
      removeDelegateFromActives(paramAppCompatDelegate);
      sActivityDelegates.add(new WeakReference(paramAppCompatDelegate));
      return;
    }
  }
  
  private static void applyDayNightToActiveDelegates()
  {
    synchronized (sActivityDelegatesLock)
    {
      Iterator localIterator = sActivityDelegates.iterator();
      while (localIterator.hasNext())
      {
        AppCompatDelegate localAppCompatDelegate = (AppCompatDelegate)((WeakReference)localIterator.next()).get();
        if (localAppCompatDelegate != null) {
          localAppCompatDelegate.applyDayNight();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  @NonNull
  public static AppCompatDelegate create(@NonNull Activity paramActivity, @Nullable AppCompatCallback paramAppCompatCallback)
  {
    return new AppCompatDelegateImpl(paramActivity, paramAppCompatCallback);
  }
  
  @NonNull
  public static AppCompatDelegate create(@NonNull Dialog paramDialog, @Nullable AppCompatCallback paramAppCompatCallback)
  {
    return new AppCompatDelegateImpl(paramDialog, paramAppCompatCallback);
  }
  
  @NonNull
  public static AppCompatDelegate create(@NonNull Context paramContext, @NonNull Activity paramActivity, @Nullable AppCompatCallback paramAppCompatCallback)
  {
    return new AppCompatDelegateImpl(paramContext, paramActivity, paramAppCompatCallback);
  }
  
  @NonNull
  public static AppCompatDelegate create(@NonNull Context paramContext, @NonNull Window paramWindow, @Nullable AppCompatCallback paramAppCompatCallback)
  {
    return new AppCompatDelegateImpl(paramContext, paramWindow, paramAppCompatCallback);
  }
  
  public static int getDefaultNightMode()
  {
    return sDefaultNightMode;
  }
  
  public static boolean isCompatVectorFromResourcesEnabled()
  {
    return VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
  }
  
  static void removeActivityDelegate(@NonNull AppCompatDelegate paramAppCompatDelegate)
  {
    synchronized (sActivityDelegatesLock)
    {
      removeDelegateFromActives(paramAppCompatDelegate);
      return;
    }
  }
  
  private static void removeDelegateFromActives(@NonNull AppCompatDelegate paramAppCompatDelegate)
  {
    synchronized (sActivityDelegatesLock)
    {
      Iterator localIterator = sActivityDelegates.iterator();
      while (localIterator.hasNext())
      {
        AppCompatDelegate localAppCompatDelegate = (AppCompatDelegate)((WeakReference)localIterator.next()).get();
        if ((localAppCompatDelegate == paramAppCompatDelegate) || (localAppCompatDelegate == null)) {
          localIterator.remove();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramAppCompatDelegate;
    }
  }
  
  public static void setCompatVectorFromResourcesEnabled(boolean paramBoolean)
  {
    VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(paramBoolean);
  }
  
  public static void setDefaultNightMode(int paramInt)
  {
    if ((paramInt != -1) && (paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
      return;
    }
    if (sDefaultNightMode != paramInt)
    {
      sDefaultNightMode = paramInt;
      applyDayNightToActiveDelegates();
    }
  }
  
  public abstract void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract boolean applyDayNight();
  
  @Deprecated
  public void attachBaseContext(Context paramContext) {}
  
  @CallSuper
  @NonNull
  public Context attachBaseContext2(@NonNull Context paramContext)
  {
    attachBaseContext(paramContext);
    return paramContext;
  }
  
  public abstract View createView(@Nullable View paramView, String paramString, @NonNull Context paramContext, @NonNull AttributeSet paramAttributeSet);
  
  @Nullable
  public abstract <T extends View> T findViewById(@IdRes int paramInt);
  
  @Nullable
  public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();
  
  public int getLocalNightMode()
  {
    return -100;
  }
  
  public abstract MenuInflater getMenuInflater();
  
  @Nullable
  public abstract ActionBar getSupportActionBar();
  
  public abstract boolean hasWindowFeature(int paramInt);
  
  public abstract void installViewFactory();
  
  public abstract void invalidateOptionsMenu();
  
  public abstract boolean isHandleNativeActionModesEnabled();
  
  public abstract void onConfigurationChanged(Configuration paramConfiguration);
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onPostCreate(Bundle paramBundle);
  
  public abstract void onPostResume();
  
  public abstract void onSaveInstanceState(Bundle paramBundle);
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract boolean requestWindowFeature(int paramInt);
  
  public abstract void setContentView(@LayoutRes int paramInt);
  
  public abstract void setContentView(View paramView);
  
  public abstract void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams);
  
  public abstract void setHandleNativeActionModesEnabled(boolean paramBoolean);
  
  @RequiresApi(17)
  public abstract void setLocalNightMode(int paramInt);
  
  public abstract void setSupportActionBar(@Nullable Toolbar paramToolbar);
  
  public void setTheme(@StyleRes int paramInt) {}
  
  public abstract void setTitle(@Nullable CharSequence paramCharSequence);
  
  @Nullable
  public abstract ActionMode startSupportActionMode(@NonNull ActionMode.Callback paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegate
 * JD-Core Version:    0.7.0.1
 */
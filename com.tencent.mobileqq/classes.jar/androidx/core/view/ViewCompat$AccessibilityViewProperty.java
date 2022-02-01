package androidx.core.view;

import android.os.Build.VERSION;
import android.view.View;

abstract class ViewCompat$AccessibilityViewProperty<T>
{
  private final int mFrameworkMinimumSdk;
  private final int mTagKey;
  private final Class<T> mType;
  
  ViewCompat$AccessibilityViewProperty(int paramInt1, Class<T> paramClass, int paramInt2)
  {
    this(paramInt1, paramClass, 0, paramInt2);
  }
  
  ViewCompat$AccessibilityViewProperty(int paramInt1, Class<T> paramClass, int paramInt2, int paramInt3)
  {
    this.mTagKey = paramInt1;
    this.mType = paramClass;
    this.mFrameworkMinimumSdk = paramInt3;
  }
  
  private boolean extrasAvailable()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
  
  private boolean frameworkAvailable()
  {
    return Build.VERSION.SDK_INT >= this.mFrameworkMinimumSdk;
  }
  
  boolean booleanNullToFalseEquals(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    boolean bool3 = false;
    boolean bool1;
    if (paramBoolean1 == null) {
      bool1 = false;
    } else {
      bool1 = paramBoolean1.booleanValue();
    }
    boolean bool2;
    if (paramBoolean2 == null) {
      bool2 = false;
    } else {
      bool2 = paramBoolean2.booleanValue();
    }
    if (bool1 == bool2) {
      bool3 = true;
    }
    return bool3;
  }
  
  abstract T frameworkGet(View paramView);
  
  abstract void frameworkSet(View paramView, T paramT);
  
  T get(View paramView)
  {
    if (frameworkAvailable()) {
      return frameworkGet(paramView);
    }
    if (extrasAvailable())
    {
      paramView = paramView.getTag(this.mTagKey);
      if (this.mType.isInstance(paramView)) {
        return paramView;
      }
    }
    return null;
  }
  
  void set(View paramView, T paramT)
  {
    if (frameworkAvailable())
    {
      frameworkSet(paramView, paramT);
      return;
    }
    if ((extrasAvailable()) && (shouldUpdate(get(paramView), paramT)))
    {
      ViewCompat.getOrCreateAccessibilityDelegateCompat(paramView);
      paramView.setTag(this.mTagKey, paramT);
      ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(paramView, 0);
    }
  }
  
  boolean shouldUpdate(T paramT1, T paramT2)
  {
    return paramT2.equals(paramT1) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.ViewCompat.AccessibilityViewProperty
 * JD-Core Version:    0.7.0.1
 */
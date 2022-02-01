package androidx.core.view.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityManager;
import java.util.List;

public final class AccessibilityManagerCompat
{
  @Deprecated
  public static boolean addAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityManagerCompat.AccessibilityStateChangeListener paramAccessibilityStateChangeListener)
  {
    if (paramAccessibilityStateChangeListener == null) {
      return false;
    }
    return paramAccessibilityManager.addAccessibilityStateChangeListener(new AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper(paramAccessibilityStateChangeListener));
  }
  
  public static boolean addTouchExplorationStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityManagerCompat.TouchExplorationStateChangeListener paramTouchExplorationStateChangeListener)
  {
    if ((Build.VERSION.SDK_INT < 19) || (paramTouchExplorationStateChangeListener == null)) {
      return false;
    }
    return paramAccessibilityManager.addTouchExplorationStateChangeListener(new AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper(paramTouchExplorationStateChangeListener));
  }
  
  @Deprecated
  public static List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager, int paramInt)
  {
    return paramAccessibilityManager.getEnabledAccessibilityServiceList(paramInt);
  }
  
  @Deprecated
  public static List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(AccessibilityManager paramAccessibilityManager)
  {
    return paramAccessibilityManager.getInstalledAccessibilityServiceList();
  }
  
  @Deprecated
  public static boolean isTouchExplorationEnabled(AccessibilityManager paramAccessibilityManager)
  {
    return paramAccessibilityManager.isTouchExplorationEnabled();
  }
  
  @Deprecated
  public static boolean removeAccessibilityStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityManagerCompat.AccessibilityStateChangeListener paramAccessibilityStateChangeListener)
  {
    if (paramAccessibilityStateChangeListener == null) {
      return false;
    }
    return paramAccessibilityManager.removeAccessibilityStateChangeListener(new AccessibilityManagerCompat.AccessibilityStateChangeListenerWrapper(paramAccessibilityStateChangeListener));
  }
  
  public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager paramAccessibilityManager, AccessibilityManagerCompat.TouchExplorationStateChangeListener paramTouchExplorationStateChangeListener)
  {
    if ((Build.VERSION.SDK_INT < 19) || (paramTouchExplorationStateChangeListener == null)) {
      return false;
    }
    return paramAccessibilityManager.removeTouchExplorationStateChangeListener(new AccessibilityManagerCompat.TouchExplorationStateChangeListenerWrapper(paramTouchExplorationStateChangeListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityManagerCompat
 * JD-Core Version:    0.7.0.1
 */
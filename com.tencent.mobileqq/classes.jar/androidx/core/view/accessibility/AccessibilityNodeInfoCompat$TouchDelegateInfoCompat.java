package androidx.core.view.accessibility;

import android.graphics.Region;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo.TouchDelegateInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

public final class AccessibilityNodeInfoCompat$TouchDelegateInfoCompat
{
  final AccessibilityNodeInfo.TouchDelegateInfo mInfo;
  
  AccessibilityNodeInfoCompat$TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo.TouchDelegateInfo paramTouchDelegateInfo)
  {
    this.mInfo = paramTouchDelegateInfo;
  }
  
  public AccessibilityNodeInfoCompat$TouchDelegateInfoCompat(@NonNull Map<Region, View> paramMap)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.mInfo = new AccessibilityNodeInfo.TouchDelegateInfo(paramMap);
      return;
    }
    this.mInfo = null;
  }
  
  @Nullable
  public Region getRegionAt(@IntRange(from=0L) int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return this.mInfo.getRegionAt(paramInt);
    }
    return null;
  }
  
  @IntRange(from=0L)
  public int getRegionCount()
  {
    if (Build.VERSION.SDK_INT >= 29) {
      return this.mInfo.getRegionCount();
    }
    return 0;
  }
  
  @Nullable
  public AccessibilityNodeInfoCompat getTargetForRegion(@NonNull Region paramRegion)
  {
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramRegion = this.mInfo.getTargetForRegion(paramRegion);
      if (paramRegion != null) {
        return AccessibilityNodeInfoCompat.wrap(paramRegion);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.accessibility.AccessibilityNodeInfoCompat.TouchDelegateInfoCompat
 * JD-Core Version:    0.7.0.1
 */
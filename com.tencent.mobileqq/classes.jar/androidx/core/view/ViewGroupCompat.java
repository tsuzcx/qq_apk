package androidx.core.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;

public final class ViewGroupCompat
{
  public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
  public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;
  
  public static int getLayoutMode(@NonNull ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramViewGroup.getLayoutMode();
    }
    return 0;
  }
  
  public static int getNestedScrollAxes(@NonNull ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramViewGroup.getNestedScrollAxes();
    }
    if ((paramViewGroup instanceof NestedScrollingParent)) {
      return ((NestedScrollingParent)paramViewGroup).getNestedScrollAxes();
    }
    return 0;
  }
  
  public static boolean isTransitionGroup(@NonNull ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramViewGroup.isTransitionGroup();
    }
    Boolean localBoolean = (Boolean)paramViewGroup.getTag(2131378437);
    return ((localBoolean != null) && (localBoolean.booleanValue())) || (paramViewGroup.getBackground() != null) || (ViewCompat.getTransitionName(paramViewGroup) != null);
  }
  
  @Deprecated
  public static boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return paramViewGroup.onRequestSendAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public static void setLayoutMode(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      paramViewGroup.setLayoutMode(paramInt);
    }
  }
  
  @Deprecated
  public static void setMotionEventSplittingEnabled(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    paramViewGroup.setMotionEventSplittingEnabled(paramBoolean);
  }
  
  public static void setTransitionGroup(@NonNull ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramViewGroup.setTransitionGroup(paramBoolean);
      return;
    }
    paramViewGroup.setTag(2131378437, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.view.ViewGroupCompat
 * JD-Core Version:    0.7.0.1
 */
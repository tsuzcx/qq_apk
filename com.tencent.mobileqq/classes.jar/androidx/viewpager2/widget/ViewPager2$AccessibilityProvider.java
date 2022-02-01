package androidx.viewpager2.widget;

import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

abstract class ViewPager2$AccessibilityProvider
{
  private ViewPager2$AccessibilityProvider(ViewPager2 paramViewPager2) {}
  
  boolean handlesGetAccessibilityClassName()
  {
    return false;
  }
  
  boolean handlesLmPerformAccessibilityAction(int paramInt)
  {
    return false;
  }
  
  boolean handlesPerformAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    return false;
  }
  
  boolean handlesRvGetAccessibilityClassName()
  {
    return false;
  }
  
  void onAttachAdapter(@Nullable RecyclerView.Adapter<?> paramAdapter) {}
  
  void onDetachAdapter(@Nullable RecyclerView.Adapter<?> paramAdapter) {}
  
  String onGetAccessibilityClassName()
  {
    throw new IllegalStateException("Not implemented.");
  }
  
  void onInitialize(@NonNull CompositeOnPageChangeCallback paramCompositeOnPageChangeCallback, @NonNull RecyclerView paramRecyclerView) {}
  
  void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo) {}
  
  void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
  
  boolean onLmPerformAccessibilityAction(int paramInt)
  {
    throw new IllegalStateException("Not implemented.");
  }
  
  boolean onPerformAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    throw new IllegalStateException("Not implemented.");
  }
  
  void onRestorePendingState() {}
  
  CharSequence onRvGetAccessibilityClassName()
  {
    throw new IllegalStateException("Not implemented.");
  }
  
  void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent paramAccessibilityEvent) {}
  
  void onSetLayoutDirection() {}
  
  void onSetNewCurrentItem() {}
  
  void onSetOrientation() {}
  
  void onSetUserInputEnabled() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.AccessibilityProvider
 * JD-Core Version:    0.7.0.1
 */
package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

public class RecyclerViewAccessibilityDelegate$ItemDelegate
  extends AccessibilityDelegateCompat
{
  private Map<View, AccessibilityDelegateCompat> mOriginalItemDelegates = new WeakHashMap();
  final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;
  
  public RecyclerViewAccessibilityDelegate$ItemDelegate(@NonNull RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate)
  {
    this.mRecyclerViewDelegate = paramRecyclerViewAccessibilityDelegate;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(@NonNull View paramView, @NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    AccessibilityDelegateCompat localAccessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(paramView);
    if (localAccessibilityDelegateCompat != null) {
      return localAccessibilityDelegateCompat.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    return super.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  @Nullable
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NonNull View paramView)
  {
    AccessibilityDelegateCompat localAccessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(paramView);
    if (localAccessibilityDelegateCompat != null) {
      return localAccessibilityDelegateCompat.getAccessibilityNodeProvider(paramView);
    }
    return super.getAccessibilityNodeProvider(paramView);
  }
  
  AccessibilityDelegateCompat getAndRemoveOriginalDelegateForItem(View paramView)
  {
    return (AccessibilityDelegateCompat)this.mOriginalItemDelegates.remove(paramView);
  }
  
  public void onInitializeAccessibilityEvent(@NonNull View paramView, @NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    AccessibilityDelegateCompat localAccessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(paramView);
    if (localAccessibilityDelegateCompat != null)
    {
      localAccessibilityDelegateCompat.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      return;
    }
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    if ((!this.mRecyclerViewDelegate.shouldIgnore()) && (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() != null))
    {
      this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      AccessibilityDelegateCompat localAccessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(paramView);
      if (localAccessibilityDelegateCompat != null)
      {
        localAccessibilityDelegateCompat.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
        return;
      }
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
  }
  
  public void onPopulateAccessibilityEvent(@NonNull View paramView, @NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    AccessibilityDelegateCompat localAccessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(paramView);
    if (localAccessibilityDelegateCompat != null)
    {
      localAccessibilityDelegateCompat.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      return;
    }
    super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(@NonNull ViewGroup paramViewGroup, @NonNull View paramView, @NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    AccessibilityDelegateCompat localAccessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(paramViewGroup);
    if (localAccessibilityDelegateCompat != null) {
      return localAccessibilityDelegateCompat.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    return super.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if ((!this.mRecyclerViewDelegate.shouldIgnore()) && (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() != null))
    {
      AccessibilityDelegateCompat localAccessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(paramView);
      if (localAccessibilityDelegateCompat != null)
      {
        if (localAccessibilityDelegateCompat.performAccessibilityAction(paramView, paramInt, paramBundle)) {
          return true;
        }
      }
      else if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(paramView, paramInt, paramBundle);
    }
    return super.performAccessibilityAction(paramView, paramInt, paramBundle);
  }
  
  void saveOriginalDelegate(View paramView)
  {
    AccessibilityDelegateCompat localAccessibilityDelegateCompat = ViewCompat.getAccessibilityDelegate(paramView);
    if ((localAccessibilityDelegateCompat != null) && (localAccessibilityDelegateCompat != this)) {
      this.mOriginalItemDelegates.put(paramView, localAccessibilityDelegateCompat);
    }
  }
  
  public void sendAccessibilityEvent(@NonNull View paramView, int paramInt)
  {
    AccessibilityDelegateCompat localAccessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(paramView);
    if (localAccessibilityDelegateCompat != null)
    {
      localAccessibilityDelegateCompat.sendAccessibilityEvent(paramView, paramInt);
      return;
    }
    super.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public void sendAccessibilityEventUnchecked(@NonNull View paramView, @NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    AccessibilityDelegateCompat localAccessibilityDelegateCompat = (AccessibilityDelegateCompat)this.mOriginalItemDelegates.get(paramView);
    if (localAccessibilityDelegateCompat != null)
    {
      localAccessibilityDelegateCompat.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
      return;
    }
    super.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate.ItemDelegate
 * JD-Core Version:    0.7.0.1
 */
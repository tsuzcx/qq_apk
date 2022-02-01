package androidx.viewpager2.widget;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.AdapterDataObserver;

class ViewPager2$PageAwareAccessibilityProvider
  extends ViewPager2.AccessibilityProvider
{
  private final AccessibilityViewCommand mActionPageBackward = new ViewPager2.PageAwareAccessibilityProvider.2(this);
  private final AccessibilityViewCommand mActionPageForward = new ViewPager2.PageAwareAccessibilityProvider.1(this);
  private RecyclerView.AdapterDataObserver mAdapterDataObserver;
  
  ViewPager2$PageAwareAccessibilityProvider(ViewPager2 paramViewPager2)
  {
    super(paramViewPager2, null);
  }
  
  private void addCollectionInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    int i;
    if (this.this$0.getAdapter() != null)
    {
      if (this.this$0.getOrientation() == 1)
      {
        i = this.this$0.getAdapter().getItemCount();
      }
      else
      {
        j = this.this$0.getAdapter().getItemCount();
        i = 0;
        break label55;
      }
    }
    else {
      i = 0;
    }
    int j = 0;
    label55:
    AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i, j, false, 0));
  }
  
  private void addScrollActions(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    RecyclerView.Adapter localAdapter = this.this$0.getAdapter();
    if (localAdapter == null) {
      return;
    }
    int i = localAdapter.getItemCount();
    if (i != 0)
    {
      if (!this.this$0.isUserInputEnabled()) {
        return;
      }
      if (this.this$0.mCurrentItem > 0) {
        paramAccessibilityNodeInfo.addAction(8192);
      }
      if (this.this$0.mCurrentItem < i - 1) {
        paramAccessibilityNodeInfo.addAction(4096);
      }
      paramAccessibilityNodeInfo.setScrollable(true);
    }
  }
  
  public boolean handlesGetAccessibilityClassName()
  {
    return true;
  }
  
  public boolean handlesPerformAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    return (paramInt == 8192) || (paramInt == 4096);
  }
  
  public void onAttachAdapter(@Nullable RecyclerView.Adapter<?> paramAdapter)
  {
    updatePageAccessibilityActions();
    if (paramAdapter != null) {
      paramAdapter.registerAdapterDataObserver(this.mAdapterDataObserver);
    }
  }
  
  public void onDetachAdapter(@Nullable RecyclerView.Adapter<?> paramAdapter)
  {
    if (paramAdapter != null) {
      paramAdapter.unregisterAdapterDataObserver(this.mAdapterDataObserver);
    }
  }
  
  public String onGetAccessibilityClassName()
  {
    if (handlesGetAccessibilityClassName()) {
      return "androidx.viewpager.widget.ViewPager";
    }
    throw new IllegalStateException();
  }
  
  public void onInitialize(@NonNull CompositeOnPageChangeCallback paramCompositeOnPageChangeCallback, @NonNull RecyclerView paramRecyclerView)
  {
    ViewCompat.setImportantForAccessibility(paramRecyclerView, 2);
    this.mAdapterDataObserver = new ViewPager2.PageAwareAccessibilityProvider.3(this);
    if (ViewCompat.getImportantForAccessibility(this.this$0) == 0) {
      ViewCompat.setImportantForAccessibility(this.this$0, 1);
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    addCollectionInfo(paramAccessibilityNodeInfo);
    if (Build.VERSION.SDK_INT >= 16) {
      addScrollActions(paramAccessibilityNodeInfo);
    }
  }
  
  public boolean onPerformAccessibilityAction(int paramInt, Bundle paramBundle)
  {
    if (handlesPerformAccessibilityAction(paramInt, paramBundle))
    {
      if (paramInt == 8192) {
        paramInt = this.this$0.getCurrentItem() - 1;
      } else {
        paramInt = this.this$0.getCurrentItem() + 1;
      }
      setCurrentItemFromAccessibilityCommand(paramInt);
      return true;
    }
    throw new IllegalStateException();
  }
  
  public void onRestorePendingState()
  {
    updatePageAccessibilityActions();
  }
  
  public void onRvInitializeAccessibilityEvent(@NonNull AccessibilityEvent paramAccessibilityEvent)
  {
    paramAccessibilityEvent.setSource(this.this$0);
    paramAccessibilityEvent.setClassName(onGetAccessibilityClassName());
  }
  
  public void onSetLayoutDirection()
  {
    updatePageAccessibilityActions();
  }
  
  public void onSetNewCurrentItem()
  {
    updatePageAccessibilityActions();
  }
  
  public void onSetOrientation()
  {
    updatePageAccessibilityActions();
  }
  
  public void onSetUserInputEnabled()
  {
    updatePageAccessibilityActions();
    if (Build.VERSION.SDK_INT < 21) {
      this.this$0.sendAccessibilityEvent(2048);
    }
  }
  
  void setCurrentItemFromAccessibilityCommand(int paramInt)
  {
    if (this.this$0.isUserInputEnabled()) {
      this.this$0.setCurrentItemInternal(paramInt, true);
    }
  }
  
  void updatePageAccessibilityActions()
  {
    ViewPager2 localViewPager2 = this.this$0;
    int j = 16908360;
    ViewCompat.removeAccessibilityAction(localViewPager2, 16908360);
    ViewCompat.removeAccessibilityAction(localViewPager2, 16908361);
    ViewCompat.removeAccessibilityAction(localViewPager2, 16908358);
    ViewCompat.removeAccessibilityAction(localViewPager2, 16908359);
    if (this.this$0.getAdapter() == null) {
      return;
    }
    int k = this.this$0.getAdapter().getItemCount();
    if (k == 0) {
      return;
    }
    if (!this.this$0.isUserInputEnabled()) {
      return;
    }
    if (this.this$0.getOrientation() == 0)
    {
      boolean bool = this.this$0.isRtl();
      int i;
      if (bool) {
        i = 16908360;
      } else {
        i = 16908361;
      }
      if (bool) {
        j = 16908361;
      }
      if (this.this$0.mCurrentItem < k - 1) {
        ViewCompat.replaceAccessibilityAction(localViewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i, null), null, this.mActionPageForward);
      }
      if (this.this$0.mCurrentItem > 0) {
        ViewCompat.replaceAccessibilityAction(localViewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(j, null), null, this.mActionPageBackward);
      }
    }
    else
    {
      if (this.this$0.mCurrentItem < k - 1) {
        ViewCompat.replaceAccessibilityAction(localViewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, null), null, this.mActionPageForward);
      }
      if (this.this$0.mCurrentItem > 0) {
        ViewCompat.replaceAccessibilityAction(localViewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, null), null, this.mActionPageBackward);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider
 * JD-Core Version:    0.7.0.1
 */
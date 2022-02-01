package com.google.android.material.internal;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

class NavigationMenuPresenter$NavigationMenuViewAccessibilityDelegate
  extends RecyclerViewAccessibilityDelegate
{
  NavigationMenuPresenter$NavigationMenuViewAccessibilityDelegate(NavigationMenuPresenter paramNavigationMenuPresenter, @NonNull RecyclerView paramRecyclerView)
  {
    super(paramRecyclerView);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(this.a.c.d(), 0, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuViewAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */
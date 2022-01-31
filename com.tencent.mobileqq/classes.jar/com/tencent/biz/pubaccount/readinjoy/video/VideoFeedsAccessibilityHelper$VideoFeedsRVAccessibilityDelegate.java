package com.tencent.biz.pubaccount.readinjoy.video;

import ajyc;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class VideoFeedsAccessibilityHelper$VideoFeedsRVAccessibilityDelegate
  extends RecyclerViewAccessibilityDelegate
{
  public VideoFeedsAccessibilityHelper$VideoFeedsRVAccessibilityDelegate(RecyclerView paramRecyclerView)
  {
    super(paramRecyclerView);
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    AccessibilityEventCompat.asRecord(paramAccessibilityEvent).setItemCount(0);
    paramView.setContentDescription(ajyc.a(2131716185));
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setScrollable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAccessibilityHelper.VideoFeedsRVAccessibilityDelegate
 * JD-Core Version:    0.7.0.1
 */
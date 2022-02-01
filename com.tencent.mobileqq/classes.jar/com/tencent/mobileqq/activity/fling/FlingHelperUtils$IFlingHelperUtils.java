package com.tencent.mobileqq.activity.fling;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.View;

abstract interface FlingHelperUtils$IFlingHelperUtils
{
  public abstract boolean isDragFrameLayoutClass(View paramView);
  
  public abstract boolean isInTwoFingerMode(GestureDetector paramGestureDetector);
  
  public abstract GestureDetector newStickerDismissGestureDetectorInstance(TopGestureLayout paramTopGestureLayout, Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.fling.FlingHelperUtils.IFlingHelperUtils
 * JD-Core Version:    0.7.0.1
 */
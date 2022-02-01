package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Canvas;

public abstract interface HippyTKDRefreshAnimation
{
  public abstract void animateRefresh();
  
  public abstract void draw(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void onSkinChange();
  
  public abstract void setInvalidateCallback(HippyTKDInvalidateCallback paramHippyTKDInvalidateCallback);
  
  public abstract void stopAllAnimators();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshAnimation
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.recent;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

public class DrawerFrame$ContentViewOutlineProvider
  extends ViewOutlineProvider
{
  private float a;
  
  public void a(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(new Rect(0, 0, paramView.getWidth(), paramView.getHeight()), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.DrawerFrame.ContentViewOutlineProvider
 * JD-Core Version:    0.7.0.1
 */
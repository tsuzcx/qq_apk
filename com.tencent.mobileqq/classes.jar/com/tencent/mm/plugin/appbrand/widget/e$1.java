package com.tencent.mm.plugin.appbrand.widget;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;

class e$1
  extends ViewOutlineProvider
{
  e$1(e parame) {}
  
  public void getOutline(View paramView, Outline paramOutline)
  {
    paramOutline.setRoundRect(new Rect(0, 0, paramView.getWidth(), paramView.getHeight()), e.g());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.e.1
 * JD-Core Version:    0.7.0.1
 */
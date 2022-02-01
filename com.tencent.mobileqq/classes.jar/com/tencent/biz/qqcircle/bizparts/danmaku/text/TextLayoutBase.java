package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.view.View;

public abstract interface TextLayoutBase
{
  public abstract void a(TextCell paramTextCell);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract boolean d();
  
  public abstract View getAttachedView();
  
  public abstract void invalidate();
  
  public abstract boolean isPressed();
  
  public abstract void postInvalidate();
  
  public abstract void requestLayout();
  
  public abstract void setLongClickTrig(boolean paramBoolean);
  
  public abstract void setPressed(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextLayoutBase
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqstory.utils;

import android.view.View;
import android.view.View.OnClickListener;

public abstract class PollWidgetUtils$WidgetElement
{
  private View.OnClickListener a = new PollWidgetUtils.WidgetElement.1(this);
  PollWidgetUtils.WidgetWrapper i;
  View j;
  PollWidgetUtils.OnWidgetElementClickListener k;
  PollWidgetUtils.OnSelectedChangedListener l;
  boolean m = false;
  
  public PollWidgetUtils$WidgetElement(PollWidgetUtils.WidgetWrapper paramWidgetWrapper, View paramView)
  {
    this.i = paramWidgetWrapper;
    this.j = paramView;
  }
  
  public void a(float paramFloat) {}
  
  void a(PollWidgetUtils.OnSelectedChangedListener paramOnSelectedChangedListener)
  {
    this.l = paramOnSelectedChangedListener;
  }
  
  public void a(CharSequence paramCharSequence) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.m != paramBoolean)
    {
      this.m = paramBoolean;
      PollWidgetUtils.OnSelectedChangedListener localOnSelectedChangedListener = this.l;
      if (localOnSelectedChangedListener != null) {
        localOnSelectedChangedListener.a(this, paramBoolean);
      }
    }
  }
  
  public boolean b()
  {
    return this.m;
  }
  
  public void c(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetElement
 * JD-Core Version:    0.7.0.1
 */
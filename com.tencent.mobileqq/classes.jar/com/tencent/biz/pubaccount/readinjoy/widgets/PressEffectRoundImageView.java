package com.tencent.biz.pubaccount.readinjoy.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import besu;
import com.tencent.mobileqq.widget.RoundImageView;

public class PressEffectRoundImageView
  extends RoundImageView
{
  private boolean b;
  
  public PressEffectRoundImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isClickable()) || (!isEnabled()) || (this.b)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      besu.a(this);
      super.onTouchEvent(paramMotionEvent);
      return true;
      besu.b(this);
    }
  }
  
  public void setDisableEffect(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.widgets.PressEffectRoundImageView
 * JD-Core Version:    0.7.0.1
 */
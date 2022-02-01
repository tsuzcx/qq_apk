package com.tencent.biz.pubaccount.readinjoy.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import bivv;
import com.tencent.mobileqq.widget.RoundImageView;

public class PressEffectRoundImageView
  extends RoundImageView
{
  private boolean a;
  
  public PressEffectRoundImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isClickable()) || (!isEnabled()) || (this.a)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      bivv.a(this);
      super.onTouchEvent(paramMotionEvent);
      return true;
      bivv.b(this);
    }
  }
  
  public void setDisableEffect(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.widgets.PressEffectRoundImageView
 * JD-Core Version:    0.7.0.1
 */
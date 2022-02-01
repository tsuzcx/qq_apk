package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class PressScaleTextView
  extends TextView
{
  private final PressScaleAnimDelegate a = new PressScaleAnimDelegate(this);
  
  public PressScaleTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PressScaleTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PressScaleTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a.a())
    {
      paramCanvas.save();
      this.a.a(paramCanvas);
    }
    super.onDraw(paramCanvas);
    if (this.a.a()) {
      paramCanvas.restore();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i == 1) {}
    }
    else {
      this.a.b();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.PressScaleTextView
 * JD-Core Version:    0.7.0.1
 */
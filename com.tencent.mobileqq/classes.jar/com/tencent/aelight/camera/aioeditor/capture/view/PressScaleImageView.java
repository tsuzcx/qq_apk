package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class PressScaleImageView
  extends ImageView
{
  public boolean a = true;
  private final PressScaleAnimDelegate b = new PressScaleAnimDelegate(this);
  
  public PressScaleImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PressScaleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PressScaleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.b.a())
    {
      paramCanvas.save();
      this.b.a(paramCanvas);
    }
    super.onDraw(paramCanvas);
    if (this.b.a()) {
      paramCanvas.restore();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0 ? i != 1 : this.a) {
      this.b.b();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.PressScaleImageView
 * JD-Core Version:    0.7.0.1
 */
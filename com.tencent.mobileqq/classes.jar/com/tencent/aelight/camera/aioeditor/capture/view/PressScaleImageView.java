package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class PressScaleImageView
  extends ImageView
{
  private final PressScaleAnimDelegate a;
  public boolean a;
  
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
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewPressScaleAnimDelegate = new PressScaleAnimDelegate(this);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewPressScaleAnimDelegate.a())
    {
      paramCanvas.save();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewPressScaleAnimDelegate.a(paramCanvas);
    }
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewPressScaleAnimDelegate.a()) {
      paramCanvas.restore();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i != 0 ? i != 1 : this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewPressScaleAnimDelegate.a();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.PressScaleImageView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class EditTextPreView
  extends ImageView
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private DynamicTextItem jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem = null;
  private EditTextPreView.OnClickListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView$OnClickListener;
  
  public EditTextPreView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public EditTextPreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public EditTextPreView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    setScaleType(ImageView.ScaleType.CENTER);
    setClickable(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.translate(paramCanvas.getWidth() / 2, paramCanvas.getHeight() / 2);
    DynamicTextItem localDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    if (localDynamicTextItem != null) {
      localDynamicTextItem.b(paramCanvas);
    }
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isEnabled()) && (isClickable()))
    {
      int i = paramMotionEvent.getAction();
      if (i != 0) {
        if (i != 1)
        {
          if (i != 2) {
            break label137;
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView$OnClickListener == null) {
            break label137;
          }
          DynamicTextItem localDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
          if (localDynamicTextItem == null) {
            break label137;
          }
          i = localDynamicTextItem.a(paramMotionEvent, getWidth(), getHeight(), null, null);
          if (i > -1)
          {
            setText(i, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a(i));
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a(i, true);
            paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
            paramMotionEvent.a(i, paramMotionEvent.a(i));
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.b(i);
          }
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView$OnClickListener.a(this, this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem, i);
        }
      }
      return true;
    }
    label137:
    return super.onTouchEvent(paramMotionEvent);
  }
  
  @Deprecated
  public void setOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    throw new UnsupportedOperationException("unSupport normal click listener, use EditTextPreView.OnClickListener instead");
  }
  
  public void setOnClickListener(@Nullable EditTextPreView.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextEditTextPreView$OnClickListener = paramOnClickListener;
  }
  
  public void setPreViewDrawer(DynamicTextItem paramDynamicTextItem)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem = paramDynamicTextItem;
    invalidate();
  }
  
  public void setText(int paramInt, String paramString)
  {
    DynamicTextItem localDynamicTextItem = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem;
    if ((localDynamicTextItem != null) && (!paramString.equals(localDynamicTextItem.a(paramInt))))
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a(paramInt, paramString);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureTextDynamicTextItem.a(false);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.EditTextPreView
 * JD-Core Version:    0.7.0.1
 */
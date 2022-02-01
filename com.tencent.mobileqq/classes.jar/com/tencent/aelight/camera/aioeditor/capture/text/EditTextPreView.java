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
  private DynamicTextItem a = null;
  private Paint b;
  private EditTextPreView.OnClickListener c;
  
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
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setDither(true);
    this.b.setFilterBitmap(true);
    setScaleType(ImageView.ScaleType.CENTER);
    setClickable(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    paramCanvas.translate(paramCanvas.getWidth() / 2, paramCanvas.getHeight() / 2);
    DynamicTextItem localDynamicTextItem = this.a;
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
          if (this.c == null) {
            break label137;
          }
          DynamicTextItem localDynamicTextItem = this.a;
          if (localDynamicTextItem == null) {
            break label137;
          }
          i = localDynamicTextItem.a(paramMotionEvent, getWidth(), getHeight(), null, null);
          if (i > -1)
          {
            setText(i, this.a.b(i));
            this.a.a(i, true);
            paramMotionEvent = this.a;
            paramMotionEvent.a(i, paramMotionEvent.b(i));
            this.a.e(i);
          }
          this.c.a(this, this.a, i);
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
    this.c = paramOnClickListener;
  }
  
  public void setPreViewDrawer(DynamicTextItem paramDynamicTextItem)
  {
    this.a = paramDynamicTextItem;
    invalidate();
  }
  
  public void setText(int paramInt, String paramString)
  {
    DynamicTextItem localDynamicTextItem = this.a;
    if ((localDynamicTextItem != null) && (!paramString.equals(localDynamicTextItem.b(paramInt))))
    {
      this.a.a(paramInt, paramString);
      this.a.a(false);
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.EditTextPreView
 * JD-Core Version:    0.7.0.1
 */
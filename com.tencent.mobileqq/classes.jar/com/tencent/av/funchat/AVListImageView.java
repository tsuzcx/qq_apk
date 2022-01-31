package com.tencent.av.funchat;

import aepi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.image.URLDrawable;
import mwj;

public class AVListImageView
  extends ImageView
{
  private int jdField_a_of_type_Int = 3;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 3;
  private boolean jdField_b_of_type_Boolean;
  private int c = -15550475;
  
  public AVListImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AVListImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AVListImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = aepi.a(this.jdField_a_of_type_Int, getResources()) - 2;
    int n = aepi.a(this.jdField_b_of_type_Int, getResources());
    int i = Math.min(getWidth(), getHeight()) / 2;
    int j = getWidth() / 2;
    int k = getHeight() / 2;
    paramCanvas.drawARGB(0, 0, 0, 0);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        if (!(localDrawable instanceof mwj)) {
          localDrawable.setColorFilter(-10591367, PorterDuff.Mode.MULTIPLY);
        }
        localDrawable.setBounds(m, m, getWidth() - m, getHeight() - m);
        localDrawable.draw(paramCanvas);
      }
    }
    else if ((this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.reset();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(n);
      m = (n + 1) / 2;
      if ((getParent() == null) || (!(getParent().getParent() instanceof LinearLayout))) {
        break label299;
      }
      i = Math.min(((LinearLayout)getParent().getParent()).getWidth() / 2, i);
    }
    label299:
    for (;;)
    {
      paramCanvas.drawCircle(j, k, i - m, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      if ((localDrawable instanceof URLDrawable))
      {
        localDrawable.setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
        break;
      }
      if ((localDrawable instanceof mwj)) {
        break;
      }
      localDrawable.clearColorFilter();
      break;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0) {
      setAlpha(0.5F);
    }
    while ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
      return true;
    }
    setAlpha(1.0F);
    return true;
  }
  
  public void setDimmed(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setDimmedColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.funchat.AVListImageView
 * JD-Core Version:    0.7.0.1
 */
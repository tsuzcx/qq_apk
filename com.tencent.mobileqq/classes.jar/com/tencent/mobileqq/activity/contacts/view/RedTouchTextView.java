package com.tencent.mobileqq.activity.contacts.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import bdoo;

public class RedTouchTextView
  extends TextView
{
  Paint a;
  
  public RedTouchTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RedTouchTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RedTouchTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    if (this.a == null)
    {
      this.a = new Paint();
      this.a.setStyle(Paint.Style.FILL);
      this.a.setStyle(Paint.Style.FILL_AND_STROKE);
      this.a.setColor(-65536);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    paramInt2 = getMeasuredHeight();
    setMeasuredDimension(paramInt1 + bdoo.a(10.0F), paramInt2 + bdoo.a(10.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.RedTouchTextView
 * JD-Core Version:    0.7.0.1
 */
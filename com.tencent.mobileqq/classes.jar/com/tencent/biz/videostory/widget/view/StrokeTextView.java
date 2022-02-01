package com.tencent.biz.videostory.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

public class StrokeTextView
  extends TextView
{
  private TextView a = null;
  
  public StrokeTextView(Context paramContext)
  {
    super(paramContext);
    this.a = new TextView(paramContext);
    a();
  }
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new TextView(paramContext, paramAttributeSet);
    a();
  }
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new TextView(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public void a()
  {
    TextPaint localTextPaint = this.a.getPaint();
    localTextPaint.setStrokeWidth(3.0F);
    localTextPaint.setStyle(Paint.Style.STROKE);
    this.a.setTextColor(Color.parseColor("#000000"));
    this.a.setGravity(getGravity());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.a.draw(paramCanvas);
    super.onDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    CharSequence localCharSequence = this.a.getText();
    if ((localCharSequence == null) || (!localCharSequence.equals(getText())))
    {
      this.a.setText(getText());
      postInvalidate();
    }
    this.a.measure(paramInt1, paramInt2);
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setLayoutParams(paramLayoutParams);
    this.a.setLayoutParams(paramLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.StrokeTextView
 * JD-Core Version:    0.7.0.1
 */
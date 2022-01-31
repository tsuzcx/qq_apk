package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.reflect.Field;

public class StrokeTextView
  extends TextView
{
  protected int a;
  protected TextPaint a;
  protected boolean a;
  protected int b = -16777216;
  
  public StrokeTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidTextTextPaint = getPaint();
    this.jdField_a_of_type_Int = -1;
  }
  
  private void a(int paramInt)
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mCurTextColor");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      localField.setAccessible(false);
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(paramInt);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        localNoSuchFieldException.printStackTrace();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(this.b);
      this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(1.0F);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidTextTextPaint.setFakeBoldText(true);
      super.onDraw(paramCanvas);
      a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.setStrokeWidth(0.0F);
      this.jdField_a_of_type_AndroidTextTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      this.jdField_a_of_type_AndroidTextTextPaint.setFakeBoldText(false);
      this.jdField_a_of_type_AndroidTextTextPaint.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.b = paramInt;
    super.invalidate();
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    super.setTextColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StrokeTextView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.view.widget.ticker;

import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import java.util.HashMap;
import java.util.Map;

class TickerDrawMetrics
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Map<Character, Float> jdField_a_of_type_JavaUtilMap = new HashMap(256);
  private float b;
  
  TickerDrawMetrics(Paint paramPaint)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = paramPaint;
    a();
  }
  
  float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  float a(char paramChar)
  {
    if (paramChar == 0) {
      return 0.0F;
    }
    Float localFloat = (Float)this.jdField_a_of_type_JavaUtilMap.get(Character.valueOf(paramChar));
    if (localFloat != null) {
      return localFloat.floatValue();
    }
    float f = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(Character.toString(paramChar));
    this.jdField_a_of_type_JavaUtilMap.put(Character.valueOf(paramChar), Float.valueOf(f));
    return f;
  }
  
  int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    Paint.FontMetrics localFontMetrics = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetrics();
    this.jdField_a_of_type_Float = (localFontMetrics.bottom - localFontMetrics.top);
    this.b = (-localFontMetrics.top);
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  float b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerDrawMetrics
 * JD-Core Version:    0.7.0.1
 */
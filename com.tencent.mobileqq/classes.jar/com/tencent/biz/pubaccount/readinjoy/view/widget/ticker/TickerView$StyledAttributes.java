package com.tencent.biz.pubaccount.readinjoy.view.widget.ticker;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.TypedValue;

class TickerView$StyledAttributes
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int = -16777216;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  
  TickerView$StyledAttributes(TickerView paramTickerView, Resources paramResources)
  {
    this.jdField_d_of_type_Float = TypedValue.applyDimension(2, 12.0F, paramResources.getDisplayMetrics());
    this.jdField_a_of_type_Int = 8388611;
  }
  
  void a(TypedArray paramTypedArray)
  {
    this.jdField_a_of_type_Int = paramTypedArray.getInt(4, this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = paramTypedArray.getColor(6, this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Float = paramTypedArray.getFloat(7, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Float = paramTypedArray.getFloat(8, this.jdField_b_of_type_Float);
    this.jdField_c_of_type_Float = paramTypedArray.getFloat(9, this.jdField_c_of_type_Float);
    this.jdField_a_of_type_JavaLangString = paramTypedArray.getString(5);
    this.jdField_c_of_type_Int = paramTypedArray.getColor(3, this.jdField_c_of_type_Int);
    this.jdField_d_of_type_Float = paramTypedArray.getDimension(1, this.jdField_d_of_type_Float);
    this.jdField_d_of_type_Int = paramTypedArray.getInt(2, this.jdField_d_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView.StyledAttributes
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class PoiMapActivity$TabView
  extends RelativeLayout
{
  public int a;
  public View a;
  public TextView a;
  public String a;
  public View b;
  
  public PoiMapActivity$TabView(PoiMapActivity paramPoiMapActivity, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(16.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramPoiMapActivity.jdField_a_of_type_Int);
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(13, -1);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, paramString);
    this.jdField_a_of_type_AndroidViewView = new View(paramContext);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramPoiMapActivity.g);
    paramString = new RelativeLayout.LayoutParams(-2, (int)(3.0F * paramPoiMapActivity.jdField_a_of_type_Float));
    paramString.addRule(12, -1);
    paramInt = paramContext.getResources().getDimensionPixelSize(2131297454);
    paramString.rightMargin = paramInt;
    paramString.leftMargin = paramInt;
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    addView(this.jdField_a_of_type_AndroidViewView, paramString);
    this.b = new View(paramContext);
    this.b.setBackgroundDrawable(null);
    this.b.setBackgroundResource(paramPoiMapActivity.f);
    paramContext = new RelativeLayout.LayoutParams((int)(2.0F * paramPoiMapActivity.jdField_a_of_type_Float), (int)(20.0F * paramPoiMapActivity.jdField_a_of_type_Float));
    paramContext.addRule(15, -1);
    paramContext.addRule(11, -1);
    addView(this.b, paramContext);
    setOnClickListener(paramPoiMapActivity.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  public void a()
  {
    this.b.setVisibility(4);
  }
  
  public void setSelect(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.b);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizPoiMapActivity.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.TabView
 * JD-Core Version:    0.7.0.1
 */
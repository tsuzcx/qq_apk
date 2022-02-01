package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import tqx;
import tqy;

public class ReadInJoySelectPositionHeader
  extends RelativeLayout
{
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private tqy jdField_a_of_type_Tqy;
  private TextView b;
  
  public ReadInJoySelectPositionHeader(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ReadInJoySelectPositionHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ReadInJoySelectPositionHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131560317, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377327));
    this.b = ((TextView)localView.findViewById(2131367802));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131367803));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new tqx(this, paramContext));
  }
  
  public void setGPSCity(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setSelectCityListener(tqy paramtqy)
  {
    this.jdField_a_of_type_Tqy = paramtqy;
  }
  
  public void setSelectedCity(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoySelectPositionHeader
 * JD-Core Version:    0.7.0.1
 */
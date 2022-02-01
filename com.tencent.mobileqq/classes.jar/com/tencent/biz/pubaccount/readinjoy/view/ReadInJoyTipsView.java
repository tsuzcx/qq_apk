package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ReadInJoyTipsView
  extends LinearLayout
{
  public int a;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageView b;
  
  public ReadInJoyTipsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    inflate(paramContext, 2131560408, this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376627));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376630));
    this.b = ((ImageView)findViewById(2131376629));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376628));
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyTipsView
 * JD-Core Version:    0.7.0.1
 */
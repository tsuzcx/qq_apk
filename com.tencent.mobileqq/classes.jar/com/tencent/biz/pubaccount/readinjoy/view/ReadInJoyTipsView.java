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
    inflate(paramContext, 2131560032, this);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374840));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374843));
    this.b = ((ImageView)findViewById(2131374842));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131374841));
  }
  
  protected void onFinishInflate()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyTipsView
 * JD-Core Version:    0.7.0.1
 */
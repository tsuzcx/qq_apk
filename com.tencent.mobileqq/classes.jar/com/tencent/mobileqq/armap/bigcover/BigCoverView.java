package com.tencent.mobileqq.armap.bigcover;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BigCoverView
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private TextView b;
  
  public BigCoverView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public BigCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970206, this);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131365227);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131369573));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramContext.findViewById(2131369569));
    this.b = ((TextView)paramContext.findViewById(2131369572));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.bigcover.BigCoverView
 * JD-Core Version:    0.7.0.1
 */
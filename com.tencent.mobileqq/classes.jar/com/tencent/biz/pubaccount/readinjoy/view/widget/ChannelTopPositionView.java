package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class ChannelTopPositionView
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ChannelTopPositionView.1(this);
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  
  public ChannelTopPositionView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public ChannelTopPositionView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560101, this, true);
    b();
    c();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373385));
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ChannelTopPositionView
 * JD-Core Version:    0.7.0.1
 */
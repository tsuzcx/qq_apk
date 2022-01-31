package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import ajyc;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import qxw;

public class MultiVideoLoadingFooter
  extends FrameLayout
{
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public MultiVideoLoadingFooter(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131560060, this);
    addOnLayoutChangeListener(new qxw(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369501));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369510));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131369507));
    a(1);
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return ajyc.a(2131716245);
    }
    if (paramInt == 2) {
      return ajyc.a(2131716242);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(a(1));
    }
    while (paramInt != 2) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(a(2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoLoadingFooter
 * JD-Core Version:    0.7.0.1
 */
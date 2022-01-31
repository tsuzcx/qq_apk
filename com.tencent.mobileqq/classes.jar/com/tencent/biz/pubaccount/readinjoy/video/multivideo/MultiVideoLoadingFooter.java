package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import alud;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import rni;

public class MultiVideoLoadingFooter
  extends FrameLayout
{
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public MultiVideoLoadingFooter(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131560160, this);
    addOnLayoutChangeListener(new rni(this));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131369781));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369790));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131369787));
    a(1);
  }
  
  private String a(int paramInt)
  {
    if (paramInt == 1) {
      return alud.a(2131716640);
    }
    if (paramInt == 2) {
      return alud.a(2131716637);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoLoadingFooter
 * JD-Core Version:    0.7.0.1
 */
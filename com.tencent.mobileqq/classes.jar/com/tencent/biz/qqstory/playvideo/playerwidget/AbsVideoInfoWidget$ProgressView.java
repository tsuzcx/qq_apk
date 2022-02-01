package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AbsVideoInfoWidget$ProgressView
  extends FrameLayout
{
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  
  public AbsVideoInfoWidget$ProgressView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AbsVideoInfoWidget$ProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131562006, this);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131373545));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379091));
  }
  
  public void setProgressText(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (paramCharSequence.length() <= 0))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.AbsVideoInfoWidget.ProgressView
 * JD-Core Version:    0.7.0.1
 */
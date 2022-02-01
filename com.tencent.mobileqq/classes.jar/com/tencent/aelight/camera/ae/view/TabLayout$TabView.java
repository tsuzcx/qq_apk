package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

class TabLayout$TabView
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private int b;
  private int c;
  private int d;
  
  public TabLayout$TabView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AECircleCaptureStyle localAECircleCaptureStyle;
    if (!paramBoolean) {
      localAECircleCaptureStyle = AECircleCaptureStyle.a;
    } else {
      localAECircleCaptureStyle = AECircleCaptureStyle.e;
    }
    this.jdField_a_of_type_Int = localAECircleCaptureStyle.t;
    if (!paramBoolean) {
      localAECircleCaptureStyle = AECircleCaptureStyle.a;
    } else {
      localAECircleCaptureStyle = AECircleCaptureStyle.e;
    }
    this.b = localAECircleCaptureStyle.s;
    if (!paramBoolean) {
      localAECircleCaptureStyle = AECircleCaptureStyle.b;
    } else {
      localAECircleCaptureStyle = AECircleCaptureStyle.f;
    }
    this.c = localAECircleCaptureStyle.t;
    if (!paramBoolean) {
      localAECircleCaptureStyle = AECircleCaptureStyle.b;
    } else {
      localAECircleCaptureStyle = AECircleCaptureStyle.f;
    }
    this.d = localAECircleCaptureStyle.s;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(paramContext);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 15.0F);
    addView(this.jdField_a_of_type_AndroidWidgetTextView);
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView;
    int i;
    if (!paramBoolean2)
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramBoolean1) {
        i = this.b;
      } else {
        i = this.jdField_a_of_type_Int;
      }
      localTextView.setTextColor(i);
    }
    else
    {
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramBoolean1) {
        i = this.d;
      } else {
        i = this.c;
      }
      localTextView.setTextColor(i);
    }
    if (paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(1.0F, 0.0F, 0.0F, 2131165336);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.TabLayout.TabView
 * JD-Core Version:    0.7.0.1
 */
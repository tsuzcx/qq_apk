package com.tencent.aelight.camera.aebase.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

public class QIMCameraCountTimeLayout
  extends LinearLayout
{
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private boolean jdField_a_of_type_Boolean;
  
  public QIMCameraCountTimeLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QIMCameraCountTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QIMCameraCountTimeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOrientation(0);
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130844503);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.a(6.0F), ViewUtils.a(6.0F));
    localLayoutParams.gravity = 16;
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setText("0秒");
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setShadowLayer(2.0F, 0.0F, 0.0F, 2131165338);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167394));
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = ViewUtils.a(4.0F);
    addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  public void setDotView(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setBackgroundResource(paramInt);
  }
  
  public void setIsCircleStyle(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
  
  public void setTextShadow(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      localTextView.setShadowLayer(2.0F, 0.0F, 0.0F, 2131165338);
      return;
    }
    localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0)
    {
      Animation localAnimation;
      if (!this.jdField_a_of_type_Boolean) {
        localAnimation = AnimationUtils.loadAnimation(getContext(), 2063663114);
      } else {
        localAnimation = AnimationUtils.loadAnimation(getContext(), 2063663104);
      }
      this.jdField_a_of_type_AndroidViewView.startAnimation(localAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraCountTimeLayout
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class SettingMeRelativeLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private float b;
  
  public SettingMeRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SettingMeRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(14)
  public void a()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null)
      {
        ((View)localObject).setTranslationX(super.getTranslationX() * this.jdField_a_of_type_Float + this.b);
        localObject = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localObject != null) {
          ((ImageView)localObject).setTranslationX(super.getTranslationX() * this.jdField_a_of_type_Float);
        }
      }
    }
  }
  
  public void setSurfaceView(View paramView, ImageView paramImageView, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
  }
  
  @TargetApi(14)
  public void setTranslationX(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.setTranslationX(paramFloat);
      Object localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setTranslationX(this.jdField_a_of_type_Float * paramFloat + this.b);
      }
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null) {
        ((ImageView)localObject).setTranslationX(paramFloat * this.jdField_a_of_type_Float);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingMeRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
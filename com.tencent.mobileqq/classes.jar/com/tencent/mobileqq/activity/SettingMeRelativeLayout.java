package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.apollo.ApolloTextureView;

public class SettingMeRelativeLayout
  extends RelativeLayout
{
  private float jdField_a_of_type_Float = 1.0F;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ApolloTextureView jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView;
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
    if ((Build.VERSION.SDK_INT >= 11) && (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setTranslationX(super.getTranslationX() * this.jdField_a_of_type_Float + this.b);
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(super.getTranslationX() * this.jdField_a_of_type_Float);
      }
    }
  }
  
  public void setSurfaceView(ApolloTextureView paramApolloTextureView, ImageView paramImageView, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = paramApolloTextureView;
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
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setTranslationX(this.jdField_a_of_type_Float * paramFloat + this.b);
      }
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setTranslationX(this.jdField_a_of_type_Float * paramFloat);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SettingMeRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
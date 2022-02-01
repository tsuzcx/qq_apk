package com.tencent.av.tips;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

class AvTipsView$MainTips
  extends AvTipsView.BaseTips
{
  View jdField_a_of_type_AndroidViewView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  AvTipsView$MainTips(LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLinearLayout.findViewById(2131373623));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131373620));
    this.jdField_a_of_type_AndroidViewView = paramLinearLayout.findViewById(2131373624);
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLinearLayout.findViewById(2131373626));
  }
  
  Resources a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView.getResources();
  }
  
  void a()
  {
    if (!a()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null)
    {
      ((ImageView)localObject).setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(4);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localObject != null) {
      ((ProgressBar)localObject).setVisibility(8);
    }
  }
  
  boolean a()
  {
    return (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null);
  }
  
  boolean a(AvTipsView.TipsInfo paramTipsInfo)
  {
    a();
    Object localObject;
    if ((paramTipsInfo.b) && (paramTipsInfo.jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      localObject = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localObject != null)
      {
        ((ImageView)localObject).setImageBitmap(paramTipsInfo.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
    }
    if (paramTipsInfo.c)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (localObject != null) {
        ((ProgressBar)localObject).setVisibility(0);
      }
    }
    if (paramTipsInfo.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
    }
    if (paramTipsInfo.jdField_a_of_type_AndroidTextSpannableString != null)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        AvTipsView.a((TextView)localObject, paramTipsInfo);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.tips.AvTipsView.MainTips
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.tips;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

class AvTipsView$SubTips
  extends AvTipsView.BaseTips
{
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  
  AvTipsView$SubTips(LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLinearLayout.findViewById(2131374066));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLinearLayout.findViewById(2131373784));
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
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView != null;
  }
  
  boolean a(AvTipsView.TipsInfo paramTipsInfo)
  {
    a();
    if ((paramTipsInfo.a != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      AvTipsView.a(this.jdField_a_of_type_AndroidWidgetTextView, paramTipsInfo);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.tips.AvTipsView.SubTips
 * JD-Core Version:    0.7.0.1
 */
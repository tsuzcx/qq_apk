package com.tencent.biz.pubaccount.readinjoy.view;

import alud;
import android.content.Context;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ReadInJoyDisLikeDialogViewForAd
  extends ReadInJoyDisLikeDialogView
{
  public ReadInJoyDisLikeDialogViewForAd(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a(Context paramContext)
  {
    super.a(paramContext);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    if (this.jdField_a_of_type_AndroidWidgetButton != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setText(alud.a(2131713169));
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogViewForAd
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.ui;

import android.text.TextUtils;
import android.view.View;

public class ControlUIObserver$CPreChangButtonStyleInfo
  extends ControlUIObserver.CPreEventInfo
{
  public int a;
  public boolean a;
  
  public ControlUIObserver$CPreChangButtonStyleInfo(View paramView, boolean paramBoolean, int paramInt)
  {
    super(paramView);
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.ui.ControlUIObserver.CPreChangButtonStyleInfo
 * JD-Core Version:    0.7.0.1
 */
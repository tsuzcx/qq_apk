package com.tencent.mobileqq.apollo.aio.panel;

import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

class ApolloPanelTips$PopupWindowData
{
  private final int jdField_a_of_type_Int;
  private final View jdField_a_of_type_AndroidViewView;
  private final String jdField_a_of_type_JavaLangString;
  WeakReference<View.OnClickListener> jdField_a_of_type_JavaLangRefWeakReference;
  private final int b;
  
  ApolloPanelTips$PopupWindowData(View paramView, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelTips.PopupWindowData
 * JD-Core Version:    0.7.0.1
 */
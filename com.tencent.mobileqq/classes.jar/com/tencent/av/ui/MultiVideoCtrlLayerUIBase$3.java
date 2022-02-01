package com.tencent.av.ui;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUIBase$3
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$3(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_AndroidViewViewGroup == null) || (this.this$0.jdField_d_of_type_AndroidWidgetTextView == null) || (this.this$0.jdField_a_of_type_AndroidContentResResources == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.this$0.jdField_d_of_type_JavaLangString, 2, "SetTitleMaxWidth Failed --> RootView Or TitleView Or Resource is NULL");
      }
      return;
    }
    int i = this.this$0.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299096);
    this.this$0.jdField_d_of_type_AndroidWidgetTextView.setMaxWidth(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.3
 * JD-Core Version:    0.7.0.1
 */
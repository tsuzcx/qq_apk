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
    if ((this.this$0.jdField_a_of_type_AndroidViewViewGroup != null) && (this.this$0.e != null) && (this.this$0.jdField_a_of_type_AndroidContentResResources != null))
    {
      int i = this.this$0.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131299274);
      this.this$0.e.setMaxWidth(i);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.this$0.d, 2, "SetTitleMaxWidth Failed --> RootView Or TitleView Or Resource is NULL");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.3
 * JD-Core Version:    0.7.0.1
 */
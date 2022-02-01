package com.tencent.av.ui;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class MultiVideoCtrlLayerUIBase$RefreshDisplayNameRunnable
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$RefreshDisplayNameRunnable(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.this$0.d, String.valueOf(this.this$0.jdField_a_of_type_Long), null);
    MultiVideoCtrlLayerUIBase localMultiVideoCtrlLayerUIBase = this.this$0;
    localMultiVideoCtrlLayerUIBase.jdField_b_of_type_JavaLangString = localMultiVideoCtrlLayerUIBase.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131695369);
    if (this.this$0.e == 2)
    {
      localMultiVideoCtrlLayerUIBase = this.this$0;
      localMultiVideoCtrlLayerUIBase.jdField_b_of_type_JavaLangString = localMultiVideoCtrlLayerUIBase.a((String)localObject, localMultiVideoCtrlLayerUIBase.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.this$0.e, String.valueOf(this.this$0.jdField_a_of_type_Long)), this.this$0.jdField_a_of_type_AndroidWidgetTextView);
    }
    else if (this.this$0.e == 1)
    {
      this.this$0.jdField_b_of_type_JavaLangString = ((String)localObject);
    }
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(this.this$0.jdField_b_of_type_JavaLangString);
    if (this.this$0.j == 2131695503)
    {
      this.this$0.C();
    }
    else
    {
      localObject = this.this$0;
      ((MultiVideoCtrlLayerUIBase)localObject).e(-1L, ((MultiVideoCtrlLayerUIBase)localObject).i);
      localObject = this.this$0;
      ((MultiVideoCtrlLayerUIBase)localObject).f(-1L, ((MultiVideoCtrlLayerUIBase)localObject).i);
    }
    this.this$0.jdField_b_of_type_AndroidWidgetTextView.setText(this.this$0.jdField_b_of_type_JavaLangString);
    this.this$0.jdField_b_of_type_AndroidWidgetTextView.setText(null);
    localObject = this.this$0;
    ((MultiVideoCtrlLayerUIBase)localObject).h += 1;
    if (this.this$0.f != null)
    {
      if (this.this$0.h < 3)
      {
        this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.this$0.f, 1000L);
        return;
      }
      this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.this$0.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.RefreshDisplayNameRunnable
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.gaudio;

import com.tencent.mobileqq.app.QQAppInterface;
import mse;

class AVNotifyCenter$1
  implements Runnable
{
  AVNotifyCenter$1(AVNotifyCenter paramAVNotifyCenter) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.this$0.jdField_a_of_type_Mse = new mse(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.1
 * JD-Core Version:    0.7.0.1
 */
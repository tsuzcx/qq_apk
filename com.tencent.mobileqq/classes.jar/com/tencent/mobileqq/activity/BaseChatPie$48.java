package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Build;
import bicz;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$48
  implements Runnable
{
  BaseChatPie$48(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.jdField_a_of_type_JavaLangString, 2, "recorderVolumeChange " + this.a);
    }
    if (this.a == 1) {
      if (!this.this$0.n()) {
        QLog.i(this.this$0.jdField_a_of_type_JavaLangString, 1, "volueme state err" + Build.MANUFACTURER + Build.MODEL);
      }
    }
    while (((this.a != 2) && (this.a != 0)) || (this.this$0.jdField_a_of_type_Bicz == null) || (!this.this$0.jdField_a_of_type_Bicz.isShowing()) || (this.this$0.jdField_a_of_type_Bicz.getWindow() == null))
    {
      do
      {
        return;
      } while ((this.this$0.jdField_a_of_type_Bicz != null) && (this.this$0.jdField_a_of_type_Bicz.isShowing()));
      this.this$0.jdField_a_of_type_Bicz = new bicz(this.this$0.jdField_a_of_type_AndroidContentContext);
      this.this$0.jdField_a_of_type_Bicz.a(this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131697733));
      this.this$0.jdField_a_of_type_Bicz.show();
      return;
    }
    this.this$0.jdField_a_of_type_Bicz.dismiss();
    this.this$0.jdField_a_of_type_Bicz = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.48
 * JD-Core Version:    0.7.0.1
 */
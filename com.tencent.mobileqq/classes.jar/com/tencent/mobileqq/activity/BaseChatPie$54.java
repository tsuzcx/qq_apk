package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Build;
import bewb;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$54
  implements Runnable
{
  BaseChatPie$54(BaseChatPie paramBaseChatPie, int paramInt) {}
  
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
    while (((this.a != 2) && (this.a != 0)) || (this.this$0.jdField_a_of_type_Bewb == null) || (!this.this$0.jdField_a_of_type_Bewb.isShowing()) || (this.this$0.jdField_a_of_type_Bewb.getWindow() == null))
    {
      do
      {
        return;
      } while ((this.this$0.jdField_a_of_type_Bewb != null) && (this.this$0.jdField_a_of_type_Bewb.isShowing()));
      this.this$0.jdField_a_of_type_Bewb = new bewb(this.this$0.jdField_a_of_type_AndroidContentContext);
      this.this$0.jdField_a_of_type_Bewb.a(this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131698861));
      this.this$0.jdField_a_of_type_Bewb.show();
      return;
    }
    this.this$0.jdField_a_of_type_Bewb.dismiss();
    this.this$0.jdField_a_of_type_Bewb = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.54
 * JD-Core Version:    0.7.0.1
 */
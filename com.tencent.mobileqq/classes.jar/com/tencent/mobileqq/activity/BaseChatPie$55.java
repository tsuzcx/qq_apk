package com.tencent.mobileqq.activity;

import android.content.Context;
import android.os.Build;
import bbot;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$55
  implements Runnable
{
  BaseChatPie$55(BaseChatPie paramBaseChatPie, int paramInt) {}
  
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
    while (((this.a != 2) && (this.a != 0)) || (this.this$0.jdField_a_of_type_Bbot == null) || (!this.this$0.jdField_a_of_type_Bbot.isShowing()) || (this.this$0.jdField_a_of_type_Bbot.getWindow() == null))
    {
      do
      {
        return;
      } while ((this.this$0.jdField_a_of_type_Bbot != null) && (this.this$0.jdField_a_of_type_Bbot.isShowing()));
      this.this$0.jdField_a_of_type_Bbot = new bbot(this.this$0.jdField_a_of_type_AndroidContentContext);
      this.this$0.jdField_a_of_type_Bbot.a(this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131632808));
      this.this$0.jdField_a_of_type_Bbot.show();
      return;
    }
    this.this$0.jdField_a_of_type_Bbot.dismiss();
    this.this$0.jdField_a_of_type_Bbot = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.55
 * JD-Core Version:    0.7.0.1
 */
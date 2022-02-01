package com.tencent.biz.anonymous;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;

class QQAnonymousDialog$1
  implements Handler.Callback
{
  QQAnonymousDialog$1(QQAnonymousDialog paramQQAnonymousDialog) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 291)
    {
      int i = this.a.jdField_a_of_type_Int;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              i = 0;
            } else {
              i = 2131696054;
            }
          }
          else {
            i = 2131696053;
          }
        }
        else {
          i = 2131696052;
        }
      }
      else {
        i = 2131696051;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(i));
      paramMessage = this.a;
      paramMessage.jdField_a_of_type_Int += 1;
      if (this.a.jdField_a_of_type_Int == 4) {
        this.a.jdField_a_of_type_Int = 0;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(291, 1000L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.anonymous.QQAnonymousDialog.1
 * JD-Core Version:    0.7.0.1
 */
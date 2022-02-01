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
    int i;
    if (paramMessage.what == 291) {
      switch (this.a.jdField_a_of_type_Int)
      {
      default: 
        i = 0;
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(i));
      paramMessage = this.a;
      paramMessage.jdField_a_of_type_Int += 1;
      if (this.a.jdField_a_of_type_Int == 4) {
        this.a.jdField_a_of_type_Int = 0;
      }
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(291, 1000L);
      return false;
      i = 2131696036;
      continue;
      i = 2131696037;
      continue;
      i = 2131696038;
      continue;
      i = 2131696039;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.anonymous.QQAnonymousDialog.1
 * JD-Core Version:    0.7.0.1
 */
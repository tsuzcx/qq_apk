package com.tencent.mobileqq.armap;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class SupercellActivity$1
  implements Handler.Callback
{
  SupercellActivity$1(SupercellActivity paramSupercellActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SupercellActivity", 2, "handleMessage : " + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      return true;
    }
    this.this$0.hideGuide();
    this.this$0.isFindSupercell = true;
    SupercellActivity.access$200(this.this$0).queueEvent(new SupercellActivity.1.1(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.1
 * JD-Core Version:    0.7.0.1
 */
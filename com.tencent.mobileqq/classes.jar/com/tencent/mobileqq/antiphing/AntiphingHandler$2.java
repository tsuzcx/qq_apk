package com.tencent.mobileqq.antiphing;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class AntiphingHandler$2
  implements DialogInterface.OnClickListener
{
  AntiphingHandler$2(AntiphingHandler paramAntiphingHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(AntiphingHandler.a(this.a), 4, "right button is clicked! ");
    }
    AntiphingHandler.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphingHandler.2
 * JD-Core Version:    0.7.0.1
 */
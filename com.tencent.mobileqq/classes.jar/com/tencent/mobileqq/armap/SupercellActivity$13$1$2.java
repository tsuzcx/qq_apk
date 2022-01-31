package com.tencent.mobileqq.armap;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class SupercellActivity$13$1$2
  implements DialogInterface.OnClickListener
{
  SupercellActivity$13$1$2(SupercellActivity.13.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.i("ARTreasurePlayControl", 2, "initMode when camera openfail");
    }
    SupercellActivity.access$200(this.this$2.this$1.this$0).queueEvent(new SupercellActivity.13.1.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SupercellActivity.13.1.2
 * JD-Core Version:    0.7.0.1
 */
package com.qq.im.poi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.armap.ARTreasurePlayControl;
import com.tencent.qphone.base.util.QLog;

class LbsCaiShenActivity$3
  implements DialogInterface.OnClickListener
{
  LbsCaiShenActivity$3(LbsCaiShenActivity paramLbsCaiShenActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    if (QLog.isColorLevel()) {
      QLog.i("ARTreasurePlayControl", 2, "initMode when camera openfail");
    }
    LbsCaiShenActivity.access$100(this.this$0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qq.im.poi.LbsCaiShenActivity.3
 * JD-Core Version:    0.7.0.1
 */
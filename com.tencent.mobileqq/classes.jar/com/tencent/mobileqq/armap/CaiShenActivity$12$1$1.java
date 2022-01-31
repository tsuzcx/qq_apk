package com.tencent.mobileqq.armap;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class CaiShenActivity$12$1$1
  implements DialogInterface.OnDismissListener
{
  CaiShenActivity$12$1$1(CaiShenActivity.12.1 param1) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaiShenActivity", 2, "already get dialog close");
    }
    this.this$2.this$1.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity.12.1.1
 * JD-Core Version:    0.7.0.1
 */
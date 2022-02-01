package com.tencent.mobileqq.bigbrother;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.statistics.ReportController;

class JumpConfirmFragment$2
  implements DialogInterface.OnClickListener
{
  JumpConfirmFragment$2(JumpConfirmFragment paramJumpConfirmFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    JefsClass.getInstance().b(JumpConfirmFragment.a(this.a), JumpConfirmFragment.a(this.a), JumpConfirmFragment.b(this.a));
    if (JumpConfirmFragment.b(this.a) == null) {
      paramDialogInterface = "";
    } else {
      paramDialogInterface = JumpConfirmFragment.b(this.a);
    }
    ReportController.b(null, "dc00898", "", "", "0X8009C5A", "0X8009C5A", 0, 0, "1", "", paramDialogInterface, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.JumpConfirmFragment.2
 * JD-Core Version:    0.7.0.1
 */
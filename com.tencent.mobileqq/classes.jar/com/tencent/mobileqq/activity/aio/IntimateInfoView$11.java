package com.tencent.mobileqq.activity.aio;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class IntimateInfoView$11
  implements DialogInterface.OnClickListener
{
  IntimateInfoView$11(IntimateInfoView paramIntimateInfoView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((IntimateInfoView.l(this.a) != null) && (IntimateInfoView.l(this.a).isShowing())) {
        IntimateInfoView.l(this.a).dismiss();
      }
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, "disband cancel");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.11
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ar;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class FaceUIController$1
  implements DialogInterface.OnClickListener
{
  FaceUIController$1(FaceUIController paramFaceUIController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a.a, 2, 2131690201, 0).a();
      paramDialogInterface.dismiss();
      ReportController.b(null, "dc00898", "", "", "0X8008353", "0X8008353", 0, 0, "", "", "", "");
      return;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FaceUIController.1
 * JD-Core Version:    0.7.0.1
 */
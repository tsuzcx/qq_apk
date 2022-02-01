package com.tencent.mobileqq.activity.richmedia;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.QQCustomDialog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class QzoneSlideShowPreparingFragment$6
  implements DialogInterface.OnClickListener
{
  QzoneSlideShowPreparingFragment$6(QzoneSlideShowPreparingFragment paramQzoneSlideShowPreparingFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LpReportInfo_pf00064.allReport(680, 1, 2);
    QzoneSlideShowPreparingFragment.a(this.a).dismiss();
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gdtad.basics.motivevideo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.qphone.base.util.QLog;

class GdtMvViewController$3
  implements DialogInterface.OnClickListener
{
  GdtMvViewController$3(GdtMvViewController paramGdtMvViewController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("GdtMvViewController", 1, " DialogInterface onClick confirm");
    GdtMvViewController.b(this.a, false);
    this.a.i();
    if (GdtADFlyingStreamingReportHelper.a().b() == 1) {
      GdtADFlyingStreamingReportHelper.a().a(1020041L);
    } else {
      GdtMvViewController.a(this.a, 1020011L);
    }
    GdtADFlyingStreamingReportHelper.a().a(40062L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.3
 * JD-Core Version:    0.7.0.1
 */
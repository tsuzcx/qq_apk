package com.tencent.gdtad.api.motivevideo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class GdtMvViewController$3
  implements DialogInterface.OnClickListener
{
  GdtMvViewController$3(GdtMvViewController paramGdtMvViewController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("GdtMvViewController", 1, " DialogInterface onClick confirm");
    GdtMvViewController.a(this.a, false);
    this.a.d();
    if (GdtADFlyingStreamingReportHelper.a().a() == 1)
    {
      GdtADFlyingStreamingReportHelper.a().a(1020041L);
      return;
    }
    GdtMvViewController.a(this.a, 1020011L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.3
 * JD-Core Version:    0.7.0.1
 */
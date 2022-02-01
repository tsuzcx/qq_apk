package com.tencent.gdtad.api.motivevideo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class GdtMvViewController$4
  implements DialogInterface.OnClickListener
{
  GdtMvViewController$4(GdtMvViewController paramGdtMvViewController) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("GdtMvViewController", 1, " DialogInterface onClick onCancel");
    GdtMvViewController.a(this.a).a();
    if (GdtADFlyingStreamingReportHelper.a().a() == 1) {
      GdtADFlyingStreamingReportHelper.a().a(1020040L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.4
 * JD-Core Version:    0.7.0.1
 */
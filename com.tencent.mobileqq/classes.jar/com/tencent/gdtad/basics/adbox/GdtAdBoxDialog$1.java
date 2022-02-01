package com.tencent.gdtad.basics.adbox;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.basics.motivevideo.report.GdtMotiveVideoClickCoordinateReportHelper;
import java.util.Iterator;
import java.util.List;

class GdtAdBoxDialog$1
  implements DialogInterface.OnDismissListener
{
  GdtAdBoxDialog$1(GdtAdBoxDialog paramGdtAdBoxDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    GdtAdBoxDialog.a(this.a).b();
    this.a.c.d();
    this.a.b.d();
    paramDialogInterface = GdtAdBoxDialog.b(this.a).iterator();
    while (paramDialogInterface.hasNext())
    {
      AdExposureChecker localAdExposureChecker = (AdExposureChecker)paramDialogInterface.next();
      localAdExposureChecker.onActivityDestroy();
      localAdExposureChecker.setCallback(null);
    }
    GdtAdBoxDialog.b(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.adbox.GdtAdBoxDialog.1
 * JD-Core Version:    0.7.0.1
 */
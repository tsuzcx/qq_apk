package com.tencent.gdtad.api.adbox;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoClickCoordinateReportHelper;
import java.util.Iterator;
import java.util.List;

class GdtAdBoxDialog$1
  implements DialogInterface.OnDismissListener
{
  GdtAdBoxDialog$1(GdtAdBoxDialog paramGdtAdBoxDialog) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    GdtAdBoxDialog.a(this.a).a();
    this.a.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxPresenter.d();
    this.a.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBox.c();
    paramDialogInterface = GdtAdBoxDialog.a(this.a).iterator();
    while (paramDialogInterface.hasNext())
    {
      AdExposureChecker localAdExposureChecker = (AdExposureChecker)paramDialogInterface.next();
      localAdExposureChecker.onActivityDestroy();
      localAdExposureChecker.setCallback(null);
    }
    GdtAdBoxDialog.a(this.a).clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.adbox.GdtAdBoxDialog.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gdtad.api.motivevideo;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class GdtMvViewController$10
  implements AdExposureChecker.ExposureCallback
{
  GdtMvViewController$10(GdtMvViewController paramGdtMvViewController) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    paramWeakReference = new GdtMotiveVideoClickCoordinateReportHelper().a(GdtMvViewController.a(this.a).a().getUrlForImpression());
    GdtReporter.doCgiReport(paramWeakReference);
    QLog.d("GdtMvViewController", 1, "AdExposureChecker exposure report url: " + paramWeakReference);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.10
 * JD-Core Version:    0.7.0.1
 */
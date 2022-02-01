package com.tencent.gdtad.basics.motivevideo;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.report.GdtMotiveVideoClickCoordinateReportHelper;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class GdtMvViewController$9
  implements AdExposureChecker.ExposureCallback
{
  GdtMvViewController$9(GdtMvViewController paramGdtMvViewController) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    paramWeakReference = new GdtMotiveVideoClickCoordinateReportHelper().a(GdtMvViewController.a(this.a).a().getUrlForImpression());
    GdtReporter.doExposeCgiReport(paramWeakReference);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AdExposureChecker exposure report url: ");
    localStringBuilder.append(paramWeakReference);
    QLog.d("GdtMvViewController", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.9
 * JD-Core Version:    0.7.0.1
 */
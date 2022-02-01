package com.tencent.gdtad.basics.motivevideo;

import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.report.GdtMotiveVideoClickCoordinateReportHelper;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.ref.WeakReference<Landroid.view.View;>;

class GdtMvViewController$10
  implements AdExposureChecker.ExposureCallback
{
  GdtMvViewController$10(GdtMvViewController paramGdtMvViewController) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    Object localObject = new GdtMotiveVideoClickCoordinateReportHelper().a(GdtMvViewController.m(this.a).d().getUrlForImpression());
    paramWeakReference = (WeakReference<View>)localObject;
    if (GdtMvViewController.n(this.a) > 0)
    {
      paramWeakReference = new StringBuilder();
      paramWeakReference.append((String)localObject);
      paramWeakReference.append("&slot=");
      paramWeakReference.append(GdtMvViewController.n(this.a));
      paramWeakReference = paramWeakReference.toString();
    }
    GdtReporter.doExposeCgiReport(paramWeakReference);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("AdExposureChecker exposure report url: ");
    ((StringBuilder)localObject).append(paramWeakReference);
    QLog.d("GdtMvViewController", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.10
 * JD-Core Version:    0.7.0.1
 */
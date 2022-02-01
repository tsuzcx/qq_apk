package com.tencent.gdtad.basics.motivevideo;

import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.basics.motivevideo.web.bottomcrad.IOnWebBottomCardCallback;
import com.tencent.qphone.base.util.QLog;

class GdtMvViewController$2
  implements IOnWebBottomCardCallback
{
  GdtMvViewController$2(GdtMvViewController paramGdtMvViewController) {}
  
  public void a()
  {
    QLog.i("GdtMvViewController", 1, "onLoadFail,show native");
    GdtMvViewController.a(this.a, false);
    GdtADFlyingStreamingReportHelper.a().a(1020042L);
  }
  
  public void b()
  {
    QLog.i("GdtMvViewController", 1, "onLoadSuccess");
    GdtMvViewController.b(this.a).n = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.2
 * JD-Core Version:    0.7.0.1
 */
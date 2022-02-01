package com.tencent.gdtad.api.motivevideo;

import com.tencent.gdtad.api.motivevideo.webbottomcard.IOnWebBottomCardCallback;
import com.tencent.qphone.base.util.QLog;

class GdtMvViewController$2
  implements IOnWebBottomCardCallback
{
  GdtMvViewController$2(GdtMvViewController paramGdtMvViewController) {}
  
  public void a()
  {
    QLog.i("GdtMvViewController", 1, "onLoadFail,show native");
    GdtMvViewController.b(this.a);
    GdtADFlyingStreamingReportHelper.a().a(1020042L);
  }
  
  public void b()
  {
    QLog.i("GdtMvViewController", 1, "onLoadSuccess");
    GdtMvViewController.a(this.a).d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.2
 * JD-Core Version:    0.7.0.1
 */
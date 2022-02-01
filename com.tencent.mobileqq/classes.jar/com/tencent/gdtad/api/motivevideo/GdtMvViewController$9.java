package com.tencent.gdtad.api.motivevideo;

import com.tencent.ad.tangram.net.AdHttp.Params;
import com.tencent.gdtad.statistics.GdtReportForAntiSpam.ReportCallback;

class GdtMvViewController$9
  implements GdtReportForAntiSpam.ReportCallback
{
  GdtMvViewController$9(GdtMvViewController paramGdtMvViewController) {}
  
  public void a(AdHttp.Params paramParams)
  {
    if (paramParams != null)
    {
      if (paramParams.isSuccess()) {
        GdtMvViewController.a(this.a, 1020021L);
      }
    }
    else {
      return;
    }
    GdtMvViewController.a(this.a, 1020022L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMvViewController.9
 * JD-Core Version:    0.7.0.1
 */
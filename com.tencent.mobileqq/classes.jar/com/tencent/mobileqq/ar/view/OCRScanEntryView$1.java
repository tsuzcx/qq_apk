package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import com.tencent.mobileqq.ar.model.CameraProxy;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class OCRScanEntryView$1
  implements Runnable
{
  OCRScanEntryView$1(OCRScanEntryView paramOCRScanEntryView) {}
  
  public void run()
  {
    String str = CameraProxy.a().m();
    if (FileUtil.d(str))
    {
      ((IOCR)QRoute.api(IOCR.class)).startOcrPerformFragment((Activity)this.this$0.E, str, 0, -1008, null);
      ReportController.b(null, "dc00898", "", "", "0X800AE06", "0X800AE06", 1, 0, "", "0", "0", "");
    }
    OCRScanEntryView.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.OCRScanEntryView.1
 * JD-Core Version:    0.7.0.1
 */
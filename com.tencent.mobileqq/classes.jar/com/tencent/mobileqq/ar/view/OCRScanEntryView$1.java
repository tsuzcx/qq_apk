package com.tencent.mobileqq.ar.view;

import anbk;
import android.app.Activity;
import arof;
import com.tencent.mobileqq.ocr.OCRPerformFragment;

class OCRScanEntryView$1
  implements Runnable
{
  OCRScanEntryView$1(OCRScanEntryView paramOCRScanEntryView) {}
  
  public void run()
  {
    String str = anbk.a().a();
    if (arof.a(str)) {
      OCRPerformFragment.a((Activity)this.this$0.a, str, 0, -1008, null);
    }
    OCRScanEntryView.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.OCRScanEntryView.1
 * JD-Core Version:    0.7.0.1
 */
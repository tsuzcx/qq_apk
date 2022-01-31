package com.tencent.mobileqq.ar.view;

import alkv;
import android.app.Activity;
import apvb;
import com.tencent.mobileqq.ocr.OCRResultActivity;

class OCRScanEntryView$1
  implements Runnable
{
  OCRScanEntryView$1(OCRScanEntryView paramOCRScanEntryView) {}
  
  public void run()
  {
    String str = alkv.a().a();
    if (apvb.a(str)) {
      OCRResultActivity.a((Activity)this.this$0.a, str, 0);
    }
    OCRScanEntryView.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.OCRScanEntryView.1
 * JD-Core Version:    0.7.0.1
 */
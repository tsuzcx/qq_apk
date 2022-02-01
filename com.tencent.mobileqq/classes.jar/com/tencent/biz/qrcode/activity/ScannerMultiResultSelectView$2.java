package com.tencent.biz.qrcode.activity;

import com.tencent.qbar.QBarResult;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ScannerMultiResultSelectView$2
  implements Runnable
{
  ScannerMultiResultSelectView$2(ScannerMultiResultSelectView paramScannerMultiResultSelectView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScannerMultiResultSelectView", 2, "updateAfterDecodeBitmap mShowing：" + ScannerMultiResultSelectView.a(this.this$0) + " mBitmap:" + ScannerMultiResultSelectView.a(this.this$0));
    }
    if (!ScannerMultiResultSelectView.a(this.this$0)) {}
    do
    {
      return;
      if (ScannerMultiResultSelectView.a(this.this$0) != null)
      {
        ScannerMultiResultSelectView.b(this.this$0);
        return;
      }
    } while ((ScannerMultiResultSelectView.a(this.this$0) == null) || (ScannerMultiResultSelectView.a(this.this$0) == null));
    if (ScannerMultiResultSelectView.a(this.this$0).d())
    {
      ScannerMultiResultSelectView.a(this.this$0).a((QBarResult)ScannerMultiResultSelectView.a(this.this$0).a.get(0), ScannerMultiResultSelectView.a(this.this$0), ScannerMultiResultSelectView.a(this.this$0));
      return;
    }
    if (ScannerMultiResultSelectView.a(this.this$0).c())
    {
      ScannerMultiResultSelectView.a(this.this$0).a((QMiniResult)ScannerMultiResultSelectView.a(this.this$0).b.get(0), ScannerMultiResultSelectView.a(this.this$0), ScannerMultiResultSelectView.a(this.this$0));
      return;
    }
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerMultiResultSelectView.2
 * JD-Core Version:    0.7.0.1
 */
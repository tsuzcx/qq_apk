package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.ARRecord.ARRecordUtils;
import com.tencent.mobileqq.ar.model.QRSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.qrscan.view.ScannerMultiResultSelectView.ImageData;
import com.tencent.mobileqq.statistics.ReportController;

class QRScanEntryView$15
  implements Runnable
{
  QRScanEntryView$15(QRScanEntryView paramQRScanEntryView, ScannerResult paramScannerResult, ScannerMultiResultSelectView.ImageData paramImageData) {}
  
  public void run()
  {
    if (this.this$0.E != null)
    {
      if (this.this$0.G == null) {
        return;
      }
      Activity localActivity = (Activity)this.this$0.E;
      Object localObject = this.a;
      if ((localObject != null) && (((ScannerResult)localObject).a()) && ((this.b.a == null) || (((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).isDetectInited())))
      {
        QRScanEntryView.a(this.this$0, this.a, 3, this.b);
        return;
      }
      localObject = this.a;
      if ((localObject != null) && (((ScannerResult)localObject).h()))
      {
        localObject = this.a.b();
        if (localObject != null) {
          QRScanEntryView.a(this.this$0, String.valueOf(((Pair)localObject).first), String.valueOf(((Pair)localObject).second), localActivity, this.b.d);
        }
        ReportController.b(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 0, 0, "", "", "", "");
        return;
      }
      localObject = this.a;
      if ((localObject != null) && (((ScannerResult)localObject).g()))
      {
        localObject = this.a.c();
        String str = this.a.d();
        QRScanEntryView.b(this.this$0, (String)localObject, str, localActivity, this.b.d);
        ReportController.b(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 1, 0, "", "", "", "");
        return;
      }
      if (!TextUtils.isEmpty(this.b.d))
      {
        ((QRSession)this.this$0.G).b(false);
        ARRecordUtils.a(HardCodeUtil.a(2131908829), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.15
 * JD-Core Version:    0.7.0.1
 */
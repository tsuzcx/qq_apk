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
    if (this.this$0.jdField_a_of_type_AndroidContentContext != null)
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession == null) {
        return;
      }
      Activity localActivity = (Activity)this.this$0.jdField_a_of_type_AndroidContentContext;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult;
      if ((localObject != null) && (((ScannerResult)localObject).a()) && ((this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$ImageData.jdField_a_of_type_ArrayOfByte == null) || (((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).isDetectInited())))
      {
        QRScanEntryView.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult, 3, this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$ImageData);
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult;
      if ((localObject != null) && (((ScannerResult)localObject).d()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult.a();
        if (localObject != null) {
          QRScanEntryView.a(this.this$0, String.valueOf(((Pair)localObject).first), String.valueOf(((Pair)localObject).second), localActivity, this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$ImageData.jdField_a_of_type_JavaLangString);
        }
        ReportController.b(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 0, 0, "", "", "", "");
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult;
      if ((localObject != null) && (((ScannerResult)localObject).c()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqQrscanScannerResult.a();
        QRScanEntryView.a(this.this$0, (String)localObject, localActivity, this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$ImageData.jdField_a_of_type_JavaLangString);
        ReportController.b(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 1, 0, "", "", "", "");
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqQrscanViewScannerMultiResultSelectView$ImageData.jdField_a_of_type_JavaLangString))
      {
        ((QRSession)this.this$0.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession).b(false);
        ARRecordUtils.a(HardCodeUtil.a(2131711164), false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.15
 * JD-Core Version:    0.7.0.1
 */
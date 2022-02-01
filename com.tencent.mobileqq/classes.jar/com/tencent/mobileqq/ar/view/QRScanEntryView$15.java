package com.tencent.mobileqq.ar.view;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.qrcode.activity.ScannerMultiResultSelectView.ImageData;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.ARRecord.ARRecordUtils;
import com.tencent.mobileqq.ar.codeEngine.MiniCodeController;
import com.tencent.mobileqq.ar.model.QRSession;
import com.tencent.mobileqq.statistics.ReportController;

class QRScanEntryView$15
  implements Runnable
{
  QRScanEntryView$15(QRScanEntryView paramQRScanEntryView, ScannerResult paramScannerResult, ScannerMultiResultSelectView.ImageData paramImageData) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_AndroidContentContext == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession == null)) {}
    do
    {
      return;
      Activity localActivity = (Activity)this.this$0.jdField_a_of_type_AndroidContentContext;
      if ((this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult != null) && (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.a()) && ((this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView$ImageData.jdField_a_of_type_ArrayOfByte == null) || (MiniCodeController.b())))
      {
        QRScanEntryView.a(this.this$0, this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult, 3, this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView$ImageData);
        return;
      }
      Object localObject;
      if ((this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult != null) && (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.d()))
      {
        localObject = this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.a();
        if (localObject != null) {
          QRScanEntryView.a(this.this$0, String.valueOf(((Pair)localObject).first), String.valueOf(((Pair)localObject).second), localActivity, this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView$ImageData.jdField_a_of_type_JavaLangString);
        }
        ReportController.b(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 0, 0, "", "", "", "");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult != null) && (this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.c()))
      {
        localObject = this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerResult.a();
        QRScanEntryView.a(this.this$0, (String)localObject, localActivity, this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView$ImageData.jdField_a_of_type_JavaLangString);
        ReportController.b(null, "dc00898", "", "", "0X80085AC", "0X80085AC", 1, 0, "", "", "", "");
        return;
      }
    } while (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQrcodeActivityScannerMultiResultSelectView$ImageData.jdField_a_of_type_JavaLangString));
    ((QRSession)this.this$0.jdField_a_of_type_ComTencentMobileqqArModelAbstractSession).b(false);
    ARRecordUtils.a(HardCodeUtil.a(2131711188), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.15
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qrcode.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qrcode.logindev.LoginDevItem;
import com.tencent.mobileqq.statistics.ReportController;

class QRLoginMgrActivity$8
  implements DialogInterface.OnClickListener
{
  QRLoginMgrActivity$8(QRLoginMgrActivity paramQRLoginMgrActivity, LoginDevItem paramLoginDevItem) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QRLoginMgrActivity.a(this.jdField_a_of_type_ComTencentBizQrcodeActivityQRLoginMgrActivity, false, this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevItem.a);
    ReportController.b(null, "dc00898", "", "", "0X800A474", "0X800A474", this.jdField_a_of_type_ComTencentBizQrcodeLogindevLoginDevItem.c, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.8
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qrcode.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.statistics.ReportController;

class QRLoginMgrActivity$1$1
  implements DialogInterface.OnClickListener
{
  QRLoginMgrActivity$1$1(QRLoginMgrActivity.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((RegisterProxySvcPackHandler)this.a.a.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).a(true);
    ReportController.b(null, "dc00898", "", "", "0X800A476", "0X800A476", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.1.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qrcode.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QRLoginMgrActivity$1
  implements CompoundButton.OnCheckedChangeListener
{
  QRLoginMgrActivity$1(QRLoginMgrActivity paramQRLoginMgrActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "qqmute onCheckedChanged:", Boolean.valueOf(paramBoolean) });
    }
    if (!NetworkUtil.g(this.a))
    {
      QQToast.a(QRLoginMgrActivity.a(this.a), 1, 2131696097, 0).b(this.a.getTitleBarHeight());
      if (!paramBoolean) {
        bool = true;
      }
      paramCompoundButton.setChecked(bool);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      if (paramBoolean)
      {
        QQCustomDialog localQQCustomDialog = DialogUtil.a(QRLoginMgrActivity.a(this.a), 230);
        localQQCustomDialog.setTitle(2131717034);
        localQQCustomDialog.setMessage(2131717033);
        localQQCustomDialog.setPositiveButton(2131694615, new QRLoginMgrActivity.1.1(this));
        localQQCustomDialog.setNegativeButton(2131690800, new QRLoginMgrActivity.1.2(this, paramCompoundButton));
        localQQCustomDialog.show();
        ReportController.b(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
      }
      else
      {
        ((RegisterProxySvcPackHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).a(paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.1
 * JD-Core Version:    0.7.0.1
 */
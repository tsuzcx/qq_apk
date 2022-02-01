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
    if (QLog.isColorLevel()) {
      QLog.d("QRLoginMgrActivity", 2, new Object[] { "qqmute onCheckedChanged:", Boolean.valueOf(paramBoolean) });
    }
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QQToast.a(QRLoginMgrActivity.a(this.a), 1, 2131696114, 0).b(this.a.getTitleBarHeight());
      paramCompoundButton.setChecked(paramBoolean ^ true);
    }
    else if (paramBoolean)
    {
      QQCustomDialog localQQCustomDialog = DialogUtil.a(QRLoginMgrActivity.a(this.a), 230);
      localQQCustomDialog.setTitle(2131716687);
      localQQCustomDialog.setMessage(2131716686);
      localQQCustomDialog.setPositiveButton(2131694583, new QRLoginMgrActivity.1.1(this));
      localQQCustomDialog.setNegativeButton(2131690728, new QRLoginMgrActivity.1.2(this, paramCompoundButton));
      localQQCustomDialog.show();
      ReportController.b(null, "dc00898", "", "", "0X800A475", "0X800A475", 0, 0, "", "", "", "");
    }
    else
    {
      ((RegisterProxySvcPackHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).a(paramBoolean);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRLoginMgrActivity.1
 * JD-Core Version:    0.7.0.1
 */
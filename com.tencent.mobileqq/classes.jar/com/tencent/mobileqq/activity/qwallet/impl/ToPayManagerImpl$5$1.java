package com.tencent.mobileqq.activity.qwallet.impl;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ToPayManagerImpl$5$1
  implements Runnable
{
  ToPayManagerImpl$5$1(ToPayManagerImpl.5 param5, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = (BaseActivity)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localBaseActivity == null) || (localBaseActivity.isFinishing())) {
      return;
    }
    ToPayManagerImpl.access$000(localBaseActivity, false);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.this$0.jdField_a_of_type_AndroidOsResultReceiver.send(1, new Bundle());
      ReportController.b(QWalletTools.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.aio.send", 0, 0, "", "", "", "");
      int i = localBaseActivity.getIntent().getIntExtra("iPayFrom", -1);
      if (QLog.isColorLevel()) {
        QLog.e("TopayManager", 2, "iPayFrom : " + i);
      }
      if (i == 1)
      {
        ToPayManagerImpl.access$100(localBaseActivity, this.this$0.jdField_a_of_type_JavaUtilArrayList, this.this$0.b);
        return;
      }
      ToPayManagerImpl.access$200(localBaseActivity, this.this$0.jdField_a_of_type_JavaUtilArrayList, this.this$0.b);
      return;
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {}
    for (String str = this.jdField_a_of_type_AndroidOsBundle.getString("retmsg");; str = null)
    {
      if (TextUtils.isEmpty(str)) {
        str = localBaseActivity.getResources().getString(2131694678);
      }
      for (;;)
      {
        DialogUtil.a(localBaseActivity, 231, null, str, localBaseActivity.getResources().getString(2131694615), null, null, new ToPayManagerImpl.5.1.1(this)).show();
        ReportController.b(QWalletTools.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.errwinshow", 0, 0, "", "", "", "");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.impl.ToPayManagerImpl.5.1
 * JD-Core Version:    0.7.0.1
 */
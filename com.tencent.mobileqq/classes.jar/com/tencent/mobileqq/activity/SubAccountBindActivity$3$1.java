package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.observer.SubAccountObserver;

class SubAccountBindActivity$3$1
  extends SubAccountObserver
{
  SubAccountBindActivity$3$1(SubAccountBindActivity.3 param3, SimpleAccount paramSimpleAccount) {}
  
  public void onGetKeyBack(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12005");
      paramString1.put("fail_step", "getKeyEmpty");
      paramString1.put("fail_location", "SubBind");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$3.a.app.getCurrentAccountUin(), "actSBDLoginGetkey", false, 0L, 0L, paramString1, "");
      if (QLog.isColorLevel()) {
        QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onGetKeyBack: key is empty");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$3.a.runOnUiThread(new SubAccountBindActivity.3.1.1(this));
    }
    do
    {
      return;
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "12006");
      paramString1.put("fail_step", "getKeyNotEmpty");
      paramString1.put("fail_location", "SubBind");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$3.a.app.getCurrentAccountUin(), "actSBDLoginGetkey", true, 0L, 0L, paramString1, "");
      paramString1 = (SubAccountProtocManager)this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$3.a.app.getManager(QQManagerFactory.MGR_SUB_ACNT);
      if (paramString1 != null) {
        paramString1.a(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount.getUin(), paramString3, this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountBindActivity$3.a.b);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onGetKeyBack:getA2 subAccount = " + paramString2 + ".....subA2 = " + paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBindActivity.3.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.qwallet;

import agya;
import agyd;
import ahiw;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import axqy;
import bbdj;
import bbgu;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class TopayManager$5$1
  implements Runnable
{
  TopayManager$5$1(TopayManager.5 param5, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    SelectMemberActivity localSelectMemberActivity = (SelectMemberActivity)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localSelectMemberActivity == null) || (localSelectMemberActivity.isFinishing())) {
      return;
    }
    agya.a(localSelectMemberActivity, false);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.this$0.jdField_a_of_type_AndroidOsResultReceiver.send(1, null);
      axqy.b(ahiw.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.aio.send", 0, 0, "", "", "", "");
      int i = localSelectMemberActivity.getIntent().getIntExtra("iPayFrom", -1);
      if (QLog.isColorLevel()) {
        QLog.e("TopayManager", 2, "iPayFrom : " + i);
      }
      if (i == 1)
      {
        agya.a(localSelectMemberActivity, this.this$0.jdField_a_of_type_JavaUtilArrayList, this.this$0.b);
        return;
      }
      agya.b(localSelectMemberActivity, this.this$0.jdField_a_of_type_JavaUtilArrayList, this.this$0.b);
      return;
    }
    if (this.jdField_a_of_type_AndroidOsBundle != null) {}
    for (String str = this.jdField_a_of_type_AndroidOsBundle.getString("retmsg");; str = null)
    {
      if (TextUtils.isEmpty(str)) {
        str = localSelectMemberActivity.getResources().getString(2131694906);
      }
      for (;;)
      {
        bbdj.a(localSelectMemberActivity, 231, null, str, localSelectMemberActivity.getResources().getString(2131694794), null, null, new agyd(this)).show();
        axqy.b(ahiw.a(), "P_CliOper", "Vip_pay_mywallet", "", "wallet", "friendpay.selectpage.errwinshow", 0, 0, "", "", "", "");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.TopayManager.5.1
 * JD-Core Version:    0.7.0.1
 */
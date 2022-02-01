package com.tencent.mobileqq.app.parser;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ScreenShareAskAction$1
  implements Runnable
{
  ScreenShareAskAction$1(ScreenShareAskAction paramScreenShareAskAction) {}
  
  public void run()
  {
    FragmentActivity localFragmentActivity = (FragmentActivity)this.this$0.jdField_a_of_type_AndroidContentContext;
    String str1 = (String)this.this$0.jdField_a_of_type_JavaUtilHashMap.get("requestUin");
    String str2 = (String)this.this$0.jdField_a_of_type_JavaUtilHashMap.get("expireDate");
    long l1;
    if (str2 != null)
    {
      l1 = Long.parseLong(str2);
      long l2 = System.currentTimeMillis() / 1000L;
      if (QLog.isDevelopLevel()) {
        QLog.i("ScreenShareAskAction", 1, "doAction requestUin: " + str1 + "curuin: " + this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + " expireDate: " + l1 + "nowDate: " + l2);
      }
      if (l2 <= l1) {
        break label187;
      }
      QQToast.a(this.this$0.jdField_a_of_type_AndroidContentContext, 1, 2131718842, 1).a();
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", str1, "0X800B8A4", "0X800B8A4", 0, 0, str1, "", "", "");
      return;
      l1 = 0L;
      break;
      label187:
      if (str1.equals(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
      {
        str2 = localFragmentActivity.getString(2131718847);
        String str3 = localFragmentActivity.getString(2131718846);
        DialogUtil.a(localFragmentActivity, 230, null, str2, str3, str3, new ScreenShareAskAction.1.1(this), null).show();
      }
      else
      {
        this.this$0.a(localFragmentActivity, str1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.ScreenShareAskAction.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.rebuild;

import ainh;
import aipc;
import android.os.Handler;
import android.text.TextUtils;
import aody;
import bdll;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import obj;
import ocd;

public class PublicAccountChatPie$9
  implements Runnable
{
  public PublicAccountChatPie$9(ainh paramainh) {}
  
  public void run()
  {
    Object localObject = null;
    aody localaody = (aody)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localaody != null) {
      localObject = localaody.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    boolean bool;
    if (localObject == null)
    {
      bool = this.this$0.F();
      this.this$0.E();
      if ((bool) && (TextUtils.isEmpty(this.this$0.g)) && (localaody != null))
      {
        localObject = localaody.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        if ((localObject != null) && (!TextUtils.isEmpty(((AccountDetail)localObject).summary))) {
          this.this$0.g = ((AccountDetail)localObject).summary;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (ainh.a(this.this$0)))
      {
        ocd.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EFB", "0X8004EFB", 0, 0, "", "", "", "", false);
        this.this$0.T = true;
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
      for (;;)
      {
        localObject = "0";
        if (bool) {
          localObject = "1";
        }
        long l = NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
          QLog.d("struct_log_tag", 2, "PublicAccountChatPie :CliOper|" + this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a + "|0X8005619|0X8005619" + 0 + "|" + 0 + "|" + Long.toString(l) + "|" + (String)localObject);
        }
        bdll.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8005619", "0X8005619", 0, 0, Long.toString(l), (String)localObject, "", "");
        return;
        if (!ainh.b(this.this$0)) {
          this.this$0.jdField_a_of_type_Obj.a(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, new aipc(this));
        }
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.9
 * JD-Core Version:    0.7.0.1
 */
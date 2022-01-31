package com.tencent.mobileqq.activity.aio.rebuild;

import aert;
import aetk;
import akdh;
import android.os.Handler;
import android.text.TextUtils;
import axqy;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import nnu;
import nol;

public class PublicAccountChatPie$7
  implements Runnable
{
  public PublicAccountChatPie$7(aert paramaert) {}
  
  public void run()
  {
    Object localObject = null;
    akdh localakdh = (akdh)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localakdh != null) {
      localObject = localakdh.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    boolean bool;
    if (localObject == null)
    {
      bool = this.this$0.E();
      this.this$0.D();
      if ((bool) && (TextUtils.isEmpty(this.this$0.g)) && (localakdh != null))
      {
        localObject = localakdh.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        if ((localObject != null) && (!TextUtils.isEmpty(((AccountDetail)localObject).summary))) {
          this.this$0.g = ((AccountDetail)localObject).summary;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (aert.c(this.this$0)))
      {
        nol.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EFB", "0X8004EFB", 0, 0, "", "", "", "", false);
        this.this$0.U = true;
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
        axqy.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8005619", "0X8005619", 0, 0, Long.toString(l), (String)localObject, "", "");
        return;
        if (!aert.d(this.this$0)) {
          this.this$0.jdField_a_of_type_Nnu.a(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, new aetk(this));
        }
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.7
 * JD-Core Version:    0.7.0.1
 */
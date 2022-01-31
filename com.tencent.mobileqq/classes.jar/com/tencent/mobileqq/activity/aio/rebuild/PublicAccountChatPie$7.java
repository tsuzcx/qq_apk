package com.tencent.mobileqq.activity.aio.rebuild;

import aegy;
import aeip;
import ajoy;
import android.os.Handler;
import android.text.TextUtils;
import awqx;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import ncw;
import ndn;

public class PublicAccountChatPie$7
  implements Runnable
{
  public PublicAccountChatPie$7(aegy paramaegy) {}
  
  public void run()
  {
    Object localObject = null;
    ajoy localajoy = (ajoy)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
    if (localajoy != null) {
      localObject = localajoy.b(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    boolean bool;
    if (localObject == null)
    {
      bool = this.this$0.E();
      this.this$0.D();
      if ((bool) && (TextUtils.isEmpty(this.this$0.g)) && (localajoy != null))
      {
        localObject = localajoy.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
        if ((localObject != null) && (!TextUtils.isEmpty(((AccountDetail)localObject).summary))) {
          this.this$0.g = ((AccountDetail)localObject).summary;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (aegy.b(this.this$0)))
      {
        ndn.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004EFB", "0X8004EFB", 0, 0, "", "", "", "", false);
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
        awqx.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8005619", "0X8005619", 0, 0, Long.toString(l), (String)localObject, "", "");
        return;
        if (!aegy.c(this.this$0)) {
          this.this$0.jdField_a_of_type_Ncw.a(this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, new aeip(this));
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
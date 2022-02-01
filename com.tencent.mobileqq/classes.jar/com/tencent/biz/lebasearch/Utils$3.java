package com.tencent.biz.lebasearch;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;

final class Utils$3
  implements DialogInterface.OnClickListener
{
  Utils$3(int paramInt, ILebaHelperService paramILebaHelperService, QQAppInterface paramQQAppInterface, long paramLong, Handler paramHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqLebaILebaHelperService;
      if (paramDialogInterface != null) {
        paramDialogInterface.updateAppSetting(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, true, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      paramDialogInterface = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ILebaHelperService.class, "multi");
      l = NetConnInfoCenter.getServerTimeMillis();
      paramDialogInterface.netSetPluginState(String.valueOf(this.jdField_a_of_type_Long), true, l);
      return;
    }
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqLebaILebaHelperService;
    if (paramDialogInterface != null) {
      paramDialogInterface.updateAppSetting(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, false, NetConnInfoCenter.getServerTimeMillis(), -9223372036854775808L);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    paramDialogInterface = (ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ILebaHelperService.class, "multi");
    long l = NetConnInfoCenter.getServerTimeMillis();
    paramDialogInterface.netSetPluginState(String.valueOf(this.jdField_a_of_type_Long), false, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.lebasearch.Utils.3
 * JD-Core Version:    0.7.0.1
 */
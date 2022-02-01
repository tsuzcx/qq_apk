package com.tencent.biz.eqq;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetEqqAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class CrmUtils$2
  implements BusinessObserver
{
  CrmUtils$2(Context paramContext, QQAppInterface paramQQAppInterface, QQProgressDialog paramQQProgressDialog, SessionInfo paramSessionInfo, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("success:");
      ((StringBuilder)localObject).append(String.valueOf(paramBoolean));
      QLog.d("CrmUtils", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null) {
        localObject = new mobileqq_mp.GetEqqAccountDetailInfoResponse();
      }
    }
    try
    {
      ((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).mergeFrom(paramBundle);
      if (((mobileqq_mp.RetInfo)((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject).ret_info.get()).ret_code.get() == 0)
      {
        paramBundle = new EqqDetail((mobileqq_mp.GetEqqAccountDetailInfoResponse)localObject);
        CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBundle);
        CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
        if (QLog.isDevelopLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("<<<end getDetail, ts=");
          ((StringBuilder)localObject).append(System.currentTimeMillis());
          QLog.d("IVR_TS_CrmUtils", 4, ((StringBuilder)localObject).toString());
        }
        CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null, paramBundle, this.jdField_a_of_type_JavaLangString);
      }
      else
      {
        CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131695217);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
      }
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      label226:
      break label226;
    }
    CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131695217);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
    CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
    return;
    CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131695217);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
    break label345;
    CrmUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131695217);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80049DF", "GetDetailFalse", 0, 0, "", "", "", "");
    label345:
    CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmUtils.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.identification.AppConf;
import com.tencent.mobileqq.identification.FaceConf;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

class QQIdentiferLegacy$7
  implements EIPCResultCallback
{
  QQIdentiferLegacy$7(QQIdentiferLegacy paramQQIdentiferLegacy, boolean paramBoolean, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("callServer ACTION_APP_CONF error_code:");
    localStringBuilder.append(paramEIPCResult.code);
    QLog.d("QQIdentiferLegacy", 1, localStringBuilder.toString());
    int i = paramEIPCResult.code;
    if (i != -102)
    {
      if (i != 0)
      {
        if (i != 15)
        {
          QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).set(false);
        }
        else
        {
          QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).set(false);
          QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy, true);
        }
      }
      else
      {
        QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).set(false);
        if (paramEIPCResult.data != null)
        {
          paramEIPCResult = (AppConf)paramEIPCResult.data.getSerializable("FaceRecognition.AppConf");
          QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).setAppConf(paramEIPCResult);
          QQIdentiferLegacy.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy);
        }
        QLog.d("QQIdentiferLegacy", 1, new Object[] { "callServer ACTION_APP_CONF success conf :", QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).getAppConf() });
      }
    }
    else {
      QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).set(false);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      QQIdentiferLegacy.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy);
    }
    else if ("identify".equals(this.jdField_a_of_type_JavaLangString))
    {
      QQIdentiferUtil.a(QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).getAppConf(), "0X800B2BE");
      this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy.a.removeCallbacks(QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy));
    }
    QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy.7
 * JD-Core Version:    0.7.0.1
 */
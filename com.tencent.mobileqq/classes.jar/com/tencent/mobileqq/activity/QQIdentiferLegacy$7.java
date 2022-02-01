package com.tencent.mobileqq.activity;

import android.os.Bundle;
import com.tencent.mobileqq.jsp.FaceDetectForThirdPartyManager.AppConf;
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
    QLog.d("QQIdentiferLegacy", 1, "callServer ACTION_APP_CONF error_code:" + paramEIPCResult.code);
    switch (paramEIPCResult.code)
    {
    default: 
      QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).set(false);
      if (this.jdField_a_of_type_Boolean) {
        QQIdentiferLegacy.c(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy);
      }
      break;
    }
    for (;;)
    {
      QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy, true);
      return;
      QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).set(false);
      break;
      QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).set(false);
      if (paramEIPCResult.data != null)
      {
        QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy, (FaceDetectForThirdPartyManager.AppConf)paramEIPCResult.data.getSerializable("FaceRecognition.AppConf"));
        QQIdentiferLegacy.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy);
      }
      QLog.d("QQIdentiferLegacy", 1, "callServer ACTION_APP_CONF success conf :" + QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy));
      break;
      QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy).set(false);
      QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy, true);
      break;
      if ("identify".equals(this.jdField_a_of_type_JavaLangString))
      {
        QQIdentiferUtil.a(QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy), "0X800B2BE");
        this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy.a.removeCallbacks(QQIdentiferLegacy.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQIdentiferLegacy));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferLegacy.7
 * JD-Core Version:    0.7.0.1
 */
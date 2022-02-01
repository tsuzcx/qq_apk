package com.tencent.mobileqq.activity.aio.audiopanel;

import asbm;
import asbv;
import asck;
import bdla;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.qphone.base.util.QLog;
import llq;
import muy;

final class PressToChangeVoicePanel$2
  implements Runnable
{
  PressToChangeVoicePanel$2(boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (PressToChangeVoicePanel.jdField_a_of_type_JavaLangString == null) {
        PressToChangeVoicePanel.jdField_a_of_type_JavaLangString = muy.a(BaseApplicationImpl.sApplication);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "checkVcSo async:" + PressToChangeVoicePanel.jdField_a_of_type_JavaLangString);
      }
    }
    if ((PressToChangeVoicePanel.jdField_a_of_type_JavaLangString != null) || (llq.f() <= 2)) {}
    for (;;)
    {
      try
      {
        asbv localasbv = ((asbm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a(asck.e());
        if (localasbv == null) {
          continue;
        }
        localasbv.a(false);
      }
      catch (Exception localException)
      {
        QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo Exception:" + localException.getMessage());
        continue;
      }
      bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, "", "", "", "");
      return;
      QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo null == earlyHandler:");
      continue;
      AVSoUtils.b(BaseApplicationImpl.sApplication, "traeimp-armeabi-v7a", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel.2
 * JD-Core Version:    0.7.0.1
 */
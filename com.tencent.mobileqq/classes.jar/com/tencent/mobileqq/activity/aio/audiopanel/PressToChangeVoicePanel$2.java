package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

final class PressToChangeVoicePanel$2
  implements Runnable
{
  PressToChangeVoicePanel$2(boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (PressToChangeVoicePanel.jdField_a_of_type_JavaLangString == null) {
        PressToChangeVoicePanel.jdField_a_of_type_JavaLangString = TraeHelper.a(BaseApplicationImpl.sApplication);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "checkVcSo async:" + PressToChangeVoicePanel.jdField_a_of_type_JavaLangString);
      }
    }
    if ((PressToChangeVoicePanel.jdField_a_of_type_JavaLangString != null) || (VcSystemInfo.getCpuArchitecture() <= 2)) {}
    for (;;)
    {
      try
      {
        EarlyHandler localEarlyHandler = ((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a(QavSoDownloadHandler.e());
        if (localEarlyHandler == null) {
          continue;
        }
        localEarlyHandler.a(false);
      }
      catch (Exception localException)
      {
        QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo Exception:" + localException.getMessage());
        continue;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 0, 0, "", "", "", "");
      return;
      QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo null == earlyHandler:");
      continue;
      AVSoUtils.b(BaseApplicationImpl.sApplication, "traeimp-armeabi-v7a", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel.2
 * JD-Core Version:    0.7.0.1
 */
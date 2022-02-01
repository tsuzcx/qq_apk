package com.tencent.mobileqq.activity.aio.audiopanel;

import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.TraeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.QavSoDownloadHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

final class PressToChangeVoicePanel$2
  implements Runnable
{
  PressToChangeVoicePanel$2(boolean paramBoolean, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    Object localObject1;
    if (!this.a)
    {
      if (PressToChangeVoicePanel.p == null) {
        PressToChangeVoicePanel.p = TraeHelper.b(BaseApplicationImpl.sApplication);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("checkVcSo async:");
        ((StringBuilder)localObject1).append(PressToChangeVoicePanel.p);
        QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject1).toString());
      }
    }
    if (PressToChangeVoicePanel.p == null)
    {
      if (VcSystemInfo.getCpuArchitecture() <= 2) {
        try
        {
          localObject1 = ((IEarlyDownloadService)this.b.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler(QavSoDownloadHandler.w());
          if (localObject1 != null) {
            ((EarlyHandler)localObject1).a(false);
          } else {
            QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo null == earlyHandler:");
          }
        }
        catch (Exception localException)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("voiceChang checkVcSo Exception:");
          ((StringBuilder)localObject2).append(localException.getMessage());
          QLog.e("AIOAudioPanel", 1, ((StringBuilder)localObject2).toString());
        }
      } else {
        AVSoUtils.b(BaseApplicationImpl.sApplication, "traeimp-armeabi-v7a", true);
      }
      QQAppInterface localQQAppInterface = this.b;
      Object localObject2 = this.c;
      ReportController.b(localQQAppInterface, "dc00898", "", "", (String)localObject2, (String)localObject2, 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio;

import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$VoiceResStrategy$1
  implements Runnable
{
  CustomizeStrategyFactory$VoiceResStrategy$1(CustomizeStrategyFactory.VoiceResStrategy paramVoiceResStrategy, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "VoiceResStrategy");
      }
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService == null) || (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager == null))
      {
        CustomizeStrategyFactory.a().a(this.a);
        return;
      }
      String str = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletConfigQWalletConfigManager.a("voice_pwd", "https://imgcache.qq.com/channel/static/socialpay/voice/", new String[] { "urlPrefix" });
      str = str + "voice_rate_" + this.a.templateId + ".zip";
      this.this$0.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService.getUnzipFolderPath(str, new CustomizeStrategyFactory.VoiceResStrategy.1.1(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.VoiceResStrategy.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio;

import aerp;
import aerq;
import aixs;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.qphone.base.util.QLog;

public class CustomizeStrategyFactory$VoiceResStrategy$1
  implements Runnable
{
  public CustomizeStrategyFactory$VoiceResStrategy$1(aerp paramaerp, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "VoiceResStrategy");
      }
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager == null) || (this.this$0.jdField_a_of_type_Aixs == null))
      {
        CustomizeStrategyFactory.a().a(this.a);
        return;
      }
      String str = this.this$0.jdField_a_of_type_Aixs.a("voice_pwd", "http://imgcache.qq.com/channel/static/socialpay/voice/", new String[] { "urlPrefix" });
      str = str + "voice_rate_" + this.a.templateId + ".zip";
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager.a(str, new aerq(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.VoiceResStrategy.1
 * JD-Core Version:    0.7.0.1
 */
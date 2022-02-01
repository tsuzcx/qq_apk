package com.tencent.av.redpacket.config;

import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.av.service.IAVRedPacketCallback;
import com.tencent.mobileqq.armap.ResDownloadManager;
import com.tencent.qphone.base.util.QLog;

class AVRedPacketConfigManager$1
  implements Runnable
{
  AVRedPacketConfigManager$1(AVRedPacketConfigManager paramAVRedPacketConfigManager, IAVRedPacketCallback paramIAVRedPacketCallback) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("downloadRes, threadName[").append(Thread.currentThread().getName()).append("], threadId[").append(Thread.currentThread().getId()).append("], resDownloadManager[");
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("AVRedPacketConfigManger", 1, bool + "]");
      this.this$0.b = this.a;
      this.this$0.c = false;
      this.this$0.d = false;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(this.this$0.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resURL, this.this$0.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resMD5, ".zip", true, 4, Integer.valueOf(1));
        this.this$0.jdField_a_of_type_ComTencentMobileqqArmapResDownloadManager.a(this.this$0.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResUrl, this.this$0.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResMd5, ".zip", true, 4, Integer.valueOf(2));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.config.AVRedPacketConfigManager.1
 * JD-Core Version:    0.7.0.1
 */
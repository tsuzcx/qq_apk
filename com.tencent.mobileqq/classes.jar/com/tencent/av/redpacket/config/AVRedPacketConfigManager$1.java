package com.tencent.av.redpacket.config;

import aqgr;
import com.tencent.av.service.AVRedPacketConfig;
import com.tencent.qphone.base.util.QLog;
import lun;
import lwo;

public class AVRedPacketConfigManager$1
  implements Runnable
{
  public AVRedPacketConfigManager$1(lun paramlun, lwo paramlwo) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("downloadRes, threadName[").append(Thread.currentThread().getName()).append("], threadId[").append(Thread.currentThread().getId()).append("], resDownloadManager[");
    if (this.this$0.jdField_a_of_type_Aqgr != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.w("AVRedPacketConfigManger", 1, bool + "]");
      this.this$0.jdField_b_of_type_Lwo = this.a;
      this.this$0.jdField_b_of_type_Boolean = false;
      this.this$0.c = false;
      if (this.this$0.jdField_a_of_type_Aqgr != null)
      {
        this.this$0.jdField_a_of_type_Aqgr.a(this.this$0.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resURL, this.this$0.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.resMD5, ".zip", true, 4, Integer.valueOf(1));
        this.this$0.jdField_a_of_type_Aqgr.a(this.this$0.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResUrl, this.this$0.jdField_a_of_type_ComTencentAvServiceAVRedPacketConfig.musicResMd5, ".zip", true, 4, Integer.valueOf(2));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.config.AVRedPacketConfigManager.1
 * JD-Core Version:    0.7.0.1
 */